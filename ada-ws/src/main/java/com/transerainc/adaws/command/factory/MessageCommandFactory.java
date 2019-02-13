package com.transerainc.adaws.command.factory;

import java.util.SortedMap;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.command.InternalRoutingCommand;
import com.transerainc.adaws.command.OutdialCommand;
import com.transerainc.adaws.command.PrivacyShieldCommand;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.CallStateConstants;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.exception.InterpretationException;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.CallAssociatedData.Data;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.TacgResponse;
import com.transerainc.adaws.model.cache.contact.call.CallContact;
import com.transerainc.adaws.model.cache.contact.call.CallStatus;
import com.transerainc.adaws.model.cache.contact.call.LineData1;
import com.transerainc.adaws.model.cache.contact.call.LineData2;
import com.transerainc.adaws.util.XbeanHelper;
import com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand;

@Component
public class MessageCommandFactory implements CallStateConstants {

	private static Logger LOGGER = LoggerFactory.getLogger(MessageCommandFactory.class.getName());

	@Autowired
	private InternalRoutingCommand routingCommand;

	@Autowired
	private OutdialCommand outdialCommand;

	@Autowired
	private PrivacyShieldCommand privacyShieldCommand;

	@Autowired
	private XbeanHelper xbeanHelper;

	@Autowired
	private DesktopConfigManager configMap;

	/**
	 * @param tacgResp
	 * @return
	 * @throws InterpretationException
	 * @throws JSONException
	 */
	protected AdaResponse getCommand(final TacgResponse tacgResp) throws InterpretationException, JSONException {
		AdaResponse adaResponse = null;
		final String agentSessionId = tacgResp.getAgentSessionId();

		final AgentCommand agentCommand = xbeanHelper.parseAgentCommandXml(tacgResp.getXml(), agentSessionId);

		if (agentCommand.getName() == null) {
			LOGGER.warn(agentSessionId + "Name attribute not found in xml: {}", tacgResp.getXml());
			throw new InterpretationException("Name attribute not found in xml: " + tacgResp.getXml());
		}

		tacgResp.setAgentCommand(agentCommand);

		String name = agentCommand.getName();
		name = name.trim();

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("{} ===> Command name: {}", agentSessionId, name);
		}

		boolean errorCodeSet = false;

		LOGGER.debug("getCommand() processing on AgentCommand name: {}, for BE agentSessionId: {}", 
				name,
				agentSessionId);
		if (configMap == null) {
			return null;
		}
		final DesktopConfiguration conf = configMap.getConfigForAgent(agentSessionId);
		if (conf == null) {
			return null;
		}
		SortedMap<String, Data> dataMap = null;
		if (conf.getStateChangeData() != null && conf.getStateChangeData().getCallAssociatedData() != null) {
			dataMap = conf.getStateChangeData().getCallAssociatedData().getDataMap();

		}
		LineData1 line1 = conf.getCallContact().getLine1();
		LineData2 line2 = conf.getCallContact().getLine2();
		final String line1CurrentStatus = line1.getStatus();
		final String line2CurrentStatus = line2.getStatus();
		
		LOGGER.debug("Before processing, Line1 Status: {}, Line2 Status: {}",
				line1CurrentStatus,
				line2CurrentStatus);
		LOGGER.debug("Before processing, Line1 : {}, Line2 : {}",
				line1.debugToString(),
				line2.debugToString());

