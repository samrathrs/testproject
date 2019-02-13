package com.transerainc.adaws.command;

import java.util.SortedMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AgentStateConstants;
import com.transerainc.adaws.constants.CallPropertyConstants;
import com.transerainc.adaws.constants.CallStateConstants;
import com.transerainc.adaws.constants.ChannelStateConstant;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.constants.OmniChannelCommonCommandConstants;
import com.transerainc.adaws.constants.OmniChannelCommonConstants;
import com.transerainc.adaws.exception.InterpretationException;
import com.transerainc.adaws.constants.OmniChannelCommonFrontendRequests;
import com.transerainc.adaws.json.DesktopConfigurationUtil;
import com.transerainc.adaws.json.OmniChannelJsonUtil;
import com.transerainc.adaws.json.PackageJsonData;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.CallAssociatedData.Data;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.TacgResponse;
import com.transerainc.adaws.model.cache.contact.call.CallContact;
import com.transerainc.adaws.service.OmniChannelUtilService;
import com.transerainc.adaws.model.cache.contact.call.CallStatus;
import com.transerainc.adaws.model.cache.contact.call.LineData1;
import com.transerainc.adaws.model.cache.contact.call.LineData2;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.SpringContextHelper;
import com.transerainc.aha.gen.agent.AgentDocument.Agent;

/**
 * @author rajeev.lochanam
 */
@Component
public class AgentCommand {

	private static Logger LOGGER = LoggerFactory.getLogger(AgentCommand.class.getName());

	@Value("${ada.omnichannel.callback.url}")
	private String adaCallbackUrl;

	//@Value("${omnichannel.url}")
	//private String omniChannelUrl;
	
	@Autowired
	private StateUpdateCommand stateUpdateCommand;

	@Autowired
	private DesktopConfigManager configMap;

	@Autowired
	private PackageJsonData packageJsonData;

	@Autowired
	private WebSocketCacheManager webSocketCacheManager;
	
	@Autowired
    private OmniChannelUtilService omniChannelUtilService;

	/**
	 * @param tacgResp
	 * @return
	 * @throws InterpretationException
	 * @throws JSONException
	 */
	public AdaResponse processData(final TacgResponse tacgResp) throws InterpretationException, JSONException {

		final String agentSessionId = tacgResp.getAgentSessionId();
		final Agent agent = tacgResp.getAgentList().getAgentArray(0);

		final String session = webSocketCacheManager.getToken(agentSessionId);
		stateUpdateCommand.processData(tacgResp);

		final JSONObject jsonResponse = asJsonResponse(agent, agentSessionId);
		return processData(tacgResp, session, agentSessionId, jsonResponse);
	}

