package com.transerainc.adaws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.transerainc.adaws.constants.OmniChannelChatCommandConstants;
import com.transerainc.adaws.model.AdaRequest;

@Service
public class OmniChannelChatService extends CacheService {
    static Logger LOGGER = LoggerFactory.getLogger(OmniChannelChatService.class.getName());

    @Value("${ada.omnichannel.callback.url}")
    private String adaCallbackUrl;

    //@Value("${omnichannel.url}")
    //private String omniChannelUrl;

    @Autowired
    private OmniChannelUtilService omniChannelUtilService;

    private void processAndTransmitAdaRequestToIcx(final AdaRequest adaRequest, 
    		final String jsMethodCommandConstant) {
        
    		final String omniChannelUrl = omniChannelUtilService.getMimUrl(adaRequest.getagentSessionId());
	    	omniChannelUtilService.processAndTransmitAdaRequestToIcx(
	    			adaRequest, 
	    			jsMethodCommandConstant, 
	    			adaCallbackUrl,
	    			omniChannelUrl
	    			);
    }
    
	public void acceptContact(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelChatCommandConstants.CHAT_CONTACT_ACCEPT,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelChatCommandConstants.CHAT_CONTACT_ACCEPTED);
	}

	public void startTyping(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelChatCommandConstants.CHAT_WITH_CUSTOMER_START_TYPING,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelChatCommandConstants.CHAT_WITH_CUSTOMER_TYPING_STARTED);
	}
	
	public void stopTyping(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelChatCommandConstants.CHAT_WITH_CUSTOMER_STOP_TYPING,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelChatCommandConstants.CHAT_WITH_CUSTOMER_TYPING_STOPPED);
	}
	
	public void fetchAgents(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelChatCommandConstants.CHAT_CONFERENCE_FETCH_AGENTS,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelChatCommandConstants.CHAT_CONFERENCE_AGENTS_FETCHED);
	}
	
	public void startConference(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelChatCommandConstants.CHAT_CONFERENCE_START,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelChatCommandConstants.CHAT_CONFERENCE_STARTED);
	}
	
	public void sendConferencePrivateMessage(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelChatCommandConstants.CHAT_CONFERENCE_SEND_PRIVATE_MESSAGE,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelChatCommandConstants.CHAT_CONFERENCE_PRIVATE_MESSAGE_SENT);
	}

	public void sendMessage(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelChatCommandConstants.CHAT_SEND_MESSAGE,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelChatCommandConstants.CHAT_MESSAGE_SENT);
	}

	public void pushUrl(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelChatCommandConstants.CHAT_PUSH_URL,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelChatCommandConstants.CHAT_URL_PUSHED);
	}

}
