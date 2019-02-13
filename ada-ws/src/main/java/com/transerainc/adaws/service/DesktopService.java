package com.transerainc.adaws.service;

import java.util.*;

import com.transerainc.adaws.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AgentProfileConstants;
import com.transerainc.adaws.constants.AppParams;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.constants.OmniChannelCommonConstants;
import com.transerainc.adaws.exception.ServerNotFoundException;
import com.transerainc.adaws.json.OmniChannelJsonUtil;
import com.transerainc.adaws.json.StateCacheJson;
import com.transerainc.adaws.model.cache.icrm.IcrmResponse;
import com.transerainc.adaws.util.GenerateXmlUtil;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.SpringContextHelper;
import com.transerainc.adaws.util.WebSocketDataPublisher;

@Service
public class DesktopService extends BaseService {

    private static Logger LOGGER = LoggerFactory.getLogger(DesktopService.class.getName());

    public static final String PAIR_SEPARATOR = "=";
    public static final String VARIABLE_SEPARATOR = ";";

    @Autowired
    private DesktopConfigManager agentDesktopConfigMap;

    @Autowired
    private WebSocketDataPublisher dataPublisher;

    @Autowired
    private GenerateXmlUtil generateXmlUtil;

    @Autowired
    private WebSocketCacheManager webSocketCacheManager;

    @Autowired
    private DataPostService dataPostService;

    /**
     * @param adaRequest
     */
    public void querySpeedDialList(final AdaRequest adaRequest) {
        final String agentSessionId = adaRequest.getagentSessionId();

        final DesktopConfiguration config = agentDesktopConfigMap.getConfigForAgent(agentSessionId);

        if (config != null) {
            final Map<String, String> speedDialList = config.getAgentProfile().getEntityList(AgentProfileConstants.SPEED_DIAL_LIST);

            final String dialList = speedDialList == null ? "{}" : convertJson(speedDialList);
            LOGGER.info(agentSessionId + " :===>> Speed dial list : " + dialList);

            final AdaResponse response = new AdaResponse(CommandConstants.SPEED_DIAL_LIST_CHANGED, dialList,
                    webSocketCacheManager.getToken(agentSessionId));

            dataPublisher.publishData(response);
            LOGGER.info(agentSessionId + " :===>> Inside speed dial list request - end : " + adaRequest);
        }
    }

    /**
     * @param adaRequest
     */
    public void queryVteamList(final AdaRequest adaRequest) {
        final String agentSessionId = adaRequest.getagentSessionId();
        LOGGER.info(agentSessionId + " :===>> Inside query vteam list : " + adaRequest);

        final String queryString = generateXmlUtil.getTransferListQueryString(agentSessionId,
                ContextConstants.VIRTUAL_TEAM);

        LOGGER.info(agentSessionId + " :===>> vteam list query string : " + queryString);

        sendQuery(queryString, agentSessionId);
    }

    /**
     * @param adaRequest
     */
    public void sendSupervisorAlert(final AdaRequest adaRequest) {
        final String agentSessionId = adaRequest.getagentSessionId();

        final DesktopConfiguration config = agentDesktopConfigMap.getConfigForAgent(agentSessionId);

        final String callId = config.getStateChangeData().getCallId();
        final String queueId = config.getCallModel().getVteamId();
        final String message = adaRequest.getSupervisorMessage();
        final String supervisorAlertUrl = SpringContextHelper.getBean(PropertiesUtil.class).getAdaProperty(AppParams.SUPERVISOR_ALERT_URL);
        boolean alertSentSuccess = false;

        alertSentSuccess = dataPostService.sendSupervisorAlert(callId, message, queueId, supervisorAlertUrl, config);

        final AdaResponse adaResponse = new AdaResponse(CommandConstants.SUPERVISOR_ALERT_SENT, "" + alertSentSuccess,
                webSocketCacheManager.getToken(agentSessionId));
        dataPublisher.publishData(adaResponse);
    }