	/**
	 * @param agentSessionId
	 * @param jsonResponse
	 * @return
	 */
	private AdaResponse processData(final TacgResponse tacgResp, final String webToken, final String agentSessionId, final JSONObject jsonResponse) {
		final DesktopConfiguration conf = configMap.getConfigForAgent(agentSessionId);

		String propertyType = CommandConstants.AGENT_PROPERTY_CHANGED;

		if (conf == null) {
			LOGGER.debug(agentSessionId + " ===>> DesktopConfiguration is null So, agent logged out : ");
			if (DesktopConfigurationUtil.hasReason(tacgResp.getXml(), ContextConstants.TACG_SHUTTING_DOWN_REASON)) {
				JSONObject errorCode = DesktopConfigurationUtil.errorOccurred(ContextConstants.WARNING_TACG_SHUTTING_DOWN_CODE, 
						ContextConstants.TACG_SHUTTING_DOWN_REASON);
				final AdaResponse errorOccurredAdaResponse = new AdaResponse(CommandConstants.ERROR_OCCURRED, errorCode.toString(), webToken, "");
				return errorOccurredAdaResponse;
			} else {
				return new AdaResponse(propertyType, jsonResponse.toString(), webToken, "");
			}
		}

		LineData1 line1 = conf.getCallContact().getLine1();
		LineData2 line2 = conf.getCallContact().getLine2();

		String callData = "";

		// Enters the condition if the sub-state is Ringing and calls the callPropertyChanged javascript function
		final String subState = conf.getSubStatus();
		LOGGER.debug("BE agentSessionId: {} ===>> processing data for Agent subState : {}",
				agentSessionId,
				subState);

		LOGGER.debug("Before processing subStatus: {}, Line1 current: {} and Line2 current: {}", 
				subState,
				line1.debugToString(), 
				line2.debugToString());

		switch (subState) {
			case AgentStateConstants.SUBSTATE_RINGING:
				propertyType = CommandConstants.CALL_PROPERTY_CHANGED;
	
				callData = formatShowableCalldata(conf);
				setUpCallContactLine1(conf);
				if (!conf.isAgentavailable()) {
					conf.getCallContact().getLine1().setStatus(CallStatus.OUTDIAL_RESERVED.getName());
				} else {
					conf.setOutdialCallCheck(false);
					conf.getCallContact().getLine1().setStatus(CallStatus.RINGING.getName());
				}
				line1.setLastEventTimestampToCurrentTime();
				break;
			case AgentStateConstants.SUBSTATE_CONNECTED:
				propertyType = CommandConstants.CALL_STATE_CHANGED;
	
				callData = formatShowableCalldata(conf);
	
				LOGGER.debug("Before processing Connected, Line1 current: {} and Line2 current: {}", line1.debugToString(), line2.debugToString());
				// Check if callId exists in Line1
				// If Line1 callId does not exist, then Save Line2 data to Line1, reset Line2
				if ((line1.getCallId() == null) && (line2.getCallId() != null) && (!line2.getDataMap().isEmpty())) {
					line1.setDataMap(line2.getDataMap());
					line1.setLastEventTimestamp(line2.getLastEventTimestamp());
					line2.reset();
				} else {
					if (line1.getCallId() == null) {
					if (conf.getStateChangeData().getCallAssociatedData().getDataMap() != null
							&& !conf.getStateChangeData().getCallAssociatedData().getDataMap().isEmpty()) {
						line1.setDataMap(conf.getStateChangeData().getCallAssociatedData().getDataMap());
					}
						line1.setLastEventTimestampToCurrentTime();
					} else {
						long line1LastEventTimestamp = line1.getLastEventTimestamp();
						setUpCallContactLine1(conf);
						line1.setLastEventTimestamp(line1LastEventTimestamp);
					}
				}
				line1.setStatus(CallStatus.CONNECTED.getName());
				LOGGER.debug("After processing Connected, Line1 current: {} and Line2 current: {}", line1.debugToString(), line2.debugToString());
				break;
			case AgentStateConstants.SUBSTATE_AVAILABLE:
			case AgentStateConstants.SUBSTATE_IDLE:
				propertyType = CommandConstants.CHANGE_TO_AVAILABLE;
	
				if(conf.isIcrmEnabled()) {
					loginOmniChannel(agentSessionId);
				}
				resetCallContactLines(subState, line1, line2);
				line1.resetLastEventTimestamp();
				break;
			case ChannelStateConstant.AVAILABLE_CONSULT_RESERVED:
			case AgentStateConstants.IDLE_CONSULT_RESERVED:
				propertyType = CommandConstants.CALL_PROPERTY_CHANGED;
				setConferenceStatus(agentSessionId, false);
				callData = null;
				setUpCallContactLine2(conf);
				this.updateCallContactStateLine2(CallStatus.CONSULT_RESERVED.getName(), conf);
				line2.setCallId(conf.getStateChangeData().getCallId());
				line2.setLastEventTimestampToCurrentTime();
				break;
			case ChannelStateConstant.CONNECTED_CONSULT_RESERVED:
				propertyType = CommandConstants.CALL_PROPERTY_CHANGED;
				setConferenceStatus(agentSessionId, false);
				callData = null;
				setUpCallContactLine2(conf);
				this.updateCallContactStateLine2(CallStatus.CONSULT_REQUESTED.getName(), conf);
				line2.setLastEventTimestampToCurrentTime();
				break;
			case ChannelStateConstant.AVAILABLE_CONSULTING:
			case ChannelStateConstant.CONNECTED_CONSULTING:
			// TODO:
			// Is this lack of break statement for ChannelStateConstant.CONSULTING a bug/defect?
			// Need to check with Sunny Adak
			case ChannelStateConstant.CONSULTING:
				updateCallContactStateLine2(CallStatus.CONSULTING.getName(), conf);
				line2.setLastEventTimestampToCurrentTime();
			case ChannelStateConstant.CONSULT_RESERVED:
				propertyType = CommandConstants.CALL_PROPERTY_CHANGED;
	
				setConferenceStatus(agentSessionId, false);
	
				callData = formatShowableCalldata(conf);
				setUpCallContactLine2(conf);
				final String callStatusLine = conf.isConnectedConsultReserved() ? CallStatus.CONSULT_REQUESTED.getName() : CallStatus.CONSULT_RESERVED.getName();
				this.updateCallContactStateLine2(callStatusLine, conf);
				line2.setLastEventTimestampToCurrentTime();
				break;
			case AgentStateConstants.IDLE_CONSULTING:
				propertyType = CommandConstants.AGENT_PROPERTY_CHANGED;
				
				setConferenceStatus(agentSessionId, false);
				
				callData = formatShowableCalldata(conf);
				setUpCallContactLine2(conf);
				line2.setLastEventTimestampToCurrentTime();
				break;
				
			case AgentStateConstants.SUBSTATE_WRAP_UP:
				line1.setStatus(CallStatus.WRAP_UP.getName());
				line1.setLastEventTimestampToCurrentTime();
				break;
			case ChannelStateConstant.NOT_RESPONDING:
				line1.reset();
				break;
			case AgentStateConstants.WRAP_UP_CONSULT_RESERVED:
				this.updateCallContactStateLine2(CallStatus.CONSULT_RESERVED.getName(), conf);
				line2.setLastEventTimestampToCurrentTime();
				break;
			default:
				break;
		}

		LOGGER.debug("After processing subStatus: {}, Line1 current: {} and Line2 current: {}", 
				subState,
				line1.debugToString(), 
				line2.debugToString());

		return new AdaResponse(propertyType, jsonResponse.toString(), agentSessionId, callData);
	}

