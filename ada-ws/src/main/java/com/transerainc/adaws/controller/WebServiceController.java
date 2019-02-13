package com.transerainc.adaws.controller;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.transerainc.adaws.cache.CacheServerManager;
import com.transerainc.adaws.cache.CacheTokenManager;
import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.command.factory.CommandFactory;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.ServerData;
import com.transerainc.adaws.model.TacgResponse;
import com.transerainc.adaws.task.HeartBeatTask;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.SpringContextHelper;
import com.transerainc.adaws.util.StringUtils;
import com.transerainc.adaws.util.WebSocketDataPublisher;

/**
 * @author varsha.shivaram
 */
@Controller
public class WebServiceController {
	private static Logger LOGGER = LoggerFactory.getLogger(WebServiceController.class.getName());

	@Autowired
	private PropertiesUtil propertiesUtil;

	@Autowired
	private DesktopConfigManager agentDesktopConfigMap;

	@Autowired
	private WebSocketDataPublisher dataPublisher;

	@Autowired
	private CommandFactory commandFactory;

	@Autowired
	private TaskScheduler taskScheduler;

	@Autowired
	private CacheTokenManager tokenManager;

	@Autowired
	private CacheServerManager cacheServer;

	@Autowired
	private WebSocketCacheManager webSocketCacheManager;

	/**
	 * @param request
	 * @param response
	 * @param agentSessionId
	 * @throws Exception
	 */
	@RequestMapping(value = "/handleTacgResponse/{agentSessionId}")
	public void handleRequest(final HttpServletRequest request, final HttpServletResponse response,
			@PathVariable final String agentSessionId) throws Exception {
		long startTime = 0;
		if (LOGGER.isDebugEnabled()) {
			startTime = System.currentTimeMillis();
			LOGGER.debug(agentSessionId + " :===>> handle request in web service controller : " + startTime);
		}

		response.setStatus(200);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		final StringBuilder buffer = new StringBuilder();

		final BufferedReader reader = request.getReader();
		String line = null;

		try {
			while ((line = reader.readLine()) != null) {
				buffer.append(line.trim());
			}
		} catch (Exception exception) {
			LOGGER.warn("Error occurred while reading request from TACG for agentSessionId: {}, exception: {}",
					agentSessionId, exception.getMessage());
			response.setStatus(400);
			return;
		}

		if (!buffer.toString().isEmpty()) {
			final String xml = buffer.toString();
			if (agentSessionId.contains("tacgToken=")) {
				final String tacgToken = agentSessionId.substring(agentSessionId.indexOf('=') + 1,
						agentSessionId.length());

				String myRequest = xml;
				if (myRequest.contains("~")) {
					String seqNum = myRequest.substring(0, myRequest.indexOf("~"));
					String timeStamp = myRequest.substring(myRequest.lastIndexOf("~") + 1);
					final long unixTime = System.currentTimeMillis() / 1000L;
					LOGGER.info("The seq number in tacg's ping is {} and the timestamp {}", seqNum, timeStamp);
					String resStr = seqNum + "~" + String.valueOf(unixTime) + "~" + DesktopConfigManager.getTokenada();
					LOGGER.info("The response to send tacg's ping {}", resStr);
					response.setHeader("adaToken", resStr);
					final PrintWriter writer = response.getWriter();
					writer.println(resStr);

				} else {
					response.setHeader("adaToken", DesktopConfigManager.getTokenada());
					final PrintWriter writer = response.getWriter();
					writer.println(DesktopConfigManager.getTokenada());
				}
				scheduleHeartBeat(tacgToken);

				return;
			}
			final TacgResponse tacgResp = new TacgResponse(agentSessionId, xml);

			LOGGER.info("response from tacg " + buffer.toString() + "  for agentSessionID=" + agentSessionId);
			try {
				publishData(tacgResp);
			} catch (final Exception ex) {
				LOGGER.warn(" Error while processing response from tacg for tacgResp: {}", ex);
			}
		}

		if (LOGGER.isDebugEnabled()) {
			final long endTime = System.currentTimeMillis() - startTime;
			LOGGER.debug("{} :===>> handled the request in web service controller : {}", agentSessionId, endTime);
		}
	}

	/**
	 * @param tacgResp
	 */
	private void publishData(final TacgResponse tacgResp) {
		AdaResponse adaResponse = null;
		try {
			adaResponse = commandFactory.callCommandFactory(tacgResp);

			if (adaResponse == null || StringUtils.isEmpty(adaResponse.getAgentSessionId())) {
				LOGGER.info("{} NULL ada response : {}", tacgResp.getAgentSessionId(), adaResponse);
				return;
			}

			final String session = adaResponse.getAgentSessionId();
			final String tokenClient = webSocketCacheManager.isAgentCached(session)
					? webSocketCacheManager.getToken(session)
					: session;
			adaResponse.setAgentSessionId(tokenClient);

			/*
			 * LOGGER.
			 * debug("{}  Is Caching -- waitingForClose : {}, and isStatesQueueing : {}",
			 * tokenClient, eventCacheManager.waitingForClose(tokenClient),
			 * eventCacheManager.isStatesQueueing(tokenClient));
			 * 
			 * if (eventCacheManager.waitingForClose(tokenClient) ||
			 * eventCacheManager.isStatesQueueing(tokenClient)) { LOGGER.
			 * debug("Caching (queuing) the agent state for sessionId : {} on jsMethod: {} for adaResponse: {}"
			 * , tacgResp.getAgentSessionId(), adaResponse.getJsMethod(), adaResponse);
			 * eventCacheManager.setQueueStates(tokenClient, adaResponse); }
			 */

			if (webSocketCacheManager.getAgent(tokenClient) != null) {
				final DesktopConfiguration desktopConfig = agentDesktopConfigMap
						.getConfigForAgent(webSocketCacheManager.getAgent(tokenClient));
				if (desktopConfig == null) {
					return;
				}
				desktopConfig.setLastStateTriggered(adaResponse);
			}

			dataPublisher.publishData(adaResponse);
		} catch (final Exception e) {
			LOGGER.warn("{} problem while publishing data to queue: {} ", tacgResp.getAgentSessionId(), e.getMessage());
			LOGGER.warn("{} ada response : {}", tacgResp.getAgentSessionId(), adaResponse);
		}
	}

	/**
	 * @param token
	 * @throws Exception
	 */
	private void scheduleHeartBeat(final String token) throws Exception {
		if (tokenManager.tokenExists(token)) {
			final String serverIp = tokenManager.getToken(token);

			final ServerData sData = cacheServer.getServer(serverIp);

			LOGGER.info("For '{}' IP : Server details {} ", serverIp, sData);
			if (sData != null && sData.getTaskId() == null) {
				final HeartBeatTask heartBeatTask = SpringContextHelper.getBean(HeartBeatTask.class);

				heartBeatTask.setServerIp(serverIp);

				final ScheduledFuture<?> recoveryTask = taskScheduler.scheduleAtFixedRate(heartBeatTask,
						new Date(System.currentTimeMillis()
								+ Integer.valueOf(propertiesUtil.getAdaProperty("heart.beat.initial.delay"))),
						Integer.valueOf(propertiesUtil.getAdaProperty("heart.beat.rate")));

				LOGGER.info("For '{}' IP : and TACG token {} created the scheduler : {} ", serverIp, token,
						recoveryTask);

				heartBeatTask.setTaskId(recoveryTask);
				sData.setTaskId(recoveryTask);
			} else {
				return;
			}
			LOGGER.info("For '{}' TACG token : Taks {} ", token, sData.getTaskId());
		}
	}

}