    /**
     * @param adaRequest
     */
    public void requestPauseRecording(final AdaRequest adaRequest) {
        final String agentSessionId = adaRequest.getagentSessionId();
        final DesktopConfiguration config = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
        final String callId = config.getStateChangeData().getCallId();

        LOGGER.info(config.getAgentSessionId() + " :===>> Privacy Shield requested : on");

        if (callId != null) {
            long startTime = 0;

            if (LOGGER.isInfoEnabled()) {
                startTime = System.currentTimeMillis();
                LOGGER.info(agentSessionId + " :===>> got pause recording request at : " + startTime);
            }

            config.getCallModel().setPrivacyShieldEnabled(false);
            final String xml = generateXmlUtil.getPrivacyShieldOn(agentSessionId, true);

            String responseString = null;
            try {
                responseString = doHttpPost(agentSessionId, xml);
            } catch (final ServerNotFoundException e) {
                LOGGER.error("{} :===> server not found for pause recording request :  : {}", agentSessionId,
                        responseString);
            }
            LOGGER.info(agentSessionId + " :===> response to pause recording request :  : " + responseString);

            if (LOGGER.isInfoEnabled()) {
                final long endTime = System.currentTimeMillis() - startTime;
                LOGGER.info(agentSessionId + " :===>> Finished handle pause recording request : " + endTime);
            }
        }
    }

    /**
     * @param adaRequest
     */
    public void requestResumeRecording(final AdaRequest adaRequest) {
        final String agentSessionId = adaRequest.getagentSessionId();
        final DesktopConfiguration config = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
        final String callId = config.getStateChangeData().getCallId();

        LOGGER.info(config.getAgentSessionId() + " :===>> Privacy Shield requested : off");

        if (callId != null) {
            long startTime = 0;

            if (LOGGER.isInfoEnabled()) {
                startTime = System.currentTimeMillis();
                LOGGER.info(agentSessionId + " :===>> got resume recording request at : " + startTime);
            }

            config.getCallModel().setPrivacyShieldEnabled(false);
            final String xml = generateXmlUtil.getPrivacyShieldOn(agentSessionId, false);

            String responseString = null;
            try {
                responseString = doHttpPost(agentSessionId, xml);
            } catch (final ServerNotFoundException e) {
                LOGGER.error("{} :===> server not found for resume recording request :  : {}", agentSessionId,
                        responseString);
            }
            LOGGER.info(agentSessionId + " :===> response to resume recording request :  : " + responseString);

            if (LOGGER.isInfoEnabled()) {
                final long endTime = System.currentTimeMillis() - startTime;
                LOGGER.info(agentSessionId + " :===>> Finished handle resume recording request : " + endTime);
            }
        }
    }

    /**
     * @param reqMap
     * @return
     */
    private String convertJson(final Map<String, String> reqMap) {
        // convert to json
        final Gson gson = new GsonBuilder().create();
        return gson.toJson(marshallProperties(reqMap));
    }