	/**
	 * @param agentSessionId
	 * @param status
	 */
	private void setConferenceStatus(final String agentSessionId, final boolean status) {
		final DesktopConfiguration config = configMap.getConfigForAgent(agentSessionId);

		config.getCallModel().setConferencing(status);
	}

	/**
	 * @param agent
	 * @param agentSessionId
	 * @return
	 * @throws InterpretationException
	 * @throws JSONException
	 */
	private JSONObject asJsonResponse(final Agent agent, final String agentSessionId) throws InterpretationException,
			JSONException {
		JSONObject jsonResponse = packageJsonData.getAgentStateUpdateJson(agent, agentSessionId);

		final DesktopConfiguration conf = configMap.getConfigForAgent(agentSessionId);
		if (conf == null) { return jsonResponse; }

		if (conf.getSubStatus().equals(AgentStateConstants.SUBSTATE_AVAILABLE)) {
			conf.getCallModel().setConferencing(false);
			conf.getCallModel().setHoldEnabled(false);
			conf.getCallModel().setConsulting(false);
		}

		jsonResponse.put(ContextConstants.PARAM_CALL_ON_HOLD_FLAG, "" + conf.getCallModel().isHoldEnabled());
		jsonResponse.put(ContextConstants.PARAM_CALL_CONFERENCING_FLAG, "" + conf.getCallModel().isConferencing());
		jsonResponse.put(ContextConstants.PARAM_PRIVACY_SHIELD_STATE, "" + conf.getCallModel().getPrivacyShieldState());
		setCallContactCallRecordingFlag(conf.getCallModel().getPrivacyShieldState(), conf);
		if (conf.getStateChangeData() != null) {
			jsonResponse.put(CallPropertyConstants.STANDARD_CALL_ID, conf.getStateChangeData().getCallId());
		}
		jsonResponse.put(CallPropertyConstants.STANDARD_CHANNEL_ID, agent.getChannelId());
		jsonResponse.put(CallPropertyConstants.STANDARD_CHANNEL_TYPE, agent.getChannelType());
 
		if (null != conf.getLastIdleAuxCode()) {
			jsonResponse.put(ContextConstants.PARAM_LAST_IDLE_CODE, conf.getLastIdleAuxCode().getId());
		}
		jsonResponse = SpringContextHelper.getBean(PropertiesUtil.class).getInitParamsAsJson(jsonResponse);
		return jsonResponse;
	}

	/**
	 * @param conf
	 * @return
	 */
	private String formatShowableCalldata(final DesktopConfiguration conf) {
		String callData = null;

		if (conf.getStateChangeData() != null && conf.getStateChangeData().getCallAssociatedData() != null) {
			final SortedMap<String, Data> dataMap = conf.getStateChangeData().getCallAssociatedData().getDataMap();
	   //ADA-WS BE should send all the variables to ADA-WS UI (So commenting the lines) and  ADA-WS UI enforces the suppressed list of variables while displaying
			//    final TreeMap<String, Data> filteredMap = new TreeMap<String, Data>();
			if (dataMap != null && !dataMap.isEmpty()) {
			  /*  final Iterator<String> itr = dataMap.keySet().iterator();
				while (itr.hasNext()) {
					final String key = itr.next();
					if (conf.getCallDataConfig().isAllowedKey(key)) {
						filteredMap.put(key, dataMap.get(key));
					}
				}*/

				callData = toJson(dataMap);
			}
		}

		return callData;
	}

