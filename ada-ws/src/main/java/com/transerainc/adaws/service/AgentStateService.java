package com.transerainc.adaws.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

import com.google.gson.Gson;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AgentStateConstants;
import com.transerainc.adaws.constants.ChannelType;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.constants.OmniChannelCommonCommandConstants;
import com.transerainc.adaws.constants.OmniChannelCommonMessageTypeConstants;
import com.transerainc.adaws.exception.ServerNotFoundException;
import com.transerainc.adaws.json.ChannelMessageConveyer;
import com.transerainc.adaws.json.DesktopConfigurationUtil;
import com.transerainc.adaws.model.AdaRequest;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.AuxCode;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.MmRequest;
import com.transerainc.adaws.model.RequestData;
import com.transerainc.adaws.util.GenerateXmlUtil;
import com.transerainc.adaws.util.ParsingUtils;
import com.transerainc.adaws.util.StringUtils;

/**
 * @author rajeev.lochanam
 */
@Service
public class AgentStateService extends BaseService {
	private static Logger LOGGER = LoggerFactory.getLogger(AgentStateService.class.getName());

	@Value("${ada.omnichannel.callback.url}")
	private String adaCallbackUrl;

	@Autowired
	private DesktopConfigManager agentDesktopConfigMap;
 
	@Autowired
	AuthenticationService authService;
	
	@Autowired
	private ChannelMessageConveyer channelMessage;

	@Autowired
	private GenerateXmlUtil generateXmlUtil;

	@Autowired
	private OmniChannelUtilService omniChannelUtilService;

	public void changeDnTeam(final AdaRequest adaRequest) {
		final String backendAgentSessionId = adaRequest.getagentSessionId();
		LOGGER.info("Backend Agent Session Id: {} :===>> Inside change DN and/or Team : {}",
				backendAgentSessionId,
				adaRequest);

		final String newDN = adaRequest.getDn();
		String newTeamId = adaRequest.getTeamId();
		LOGGER.info("Backend AgentSessionId: {}, " +
				"new DN: {}, " + 
				"and new Team Id: {}",
				backendAgentSessionId,
				newDN,
				newTeamId
				);
		final String filteredDn = authService.getFilteredAgentDn(backendAgentSessionId, newDN, adaRequest.getUsesOtherDn());

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(backendAgentSessionId + " Original DN " + newDN + ", filtered DN: " + filteredDn);
		}