		switch (name) {
		case ONHOLD:
			tacgResp.setHoldFalg(true);
			setCallContactCallOnHold(true, agentSessionId);
			adaResponse = routingCommand.processHoldUnholdResponse(tacgResp);
			break;
		case HOLD_DONE:
			setCallContactCallOnHold(false, agentSessionId);
			adaResponse = routingCommand.processHoldUnholdResponse(tacgResp);
			break;
		case HOLD_ERROR:
			tacgResp.setHoldFalg(true);
			setCallContactCallOnHold(true, agentSessionId);
			tacgResp.setError(HOLD_ERROR_DESC);
			adaResponse = routingCommand.processHoldUnholdResponse(tacgResp);
			break;
		case UNHOLD_ERROR:
			tacgResp.setError(UNHOLD_ERROR_DESC);
			adaResponse = routingCommand.processHoldUnholdResponse(tacgResp);
			break;
		case CONSULT_ERROR:
			tacgResp.setErrorMessage("Consult Failed ");
			tacgResp.setErrorCode(String.valueOf(ContextConstants.ERROR_CONSULT));
			// For Agent1, reset line2 and update line1 with hold flag and status
			// Determine if current agent is Agent1 or Agent2
			if (
					(line1.getCallId().getId() != null) 
					&&
					(line1.getCallId().getId().equals(line2.getCallId().getId()))
			) {
				// For Agent1, reset line2 and update line1 with hold flag and status
				line2.reset();
				// Set on Hold and line 1 call status according to DesktopConfig (TACG source of truth)
				setCallContactCallOnHold(conf.getCallModel().isHoldEnabled(), agentSessionId);
				setCallContactCallStatusLine1(conf.getSubStatus(), agentSessionId);
			}
			adaResponse = routingCommand.processConsultErrorResponse(tacgResp);
			break;
		case CTQ_READY:
			adaResponse = routingCommand.processCtqResponse(tacgResp);
			break;
		case END_CONSULT_FAILED:
			tacgResp.setErrorMessage("Consult Cancel Failed ");
			tacgResp.setErrorCode(String.valueOf(ContextConstants.ERROR_CONSULT_CANCEL));

			adaResponse = routingCommand.processConsultErrorResponse(tacgResp);
			break;
		case CONFERENCING:
			tacgResp.setHoldFalg(false);// tacgResp.setHoldFalg(true);
			setCallContactCallOnHold(false, agentSessionId);
			if (
					(line1 != null) &&
					(line1.getCallId() != null) && 
					(line2 != null) &&
					(line2.getCallId() != null) &&
					(StringUtils.isNotBlank(line1.getCallId().getId())) 
					&&
					(line1.getCallId().getId().equals(line2.getCallId().getId()))
			) {
				setCallContactCallStatusOnBothLines(CallStatus.CONFERENCING.getName(), agentSessionId);
				line1.setLastEventTimestampToCurrentTime();
			} else {
				setCallContactCallStatusLine2(CallStatus.CONFERENCING.getName(), agentSessionId);
			}
			adaResponse = routingCommand.processConferenceResponse(tacgResp);
			break;
		case CONFERENCE_DONE:
			// TODO:
			// Possibly reset Line1 or Line or both Line1 and Line2
			adaResponse = routingCommand.processConferenceStatus(tacgResp);
			break;
		case CONFERENCE_ERROR:
			errorCodeSet = true;
			tacgResp.setErrorMessage("Conference failed.");
			tacgResp.setErrorCode(String.valueOf(ContextConstants.ERROR_CONFERENCING));
			break;
		case TRANSFER_ERROR:
			if (!errorCodeSet) {
				tacgResp.setErrorMessage("Agent transfer failed.");
				tacgResp.setErrorCode(String.valueOf(ContextConstants.ERROR_TRANSFER));
			}
			LOGGER.info(agentSessionId + " ===>> " + tacgResp.getErrorMessage());

			adaResponse = routingCommand.processTransferErrorResponse(tacgResp);
			break;
		case VTEAM_TRANSFER_FAILED:
			LOGGER.info(agentSessionId + "Vteam transfer failed.");
			tacgResp.setErrorMessage("Vteam transfer failed.");
			tacgResp.setErrorCode(String.valueOf(ContextConstants.ERROR_TRANSFER));

			adaResponse = routingCommand.processTransferErrorResponse(tacgResp);
			break;
		case CONSULT_ENDED:
			// TODO:
			// Possible case for Round # 3
			
			routingCommand.processConsultEnded(tacgResp);
			resetCallContactLine2(name, agentSessionId);
			break;
		case TRANSFERRED:
			routingCommand.processTransferred(tacgResp);
			break;
		case TRANSFER_DONE:
			// @ TODO This is an temporary implementation, Implement the proper functionality
			routingCommand.processTransferDone(tacgResp);
			//setCallContactCallStatusLine1(CallStatus.WRAP_UP.getName(), agentSessionId);
			break;
		case CALL_ENDED:
			adaResponse = routingCommand.processCallEnded(tacgResp);
			line1.setStatus(CallStatus.WRAP_UP.getName());
			line1.setLastEventTimestampToCurrentTime();
			break;
		case CONSULT_DONE:
			// @ TODO This is an temporary implementation, Implement the proper functionality
			routingCommand.processConsultDone(tacgResp);
			resetCallContactLine2(name, agentSessionId);
			break;
		case CONSULT_TRANSFER:
			// @ TODO This is an temporary implementation, Implement the proper functionality
			routingCommand.processConsultTransfer(tacgResp);
			setCallContactCallStatusLine1(CallStatus.CONNECTED.getName(), agentSessionId);
			line1.setLastEventTimestampToCurrentTime();
			break;
		case OUTDIAL_REQUEST_REJECTED:
			adaResponse = routingCommand.processRequestRejected(tacgResp);
			break;
		case OUTDIAL_REQUEST_REJECT:
			adaResponse = routingCommand.processRequestRejected(tacgResp);
			break;
		case OUTDIAL_REQUEST_ACCEPTED:
			adaResponse = outdialCommand.processOutdialAccepted(tacgResp);
			break;
		case CONSULT:
		case CONSULTING:
			adaResponse = outdialCommand.processOutdialConsulting(tacgResp);
			this.setCallContactCallStatusLine2(CallStatus.CONSULTING.getName(), agentSessionId);
			line2.setDataMap(dataMap);
			line2.setLastEventTimestampToCurrentTime();
			break;
		case CANCEL_OUTDIAL_ACCEPTED:
			// @ TODO implement the relevant code
			break;
		case CANCEL_OUTDIAL_REJECTED:
			// @ TODO implement the relevant code
			break;
		case CANCEL_OUTDIAL_DONE:
			// @ TODO implement the relevant code
			break;
		case CONSULT_RESERVED:
			final String callStatusLine = conf.isConnectedConsultReserved() ? CallStatus.CONSULT_REQUESTED.getName() : CallStatus.CONSULT_RESERVED.getName();
			this.setCallContactCallStatusLine2(callStatusLine, agentSessionId);
			line2.setLastEventTimestampToCurrentTime();
			// @ TODO implement the relevant code
			break;
		case CTQ_RESERVED:
			this.setCallContactCallStatusLine2(CallStatus.CONSULT_RESERVED.getName(), agentSessionId);
			line2.setLastEventTimestampToCurrentTime();
			// @ TODO implement the relevant code
			break;
		case SYSTEM_RECOVERY:
			// @ TODO implement the relevant code
			break;
		case PAUSED:
			adaResponse = privacyShieldCommand.processPrivacyShieldResponse(ContextConstants.STATE_OK, true, tacgResp);
			break;
		case PAUSE_FAILED:
			adaResponse = privacyShieldCommand.processPrivacyShieldResponse(ContextConstants.STATE_FAILED, true,
					tacgResp);
			break;
		case PAUSE_REJECTED:
			adaResponse = privacyShieldCommand.processPrivacyShieldResponse(ContextConstants.STATE_REJECTED, true,
					tacgResp);
			break;
		case RESUMED:
			adaResponse = privacyShieldCommand.processPrivacyShieldResponse(ContextConstants.STATE_OK, false, tacgResp);
			break;
		case RESUME_FAILED:
			adaResponse = privacyShieldCommand.processPrivacyShieldResponse(ContextConstants.STATE_FAILED, false,
					tacgResp);
			break;
		case RESUME_REJECTED:
			adaResponse = privacyShieldCommand.processPrivacyShieldResponse(ContextConstants.STATE_REJECTED, false,
					tacgResp);
			break;
		default:
			// @ TODO implement the relevant code
			// attr = attrs.getNamedItem(TRANSFER_ENABLED);
			// if (attr != null) {
			// final String attrValue = attr.getNodeValue();
			// StringUtils.convertToBoolean(attrValue);
			// }
			break;
		}

