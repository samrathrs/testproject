/**
 * 
 */
package com.transerainc.adaws.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.transerainc.adaws.cache.CacheServerManager;
import com.transerainc.adaws.cache.CacheTokenManager;
import com.transerainc.adaws.cache.TacgCacheManager;
import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.connection.HttpUtil;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.exception.ServerNotFoundException;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.CallAssociatedData;
import com.transerainc.adaws.model.CallAssociatedData.Data;
import com.transerainc.adaws.model.CallDataConfiguration;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.ServerData;
import com.transerainc.adaws.util.GenerateXmlUtil;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.StringUtils;
import com.transerainc.adaws.util.TacgServerUtil;
import com.transerainc.adaws.util.WebSocketDataPublisher;

/**
 * @author rajeev.lochanam
 */
public abstract class BaseService {
    private static Logger LOGGER = LoggerFactory.getLogger(BaseService.class.getName());
    protected final String DELIMITER = "~";

    @Autowired
    private DesktopConfigManager agentDesktopConfigMap;

    @Autowired
    protected WebSocketDataPublisher dataPublisher;

    @Autowired
    private GenerateXmlUtil generateXmlUtil;

    @Autowired
    private TacgServerUtil tacgServerUtil;

    @Autowired
    private TacgCacheManager adaTacgMap;

    @Autowired
    private HttpUtil httpUtil;

    @Autowired
    protected WebSocketCacheManager webSocketCacheManager;

    private String adaHost;
    private String adaPort;
    private String callBackUrl;

    @Autowired
    private CacheServerManager cacheServer;

    @Autowired
    private CacheTokenManager tokenManager;

    @Autowired
    protected PropertiesUtil propertiesUtil;

    /**
     * 
     */
    public BaseService() {
        final File propertiesFile = new File("./config/ada-ws.properties");
		try (FileInputStream fileStream = new FileInputStream(propertiesFile)) {
            final Properties properties = new Properties();
            properties.load(fileStream);
            // Internal communication with TACG should be on the non-DMZ port
            adaPort = properties.getProperty(AdaConstants.NON_DMZ_PORT);
            adaHost = properties.getProperty(AdaConstants.HOST_NAME);

            callBackUrl = AdaConstants.PROTOCOL + 
            		adaHost + 
            		AdaConstants.PORT_SEPARATOR + 
            		adaPort + 
            		AdaConstants.ADA_CALLBACK_URL;
        } catch (final FileNotFoundException e) {
            LOGGER.error("Exception occured while forming callBackUrl: " + e);
        } catch (final IOException e) {
            LOGGER.error("Exception occured while forming callBackUrl: " + e);
        }
    }

    /**
     * @param agentSessionId
     * @param xmlMessage
     * @return
     * @throws ServerNotFoundException
     */
    protected String hookHttpPost(final String agentSessionId) throws ServerNotFoundException {
        return httpPost(agentSessionId);
    }

