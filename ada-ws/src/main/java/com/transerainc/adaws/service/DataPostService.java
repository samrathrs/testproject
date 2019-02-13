/**
 * 
 */
package com.transerainc.adaws.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

import com.transerainc.adaws.cache.TacgCacheManager;
import com.transerainc.adaws.constants.*;
import com.transerainc.adaws.exception.ServerNotFoundException;
import com.transerainc.adaws.json.OmniChannelJsonUtil;
import com.transerainc.adaws.model.ServerData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transerainc.adaws.connection.HttpUtil;
import com.transerainc.adaws.exception.CommunicationException;
import com.transerainc.adaws.model.AdaRequest;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.SignatureHelper;
import com.transerainc.adaws.util.SpringContextHelper;
import com.transerainc.adaws.util.StringUtils;
import com.transerainc.adaws.util.PropertiesUtil;

/**
 * @author varsha.shivaram
 */
@Service
public class DataPostService extends BaseService implements AgentStateConstants, ContextConstants {

    private static Logger LOGGER = LoggerFactory.getLogger(DataPostService.class.getName());

    @Autowired
    private SignatureHelper signatureHelper;

    @Autowired
    private HttpUtil httpUtil;

	@Autowired
	protected TacgCacheManager adaTacgMap;

	private static final String HTTPS_PROTOCOL = "https://";
	private static final String HTTP_PROTOCOL = "http://";

    /**
     * @param adaRequest
     * @param agentSessionId
     * @param callId
     * @param desktopConfig
     */
    public void postDataToCrmLite(final AdaRequest adaRequest, final String agentSessionId,
            final DesktopConfiguration config, final String callId) {
        final String crmLiteUrl = config.getValue(AppParams.CRM_LITE_URL);
        final String emailId = config.getValue(AppParams.EMAIL_ID);
        final String key = config.getValue(AppParams.KEY);
        final long timestamp = System.currentTimeMillis();
        final boolean larFlag = adaRequest.isDoLar();
        final String agentId = config.getAgentId();

        try {

            if (StringUtils.isNotEmpty(crmLiteUrl) && StringUtils.isNotEmpty(agentId) && StringUtils.isNotEmpty(callId)
                    && larFlag) {

                final ObjectMapper mapper = new ObjectMapper();

                final Map<String, Object> attrMap = new HashMap<String, Object>();
                attrMap.put(LAR_AGENT_ID, agentId);
                attrMap.put(LAR, StringUtils.booleanToInt(larFlag));
                attrMap.put(SID, callId);

                final Map<String, Object> dataMap = new HashMap<String, Object>();
                dataMap.put(TENANT_ID, config.getEnterpriseId());
                dataMap.put(TIMESTAMP, timestamp);
                dataMap.put(EVENT_NAME, EVENT_NAME_ADD);
                dataMap.put(ENTITY_ID, callId);
                dataMap.put(ATTRIBUTE_MAP, attrMap);

                final String map = mapper.writeValueAsString(dataMap);

                final String autorizationId = signatureHelper.computeSignature(emailId, key);

                final Map<String, String> headersMap = new HashMap<String, String>();
                headersMap.put(CONTENT_TYPE, AdaConstants.CONTENT_TYPE_JSON);
                headersMap.put(AUTHORIZATION, autorizationId);
                headersMap.put(FROM, emailId);

                LOGGER.info(agentSessionId
                        + String.format(" Posting data to CRM lite url %s with params %s and headers %s", crmLiteUrl,
                                map, headersMap));

                final String response = httpUtil.doHttpJSONPut(crmLiteUrl, map, headersMap);

                LOGGER.info(agentSessionId + "{} Response from crmlite {} is {} ", crmLiteUrl, response);

            } else {
                LOGGER.error(agentSessionId
                        + " :===>> Failed to post data to CRM Lite with the parameters - crmLiteUrl:" + crmLiteUrl
                        + " larFlag:" + larFlag + " agentId:" + agentId);
            }

		} catch (JsonProcessingException | SignatureException
				| CommunicationException e) {
			LOGGER.error(agentSessionId
					+ " Failed to post data to CRM Lite for agentSessionId "
					+ agentSessionId + " and CRM Lite url: " + crmLiteUrl, e);
		}
    }

