/**
 * 
 */
package com.transerainc.adaws.command;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.AgentStateConstants;
import com.transerainc.adaws.constants.CallPropertyConstants;
import com.transerainc.adaws.constants.CallStateConstants;
import com.transerainc.adaws.constants.ChannelStateConstant;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.CallAssociatedData;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.PeerAgent;
import com.transerainc.adaws.model.TacgResponse;
import com.transerainc.adaws.model.cache.contact.call.CallContact;
import com.transerainc.adaws.model.cache.contact.call.LineData1;
import com.transerainc.adaws.service.AgentStateService;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.SpringContextHelper;
import com.transerainc.adaws.util.StringUtils;
import com.transerainc.adaws.util.WebSocketDataPublisher;
import com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand;
import com.transerainc.aha.gen.agent.ParamDocument.Param;

/**
 * @author rajeev.lochanam
 */
@Component
public class InternalRoutingCommand {
	static Logger LOGGER = LoggerFactory.getLogger(InternalRoutingCommand.class.getName());

	@Autowired
	private DesktopConfigManager configMap;

	@Autowired
	private AgentStateService agentStateService;

	@Autowired
	private WebSocketDataPublisher dataPublisher;

	@Autowired
	private WebSocketCacheManager webSocketCacheManager;

	/**
	 * @param tacgResp
	 * @return
	 * @throws JSONException
	 */
	public AdaResponse processHoldUnholdResponse(final TacgResponse tacgResp) throws JSONException {
		final String agentSessionId = tacgResp.getAgentSessionId();
		final String error = tacgResp.getError();

		final DesktopConfiguration config = configMap.getConfigForAgent(agentSessionId);
		JSONObject jsonResponse = new JSONObject();
		String jsMethod = CommandConstants.UPDATE_CALL_STATE;
		if (null != config) {
			if (null == error) {
				setHoldStatus(agentSessionId, tacgResp.isHoldFalg());

				tacgResp.setHoldFalg(false);
				processConferenceStatus(tacgResp);

				jsonResponse.put(ContextConstants.PARAM_CALL_ON_HOLD_FLAG, "" + config.getCallModel().isHoldEnabled());
				jsonResponse.put(ContextConstants.PARAM_CALL_CONFERENCING_FLAG, ""
						+ config.getCallModel().isConferencing());
				jsonResponse.put(ContextConstants.PARAM_PRIVACY_SHIELD_STATE, ""
						+ config.getCallModel().getPrivacyShieldState());
				setCallContactCallRecordingFlag(config.getCallModel().getPrivacyShieldState(), config);
				if (tacgResp.getAgentCommand().getName().trim().equals(CallStateConstants.HOLD_DONE)) {
					if (config.getStateChangeData() != null
							&& config.getStateChangeData().getCallAssociatedData() != null) {
						if (config.getStateChangeData().getCallAssociatedData().getDataMap() != null
								&& !config.getStateChangeData().getCallAssociatedData().getDataMap().isEmpty()) {
							final CallAssociatedData.Data data = config.getStateChangeData().getCallAssociatedData()
									.getDataMap().get(CallPropertyConstants.CALL_ID);
							if (data != null) {
								config.getStateChangeData()
										.getCallAssociatedData()
										.putData(data.getId(), data.getName(), tacgResp.getAgentCommand().getCallId(),
												data.isEditable());
							}
						}
					}
				}

				final String tokenClient = webSocketCacheManager.getToken(agentSessionId);
				AdaResponse response = new AdaResponse(jsMethod, jsonResponse.toString(), tokenClient);

				dataPublisher.publishData(response);

				if (config.getCallModel().isConsulting()) {
					jsonResponse.put(ContextConstants.AGENT_INTERNAL_ROUTED_CALL_ON_HOLD, ""
							+ !config.getCallModel().isHoldEnabled());
					response = new AdaResponse(jsMethod, jsonResponse.toString(),
							webSocketCacheManager.getToken(agentSessionId));

					dataPublisher.publishData(response);
				}
				/*
				LOGGER.info("{} Reloading - waiting for close : {} and is agent state in reloading : {}", tokenClient,
						eventCacheManager.waitingForClose(tokenClient), eventCacheManager.isStatesQueueing(tokenClient));
				if (eventCacheManager.waitingForClose(tokenClient) || eventCacheManager.isStatesQueueing(tokenClient)) {
					LOGGER.info("{} Reloading - caching (queuing) the agent state : {}", tacgResp.getAgentSessionId(),
							response);
					eventCacheManager.setQueueStates(tokenClient, response);
				}
				*/
				return null;
			} else {
				jsMethod = CommandConstants.ERROR_OCCURRED;

				int errorCode = ContextConstants.ERROR_UNHOLD;
				if (tacgResp.isHoldFalg()) {
					errorCode = ContextConstants.ERROR_HOLD;
				}

				jsonResponse.put(AdaConstants.CODE, String.valueOf(errorCode));
				jsonResponse.put(AdaConstants.DETAIL, error);
			}
			jsonResponse = SpringContextHelper.getBean(PropertiesUtil.class).getInitParamsAsJson(jsonResponse);
		}

		return new AdaResponse(jsMethod, jsonResponse.toString(), agentSessionId);
	}

