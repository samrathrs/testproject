package com.transerainc.adaws.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.constants.OmniChannelCommonConstants;
import com.transerainc.adaws.constants.StateCacheConstants;
import com.transerainc.adaws.model.AdaRequest;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.RequestData;
import com.transerainc.adaws.model.cache.contact.call.CallContact;
import com.transerainc.adaws.model.cache.contact.chat.ChatContact;
import com.transerainc.adaws.model.cache.contact.chat.ChatContactArrivedMessage;
import com.transerainc.adaws.model.cache.contact.chat.ChatContactConferenceCloseMessage;
import com.transerainc.adaws.model.cache.contact.chat.ChatContactConferenceMemberJoinedMessage;
import com.transerainc.adaws.model.cache.contact.chat.ChatContactMemberJoinedMessage;
import com.transerainc.adaws.model.cache.contact.chat.ChatMessagePrivateAgentToAgentMessage;
import com.transerainc.adaws.model.cache.contact.chat.ChatMessagePrivateSentRequestMessage;
import com.transerainc.adaws.model.cache.contact.chat.ChatMessageToCustomerMessage;
import com.transerainc.adaws.model.cache.contact.email.EmailContact;
import com.transerainc.adaws.model.cache.contact.email.EmailContactArrivedMessage;
import com.transerainc.adaws.model.cache.contact.followup.FollowUpContact;
import com.transerainc.adaws.model.cache.contact.followup.FollowUpContactArrivedMessage;
import com.transerainc.adaws.model.cache.contact.followup.FollowUpContactFetchedMessage;
import com.transerainc.adaws.model.cache.icrm.IcrmResponse;
import com.transerainc.adaws.model.cache.loggedinagent.AgentLoggedInMessage;
import com.transerainc.adaws.model.cache.profile.AgentLoginResponseBody;
import com.transerainc.adaws.model.cache.profile.MmProfile;

/**
 * @author tnguyen
 *
 */
@Component
public class StateCacheJson {

	private static final Logger LOGGER = LoggerFactory.getLogger(StateCacheJson.class.getName());
	private static final Gson GSON = new Gson();

	@Autowired
	private DesktopConfigManager configMap;

	@Autowired
	private WebSocketCacheManager webSocketCacheManager;