	/**
	 * @param request
	 * @return
	 */
	private static String toJson(final SortedMap<String, Data> request) {
		// convert to json
		final Gson gson = new GsonBuilder().create();
		final String json = gson.toJson(request);

		return json;
	}
    
    private void loginOmniChannel(final String agentSessionId) {
        // Construct Request Body (payload) for transmission to ICX
	    	// 1.) Inject:
	    	//    1.) Session Id
	    	//    2.) Agent Id
	    	//    3.) Tenant Id
	    	//    4.) Ada BE's Persistent Callback URL
    		final DesktopConfiguration conf = configMap.getConfigForAgent(agentSessionId);
        
    		if (conf.isOmnichannelLoginPending()) { 
			if ((conf.getChannelCapability() != null) && 
	            (conf.getChannelCapability().hasAnyOmniChannelCapability())) {
	        		
		    		if (!conf.getChannelCapability().isChatChannelsLoggedIn() && 
		    				!conf.getChannelCapability().isEmailChannelsLoggedIn()) {	
		    	        	// Send Login Request to ICX
		        		String agentLoginRequestToIcx = OmniChannelCommonFrontendRequests.AGENT_LOGIN_REQUEST;
		        	    	long agentId = Long.valueOf(conf.getAgentId()).longValue();
		        	    	long tenantId = Long.valueOf(conf.getEnterpriseId()).longValue();
		        	    	String loginName = conf.getUserName();
		        	    	long emailChannels = conf.getChannelCapability().getEmailChannels();
		        	    	long chatChannels = conf.getChannelCapability().getChatChannels();
		        	    	long blendingMode = conf.getChannelCapability().getBlendingMode();
		        	    	//long teleChannels = conf.getChannelCapability().getTeleChannels();
		        	    LOGGER.info("Logging in user {} to OmniChannel", loginName);
		        	    	
		        	    	String requestToIcx = OmniChannelJsonUtil.injectSessionAgentTenantIdsAndCallbackUrlIntoRequest(
		        	    			agentSessionId,
		        	    			tenantId,
		        	    			agentId, 
		        	    			loginName,
		        	    			adaCallbackUrl, 
		        	    			agentLoginRequestToIcx,emailChannels,chatChannels, blendingMode);
		        	    	
		        	    	// Send message to ICX
		        	    	
		        	    	String response = null;
		        	    	try {
			        	    	LOGGER.info("{} :===>> OmniChannel Station login requested: {}", agentSessionId, requestToIcx);
			        	    	response = com.transerainc.adaws.connection.HttpUtil.doHttpJsonPost(conf.getOmniChannelUrl(), requestToIcx);
			        	    	LOGGER.info("{} :===> Response to Station login OmniChannel request : {} : ", agentSessionId, response);
			        	    	
			        	    	omniChannelUtilService.transmitDataToFrontend(
			        	    			response, 
			        	    			OmniChannelCommonCommandConstants.LOGIN_SUCCESS);	        	    	
			        	} catch (final Exception e) {  
		        	    		LOGGER.warn("Unable to login user {} to OmniChannels: {}", loginName, e.getMessage());
		    	        		// Send login failure/error to FE
		        	    		// inject session-id and agent-id in LOGIN_FAILED_RESPONSE
		        	    		String loginFailResponse = OmniChannelJsonUtil.injectBackendSessionIdAgentIdMessageIntoResponse(
		        	    			OmniChannelCommonConstants.LOGIN_FAILED_RESPONSE1, 
		        	    			agentSessionId,
		    	    				Long.valueOf(conf.getAgentId()),
		    	    				e.getMessage());
		        	    		omniChannelUtilService.transmitDataToFrontend(
			        				loginFailResponse,
			        				OmniChannelCommonCommandConstants.LOGIN_SUCCESS);
		        	    	}
		        	    	conf.setOmnichannelLoginPending(false);
		        	    	conf.setPendingLoginAdaRequest(null);
		    		} else {
		        		LOGGER.info("User {} already logged into OmniChannel", conf.getUserName());
		        }
			} else {
        			LOGGER.info("User {} doesn't have OmniChannel capabilities", conf.getUserName());
			}
    		} else {
        		LOGGER.info("User {} already logged into OmniChannel", conf.getUserName());
        }
    }