    /**
     * @param callId
     * @param message
     * @param queueId
     * @param supervisorAlertUrl
     * @param config
     */
    public boolean sendSupervisorAlert(final String callId, final String message, final String queueId,
            final String supervisorAlertUrl, final DesktopConfiguration config) {
        if (!org.springframework.util.StringUtils.hasText(supervisorAlertUrl)
                || !org.springframework.util.StringUtils.hasText(callId)) { return false; }

        try {
            final String content = "callSessionId=" + URLEncoder.encode(callId, "UTF-8") + "&reason="
                    + URLEncoder.encode(message, "UTF-8") + "&enterpriseId=" + config.getEnterpriseId() + "&teamId="
                    + config.getTeamId() + "&agentId=" + config.getAgentId() + "&siteId=" + config.getSiteId()
                    + "&queueId=" + URLEncoder.encode(queueId, "UTF-8") + "&agentName="
                    + URLEncoder.encode(config.getAgentName(), "UTF-8") + "&login="
                    + URLEncoder.encode(config.getAgentName(), "UTF-8");

            LOGGER.info(config.getAgentSessionId() + " :===>> Send supervisor alert : " + content);

            final URL url = new URL(supervisorAlertUrl);
            final HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            uc.setRequestMethod("POST");
            uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            uc.setRequestProperty("Content-Length", "" + Integer.toString(content.getBytes().length));
            uc.setDoInput(true);
            uc.setDoOutput(true);
            uc.setUseCaches(false);
            uc.setConnectTimeout(getTimeoutSetting("safConnectTimeout", 10000, config));
            uc.setReadTimeout(getTimeoutSetting("safReadTimeout", 10000, config));

            final OutputStreamWriter wr = new OutputStreamWriter(uc.getOutputStream());
            wr.write(content);
            wr.flush();
            wr.close();

            uc.getInputStream().read();
            return true;
		} catch (IOException e) {
			LOGGER.error(config.getAgentSessionId()
					+ " Failed to send supervisor alert for call " + callId
					+ " and supervisor alert url: " + supervisorAlertUrl, e);
		}
        return false;
    }

    private int getTimeoutSetting(final String name, final int defaultValue, final DesktopConfiguration config) {
        int r = defaultValue;
        String value = config.getValue(name);
        if (value == null || "".equals(value)) {
            value = "";
        }
        LOGGER.info(config.getAgentSessionId() + " in getConfigSetting(): " + name + " -> " + value);
        if (value != null && !"".equals(value)) {
            try {
                r = Integer.parseInt(value);
            } catch (final Exception e) {
                LOGGER.warn(config.getAgentSessionId() + " Timeout setting " + name + " has invalid value: " + value);
            }
        }
        return r;
    }