	   if (filteredDn == null && !adaRequest.getIsAutoStationLogin().equals("true")) {
		   authService.errorOccurred(ContextConstants.ERROR_INVALID_STATION_DN, "Invalid Station DN", backendAgentSessionId);
			return ;
		}
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendAgentSessionId);
		if (desktopConfig == null) { return; }

		// Send DN and Team Name change to TACG
		// only allow the two states for now.
		final String subStateFromDesktopConfig = desktopConfig.getSubStatus();
		final String frontendAgentSessionId = webSocketCacheManager.getToken(backendAgentSessionId);

		desktopConfig.setDn(newDN);
		desktopConfig.setTeamId(newTeamId);
		final String teamIdsCSV = desktopConfig.getTeamIdsCSV();
		final String teamNamesCSV = desktopConfig.getTeamNamesCSV();
		final Map<String, String> teamIdsTeamNamesMap = ParsingUtils.createMap(teamIdsCSV, teamNamesCSV);
		final String teamName = teamIdsTeamNamesMap.get(adaRequest.getTeamId());
		desktopConfig.setTeamName(teamName);
		desktopConfig.setHasRequestedDnTeamChange(true);

		// Construct data for response to Frontend
		final String data = DesktopConfigurationUtil.dnTeamNameToJson(desktopConfig).toString();
		final AdaResponse adaResponse = new AdaResponse(CommandConstants.DN_TEAM_NAME_CHANGED, 
															data, 
															frontendAgentSessionId);

		// Send response to frontend
		dataPublisher.publishData(adaResponse);

		String xml = null;
		if (AgentStateConstants.SUBSTATE_AVAILABLE.equals(subStateFromDesktopConfig)) {
			xml = channelMessage.updateAgentState(desktopConfig, ChannelType.Telephony,
					AgentStateConstants.SUBSTATE_AVAILABLE, AgentStateConstants.STATE_LOGGED_IN, null);
		} else if (AgentStateConstants.SUBSTATE_IDLE.equals(subStateFromDesktopConfig)) {
			xml = channelMessage.updateAgentState(desktopConfig, ChannelType.Telephony,
					AgentStateConstants.SUBSTATE_IDLE, AgentStateConstants.STATE_LOGGED_IN, null);
		}

		LOGGER.info("Backend Agent Session Id: {} :===>> Sending state (DN and/or Team values) change request to tacg: {}",
				backendAgentSessionId,
				xml);

		String responseString = null;
		try {
			responseString = doHttpPost(backendAgentSessionId, xml);
		} catch (final ServerNotFoundException e) {
			LOGGER.error("{} :===>> Error while sending (setState) state (DN and/or Team values) change request to tacg {}", 
					backendAgentSessionId,
					xml);
		}

		LOGGER.info("Backend Agent Session Id: {} :===>> responseString for sending state (DN and/or Team values) change request to tacg: {}",
				backendAgentSessionId,
				responseString);
	}
	
	/**
	 * @param agentId 
	 * @param adaRequest
	 */
	public void setStateOmniChannel(final long auxCode, final String agentSessionId, Long agentId ) {
		// Construct Request Body (payload) for transmission to ICX
			MmRequest mmRequest = new MmRequest();
			
			mmRequest.setAction(OmniChannelCommonMessageTypeConstants.AGENT_STATE_CHANGE);
			
			mmRequest.setRequestData(new RequestData());
	
			mmRequest.getRequestData().setSessionId(agentSessionId);
			mmRequest.getRequestData().setAuxCodeId(auxCode);
			
			LOGGER.info("Sending to ICX with Ada Callback URL: {}, POJO request: {}", 
					adaCallbackUrl,
					mmRequest.debugToString());
	
			Gson gson = new Gson();
			String requestToIcx = gson.toJson(mmRequest);
	
			LOGGER.info("Sending to ICX with Ada Callback URL: {}, JSON request: {}", 
					adaCallbackUrl,
					requestToIcx);
	
			final String omniChannelUrl = omniChannelUtilService.getMimUrl(agentSessionId);
			try { // Send message to ICX    		
				String response = com.transerainc.adaws.connection.HttpUtil.doHttpJsonPost(omniChannelUrl, requestToIcx);
			
				// Send ICX response to Frontend
				omniChannelUtilService.transmitDataToFrontend(
						response, 
						OmniChannelCommonCommandConstants.STATE_CHANGED
						);
				
			} catch (final HttpServerErrorException hse) {
			omniChannelUtilService.reportError(hse, agentSessionId);
				
		} catch (final ResourceAccessException rae) {
			omniChannelUtilService.reportError(rae, agentSessionId);
		
		} catch (final HttpClientErrorException hce) {
			omniChannelUtilService.reportError(hce, agentSessionId);
			
		} catch (Exception exception) {	
			LOGGER.error("setStateOmniChannel(): Exception: {}", exception.getMessage());
			LOGGER.error("Error transmitting to ICX with exception: {}, omniChannelUrl: {}, requestToIcx: {}", 
					exception, omniChannelUrl, requestToIcx);
		
			omniChannelUtilService.reportError(OmniChannelCommonCommandConstants.STATE_CHANGED, 
				agentSessionId, 
				agentId, 
				OmniChannelCommonMessageTypeConstants.AGENT_STATE_CHANGE);
		}
	}
	
	/**
	 * @param adaRequest
	 */
	public void setStateOmniChannel(final AdaRequest adaRequest, Long agentId) {
		// Construct Request Body (payload) for transmission to ICX
			MmRequest mmRequest = adaRequest.getMmRequest();
			if (adaRequest.getMmRequest() == null) {
				mmRequest = new MmRequest();
			}
	
			mmRequest.setAction(OmniChannelCommonMessageTypeConstants.AGENT_STATE_CHANGE);
			
			String sessionId = adaRequest.getagentSessionId();
			Long auxCodeId = Long.valueOf(0);
			if (adaRequest.getAuxCodeIdArray() != null) {
				auxCodeId = Long.valueOf(adaRequest.getAuxCodeIdArray());
			}
	
			if (mmRequest.getRequestData() == null) {
				mmRequest.setRequestData(new RequestData());
			}
			mmRequest.getRequestData().setSessionId(sessionId);
			mmRequest.getRequestData().setAuxCodeId(auxCodeId);
			
			LOGGER.info("Sending to ICX with Ada Callback URL: {}, POJO request: {}", 
					adaCallbackUrl,
					mmRequest.debugToString());
	
			Gson gson = new Gson();
			String requestToIcx = gson.toJson(mmRequest);
	
			LOGGER.info("Sending to ICX with Ada Callback URL: {}, JSON request: {}", 
					adaCallbackUrl,
					requestToIcx);
	
			final String omniChannelUrl = omniChannelUtilService.getMimUrl(adaRequest.getagentSessionId());
			try { // Send message to ICX  		
				String response = com.transerainc.adaws.connection.HttpUtil.doHttpJsonPost(omniChannelUrl, requestToIcx);
			
				// Send ICX response to Frontend
				omniChannelUtilService.transmitDataToFrontend(
						response, 
						OmniChannelCommonCommandConstants.STATE_CHANGED
						);
				
			} catch (final HttpServerErrorException hse) {
			omniChannelUtilService.reportError(hse, sessionId);
				
		} catch (final ResourceAccessException rae) {
			omniChannelUtilService.reportError(rae, sessionId);
		
		} catch (final HttpClientErrorException hce) {
			omniChannelUtilService.reportError(hce, sessionId);
			
		} catch (Exception exception) {	
			LOGGER.error("setStateOmniChannel(): Exception: {}", exception.getMessage());
			LOGGER.error("Error transmitting to ICX with exception: {}, omniChannelUrl: {}, requestToIcx: {}", 
					exception, omniChannelUrl, requestToIcx);
		
			omniChannelUtilService.reportError(OmniChannelCommonCommandConstants.STATE_CHANGED, 
				sessionId, 
				agentId, 
				OmniChannelCommonMessageTypeConstants.AGENT_STATE_CHANGE);			
		}
	}
	
	/**
	 * @param adaRequest
	 * @throws IOException
	 */
	public void setState(final AdaRequest adaRequest) throws IOException {
		final String agentSessionId = adaRequest.getagentSessionId();
		LOGGER.info(agentSessionId + " :===>> Inside setState " + adaRequest);

		final String state = adaRequest.getState();
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
		if (desktopConfig == null) { return; }
		
		Long agentId = Long.valueOf(desktopConfig.getAgentId());

		final String currentSubStatus = desktopConfig.getSubStatus();

		// Send State Change to ICX as well
		if (desktopConfig.isIcrmEnabled() && (desktopConfig.getChannelCapability() != null) && 
				(desktopConfig.getChannelCapability().hasAnyOmniChannelCapability())) {
			try {
				setStateOmniChannel(adaRequest, agentId);
				} catch (Exception exception) {
					LOGGER.error("Cannot set state of OmniChannels: {}", exception);
					// TODO: Send setStateChange of OmniChannel failure/error to FE 			
				}
		} else {
			LOGGER.debug("No omnichannels configured for this agent. No State Change request sent to ICX.");
		}
		
		if ((!AgentStateConstants.SUBSTATE_AVAILABLE.equals(currentSubStatus)) && 
				(!AgentStateConstants.SUBSTATE_IDLE.equals(currentSubStatus)) && 
				(!AgentStateConstants.NOT_RESPONDING.equals(currentSubStatus))) {
			LOGGER.info("Buffering Frontend/FE AgentSessionId: {}, " + 
					"with current SubStatus: {}, " + 
					"buffered SubStatus: {}, " +
					"and IdleAuxCodeId: {}",
					agentSessionId, 
					currentSubStatus,
					state,
					adaRequest.getAuxCodeIdArray());
			desktopConfig.setBufferedAdaRequest(adaRequest); // last buffered request
			return;
		} else {
				// Send State Change to tacg
				LOGGER.info("Pass through to TACG of Frontend/FE AgentSessionId: {}" +
							"current SubStatus: {}, " +
							"and new SubStatus: {}",
							agentSessionId, 
							currentSubStatus,
							state);
				processStateChange(adaRequest);
			}         
	}

	public void processStateChange(final AdaRequest adaRequest) throws IOException {
			// This method is telephony specific
		final String agentSessionId = adaRequest.getagentSessionId();
		LOGGER.info(agentSessionId + " :===>> Inside processStateChange " + adaRequest);

		final String state = adaRequest.getState();
		final String auxCodeIdArray = adaRequest.getAuxCodeIdArray();

		LOGGER.info(agentSessionId + " :===>> auxCodeId Array " + auxCodeIdArray);
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);

		if (desktopConfig == null) { return; }

		desktopConfig.setStatus(AgentStateConstants.STATE_LOGGED_IN);
		desktopConfig.setSubStatus(state);

		String xml = null;
		String idleAuxCodeId = null;
		String wrapUpAuxCodeId = null;

		final List<String> auxCodeList = ParsingUtils.getListFromCSV(auxCodeIdArray);
		if (auxCodeList.size() > 1) {
			wrapUpAuxCodeId = auxCodeList.get(1);
		} else if (auxCodeList.size() == 1) {
			idleAuxCodeId = auxCodeList.get(0);
		}
		LOGGER.info(agentSessionId + " :===>> idle code selected " + idleAuxCodeId + ", Wrap code selected : "
				+ wrapUpAuxCodeId);

		AuxCode wrapUpAuxCode = null;
		AuxCode idleAuxCode = null;

		if (StringUtils.isNotEmpty(wrapUpAuxCodeId)) {
			final String wrapUpDesc = desktopConfig.getCodeName(AuxCode.TYPE_WRAPUP, wrapUpAuxCodeId);

			if (StringUtils.isEmpty(wrapUpDesc)) {
				wrapUpAuxCode = desktopConfig.getDefaultWrapUpAuxCode();
			} else {
				wrapUpAuxCode = new AuxCode(AuxCode.TYPE_WRAPUP, wrapUpAuxCodeId, wrapUpDesc);
			}
			LOGGER.info(agentSessionId + " :===>> wrap up desc " + wrapUpDesc);
		}

		if (StringUtils.isNotEmpty(idleAuxCodeId)) {
			final String idleDesc = desktopConfig.getCodeName(AuxCode.TYPE_IDLE, idleAuxCodeId);
			if (StringUtils.isEmpty(idleDesc)) {
				idleAuxCode = desktopConfig.getDefaultIdleAuxCode();
			} else {
				idleAuxCode = new AuxCode(AuxCode.TYPE_IDLE, idleAuxCodeId, idleDesc);
			}
			LOGGER.info(agentSessionId + " :===>> Idle desc " + idleDesc);
		}

		AuxCode[] auxCodes = null;
		if (wrapUpAuxCode != null) {
			auxCodes = new AuxCode[2];
			auxCodes[0] = idleAuxCode;
			auxCodes[1] = wrapUpAuxCode;
		} else if (idleAuxCode != null) {
			auxCodes = new AuxCode[1];
			auxCodes[0] = idleAuxCode;
		}
		LOGGER.info("{} :===>> auxCodes {}", agentSessionId, auxCodes);

		// only allow the two states for now.
		if (AgentStateConstants.SUBSTATE_AVAILABLE.equals(state)) {
			postAgentStateUpdateToJacg(agentSessionId, AgentStateConstants.STATE_LOGGED_IN,
					AgentStateConstants.SUBSTATE_AVAILABLE, auxCodes);

		} else if (AgentStateConstants.SUBSTATE_IDLE.equals(state)) {
			postAgentStateUpdateToJacg(agentSessionId, AgentStateConstants.STATE_LOGGED_IN,
					AgentStateConstants.SUBSTATE_IDLE, auxCodes);
		}
	}
	
	/**
	 * @param adaRequest
	 */
	public void queryAgentList(final AdaRequest adaRequest) {
		final String agentSessionId = adaRequest.getagentSessionId();
		LOGGER.info(agentSessionId + " :===>> Inside query agent list : " + adaRequest);

		final String queryString = generateXmlUtil.getTransferListQueryString(agentSessionId, ContextConstants.AGENT);

		LOGGER.info(agentSessionId + " :===>> agent list xml string : " + queryString);

		sendQuery(queryString, agentSessionId);
	}

	/**
	 * @param status
	 * @param subStatus
	 * @param agentSessionId
	 */
	public void requestStateChange(final String status, final String subStatus, final String agentSessionId) {
		final DesktopConfiguration conf = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
		Long agentId = Long.valueOf(conf.getAgentId());
		String xml = null;

		conf.setStatus(status);
		conf.setSubStatus(subStatus);
		AuxCode auxCode = conf.getLastIdleAuxCode();
		if (auxCode == null) {
			auxCode = conf.getDefaultIdleAuxCode();
		}
		final AuxCode[] auxCodes = new AuxCode[1];
		auxCodes[0] = auxCode;

		LOGGER.info("{} :===>> Requested state change with Aux code : {}", agentSessionId, auxCodes);

		if (conf.getChannelCapability() == null) {
				LOGGER.debug("No channel capabilities configured for this agent. No further State Change to be processed.");   			
			}
		else {
			postAgentStateUpdateToJacg(agentSessionId, AgentStateConstants.STATE_LOGGED_IN,
					AgentStateConstants.SUBSTATE_IDLE, auxCodes);

			if (conf.isIcrmEnabled() && conf.getChannelCapability().hasAnyOmniChannelCapability()) {
				// Fork State Change to ICX as well
				try {
					setStateOmniChannel(Long.valueOf(auxCode.getId()), agentSessionId, agentId);
					} catch (Exception exception) {
						LOGGER.error("Cannot set state of OmniChannels: {}", exception);
				}
			} else {
					LOGGER.debug("No omnichannels configured for this agent. No State Change request sent to ICX.");
			}
		}
	}

	private void postAgentStateUpdateToJacg(final String agentSessionId, final String state, final String subState,
			AuxCode[] auxCodes) {
		final DesktopConfiguration conf = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
		String xml = null;
		// Send State Change request to tacg for each channel type
		for (ChannelType channelType : ChannelType.values()) {
			if (conf.getChannelCapability().hasChannelCapability(channelType)
					&& (channelType == ChannelType.Telephony || !conf.isIcrmEnabled())) {
				xml = channelMessage.updateAgentState(conf, channelType, subState, state, auxCodes);

				LOGGER.info(agentSessionId + " :===>> Sending state change request to jacg " + xml);

				try {
					String responseString = null;
					responseString = doHttpPost(agentSessionId, xml);
					LOGGER.info(agentSessionId + " :===>> responseString: " + responseString);
				} catch (final ServerNotFoundException e) {
					LOGGER.error("{} :===>> Error while sending state change request to jacg {}", agentSessionId, xml);
				}
			} else {
				LOGGER.debug("No {} channel configured for this agent. No State Change request sent to jacg.",
						channelType.getName());
			}
		}
	}
}
