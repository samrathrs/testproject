package com.transerainc.adaws.service;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.AgentStateConstants;
import com.transerainc.adaws.constants.AppParams;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.constants.OmniChannelCommonCommandConstants;
import com.transerainc.adaws.constants.OmniChannelCommonConstants;
import com.transerainc.adaws.constants.OmniChannelCommonFrontendRequests;
import com.transerainc.adaws.exception.BaseException;
import com.transerainc.adaws.exception.ServerNotFoundException;
import com.transerainc.adaws.json.OmniChannelJsonUtil;
import com.transerainc.adaws.model.AdaRequest;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.AgentProfile;
import com.transerainc.adaws.model.AuxCode;
import com.transerainc.adaws.model.ChannelCapability;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.DialPlan;
import com.transerainc.adaws.model.DialPlan.Allowed;
import com.transerainc.adaws.model.ServerData;
import com.transerainc.adaws.util.ConfigAgentUtil;
import com.transerainc.adaws.util.DnValidator;
import com.transerainc.adaws.util.GenerateXmlUtil;
import com.transerainc.adaws.util.StringUtils;
import com.transerainc.adaws.util.WebSocketDataPublisher;

/**
 * @author rajeev.lochanam
 */

@Service
public class AuthenticationService extends CacheService {

	private static Logger LOGGER = LoggerFactory.getLogger(AuthenticationService.class.getName());

	@Value("${ada.omnichannel.callback.url}")
	private String adaCallbackUrl;

	@Value("${omnichannel.url}")
	private String omniChannelUrl;
	
	@Value("${omnichannel.server.url}")
	private String omniChannelServerUrl;
	

	@Autowired
	private GenerateXmlUtil generateXmlUtil;

	@Autowired
	private WebSocketDataPublisher dataPublisher;

	@Autowired
	private ConfigAgentUtil configAgentUtil;

	@Autowired
	private ConnectionStateService connectionStateService;

	@Autowired
	private OmniChannelUtilService omniChannelUtilService;
	
	@Autowired
	private DiscoveryService discoveryService;
	
	/**
	 * @param adaRequest
	 */
	public void authenticate(final AdaRequest adaRequest) {
		final String agentSessionId = adaRequest.getagentSessionId();
		LOGGER.info("{} :===>> Inside authenticate : {} ", agentSessionId, adaRequest);

		final String enterpriseName = adaRequest.getTenant();
		final String loginName = adaRequest.getUserName();

		agentDesktopConfigMap.populateDesktopConfig(agentSessionId);

		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
		desktopConfig.setEnterpriseName(enterpriseName);
		desktopConfig.setUserName(loginName);

		try {
			final String responseString = hookHttpPost(agentSessionId);
			
			if (org.apache.commons.lang3.StringUtils.isNotBlank(responseString)) {
				
				LOGGER.info("{} :===> loginName : {} Authentication response  : {} : ", agentSessionId, loginName, responseString); 
				final ServerData serverSaved = adaTacgMap.getAdaTacgMap(agentSessionId);
				agentCache.populateAgent(enterpriseName, agentSessionId);

				final String xmlMessage = generateXmlUtil.getAuthenticationMessage(adaRequest);

				LOGGER.info("{} :===>> Authenticate request xml : {}", agentSessionId, xmlMessage);

				doHttpPost(agentSessionId, xmlMessage);

				// cacheLoginInfo(adaRequest, enterpriseName, desktopConfig);

				final String hbInterval = desktopConfig.getValue(AppParams.HEART_BEAT_INTERVAL);
				final String missedHbAllowed = desktopConfig.getValue(AppParams.MISSED_HEART_BEATS_ALLOWED);
				final String connecRecTimeout = desktopConfig.getValue(AppParams.RECOVERY_MAX_TIME);
				final String serverIp = serverSaved.getHost() + ":" + serverSaved.getPort();

				tenantCache.populateTenants(hbInterval, missedHbAllowed, connecRecTimeout, serverIp, enterpriseName);
				
			} else {
				
				LOGGER.error("Error starting a heartbeat for sessionId:{}, responseString:{}", agentSessionId, responseString);
				// At this point we should not proceed and return the error to UI
				
				final String token = webSocketCacheManager.getToken(agentSessionId);
				final AdaResponse adaResponse = invalidTenant(ContextConstants.ERROR_AUTHENTICATION,
							AdaConstants.AUTH_FAILED, token);

				dataPublisher.publishData(adaResponse);
				
				LOGGER.info("Removing desktopConfig cache for agentSessionId : {}", agentSessionId);
				clearCache(agentSessionId, enterpriseName);
				return;
			}
			
		} catch (final ServerNotFoundException e) {

			final String token = webSocketCacheManager.getToken(agentSessionId);
			if (enterpriseName.equals(e.getMessage())) {
				final AdaResponse adaResponse = invalidTenant(ContextConstants.ERROR_AUTHENTICATION,
						AdaConstants.AUTH_FAILED, token);

				dataPublisher.publishData(adaResponse);
			} else if (AdaConstants.SERVER_NOT_STARTED.equals(e.getMessage())) {
				final AdaResponse adaResponse = invalidTenant(ContextConstants.ERROR_SERVER_NOT_FOUND,
						AdaConstants.SERVER_NOT_FOUND, token);

				dataPublisher.publishData(adaResponse);
			}

			clearCache(agentSessionId, enterpriseName);
		} catch (final Exception e) {
			LOGGER.error("Failed to connect.", e);
			LOGGER.info("{} :===>> Removing desktopConfig cache for agentSessionId : {}", agentSessionId,
					agentSessionId);

			clearCache(agentSessionId, enterpriseName);
		}

		LOGGER.info("{} :===>> Authenticate json result : {}", agentSessionId);

		publishEnterpriseLarEnabled(enterpriseName, agentSessionId);

		connectionStateService.scheduleJob(webSocketCacheManager.getToken(agentSessionId));

	}
    