	/**
	 * @param tacgResp
	 * @return
	 * @throws JSONException
	 */
	public AdaResponse processConferenceResponse(final TacgResponse tacgResp) throws JSONException {
		final String agentSessionId = tacgResp.getAgentSessionId();
		JSONObject jsonResponse = new JSONObject();
		String jsMethod = CommandConstants.CALL_STATE_CONFERENCED;

		final DesktopConfiguration config = configMap.getConfigForAgent(agentSessionId);
		if (null != config) {
			if (null == tacgResp.getError()) {
				setHoldStatus(agentSessionId, tacgResp.isHoldFalg());

				tacgResp.setHoldFalg(true);
				processConferenceStatus(tacgResp);

				jsonResponse.put(ContextConstants.PARAM_CALL_ON_HOLD_FLAG, "" + config.getCallModel().isHoldEnabled());
				jsonResponse.put(ContextConstants.PARAM_CALL_CONFERENCING_FLAG, ""
						+ config.getCallModel().isConferencing());
				jsonResponse.put(ContextConstants.PARAM_PRIVACY_SHIELD_STATE, ""
						+ config.getCallModel().getPrivacyShieldState());
				setCallContactCallRecordingFlag(config.getCallModel().getPrivacyShieldState(), config);

				jsonResponse.put(ContextConstants.PARAM_SUB_STATE, ChannelStateConstant.CONSULTING);
			} else {
				jsMethod = CommandConstants.ERROR_OCCURRED;

				int errorCode = ContextConstants.ERROR_UNHOLD;
				if (tacgResp.isHoldFalg()) {
					errorCode = ContextConstants.ERROR_HOLD;
				}

				jsonResponse.put(AdaConstants.CODE, String.valueOf(errorCode));
				jsonResponse.put(AdaConstants.DETAIL, tacgResp.getError());
			}
			jsonResponse = SpringContextHelper.getBean(PropertiesUtil.class).getInitParamsAsJson(jsonResponse);
		}

		return new AdaResponse(jsMethod, jsonResponse.toString(), agentSessionId);
	}

	/**
	 * @param tacgResp
	 * @return
	 */
	public AdaResponse processConferenceStatus(final TacgResponse tacgResp) {
		final DesktopConfiguration config = configMap.getConfigForAgent(tacgResp.getAgentSessionId());

		config.getCallModel().setConferencing(tacgResp.isHoldFalg());

		// Method is to update the config. No response will be send to UI
		return null;
	}

	/**
	 * @param tacgResp
	 * @return
	 */
	public AdaResponse processConsultErrorResponse(final TacgResponse tacgResp) {
		final String message = tacgResp.getErrorMessage() + " ";
		final String errorCode = tacgResp.getErrorCode();

		final AgentCommand agentCommand = tacgResp.getAgentCommand();
		final String agentSessionId = tacgResp.getAgentSessionId();

		final String callId = StringUtils.isEmpty(agentCommand.getCallId()) ? "" : agentCommand.getCallId();
		String reason = getFailureReason(agentCommand.getReason());

		if (!org.springframework.util.StringUtils.hasText(reason)) {
			reason = "unknown";
		}
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(agentSessionId + message + ". Reason -  " + reason + " callId: " + callId);
		}

		final StringBuffer msg = new StringBuffer(message);
		msg.append("(" + reason + ")");
		msg.append("\n Call Session Id : ").append(callId);
		msg.append("\n Agent Session Id : ").append(agentSessionId);

		final DesktopConfiguration config = configMap.getConfigForAgent(agentSessionId);

		if (config.getStateChangeData().getCallAssociatedData() != null
				&& !config.getStateChangeData().getCallAssociatedData().getDataMap().isEmpty()) {
			if (config.getStateChangeData().getCallAssociatedData().getData("virtualTeamId") != null) {
				final String strQueueId = config.getStateChangeData().getCallAssociatedData().getData("virtualTeamId")
						.getValue();
				if (StringUtils.isNotEmpty(strQueueId)) {
					msg.append("\n Queue Id : ").append(strQueueId);
				}
			}
		}