    /**
     * @param map
     * @return
     */
    private List<SpeedDialModel> marshallProperties(final Map<String, String> map) {
        if (map == null) { return null; }

        final List<SpeedDialModel> speedDialList = new ArrayList<SpeedDialModel>(map.size());
        final Set<String> keys = map.keySet();
        for (final String key : keys) {
            // final String key = StringUtils.trimAllWhitespace(string);
            final String value = map.get(key);
            String s = "";
            if (value != null) {
                // s = StringUtils.trimAllWhitespace(value.toString());
                s = value.toString();
            }
            final SpeedDialModel speedDialModel = new SpeedDialModel(key, s);
            speedDialList.add(speedDialModel);
        }

        return speedDialList;
    }
	public void doIcrmlogin(final AdaRequest adaRequest) {
		final String agentSessionId = adaRequest.getagentSessionId();
		if( adaRequest.getChatUrl() == null || "".equals(adaRequest.getChatUrl()) ){
			final AdaResponse adaResponse = new AdaResponse(CommandConstants.ICRMLOGINRESPONSE, "" + "",
	                webSocketCacheManager.getToken(agentSessionId));
			 dataPublisher.publishData(adaResponse);
		}
		final DesktopConfiguration config = agentDesktopConfigMap
				.getConfigForAgent(agentSessionId);
		String icrmLoginResponse = null;
		try {
			icrmLoginResponse = dataPostService.doIcrmlogin(adaRequest, config);
		} catch (Exception e) {
			LOGGER.error("ICRM login Error Response:" + e.getMessage());
		}
		
		LOGGER.info(agentSessionId + " :===> icrmresponse :  : " + icrmLoginResponse);
		
		final AdaResponse adaResponse = new AdaResponse(CommandConstants.ICRMLOGINRESPONSE, "" + icrmLoginResponse,
                webSocketCacheManager.getToken(agentSessionId));
        dataPublisher.publishData(adaResponse);
	}
	public void getAgentTpp(final AdaRequest adaRequest) {
		final String agentSessionId = adaRequest.getagentSessionId();
		final DesktopConfiguration config = agentDesktopConfigMap
				.getConfigForAgent(agentSessionId);
		String icrmresponse = null;
		try {
			icrmresponse = dataPostService.getAgentTpp(config, adaRequest.getTeamId(), agentSessionId);
		} catch (Exception e) {
			LOGGER.error("ICRM Error Response:" + e.getMessage());
		}
		// update omnichannel capabilities here
		setChannelCapabilities(icrmresponse, config);
			
		LOGGER.info(agentSessionId + " :===> icrmresponse :  : " + icrmresponse);

		if ((org.apache.commons.lang3.StringUtils.isNotBlank(icrmresponse)) && (config != null)) {
			IcrmResponse icrmResponse = StateCacheJson.getIcrmResponseFromJsonString(icrmresponse);
			config.setIcrmResponse(icrmResponse);
		}

		final AdaResponse adaResponse = new AdaResponse(CommandConstants.ICRMRESPONSE, "" + icrmresponse,
                webSocketCacheManager.getToken(agentSessionId));
        dataPublisher.publishData(adaResponse);
	}
	public void doIcrmlogout(final AdaRequest adaRequest) {
		final String agentSessionId = adaRequest.getagentSessionId();
		if( adaRequest.getChatUrl() == null || "".equals(adaRequest.getChatUrl()) ){
			final AdaResponse adaResponse = new AdaResponse(CommandConstants.ICRMLOGINRESPONSE, "" + "",
	                webSocketCacheManager.getToken(agentSessionId));
			 dataPublisher.publishData(adaResponse);
		}
		final DesktopConfiguration config = agentDesktopConfigMap
				.getConfigForAgent(agentSessionId);
		String icrmLogOutResponse = null;
		try {
			icrmLogOutResponse = dataPostService.doIcrmLogout(adaRequest, config);
		} catch (Exception e) {
			LOGGER.error("ICRM Error Response:" + e.getMessage());
		}
		
		LOGGER.info(agentSessionId + " :===> icrmresponse :  : " + icrmLogOutResponse);
		
		final AdaResponse adaResponse = new AdaResponse(CommandConstants.ICRMLOGOUTRESPONSE, "" + icrmLogOutResponse,
                webSocketCacheManager.getToken(agentSessionId));
        dataPublisher.publishData(adaResponse);
	}
	protected void setChannelCapabilities(String icrmResponse, DesktopConfiguration config) {
		ChannelCapability cc;
		int chatChannels = 0;
		int emailChannels = 0;
		int teleChannels = 0;
		int blendingMode = 0;
		
		if (org.apache.commons.lang3.StringUtils.isNotBlank(icrmResponse)) {
			try {
				chatChannels = OmniChannelJsonUtil.extractChannelId(icrmResponse, OmniChannelCommonConstants.CHAT_CHANNEL_KEY);
				emailChannels = OmniChannelJsonUtil.extractChannelId(icrmResponse, OmniChannelCommonConstants.EMAIL_CHANNEL_KEY);
				teleChannels = OmniChannelJsonUtil.extractChannelId(icrmResponse, OmniChannelCommonConstants.TELE_CHANNEL_KEY);
				blendingMode = OmniChannelJsonUtil.extractChannelId(icrmResponse, OmniChannelCommonConstants.BLENDING_MODE_KEY);
				cc = new ChannelCapability(chatChannels, emailChannels, teleChannels, blendingMode);
				config.setChannelCapability(cc);
			} catch (Exception exception) {
				LOGGER.error(
						"Error retrieving and setting channel capabilities on icrm response: {}, with exception: {}",
						icrmResponse,
						exception
						);
			}
		} else {
			LOGGER.info("icrmResponse is blank {}, setting telechannel capability to 1", icrmResponse);
			teleChannels = 1;
			cc = new ChannelCapability(chatChannels, emailChannels, teleChannels, blendingMode);
			config.setChannelCapability(cc);
		}
	}

}