	/**
	 * @param enterpriseName
	 * @param agentSessionId
	 */
	private void publishEnterpriseLarEnabled(final String enterpriseName, final String agentSessionId) {
		final String token = webSocketCacheManager.getToken(agentSessionId);
		final JSONObject jsonResponse = new JSONObject();
		try {
			final String enterpriseLarEnabled = configAgentUtil.getEnterpriseLarEnabledViaConfigAgent(enterpriseName);

			try {
				jsonResponse.put(AdaConstants.ENTERPRISE_LAR_ENABLED, StringUtils.getBoolean(enterpriseLarEnabled));
			} catch (final JSONException e) {
				LOGGER.error("Exception occured while forming json string on errorOccured condition." + e);
			}

			final AdaResponse adaResponse = new AdaResponse(CommandConstants.ENTERPRISE_LAR_ENABLED_FLAG,
					jsonResponse.toString(), token);

			dataPublisher.publishData(adaResponse);

			LOGGER.info("{} :===>> larEnabled flag from config agent : {}", agentSessionId, enterpriseLarEnabled);
		} catch (final BaseException e) {
			LOGGER.error("Error in retrieving data from xpath.", e);
		}
	}

	/**
	 * @param authError
	 * @param detail
	 * @param token
	 * @return
	 */
	private AdaResponse invalidTenant(final int authError, final String detail, final String token) {
		final JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put(AdaConstants.CODE, String.valueOf(authError));
			jsonResponse.put(AdaConstants.DETAIL, detail);
		} catch (final JSONException e) {
			LOGGER.error("Exception occured while forming json string on errorOccured condition." + e);
		}