	public AdaResponse buildAgentStateData(final AdaRequest adaRequest) {
		final String agentToken = adaRequest.getagentSessionId();

		final DesktopConfiguration desktopConfig = configMap.getConfigForAgent(webSocketCacheManager
				.getAgent(agentToken));

		// Agent not found in Backend
		if (desktopConfig == null) {
			LOGGER.warn("Could not find desktop configuration in map and cache for WebToken: {}",
					agentToken);
			return null;
		}

		// TODO:
		// Send to Front End the cache of Backend's knowledge of Agent's states
		// 1.) Agent Profile (default - TACG/non-OmniChannel and non-ICX)
		// 2.) Desktop Configuration
		// 3.) OmniChannel/MM Profile of Agent
		// 4.) ICRM Response
		// 5.) Logged-in channels of OmniChannel ICX
		// 6.) Active Contacts
		//      6a.) Chat Contacts
		//      6b.) Call Contacts
		//      6c.) Email Contacts
		//      6d.) Followup Contacts
		// 7.) Customization Information

		try {
			// 1.) Agent Profile
			final JSONObject agentStateJson = new JSONObject(desktopConfig.getStringifiedAgentProfileJSON());
			LOGGER.info("agentProfile: {} sent to FE agentToken for Browser Reload: {}", 
					agentStateJson,
					agentToken);

			// 2.) Desktop Configuration
			agentStateJson.put(StateCacheConstants.DESKTOP_CONFIGURATION_KEY, DesktopConfigurationUtil.toJson(desktopConfig));
			LOGGER.info("desktopConfiguration: {}, sent to FE agentToken for Browser Reload: {}", 
					DesktopConfigurationUtil.toJson(desktopConfig),
					agentToken);

			// 3.) OmniChannel/MM Profile of Agent
			if (desktopConfig.getMmProfile() != null) {
				final String mmProfileString = GSON.toJson(desktopConfig.getMmProfile(), MmProfile.class);
				final JSONObject mmProfileJson = new JSONObject(mmProfileString);
				agentStateJson.put(StateCacheConstants.MM_PROFILE_KEY, mmProfileJson);
				LOGGER.info("mmProfile: {}, sent to FE agentToken for Browser Reload: {}", 
						mmProfileString,
						agentToken);
			} else {
				LOGGER.info("mmProfile is null for FE agentToken: {}", agentToken);
			}

			// 4.) ICRM Response
			if (desktopConfig.getIcrmResponse() != null) {
				String icrmResponseString = GSON.toJson(desktopConfig.getIcrmResponse(), IcrmResponse.class);
				final JSONObject icrmResponseJson = new JSONObject(icrmResponseString);
				agentStateJson.put(StateCacheConstants.ICRM_RESPONSE_KEY, icrmResponseJson);
				LOGGER.info("icrmResponse: {}, sent to FE agentToken for Browser Reload: {}", 
						icrmResponseString,
						agentToken);
			} else {
				LOGGER.info("icrmResponse is null for FE agentToken: {}", agentToken);
			}

			// 5.) Logged-in channels of OmniChannel ICX
			if (
					(desktopConfig.getAgentLoggedInMessages() != null)
					&& 
					(desktopConfig.getAgentLoggedInMessages().length > 0)
			) {
				JSONArray agentLoggedInMessageArray = new JSONArray();
				for (AgentLoggedInMessage agentLoggedInMessage : desktopConfig.getAgentLoggedInMessages()) {
					final String agentLoggedInMessageOuterWrapperString = GSON.toJson(agentLoggedInMessage, AgentLoggedInMessage.class);
					final JSONObject agentLoggedInMessageOuterWrapperJson = new JSONObject(agentLoggedInMessageOuterWrapperString);
					final JSONObject agentLoggedInMessageJson = agentLoggedInMessageOuterWrapperJson.getJSONObject(OmniChannelCommonConstants.MM_RESPONSE_KEY);
					agentLoggedInMessageArray.put(agentLoggedInMessageJson);
					LOGGER.info("Single array element - agentLoggedInMessageJsonString: {}, sent to FE agentToken for Browser Reload: {}", 
							agentLoggedInMessageJson,
							agentToken);
				}
				agentStateJson.put(StateCacheConstants.MM_LOGGED_IN_AGENTS_KEY, agentLoggedInMessageArray);
				LOGGER.info("agentLoggedInMessages array: {}, sent to FE agentToken for Browser Reload: {}", 
						agentLoggedInMessageArray,
						agentToken);
			} else {
				LOGGER.info("agentLoggedInMessages is null or is empty for FE agentToken: {}", agentToken);
			}

			JSONArray activeContactsArray = new JSONArray();

			// 6.) Active Contacts
			//		6a.) Chat Contacts
			if (
					(desktopConfig.getChatContacts() != null)
					&& 
					(desktopConfig.getChatContacts().length > 0)
			) {
				for (ChatContact chatContact : desktopConfig.getChatContacts()) {
					final JSONObject chatContactJson = chatContact.toJsonObject();
					activeContactsArray.put(chatContactJson);
					LOGGER.info("Single array element - chatContact: {}, sent to FE agentToken for Browser Reload: {}", 
							chatContactJson.toString(),
							agentToken);
				}
			} else {
				LOGGER.info("chatContacts is null or is empty for FE agentToken: {}", agentToken);
			}

			// 6.) Active Contacts
			//		6b.) Call Contacts
			if (desktopConfig.getCallContact() != null) {
				CallContact callContact = desktopConfig.getCallContact();
				final JSONObject callContactJson = callContact.toJsonObject();
				LOGGER.info("CallContact JSON Object: {}", callContactJson);
				activeContactsArray.put(callContactJson);
			} else {
				LOGGER.info("Call Contact is null for FE agentToken: {}", agentToken);
			}

			// 6.) Active Contacts
			//      6c.) Email Contacts
			if (
					(desktopConfig.getEmailContacts() != null)
					&& 
					(desktopConfig.getEmailContacts().length > 0)
			) {
				for (EmailContact emailContact : desktopConfig.getEmailContacts()) {
					final JSONObject emailContactJson = emailContact.toJsonObject();
					activeContactsArray.put(emailContactJson);
					LOGGER.info("Single array element - emailContact: {}, sent to FE agentToken for Browser Reload: {}", 
							emailContactJson.toString(),
							agentToken);
				}
			} else {
				LOGGER.info("emailContacts is null or is empty for FE agentToken: {}", agentToken);
			}

			// 6.) Active Contacts
			//		6d.) FollowUp Contacts
			if (
					(desktopConfig.getFollowUpContacts() != null)
					&& 
					(desktopConfig.getFollowUpContacts().length > 0)
			) {
				for (FollowUpContact followUpContact : desktopConfig.getFollowUpContacts()) {
					final JSONObject followUpContactJson = followUpContact.toJsonObject();
					activeContactsArray.put(followUpContactJson);
					LOGGER.info("Single array element - followUpContact: {}, sent to FE agentToken for Browser Reload: {}", 
							followUpContactJson.toString(),
							agentToken);
				}
			} else {
				LOGGER.info("followUpContacts is null or is empty for FE agentToken: {}", agentToken);
			}

			// 6.) Active Contacts
			// Serialize all Active Contacts into Contacts element of Reload JSON
			if (activeContactsArray.length() > 0) {
				agentStateJson.put(StateCacheConstants.CONTACTS_KEY, activeContactsArray);
			}

			// 7.) Customization Information
			if(desktopConfig.getComponentInformation() != null && desktopConfig.getComponentInformation().size() > 0){
				JSONObject componentInformationsJson = new JSONObject();
				for (String componentType : desktopConfig.getComponentInformation().keySet()) {
					final JSONObject componentInformationJson = new JSONObject(desktopConfig.getComponentInformation().get(componentType));
					componentInformationsJson.put(componentType, componentInformationJson);
				}
				agentStateJson.put(StateCacheConstants.COMPONENT_INFORMATION_KEY, componentInformationsJson);
			}

			// Create Ada Response of Agent's cached state from all pieces of information retrieved and constructed so far.
			final AdaResponse agentStateAdaResponse = 
					new AdaResponse(CommandConstants.AGENT_UI_STATE_RELOADED, 
							agentStateJson.toString(), 
							agentToken);
			LOGGER.info("Constructed Ada Response: {},of cached agent state for Web Token: {}",
					agentStateAdaResponse,
					agentToken);
			return agentStateAdaResponse;
		} catch (JSONException jsonException) {
			LOGGER.warn("Could not construct Agent State JSON for FE Agent Session Id:{}; Encountered JSONException: {}",
					agentToken,
					jsonException.toString());
			return null;
		}
	}

