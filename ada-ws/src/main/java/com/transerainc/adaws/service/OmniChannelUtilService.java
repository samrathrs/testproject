package com.transerainc.adaws.service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import com.google.gson.Gson;
import com.transerainc.adaws.constants.OmniChannelChatCommandConstants;
import com.transerainc.adaws.constants.OmniChannelCommonCommandConstants;
import com.transerainc.adaws.constants.OmniChannelCommonConstants;
import com.transerainc.adaws.constants.OmniChannelEmailCommandConstants;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.CacheContactState;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.json.OmniChannelJsonUtil;
import com.transerainc.adaws.json.StateCacheJson;
import com.transerainc.adaws.model.AdaRequest;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.MmRequest;
import com.transerainc.adaws.model.RequestData;
import com.transerainc.adaws.model.cache.contact.chat.ChatContact;
import com.transerainc.adaws.model.cache.contact.chat.ChatContactArrivedMessage;
import com.transerainc.adaws.model.cache.contact.chat.ChatContactConferenceCloseMessage;
import com.transerainc.adaws.model.cache.contact.chat.ChatContactConferenceMemberJoinedMessage;
import com.transerainc.adaws.model.cache.contact.chat.ChatContactMemberJoinedMessage;
import com.transerainc.adaws.model.cache.contact.chat.ChatMessage;
import com.transerainc.adaws.model.cache.contact.chat.ChatMessagePrivateAgentToAgentMessage;
import com.transerainc.adaws.model.cache.contact.chat.ChatMessagePrivateSentRequestMessage;
import com.transerainc.adaws.model.cache.contact.chat.ChatMessageToCustomerMessage;
import com.transerainc.adaws.model.cache.contact.chat.ConferenceParticipant;
import com.transerainc.adaws.model.cache.contact.chat.MessageDirection;
import com.transerainc.adaws.model.cache.contact.email.EmailContact;
import com.transerainc.adaws.model.cache.contact.email.EmailContactArrivedMessage;
import com.transerainc.adaws.model.cache.contact.email.NameEmailPair;
import com.transerainc.adaws.model.cache.contact.followup.FollowUpContact;
import com.transerainc.adaws.model.cache.contact.followup.FollowUpContactArrivedMessage;
import com.transerainc.adaws.model.cache.contact.followup.FollowUpContactFetchedMessage;
import com.transerainc.adaws.model.cache.loggedinagent.AgentLoggedInMessage;
import com.transerainc.adaws.model.cache.profile.AgentLoginResponseBody;
import com.transerainc.adaws.model.cache.profile.MmProfile;

/**
 * @author tringuyen
 *
 */