		final String line1PostStatus = line1.getStatus();
		final String line2PostStatus = line2.getStatus();
		
		LOGGER.debug("After processing, Line1 Status: {}, Line2 Status: {}",
				line1PostStatus,
				line2PostStatus);
		LOGGER.debug("After processing, Line1 : {}, Line2 : {}",
				line1.debugToString(),
				line2.debugToString());

		boolean hasPauseSettings = false;
		boolean pauseResumeEnabled = false;

		if (agentCommand.getEnablePauseResume()) {
			pauseResumeEnabled = agentCommand.getEnablePauseResume();
			hasPauseSettings = true;
		}

		final int pauseDuration = agentCommand.getPauseDuration();

		if (hasPauseSettings) {
			privacyShieldCommand.setPrivacyShieldParams(pauseResumeEnabled, pauseDuration, agentSessionId);
		}

		return adaResponse;
	}

	private void setCallContactCallStatusOnBothLines(final String callStatus, final String agentSessionId) {
		final DesktopConfiguration conf = configMap.getConfigForAgent(agentSessionId);

		if (conf == null) {
			LOGGER.warn("DesktopConfiguration is null for BE agentSessionId: {}", agentSessionId);
			return;
		}

		CallContact callContact = conf.getCallContact();
		LineData1 line1 = callContact.getLine1();
		LineData2 line2 = callContact.getLine2();

		Data line1CallIdData = line1.getCallId();
		Data line2CallIdData = line2.getCallId();

		if ((line1CallIdData != null) && (line2CallIdData != null)) {
			final String line1CallId = line1CallIdData.getValue();
			final String line2CallId = line2CallIdData.getValue();
			if ((org.apache.commons.lang3.StringUtils.isNotBlank(line1CallId)) && 
					(org.apache.commons.lang3.StringUtils.isNotBlank(line2CallId))) {
				if (line1CallId.equalsIgnoreCase(line2CallId)) {
					line1.setStatus(callStatus);
					line2.setStatus(callStatus);
				}
			}
		}
	}

	private void setCallContactCallOnHold(final boolean holdValue, final String agentSessionId) {
		final DesktopConfiguration conf = configMap.getConfigForAgent(agentSessionId);

		if (conf == null) {
			LOGGER.warn("DesktopConfiguration is null for BE agentSessionId: {}", agentSessionId);
			return;
		}

		CallContact callContact = conf.getCallContact();
		LineData1 line1 = callContact.getLine1();
		line1.setCallOnHold(holdValue);
		
		LOGGER.debug("Setting call onHold flag to: {}, on line1: {}, of CallContact: {}",
				holdValue,
				line1.debugToString(),
				callContact.debugToString());
	}

	private void setCallContactCallStatusLine1(final String callStatus, final String agentSessionId) {
		final DesktopConfiguration conf = configMap.getConfigForAgent(agentSessionId);

		if (conf == null) {
			LOGGER.warn("DesktopConfiguration is null for BE agentSessionId: {}", agentSessionId);
			return;
		}

		CallContact callContact = conf.getCallContact();
		LineData1 line1 = callContact.getLine1();
		line1.setStatus(callStatus);
		
		LOGGER.debug("Setting call status to: {}, on line1: {}, of CallContact: {}",
				callStatus,
				line1.debugToString(),
				callContact.debugToString());
	}

	private void setCallContactCallStatusLine2(final String callStatus, final String agentSessionId) {
		final DesktopConfiguration conf = configMap.getConfigForAgent(agentSessionId);

		if (conf == null) {
			LOGGER.warn("DesktopConfiguration is null for BE agentSessionId: {}", agentSessionId);
			return;
		}

		CallContact callContact = conf.getCallContact();
		LineData2 line2 = callContact.getLine2();
		line2.setStatus(callStatus);
		
		LOGGER.debug("Setting call status to: {}, on line2: {}, of CallContact: {}",
				callStatus,
				line2.debugToString(),
				callContact.debugToString());
	}

	private void resetCallContactLine2(final String subState, final String agentSessionId) {
		final DesktopConfiguration conf = configMap.getConfigForAgent(agentSessionId);

		if (conf == null) {
			LOGGER.debug(agentSessionId + " ===>> DesktopConfiguration is null So, agent logged out : ");
			return;
		}
		CallContact callContact = conf.getCallContact();
		callContact.resetLine2();
		LOGGER.debug("CallContact Line2 'Exit', AgentCommand subState: {}, Resetting Line1 of CallContact: {}",
				subState,
				callContact.debugToString());
	}

}
