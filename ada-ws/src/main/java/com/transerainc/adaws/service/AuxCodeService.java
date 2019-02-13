/**
 * 
 */
package com.transerainc.adaws.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AgentProfileConstants;
import com.transerainc.adaws.constants.AgentStateConstants;
import com.transerainc.adaws.constants.ChannelType;
import com.transerainc.adaws.exception.ServerNotFoundException;
import com.transerainc.adaws.json.ChannelMessageConveyer;
import com.transerainc.adaws.json.OmniChannelJsonUtil;
import com.transerainc.adaws.model.AdaRequest;
import com.transerainc.adaws.model.AgentProfile;
import com.transerainc.adaws.model.AuxCode;
import com.transerainc.adaws.model.DesktopConfiguration;

/**
 * @author jnarain
 * 
 *
 */
@Service
public class AuxCodeService extends BaseService {

	private static Logger LOGGER = LoggerFactory.getLogger(AuxCodeService.class.getName());

	@Autowired
	private DesktopConfigManager agentDesktopConfigMap;

	@Autowired
	private ChannelMessageConveyer channelMessage;

	@Autowired
	private OmniChannelUtilService omniChannelUtilService;

	public void handleRequestSystemAuxCode(final HttpServletRequest request, final HttpServletResponse response,
			String payloadData, String jsMethod, String messageType) {

		LOGGER.debug("Received ICX Request of action/message type: {} with message data: {}", messageType, payloadData);

		// Now, see if translated/mapped system auxcodes exist for auxcode received from
		// ICX
		final String backendSessionId = OmniChannelJsonUtil.extractSessionId(payloadData);
		final DesktopConfiguration config = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if (config.getChannelCapability() != null) {
			LOGGER.debug("(config.getChannelCapability() != null)");
			// either telephony or omnichannel capabilities are configured for this agent
			final String omniAuxName = OmniChannelJsonUtil.extractAuxCodeName(payloadData);
			final String omniAuxIdStr = OmniChannelJsonUtil.extractAuxCodeId(payloadData);
			try {
				final int omniAuxId = Integer.valueOf(omniAuxIdStr);

				// look at the mapped idle auxcodes stored in agent profile
				final AgentProfile agentProfile = config.getAgentProfile();
				final Map<Integer, AgentProfile.Tuple> idleInfo = agentProfile.getIdleCodes();

				AuxCode idleAuxCode = null;
				AuxCode[] auxCodes = null;

				if ((idleInfo != null) && (!idleInfo.isEmpty())) {
					// there exist mapped system auxcodes (tuple)for this agent
					final AgentProfile.Tuple tupleEntity = idleInfo.get(omniAuxId);
					if (tupleEntity != null) {
						// isSystem=true for this auxcode and has a mapped system equivalent value
						String sysAuxCodeId = tupleEntity.getId();
						idleAuxCode = new AuxCode(AuxCode.TYPE_IDLE, sysAuxCodeId, omniAuxName);
						LOGGER.debug(
								"Translating ICX Request for TACG: origAuxCodeId:{}, translated AuxCodeId:{}, auxCodeName:{}",
								omniAuxId, idleAuxCode, omniAuxName);

						// inject new auxcode into profileData
						String modPayloadData = null;
						try {
							modPayloadData = OmniChannelJsonUtil.injectStringIntoPayload(
									AgentProfileConstants.AUX_CODE_ID, sysAuxCodeId, payloadData);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// Send this profileData to UI with translated idle system-auxcodes
						omniChannelUtilService.handleRequest(request, response, modPayloadData, jsMethod, messageType);

						// do not send to tacg if agent is on call: buffer it instead to be sent after
						// wrapup
						final String currentSubStatus = config.getSubStatus();
						if ((!AgentStateConstants.SUBSTATE_AVAILABLE.equals(currentSubStatus))
								&& (!AgentStateConstants.SUBSTATE_IDLE.equals(currentSubStatus))
								&& (!AgentStateConstants.NOT_RESPONDING.equals(currentSubStatus))) {

							LOGGER.info("Buffering this state change request from ICX");

							AdaRequest bufferedAdaRequest = config.getBufferedAdaRequest();
							if (bufferedAdaRequest != null) {
								LOGGER.debug("Previously Bufferred AuxCodeIdArray{} and state",
										bufferedAdaRequest.getAuxCodeIdArray(), bufferedAdaRequest.getState());

								bufferedAdaRequest.setState(AgentStateConstants.SUBSTATE_IDLE);
								// bufferedAdaRequest.setAuxCodeIdArray(idleAuxCode.toString());
								// LOGGER.info("Buffered AuxCodeIdArray{} modified",
								// bufferedAdaRequest.getAuxCodeIdArray());
								bufferedAdaRequest.setAuxCodeIdArray(sysAuxCodeId.toString());
								LOGGER.info("Bufferred AuxCodeIdArray{} modified with sysAuxCodeId",
										bufferedAdaRequest.getAuxCodeIdArray());
							} else { // buffer the state and substate in a dummy adaRequest
								LOGGER.debug("No previously Bufferred AuxCodeIdArray: create new");
								bufferedAdaRequest = new AdaRequest(); // how will it get deleted?
								bufferedAdaRequest.setState(AgentStateConstants.SUBSTATE_IDLE);
								// bufferedAdaRequest.setAuxCodeIdArray(idleAuxCode.toString());
								// LOGGER.info("Buffered AuxCodeIdArray{} added",
								// bufferedAdaRequest.getAuxCodeIdArray());
								bufferedAdaRequest.setAuxCodeIdArray(sysAuxCodeId.toString());
								LOGGER.info("Bufferred AuxCodeIdArray{} added sysAuxCodeId",
										bufferedAdaRequest.getAuxCodeIdArray());
								config.setBufferedAdaRequest(bufferedAdaRequest);
							}
						} else {
							if (config.getChannelCapability().hasTelephonyCapability()) {

								// Setting subStatus to Idle : later generateXmlUtil.updateAgentState() depends
								// on it to find new-subStatus
								config.setStatus(AgentStateConstants.STATE_LOGGED_IN);
								config.setSubStatus(AgentStateConstants.SUBSTATE_IDLE);
								LOGGER.debug("Setting subStatus to IDLE");

								// Send state change with system auxcode to tacg now
								auxCodes = new AuxCode[1];
								auxCodes[0] = idleAuxCode;
								String responseString = null;
								if (idleAuxCode != null) {
									String xml = null;
									xml = channelMessage.updateAgentState(config, ChannelType.Telephony, 
											AgentStateConstants.SUBSTATE_IDLE, AgentStateConstants.STATE_LOGGED_IN,
											auxCodes);
									LOGGER.info("{}:===>> Sending state change auxCodes: {} ==> request to tacg {}",
											backendSessionId, auxCodes, xml);
									try {
										responseString = doHttpPost(backendSessionId, xml);
									} catch (final ServerNotFoundException e) {
										LOGGER.error(
												"{} :===>> Error while sending (setState) state change request to tacg {}",
												backendSessionId, xml);
									}
								}
								LOGGER.info("{} :===>> responseString:{} ", backendSessionId, responseString);
							}
						}
					} else {
						LOGGER.debug("This AuxCodeId is not a system-auxcode hence don't send to tacg");
						// send to FE UI as-is
						omniChannelUtilService.handleRequest(request, response, payloadData, jsMethod, messageType);
					}
				} else {
					LOGGER.debug("There is no mapped auxcode for this isSystem=true item, hence don't send to tacg");
					// send to FE UI as-is
					omniChannelUtilService.handleRequest(request, response, payloadData, jsMethod, messageType);
				}
			} catch (NumberFormatException numberFormatException) {
				LOGGER.error("NumberFormatException for omniAuxIdStr: {}, payloadData: {}", omniAuxIdStr, payloadData);
			}

		}
	}
}