@Service
public class OmniChannelUtilService  extends CacheService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OmniChannelUtilService.class.getName());
	private static final Gson GSON = new Gson();

	public String getMimUrl(final String agentSessionId) {
		
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
		final String omniUrl = desktopConfig.getOmniChannelUrl();

		return omniUrl;		
	}
	
	public String getMimUrl(final String agentSessionId, final String jsMethodCommandConstant) {
		
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
		String omniUrl = null;
		
		if ((jsMethodCommandConstant != null) && 
				(jsMethodCommandConstant.equals(OmniChannelEmailCommandConstants.EMAIL_ATTACHMENT_REMOVED) ||
				 jsMethodCommandConstant.equals(OmniChannelEmailCommandConstants.ADD_EMAIL_ATTACHMENT))) {
			omniUrl = desktopConfig.getOmniChannelFileServerUrl();
		} else {
			omniUrl = desktopConfig.getOmniChannelUrl();
		}
		
		return omniUrl;		
	}
	
	public void processAndTransmitAdaRequestToIcx(
			final AdaRequest adaRequest, 
			final String jsMethodCommandConstant,
			final String adaCallbackUrl,
			final String omniChannelUrl
			) {
		
			String sessionId = adaRequest.getagentSessionId();
			DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(sessionId);
			Long agentId = Long.valueOf(desktopConfig.getAgentId());
			Long tenantId = Long.valueOf(desktopConfig.getEnterpriseId());
			MmRequest mmRequest = adaRequest.getMmRequest();
			String action = mmRequest.getAction();
			
			try {
				if (mmRequest.getRequestData() == null) {
					mmRequest.setRequestData(new RequestData());
				}
				mmRequest.getRequestData().setSessionId(sessionId);
				mmRequest.getRequestData().setTenantId(tenantId);
				mmRequest.getRequestData().setAgentId(agentId);
				mmRequest.getRequestData().setPersistentCallbackUrl(adaCallbackUrl);
				mmRequest.setCallbackUrl(adaCallbackUrl);
				
			} catch (Exception exception) {
				LOGGER.error("ERROR in processing Ada Request to ICX : {}, and mmRequest: {}, with exception: {}",
						adaRequest, mmRequest.debugToString(), exception);
				
				reportError(jsMethodCommandConstant, sessionId, agentId, action);
			}
			
			String requestToIcx = GSON.toJson(mmRequest);		
			
			// Send message to ICX
			LOGGER.debug("Sending to ICX with Ada Callback URL: {}, JSON request: {} for action: {}", 
						adaCallbackUrl,
						requestToIcx,
						action);

			String response = null;
			try {
				// Send request to ICX (OmniChannel server)
				response = com.transerainc.adaws.connection.HttpUtil.doHttpJsonPost(omniChannelUrl, requestToIcx);
		    		LOGGER.info("Response from {}: {}", omniChannelUrl, response);
		    		
		    		if (response != null) {
		    			// 2nd Method to capture and cache Agent State should use both Request and Response
		    			updateAgentStateCacheOnSynchronousInvocations(requestToIcx, response, jsMethodCommandConstant, sessionId);
					
		    			// Send success response to FE
		    			transmitDataToFrontend(response, jsMethodCommandConstant);
		    		} else {
					LOGGER.error("Error transmitting to ICX with response=NULL, omniChannelUrl: {}, requestToIcx: {}", 
								omniChannelUrl, requestToIcx);
					
					reportError(jsMethodCommandConstant, sessionId, agentId, action);
		    		}
				
	        } catch (final HttpServerErrorException hse) {
	        		reportError(hse, sessionId);
	        		
	        } catch (final ResourceAccessException rae) {
	        		reportError(rae, sessionId);
	        	
	        } catch (final HttpClientErrorException hce) {
                reportError(hce, sessionId);
	        		
	        } catch (final Exception e) {
	        
				LOGGER.error("Error transmitting to ICX with exception: {}, omniChannelUrl: {}, requestToIcx: {}", 
							e, omniChannelUrl, requestToIcx);
				
				reportError(jsMethodCommandConstant, sessionId, agentId, action);
			}
	}
	
	public String processAndPostAdaRequestToIcx(
			final AdaRequest adaRequest, 
			final String jsMethodCommandConstant,
			final String adaCallbackUrl,
			final String omniChannelUrl,
			HttpServletResponse res
			) {
		
			String response = null;
			String sessionId = adaRequest.getagentSessionId();
			DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(sessionId);
			Long agentId = Long.valueOf(desktopConfig.getAgentId());
			Long tenantId = Long.valueOf(desktopConfig.getEnterpriseId());

			MmRequest mmRequest = adaRequest.getMmRequest();
			String action = mmRequest.getAction();
			
			try {			
				if (mmRequest.getRequestData() == null) {
					mmRequest.setRequestData(new RequestData());
				}
				mmRequest.getRequestData().setSessionId(sessionId);
				mmRequest.getRequestData().setTenantId(tenantId);
				mmRequest.getRequestData().setAgentId(agentId);
				mmRequest.getRequestData().setPersistentCallbackUrl(adaCallbackUrl);
				mmRequest.setCallbackUrl(adaCallbackUrl);
							
				String requestToIcx = GSON.toJson(mmRequest);

				// Send message to ICX
				LOGGER.debug("Sending to ICX with Ada Callback URL: {}, JSON request: {} for action: {}", 
						adaCallbackUrl,
						requestToIcx,
						action);

				// Send request to ICX (OmniChannel server)
				response = com.transerainc.adaws.connection.HttpUtil.doHttpJsonPost(omniChannelUrl, requestToIcx, res);

				if (response != null) {
					// 2nd Method to capture and cache Agent State should use both Request and Response
					updateAgentStateCacheOnSynchronousInvocations(requestToIcx, response, jsMethodCommandConstant, sessionId);
				} else {
					LOGGER.error("Error transmitting to ICX with response=NULL, omniChannelUrl: {}, requestToIcx: {}", 
							omniChannelUrl, requestToIcx);
				
					reportError(jsMethodCommandConstant, sessionId, agentId, action);
	    			}	
				
			} catch (final HttpServerErrorException hse) {
        			reportError(hse, sessionId);
        		
			} catch (final ResourceAccessException rae) {
        			reportError(rae, sessionId);
        	
			} catch (final HttpClientErrorException hce) {
				reportError(hce, sessionId);
        		
			} catch (Exception exception) {
				LOGGER.error("ERROR in processing and transmitting Ada Request: {}, with mmRequest: {}, to ICX with exception: {}",
						adaRequest,
						mmRequest.debugToString(),
						exception);
				
				reportError(jsMethodCommandConstant, sessionId, agentId, action);
			}
					
			return response;
	}


	public boolean hasOmniRedirectApi(String redirectApi) {
		if ((org.apache.commons.lang3.StringUtils.isNotBlank(redirectApi)) && 
			(redirectApi.length() > OmniChannelCommonCommandConstants.PREFIX.length())) {
			String prefix = redirectApi.substring(0, 
					OmniChannelCommonCommandConstants.PREFIX.length());
			return OmniChannelCommonCommandConstants.PREFIX.equals(prefix);
		}
		return false;
	}

	public void handleRequest(
		final HttpServletRequest request, 
			final HttpServletResponse response,
			final String payloadData,
			final String jsMethod,
			final String mappedRequest
	) {
		buildSuccessfulHttpResponse(response);
		StringBuilder wrappedMessageStrBldr = wrapResponseMessage(payloadData);

			final String backendSessionId = OmniChannelJsonUtil.extractSessionId(payloadData);
	
			LOGGER.debug(
					"Handling Request: {}," + 
					"payload data: {}, "  +
					"Backend Session Id: {}, " +
					"jsMethod: {}",
					mappedRequest,
					payloadData,
					backendSessionId,
					jsMethod
					);

		final String responsePayloadToFe = wrappedMessageStrBldr.toString();

		transmitDataToFrontend(
					responsePayloadToFe, 
					jsMethod, 
					backendSessionId
					);
	}

	public void transmitDataToFrontend(
			final String payloadData,
			final String jsMethod
		) {
		StringBuilder wrappedMessageStrBldr = wrapResponseMessage(payloadData);
	
		final String backendSessionId = OmniChannelJsonUtil.extractSessionId(payloadData);
	
		transmitDataToFrontend(
					wrappedMessageStrBldr.toString(), 
					jsMethod, 
					backendSessionId
					);
	}
	
	public void transmitDataToFrontend(
			final String data,
			final String jsMethod,
			final String backendSessionId
		) {
		Map<String, String> agentTokenMap = webSocketCacheManager.getAgentTokenMap();
		String frontendWebTokenId = agentTokenMap.get(backendSessionId);
		if (org.apache.commons.lang3.StringUtils.isNotBlank(frontendWebTokenId)) {
			AdaResponse adaResponse = new AdaResponse(jsMethod, data, frontendWebTokenId);
			dataPublisher.publishData(adaResponse);
			LOGGER.debug("Transmitted Data to Frontend " +
					"jsMethod: {}, " + 
					"frontendAgentSessionId: {}," +
					"adaResponse: {} ",
					jsMethod,
					frontendWebTokenId,
					adaResponse
					);
			updateAgentStateCacheOnAsynchronousCallBack(data, jsMethod, backendSessionId);
		} else {
			LOGGER.error("No Frontend Web Token found for Backend Session Id: {}", backendSessionId);
		}
	}

	public static StringBuilder wrapResponseMessage(String responseMessage) {
		StringBuilder msgStrBldr = new StringBuilder(OmniChannelCommonConstants.MM_RESPONSE_WRAPPER_PREFIX);
		msgStrBldr.append(responseMessage);
		msgStrBldr.append(OmniChannelCommonConstants.MM_RESPONSE_WRAPPER_POSTFIX);
		return msgStrBldr;
	}

	public void buildSuccessfulHttpResponse(final HttpServletResponse response) {
		response.setStatus(HttpStatus.OK.value());
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
	}

	/*
	 * 
	 * Browser Reload capture tapping for cache at asynchronous callback from ICX/OmniChannel to FE
	 * 
	 */
	private void updateAgentStateCacheOnAsynchronousCallBack(
			final String payloadData,
			final String jsMethod,
			final String backendSessionId
	) {
		LOGGER.debug(
				"Determining if Agent State should be cached for Browser Reload with jsMethod: {}, " +
						"backendSessionId: {}, and payloadData: {}",
						jsMethod,
						backendSessionId,
						payloadData
				);

		try {
			// TODO: 
			// OOM
			// Check if success is true before entering this big if-else-if statement block
			if (OmniChannelJsonUtil.extractSuccessFlagFromMmResponse(payloadData)) {
				if (isAgentLoggedInMessage(jsMethod)) {
					addAgentLoggedInToCache(backendSessionId, payloadData);
				} else if (isAgentLoggedOutMessage(jsMethod)) {
					removeAgentLoggedInFromCache(backendSessionId, payloadData);
				} else if (isChatContactArrivalMessage(jsMethod)) {
					addChatContactToCache(backendSessionId, payloadData);
				} else if (isChatContactMemberJoinedMessage(jsMethod)) {
					setCustomerIdOfChatContactInCache(backendSessionId, payloadData);
				} /*else if (isChatContactTerminated(jsMethod)) { //Removed for FIJI-1927
					removeChatContactFromCache(backendSessionId, payloadData);
				}*/ else if (isChatMessage(jsMethod)) {
					addChatMessageToCache(backendSessionId, payloadData);
				} else if (isOmnichannelProfileMessage(jsMethod)) {
					addOmnichannelProfileToCache(backendSessionId, payloadData);
				} else if (isChatContactStateChanged(jsMethod)) {
					updateChatContactStateInCache(backendSessionId, payloadData, jsMethod);
				} else if (isEmailContactArrived(jsMethod)) {
					addEmailContactToCache(backendSessionId, payloadData);
				} else if (isFollowUpContactArrived(jsMethod, payloadData)) {
					addFollowUpContactToCache(backendSessionId, payloadData);
				} else if (isChatConferenceArrivalMessage(jsMethod)) {
					addChatConferenceParticipantToCache(backendSessionId, payloadData);
				} else if (isChatContactClosed(jsMethod)) {
					removeChatConferenceParticipantFromCache(backendSessionId, payloadData);
				} else if (isChatConferenceDepartureMessage(jsMethod)) {
					removeChatConferenceParticipantFromCache(backendSessionId, payloadData);
				} else if (isPrivateChatMessage(jsMethod)) {
					addPrivateMessageToCache(backendSessionId, payloadData);
				} else if (
						(isContactCompleted(jsMethod, payloadData))		|| 
						(isContactTransferred(jsMethod, payloadData))	|| 
						(isInRONA(jsMethod, payloadData))) {
					removeContactFromCache(backendSessionId, payloadData);
				}
			}
		} catch (Exception exception) {
			LOGGER.warn(
					"Error encountered while determining if Agent State should be cached for Browser Reload with jsMethod: {}, " +
							"backendSessionId: {}, payloadData: {}, and exception: {}",
							jsMethod,
							backendSessionId,
							payloadData, 
							exception
					);
		}
	}

	/*
	 * 
	 * Browser Reload capture tapping for cache at synchronous call from FE to ICX/OmniChannel
	 * 
	 */
	private void updateAgentStateCacheOnSynchronousInvocations(
			final String request, 
			final String response, 
			final String jsMethod, 
			final String backendSessionId
	) {
		LOGGER.debug(
				"Determining if Agent State should be cached for Browser Reload with jsMethod: {}, " +
						"backendSessionId: {} and using both request: {}, and response: {}",
						jsMethod,
						backendSessionId,
						request,
						response
				);

		try {
			if (isAcceptingEmailContact(jsMethod, response)) {
				updateEmailContactStateToAccepted(backendSessionId, response);
			} else if (isSendingEmail(jsMethod, response)) {
				updateEmailContactStateToClosed(backendSessionId, request);
				LOGGER.info("updateOutboundID: {}",
						response);
				updateOutboundID(backendSessionId, response);
				if ((doesCduIdInvolveEmailContact(backendSessionId, response))	&& 
						(hasCustomerEmailInformation(request))) {
					updateEmailContactWithCustomerEmailInformation(backendSessionId, request, response);
				}
			} else if (isSavingEmail(jsMethod, response)) {
				copyEmailDraftToEmailContact(backendSessionId, request);
				updateEmailContactStateToClosed(backendSessionId, request);
			} else if (isAcceptingComposeEmailContact(jsMethod, response)) {
				updateEmailContactStateToAccepted(backendSessionId, response);
			} else if (isSendingComposedEmail(jsMethod, response)) {
				updateEmailContactStateToClosed(backendSessionId, request);
			} else if (isContactWrappingUp(jsMethod, response)) {
				if (doesCduIdInvolveEmailContact(backendSessionId, response)) {
					updateEmailContactStateToClosed(backendSessionId, request);
				} else if (doesCduIdInvolveChatContact(backendSessionId, response)) {
					updateChatContactStateForSynchronousInvocations(backendSessionId, response, CacheContactState.WRAP_UP.getName());
				}
			} else if (isDeletingEmailDraft(jsMethod, response)) {
				removeEmailContactFromCache(backendSessionId, response, request);
			}
//			else if (isContactClosedMessage(jsMethod, response)) {
//				if (
//						(doesCduIdInvolveEmailContact(backendSessionId, response))		&& 
//						(hasCustomerEmailInformation(request))
//				) {
//					updateEmailContactWithCustomerEmailInformation(backendSessionId, request, response);
//				}
//			} 
			else if (isFollowUpContactFetched(jsMethod, response)) {
				addFetchedFollowUpContactsIntoCache(backendSessionId, response);
			} else if (isFollowUpContactCompleted(jsMethod, response)) {
				removeFollowUpContactFromCache(backendSessionId, response);
			} else if (isPrivateChatMessageSent(jsMethod, response)) {
				addChatMessagePrivateSentRequestToCache(backendSessionId, request, response);
			}
		} catch (Exception exception) {
			LOGGER.warn(
					"Error encountered while determining if Agent State should be cached for Browser Reload with jsMethod: {}, " +
							"backendSessionId: {} and using both request: {}, and response: {}",
							jsMethod,
							backendSessionId,
							request,
							response
					);
		}
	}

	private void updateEmailContactWithCustomerEmailInformation(String backendSessionId, String request, String response) {
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if(desktopConfig == null) {
			LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking with request: {}, and response: {}",
					backendSessionId,
					request,
					response);
			return;
		}
		final String cduId = OmniChannelJsonUtil.extractCduIdFromIcxResponse(response);
		if (org.apache.commons.lang3.StringUtils.isNotBlank(cduId)) {
			final EmailContact emailContact = desktopConfig.getEmailContact(cduId);
			if (emailContact != null) {
				final Map<String, String> nameEmailMap = OmniChannelJsonUtil.extractNameEmailFromCustomerEmailInformation(request);
				if (
						(nameEmailMap != null)		&& 
						(!nameEmailMap.isEmpty())	&& 
						(nameEmailMap.size() > 0)
				) {
					for (Map.Entry<String, String> entry : nameEmailMap.entrySet()) {
						NameEmailPair nameEmailPair = new NameEmailPair(entry.getKey(), entry.getValue());
						emailContact.getContactDetails().addTo(nameEmailPair);
					}
				}
			}
			
		}
		
	}

	private boolean hasCustomerEmailInformation(String request) {
		final Map<String, String> nameEmailMap = OmniChannelJsonUtil.extractNameEmailFromCustomerEmailInformation(request);
		if (
				(nameEmailMap != null)		&& 
				(!nameEmailMap.isEmpty())	&& 
				(nameEmailMap.size() > 0)
		) {
			return true;
		}
		return false;
	}

	private void updateOutboundID(String backendSessionId, String response) {
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if(desktopConfig == null) {
			LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking with response: {}",
					backendSessionId,
					response);
			return;
		}
		final String cduId = OmniChannelJsonUtil.extractCduIdFromIcxResponse(response);
		if (org.apache.commons.lang3.StringUtils.isNotBlank(cduId)) {
			final EmailContact emailContact = desktopConfig.getEmailContact(cduId);
			if (emailContact != null) {
				emailContact.getContactDetails().setOutboundId(OmniChannelJsonUtil.extractOutBoundID(response));
			}
			
		}
	}

	private boolean doesCduIdInvolveChatContact(String backendSessionId, String response) {
		try {
			final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

			if(desktopConfig == null) {
				LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking with response: {}",
						backendSessionId,
						response);
				return false;
			}

			final String cduId = OmniChannelJsonUtil.extractCduIdFromIcxResponse(response);
			if (org.apache.commons.lang3.StringUtils.isNotBlank(cduId)) {
				final ChatContact chatContact = desktopConfig.getChatContact(cduId);
				if (chatContact != null) {
					return true;
				}
			}
		} catch (Exception exception) {
			LOGGER.warn("Could not determine doesCduIdInvolveEmailContact() with payload: {}, for backendSessionId: {}",
					response,
					backendSessionId);
		}
		return false;
	}

	private boolean isFollowUpContactArrived(final String jsMethod, final String payloadData) {
		if (!OmniChannelEmailCommandConstants.EMAIL_CONTACT_ARRIVAL_FOLLOWUP.equals(jsMethod)) {
			return false;
		}
		boolean isRequestSuccessful = OmniChannelJsonUtil.extractSuccessFlagFromMmResponse(payloadData);
		if (!isRequestSuccessful) {
			return false;
		}
		return true;
	}


	private boolean isFollowUpContactFetched(final String jsMethod, final String response) {
		if (!OmniChannelCommonCommandConstants.FOLLOW_UP_CONTACTS_ON_LOGIN_FETCHED.equals(jsMethod)) {
			return false;
		}
		boolean isRequestSuccessful = OmniChannelJsonUtil.extractSuccessFlagFromResponse(response);
		if (!isRequestSuccessful) {
			return false;
		}
		return true;
	}

	private boolean isFollowUpContactCompleted(final String jsMethod, final String payloadData) {
		if (
				(!OmniChannelCommonCommandConstants.CONTACT_RETIRE_FOLLOWED_UP.equals(jsMethod)) 
				&& 
				(!OmniChannelCommonCommandConstants.CONTACT_REMIND_LATER_FOLLOWED_UP.equals(jsMethod)) 
				&& 
				(!OmniChannelEmailCommandConstants.ACTIVATE_FOLLOW_UP_EMAIL.equals(jsMethod)) 
				&& 
				(!OmniChannelEmailCommandConstants.ACTIVATE_FOLLOW_UP_OUTBOUND.equals(jsMethod)) 
				&& 
				(!OmniChannelEmailCommandConstants.ACTIVATE_FOLLOW_UP_CHAT.equals(jsMethod)) 
		) {
			return false;
		}
		boolean isRequestSuccessful = OmniChannelJsonUtil.extractSuccessFlagFromResponse(payloadData);
		if (!isRequestSuccessful) {
			return false;
		}
		return true;
	}

	private boolean isContactWrappingUp(final String jsMethod, final String response) {
		if (!OmniChannelCommonCommandConstants.CONTACT_WRAPPED_UP.equals(jsMethod)) {
			return false;
		}
		boolean isRequestSuccessful = OmniChannelJsonUtil.extractSuccessFlagFromResponse(response);
		if (!isRequestSuccessful) {
			return false;
		}
		return true;
	}

	private boolean doesCduIdInvolveEmailContact(final String backendSessionId, final String response) {
		try {
			final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

			if(desktopConfig == null) {
				LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking with response: {}",
						backendSessionId,
						response);
				return false;
			}

			final String cduId = OmniChannelJsonUtil.extractCduIdFromIcxResponse(response);
			if (org.apache.commons.lang3.StringUtils.isNotBlank(cduId)) {
				final EmailContact emailContact = desktopConfig.getEmailContact(cduId);
				if (emailContact != null) {
					return true;
				}
			}
		} catch (Exception exception) {
			LOGGER.warn("Could not determine doesCduIdInvolveEmailContact() with payload: {}, for backendSessionId: {}",
					response,
					backendSessionId);
		}
		return false;
	}

	private boolean isContactCompleted(final String jsMethod, final String response) {
		if (!OmniChannelCommonCommandConstants.CONTACT_COMPLETED.equals(jsMethod)) {
			LOGGER.debug("Is not ContactCompleted, jsMethod: {}, response: {}",
					jsMethod,
					response);
			return false;
		}
		LOGGER.debug("Is ContactCompleted, jsMethod: {}, response: {}",
				jsMethod,
				response);
		return true;
	}

	private boolean isContactTransferred(final String jsMethod, final String response) {
		if (!OmniChannelCommonCommandConstants.CONTACT_TRANSFERRED.equals(jsMethod)) {
			LOGGER.debug("Is not ContactTransferred, jsMethod: {}, response: {}",
					jsMethod,
					response);
			return false;
		}
		LOGGER.debug("Is ContactTransferred, jsMethod: {}, response: {}",
				jsMethod,
				response);
		return true;
	}

	private boolean isInRONA(final String jsMethod, final String response) {
		if (!OmniChannelCommonCommandConstants.RONA_NOTIFICATION.equals(jsMethod)) {
			LOGGER.debug("Is not RONA, jsMethod: {}, response: {}",
					jsMethod,
					response);
			return false;
		}
		LOGGER.debug("Is RONA, jsMethod: {}, response: {}",
				jsMethod,
				response);
		return true;
	}

	private boolean isSendingComposedEmail(final String jsMethod, final String response) {
		if (!OmniChannelEmailCommandConstants.COMPOSED_EMAIL_SENT.equals(jsMethod)) {
			return false;
		}
		boolean isRequestSuccessful = OmniChannelJsonUtil.extractSuccessFlagFromResponse(response);
		if (!isRequestSuccessful) {
			return false;
		}
		return true;
	}

	private boolean isAcceptingComposeEmailContact(final String jsMethod, final String response) {
		LOGGER.debug(
				"jsMethod: {}, inside checking isAcceptingComposeEmailContact(), with response: {}", 
				jsMethod,
				response
				);
		if (!OmniChannelEmailCommandConstants.OUTBOUND_EMAIL_CONTACT_ACCEPTED.equals(jsMethod)) {
			LOGGER.debug(
					"Returning false because " + 
					"jsMethod: {}, inside checking isAcceptingComposeEmailContact(), with response: {}", 
					jsMethod,
					response
					);
			return false;
		}
		boolean isRequestSuccessful = OmniChannelJsonUtil.extractSuccessFlagFromResponse(response);
		if (!isRequestSuccessful) {
			return false;
		}
		return true;
	}

	private boolean isSavingEmail(final String jsMethod, final String response) {
		if (!OmniChannelEmailCommandConstants.EMAIL_DRAFT_SAVED.equals(jsMethod)) {
			return false;
		}
		boolean isRequestSuccessful = OmniChannelJsonUtil.extractSuccessFlagFromResponse(response);
		if (!isRequestSuccessful) {
			return false;
		}
		return true;
	}
	
	private boolean isDeletingEmailDraft(final String jsMethod, final String response) {
		if (!OmniChannelEmailCommandConstants.EMAIL_DRAFT_DELETED.equals(jsMethod)) {
			return false;
		}

		return OmniChannelJsonUtil.extractSuccessFlagFromResponse(response);
	}

	private boolean isSendingEmail(final String jsMethod, final String response) {
		if (
				(!OmniChannelEmailCommandConstants.PLAIN_TEXT_EMAIL_SENT.equals(jsMethod))	&&
				(!OmniChannelEmailCommandConstants.RICH_TEXT_EMAIL_SENT.equals(jsMethod))		&& 
				(!OmniChannelEmailCommandConstants.COMPOSED_EMAIL_SENT.equals(jsMethod)) &&
				(!OmniChannelEmailCommandConstants.FOLLOW_UP_OUTBOUND_EMAIL_SENT.equals(jsMethod)) &&
				(!OmniChannelEmailCommandConstants.FOLLOW_UP_EMAIL_SENT.equals(jsMethod)) &&
				(!OmniChannelEmailCommandConstants.SENDING_CORRECT_DISAPPROVED_EMAIL.equals(jsMethod)) &&
				(!OmniChannelEmailCommandConstants.EMAIL_DRAFT_SAVED.equals(jsMethod))
			) {
			return false;
		}
		boolean isRequestSuccessful = OmniChannelJsonUtil.extractSuccessFlagFromResponse(response);
		if (!isRequestSuccessful) {
			return false;
		}
		return true;
	}

	private boolean isAcceptingEmailContact(final String jsMethod, final String response) {
		if (
				(!OmniChannelEmailCommandConstants.ACCEPT_EMAIL_CONTACT.equals(jsMethod)) && 
				(!OmniChannelEmailCommandConstants.EMAIL_CONTACT_ACCEPTED.equals(jsMethod))
			) {
			return false;
		}
		boolean isRequestSuccessful = OmniChannelJsonUtil.extractSuccessFlagFromResponse(response);
		if (!isRequestSuccessful) {
			return false;
		}
		return true;
	}

	private boolean isEmailContactArrived(final String jsMethod) {
		LOGGER.debug("isEmailContactArrived({})", jsMethod);
		switch (jsMethod) {
			case OmniChannelEmailCommandConstants.EMAIL_CONTACT_ARRIVAL:
				LOGGER.debug("isEmailContactArrived({}), returning true", jsMethod);
				return true;
			default:
				LOGGER.debug("isEmailContactArrived({}), returning false", jsMethod);
				return false;
		}
	}

	private boolean isChatContactMemberJoinedMessage(final String jsMethod) {
		switch (jsMethod) {
			case OmniChannelChatCommandConstants.CHAT_MEMBER_JOINED:
				return true;
			default:
				return false;
		}
	}

	private boolean isChatConferenceArrivalMessage(final String jsMethod) {
		switch (jsMethod) {
			case OmniChannelChatCommandConstants.CHAT_CONFERENCE_ACCEPTED:
				return true;
			default:
				return false;
		}
	}

	private boolean isChatConferenceDepartureMessage(final String jsMethod) {
		switch (jsMethod) {
			case OmniChannelChatCommandConstants.CHAT_CONFERENCE_CLOSED:
				return true;
			default:
				return false;
		}
	}

	private boolean isOmnichannelProfileMessage(final String jsMethod) {
		switch (jsMethod) {
			case OmniChannelCommonCommandConstants.LOGIN_SUCCESS:
				return true;
			default:
				return false;
		}
	}

	private boolean isChatContactArrivalMessage(final String jsMethod) {
		switch (jsMethod) {
			case OmniChannelChatCommandConstants.CHAT_CONTACT_ARRIVED:
				return true;
			default:
				return false;
		}
	}

	private boolean isChatContactStateChanged(final String jsMethod) {
		LOGGER.debug("isChatContactStateChanged({})", jsMethod);
		switch (jsMethod) {
			case OmniChannelChatCommandConstants.CHAT_CONTACT_READY:
				return true;
			case OmniChannelChatCommandConstants.CHAT_CONTACT_ASSIGNED:
				return true;
			case OmniChannelCommonCommandConstants.CONTACT_CLOSED:
				return true;
			case OmniChannelChatCommandConstants.CHAT_CONTACT_TERMINATED: // FIJI-1927
				return true;
			default:
				return false;
		}
	}

	private boolean isChatContactClosed(String jsMethod) {
		LOGGER.debug("isChatContactClosed({})", jsMethod);
		switch (jsMethod) {
			case OmniChannelChatCommandConstants.CHAT_CONTACT_CLOSED:
				return true;
			default:
				return false;
		}
	}

	private boolean isAgentLoggedInMessage(final String jsMethod) {
		LOGGER.debug("jsMethod: {}, inside checking isAgentLoggedInMessage", jsMethod);
		switch (jsMethod) {
			case OmniChannelCommonCommandConstants.AGENT_LOGGED_IN:
				LOGGER.debug("Returning true to isAgentLoggedInMessage({})", jsMethod);
				return true;
			default:
				LOGGER.debug("Returning false to isAgentLoggedInMessage({})", jsMethod);
				return false;
		}
	}

	private boolean isAgentLoggedOutMessage(final String jsMethod) {
		switch (jsMethod) {
			case OmniChannelCommonCommandConstants.AGENT_LOGGED_OUT:
				return true;
			default:
				return false;
		}
	}

	private boolean isChatMessage(final String jsMethod) {
		switch (jsMethod) {
			case OmniChannelChatCommandConstants.CHAT_MESSAGE_RECEIVED:
				return true;
			default:
				return false;
		}
	}

	private boolean isPrivateChatMessage(final String jsMethod) {
		switch (jsMethod) {
			case OmniChannelChatCommandConstants.CHAT_CONFERENCE_AGENT_TO_AGENT_MESSAGE_SENT:
				return true;
			default:
				return false;
		}
	}


	private boolean isPrivateChatMessageSent(final String jsMethod, final String response) {
		if (!OmniChannelChatCommandConstants.CHAT_CONFERENCE_PRIVATE_MESSAGE_SENT.equals(jsMethod)) {
			return false;
		}
		boolean isRequestSuccessful = OmniChannelJsonUtil.extractSuccessFlagFromResponse(response);
		if (!isRequestSuccessful) {
			return false;
		}
		return true;
	}

	private void addChatContactToCache(final String backendSessionId, final String payloadData) {
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if(desktopConfig == null) {
			LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking with payloadData: {}",
					backendSessionId,
					payloadData);
			return;
		}

		ChatContactArrivedMessage chatContactArrivedMessage = StateCacheJson.getChatContactArrivedMessage(payloadData);
		if (chatContactArrivedMessage != null) {
			ChatContact chatContact = chatContactArrivedMessage.constructChatContact();
			desktopConfig.addChatContact(chatContact);
		}
	}

	private void removeContactFromCache(final String backendSessionId, final String payloadData) {
		LOGGER.debug("removeContactFromCache() backendSessionId: {}, payloadData: {}", 
				backendSessionId,
				payloadData); 
		try {
			final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

			if(desktopConfig == null) {
				LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking with payloadData: {}",
						backendSessionId,
						payloadData);
				return;
			}

			final String cduId = OmniChannelJsonUtil.extractCduId(payloadData);
			
			LOGGER.debug("removeContactFromCache() cduId: {}, backendSessionId: {}, payloadData: {}", 
					cduId,
					backendSessionId,
					payloadData); 
			
			if (org.apache.commons.lang3.StringUtils.isNotBlank(cduId)) {
				desktopConfig.removeChatContact(cduId);
				desktopConfig.removeEmailContact(cduId);
				desktopConfig.removeFollowUpContact(cduId);
				LOGGER.debug("removeContactFromCache() cduId removed attempted for all 3 Contacts=> Chat Email FollowUp: {}, backendSessionId: {}, payloadData: {}", 
						cduId,
						backendSessionId,
						payloadData); 
			} else {
				LOGGER.debug("removeContactFromCache() cduId is blank: {}, backendSessionId: {}, payloadData: {}", 
						cduId,
						backendSessionId,
						payloadData); 
			}
		} catch (Exception exception) {
			LOGGER.warn("Could not removeContactFromCache() with payload: {}, for backendSessionId: {}",
					payloadData,
					backendSessionId);
		}
		
	}

	private void removeChatContactFromCache(final String backendSessionId, final String payloadData) {
		try {
			final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

			if(desktopConfig == null) {
				LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking with payloadData: {}",
						backendSessionId,
						payloadData);
				return;
			}

			final String cduId = OmniChannelJsonUtil.extractCduId(payloadData);
			if (org.apache.commons.lang3.StringUtils.isNotBlank(cduId)) {
				desktopConfig.removeChatContact(cduId);
			}
		} catch (Exception exception) {
			LOGGER.warn("Could not removeChatContactFromCache() with payload: {}, for backendSessionId: {}",
					payloadData,
					backendSessionId);
		}
	}

	private void updateChatContactStateForSynchronousInvocations(final String backendSessionId, final String payloadData, final String contactState) {
		LOGGER.debug("updateChatContactStateToClosed({}, {}, {})",
				backendSessionId,
				payloadData);

		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if(desktopConfig == null) {
			LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking with payloadData: {}",
					backendSessionId,
					payloadData);
			return;
		}

		final String cduId = OmniChannelJsonUtil.extractCduIdFromIcxResponse(payloadData);

		LOGGER.debug("cduId: {}; updateChatContactStateToClosed({}, {}, {})",
				cduId,
				backendSessionId,
				payloadData);

		if (org.apache.commons.lang3.StringUtils.isNotBlank(cduId)) {
			ChatContact chatContact = desktopConfig.getChatContact(cduId);

			LOGGER.debug("chatContact: {}; cduId: {}; updateChatContactState({}, {}, {})",
					chatContact,
					cduId,
					backendSessionId,
					payloadData);

			if (chatContact != null) {

				LOGGER.debug("Before updating ChatState: {}, chatContact: {}; cduId: {}; updateChatContactState({}, {})",
						chatContact.getContactState(),
						chatContact.debugToString(),
						cduId,
						backendSessionId,
						payloadData);
				chatContact.setContactState(contactState);
				if (CacheContactState.WRAP_UP.getName().equals(contactState)) {
					chatContact.setLastEventTimestampToCurrentTime();
				}
				LOGGER.debug("After possibly updated ChatState: {}, chatContact: {}; cduId: {}; updateChatContactState({}, {})",
						chatContact.getContactState(),
						chatContact.debugToString(),
						cduId,
						backendSessionId,
						payloadData);

			}
		}
	}

	private void updateChatContactStateInCache(final String backendSessionId, final String payloadData, final String jsMethod) {
		LOGGER.debug("updateCachedChatContactState({}, {}, {})",
				backendSessionId,
				payloadData,
				jsMethod);

		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if(desktopConfig == null) {
			LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking with payloadData: {}",
					backendSessionId,
					payloadData);
			return;
		}

		final String cduId = OmniChannelJsonUtil.extractCduId(payloadData);

		LOGGER.debug("cduId: {}; updateCachedChatContactState({}, {}, {})",
				cduId,
				backendSessionId,
				payloadData,
				jsMethod);

		if (org.apache.commons.lang3.StringUtils.isNotBlank(cduId)) {
			ChatContact chatContact = desktopConfig.getChatContact(cduId);

			LOGGER.debug("chatContact: {}; cduId: {}; updateCachedChatContactState({}, {}, {})",
					chatContact,
					cduId,
					backendSessionId,
					payloadData,
					jsMethod);

			if (chatContact != null) {

				LOGGER.debug("Before possibly updating ChatState: {}, chatContact: {}; cduId: {}; updateCachedChatContactState({}, {}, {})",
						chatContact.getContactState(),
						chatContact.debugToString(),
						cduId,
						backendSessionId,
						payloadData,
						jsMethod);

				switch (jsMethod) {
					case OmniChannelChatCommandConstants.CHAT_CONTACT_READY:
						chatContact.setContactState(CacheContactState.ACCEPTED.getName());
						chatContact.setLastEventTimestampToCurrentTime();
						break;
					case OmniChannelChatCommandConstants.CHAT_CONTACT_ASSIGNED:
						chatContact.setContactState(CacheContactState.ASSIGNED.getName());
						break;
					case OmniChannelCommonCommandConstants.CONTACT_CLOSED:
						chatContact.setContactState(CacheContactState.CLOSED.getName());
						chatContact.setLastEventTimestampToCurrentTime();
						break;
					case OmniChannelChatCommandConstants.CHAT_CONTACT_TERMINATED:  //FIJI-1927
						chatContact.setContactState(CacheContactState.CLOSED.getName());
						chatContact.setLastEventTimestampToCurrentTime();
						break;
					default:
						break;
				}

				LOGGER.debug("After possibly updated ChatState: {}, chatContact: {}; cduId: {}; updateCachedChatContactState({}, {}, {})",
						chatContact.getContactState(),
						chatContact.debugToString(),
						cduId,
						backendSessionId,
						payloadData,
						jsMethod);

			}
		}
	}

	private void addAgentLoggedInToCache(final String backendSessionId, final String payloadData) {
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if(desktopConfig == null) {
			LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking with payloadData: {}",
					backendSessionId,
					payloadData);
			return;
		}

		AgentLoggedInMessage agentLoggedInMessage = StateCacheJson.getAgentLoggedInMessageFromJsonString(payloadData);
		if (agentLoggedInMessage != null) {
			LOGGER.info("agentLoggedInMessage: {}, for backendSessionId: {}",
					agentLoggedInMessage.debugToString(),
					backendSessionId);
			desktopConfig.addAgentLoggedMessage(agentLoggedInMessage);
		} else {
			LOGGER.info("agentLoggedInMessage is null, for backendSessionId: {}",
					backendSessionId);
		}
	}

	private void removeAgentLoggedInFromCache(final String backendSessionId, final String payloadData) {
		try {
			final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

			if(desktopConfig == null) {
				LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking with payloadData: {}",
						backendSessionId,
						payloadData);
				return;
			}

			final Long channelId = OmniChannelJsonUtil.extractChannelIdFromMmResponse(payloadData);
			if (channelId != null) {
				desktopConfig.removeAgentLoggedMessage(channelId);
			}
		} catch (Exception exception) {
			LOGGER.warn("Could not removeAgentLoggedInFromCache() with payload: {}, for backendSessionId: {}, with exception: {}",
					payloadData,
					backendSessionId,
					exception.getMessage());
		}
	}

	private void addOmnichannelProfileToCache(final String backendSessionId, final String payloadData) {
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if(desktopConfig == null) {
			LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking with payloadData: {}",
					backendSessionId,
					payloadData);
			return;
		}

		AgentLoginResponseBody agentLoginResponseBody = StateCacheJson.getAgentLoginResponseBodyFromJsonString(payloadData);

		if (
				(agentLoginResponseBody != null) && 
				(agentLoginResponseBody.getMmResponse() != null) &&
				(desktopConfig.getMmProfile() == null)
		) {
			LOGGER.info("agentLoginResponseBody: {}, for backendSessionId: {}",
					agentLoginResponseBody.debugToString(),
					backendSessionId);
			MmProfile mmProfile = agentLoginResponseBody.getMmResponse().getResponseData();
			desktopConfig.setMmProfile(mmProfile);
			LOGGER.info("mmProfile: {}, for backendSessionId: {}",
					mmProfile.debugToString(),
					backendSessionId);
		} 

		if (agentLoginResponseBody == null) {
			LOGGER.debug("agentLoginResponseBody is null, for backendSessionId: {}",
					backendSessionId);
		}

		if ((agentLoginResponseBody != null) && (agentLoginResponseBody.getMmResponse() == null)) {
			LOGGER.debug("agentLoginResponseBody.getMmResponse() is null, for backendSessionId: {}",
					backendSessionId);
		}

		if (desktopConfig.getMmProfile() == null) {
			LOGGER.debug("mmProfile is null, for backendSessionId: {}",
					backendSessionId);
		}
	}

	private void addChatMessageToCache(final String backendSessionId, final String payloadData) {
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if(desktopConfig == null) {
			LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking addChatMessageToCache() with payloadData: {}",
					backendSessionId,
					payloadData);
			return;
		}

		ChatMessageToCustomerMessage chatMessageToCustomer = StateCacheJson.getChatMessageToCustomer(payloadData);
		
		if (chatMessageToCustomer != null) {
			final ChatMessage chatMessage = chatMessageToCustomer.constructChatMessage();
			if (chatMessage != null) {
				LOGGER.debug(
						"Determining if chatMessage is Inbound (to Agent), "		+ 
						"desktopConfig.getMmProfile().getAgentId(): {}, "			+ 
						"chatMessage.getFromId(): {}",
						desktopConfig.getMmProfile().getAgentId(), 
						chatMessage.getFromId()
				);
				LOGGER.debug(
						"Original chatMessage.MsgDirection: {}",
						chatMessage.getMsgDirection()
				);
				
				final String cduId = chatMessageToCustomer.getMmResponse().getResponseData().getCduId();
				final ChatContact chatContact = desktopConfig.getChatContact(cduId);
				if (chatContact != null) {
					final long currentAgentId = chatContact.getAgentId();
					final long messageOriginatorAgentId = Long.valueOf(chatMessage.getFromId()).longValue();
					if (currentAgentId == messageOriginatorAgentId) {
						chatMessage.setMsgDirection(MessageDirection.OUTBOUND.getName());
					} else {
						chatMessage.setMsgDirection(MessageDirection.INBOUND.getName());
					}
					chatMessage.setMessageReason(chatContact.getContactDetails().getChatReason());
					chatContact.addChatMessage(chatMessage);
				}
				LOGGER.debug(
						"After processing, chatMessage.MsgDirection is: {}",
						chatMessage.getMsgDirection()
				);
			}
		}
	}

	private void addPrivateMessageToCache(final String backendSessionId, final String payloadData) {
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if(desktopConfig == null) {
			LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking addPrivateMessageToCache() with payloadData: {}",
					backendSessionId,
					payloadData);
			return;
		}

		ChatMessagePrivateAgentToAgentMessage chatMessagePrivateAgentToAgentMessage = 
				StateCacheJson.getChatMessagePrivateAgentToAgentMessage(payloadData);
		
		if (chatMessagePrivateAgentToAgentMessage != null) {
			final ChatMessage chatMessage = chatMessagePrivateAgentToAgentMessage.constructChatMessage();
			if (chatMessage != null) {
				LOGGER.debug(
						"Determining if chatMessage is Inbound (to Agent), "		+ 
						"desktopConfig.getMmProfile().getAgentId(): {}, "			+ 
						"chatMessage.getFromId(): {}",
						desktopConfig.getMmProfile().getAgentId(), 
						chatMessage.getFromId()
				);
				LOGGER.debug(
						"Original chatMessage.MsgDirection: {}",
						chatMessage.getMsgDirection()
				);
				
				long confParticipantIdLongValue = 0;
				final long currentAgentId = desktopConfig.getMmProfile().getAgentId();
				final long messageOriginatorAgentId = Long.valueOf(chatMessage.getFromId()).longValue();
				if (currentAgentId == messageOriginatorAgentId) {
					chatMessage.setMsgDirection(MessageDirection.OUTBOUND.getName());
					final String confParticipantIdStringValue = 
							chatMessagePrivateAgentToAgentMessage.getMmResponse().getResponseData().getTo();
					confParticipantIdLongValue = Long.valueOf(confParticipantIdStringValue).longValue();
				} else {
					chatMessage.setMsgDirection(MessageDirection.INBOUND.getName());
					final String confParticipantIdStringValue = 
							chatMessagePrivateAgentToAgentMessage.getMmResponse().getResponseData().getFromId();
					confParticipantIdLongValue = Long.valueOf(confParticipantIdStringValue).longValue();
				}
				final String cduId = chatMessagePrivateAgentToAgentMessage.getMmResponse().getResponseData().getCduId();
				final ChatContact chatContact = desktopConfig.getChatContact(cduId);
				if (chatContact != null) {
					chatMessage.setMessageReason(chatContact.getContactDetails().getChatReason());
					chatContact.addPrivateMessage(confParticipantIdLongValue, chatMessage);
				}
				LOGGER.debug(
						"After processing, chatMessage.MsgDirection is: {}",
						chatMessage.getMsgDirection()
				);
			}
		}
	}

	private void addChatMessagePrivateSentRequestToCache(
			final String backendSessionId, 
			final String request,
			final String response
	) {
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if(desktopConfig == null) {
			LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking addChatMessageRequestToCache() with request: {}",
					backendSessionId,
					request);
			return;
		}

		ChatMessagePrivateSentRequestMessage chatMessagePrivateSentRequest = 
				StateCacheJson.getChatMessagePrivateSentRequest(request);
		
		if (chatMessagePrivateSentRequest != null) {
			final ChatMessage chatMessage = chatMessagePrivateSentRequest.constructChatMessage();
			if (chatMessage != null) {
				final String agentUserName = desktopConfig.getUserName();
				chatMessage.setFromName(agentUserName);
				Long sendTimeFromResponse = null;
				Long sendTimeFromMmResponse = null;
				try {
					sendTimeFromResponse = OmniChannelJsonUtil.extractSendTimeFromResponse(response);
				} catch (Exception exception) {
				}
				try {
					sendTimeFromMmResponse = OmniChannelJsonUtil.extractSendTimeFromMmResponse(response);
				} catch (Exception exception) {
				}
				String sendTime = null;
				try {
					if (sendTimeFromResponse != null) {
						sendTime = Long.valueOf(sendTimeFromResponse).toString();
					} else if (sendTimeFromMmResponse != null) {
						sendTime = Long.valueOf(sendTimeFromMmResponse).toString();
					}
				} catch (Exception exception) {
					LOGGER.warn("Error in converting sendTime for response: {}", response);
				}
				chatMessage.setSendTime(sendTime);

				LOGGER.debug(
						"Determining if chatMessage is Inbound (to Agent), "		+ 
						"desktopConfig.getMmProfile().getAgentId(): {}, "			+ 
						"chatMessage.getFromId(): {}",
						desktopConfig.getMmProfile().getAgentId(), 
						chatMessage.getFromId()
				);
				LOGGER.debug(
						"Original chatMessage.MsgDirection: {}",
						chatMessage.getMsgDirection()
				);

				long confParticipantIdLongValue = 0;
				final String cduId = chatMessagePrivateSentRequest.getCduId();
				if (org.apache.commons.lang3.StringUtils.isNotBlank(cduId)) {
					final ChatContact chatContact = desktopConfig.getChatContact(cduId);
					if (chatContact != null) {
						final long currentAgentId = chatContact.getAgentId();
						final long messageOriginatorAgentId = Long.valueOf(chatMessage.getFromId()).longValue();
						if (currentAgentId == messageOriginatorAgentId) {
							chatMessage.setMsgDirection(MessageDirection.OUTBOUND.getName());
							final String confParticipantIdStringValue = 
									chatMessagePrivateSentRequest.getToMemberId();
							try {
								confParticipantIdLongValue = Long.valueOf(confParticipantIdStringValue).longValue();
							} catch (Exception exception) {
								LOGGER.warn("Could not find or convert toMemberId: {}, in chatMessagePrivateSentRequest: {}",
										confParticipantIdStringValue,
										chatMessagePrivateSentRequest.debugToString());
							}
						} else {
							chatMessage.setMsgDirection(MessageDirection.INBOUND.getName());
							final String confParticipantIdStringValue = 
									chatMessagePrivateSentRequest.getFromMemberId();
							try {
								confParticipantIdLongValue = Long.valueOf(confParticipantIdStringValue).longValue();
							} catch (Exception exception) {
								LOGGER.warn("Could not find or convert fromMemberId: {}, in chatMessagePrivateSentRequest: {}",
										confParticipantIdStringValue,
										chatMessagePrivateSentRequest.debugToString());
							}
						}
						chatMessage.setMessageReason(chatContact.getContactDetails().getChatReason());
						chatContact.addPrivateMessage(confParticipantIdLongValue, chatMessage);
					}
				}
				LOGGER.debug(
						"After processing, chatMessage.MsgDirection is: {}, for chatMessage: {}",
						chatMessage.getMsgDirection(),
						chatMessage.debugToString()
				);
			}
		}
	}

	private void addChatConferenceParticipantToCache(final String backendSessionId, final String payloadData) {
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if(desktopConfig == null) {
			LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking addChatConferenceParticipant() with payloadData: {}",
					backendSessionId,
					payloadData);
			return;
		}

		ChatContactConferenceMemberJoinedMessage chatContactConferenceMemberJoinedMessage = 
				StateCacheJson.getChatContactConferenceMemberJoinedMessage(payloadData);

		if (
				(chatContactConferenceMemberJoinedMessage != null) &&
				(chatContactConferenceMemberJoinedMessage.getMmResponse() != null) &&
				(chatContactConferenceMemberJoinedMessage.getMmResponse().getResponseData() != null)
		) {
			final String cduId = chatContactConferenceMemberJoinedMessage.getMmResponse().getResponseData().getCduId();

			final ChatContact chatContact = desktopConfig.getChatContact(cduId);
			if (chatContact != null) {
				final long conferenceAgentId = chatContactConferenceMemberJoinedMessage.getMmResponse()
						.getResponseData().getConferenceAgentId();
				final String conferenceAgentName = chatContactConferenceMemberJoinedMessage.getMmResponse()
						.getResponseData().getMemberName();
				ConferenceParticipant conferenceParticipant = new ConferenceParticipant(conferenceAgentId,
						conferenceAgentName);
				//FIJI-2912 --Start
				if (chatContact.getConfParticipants().contains(conferenceParticipant)
						|| chatContact.getAgentId() == conferenceAgentId) {
					LOGGER.warn("ConferenceParticipant Already Exits in the Contact {}", conferenceParticipant);
				} else {
					chatContact.addConferenceParticipant(conferenceParticipant);
				}
				//FIJI-2912 --End
			}
		}
	}

	private void removeChatConferenceParticipantFromCache(final String backendSessionId, final String payloadData) {
		LOGGER.debug("removeChatConferenceParticipantFromCache() with backendSessionId: {} , payloadData: {}", 
				backendSessionId,
				payloadData);

		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if(desktopConfig == null) {
			LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking removeChatConferenceParticipant() with payloadData: {}",
					backendSessionId,
					payloadData);
			return;
		}

		ChatContactConferenceCloseMessage chatContactConferenceCloseMessage = 
				StateCacheJson.getChatContactConferenceCloseMessage(payloadData);

		if (
				(chatContactConferenceCloseMessage != null) &&
				(chatContactConferenceCloseMessage.getMmResponse() != null) &&
				(chatContactConferenceCloseMessage.getMmResponse().getResponseData() != null)
		) {
			final String cduId = chatContactConferenceCloseMessage.getMmResponse().getResponseData().getCduId();
			
			final ChatContact chatContact = desktopConfig.getChatContact(cduId);
			if (chatContact != null) {
				try {
					final String memberIdStringValue = 
							chatContactConferenceCloseMessage.getMmResponse().getResponseData().getMemberId();
					final long memberId = Long.valueOf(memberIdStringValue).longValue();

					LOGGER.debug("Processing removal of chat contact information of memberId: {} , cduId: {}, customerId: {}",
							memberIdStringValue,
							cduId, 
							chatContact.getCustomerId());

					// If ChatContactClosed or ChatConferenceMemberLeft, 
					// then perform same/similar action as
					// UI FE's chatService.js handleChatClosedMemberLeft()
					// ==>
					// If memberId != customerId, then remove member from conference participant list
					// If conference participant list is not empty but length is zero, then Customer left Chat (and conference)

					if (memberId != chatContact.getCustomerId()) {
						chatContact.removeConferenceParticipant(memberId);
						LOGGER.debug("Removed conference participant with memberId: {}, chatContact: {}", 
								memberId, 
								chatContact.debugToString());
					}else {
						chatContact.setContactState(CacheContactState.CLOSED.getName());
						LOGGER.debug("Setting chatContactState to CLOSED, memberId: {}, chatContact: {}", 
								memberId, 
								chatContact.debugToString());
					} /**else if ( --FIJI-1832--
//							(chatContact.getConfParticipants() != null)			&& 
//							(chatContact.getConfParticipants().size() == 0)) **/
				} catch (Exception exception) {
					LOGGER.warn("Error while processing ChatContact: {}, for removeChatConferenceParticipant()",
							chatContact.debugToString());
				}
			}
		}
	}

	private void setCustomerIdOfChatContactInCache(final String backendSessionId, final String payloadData) {
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if(desktopConfig == null) {
			LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking setCustomerIdOfChatContactInCache() with payloadData: {}",
					backendSessionId,
					payloadData);
			return;
		}

		ChatContactMemberJoinedMessage chatContactMemberJoinedMessage = StateCacheJson.getChatContactMemberJoinedMessage(payloadData);
		if (
				(chatContactMemberJoinedMessage != null) &&
				(chatContactMemberJoinedMessage.getMmResponse() != null) &&
				(chatContactMemberJoinedMessage.getMmResponse().getResponseData() != null)
		) {
			final String cduId = chatContactMemberJoinedMessage.getMmResponse().getResponseData().getCduId();
			final ChatContact chatContact = desktopConfig.getChatContact(cduId);
			if (chatContact != null) {
				final long customerId = chatContactMemberJoinedMessage.getMmResponse().getResponseData().getCustomerId();
				chatContact.setCustomerId(customerId);
			}
		}
	}

	private void addEmailContactToCache(final String backendSessionId, final String payloadData) {
		LOGGER.debug("Trying to add email contact state cached object with backendSessionId: {}, and payloadData: {}",
				backendSessionId, payloadData);
		
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if(desktopConfig == null) {
			LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking with payloadData: {}",
					backendSessionId,
					payloadData);
			return;
		}

		EmailContactArrivedMessage emailContactArrivedMessage = StateCacheJson.getEmailContactArrivedMessage(payloadData);
		if (emailContactArrivedMessage != null) {
			LOGGER.debug("Adding email contact emailContactArrivedMessage: {}",
					emailContactArrivedMessage.debugToString());
			EmailContact emailContact = emailContactArrivedMessage.constructEmailContact();
			desktopConfig.addEmailContact(emailContact);
		} else {
			LOGGER.debug("Trying to add email contact state with emailContactArrivedMessage is null");
		}
	}

	private void updateEmailContactStateToAccepted(final String backendSessionId, final String response) {
		
		LOGGER.debug("Trying to update email contact state to Accepted for backendSessionId: {}, and response: {}",
				backendSessionId, response);
		
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if(desktopConfig == null) {
			LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking with response: {}",
					backendSessionId,
					response);
			return;
		}

		final String cduId = OmniChannelJsonUtil.extractCduIdFromIcxResponse(response);
		
		LOGGER.debug("Found cduId: {}, while trying to update email contact state to Accepted for backendSessionId: {}, and response: {}",
				cduId, backendSessionId, response);
		
		if (org.apache.commons.lang3.StringUtils.isNotBlank(cduId)) {
			EmailContact emailContact = desktopConfig.getEmailContact(cduId);

			if (emailContact != null) {
				LOGGER.debug("Found emailContact: {}, with cduId: {}, while trying to update email contact state to Accepted for backendSessionId: {}, and response: {}",
						emailContact.debugToString(), cduId, backendSessionId, response);
				if (CacheContactState.NEW.getName().equals(emailContact.getContactState())) {
					emailContact.setContactState(CacheContactState.ACCEPTED.getName());
					emailContact.setLastEventTimestampToCurrentTime();
					LOGGER.debug("Updated emailContact state: {}, of emailContact: {}, with cduId: {}, while trying to update email contact state to Accepted for backendSessionId: {}, and response: {}",
							emailContact.getContactState(), emailContact.debugToString(), cduId, backendSessionId, response);
				} else {
					LOGGER.debug("Not updating emailContact state: {}, of emailContact: {}, with cduId: {}, because state is not New while trying to update email contact state to Accepted for backendSessionId: {}, and response: {}",
							emailContact.getContactState(), emailContact.debugToString(), cduId, backendSessionId, response);
				}
			} else {
				LOGGER.info("Could not find emailContact: {}, with cduId: {}, while trying to update email contact state to Accepted for backendSessionId: {}, and response: {}",
						emailContact, cduId, backendSessionId, response);
			}
		}
	}

	private void updateEmailContactStateToClosed(final String backendSessionId, final String request) {
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if(desktopConfig == null) {
			LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking with request: {}",
					backendSessionId,
					request);
			return;
		}

		final String cduId = OmniChannelJsonUtil.extractCduIdFromFeRequestToIcx(request);
		if (org.apache.commons.lang3.StringUtils.isNotBlank(cduId)) {
			EmailContact emailContact = desktopConfig.getEmailContact(cduId);
			if (emailContact != null) {
				emailContact.setContactState(CacheContactState.CLOSED.getName());
				emailContact.setLastEventTimestampToCurrentTime();
			}
		}
	}

	private void removeEmailContactFromCache(final String backendSessionId, final String response, final String request) {
		try {
			final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

			if(desktopConfig == null) {
				LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking with response: {}",
						backendSessionId,
						response);
				return;
			}

			final String cduId = OmniChannelJsonUtil.extractCduIdFromFeRequestToIcx(request);
			if (org.apache.commons.lang3.StringUtils.isNotBlank(cduId)) {
				desktopConfig.removeEmailContact(cduId);
			}
		} catch (Exception exception) {
			LOGGER.warn("Could not remove Email Contact with response: {}, for backendSessionId: {}",
					response,
					backendSessionId);
		}
	}

	private void copyEmailDraftToEmailContact(final String backendSessionId, final String request) {
		try {
			final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

			if(desktopConfig == null) {
				LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking with request: {}",
						backendSessionId,
						request);
				return;
			}

			final RequestData saveEmailDraftRequest = StateCacheJson.getSaveEmailDraftRequest(request);
			if (saveEmailDraftRequest == null) {
				LOGGER.warn("Could not create RequestData POJO from request JSON: {}, with backendSessionId: {}",
						request,
						backendSessionId);
				return;
			}

			final String cduId = saveEmailDraftRequest.getCduId();
			if (org.apache.commons.lang3.StringUtils.isBlank(cduId)) {
				LOGGER.warn("cduId is Apache defined blank: {}, for RequestData POJO: {}",
						cduId,
						saveEmailDraftRequest.debugToString());
				return;
			}
			
			final EmailContact emailContact = desktopConfig.getEmailContact(cduId);
			if (emailContact == null) {
				LOGGER.warn("Email contact could not be found in Dekstop Configuration for cduId: {}",
						cduId);
				return;
			}
			emailContact.copyAttributes(saveEmailDraftRequest);
		} catch (Exception exception) {
			LOGGER.warn("Could not update Email Contact with request: {}, for backendSessionId: {}",
					request,
					backendSessionId);
		}
	}

	private void addFollowUpContactToCache(final String backendSessionId, final String payloadData) {
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if(desktopConfig == null) {
			LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking addFollowUpContactIntoCache with payloadData: {}",
					backendSessionId,
					payloadData);
			return;
		}

		FollowUpContactArrivedMessage followUpContactArrivedMessage = StateCacheJson.getFollowUpContactArrivedMessage(payloadData);
		if (followUpContactArrivedMessage != null) {
			FollowUpContact followUpContact = followUpContactArrivedMessage.constructFollowUpContact();
			desktopConfig.addFollowUpContact(followUpContact);
		}
	}


	private void addFetchedFollowUpContactsIntoCache(String backendSessionId, String payloadData) {
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if(desktopConfig == null) {
			LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking addFollowUpContactIntoCache with payloadData: {}",
					backendSessionId,
					payloadData);
			return;
		}

		FollowUpContactFetchedMessage followUpContactFetchedMessage = StateCacheJson.getFollowUpContactFetchedMessage(payloadData);
		if (followUpContactFetchedMessage != null) {
			List<FollowUpContact> followUpContacts = followUpContactFetchedMessage.constructFollowUpContacts();
			if (
					(followUpContacts != null)		&& 
					(!followUpContacts.isEmpty())	&& 
					(followUpContacts.size() > 0)
			) {
				for (FollowUpContact followUpContact : followUpContacts) {
					desktopConfig.addFollowUpContact(followUpContact);
					LOGGER.debug("followUpContact: {}", followUpContact.debugToString());
				}
			}
		}
	}

	private void removeFollowUpContactFromCache(final String backendSessionId, final String response) {
		try {
			final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

			if(desktopConfig == null) {
				LOGGER.warn("DesktopConfiguration not found for backendSessionId: {}, invoking with response: {}",
						backendSessionId,
						response);
				return;
			}

			final String cduId = OmniChannelJsonUtil.extractCduIdFromIcxResponse(response);
			if (org.apache.commons.lang3.StringUtils.isNotBlank(cduId)) {
				desktopConfig.removeFollowUpContact(cduId);;
			}
		} catch (Exception exception) {
			LOGGER.warn("Could not remove FollowUp Contact with response: {}, for backendSessionId: {}",
					response,
					backendSessionId);
		}
	}
	
	private JSONObject icxServerError(String detail) {
		final JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put(AdaConstants.CODE, String.valueOf(ContextConstants.ERROR_OMNI));
			jsonResponse.put(AdaConstants.DETAIL, detail);
		} catch (final JSONException e) {
			LOGGER.error("Exception occured while forming json string on errorOccured condition {} " + e);
		}
		return jsonResponse;
	}
	
	private JSONObject icxServerError4xx(String detail) {
		final JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put(AdaConstants.CODE, String.valueOf(ContextConstants.ERROR_OMNI_4XX));
			jsonResponse.put(AdaConstants.DETAIL, detail);
		} catch (final JSONException e) {
			LOGGER.error("Exception occured while forming json string on errorOccured condition {} " + e);
		}
		return jsonResponse;
	}
	
	public void reportError(HttpServerErrorException hse, String sessionId) {
		LOGGER.error("{} HttpServerErrorException: StatusCode:{}, StatusMessage: {} ", 
				sessionId, hse.getStatusCode(), hse.getMessage());
		
		final JSONObject jsonResponse = icxServerError(hse.getMessage());
		final AdaResponse adaResponse = new AdaResponse(
				CommandConstants.ERROR_OCCURRED, 
				jsonResponse.toString(),
				webSocketCacheManager.getToken(sessionId));
		try {
			dataPublisher.publishData(adaResponse);
		} catch (final Exception e) {
			LOGGER.error("{} Exception publishing ICX failure: adaResponse:{} exception:{} ", 
					sessionId, adaResponse, e.getMessage());
		}
	}
	
	public void reportError(ResourceAccessException rae, String sessionId) {
		LOGGER.error("{} ResourceAccessException: Cause:{}, CauseMessage: {} ", 
				sessionId, rae.getCause(), rae.getMessage());

		final JSONObject jsonResponse = icxServerError(rae.getCause().toString());
		final AdaResponse adaResponse = new AdaResponse(
				CommandConstants.ERROR_OCCURRED, 
				jsonResponse.toString(),
				webSocketCacheManager.getToken(sessionId));
		try {
			dataPublisher.publishData(adaResponse);
		} catch (final Exception e) {
			LOGGER.error("{} Exception publishing ICX failure: adaResponse:{} exception:{} cause:{}", 
					sessionId, adaResponse, e.getMessage(), e.getCause());
		}
	}
	
	public void reportError(HttpClientErrorException hce, String sessionId) {
        LOGGER.error("{} HttpClientErrorException: StatusCode:{}, StatusMessage: {} ",
                        sessionId, hce.getStatusCode(), hce.getMessage());

        final JSONObject jsonResponse = icxServerError4xx(hce.getMessage());
        final AdaResponse adaResponse = new AdaResponse(
                        CommandConstants.ERROR_OCCURRED,
                        jsonResponse.toString(),
                        webSocketCacheManager.getToken(sessionId));
        try {
        		dataPublisher.publishData(adaResponse);
        } catch (final Exception e) {
        		LOGGER.error("{} Exception publishing ICX failure: adaResponse:{} exception:{} ",
        				sessionId, adaResponse, e.getMessage());
        }
	}
	
	public void reportError(
		final String jsMethodCommandConstant, 
		final String sessionId, 
		final Long agentId, 
		final String actionName) {
		
		// Send failure response to FE: "success": false, and jsMethod			
		String failResponse = OmniChannelJsonUtil.
    			failureResponse(OmniChannelCommonConstants.ICX_POST_FAILED_RESPONSE, sessionId, agentId, actionName);
    		
		try {
    			transmitDataToFrontend(failResponse, jsMethodCommandConstant);
		} catch (final Exception e) {
			LOGGER.error("Error transmitting to Frontend with exception: {}, response: {}, jsMethod: {}", 
					e, failResponse, jsMethodCommandConstant);
		} 		
	}
	
	

}