	private void resetCallContactLines(final String subState, final LineData1 line1, final LineData2 line2) {
		LOGGER.debug(
						"BEFORE CallContact Line1 'Exit', invoking resetCallContactLines(), "		+ 
						"AgentCommand subState: {}, "												+ 
						"state of Line1 of CallContact: {} "										+ 
						"and state of Line2 of CallContact: {}",
						subState,
						line1.debugToString(), 
						line2.debugToString());
		if (
				(line1 != null)													&& 
				(line2 != null)													&& 
				(line2.getCallId() != null)										&& 
				(line1.getCallId() != null)										&& 
				(line1.getCallId().getValue().equals(line2.getCallId().getValue()))
			) {
			line2.reset();
		}
		line1.reset();
		LOGGER.debug(
				"AFTER CallContact Line1 'Exit', invoking resetCallContactLines(), "		+ 
				"AgentCommand subState: {}, "												+ 
				"state of Line1 of CallContact: {} "										+ 
				"and state of Line2 of CallContact: {}",
				subState,
				line1.debugToString(), 
				line2.debugToString());
	}

	private void setUpCallContactLine1(final DesktopConfiguration conf) {
		LOGGER.debug("Setting up Line1 of CallContact with DesktopConfiguration: {}",
				conf);

		if (conf == null) {
			LOGGER.warn("{} ===>> DesktopConfiguration is null.");
			return;
		}

		CallContact callContact = conf.getCallContact();

		callContact.setAgentId(Long.valueOf(conf.getAgentId()));
		LineData1 line1 = callContact.getLine1();
		line1.reset();
		if (conf.getStateChangeData() != null && conf.getStateChangeData().getCallAssociatedData() != null) {
			final SortedMap<String, Data> dataMap = conf.getStateChangeData().getCallAssociatedData().getDataMap();
			line1.setDataMap(dataMap);
			LOGGER.debug("CallContact Line1 'Entry', line1 set up: {}, with dataMap: {}",
					callContact.debugToString(),
					dataMap.toString());
		} else {
			LOGGER.debug("CallContact Line1 'Entry', line1 set up: {}, but dataMap is null or empty.",
					callContact.debugToString());
		}
	}

	private void setUpCallContactLine2(final DesktopConfiguration conf) {
		LOGGER.debug("Setting up Line2 of CallContact with DesktopConfiguration: {}",
				conf);

		if (conf == null) {
			LOGGER.warn("{} ===>> DesktopConfiguration is null.");
			return;
		}

		CallContact callContact = conf.getCallContact();

		callContact.setAgentId(Long.valueOf(conf.getAgentId()));
		LineData2 line2 = callContact.getLine2();
		line2.reset();
		if (conf.getStateChangeData() != null && conf.getStateChangeData().getCallAssociatedData() != null) {
			final SortedMap<String, Data> dataMap = conf.getStateChangeData().getCallAssociatedData().getDataMap();
			line2.setDataMap(dataMap);
			LOGGER.debug("CallContact Line2 'Entry', line2 set up: {}, with dataMap: {}",
					callContact.debugToString(),
					dataMap.toString());
		} else {
			LOGGER.debug("CallContact Line2 'Entry', line2 set up: {}, but dataMap is null or empty.",
					callContact.debugToString());
		}
	}

	private void updateCallContactStateLine2(final String lineCallStatus, final DesktopConfiguration conf) {
		CallContact callContact = conf.getCallContact();
		LineData2 line2 = callContact.getLine2();
		line2.setStatus(lineCallStatus);
		LOGGER.debug("Line2 updated status to: {}, of CallContact: {}",
				line2.getStatus(),
				callContact.debugToString());
	}

	private void setCallContactCallRecordingFlag(final int privacyShieldState, final DesktopConfiguration conf) {
		CallContact callContact = conf.getCallContact();
		LineData1 line1 = callContact.getLine1();
		boolean callRecordingFlag = (CallStateConstants.SHIELD_ON == privacyShieldState);
		line1.setCallRecording(callRecordingFlag);
		LOGGER.debug("Line1 updated CallRecording flag to: {}, of CallContact: {}",
				line1.isCallRecording(),
				callContact.debugToString());
	}

}