	public String getAgentTpp(final DesktopConfiguration config, String teamId, String agentSessionId) throws Exception {

		final ServerData serverData = adaTacgMap.getAdaTacgMap(agentSessionId);
		if (serverData == null) {
			LOGGER.info("{} throwing server not found", agentSessionId);
			throw new ServerNotFoundException(agentSessionId);
		}
		Boolean isSecure =	 StringUtils.getBoolean(propertiesUtil.getAdaProperty("sslEnabled"));
		String jACGURL=(isSecure ? HTTPS_PROTOCOL : HTTP_PROTOCOL) + serverData.getHost() + ":" + serverData.getPort() + "/" + "aim/tppIntf";
		final String aimUrlProperty = SpringContextHelper.getBean(PropertiesUtil.class).getAdaProperty(AppParams.AIMURL);
		String primaryAimUrl = null;
		String backupAimUrl = null;
		String response = "";
		String content = null;

		if(aimUrlProperty == null || aimUrlProperty.length()<=0){
			return response;
		}

		if(aimUrlProperty.contains(",")){
			String aimUrl[] = aimUrlProperty.split(",");
			primaryAimUrl = aimUrl[0];
			backupAimUrl = aimUrl[1];
		}else{
			primaryAimUrl = aimUrlProperty;
			backupAimUrl = aimUrlProperty;
		}

		content = "agentId=" + config.getAgentId() +"&teamId=" + teamId
				+ "&siteId=" + config.getSiteId()+"&sId="+config.getAgentSessionId();

		LOGGER.warn("Aim URLs:"+primaryAimUrl+","+backupAimUrl +" JACG URL :"+ jACGURL +":"+content);
		try{
			LOGGER.info("Trying for the jACG URL {}" ,jACGURL);
			response = postToAim(jACGURL ,content, config);
		}catch(Exception e){
			try{
				LOGGER.info("Trying for the primary Aim Url{}" ,primaryAimUrl);
				response = postToAim(primaryAimUrl,content, config);
			}catch(Exception e1){
				try{
					LOGGER.info("Trying for the backup Aim Url{}" ,backupAimUrl);
					response = postToAim(backupAimUrl, content, config);
				}catch(Exception e2){
					response = "";
					LOGGER.error("Aim Error Response:" + e2.getMessage());
					throw e2;
				}

			}
		}
		LOGGER.warn("Aim Response:"+response);

		return response;
	}
	private String postToAim(String tppURL,String content, final DesktopConfiguration config) throws Exception{
		URL url = new URL(tppURL);
		HttpURLConnection uc = (HttpURLConnection)url.openConnection();
		uc.setRequestMethod("GET");
		uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		uc.setRequestProperty("Content-Length", "" +
				Integer.toString(content.getBytes().length));
		uc.setDoInput(true);
		uc.setDoOutput(true);
		uc.setUseCaches(false);
		uc.setConnectTimeout(getTimeoutSetting("aimConnectTimeout",10000, config));
		uc.setReadTimeout(getTimeoutSetting("aimReadTimeout",10000, config));

		OutputStreamWriter wr = new OutputStreamWriter(uc.getOutputStream());
		wr.write(content);
		wr.flush();
		wr.close();

		Reader reader = new InputStreamReader(uc.getInputStream(),
				"UTF-8");
		StringBuffer buffer = new StringBuffer();

		if(uc.getResponseCode() == HttpStatus.OK.value()){
			int c;
			while ( (c = uc.getInputStream().read()) != -1) {
				buffer.append((char) c);
			}
		}

		reader.close();
		return buffer.toString();
	}

	public String doIcrmlogin(AdaRequest adaRequest, DesktopConfiguration config)
			throws Exception {
		String icrmUrl = adaRequest.getChatUrl();
		String idleCodes = adaRequest.getIdleCodeIds();
		String idleNames = adaRequest.getIdleCodeNames();
		String wrapupCodes = adaRequest.getWrapUpCodeIds();
		String wrapupNames = adaRequest.getWrapCodeNames();
		String isSysCodes = adaRequest.getIsSysCodes();

		// String aimUrl = ctx.getInitParameter("aimUrl");
		if (icrmUrl == null || "".equals(icrmUrl)) {
			return "";
		}


		String content = "{\"operation\":\"login\"," + "\"agentId\":"
				+ config.getAgentId() + ","
				// + "\"role\": 3"
				// + ","
				+ "\"tenantId\":" + config.getEnterpriseId() + ","
				+ "\"sessionId\":" + "\"" + config.getAgentSessionId() + "\""
				+ "," + "\"applicationId\":3,"
				/*
				 * + "\"adaUrl\":" + "\"" + "http://localhost:" +
				 * SpringContextHelper.getBean(PropertiesUtil.class)
				 * .getAdaProperty(AppParams.HTTP_SERVER_PORT) + "/request" +
				 * "\"" + ","
				 */
				+ getIdleCodeJson(idleCodes, idleNames, isSysCodes, config)
				+ "," + getWrapUpCodeJson(wrapupCodes, wrapupNames, config)
				+ "}";

		LOGGER.info("ICRM URL:" + icrmUrl + ":" + content);
		URL url = new URL(icrmUrl);
		HttpURLConnection uc = (HttpURLConnection) url.openConnection();
		uc.setRequestMethod("GET");
		uc.setRequestProperty("Content-Type", "application/json");
		uc.setRequestProperty("Content-Length",
				"" + Integer.toString(content.getBytes().length));
		uc.setDoInput(true);
		uc.setDoOutput(true);
		uc.setUseCaches(false);
		uc.setConnectTimeout(
				getTimeoutSetting("icrmConnectTimeout", 10000, config));
		uc.setReadTimeout(getTimeoutSetting("icrmReadTimeout", 10000, config));

		OutputStreamWriter wr = new OutputStreamWriter(uc.getOutputStream());
		wr.write(content);
		wr.flush();
		wr.close();

		Reader reader = new InputStreamReader(uc.getInputStream(), "UTF-8");
		StringBuffer buffer = new StringBuffer();
		int c;
		while ((c = uc.getInputStream().read()) != -1) {
			buffer.append((char) c);
		}
		reader.close();
		LOGGER.info("ICRM Response:" + buffer.toString());
		return buffer.toString();

	}
	private String getIdleCodeJson(String id, String name, String isSystem, DesktopConfiguration config)
	{
		String[] idleCode = id.split(",");
		String[] idleNames = name.split(",");
		String[] isSysCodes = isSystem.split(",");
		String defaultId =config.getDefaultIdleId();
		StringBuffer buffer = new StringBuffer();
		buffer.append("\"idleCodes\":[");
		for(int i=0;i<idleCode.length;i++){
			if(idleCode[i].equalsIgnoreCase(defaultId)){
				buffer.append("{\"key\":"+ "\""+idleCode[i]+ "\""+","
			            +"\"code\":"+ "\""+idleCode[i]+ "\""+","
			            +"\"name\":"+ "\""+idleNames[i]+ "\""+","
			            +"\"isDefault\":true"+"," 
			            +"\"isSystem\":"+ "\""+isSysCodes[i]+ "\"},");
			}else{
				buffer.append("{\"key\":"+ "\""+idleCode[i]+ "\""+","
			            +"\"code\":"+ "\""+idleCode[i]+ "\""+","
			            +"\"name\":"+ "\""+idleNames[i]+ "\""+","
			            +"\"isDefault\":false"+"," 
			            +"\"isSystem\":"+ "\""+isSysCodes[i]+ "\"},");
			}
		}
		
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("]");
		return buffer.toString();
	}
	
