/**
 * 
 */
package com.transerainc.adaws.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.json.ProxyJson;
import com.transerainc.adaws.model.AdaRequest;
//import com.transerainc.adaws.service.CacheService;
import com.transerainc.adaws.service.HeartbeatService;
import com.transerainc.adaws.util.StringUtils;

/**
 * @author rajeev.lochanam
 */
@Controller
public class AdaPingController {
	private static Logger LOGGER = LoggerFactory.getLogger(AdaPingController.class.getName());

	@Autowired
	private HeartbeatService nonFunctionalService;

	@Autowired
	protected WebSocketCacheManager webSocketCacheManager;

	public static Map<String, String> synchMapForValue = new ConcurrentHashMap<String, String>();

	@RequestMapping(value = "/pingEcho", produces = "application/json; charset=UTF-8", method = RequestMethod.POST, headers = "Accept=application/json, text/plain, */*")
	public @ResponseBody String handleEcho(final AdaRequest adaRequest, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		JSONObject res = new JSONObject();
		LOGGER.info("Ui's ping echo: webSocket Token {} ===>>", adaRequest.getagentSessionId());
		res.put("success", "true");
		return res.toString();
	}

	@RequestMapping(value = "/pingAda", produces = "application/json; charset=UTF-8", method = RequestMethod.POST, headers = "Accept=application/json, text/plain, */*")
	public @ResponseBody String handleHeartbeat(final AdaRequest adaRequest, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		String pingCounter = StringUtils.escapeHtml(request.getParameter("pingC"));
		JSONObject res = new JSONObject();
		LOGGER.info("Ui's Heart beat ping: webSocket Token {} ===>> and seqNumber===>>{} ",
				adaRequest.getagentSessionId(), adaRequest.getPingC());
		try {
			if ((!webSocketCacheManager.isTokenCached(adaRequest.getagentSessionId()))
					&& (!webSocketCacheManager.isAgentCached(adaRequest.getagentSessionId()))) {
				LOGGER.warn("The agent with token id {} does not exist", adaRequest.getagentSessionId());
				res.put("key", "no"); // Agent has logged out from BE
				res.put("adatoken", DesktopConfigManager.getTokenada());
				res.put("pingCounter", pingCounter);
				res.put("timestamp", System.currentTimeMillis());
				LOGGER.info("BE's response for UI's ping: {} ", res.toString());
				return res.toString();
			}
		} catch (NullPointerException e) {
			LOGGER.warn("The token id is null ==> {}", adaRequest.getagentSessionId());
			res.put("key", "no"); // Agent has logged out from BE
			res.put("adatoken", DesktopConfigManager.getTokenada());
			res.put("pingCounter", pingCounter);
			res.put("timestamp", System.currentTimeMillis());
			LOGGER.info("BE's response for UI's ping: {} ", res.toString());
			return res.toString();
		}
		LOGGER.info("The agent with token id {} exists", adaRequest.getagentSessionId());
		adaRequest.setPingC(pingCounter);
		nonFunctionalService.processHeartBeat(adaRequest);
		res.put("key", "yes"); // Agent exists in BE
		res.put("adatoken", DesktopConfigManager.getTokenada());
		res.put("pingCounter", pingCounter);
		res.put("timestamp", System.currentTimeMillis());
		LOGGER.info("BE's response for UI's ping: {} ", res.toString());
		return res.toString();
	}

	@RequestMapping(value = "/browserClosing", method = RequestMethod.POST)
	public @ResponseBody void handleCloseBrowser(final HttpServletRequest req, final HttpServletResponse res)
			throws Exception {

		LOGGER.debug("/browserClosing : Received POST request from UI: {}", req);
		final String bodyPayloadData = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		LOGGER.debug("/browserClosing : Raw body payload data: {}", bodyPayloadData);

		final String agentToken = ProxyJson.getAgentSessionId(bodyPayloadData);
		final String backendAgentSessionId = webSocketCacheManager.getAgent(agentToken);
		LOGGER.debug("/browserClosing : FE agent web token: {} and backendAgentSessionId:{}", agentToken,
				backendAgentSessionId);

		synchMapForValue.put(agentToken, ContextConstants.BROWSER_CLOSED_REASON);
		// synchMapForValue.put(backendAgentSessionId,
		// ContextConstants.BROWSER_CLOSED_REASON);

		LOGGER.info("{} ===>> Browser closing info ", agentToken);
		// nonFunctionalService.processBrowserClose(adaRequest);
	}

}
