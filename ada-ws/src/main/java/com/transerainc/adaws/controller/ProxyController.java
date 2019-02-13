/**
 * 
 */
package com.transerainc.adaws.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.connection.HttpUtil;
import com.transerainc.adaws.json.ProxyJson;
import com.transerainc.adaws.model.DesktopConfiguration;


/**
 * @author rajeev.lochanam
 */
@Controller
public class ProxyController {

	private static final Logger lgr = LoggerFactory.getLogger(ProxyController.class);

	private static final String URI_PARAM = "uri";
	private static final String WATSON_ANALYTICS_USERNAME_PASSWORD_SEPARATOR = ":";
	private static final String AUTHORIZATION_PREFIX = "Basic ";

	@Autowired
	private DesktopConfigManager agentDesktopConfigMap;

	@Autowired
	private WebSocketCacheManager webSocketCacheManager;

	@RequestMapping(value = "/proxyGETRequest", method = RequestMethod.GET)
	public @ResponseBody String handleProxyGet(final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		String response = null;
		String uri = req.getParameter(URI_PARAM);
		lgr.info("Proxying request to {}", uri);
		HttpClient httpClient = new HttpClient();
		// Supports only GET right now
		GetMethod method = new GetMethod(uri);
		// Proxy all the request headers
		Enumeration<String> headerNames = req.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			method.addRequestHeader(headerName, req.getHeader(headerName));
		}
		// Proxy all the parameters
		Enumeration<String> parameterNames = req.getParameterNames();
		List<NameValuePair> params = new ArrayList<>();
		while (parameterNames.hasMoreElements()) {
			String p = parameterNames.nextElement();
			// SKIP the URI param
			if (p.equals(URI_PARAM)) {
				continue;
			}
			params.add(new NameValuePair(p, req.getParameter(p)));
		}
		method.setQueryString(params.toArray(new NameValuePair[params.size()]));
		// Open a connection to the requested URL
		httpClient.executeMethod(method);
		// Proxy filtered response headers
		for (Header header : method.getResponseHeaders()) {
			String name = header.getName();
			if ("Content-Type".equals(name)) {
				res.setHeader(name, header.getValue());
			}else if("WWW-Authenticate".equals(name)){
				res.setHeader("Authorization", header.getValue());
			}
		}
		// Proxy the response code, and string
		int statusCode = method.getStatusCode();
		res.setStatus(statusCode);
		response = method.getResponseBodyAsString();
		lgr.info("Relaying the response from {} with status code {}: {}", uri,
				statusCode, response);
		return response;
	}
	
	@CrossOrigin(origins = "*", 
				methods = {RequestMethod.OPTIONS, RequestMethod.POST}, 
				allowedHeaders = {"Origin", "X-Requested-With", "Content-Type", "Accept"})
	@RequestMapping(value = "/proxyPOSTRequest", 
					method = RequestMethod.POST, 
					produces = { MediaType.APPLICATION_JSON_VALUE }, 
					consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody String handleProxyPost(final HttpServletRequest req,
					final HttpServletResponse res) throws Exception {
		String response = null;

		String bodyPayloadData = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		lgr.info("Raw body payload data: {}", bodyPayloadData);


		try {
			final String agentToken = ProxyJson.getAgentSessionId(bodyPayloadData);
			lgr.info("FE agent web token: {}", agentToken);
			final String backendAgentSessionId = webSocketCacheManager.getAgent(agentToken);
			final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendAgentSessionId);

			if (desktopConfig != null) {
				final String requestData = ProxyJson.getRequestDataFromStringifiedJson(bodyPayloadData);
				lgr.info("Request data: {}", requestData);

				final String analyticsUrl = desktopConfig.getWatsonAnalyticsBaseUrl();
				final String analyticsUserName = desktopConfig.getWatsonAnalyticsUserName();
				final String analyticsPassword = desktopConfig.getWatsonAnalyticsPassword();

				lgr.debug("analyticsUrl: {}, analyticsUserName: {}, analyticsPassword: {}",
						analyticsUrl,
						analyticsUserName,
						analyticsPassword);


				if (
						org.apache.commons.lang3.StringUtils.isNotBlank(analyticsUrl) && 
						org.apache.commons.lang3.StringUtils.isNotBlank(analyticsUserName) && 
						org.apache.commons.lang3.StringUtils.isNotBlank(analyticsPassword)
						) {
					lgr.info("Proxying request to uri watson: {}", analyticsUrl);
					
					final StringBuilder analyticsAuthStringBuilder = new StringBuilder(analyticsUserName);
					analyticsAuthStringBuilder.append(WATSON_ANALYTICS_USERNAME_PASSWORD_SEPARATOR);
					analyticsAuthStringBuilder.append(analyticsPassword);
					final String analyticsAuth = analyticsAuthStringBuilder.toString();

					final byte[] authEncBytes = Base64.encodeBase64(analyticsAuth.getBytes());
					final String authStringEnc = new String(authEncBytes);

					lgr.info("Watson Analytics Auth: {}", analyticsAuth);
					lgr.info("Watson Analytics Encoded Auth: {}", authStringEnc);
					
					final StringBuilder authorizationStringBuilder = new StringBuilder(AUTHORIZATION_PREFIX);
					authorizationStringBuilder.append(authStringEnc);
					final String authorization = authorizationStringBuilder.toString();
					
					response = HttpUtil.doHttpJsonPostAuth(analyticsUrl, requestData, authorization);
					res.setStatus(200);
					lgr.info("Watson response: {}", response);
					return response;
				} else {
					lgr.info("Watson credentials are blank. analyticsUrl: {}, analyticsUserName: {}, analyticsPassword: {}",
							analyticsUrl,
							analyticsUserName,
							analyticsPassword);
					
				}
			} 
			res.setStatus(500);
		} catch (JSONException jsonException) {
			lgr.error("JSONException occurred while extracting elements from raw body payload: {}", bodyPayloadData);
			res.setStatus(400);
		}
		return response;
	}

	@CrossOrigin(origins = "*", 
			methods = {RequestMethod.OPTIONS, RequestMethod.POST}, 
			allowedHeaders = {"Origin", "X-Requested-With", "Content-Type", "Accept"})
	@RequestMapping(value = "/lcm", 
			method = RequestMethod.POST, 
			produces = { MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody String proxyLcmRequest(final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		String response = null;

		final String bodyPayloadData = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		lgr.info("Raw body payload data: {}", bodyPayloadData);

		try {
			final String agentToken = ProxyJson.getAgentSessionId(bodyPayloadData);
			lgr.info("FE agent web token: {}", agentToken);
			final String backendAgentSessionId = webSocketCacheManager.getAgent(agentToken);
			final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendAgentSessionId);

			if (desktopConfig != null) {
				try {
					// Retrieve LCM (Campaign Manager URL)
					final String campaignManagerUrl = desktopConfig.getCampaignManagerUrl();

					final String url = campaignManagerUrl + req.getParameter(URI_PARAM);
					lgr.info("Proxying request to {}", url);
					
					// Retrieve body
					lgr.info("Raw request body: {}", bodyPayloadData);
					final String requestData = ProxyJson.getRequestDataFromJson(bodyPayloadData);
		
					response = HttpUtil.doHttpJsonPost(url, requestData);
					
					res.setStatus(200);
					lgr.info("Relaying the response from {} with status code {}: {}", 
							url,
							res.getStatus(),
							response);
				} catch (Exception e) {
					lgr.error("Error occurred proxying to uri: {}, with body: {}, for agent session id: {}",
							req.getParameter(URI_PARAM),
							bodyPayloadData,
							agentToken);
					res.setStatus(500);
				}
			} else {
				lgr.warn("Desktop Configuration for FE Agent Session Id/Web Token: {}, does not exist in BE.",
						agentToken);
				res.setStatus(500);
			}
		} catch (JSONException jsonException) {
			lgr.error("JSONException occurred while extracting elements from raw body payload: {}", bodyPayloadData);
			res.setStatus(400);
		}
		return response;
	}
}
