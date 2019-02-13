/**
 * 
 */
package com.transerainc.adaws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.CallPropertyConstants;
import com.transerainc.adaws.constants.CallStateConstants;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.exception.ServerNotFoundException;
import com.transerainc.adaws.model.AdaRequest;
import com.transerainc.adaws.model.CallAssociatedData;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.util.GenerateXmlUtil;
import com.transerainc.adaws.util.ParsingUtils;
import com.transerainc.adaws.util.StringUtils;

/**
 * @author rajeev.lochanam
 */
@Service
public class ConsultTransferService extends BaseService {
	private static Logger LOGGER = LoggerFactory.getLogger(ConsultTransferService.class.getName());

	@Autowired
	private DesktopConfigManager agentDesktopConfigMap;

	@Autowired
	private GenerateXmlUtil generateXmlUtil;

	/**
	 * @param adaRequest
	 */
	public void transferCall(final AdaRequest adaRequest) {
		final String agentSessionId = adaRequest.getagentSessionId();
		LOGGER.info(agentSessionId + " :===>> inside transfer call : ");

		sendAgentTargetedCommand(adaRequest);

		LOGGER.info(agentSessionId + " :===>> Finished transfer call : ");
	}

	/**
	 * @param adaRequest
	 */
	public void requestConsult(final AdaRequest adaRequest) {
		final String agentSessionId = adaRequest.getagentSessionId();
		LOGGER.info(agentSessionId + " :===>> inside consult call : ");

		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
		desktopConfig.setConferenceByThis(true);

		if (adaRequest.getTargetType().equals(ContextConstants.QUEUE)) {
			sendVteamTargetedCommand(agentSessionId, AdaConstants.REQUEST_CTQ, adaRequest);
		} else {
			adaRequest.setRedirectApi(AdaConstants.REQUEST_CONSULT);
			sendAgentTargetedCommand(adaRequest);
		}

		// Tap and capture Consult Target Id and Target Type for Call Contact state cache object for Browser Reload
		desktopConfig.getCallContact().setTargetId(adaRequest.getTargetId());
		desktopConfig.getCallContact().setTargetType(adaRequest.getTargetType());

		LOGGER.info(agentSessionId + " :===>> Finished consult call : ");
	}

	/**
	 * @param adaRequest
	 */
	public void requestConsultEnd(final AdaRequest adaRequest) {
		final String agentSessionId = adaRequest.getagentSessionId();
		LOGGER.info(agentSessionId + " :===>> inside consult end : ");

		sendAgentTargetedCommand(adaRequest);

		LOGGER.info(agentSessionId + " :===>> Finished consult end : ");
	}

	/**
	 * @param adaRequest
	 */
	public void requestConsultToQueueAccepted(final AdaRequest adaRequest) {
		final String agentSessionId = adaRequest.getagentSessionId();
		LOGGER.info(agentSessionId + " :===>> inside sending CTQ accepted : ");

		sendAgentTargetedCommand(adaRequest);

		// Tap and capture Consult Target Id and Target Type for Call Contact state cache object for Browser Reload
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
		desktopConfig.getCallContact().setTargetId(adaRequest.getTargetId());
		desktopConfig.getCallContact().setTargetType(ContextConstants.QUEUE);

		LOGGER.info(agentSessionId + " :===>> Finished sending CTQ accepted : ");
	}

	/**
	 * @param adaRequest
	 */
	public void requestConsultToQueueCancel(final AdaRequest adaRequest) {
		final String agentSessionId = adaRequest.getagentSessionId();
		LOGGER.info(agentSessionId + " :===>> inside cancel CTQ : ");

		sendVteamTargetedCommand(agentSessionId, CallStateConstants.CANCEL_CTQ, adaRequest);

		LOGGER.info(agentSessionId + " :===>> Finished cancelling CTQ : ");
	}

	/**
	 * @param adaRequest
	 * @param transferType
	 * @param commandName
	 */
	private void sendAgentTargetedCommand(final AdaRequest adaRequest) {
		final long timestamp = System.currentTimeMillis();
		final String agentSessionId = adaRequest.getagentSessionId();

		LOGGER.info(agentSessionId + " :===>> got request to BlindTransefer at : " + timestamp);

		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);

		LOGGER.info(agentSessionId + " :===>> partially created the xml for BlindTransfer : ");
		final String transferringAgentTuple = getTransferringAgentTuple(desktopConfig);
		LOGGER.info(agentSessionId + " :===>> transferring Agent Tuple : " + transferringAgentTuple);

		CallAssociatedData cad = desktopConfig.getStateChangeData().getCallAssociatedData();

		if (StringUtils.isNotEmpty(adaRequest.getUpdatedCadJson())) {
			LOGGER.info(agentSessionId + " :===>> existing call associated data : " + cad);

			final CallAssociatedData updatedCad = ParsingUtils.jsonStringToCad(cad, adaRequest.getUpdatedCadJson());

			if (updatedCad != null) {
				LOGGER.info(agentSessionId + " :===>> Adding updated call associated data : " + updatedCad);
				cad = updatedCad;
				publishUpdatedCalldata(cad, desktopConfig.getCallDataConfig(), agentSessionId);
			}
		}