	public static AgentLoginResponseBody getAgentLoginResponseBodyFromJsonString(final String jsonStringData) {
		LOGGER.debug("AgentLoginResponseBody JSON: {}", jsonStringData);
		return GSON.fromJson(jsonStringData, AgentLoginResponseBody.class);
	}

	public static IcrmResponse getIcrmResponseFromJsonString(final String jsonStringData) {
		LOGGER.debug("IcrmResponse JSON: {}", jsonStringData);
		return GSON.fromJson(jsonStringData, IcrmResponse.class);
	}

	public static AgentLoggedInMessage getAgentLoggedInMessageFromJsonString(final String jsonStringData) {
		LOGGER.debug("AgentLoggedInMessage JSON: {}", jsonStringData);
		return GSON.fromJson(jsonStringData, AgentLoggedInMessage.class);
	}

	public static ChatContactArrivedMessage getChatContactArrivedMessage(final String jsonStringData) {
		LOGGER.debug("ChatContactArrivedMessage JSON: {}", jsonStringData);
		return GSON.fromJson(jsonStringData, ChatContactArrivedMessage.class);
	}

	public static ChatMessageToCustomerMessage getChatMessageToCustomer(final String jsonStringData) {
		LOGGER.debug("ChatMessageToCustomerMessage JSON: {}", jsonStringData);
		return GSON.fromJson(jsonStringData, ChatMessageToCustomerMessage.class);
	}

	public static ChatContactMemberJoinedMessage getChatContactMemberJoinedMessage(final String jsonStringData) {
		LOGGER.debug("ChatContactMemberJoinedMessage JSON: {}", jsonStringData);
		return GSON.fromJson(jsonStringData, ChatContactMemberJoinedMessage.class);
	}

	public static EmailContactArrivedMessage getEmailContactArrivedMessage(final String jsonStringData) {
		LOGGER.debug("EmailContactArrivedMessage JSON: {}", jsonStringData);
		return GSON.fromJson(jsonStringData, EmailContactArrivedMessage.class);
	}

	public static RequestData getSaveEmailDraftRequest(final String jsonStringData) {
		LOGGER.debug("SavedEmailDraftRequest JSON: {}", jsonStringData);
		return GSON.fromJson(jsonStringData, RequestData.class);
	}

	public static FollowUpContactArrivedMessage getFollowUpContactArrivedMessage(final String jsonStringData) {
		LOGGER.debug("FollowUpContactArrivedMessage JSON: {}", jsonStringData);
		return GSON.fromJson(jsonStringData, FollowUpContactArrivedMessage.class);
	}

	public static FollowUpContactFetchedMessage getFollowUpContactFetchedMessage(final String jsonStringData) {
		LOGGER.debug("FollowUpContact JSON: {}", jsonStringData);
		return GSON.fromJson(jsonStringData, FollowUpContactFetchedMessage.class);
	}

	public static ChatContactConferenceMemberJoinedMessage getChatContactConferenceMemberJoinedMessage(
			final String jsonStringData) {
		LOGGER.debug("ChatContactConferenceMemberJoinedMessage JSON: {}", jsonStringData);
		return GSON.fromJson(jsonStringData, ChatContactConferenceMemberJoinedMessage.class);
	}

	public static ChatContactConferenceCloseMessage getChatContactConferenceCloseMessage(
			final String jsonStringData) {
		LOGGER.debug("ChatContactConferenceCloseMessage JSON: {}", jsonStringData);
		return GSON.fromJson(jsonStringData, ChatContactConferenceCloseMessage.class);
	}

	public static ChatMessagePrivateAgentToAgentMessage getChatMessagePrivateAgentToAgentMessage(
			final String jsonStringData) {
		LOGGER.debug("ChatMessagePrivateAgentToAgentMessage JSON: {}", jsonStringData);
		return GSON.fromJson(jsonStringData, ChatMessagePrivateAgentToAgentMessage.class);
	}

	public static ChatMessagePrivateSentRequestMessage getChatMessagePrivateSentRequest(
			final String jsonStringData) {
		LOGGER.debug("ChatMessagePrivateSentRequest JSON: {}", jsonStringData);
		return GSON.fromJson(jsonStringData, ChatMessagePrivateSentRequestMessage.class);
	}

}
