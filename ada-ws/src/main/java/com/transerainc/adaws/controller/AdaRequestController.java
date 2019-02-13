package com.transerainc.adaws.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.pac4j.core.context.J2EContext;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.ProfileManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.command.DesktopConfigurationCommand;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.AgentStateConstants;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.exception.BaseException;
import com.transerainc.adaws.json.FrontendAgentSessionId;
import com.transerainc.adaws.model.AdaRequest;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.AgentEnterpriseResult;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.StationLoginToken;
import com.transerainc.adaws.model.UserEnterpriseInfo;
import com.transerainc.adaws.retriever.UserInformationRetriever;
import com.transerainc.adaws.service.AgentStateService;
import com.transerainc.adaws.service.AnalyzerServiceWrapper;
import com.transerainc.adaws.service.AuthenticationService;
import com.transerainc.adaws.service.CacheService;
import com.transerainc.adaws.service.CallStateService;
import com.transerainc.adaws.service.ConsultTransferService;
import com.transerainc.adaws.service.DesktopService;
import com.transerainc.adaws.service.HeartbeatService;
import com.transerainc.adaws.service.OmniChannelUtilService;
import com.transerainc.adaws.service.OutdialService;
import com.transerainc.adaws.util.ConfigAgentUtil;
import com.transerainc.adaws.util.CssCustomization;
import com.transerainc.adaws.util.OmniChannelFrontendToBackendRouter;
import com.transerainc.adaws.util.StringUtils;
import com.transerainc.adaws.util.ThemeHelper;
import com.transerainc.adaws.util.WebSocketDataPublisher;

/**
 * @author varsha.shivaram
 */
@Controller
public class AdaRequestController {

	private static Logger LOGGER = LoggerFactory.getLogger(AdaRequestController.class.getName());

	@Autowired
	private AnalyzerServiceWrapper analyzerUtil;

	@Autowired
	private CacheService cacheService;

	@Autowired
	private DesktopService desktopApi;

	@Autowired
	private OutdialService outdialService;

	@Autowired
	private AgentStateService agentService;

	@Autowired
	private ConfigAgentUtil configAgentUtil;

	@Autowired
	private AuthenticationService autService;

	@Autowired
	private CallStateService callStateService;

	@Autowired
	private WebSocketDataPublisher dataPublisher;

	@Autowired
	private HeartbeatService nonFunctionalService;

	@Autowired
	private ConsultTransferService transferService;

	@Autowired
	private DesktopConfigManager agentDesktopConfigMap;

	@Autowired
	private WebSocketCacheManager webSocketCacheManager;

	@Autowired
	private StationLoginToken stationlogintoken;

	@Autowired
	private UserInformationRetriever userInformationRetriever;

	@Autowired
	private OmniChannelFrontendToBackendRouter omniChannelFrontendToBackendRouter;

	@Autowired
	private OmniChannelUtilService omniChannelUtilService;

	@Autowired
	private DesktopConfigurationCommand desktopConfigurationCommand;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String homePage(final HttpServletRequest request, final HttpServletResponse response) {
		// Get HTTP Session id
		HttpSession session = request.getSession();
		String backEndSessionId = session.getId();

		// Get CAS Profile, especially User Name
		final WebContext context = new J2EContext(request, response);
		final ProfileManager<CommonProfile> manager = new ProfileManager<CommonProfile>(context);
		List<CommonProfile> profiles = manager.getAll(true);
		String userName = null;
		for (CommonProfile profile : profiles) {
			userName = profile.getId();
			if (org.apache.commons.lang3.StringUtils.isNotBlank(userName)) {
				break;
			}
		}

		// Get Enterprise Name from Analyzer with User Name from CAS Profile
		UserEnterpriseInfo userEnterprise = userInformationRetriever.buildUserEnterpriseInfo(userName);
		// Map session id and JSESSIONID cookie to CAS Profile (User Name) and
		// Enterprise Name
		webSocketCacheManager.populateUserEnterprise(backEndSessionId, userEnterprise);
		LOGGER.info("Web token : {}, mapping with user: {} enterprise: {}", backEndSessionId,
				userEnterprise.getUsername(), userEnterprise.getEnterpriseName());

		// Return home page
		return "index";
	}