		LOGGER.info(agentSessionId + " :===>> adding call (commad message elements) associated data : "
				+ desktopConfig.getStateChangeData().getCallAssociatedData());

		final String xml = generateXmlUtil.getAgentTargetedAgentCommandXml(agentSessionId, adaRequest,
				transferringAgentTuple, cad);

		LOGGER.info(agentSessionId + " :===>> XMl creation completed : " + xml);

		// irrespective of who ends the consult, the consulting agent gets the consult error if any.
		if (!adaRequest.getRedirectApi().equals(AdaConstants.REQUEST_CONSULT_END)) {
			changeServiceStatus(true, agentSessionId);
		}
		if (xml.contains(CallPropertyConstants.VT_TRANSFER)) {
			changeServiceStatus(false, agentSessionId);
		}
		String responseString = null;
		try {
			responseString = doHttpPost(agentSessionId, xml);
		} catch (final ServerNotFoundException e) {
			LOGGER.error("{} :===> server not found for agent list request :  : {}", agentSessionId, responseString);
		}

		LOGGER.info(agentSessionId + " :===> response to agent list request :  : " + responseString);

		if (LOGGER.isInfoEnabled()) {
			final long endTime = System.currentTimeMillis() - timestamp;
			LOGGER.info(agentSessionId + " :===>> Finished handle request : " + endTime);
		}

		desktopConfig.getCallModel().setCtqCancel(false);
	}

	/**
	 * @param agentSessionId
	 * @param commandName
	 * @param adaRequest
	 */
	private void sendVteamTargetedCommand(final String agentSessionId, final String commandName,
			final AdaRequest adaRequest) {
		final long timestamp = System.currentTimeMillis();

		LOGGER.info(agentSessionId + " :===>> got request to " + commandName + " at : " + timestamp);

		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);

		desktopConfig.setConferenceByThis(true);

		LOGGER.info(agentSessionId + " :===>> partially created the xml for " + commandName + ": ");
		final String transferringAgentTuple = getTransferringAgentTuple(desktopConfig);
		LOGGER.info(agentSessionId + " :===>> transferring Agent Tuple : " + transferringAgentTuple);

		CallAssociatedData cad = desktopConfig.getStateChangeData().getCallAssociatedData();

		if (StringUtils.isNotEmpty(adaRequest.getUpdatedCadJson())) {

			final CallAssociatedData existingCallAsstData = cad;
			LOGGER.info(agentSessionId + " :===>> existing call associated data : " + existingCallAsstData);

			final CallAssociatedData callAsstData = ParsingUtils.jsonStringToCad(existingCallAsstData,
					adaRequest.getUpdatedCadJson());

			if (callAsstData != null) {
				LOGGER.info(agentSessionId + " :===>> Adding updated call associated data : " + callAsstData);
				cad = callAsstData;
				publishUpdatedCalldata(cad, desktopConfig.getCallDataConfig(), agentSessionId);
			}
		}

		LOGGER.info(agentSessionId + " :===>> adding call (commad message elements) associated data : "
				+ desktopConfig.getStateChangeData().getCallAssociatedData());

		final String xml = generateXmlUtil.getVteamTargetedAgentCommandXml(agentSessionId, commandName,
				adaRequest.getTargetId(), transferringAgentTuple, cad);

		LOGGER.info(agentSessionId + " :===>> XMl creation completed : " + xml);
		String responseString = null;
		try {
			responseString = doHttpPost(agentSessionId, xml);
		} catch (final ServerNotFoundException e) {
			LOGGER.error("{} :===> server not found for {} request :  : {}", agentSessionId, commandName,
					responseString);
		}

		LOGGER.info(agentSessionId + " :===> response to " + commandName + "request :  : " + responseString);

		if (LOGGER.isInfoEnabled()) {
			final long endTime = System.currentTimeMillis() - timestamp;
			LOGGER.info(agentSessionId + " :===>> Finished handle request : " + endTime);
		}

		if (commandName.equals(CallStateConstants.CANCEL_CTQ)) {
			desktopConfig.getCallModel().setCtqCancel(true);
		} else {
			desktopConfig.getCallModel().setCtqCancel(false);
		}
	}

	/**
	 * @param adaRequest
	 */
	public void conferenceCall(final AdaRequest adaRequest) {
		final String agentSessionId = adaRequest.getagentSessionId();
		LOGGER.info(agentSessionId + " :===>> inside conference call : ");

		sendAgentTargetedCommand(adaRequest);

		LOGGER.info(agentSessionId + " :===>> Finished conference call : ");
	}

	/**
	 * @param desktopConfig
	 * @return
	 */
	private String getTransferringAgentTuple(final DesktopConfiguration desktopConfig) {
		final String id = desktopConfig.getAgentId();
		final String agentName = desktopConfig.getAgentName().replace('=', ' ');
		return id + "=" + agentName;
	}

}
