package com.transerainc.adaws.command;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.AgentStateConstants;
import com.transerainc.adaws.constants.CallPropertyConstants;
import com.transerainc.adaws.constants.ChannelStateConstant;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.model.CallAssociatedData;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.TacgResponse;
import com.transerainc.adaws.service.AuthenticationService;
import com.transerainc.adaws.util.StringUtils;
import com.transerainc.aha.gen.agent.AgentDocument.Agent;
import com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage;

/**
 * @author rajeev.lochanam
 */
@Component
public class StateUpdateCommand implements AgentStateConstants {
	private static Logger LOGGER = LoggerFactory.getLogger(StateUpdateCommand.class.getName());

	@Autowired
	private CommandMessageCommand commandMessageCommand;

	@Autowired
	private DesktopConfigManager configMap;

	@Autowired
	private AuthenticationService autService;

	/**
	 * @param elem
	 * @param agentSessionId
	 */
	public void processData(final TacgResponse tacgResp) {
		final Agent agent = tacgResp.getAgentList().getAgentArray(0);
		final String agentSessionId = tacgResp.getAgentSessionId();

		long startTime = 0;
		if (LOGGER.isDebugEnabled()) {
			startTime = System.currentTimeMillis();
			LOGGER.debug(agentSessionId + " ===>> Starting state update process : " + startTime);
		}

		LOGGER.info("Processing TACG message: {}", tacgResp);

		final DesktopConfiguration conf = configMap.getConfigForAgent(agentSessionId);
		if (conf != null) {
			final String oldState = conf.getSubStatus();
			conf.setStatus(agent.getStatus() != null ? agent.getStatus().toString() : "");

			final String subState = agent.getSubStatus() != null ? agent.getSubStatus().toString() : "";

			LOGGER.info("Request new SubStatus/SubState: {}, for current SubStatus/SubState: {}, for BE agentSessionId: {}",
					subState,
					conf.getSubStatus(),
					agentSessionId);

			conf.setConnectedConsultReserved(false);

			switch (subState) {
				case ChannelStateConstant.CONNECTED_CONSULT_RESERVED:
					if (conf.isConferenceByThis()) {
						conf.setSubStatus(ChannelStateConstant.CONSULT_RESERVED);
					} else {
						conf.setSubStatus(ChannelStateConstant.CONNECTED_CONSULT_RESERVED);
					}
					conf.setRoutedCallId(conf.getStateChangeData() != null ? conf.getStateChangeData().getCallId() : null);
					conf.setConnectedConsultReserved(true);
					break;
				case ChannelStateConstant.CONNECTED_CONSULTING:
					conf.setSubStatus(ChannelStateConstant.CONNECTED_CONSULTING);
					break;
				case ChannelStateConstant.AVAILABLE_CONSULTING:
					conf.setSubStatus(ChannelStateConstant.CONSULTING);
					break;
				case AgentStateConstants.SUBSTATE_RINGING:
					conf.setSubStatus(subState);
					conf.getStateChangeData().clearCallAssociatedData();
					break;
				default:
					conf.setSubStatus(subState);
					LOGGER.info("Default switch-case handled for SubStatus/SubState: {}, for BE agentSessionId: {}",
							subState,
							agentSessionId);
			}

			conf.setAgentId(agent.getAgentId());
			conf.getStateChangeData().setPositionId(agent.getPositionId());

			if (!conf.isPositionSet()) {
				conf.setTeamId(agent.getTeamId());
				conf.setDn(agent.getDn());

				// position id is ignored.
				conf.setPositionSet(true);
			}

			String reason = agent.getReason();
			if (reason != null) {
				try {
					reason = URLDecoder.decode(reason, AdaConstants.UTF_8);
				} catch (final UnsupportedEncodingException e) {
					// leave reason as is
				}
			}

			if (STATE_LOGGED_OUT.equals(conf.getStatus()) || STATE_LOGOUT.equals(conf.getStatus())) {
				autService.requestLogoutWithReason(agentSessionId, reason);
				return;
			}

			LOGGER.info("Processing for current Status/State: {}, for BE agentSessionId: {}",
					conf.getStatus(),
					agentSessionId);

			switch (conf.getStatus()) {
				case STATE_LOGIN:
					LOGGER.warn(agentSessionId + " ===>> Ignoring message with " + conf.getStatus() + " status ");
					break;
				case STATE_LOGGED_IN:
					if (isPrivacyShieldParametersRelevant(oldState, conf.getSubStatus())) {
						boolean pauseResumeEnabled = false;
						if (agent.getEnablePauseResume()) {
							pauseResumeEnabled = agent.getEnablePauseResume();
						}
						if (pauseResumeEnabled) {
							conf.getCallModel().setPrivacyShieldEnabled(true);
							conf.getCallModel().setPrivacyShieldOn(false);
							conf.getCallModel().setPrivacyShieldDuration(agent.getPauseDuration());
						}
					}
		
					processStateLoggedin(agent, agentSessionId, conf, reason);
		
					if (outdialFailedTransitionCheck(oldState, conf.getSubStatus(), conf.isOutdialCall())) {
						autService.errorOccurred(ContextConstants.ERROR_OUTDIAL_GENERIC_ERROR, "Outdial failed.",
								agentSessionId);
						conf.reset();
					}
					break;
				default:
					// Ignore
					LOGGER.warn(agentSessionId + " ===>> Illegal state");
			}

			if (LOGGER.isDebugEnabled()) {
				final long endTime = System.currentTimeMillis() - startTime;
				LOGGER.debug(agentSessionId + " ===>> Finished state update process : " + endTime);
			}
		} else {
			LOGGER.debug("DesktopConfiguration is null for BE AgentSessionId: {}", 
					agentSessionId);
		}
	}