	// Branding and Customization changes
	@RequestMapping(value = "/loginCss.htm", method = RequestMethod.GET)
	protected void loginCss(final HttpServletRequest req, final HttpServletResponse res) {
		String url = "";
		String adaUrl = "";
		final ThemeHelper themeHelper = new ThemeHelper();

		final String domainName = CssCustomization.getTenantDomain(req, res);
		try {

			url = themeHelper.getCustomCssUrl(domainName);
			adaUrl = themeHelper.getAdaCustomCssUrl(domainName);
		} catch (final Exception e) {
			LOGGER.debug("Exception occured in retrieving login css", e);
			// return themeHelper.getCustomCssUrl(domainName);
		}
		try {
			res.getWriter().write(url);
			res.getWriter().write(adaUrl);
		} catch (IOException e) {
			LOGGER.debug("Exception occured in sending css", e);
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logoutPage(final HttpServletRequest request, final HttpServletResponse response) {
		LOGGER.info("Inside /logout endpoint");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			LOGGER.info("Clearing out Security Context, Auth: {}Request: {}", auth, request);
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
	}

	@RequestMapping(value = "/init", method = RequestMethod.POST, headers = "Content-Type="
			+ MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public AgentEnterpriseResult initWebsocketSession(
			@RequestBody(required = true) final FrontendAgentSessionId agentSession, final HttpServletRequest request,
			final HttpServletResponse response) {
		AgentEnterpriseResult agentEnterpriseResult = new AgentEnterpriseResult();
		String agentSessionId = agentSession.getAgentSessionId();

		LOGGER.info("Frontend Agent Session Id: {}", agentSessionId);

		agentEnterpriseResult.setAgentSessionId(agentSessionId);

		// Get HTTP Session id for logging here
		HttpSession session = request.getSession();
		final String jSessionId = session.getId();
		LOGGER.info("JSESSION ID from http request.getSession() : {}", jSessionId);

		// Generate a new BackEnd session id
		final String backEndSessionId = StringUtils.generateSessionId();

		LOGGER.info("New Backend Session Id : {}", backEndSessionId);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		SecurityContext securityContext = SecurityContextHolder.getContext();
		LOGGER.info("Request: {}, JSESSION ID: {}", request, jSessionId);

		Map<String, UserEnterpriseInfo> agentUserEnterpriseInfoMap = webSocketCacheManager
				.getTokenUserEnterpriseInfoMap();
		LOGGER.info("Mapping of Backend Session to User/Agent and Enterprise Info size: {} and isEmpty: {}",
				agentUserEnterpriseInfoMap.size(), agentUserEnterpriseInfoMap.isEmpty());

		if ((!agentUserEnterpriseInfoMap.containsKey(backEndSessionId))
				&& (!webSocketCacheManager.isTokenCached(agentSessionId))) {
			// Get CAS Profile of a new user, especially User Name
			final WebContext context = new J2EContext(request, response);
			final J2EContext j2eContext = new J2EContext(request, response);
			final ProfileManager<CommonProfile> manager = new ProfileManager<CommonProfile>(context);
			List<CommonProfile> profiles = manager.getAll(true);

			LOGGER.info("context = {}, manager = {}, profiles = {}", context, manager, profiles);

			// Cache CAS Login Security Context objects
			webSocketCacheManager.populateAgentAuthenticationSession(agentSessionId, backEndSessionId, authentication,
					session, securityContext, j2eContext, manager, profiles);

			String userName = null;
			for (CommonProfile profile : profiles) {
				userName = profile.getId();
				if ((userName != null) && (org.apache.commons.lang3.StringUtils.isNotBlank(userName))) {
					break;
				}
			}

			LOGGER.info("CAS User name = {}", userName);
			LOGGER.info("CAS profiles = {}", profiles);

			if (org.apache.commons.lang3.StringUtils.isNotBlank(userName)) {
				// Get Enterprise Name from Analyzer with User Name from CAS Profile
				UserEnterpriseInfo userEnterpriseInfo = userInformationRetriever.buildUserEnterpriseInfo(userName);

				LOGGER.info("Retrieved Enterprise Name = {}", userEnterpriseInfo.getEnterpriseName());

				agentEnterpriseResult.setEnterpriseName(userEnterpriseInfo.getEnterpriseName());
				agentEnterpriseResult.setAgentName(userEnterpriseInfo.getUsername());

				if (userEnterpriseInfo.isCallCenterEnabled()) {
					// Map new BackEnd SessionId to CAS Profile (User Name) and Enterprise Name
					webSocketCacheManager.populateUserEnterprise(backEndSessionId, userEnterpriseInfo);
					LOGGER.info("Backend Session Id : {}, mapping with user: {} enterprise: {}", backEndSessionId,
							userEnterpriseInfo.getUsername(), userEnterpriseInfo.getEnterpriseName());

					// Map FrontEnd SessionId and new BackEnd SessionId
					webSocketCacheManager.populateToken(agentSessionId, backEndSessionId);
					LOGGER.info(
							"Populating webSocketCache mapping with "
									+ "Frontend Agent Session Id (aka Web Token): {}, for " + "Backend Session Id: {}",
							agentSessionId, backEndSessionId);
					LOGGER.info("Sending {} response to Agent Desktop UI Frontend with: {}", response.getStatus(),
							agentEnterpriseResult);
					agentEnterpriseResult.setStatus(org.springframework.http.HttpStatus.OK.value());
					response.setStatus(org.springframework.http.HttpStatus.OK.value());
				} else {
					agentEnterpriseResult.setStatus(ContextConstants.CALL_CENTER_DISABLED);
					agentEnterpriseResult.setMessage(ContextConstants.CALL_CENTER_DISABLED_ERROR_MESSAGE);
					response.setStatus(org.springframework.http.HttpStatus.OK.value());
				}
			} else {
				LOGGER.info("CAS User name is blank = {}, CAS profiles = {}", userName, profiles);
				agentEnterpriseResult.setStatus(org.springframework.http.HttpStatus.BAD_REQUEST.value());
				agentEnterpriseResult
						.setMessage("Agent/Username not found from CAS for Agent Session Id: " + agentSessionId);
				response.setStatus(org.springframework.http.HttpStatus.BAD_REQUEST.value());
			}
		} else {
			LOGGER.info("Newly generated Backend SessionId: {} is not unique for FE SessionId: {}", backEndSessionId,
					agentSessionId);
			agentEnterpriseResult.setStatus(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value());
			agentEnterpriseResult.setMessage(
					"Backend SessionId: " + backEndSessionId + " is not unique for FE SessionId: " + agentSessionId);
			response.setStatus(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		LOGGER.info("Sending {} response to Frontend with: {}", response.getStatus(),
				agentEnterpriseResult.debugToString());
		return agentEnterpriseResult;
	}

	private void lastLogForHandleRequest(final String agentSessionId, final long startTime) {
		if (LOGGER.isDebugEnabled()) {
			final long endTime = System.currentTimeMillis() - startTime;
			LOGGER.debug(agentSessionId + " :===>> Finished handle request : " + endTime);
		}

		LOGGER.info("===>> Finished handle request for Backend Agent Session Id: {}", agentSessionId);
	}

	/**
	 * @param adaRequest
	 * @throws Exception
	 */
	@MessageMapping("/application")
	public void handleRequest(@Payload AdaRequest adaRequest, MessageHeaders messageHeaders) throws Exception {
		if ((adaRequest == null) || (messageHeaders == null)
				|| ((messageHeaders.containsKey(SessionRepositoryFilter.SESSION_REPOSITORY_ATTR))
						&& (messageHeaders.get(SessionRepositoryFilter.SESSION_REPOSITORY_ATTR) == null))) {
			if (adaRequest == null) {
				LOGGER.warn("Websocket Security hijacking attempted with null AdaRequest");
				return;
			} else {
				logoutOnAgentSessionSecurityCompromised(adaRequest.getagentSessionId());
				return;
			}
		}

		final String redirectApi = adaRequest.getRedirectApi();

		LOGGER.info("Received redirectApi = {}", redirectApi);

		final String agentToken = adaRequest.getagentSessionId();

		Map simpSessionAttributes = (Map) messageHeaders.get(AdaConstants.WEBSOCKET_SESSION_ATTRIBUTES_KEY);
		if (simpSessionAttributes == null) {
			logoutOnAgentSessionSecurityCompromised(agentToken);
			return;
		}
		final String httpSessionIdFromWebsocketHeader = (String) simpSessionAttributes
				.get(AdaConstants.SPRING_SESSION_ID_KEY);
		final String httpSessionIdFromWebsocketCache = webSocketCacheManager.getHttpSessionId(agentToken);
		if ((org.apache.commons.lang3.StringUtils.isBlank(httpSessionIdFromWebsocketHeader))
				|| (org.apache.commons.lang3.StringUtils.isBlank(httpSessionIdFromWebsocketCache))
				|| (!httpSessionIdFromWebsocketHeader.equals(httpSessionIdFromWebsocketCache))) {
			logoutOnAgentSessionSecurityCompromised(agentToken);
			return;
		}

		LOGGER.info("AgentSessionId of Websocket matches cached of HTTP Session, agentSessionId: {}, Http Session: {}",
				agentToken, httpSessionIdFromWebsocketCache);

		constructSession(redirectApi, agentToken);

		final String agentSessionId = webSocketCacheManager.getAgent(agentToken);

		if (AdaConstants.REQUEST_RELOADED_STATE.equals(redirectApi)) {
			nonFunctionalService.processBrowserReloaded(adaRequest);
			return;
		} else if (AdaConstants.REQUEST_CHECK_STATE.equals(redirectApi)) {
			nonFunctionalService.syncAgentState(adaRequest);
			return;
		} else if (AdaConstants.MOCK_OUTDIAL_ANI_LIST.equals(redirectApi)) {
			publishMockAniList(adaRequest.getProfileAniId(), agentToken);
			return;
		} else if (!AdaConstants.RECONNECT_AUTH.equals(redirectApi) && !AdaConstants.AUTHENTICATE.equals(redirectApi)) {
			final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);

			if (desktopConfig == null) {
				handleNullDesktopConfig(agentToken, agentSessionId, redirectApi);
				return;
			}
		}

		final long startTime = System.currentTimeMillis();
		LOGGER.debug("Starting handle request at : {} and web token : {} and backend-session-id : {} ", startTime,
				agentToken, agentSessionId);

		adaRequest.setagentSessionId(agentSessionId);

		// The map is maintained to store the count of station login from single agent
		// and this holds value temporary.
		// For any requests other than station login should clear this agent from the
		// map.
		if (redirectApi != null && !redirectApi.equals(AdaConstants.REQUEST_STATION_LOGIN)) {
			stationlogintoken.removeKeyFromAuth(agentToken);
			stationlogintoken.setDupDn(agentToken, false);
		}

		if (omniChannelUtilService.hasOmniRedirectApi(redirectApi)) {
			LOGGER.info("Forking to OmniChannelRouter on redirectApi = {}", redirectApi);
			omniChannelFrontendToBackendRouter.route(redirectApi, adaRequest);
			lastLogForHandleRequest(agentSessionId, startTime);
			return;
		}

		switch (redirectApi) {
		case AdaConstants.REQUEST_CHANGE_DN_AND_TEAM:
			agentService.changeDnTeam(adaRequest);
			break;
		case AdaConstants.REQUEST_RESTORE_UI_STATE:
			adaRequest.setagentSessionId(agentToken);
			nonFunctionalService.restoreAgentState(adaRequest);
			break;
		case AdaConstants.REQUEST_RELOAD_UI_STATE:
			adaRequest.setagentSessionId(agentToken);
			nonFunctionalService.reloadAgentState(adaRequest);
			break;
		case AdaConstants.REQUEST_FOR_HEART_BEAT:
			adaRequest.setagentSessionId(agentToken);
			nonFunctionalService.processHeartBeat(adaRequest);
			break;
		case AdaConstants.REQUEST_STATION_LOGIN:
			if (!multiRequestForStationLogin(agentToken, agentSessionId)) {
				stationlogintoken.addProcessingList(agentToken);
				if (autService.login(adaRequest)) {// The boolean check before put is a fix for #19029
					stationlogintoken.putAuthMap(agentToken, 0);
					stationlogintoken.removeFromPocessingList(agentToken);
				} else {
					LOGGER.error("Station Login failed");
					if (stationlogintoken.checkKeyInProcList(agentToken)) {
						stationlogintoken.removeFromPocessingList(agentToken);
					}
				}
			}
			break;
		case AdaConstants.REQUEST_LOGOUT:
			if (stationlogintoken.checkKeyInProcList(webSocketCacheManager.getToken(adaRequest.getagentSessionId()))) {
				stationlogintoken
						.removeFromPocessingList(webSocketCacheManager.getToken(adaRequest.getagentSessionId()));
				stationlogintoken.removeKeyFromAuth(webSocketCacheManager.getToken(adaRequest.getagentSessionId()));
			}
			autService.requestLogout(adaRequest.getagentSessionId(), adaRequest.getLogoutReason());
			break;
		case AdaConstants.RECONNECT_AUTH:
		case AdaConstants.AUTHENTICATE:
			autService.authenticate(adaRequest);
			break;
		case AdaConstants.REQUEST_STATE_CHANGE:
			agentService.setState(adaRequest);
			break;
		case AdaConstants.QUERY_AGENT_LIST:
			agentService.queryAgentList(adaRequest);
			break;
		case AdaConstants.REQUEST_CALL_END:
			callStateService.requestCallEnd(adaRequest);
			break;
		case AdaConstants.REQUEST_WRAPUP_CALL:
			callStateService.wrapUpCall(adaRequest);
			break;
		case AdaConstants.REQUEST_HOLD:
			callStateService.requestHold(adaRequest);
			break;
		case AdaConstants.QUERY_VTEAM_LIST:
			desktopApi.queryVteamList(adaRequest);
			break;
		case AdaConstants.QUERY_SPEED_DIAL_LIST:
			desktopApi.querySpeedDialList(adaRequest);
			break;
		case AdaConstants.REQUEST_CALL_TRANSFER:
			transferService.transferCall(adaRequest);
			break;
		case AdaConstants.REQUEST_CONSULT_TRANSFER:
			transferService.transferCall(adaRequest);
			break;
		case AdaConstants.REQUEST_CONFERENCE:
			transferService.conferenceCall(adaRequest);
			break;
		case AdaConstants.REQUEST_CONSULT:
			transferService.requestConsult(adaRequest);
			break;
		case AdaConstants.REQUEST_CONSULT_END:
			transferService.requestConsultEnd(adaRequest);
			break;
		case AdaConstants.REQUEST_CONSULT_TO_QUEUE_ACCEPTED:
			transferService.requestConsultToQueueAccepted(adaRequest);
			break;
		case AdaConstants.REQUEST_CONSULT_TO_QUEUE_CANCEL:
			transferService.requestConsultToQueueCancel(adaRequest);
			break;
		case AdaConstants.REQUEST_OUT_DIAL:
			outdialService.requestOutdial(adaRequest);
			break;
		case AdaConstants.SEND_SUPERVISOR_ALERT:
			desktopApi.sendSupervisorAlert(adaRequest);
			break;
		case AdaConstants.REQUEST_PAUSE_RECORDING:
			desktopApi.requestPauseRecording(adaRequest);
			break;
		case AdaConstants.REQUEST_RESUME_RECORDING:
			desktopApi.requestResumeRecording(adaRequest);
			break;
		case AdaConstants.REQUEST_STATE_CHANGE_TO_AVAILABLE:
			agentService.requestStateChange("LoggedIn", "Available", adaRequest.getagentSessionId());
			break;
		case AdaConstants.GETAGENTTPP:
			desktopApi.getAgentTpp(adaRequest);
			break;
		case AdaConstants.DOICRMLOGIN:
			desktopApi.doIcrmlogin(adaRequest);
			break;
		case AdaConstants.DOICRMLOGOUT:
			desktopApi.doIcrmlogout(adaRequest);
			break;
		case AdaConstants.GET_TRANSCRIPT:
			analyzerUtil.getTranscript(adaRequest);
			break;
		case AdaConstants.PUBLISH_CONSULTING:
			analyzerUtil.publishConsulting(adaRequest);
			break;
		case AdaConstants.REQUEST_COMPONENT_INFORMATION:
			publishComponentInformation(adaRequest);
			break;
		default:
			LOGGER.info("Default case handler for redirectApi on switch({})", redirectApi);
			break;
		}

		lastLogForHandleRequest(agentSessionId, startTime);
	}

	protected void handleNullDesktopConfig(final String webToken, final String agentSessionId,
			final String redirectApi) {
		// Inform FE that Agent Session is not found
		LOGGER.debug(
				"Handling null DesktopConfiguration for FE WebToken: {}, BE AgentSessionId: {}, and redirectApi: {}",
				webToken, agentSessionId, redirectApi);
		final AdaResponse agentSessionNotFoundResponse = constructErrorOccurredAdaResponse(
				ContextConstants.ERROR_AGENT_SESSION_NOT_FOUND_CODE, CommandConstants.AGENT_NOT_FOUND, webToken);
		LOGGER.debug(
				"Informing FE that Agent Session (e.g. Desktop Configuration) is not found for FE WebToken: {}, with AdaResponse: {}",
				webToken, agentSessionNotFoundResponse);
		dataPublisher.publishData(agentSessionNotFoundResponse);

		LOGGER.debug(
				"DesktopConfiguration is null but still clearing websocket cache anyways for FE WebToken: {}, with BE AgentSessionId: {}",
				webToken, agentSessionId);
		synchronized (webSocketCacheManager) {
			// Note that the method webSocketCacheManager.removeAgent(abc) expects
			// the FE web token: abc, so that it removes the BE agent session id mapping
			// first
			// and then cleans up the rest of the mappings.
			webSocketCacheManager.removeAgent(webToken);
		}
	}

	protected AdaResponse constructErrorOccurredAdaResponse(final int errorCode, final String errorDetail,
			final String webToken) {
		final JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put(AdaConstants.CODE, String.valueOf(errorCode));
			jsonResponse.put(AdaConstants.DETAIL, errorDetail);
		} catch (final JSONException jsonException) {
			LOGGER.error(
					"Error occured while forming json string on authError and detail: {} and {}, with JSONException: {}",
					String.valueOf(errorCode), errorDetail, jsonException);
		}
		final AdaResponse errorOccurredAdaResponse = new AdaResponse(CommandConstants.ERROR_OCCURRED,
				jsonResponse.toString(), webToken, "");
		return errorOccurredAdaResponse;

	}

	/**
	 * @param redirectApi
	 * @param webToken
	 */
	protected void constructSession(final String redirectApi, final String webToken) {
		if (AdaConstants.RECONNECT_AUTH.equals(redirectApi) || AdaConstants.AUTHENTICATE.equals(redirectApi)) {
			LOGGER.info("authentication request from : {}  and authMap : {} Or isTokenCached : {} ", webToken,
					stationlogintoken.getauthKeys(), webSocketCacheManager.isTokenCached(webToken));

			String backendSessionId = webSocketCacheManager.getAgent(webToken);
			if ((webSocketCacheManager.isTokenCached(webToken))
					&& (!webSocketCacheManager.isAgentSessionUserEnterpriseCached(backendSessionId))) {
				logoutOnDuplicateSession(webToken);
			}

			if (!webSocketCacheManager.isAgentSessionUserEnterpriseCached(backendSessionId)) {
				final String uuid = StringUtils.generateSessionId();

				webSocketCacheManager.populateToken(webToken, uuid);
				LOGGER.info("Web token : {} mapping with agent session : {} ", webToken, uuid);
			} else {
				LOGGER.info("Web token : {} mapping with " + "agent session : {} " + "User/Agent Enterprise: {}",
						webToken, backendSessionId, webSocketCacheManager.getUserEnterprise(backendSessionId));
			}

		}
	}

	/**
	 * @param webToken
	 * @param uuid
	 */
	private boolean multiRequestForStationLogin(final String webToken, final String agentSessionId) {
		boolean result = false;
		LOGGER.info("Checking for multiRequestForStationLogin : {} ",
				stationlogintoken.getProcKeys().toString() + " auth" + stationlogintoken.getauthKeyList());

		LOGGER.info("Is Duplicate station login : {} for Web token : {} and agent session id : {} ",
				stationlogintoken.checkKeyInAuth(webToken), webToken, agentSessionId);

		if ((stationlogintoken == null) || (org.apache.commons.lang3.StringUtils.isBlank(webToken))) {
			return false;
		}

		// To avoid duplicate channel ID
		// synchronized (authMap) {
		int stationCount = 0;
		if (stationlogintoken != null
				&& ((stationlogintoken.getauthKeys() != null && stationlogintoken.getAuthMap(webToken) != null
						&& stationlogintoken.checkKeyInAuth(webToken))
						|| stationlogintoken.checkKeyInProcList(webToken))
				&& stationlogintoken.getDupDn(webToken) != true) {
			final int countTot = stationlogintoken.getAuthMap(webToken);
			LOGGER.info("Web token : {} for agent session id : {} Threshold count : {} ", webToken, agentSessionId,
					countTot);
			if (countTot > 3) {
				LOGGER.info("Web token : {} for agent session id : {} Logging out the agent ", webToken,
						agentSessionId);
				logoutOnDuplicateSession(webToken);
			}
			stationCount = countTot + 1;
			result = true;
			stationlogintoken.putAuthMap(webToken, stationCount);
		}

		LOGGER.info("Web token : {} for agent session id : {} multiRequestForStationLogin : {} ", webToken,
				agentSessionId, result);
		return result;
	}

	/**
	 * @param webToken
	 */
	protected void logoutOnDuplicateSession(final String webToken) {
		final String existingSession = webSocketCacheManager.getAgent(webToken);
		LOGGER.info("Duplicate authentication request from : {} for session : {} ", webToken, existingSession);

		autService.requestLogout(existingSession, AgentStateConstants.LOST_CONNECTION);

		cacheService.clearAgentCache(existingSession);

		webSocketCacheManager.removeAgent(webToken);
	}

	protected void logoutOnAgentSessionSecurityCompromised(final String webToken) {
		final String backendSessionId = webSocketCacheManager.getAgent(webToken);

		LOGGER.warn("Websocket Security hijacking attempted for FE web token: {}, and BE agent session id: {}",
				webToken, backendSessionId);
		autService.requestForceLogout(backendSessionId, AgentStateConstants.LOST_CONNECTION);
	}

	/**
	 * @param aniListId
	 * @param token
	 */
	private void publishMockAniList(final String aniListId, final String token) {
		// final String token = webSocketCacheManager.getToken(agentSessionId);
		final JSONObject jsonResponse = new JSONObject();
		try {
			final JSONObject[] mockAniList = configAgentUtil.getMockOutdialList(aniListId);

			if (null != mockAniList) {
				try {
					jsonResponse.put(AdaConstants.MOCK_OUTDIAL_ANI_LIST, mockAniList);
				} catch (final JSONException e) {
					LOGGER.error("Exception occured while forming json string on errorOccured condition." + e);
				}

				final AdaResponse adaResponse = new AdaResponse(CommandConstants.MOCK_OUTDIAL_ANI_LIST,
						jsonResponse.toString(), token);

				dataPublisher.publishData(adaResponse);

				LOGGER.info("{} :===>> larEnabled flag from config agent : {}", token, mockAniList);
			}
		} catch (final BaseException e) {
			LOGGER.error("Error in retrieving data from xpath.", e);
		}
	}

	private void publishComponentInformation(final AdaRequest adaRequest) {
		final String agentSessionId = adaRequest.getagentSessionId();
		final String componentType = adaRequest.getComponentType();
		String componentInformation = desktopConfigurationCommand.retrieveComponentInformation(agentSessionId,
				componentType);
		DesktopConfiguration desktopConf = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
		if (desktopConf != null) {
			desktopConf.setComponentInformation(componentType, componentInformation);
		}
		final String webToken = webSocketCacheManager.getToken(agentSessionId);
		final AdaResponse adaResponse = new AdaResponse(CommandConstants.COMPONENT_INFORMATION_FETCHED,
				componentInformation, webToken);
		dataPublisher.publishData(adaResponse);
	}
}
