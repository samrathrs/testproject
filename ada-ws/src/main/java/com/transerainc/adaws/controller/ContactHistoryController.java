package com.transerainc.adaws.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.service.AnalyzerServiceWrapper;

/**
 * @author trin3
 *
 */
@Controller
public class ContactHistoryController {

	private static Logger LOGGER = LoggerFactory
			.getLogger(ContactHistoryController.class.getName());

	private static final String CONTACT_HISTORY_BY_AGENT_MAPPING_KEY = "/contactHistoryByAgent";
	private static final String CONTACT_HISTORY_OF_ANI_MAPPING_KEY = "/contactHistoryOfANI";

	private static final String AGENT_SESSION_ID_PARAMETER_NAME = "agentSessionId";
	private static final String START_TIME_PARAMETER_NAME = "startTime";
	private static final String END_TIME_PARAMETER_NAME = "endTime";
	private static final String ANI_PARAMETER_NAME = "ani";
	private static final String CUSTOMERPHONE_PARAMETER_NAME = "customerPhoneNumber";

	@Autowired
	private WebSocketCacheManager webSocketCacheManager;

	@Autowired
	private AnalyzerServiceWrapper analyzerUtil;

	@RequestMapping(	value = ContactHistoryController.CONTACT_HISTORY_BY_AGENT_MAPPING_KEY,
					method = RequestMethod.GET)
	@ResponseBody
	public String handleContactHistoryByAgent(final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		LOGGER.debug("Received: contactHistoryByAgent request from UI: {}", req);

		final String agentSessionId = req.getParameter(AGENT_SESSION_ID_PARAMETER_NAME);
		final String startTimeParameter = req.getParameter(START_TIME_PARAMETER_NAME);
		final String endTimeParameter = req.getParameter(END_TIME_PARAMETER_NAME);

		LOGGER.info("contactHistoryByAgent: FE agent web token: {}, startTime: {}, endTime: {}",
				agentSessionId, startTimeParameter, endTimeParameter);

		String response = null;

		if ((org.apache.commons.lang3.StringUtils.isNotBlank(agentSessionId)) &&
			(org.apache.commons.lang3.StringUtils.isNotBlank(startTimeParameter)) &&
			(org.apache.commons.lang3.StringUtils.isNotBlank(endTimeParameter))) {
			try {
				long startTime = Long.valueOf(startTimeParameter);
				long endTime = Long.valueOf(endTimeParameter);
				final String backendAgentSessionId = webSocketCacheManager.getAgent(agentSessionId);
				LOGGER.info("contactHistoryByAgent: FE agent web token: {}, backendSessionId:{}", agentSessionId, backendAgentSessionId);
				response = analyzerUtil.getContactHistoryByAgent(backendAgentSessionId, startTime, endTime);
				res.setStatus(HttpStatus.SC_OK);
			} catch (NumberFormatException nfe) {
				LOGGER.error("NumberFormatException handling contactHistoryByAgent data: {}, agentSessionId: {}, startTimeParameter: {}, endTimeParameter: {}, with exception: {}",
						req,
						agentSessionId,
						startTimeParameter,
						endTimeParameter,
						nfe.toString());
				res.setStatus(HttpStatus.SC_BAD_REQUEST);
			} catch (Exception e) {
				LOGGER.error("Error handling contactHistoryByAgent data: {}, with exception: {}",
						req,
						e.toString());
				res.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
			}
		} else {
			res.setStatus(HttpStatus.SC_BAD_REQUEST);
		}

		LOGGER.debug("Returning: contactHistoryByAgent response to UI: {}, for request: {}", response, req);
		return response;
	}

	@RequestMapping(	value = ContactHistoryController.CONTACT_HISTORY_OF_ANI_MAPPING_KEY,
			method = RequestMethod.GET)
	@ResponseBody
	public String handleContactHistoryOfANI(final HttpServletRequest req,
		final HttpServletResponse res) throws Exception {
		LOGGER.debug("Received: handleContactHistoryOfANI request from UI: {}", req);

		final String agentSessionId = req.getParameter(AGENT_SESSION_ID_PARAMETER_NAME);
		final String startTimeParameter = req.getParameter(START_TIME_PARAMETER_NAME);
		final String endTimeParameter = req.getParameter(END_TIME_PARAMETER_NAME);
		final String ani = req.getParameter(ANI_PARAMETER_NAME);
		final String customerPhoneNumber = req.getParameter(CUSTOMERPHONE_PARAMETER_NAME);

		LOGGER.info("handleContactHistoryOfANI: FE agent web token: {}, startTime: {}, endTime: {}, ani: {}, customerPhoneNumber: {}",
				agentSessionId, startTimeParameter, endTimeParameter, ani, customerPhoneNumber);

		String response = null;

		if ((org.apache.commons.lang3.StringUtils.isNotBlank(agentSessionId)) &&
			(org.apache.commons.lang3.StringUtils.isNotBlank(startTimeParameter)) &&
			(org.apache.commons.lang3.StringUtils.isNotBlank(endTimeParameter)) &&
			(org.apache.commons.lang3.StringUtils.isNotBlank(ani))) {
			try {
				long startTime = Long.valueOf(startTimeParameter);
				long endTime = Long.valueOf(endTimeParameter);
				final String backendAgentSessionId = webSocketCacheManager.getAgent(agentSessionId);
				LOGGER.info("handleContactHistoryOfANI: FE agent web token: {}, backendSessionId:{}", agentSessionId, backendAgentSessionId);
				response = analyzerUtil.getContactHistoryByAni(backendAgentSessionId, ani, customerPhoneNumber, startTime, endTime);
				res.setStatus(HttpStatus.SC_OK);
			} catch (NumberFormatException nfe) {
				LOGGER.error("NumberFormatException handling handleContactHistoryOfANI data: {}, agentSessionId: {}, ani: {}, customerPhoneNumber: {}, startTimeParameter: {}, endTimeParameter: {}, with exception: {}",
						req,
						agentSessionId,
						ani,
						customerPhoneNumber,
						startTimeParameter,
						endTimeParameter,
						nfe.toString());
				res.setStatus(HttpStatus.SC_BAD_REQUEST);
			} catch (Exception e) {
				LOGGER.error("Error handling handleContactHistoryOfANI data: {}, with exception: {}",
						req,
						e.toString());
				res.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
			}
		} else {
			res.setStatus(HttpStatus.SC_BAD_REQUEST);
		}

		LOGGER.debug("Returning: handleContactHistoryOfANI response to UI: {}, for request: {}", response, req);
		return response;
	}
}