		msg.append("\n Agent Id : ").append(config.getAgentId());

		final JSONObject jsonResponse = new JSONObject();
		try {
			if (msg != null) {
				jsonResponse.put(AdaConstants.CODE, errorCode);
				jsonResponse.put(AdaConstants.DETAIL, msg.toString());
			}
		} catch (final JSONException e) {
			LOGGER.error("Exception occured while forming json string on response command condition." + e);
		}

		AdaResponse adaResponse = null;

		if (config.isServiceRequested()) {
			adaResponse = new AdaResponse(CommandConstants.ERROR_OCCURRED, jsonResponse.toString(), agentSessionId);
			config.reset();

			// Bug 17835 - Agent state changed to connected but the caller is in MOH after End Consult.
			if (config.getCallModel() != null) {
				config.getCallModel().setHoldEnabled(true);
			}
		} else {
			config.reset();
		}

		return adaResponse;
	}

	/**
	 * @param tacgResp
	 * @return
	 */
	public AdaResponse processTransferErrorResponse(final TacgResponse tacgResp) {
		final String message = tacgResp.getErrorMessage() + " ";
		final String errorCode = tacgResp.getErrorCode();

		final AgentCommand agentCommand = tacgResp.getAgentCommand();
		final String agentSessionId = tacgResp.getAgentSessionId();

		final String callId = StringUtils.isEmpty(agentCommand.getCallId()) ? "" : agentCommand.getCallId();
		String reason = getFailureReason(agentCommand.getReason());

		if (!org.springframework.util.StringUtils.hasText(reason)) {
			reason = "unknown";
		}
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(agentSessionId + message + ". Reason -  " + reason + " callId: " + callId);
		}

		final StringBuffer msg = new StringBuffer(message);
		msg.append("(" + reason + ")");
		msg.append("\n Call Session Id : ").append(callId);
		msg.append("\n Agent Session Id : ").append(agentSessionId);

		final DesktopConfiguration config = configMap.getConfigForAgent(agentSessionId);
		if (config.getStateChangeData().getCallAssociatedData() != null
				&& config.getStateChangeData().getCallAssociatedData().getData("virtualTeamId") != null) {
			final String strQueueId = config.getStateChangeData().getCallAssociatedData().getData("virtualTeamId")
					.getValue();
			if (StringUtils.isNotEmpty(strQueueId)) {
				msg.append("\n Queue Id : ").append(strQueueId);
			}
		}
		msg.append("\n Agent Id : ").append(config.getAgentId());

		final JSONObject jsonResponse = new JSONObject();
		try {
			if (msg != null) {
				jsonResponse.put(AdaConstants.CODE, errorCode);
				jsonResponse.put(AdaConstants.DETAIL, msg.toString());
			}
		} catch (final JSONException e) {
			LOGGER.error("Exception occured while forming json string on response command condition." + e);
		}

		// To handle transfer-error for inbound/outdial calls when the transferred agent is available/unavailable
		AdaResponse adaResponse = null;
		boolean transferedToAnotherAgent = false;
		if (agentCommand.getCommandMessage() != null && agentCommand.getCommandMessage().getParamArray().length > 0) {
			for (final Param param : agentCommand.getCommandMessage().getParamArray()) {
				if (param.getName().equals("agentId")) {
					transferedToAnotherAgent = true;
				}
			}
			if (transferedToAnotherAgent) {
				String transferredAgentId = null;
				for (final Param param : agentCommand.getCommandMessage().getParamArray()) {
					if (param.getName().equals("agentId")) {
						transferredAgentId = param.getValue();
					}
				}
				if (!agentCommand.getAgentId().equals(transferredAgentId)) {
					adaResponse = new AdaResponse(CommandConstants.ERROR_OCCURRED, jsonResponse.toString(),
							agentSessionId);
				}
			}
		} else {
			if (config.isServiceRequested()) {
				adaResponse = new AdaResponse(CommandConstants.ERROR_OCCURRED, jsonResponse.toString(), agentSessionId);
			}
		}

		if (adaResponse != null) {
			config.reset();
		}

		return adaResponse;
	}

	/**
	 * @param tacgResp
	 * @return
	 */
	public AdaResponse processCtqResponse(final TacgResponse tacgResp) {
		final String jsMethod = CommandConstants.CTQ_READY;

		final AgentCommand agentCommand = tacgResp.getAgentCommand();
		final String agentSessionId = tacgResp.getAgentSessionId();

		final PeerAgent peerAgent = new PeerAgent();

		peerAgent.setDn(StringUtils.isEmpty(agentCommand.getPeerDn()) ? "" : agentCommand.getPeerDn());
		peerAgent.setTeamId(StringUtils.isEmpty(agentCommand.getPeerTeamId()) ? "" : agentCommand.getPeerTeamId());
		peerAgent.setAgentId(StringUtils.isEmpty(agentCommand.getPeerAgentId()) ? "" : agentCommand.getPeerAgentId());
		peerAgent.setChannelId(StringUtils.isEmpty(agentCommand.getPeerChannelId()) ? "" : agentCommand
				.getPeerChannelId());
		peerAgent.setChannelType(StringUtils.isEmpty(agentCommand.getPeerChannelType()) ? "" : agentCommand
				.getPeerChannelType());
		peerAgent.setSessionId(StringUtils.isEmpty(agentCommand.getPeerAgentSessionId()) ? "" : agentCommand
				.getPeerAgentSessionId());

		final DesktopConfiguration config = configMap.getConfigForAgent(agentSessionId);
		config.setPeerAgentDetails(peerAgent);

		return new AdaResponse(jsMethod, "", tacgResp.getAgentSessionId());
	}

	/**
	 * @param tacgResp
	 * @return
	 */
	public AdaResponse processConsultEnded(final TacgResponse tacgResp) {

		resetAll(tacgResp);

		return null;
	}

	/**
	 * @param tacgResp
	 * @return
	 */
	public AdaResponse processTransferred(final TacgResponse tacgResp) {
		resetAll(tacgResp);

		return null;
	}

	/**
	 * @param tacgResp
	 * @return
	 */
	public AdaResponse processTransferDone(final TacgResponse tacgResp) {
		resetAll(tacgResp);

		return null;
	}

	/**
	 * @param tacgResp
	 * @return
	 */
	public AdaResponse processCallEnded(final TacgResponse tacgResp) {

		final DesktopConfiguration conf = configMap.getConfigForAgent(tacgResp.getAgentSessionId());
		final AdaResponse adaResponse = null;

		// Not resetting isOutdialCall flag - To display Outdial failed message on CallEnd during outdial reserved state
		// and not during connected state. Reset is done after outdial failed message in this case.
		if (!(conf.isOutdialCall() && (conf.getSubStatus().equals(AgentStateConstants.RESERVED) || conf.getSubStatus()
				.equals(AgentStateConstants.OUTDIAL_RESERVED)))) {
			resetAll(tacgResp);
		}

		return adaResponse;
	}

	/**
	 * @param reason
	 * @param conf
	 * @return
	 */
	protected boolean errorDisplay(final String reason, final DesktopConfiguration conf) {
		boolean result = true;
		if (conf.getStateChangeData() != null && conf.getStateChangeData().getCallAssociatedData() != null) {
			final Map<String, String> callData = conf.getStateChangeData().getCallAssociatedData().getKeyValueMap();
			if (callData != null && !callData.isEmpty()) {
				final String value = callData.get("reason");
				if (reason.equals(value)) {
					result = false;
				}
			}
		}
		return result;
	}

	/**
	 * @param tacgResp
	 * @return
	 */
	public AdaResponse processConsultDone(final TacgResponse tacgResp) {
		final DesktopConfiguration config = configMap.getConfigForAgent(tacgResp.getAgentSessionId());
		boolean holdEnabled = false;

		// unhold doesn't work if hold is enabled after ctq-end
		if (config.getCallModel() != null
				&& !config.getCallModel().isCtqCancel()) {
			holdEnabled = true;
		}

		resetAll(tacgResp);

		// Bug 17835 - Agent state changed to connected but the caller is in MOH after End Consult.
		// Also checking if the state is not available (ctq - reload before accepting ctq - ctq cancel
		// will be fired. agent2 will be available and consult done and hence not setting on hold.
		if (!config.getSubStatus().equals(AgentStateConstants.AVAILABLE)
				&& config.getCallModel() != null && holdEnabled) {
			config.getCallModel().setHoldEnabled(true);
		}
		return null;
	}

	/**
	 * @param tacgResp
	 * @return
	 */
	public AdaResponse processConsultTransfer(final TacgResponse tacgResp) {
		resetAll(tacgResp);

		return null;
	}

	/**
	 * @param tacgResp
	 * @return
	 */
	public AdaResponse processRequestRejected(final TacgResponse tacgResp) {
		boolean returnResult = true;
		if (tacgResp.getAgentCommand() != null) {
			tacgResp.getAgentCommand().getCallId();
			final String sessionId = tacgResp.getAgentSessionId();

			final DesktopConfiguration dc = configMap.getConfigForAgent(sessionId);

			if (dc != null && dc.getStateChangeData() != null) {
				if (!tacgResp.getAgentCommand().getCallId().equals(dc.getStateChangeData().getCallId())) {
					final CallAssociatedData temp = dc.getStateChangeData().getCallAssociatedData();
					temp.getKeyValueMap();
					dc.setOutdialCallCheck(false);
					returnResult = false;
				}
			}
		}

		if (!returnResult) { return null; }

		sendLastIdle(tacgResp.getAgentSessionId());

		tacgResp.setErrorMessage("Outdial Rejected");
		tacgResp.setErrorCode(String.valueOf(ContextConstants.ERROR_OUTDIAL_REJECTED));

		resetAll(tacgResp);

		return processOutdialErrorResponse(tacgResp);
	}

	/**
	 * @param agentSessionId
	 */
	private void sendLastIdle(final String agentSessionId) {
		agentStateService.requestStateChange(AgentStateConstants.LOGGED_IN, AgentStateConstants.IDLE, agentSessionId);
	}

	/**
	 * @param tacgResp
	 * @return
	 */
	public AdaResponse processRequestReject(final TacgResponse tacgResp) {
		tacgResp.setErrorMessage("Outdial Reject");
		tacgResp.setErrorCode(String.valueOf(ContextConstants.ERROR_OUTDIAL_GENERIC_ERROR));

		resetAll(tacgResp);

		return processOutdialErrorResponse(tacgResp);
	}

	/**
	 * @param tacgResp
	 * @return
	 */
	public AdaResponse processOutdialErrorResponse(final TacgResponse tacgResp) {
		final String message = tacgResp.getErrorMessage() + " ";
		final String errorCode = tacgResp.getErrorCode();

		final AgentCommand agentCommand = tacgResp.getAgentCommand();
		final String agentSessionId = tacgResp.getAgentSessionId();

		final String callId = StringUtils.isEmpty(agentCommand.getCallId()) ? "" : agentCommand.getCallId();
		String reason = getFailureReason(agentCommand.getReason());

		final DesktopConfiguration config = configMap.getConfigForAgent(agentSessionId);
		config.reset();

		if (!org.springframework.util.StringUtils.hasText(reason)) {
			reason = "unknown";
		}
		LOGGER.info(agentSessionId + " ===>> " + message + ". Reason -  " + reason + " callId: " + callId);

		final JSONObject jsonResponse = new JSONObject();
		try {
			if (message != null) {
				jsonResponse.put(AdaConstants.CODE, errorCode);
				jsonResponse.put(AdaConstants.DETAIL, message);
			}
		} catch (final JSONException e) {
			LOGGER.error("Exception occured while forming json string on response command condition." + e);
		}

		return new AdaResponse(CommandConstants.ERROR_OCCURRED, jsonResponse.toString(), agentSessionId);
	}

	/**
	 * @param tacgResp
	 */
	protected void resetAll(final TacgResponse tacgResp) {
		final DesktopConfiguration config = configMap.getConfigForAgent(tacgResp.getAgentSessionId());
		config.reset();
	}

	/**
	 * @param config
	 * @param holdFlag
	 */
	private void setHoldStatus(final String agentSessionId, final boolean holdFlag) {
		final DesktopConfiguration config = configMap.getConfigForAgent(agentSessionId);

		config.getCallModel().setHoldEnabled(holdFlag);
	}

	/**
	 * @param reason
	 * @return
	 */
	private String getFailureReason(String reason) {
		if (reason != null) {
			try {
				reason = URLDecoder.decode(reason, "UTF-8");
			} catch (final UnsupportedEncodingException e) {
				// leave reason as is
			}
		}
		return reason;
	}

	private void setCallContactCallRecordingFlag(final int privacyShieldState, final DesktopConfiguration conf) {
		if (conf == null) {
			LOGGER.warn("DesktopConfiguration is null");
			return;
		}

		CallContact callContact = conf.getCallContact();
		LineData1 line1 = callContact.getLine1();
		boolean callRecordingFlag = (CallStateConstants.SHIELD_ON == privacyShieldState);
		line1.setCallRecording(callRecordingFlag);
		LOGGER.debug("Line1 updated CallRecording flag to: {}, of CallContact: {}",
				line1.isCallRecording(),
				callContact.debugToString());
	}
}