		final AdaResponse adaResponse = new AdaResponse(CommandConstants.ERROR_OCCURRED, jsonResponse.toString(), token);
		return adaResponse;
	}

	/**
	 * @param adaRequest
	 */
	public boolean login(final AdaRequest adaRequest) {
		final String agentSessionId = adaRequest.getagentSessionId();
		LOGGER.info("{} :===>> Inside login : {}", agentSessionId, adaRequest);
		final String dn = adaRequest.getDn();
		final String teamId = adaRequest.getTeamId();
		String teamName = "";

		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
		final ChannelCapability channelCap = desktopConfig.getChannelCapability();
		
		if (!adaRequest.getIsAutoStationLogin().equals("true") &&  !desktopConfig.getAccessibleTeamMap().containsKey(teamId) ) {
			LOGGER.warn("{} :===>> Invalid team id : {} ", agentSessionId, teamId);
			throw new RuntimeException("Invalid team id.");
		} else if (adaRequest.getIsAutoStationLogin().equals("true") && teamId == null || teamId == "" ) {
				teamName = "";
		} else {
				teamName= desktopConfig.getAccessibleTeamMap().get(teamId);
		}

		final String filteredDn = getFilteredAgentDn(agentSessionId, dn, adaRequest.getUsesOtherDn());

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(agentSessionId + " Original DN " + dn + ", filtered DN: " + filteredDn);
		}

		if ((filteredDn == null) && 
			(channelCap != null) && 
			(channelCap.hasTelephonyCapability())) {
			// indicate error only if telephony is enabled
			errorOccurred(ContextConstants.ERROR_INVALID_STATION_DN, "Invalid Station DN", agentSessionId);
			return false;
		} else {
			sendFilteredDn(filteredDn, agentSessionId, teamName);

			desktopConfig.setTeamId(teamId);
			desktopConfig.setDn(filteredDn);
			desktopConfig.getStateChangeData().setPositionId("");
			desktopConfig.setStatus(AgentStateConstants.STATE_LOGIN);
			desktopConfig.setSubStatus(AgentStateConstants.SUBSTATE_IDLE);
			desktopConfig.getStateChangeData().setRetry(false);
			desktopConfig.getStateChangeData()
					.setAuxCode(
							new AuxCode(AuxCode.TYPE_IDLE, desktopConfig.getDefaultIdleId(), desktopConfig
									.getDefaultIdleDesc()));
			
			// Set OmniChannelUrl for this agentSession
			final String omniUrl = discoveryService.getOmniUrl();
			if (omniUrl != null) {
				desktopConfig.setOmniChannelServerUrl(omniUrl);
			} else {
				desktopConfig.setOmniChannelServerUrl(omniChannelServerUrl);
			}
			LOGGER.info("{} :===>> Omni Channel Url: {}", agentSessionId, desktopConfig.getOmniChannelUrl());
			
			// Save login request for OmniChannel until login to tacg gets a successful response
			LOGGER.info("{}: Saving adaRequest for pending Omnichannel login", agentSessionId);
			desktopConfig.setPendingLoginAdaRequest(adaRequest);
			desktopConfig.setOmnichannelLoginPending(true);
			if (channelCap != null) {
				channelCap.setChatChannelsLoggedIn(false);
				channelCap.setEmailChannelsLoggedIn(false);
			}
			
			final String xmlMessage = generateXmlUtil.updateAgentState(agentSessionId, false, null);

			LOGGER.info("{} :===>> Station login requested: {}", agentSessionId, xmlMessage );

			String responseString = null;
			try {
				responseString = doHttpPost(agentSessionId, xmlMessage);
				// mark telephony channel as logged-in
				if ((channelCap != null) && (channelCap.hasTelephonyCapability())) {
						desktopConfig.getChannelCapability().setTeleChannelsLoggedIn(true);
					}
			} catch (final ServerNotFoundException e) {
				LOGGER.error("{} :===>> Error while station login requested : {}", agentSessionId, xmlMessage);
				return false;
			}
			
			// cacheStationLogin(dn, teamId, desktopConfig, filteredDn);

			LOGGER.info("{} :===> Station login request response  : {} : username: {}", agentSessionId, responseString, adaRequest.getUserName());
		}
		return true;
	}

	/**
	 * @param agentSessionId
	 * @param dn
	 * @param usesOtherDn
	 * @return
	 */
	public String getFilteredAgentDn(final String agentSessionId, String dn, final String usesOtherDn) {
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);

		final DnValidator dv = "true".equals(usesOtherDn) ? desktopConfig.getOtherDnValidator() : desktopConfig
				.getDefaultDnValidator();

		if (dv != null) {
			try {
				dv.validateDn(dn);
				dn = dv.getFilteredDn();
			} catch (final Exception e) {
				dn = null;
			}
		}

		final AgentProfile agentProfile = desktopConfig.getAgentProfile();

		if (StringUtils.isEmpty(dn)) {
			dn = null;
		} else if (agentProfile != null) {
			final DialPlan dialPlan = agentProfile.getDialPlan("agentDn");
			if (dialPlan != null) {

				final List<DialPlan.Allowed> allowedList = dialPlan.getAllowedList();
				for (final Allowed allowed : allowedList) {
					final DnValidator validator = new DnValidator();
					validator.setRegex(allowed.getRegex());
					validator.setPrefix(allowed.getPrefix());
					validator.setStripCharacters(allowed.getStrippedChars());

					validator.validateDn(dn);
					if (validator.isValid()) { return validator.getFilteredDn(); }
				}
				return null;
			}

		}

		return dn;
	}

	/**
	 * @param authError
	 * @param detail
	 */
	public void errorOccurred(final int authError, final String detail, final String agentSessionId) {
		final JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put(AdaConstants.CODE, String.valueOf(authError));
			jsonResponse.put(AdaConstants.DETAIL, detail);
		} catch (final JSONException e) {
			LOGGER.error("Exception occured while forming json string on errorOccured condition." + e);
		}

		if (null != jsonResponse) {
			final AdaResponse adaResponse = new AdaResponse(CommandConstants.ERROR_OCCURRED, jsonResponse.toString(),
					webSocketCacheManager.getToken(agentSessionId));

			dataPublisher.publishData(adaResponse);
		}
	}

	/**
	 * @param filteredDn
	 * @param agentSessionId
	 */
	private void sendFilteredDn(final String filteredDn, final String agentSessionId, final String teamName) {
		final JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put(AdaConstants.FILTERED_AGENT_DN, filteredDn);
			jsonResponse.put("teamName", teamName);
		} catch (final JSONException e) {
			LOGGER.error("Exception occured while forming json string on sendFilteredDn condition." + e);
		}

		if (null != jsonResponse) {
			final AdaResponse adaResponse = new AdaResponse(CommandConstants.STATION_DN, jsonResponse.toString(),
					webSocketCacheManager.getToken(agentSessionId));

			dataPublisher.publishData(adaResponse);
		}
	}

	/**
	 * @param adaRequest
	 */
	public void requestLogout(final String agentSessionId, final String reason) {
		LOGGER.info("agentSessionId: {} :===>> Inside requestLogout() : reason - {} ", agentSessionId, reason);
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
		
		if ((desktopConfig != null) && agentDesktopConfigMap.containsAgentConfig(agentSessionId)) {
			final ChannelCapability chCap = desktopConfig.getChannelCapability();
			// LOGOUT OF ICX OmniChannels if agent has OmniChannel capabilities
			if ((chCap != null) && (chCap.hasAnyOmniChannelCapability())) {
				try {
					requestLogoutOmniChannel(agentSessionId);
				} catch (Exception exception) {
						LOGGER.warn("Cannot log out of OmniChannels: {}", exception);
						// Send logout failure/error to FE
						// inject session-id and agent-id in LOGOUT_FAILED_RESPONSE
						String logoutResponse = OmniChannelJsonUtil.injectBackendSessionIdAgentIdIntoResponse(
							OmniChannelCommonConstants.LOGOUT_FAILED_RESPONSE1, 
							agentSessionId,
							Long.valueOf(desktopConfig.getAgentId()));
						omniChannelUtilService.transmitDataToFrontend(
							logoutResponse,
							OmniChannelCommonCommandConstants.LOGOUT_RESPONSE);
					}
			}

			desktopConfig.setStatus(AgentStateConstants.STATE_LOGOUT);
			desktopConfig.setSubStatus(AgentStateConstants.SUBSTATE_IDLE);
			desktopConfig.getStateChangeData().setReason(reason);

			// Preparing and creating TACG Logout message
			final String xmlMessage = generateXmlUtil.updateAgentState(agentSessionId, false, null);

			LOGGER.info("agentSessionId: {} :===>> requestLogout() requested: with xmlMessage: {}", agentSessionId,
					xmlMessage);

			if (org.apache.commons.lang3.StringUtils.isBlank(xmlMessage)) {
				return;
			}

			String responseString = null;
			try {
					LOGGER.info("{} :===> Sending logout request to tacg ", agentSessionId);
					responseString = doHttpPost(agentSessionId, xmlMessage);
					
					// mark telephony channel as logged-out	
					if ((chCap != null) && (chCap.hasTelephonyCapability())) {
						chCap.setTeleChannelsLoggedIn(false);
					}       			
			} catch (final ServerNotFoundException e) {
				LOGGER.error("agentSessionId: {} :===> Error from Tacg : logout response  :  :  {} ", agentSessionId, responseString);
			}

			LOGGER.info("agentSessionId: {} :===> requestLogout() request response  : {} : ", agentSessionId, responseString);

			// Clearing Agent Cache only after receiving TACG Response with "LoggedOut" Status
			// clearAgentCache(agentSessionId);
		} else {
			LOGGER.info("{} :===> User is already logged out : request not processed", agentSessionId);
		}
	}

	public void requestLogoutOmniChannel(final String agentSessionId) {
		// Construct Request Body (payload) for transmission to ICX
		// 1.) Inject:
		//    1.) Session Id
		//    2.) Agent Id
		//    3.) Tenant Id
		String agentLogoutRequestToIcx = OmniChannelCommonFrontendRequests.AGENT_LOGOUT_REQUEST;
		DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
		
		if (desktopConfig != null  && desktopConfig.getAgentId() != null) {
			final ChannelCapability chCap = desktopConfig.getChannelCapability();
			
			if ((chCap != null) && (chCap.hasAnyOmniChannelCapability())) {
				
				final boolean emailCap = chCap.hasEmailCapability();
				final boolean chatCap = chCap.hasChatCapability();
				final boolean chatLoggedIn = chCap.isChatChannelsLoggedIn();
				final boolean emailLoggedIn = chCap.isEmailChannelsLoggedIn();
			
				if ((emailCap && emailLoggedIn) || (chatCap && chatLoggedIn)) {
					LOGGER.info("Logging out of OmniChannel for BE agentSessionId: {}", agentSessionId);

					long agentId = Long.valueOf(desktopConfig.getAgentId());

					String requestToIcx = OmniChannelJsonUtil.injectSessionAgentIdsIntoRequest(
							agentSessionId, 
							agentId,
							agentLogoutRequestToIcx);
					try {
						// Send message to ICX
						String response = com.transerainc.adaws.connection.HttpUtil.doHttpJsonPost(desktopConfig.getOmniChannelUrl(), requestToIcx);

						LOGGER.info("agentSessionId: {} :===> Response to OmniChannel logout request : {} : ", agentSessionId, response);

						// Send response to FE UI
						omniChannelUtilService.transmitDataToFrontend(
								response, 
								OmniChannelCommonCommandConstants.LOGOUT_RESPONSE
								);
					} catch (Exception exception) {
						LOGGER.warn("requestLogoutWithReason(): Cannot log out of OmniChannels: {}", exception);

						// Send logout failure/error to FE
						// inject session-id in LOGOUT_FAILED_RESPONSE
						String logoutResponse = OmniChannelJsonUtil.injectBackendSessionIdAgentIdIntoResponse(
							OmniChannelCommonConstants.LOGOUT_FAILED_RESPONSE1, 
							agentSessionId,
							Long.valueOf(desktopConfig.getAgentId()));

						omniChannelUtilService.transmitDataToFrontend(
							logoutResponse,
							OmniChannelCommonCommandConstants.LOGOUT_RESPONSE);
					}
				}
			} else {
				LOGGER.debug("Agent has no omniChannel capabilities at this time: agentSessionId: {}", agentSessionId); 
			}
		} else {
			LOGGER.debug("DesktopConfiguration is null with agentSessionId: {}", agentSessionId); 
		}
	}

	/**
	 * @param tacgResp
	 */
	public void requestLogoutWithReason(final String agentSessionId, final String reason) {
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);

		LOGGER.info("{} :===>> Inside requestLogoutWithReason() : reason - {} ", agentSessionId, reason);

		if (desktopConfig != null) {
			// Important: LOGOUT OF ICX before clearing caches or logging out of Tacg
			try {
				requestLogoutOmniChannel(agentSessionId);
			} catch (Exception exception) {
				LOGGER.warn("requestLogoutWithReason(): Cannot log out of OmniChannels: {}", exception);
				// Send logout failure/error to FE
				// inject session-id in LOGOUT_FAILED_RESPONSE
				long agentIdForOmni;
				if(desktopConfig.getAgentId() != null){
					agentIdForOmni =Long.valueOf(desktopConfig.getAgentId());
				}else{
					agentIdForOmni = 0;
				}
				
				String logoutResponse = OmniChannelJsonUtil.injectBackendSessionIdAgentIdIntoResponse(
					OmniChannelCommonConstants.LOGOUT_FAILED_RESPONSE1, 
					agentSessionId,
					agentIdForOmni);
				
				omniChannelUtilService.transmitDataToFrontend(
					logoutResponse,
					OmniChannelCommonCommandConstants.LOGOUT_RESPONSE);
			}

			if (desktopConfig.getStatus().equals(AgentStateConstants.STATE_LOGGED_OUT) ||
					desktopConfig.getStatus().equals(AgentStateConstants.STATE_LOGOUT)) {
				
				LOGGER.info("Clearing Agent Cache: user logged out, with agentSessionId: {}, and reason: {}", 
						agentSessionId,
						reason);
				clearAgentCache(agentSessionId);
			} else {
				desktopConfig.setStatus(AgentStateConstants.STATE_LOGOUT);
				desktopConfig.setSubStatus(AgentStateConstants.SUBSTATE_IDLE);
				desktopConfig.getStateChangeData().setReason(reason);

				final String xmlMessage = generateXmlUtil.updateAgentState(agentSessionId, false, null);

				LOGGER.info("agentSessionId: {} ===>> requestLogoutWithReason() : Logout with xmlMessage: {}", agentSessionId, xmlMessage);

				String responseString = null;
				try {
					responseString = doHttpPost(agentSessionId, xmlMessage);
					if ((desktopConfig.getChannelCapability() != null) && 
							(desktopConfig.getChannelCapability().hasTelephonyCapability())) {
						// mark telephony channel as logged-out
						desktopConfig.getChannelCapability().setTeleChannelsLoggedIn(false);
					}
				} catch (final ServerNotFoundException e) {
					LOGGER.error("{} :===> error - logout request response  : {} : ", agentSessionId, responseString);
				}

				LOGGER.info("{} :===> logout request response  : {} : ", agentSessionId, responseString);
			}
		} else {
			LOGGER.info("Clearing Agent Cache because DesktopConfiguration is null, with agentSessionId: {}, and reason: {}", 
					agentSessionId,
					reason);
			clearAgentCache(agentSessionId);
		}

	}

	/**
	 * @param adaRequest
	 */
	public void requestForceLogout(final String agentSessionId, final String reason) {
		LOGGER.info("{} :===>> Inside requestForceLogout() : reason - {} ", agentSessionId, reason);

		if (agentDesktopConfigMap.containsAgentConfig(agentSessionId)) {
			final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);

			if (desktopConfig != null) {
				try {
					// LOGOUT OF ICX
					requestLogoutOmniChannel(agentSessionId);
				} catch (Exception exception) {
						LOGGER.warn("requestForceLogout(): Cannot log out of OmniChannels for agentSessionId: {}, Exception: {}", agentSessionId, exception);
						// Send logout failure/error to FE
						// inject session-id in LOGOUT_FAILED_RESPONSE
					String logoutResponse = OmniChannelJsonUtil.injectBackendSessionIdAgentIdIntoResponse(
									OmniChannelCommonConstants.LOGOUT_FAILED_RESPONSE1, 
									agentSessionId,
									Long.valueOf(desktopConfig.getAgentId()));
						omniChannelUtilService.transmitDataToFrontend(
								logoutResponse,
								OmniChannelCommonCommandConstants.LOGOUT_RESPONSE);
				}

				desktopConfig.setStatus(AgentStateConstants.STATE_LOGOUT);
				desktopConfig.setSubStatus(AgentStateConstants.SUBSTATE_IDLE);
				desktopConfig.getStateChangeData().setReason(reason);
	
				final String xmlMessage = generateXmlUtil.updateAgentState(agentSessionId, false, null);

				LOGGER.info("agentSessionId: {} :===>> requestForceLogout() requested: , with xmlMessage: {}", 
						agentSessionId, 
						xmlMessage);

				String responseString = null;
				try {
					responseString = doHttpPost(agentSessionId, xmlMessage);
					if ((desktopConfig.getChannelCapability() != null) && 
							(desktopConfig.getChannelCapability().hasTelephonyCapability())) {
						// mark telephony channel as logged-out
						desktopConfig.getChannelCapability().setTeleChannelsLoggedIn(false);
					}
				} catch (final ServerNotFoundException snfe) {
					LOGGER.error("agentSessionId: {} :===> Error while requestForceLogout() : response  : {}, and exception: {}", agentSessionId, responseString, snfe);
				}

				LOGGER.info("agentSessionId: {} :===> requestForceLogout() request response  : {} : ", agentSessionId, responseString);
			} else {
				LOGGER.info("Desktop Configuration is null for agentSessionId: {}", agentSessionId);
			}
			// Clear Agent Cache on TACG Response of "LoggedOut" Status
		} else {
			LOGGER.info("{} :===> User is already logged out : request not processed", agentSessionId);
		}
	}

	/**
	 * @param adaRequest
	 */
	public void requestLogoutFromTacg(final String agentSessionId, final String reason) {
		LOGGER.info("agentSessionId: {} :===>> Inside requestLogoutFromTacg() : reason - {} ", agentSessionId, reason);

		if (agentDesktopConfigMap.containsAgentConfig(agentSessionId)) {
			final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);

			if (desktopConfig != null) {
				desktopConfig.setStatus(AgentStateConstants.STATE_LOGOUT);
				desktopConfig.setSubStatus(AgentStateConstants.SUBSTATE_IDLE);
				desktopConfig.getStateChangeData().setReason(reason);

				final String xmlMessage = generateXmlUtil.updateAgentState(agentSessionId, false, null);

				LOGGER.info("agentSessionId: {} :===>> requestLogoutFromTacg() requested: with xmlMessage: {}", 
						agentSessionId, 
						xmlMessage);

				String responseString = null;
				try {	
					responseString = doHttpPost(agentSessionId, xmlMessage);
					if ((desktopConfig.getChannelCapability() != null) && 
							(desktopConfig.getChannelCapability().hasTelephonyCapability())) {
							// mark telephony channel as logged-out
							desktopConfig.getChannelCapability().setTeleChannelsLoggedIn(false);
					}
				} catch (final ServerNotFoundException snfe) {
					LOGGER.error("agentSessionId: {} :===> Error while logout request response  :  :  {} , exception: {}", 
							agentSessionId, 
							responseString, 
							snfe);
				}

				LOGGER.info("agentSessionId: {} :===> requestLogoutFromTacg() request response  : {} : ", agentSessionId, responseString);
			} else { 
					LOGGER.info("agentSessionId: {} :===> User is already logged out, request not processed; Desktop Configuration is null", 
							agentSessionId);
			}
		} else {
				LOGGER.info("agentSessionId: {} :===> User is already logged out of tacg : request not processed", 
						agentSessionId);
		}
	}
}