	/**
	 * @param oldState
	 * @param newState
	 * @param isOutdialCall
	 * @return
	 */
	private boolean outdialFailedTransitionCheck(final String oldState, final String newState,
			final boolean isOutdialCall) {
		return (oldState.equals(AgentStateConstants.RESERVED) || oldState.equals(AgentStateConstants.OUTDIAL_RESERVED))
				&& newState.equals(AgentStateConstants.WRAP_UP) && isOutdialCall;
	}

	/**
	 * @param agent
	 * @param agentSessionId
	 * @param conf
	 * @param reason
	 */
	private void processStateLoggedin(final Agent agent, final String agentSessionId, final DesktopConfiguration conf,
			final String reason) {
		if (agent.getCallId() != null) {
			conf.getStateChangeData().setCallId(agent.getCallId());
		}

		if (LOGGER.isInfoEnabled()) {
			String s = "Updating state to: " + conf.getStatus() + ", " + conf.getSubStatus();
			if (!StringUtils.isEmpty(s)) {
				s += " (" + reason + ")";
			}
			LOGGER.info(agentSessionId + " ===>> " + s);
		}

		final String vteamId = agent.getVirtualTeamId();
		if (StringUtils.isNotEmpty(vteamId)) {
			if (conf.getCallModel() != null) {
				conf.getCallModel().setVteamId(vteamId);
			}
		}
		// Process command message, if any
		final CommandMessage commandMessage = agent.getCommandMessage();
		if (commandMessage != null) {
			commandMessageCommand.processData(commandMessage, conf, agent.getCallId());
		} else if (agent.getCallId() != null) {
			commandMessageCommand.processData(agent.getCallId(), conf);
			if (conf.getStateChangeData() != null && conf.getStateChangeData().getCallAssociatedData() != null) {
				if (conf.getStateChangeData().getCallAssociatedData().getDataMap() != null
						&& !conf.getStateChangeData().getCallAssociatedData().getDataMap().isEmpty()) {
					final CallAssociatedData.Data data = conf.getStateChangeData().getCallAssociatedData().getDataMap()
							.get(CallPropertyConstants.CALL_ID);
					if (data != null) {
						conf.getStateChangeData().getCallAssociatedData()
								.putData(data.getId(), data.getName(), agent.getCallId(), data.isEditable());
					}

					final CallAssociatedData.Data connectionIdData = conf.getStateChangeData().getCallAssociatedData()
							.getDataMap().get(CallPropertyConstants.CONNECTION_ID);
					if (connectionIdData != null) {
						conf.getStateChangeData()
								.getCallAssociatedData()
								.putData(connectionIdData.getId(), connectionIdData.getName(),
										conf.getStateChangeData().getConnectionId(), connectionIdData.isEditable());
					}

					final CallAssociatedData.Data sendIdData = conf.getStateChangeData().getCallAssociatedData()
							.getDataMap().get(CallPropertyConstants.SEND_ID);
					if (sendIdData != null) {
						conf.getStateChangeData()
								.getCallAssociatedData()
								.putData(sendIdData.getId(), sendIdData.getName(),
										conf.getStateChangeData().getSendId(), sendIdData.isEditable());
					}
				}
			}
		}

		if (agent.getCallId() != null) {
			conf.getStateChangeData().setCallId(agent.getCallId());
		}

	}

	/**
	 * @param oldState
	 * @param newState
	 * @return
	 */
	private boolean isPrivacyShieldParametersRelevant(final String oldState, final String newState) {
		if (newState.equals(AgentStateConstants.CONNECTED)) { return oldState.equals(AgentStateConstants.RESERVED)
				|| oldState.equals(AgentStateConstants.OUTDIAL_RESERVED) || !hasRoutedCall(oldState); }
		return false;
	}

	public boolean hasRoutedCall(final String state) {

		switch (state) {
		case AVAILABLE_CONSULTING:
		case AVAILABLE_CONSULT_RESERVED:
		case AVAILABLE:
		case CONNECTED_CONSULTING:
		case CONNECTED_CONSULT_RESERVED:
		case CONNECTED:
		case CONSULTING:
		case CONSULT_RESERVED:
		case IDLE_CONSULTING:
		case IDLE_CONSULT_RESERVED:
		case IDLE:
		case NOT_REACHABLE:
		case NOT_RESPONDING:
			return false;

			// return true for the below states
			/*
			 * case OUTDIAL_RESERVED:
			 * case RESERVED:
			 * case WRAP_UP_CONSULTING:
			 * case WRAP_UP_CONSULT_RESERVED:
			 * case WRAP_UP:
			 * return true;
			 */
		}

		return true;
	}

}
