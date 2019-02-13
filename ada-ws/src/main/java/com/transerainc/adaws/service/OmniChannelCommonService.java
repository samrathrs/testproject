package com.transerainc.adaws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.transerainc.adaws.constants.OmniChannelCommonCommandConstants;
import com.transerainc.adaws.model.AdaRequest;


/**
 * @author tringuyen
 *
 */
@Service
public class OmniChannelCommonService extends CacheService {
    static Logger LOGGER = LoggerFactory.getLogger(OmniChannelCommonService.class.getName());

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
    
    public void getResourcesList(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelCommonCommandConstants.GET_RESOURCES_LIST,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.RESOURCES_LIST_FETCHED);
    }
    
    public void getChannels(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelCommonCommandConstants.GET_CHANNELS,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.CHANNELS_FETCHED);
    }
    
    public void getEntryPoints(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelCommonCommandConstants.GET_ENTRY_POINTS,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.ENTRY_POINTS_FETCHED);
    }
    
    public void getMacro(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelCommonCommandConstants.GET_MACRO,
        		adaRequest);
        processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.MACRO_FETCHED);
    }
    
    public void saveAgentResource(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelCommonCommandConstants.SAVE_AGENT_RESOURCE,
        		adaRequest);
        processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.AGENT_RESOURCE_SAVED);
    }
    
    public void updateAgentResource(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelCommonCommandConstants.UPDATE_AGENT_RESOURCE,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.AGENT_RESOURCE_UPDATED);
    }
    
    public void deleteAgentResource(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelCommonCommandConstants.DELETE_AGENT_RESOURCE,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.AGENT_RESOURCE_DELETED);
	}
    
    public void getProcessGuides(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelCommonCommandConstants.GET_PROCESS_GUIDES,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.PROCESS_GUIDES_FETCHED);
    }
    
    public void rtccHealthCheck(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelCommonCommandConstants.RTCC_HEALTH_CHECK,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.HEALTH_CHECK_RTCC);
    }
    
    public void ronaNotification(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelCommonCommandConstants.RONA_NOTIFICATION,
        		adaRequest);
        processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.RONA_NOTIFICATION);
    }

    public void wrapUpContact(final AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelCommonCommandConstants.CONTACT_WRAPPED_UP,
        		adaRequest);
        processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.CONTACT_WRAPPED_UP);
    }
 
    public void completeContact(final AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelCommonCommandConstants.CONTACT_COMPLETED,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.CONTACT_CLOSED);
    }

    public void agentLogout(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelCommonCommandConstants.LOGOUT_REQUEST,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.LOGOUT_RESPONSE);
    }
    
    public void processGuidesBody(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelCommonCommandConstants.PROCESS_GUIDES_BODY,
        		adaRequest);
        processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.BODY_PROCESS_GUIDES);
    }

    public void transferContactToQueue(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelCommonCommandConstants.CONTACT_TO_QUEUE_TRANSFERRED,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.CONTACT_TO_QUEUE_TRANSFERRED);
	}

	public void transferContactToAgent(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelCommonCommandConstants.CONTACT_TRANSFER_TO_AGENT,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.CONTACT_TO_AGENT_TRANSFERRED);
	}
	
   public void fetchTransferableAgents(AdaRequest adaRequest) {
       LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
       		adaRequest.getagentSessionId(), 
       		OmniChannelCommonCommandConstants.FETCH_TRANSFERABLE_AGENTS,
       		adaRequest);
       processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.TRANSFERABLE_AGENTS_FETCHED);
	}

	public void fetchTransferableQueues(AdaRequest adaRequest) {
		LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
	          		adaRequest.getagentSessionId(), 
	          		OmniChannelCommonCommandConstants.FETCH_TRANSFERABLE_QUEUES,
	          		adaRequest);
		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.TRANSFERABLE_QUEUES_FETCHED);
	}

	public void initiateTransferRequest(AdaRequest adaRequest) {
		LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
	          		adaRequest.getagentSessionId(), 
	          		OmniChannelCommonCommandConstants.INITIATE_TRANSFER_REQUEST,
	          		adaRequest);
		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.TRANSFER_REQUEST_INITIATED);
	}

	public void contactTransferRequest(AdaRequest adaRequest) {
		LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
	          		adaRequest.getagentSessionId(), 
	          		OmniChannelCommonCommandConstants.CONTACT_TRANSFER_REQUEST,
	          		adaRequest);
		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.CONTACT_TRANSFER_REQUESTED);
	}
	
	public void followUpContactRetire(AdaRequest adaRequest) {
		LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
	          		adaRequest.getagentSessionId(), 
	          		OmniChannelCommonCommandConstants.FOLLOW_UP_CONTACT_RETIRE,
	          		adaRequest);
		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.CONTACT_RETIRE_FOLLOWED_UP);
	}

	public void followUpContactRemindLater(AdaRequest adaRequest) {
		LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
	          		adaRequest.getagentSessionId(), 
	          		OmniChannelCommonCommandConstants.FOLLOW_UP_CONTACT_REMIND_LATER,
	          		adaRequest);
		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.CONTACT_REMIND_LATER_FOLLOWED_UP);
	}
	
	public void refreshAgent(AdaRequest adaRequest) {
		LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
	          		adaRequest.getagentSessionId(), 
	          		OmniChannelCommonCommandConstants.REFRESH_AGENT,
	          		adaRequest);
		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.AGENT_REFRESHED);
	}
	
	public void fetchFollowUpContactsOnLogin(AdaRequest adaRequest) {
		LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
          		adaRequest.getagentSessionId(), 
          		OmniChannelCommonCommandConstants.FETCH_FOLLOW_UP_CONTACTS_ON_LOGIN,
          		adaRequest);
		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.FOLLOW_UP_CONTACTS_ON_LOGIN_FETCHED);
	}
	
	public void contextData(AdaRequest adaRequest) {
		LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
	          		adaRequest.getagentSessionId(), 
	          		OmniChannelCommonCommandConstants.CONTEXT_DATA,
	          		adaRequest);
		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelCommonCommandConstants.CONTEXT_DATA_FETCHED);
	}
	
}
