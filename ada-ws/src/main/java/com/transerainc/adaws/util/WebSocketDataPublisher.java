package com.transerainc.adaws.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.cache.CloseEventCacheManager;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.AgentStateConstants;
import com.transerainc.adaws.json.AdaResponseJsonUtil;
import com.transerainc.adaws.model.AdaResponse;

/**
 * @author rajeev.lochanam
 */
@Component
public class WebSocketDataPublisher {
    private static Logger LOGGER = LoggerFactory.getLogger(WebSocketDataPublisher.class.getName());

    @Autowired
    public SimpMessagingTemplate template;

    @Autowired
    private CloseEventCacheManager eventCacheManager;

    /**
     * @param adaResponse
     */
    public void publishData(final AdaResponse adaResponse) {
        try {
            if ((adaResponse != null) && (adaResponse.data != null)) {
                LOGGER.info("For Frontend/FE Agent Session Id: {}, " +
                    "on jsMethod: {}, " +
                    "the message sent to ui {}, and " +
                    "call data: {}",
                    adaResponse.getAgentSessionId(),
                    adaResponse.getJsMethod(),
                    adaResponse.data,
                    adaResponse.callData);
                
                // Do not cache messages:
                // 1.) heart-beats (too many, periodic, and regular communication between FE and BE)
                // 2.) LoggedOut-Idle Status-SubStatus messages (Once this message is generated after the heartbeat FE-BE connection is torn down)
                if (
                		(!AdaConstants.REQUEST_FOR_HEART_BEAT.equalsIgnoreCase(adaResponse.getJsMethod()))	&& 
                		(!isMessageLoggedOutIdle(adaResponse.getData()))
                	) {
                		LOGGER.info("Caching (queueing) AdaResponse: {}, to FE Session Id: {}",
        					adaResponse,
        					adaResponse.getAgentSessionId()
        					);
                		eventCacheManager.setQueueStates(adaResponse.getAgentSessionId(), adaResponse);
                }
                template.convertAndSend("/update/config/" + adaResponse.getAgentSessionId(), adaResponse);
            }
        } catch (final Exception e) {
            LOGGER.warn("{} exception occured while publishing data to queue: {} ", adaResponse.getAgentSessionId(), e.getMessage());
            LOGGER.warn("{} adaResponse : ", adaResponse);
        }
    }

	protected boolean isMessageLoggedOutIdle(final String adaResponseData) {
		if (StringUtils.isNotBlank(adaResponseData)) {
			final String status =  AdaResponseJsonUtil.extractStatus(adaResponseData);
			final String subStatus = AdaResponseJsonUtil.extractSubStatus(adaResponseData);
			if (
					AgentStateConstants.STATE_LOGGED_OUT.equals(status)		&& 
					AgentStateConstants.SUBSTATE_IDLE.equals(subStatus)
			) {
				return true;
			}
		}
		return false;
	}

}
