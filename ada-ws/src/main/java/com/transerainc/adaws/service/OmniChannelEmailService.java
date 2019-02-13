/**
 * 
 */
package com.transerainc.adaws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.transerainc.adaws.constants.OmniChannelEmailCommandConstants;
import com.transerainc.adaws.model.AdaRequest;

/**
 * @author jnarain
 *
 */
@Service
public class OmniChannelEmailService extends CacheService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OmniChannelEmailService.class.getName());

    @Value("${ada.omnichannel.callback.url}")
    private String adaCallbackUrl;

    @Autowired
    private OmniChannelUtilService omniChannelUtilService;

    private void processAndTransmitAdaRequestToIcx(final AdaRequest adaRequest, 
			final String jsMethodCommandConstant) {

    		final String omniChannelUrl = omniChannelUtilService.getMimUrl(adaRequest.getagentSessionId(), jsMethodCommandConstant);
    		LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {} and omniChannelUrl:{}",
    				adaRequest.getagentSessionId(), 
    				jsMethodCommandConstant,
            		adaRequest,
            		omniChannelUrl);
    		
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
        		OmniChannelEmailCommandConstants.ACCEPT_EMAIL_CONTACT,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelEmailCommandConstants.EMAIL_CONTACT_ACCEPTED);
	}

    public void removeEmailAttachment(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelEmailCommandConstants.REMOVE_EMAIL_ATTACHMENT,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelEmailCommandConstants.EMAIL_ATTACHMENT_REMOVED);
	}

    public void deleteTempAttachment(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelEmailCommandConstants.DELETE_TEMP_ATTACHMENT,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelEmailCommandConstants.TEMP_ATTACHMENT_DELETED);
	}

    public void initiateOutboundEmail(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelEmailCommandConstants.INITIATE_OUTBOUND_EMAIL,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelEmailCommandConstants.OUTBOUND_EMAIL_INITIATED);
	}

    public void acceptComposedEmailContact(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelEmailCommandConstants.ACCEPT_COMPOSED_EMAIL_CONTACT,
        		adaRequest);
        processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelEmailCommandConstants.OUTBOUND_EMAIL_CONTACT_ACCEPTED);
	}

    public void activateEmailDraft(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelEmailCommandConstants.ACTIVATE_EMAIL_DRAFT,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelEmailCommandConstants.EMAIL_DRAFT_ACTIVATED);
	}

    public void acceptDraftedEmailContact(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelEmailCommandConstants.ACCEPT_DRAFTED_EMAIL_CONTACT,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelEmailCommandConstants.DRAFTED_EMAIL_CONTACT_ACCEPTED);
	}

    public void deleteEmailDraft(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelEmailCommandConstants.DELETE_EMAIL_DRAFT,
        		adaRequest);
        processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelEmailCommandConstants.EMAIL_DRAFT_DELETED);
	}
    
    public void parseMacro(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelEmailCommandConstants.PARSE_MACRO,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelEmailCommandConstants.MACRO_PARSED);
	}
        
    public void activateFollowUpOutbound(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelEmailCommandConstants.ACTIVATE_FOLLOW_UP_OUTBOUND,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelEmailCommandConstants.FOLLOW_UP_OUTBOUND_ACTIVATED);
	}
    
    public void activateFollowUpEmail(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelEmailCommandConstants.ACTIVATE_FOLLOW_UP_EMAIL,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelEmailCommandConstants.FOLLOW_UP_EMAIL_ACTIVATED);
	}
    
    public void activateFollowUpChat(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelEmailCommandConstants.ACTIVATE_FOLLOW_UP_CHAT,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelEmailCommandConstants.FOLLOW_UP_CHAT_ACTIVATED);
	}
    
    public void acceptFollowUpEmail(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelEmailCommandConstants.ACCEPT_FOLLOW_UP_EMAIL,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelEmailCommandConstants.FOLLOW_UP_EMAIL_ACCEPTED);
	}    
    
    public void acceptFollowUpChat(AdaRequest adaRequest) {
        LOGGER.info("AgentSessionId: {} :===>> Inside request: {}, with AdaRequest: {}",
        		adaRequest.getagentSessionId(), 
        		OmniChannelEmailCommandConstants.ACCEPT_FOLLOW_UP_CHAT,
        		adaRequest);
    		processAndTransmitAdaRequestToIcx(adaRequest, OmniChannelEmailCommandConstants.FOLLOW_UP_CHAT_ACCEPTED);
	}  

}
