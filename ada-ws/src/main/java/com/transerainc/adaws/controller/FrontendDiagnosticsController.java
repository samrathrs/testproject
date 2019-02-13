/**
 * 
 */
package com.transerainc.adaws.controller;

import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.model.FrontendDiagnosticsLogging;

/**
 * @author jnarain
 *
 */
@Controller
public class FrontendDiagnosticsController {

	private static Logger LOGGER = LoggerFactory.getLogger(FrontendDiagnosticsController.class.getName());

	private static final Gson GSON = new Gson();

	private static final String CONSOLE_LOGGING_ENDPOINT = "/consoleLogging";

	private static final String DEBUG = "DEBUG";
	private static final String INFO = "INFO";
	private static final String WARN = "WARN";
	private static final String ERROR = "ERROR";

	@Autowired
	private WebSocketCacheManager webSocketCacheManager;

	@RequestMapping(value = CONSOLE_LOGGING_ENDPOINT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String handleConsoleLogging(final HttpServletRequest req, final HttpServletResponse res) throws Exception {

		String response = GSON.toJson(ImmutableMap.of("success", "false"));

		LOGGER.debug("Received: consoleLogging request from UI: {}", req);

		final String bodyPayloadData = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		LOGGER.debug("/consoleLogging : Raw body payload data: {}", bodyPayloadData);

		try {
			if (StringUtils.isBlank(bodyPayloadData)) {
				res.setStatus(org.springframework.http.HttpStatus.BAD_REQUEST.value());
				return response;
			}

			FrontendDiagnosticsLogging logRequest = GSON.fromJson(bodyPayloadData, FrontendDiagnosticsLogging.class);

			final String agentToken = logRequest.getAgentSessionId();
			if (StringUtils.isBlank(agentToken)) {
				res.setStatus(org.springframework.http.HttpStatus.UNAUTHORIZED.value());
				return response;
			}

			final String backendAgentSessionId = webSocketCacheManager.getAgent(agentToken);
			if (StringUtils.isBlank(backendAgentSessionId)) {
				res.setStatus(org.springframework.http.HttpStatus.UNAUTHORIZED.value());
				return response;
			}

			LOGGER.info("consoleLogging: FE agent web token: {}, backendSessionId:{}", agentToken,
					backendAgentSessionId);

			final String logMessage = logRequest.getMessage();
			if (StringUtils.isBlank(logMessage)) {
				res.setStatus(org.springframework.http.HttpStatus.BAD_REQUEST.value());
				return response;
			}

			final String message = logMessage.length() <= 5120 ? logMessage : logMessage.substring(0, 5119);

			switch (logRequest.getLevel()) {
			case DEBUG:
				LOGGER.debug("agentToken: {}, backendAgentSessionId: {}, message: {}", agentToken,
						backendAgentSessionId, message);
				break;
			case INFO:
				LOGGER.info("agentToken: {}, backendAgentSessionId: {}, message: {}", agentToken, backendAgentSessionId,
						message);
				break;
			case WARN:
				LOGGER.warn("agentToken: {}, backendAgentSessionId: {}, message: {}", agentToken, backendAgentSessionId,
						message);
				break;
			case ERROR:
				LOGGER.error("agentToken: {}, backendAgentSessionId: {}, message: {}", agentToken,
						backendAgentSessionId, message);
				break;
			default:
				LOGGER.info("agentToken: {}, backendAgentSessionId: {}, message: {}", agentToken, backendAgentSessionId,
						message);
				break;
			}

			LOGGER.debug("Received: consoleLogging request from UI: {}", logRequest.debugToString());
			res.setStatus(org.springframework.http.HttpStatus.OK.value());
			response = GSON.toJson(ImmutableMap.of("success", "true"));
		} catch (Exception e) {
			LOGGER.error("Error handling consoleLogging data: {}, with exception: {}", req, e.toString());
			res.setStatus(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value());
			response = GSON.toJson(ImmutableMap.of("success", "false"));
		}
		return response;
	}
}
