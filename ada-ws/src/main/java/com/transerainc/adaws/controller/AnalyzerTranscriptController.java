/**
 * 
 */
package com.transerainc.adaws.controller;

import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.json.ProxyJson;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.service.AnalyzerService;
import com.vdurmont.emoji.EmojiParser;
import org.json.JSONObject;

/**
 * @author jnarain
 *
 */
@Controller
public class AnalyzerTranscriptController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(AnalyzerTranscriptController.class.getName());
	
	@Autowired
	private AnalyzerService analyzerService;
	
	@Autowired
	private DesktopConfigManager agentDesktopConfigMap;

	@Autowired
	private WebSocketCacheManager webSocketCacheManager;
	

	@RequestMapping(value = "/getTranscript", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String handleGetTranscript(final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		String response = null;
		
		LOGGER.info("/getTranscript : Received POST request from UI: {}", req);
		
		final String bodyPayloadData = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		LOGGER.info("/getTranscript : Raw body payload data: {}", bodyPayloadData);
		
		try {
			final String agentToken = ProxyJson.getAgentSessionId(bodyPayloadData);
			LOGGER.info("FE agent web token: {}", agentToken);
			final String backendAgentSessionId = webSocketCacheManager.getAgent(agentToken);
			final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendAgentSessionId);

			String tenantId = desktopConfig.getEnterpriseId();	

			response = analyzerService
					   .getTranscript(ProxyJson.getTranscriptId(bodyPayloadData), tenantId);
			
			LOGGER.info("/getTranscript : analyzer response : {}", response);
			res.setStatus(200);
			
			JSONObject responseJson = new JSONObject();
			responseJson.put("transcript", (response != null ? EmojiParser.parseToUnicode(response) : response));
			return responseJson.toString();

		} catch (Exception e) {
			res.setStatus(500);
			LOGGER.error("/getTranscript : Error handling getTranscript data: {}, with exception: {}",
					req,
					e.toString());
		}	
		
		return response;
	}
}