	private String getWrapUpCodeJson(String id, String name, DesktopConfiguration config )
	{
		String[] wrapupCode = id.split(",");
		String[] wrapupNames = name.split(",");
		String defaultId = config.getDefaultWrapUpId();
		StringBuffer buffer = new StringBuffer();
		buffer.append("\"wrapUpCodes\":[");
		for(int i=0;i<wrapupCode.length;i++){
			if(wrapupCode[i].equalsIgnoreCase(defaultId)){
				buffer.append("{\"pKey\":"+ "\""+wrapupCode[i]+ "\""+","
			            +"\"code\":"+ "\""+wrapupCode[i]+ "\""+","
			            +"\"description\":"+ "\""+wrapupNames[i]+ "\""+","
			            +"\"isDefault\":true"+"," 
			            +"\"level\":1},");
			}else{
				buffer.append("{\"pKey\":"+ "\""+wrapupCode[i]+ "\""+","
			            +"\"code\":"+ "\""+wrapupCode[i]+ "\""+","
			            +"\"description\":"+ "\""+wrapupNames[i]+ "\""+","
			            +"\"isDefault\":false"+"," 
			            +"\"level\":1},");
			}
		}
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("]");
		return buffer.toString();
	}

	public String doIcrmLogout(AdaRequest adaRequest,
			DesktopConfiguration config) throws Exception {
		String icrmUrl = adaRequest.getChatUrl();
		String sessionId = adaRequest.getagentSessionId();
		if (icrmUrl == null || "".equals(icrmUrl)) {
			return "";
		}

		try {
			icrmUrl = icrmUrl.substring(0, icrmUrl.lastIndexOf("/"));
			icrmUrl = icrmUrl + "/logout/" + sessionId + "/" + "3";

			LOGGER.info("ICRM URL:" + icrmUrl);
			URL url = new URL(icrmUrl);
			HttpURLConnection uc = (HttpURLConnection) url.openConnection();
			uc.setRequestMethod("GET");
			uc.setRequestProperty("Content-Length", "" + 0);
			uc.setDoInput(true);
			uc.setDoOutput(true);
			uc.setUseCaches(false);
			uc.setConnectTimeout(getTimeoutSetting("icrmConnectTimeout", 10000,
					config));
			uc.setReadTimeout(getTimeoutSetting("icrmReadTimeout", 10000,
					config));

			Reader reader = new InputStreamReader(uc.getInputStream(), "UTF-8");
			StringBuffer buffer = new StringBuffer();
			int c;
			while ((c = uc.getInputStream().read()) != -1) {
				buffer.append((char) c);
			}
			reader.close();
			LOGGER.info("ICRM Response:" + buffer.toString());
			return buffer.toString();
		} catch (Exception e) {
			LOGGER.error("ICRM Error Response:" + e.getMessage());
			throw e;
		}
	}


}