    /**
     * @param serverData
     * @param agentSessionId
     * @param params
     * @return
     * @throws ServerNotFoundException
     */
    private String httpPost(final String agentSessionId) throws ServerNotFoundException {
        String responseString = "";

        LOGGER.info("mapping the server to : {}", agentSessionId);

        final DesktopConfiguration conf = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
        final List<ServerData> reloadedServers = loadServers(conf.getEnterpriseName(), "");

        LOGGER.info("{} server configured {}", conf.getEnterpriseName(), reloadedServers);
        if (reloadedServers == null || reloadedServers.isEmpty()) {
            LOGGER.info("{} throwing server not found", conf.getEnterpriseName(), reloadedServers);
            throw new ServerNotFoundException(conf.getEnterpriseName());
        }

        final int noOfServers = reloadedServers.size();
        boolean tryOtherServer = true;
        int failureCount = 0;
        while (tryOtherServer) {
            final ServerData sData = reloadedServers.get(failureCount);
            final String serverIp = sData.getHost() + ":" + sData.getPort();
            try {
                LOGGER.info("{} posting request to {} to map the server to agent", agentSessionId, sData);
                final String paramBody = DesktopConfigManager.getTokenada() + DELIMITER + adaHost + ":" + adaPort;
                
	           	responseString =httpUtil.doHeartBeatPost(paramBody, serverIp,
	           			StringUtils.getBoolean(propertiesUtil.getAdaProperty("sslEnabled")),
	                    propertiesUtil.getAdaProperty("heart.beat.context"));
	           	
	            	LOGGER.info("{} response from TACG {} for mapping the server to agent", agentSessionId, responseString);
    			
                boolean isError = checkResponse(responseString);
    				if (isError) {
    					LOGGER.error("Error starting a heartbeat for sessionId:{}, responseString:{}", agentSessionId, responseString);
    					
    					// try the other server 
    					LOGGER.info("agent : {}, retrying with other TACG {}", agentSessionId, serverIp);
    					failureCount++;
    	                	tryOtherServer = true;

    	                if (noOfServers == failureCount) {
    	                    tryOtherServer = false;
    	                    responseString = "";
    	                    throw new ServerNotFoundException(AdaConstants.SERVER_NOT_STARTED);
    	                }
    				} else {
	                sData.setTacgToken(responseString);
	                adaTacgMap.populateAdaTacgMap(agentSessionId, sData);
	                cacheServer.populateServer(serverIp, sData);
	                tokenManager.populateToken(responseString, serverIp);
	
	                tryOtherServer = false;
	                // cacheServer.updateServer(serverIp, responseString);
	                LOGGER.info("agent session : {} tide with TACG : {}", agentSessionId, serverIp);
    				}
 
            } catch (final ServerNotFoundException snf) {
                LOGGER.info("TACG not found for agent : {} retrying with other TACG {}", agentSessionId, serverIp);

                failureCount++;
                tryOtherServer = true;

                if (noOfServers == failureCount) {
                    tryOtherServer = false;
                    responseString = "";
                    throw new ServerNotFoundException(AdaConstants.SERVER_NOT_STARTED);
                }
            }
        }

        LOGGER.info("{} response in base service {}", agentSessionId, responseString);
        return responseString;
    }

    /**
     * @param agentSessionId
     * @param xmlMessage
     * @return
     */
    protected String doHttpPost(final String agentSessionId, final String xmlMessage) throws ServerNotFoundException {

        final StringBuilder param = new StringBuilder();
        param.append(AdaConstants.AGENT_SESSION_ID).append("=").append(agentSessionId);
        param.append("~;");
        param.append(AdaConstants.CALL_BACK_URL).append("=").append(callBackUrl);
        param.append("~;");
        param.append(AdaConstants.XML_STRING).append("=").append(xmlMessage);

        final ServerData serverData = adaTacgMap.getAdaTacgMap(agentSessionId);
        LOGGER.info("{} Posting the request to : {} ", agentSessionId, serverData);

        try {
            if (serverData == null) {
                LOGGER.info("{} throwing server not found", agentSessionId);
                throw new ServerNotFoundException(agentSessionId);
            }

            // return httpPost(serverData, agentSessionId, params);
            return httpUtil.doHttpPost(param.toString(), serverData,
                    StringUtils.getBoolean(propertiesUtil.getAdaProperty("sslEnabled")),
                    propertiesUtil.getAdaProperty("tacg.context.path"));
        } catch (final ServerNotFoundException snf) {
            final JSONObject jsonResponse = connectionLost();

            final AdaResponse adaResponse = new AdaResponse(CommandConstants.ERROR_OCCURRED, jsonResponse.toString(),
                    webSocketCacheManager.getToken(agentSessionId));

            dataPublisher.publishData(adaResponse);

            throw snf;
        }
    }

    /**
     * @return
     */
    protected JSONObject connectionLost() {
        final JSONObject jsonResponse = new JSONObject();
        try {
            jsonResponse.put(AdaConstants.CODE, String.valueOf(ContextConstants.ERROR_CONNECTION_LOST));
            jsonResponse.put(AdaConstants.DETAIL, "");
        } catch (final JSONException e) {
            LOGGER.error("Exception occured while forming json string on errorOccured condition {} " + e);
        }
        return jsonResponse;
    }

    /**
     * @param enterpriseName
     * @param failedTacg
     * @return
     */
    private List<ServerData> loadServers(final String enterpriseName, final String failedTacg) {
        tacgServerUtil.uploadBootstrapServerUrls(); // add during start up
        return tacgServerUtil.getAcgServers(enterpriseName, failedTacg);
    }

    /**
     * @param query
     * @param agentSessionId
     */
    protected void sendQuery(final String query, final String agentSessionId) {
        LOGGER.info(agentSessionId + " :===>> Inside send query : ");

        final String xmlMessage = generateXmlUtil.getXpathQueryXml(agentSessionId, query);

        LOGGER.info(agentSessionId + " :===>> Sending agent list query: " + xmlMessage);

        String responseString = null;
        try {
            responseString = doHttpPost(agentSessionId, xmlMessage);
        } catch (final ServerNotFoundException e) {
            LOGGER.error("{} :===>> error while sending query {} ", agentSessionId, query);
        }

        LOGGER.info(agentSessionId + " :===> response to agent list request :  : " + responseString);
    }

    /**
     * @param serviceRequestedToOther
     * @param agentSessionId
     */
    protected void changeServiceStatus(final boolean serviceRequestedToOther, final String agentSessionId) {
        final DesktopConfiguration conf = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
        conf.setServiceRequested(serviceRequestedToOther);
    }

    /**
     * @param cad
     * @param callDataConfig
     * @param agentSessionId
     */
    protected void publishUpdatedCalldata(final CallAssociatedData cad, final CallDataConfiguration callDataConfig,
            final String agentSessionId) {
        String callData = null;

        if (cad != null) {
            final SortedMap<String, Data> dataMap = cad.getDataMap();
            final TreeMap<String, Data> filteredMap = new TreeMap<String, Data>();
            if (dataMap != null && !dataMap.isEmpty()) {
                final Iterator<String> itr = dataMap.keySet().iterator();
                while (itr.hasNext()) {
                    final String key = itr.next();
                    if (callDataConfig.isAllowedKey(key)) {
                        filteredMap.put(key, dataMap.get(key));
                    }
                }
                final Gson gson = new GsonBuilder().create();
                callData = gson.toJson(filteredMap);

                if (StringUtils.isNotEmpty(callData)) {
                    final AdaResponse adaResponse = new AdaResponse(CommandConstants.UPDATE_CAD_DATA, "",
                            webSocketCacheManager.getToken(agentSessionId), callData);

                    dataPublisher.publishData(adaResponse);
                }
            }
        }
    }
    
	private boolean checkResponse(String resp) {
		SOAPMessage msg = null;
		SOAPBody body = null;
		SOAPFault fault = null;
		String  fcode = null;
		String fstr = null;
		
		try {
			msg = getSoapMessageFromString(resp);
			if (msg != null) {
				body = msg.getSOAPBody();
				
				if (body != null) {
					fault = body.getFault();
				
					if (fault != null) {
						fcode = fault.getFaultCode();
						fstr = fault.getFaultString();
						LOGGER.info("Error Authentication response fcode:{}, fstr:{}", fcode, fstr);
						return true;
					}
				}
			}
			LOGGER.info("No error found in responseString xml: fcode:{}, fstr:{}", fcode, fstr);
			
		} catch (SOAPException e) {
			// There will be a SOAPException for non-soap responses like 1511078787TACG-Default
			//LOGGER.info("checkResponse() : SOAPException:{}", e.getCause());
			
		} catch (IOException e) {
			LOGGER.info("checkResponse() : IOException:{}", e.getCause());
		}

		return false;
    }
    
    private SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
        MessageFactory factory = MessageFactory.newInstance();
        
        if ((xml != null) && (!xml.isEmpty())) {
        		SOAPMessage message = factory.createMessage(
        				new MimeHeaders(), 
        				new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
        		return message;
        }
        return null;
    }
    
}
