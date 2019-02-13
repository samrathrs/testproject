package com.transerainc.adaws.util;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.constants.OmniChannelChatCommandConstants;
import com.transerainc.adaws.constants.OmniChannelCommonCommandConstants;
import com.transerainc.adaws.constants.OmniChannelEmailCommandConstants;
import com.transerainc.adaws.model.AdaRequest;
import com.transerainc.adaws.service.OmniChannelChatService;
import com.transerainc.adaws.service.OmniChannelCommonService;
import com.transerainc.adaws.service.OmniChannelEmailService;

@Component
public class OmniChannelFrontendToBackendRouter {
	private static Logger LOGGER = LoggerFactory.getLogger(OmniChannelFrontendToBackendRouter.class.getName());

	@Autowired
	OmniChannelCommonService commonService;

	@Autowired
	OmniChannelChatService chatService;
	
	@Autowired
	OmniChannelEmailService emailService;

	public OmniChannelFrontendToBackendRouter() {}
	
	public void route(String redirectApi, AdaRequest adaRequest) {
 
        if (adaRequest == null) {
            LOGGER.warn("Received null AdaRequest for OmniChannel processing. Stopping further processing.");
            return;
        }

        if (StringUtils.isBlank(redirectApi)) {
            LOGGER.warn("Received null redirectApi for AdaRequest: {}, for OmniChannel processing. " +
            		"Stopping further processing.",
            		adaRequest);
        }

        LOGGER.debug("Switch-Case on redirectApi: {}, OmniChannel processing with AdaRequest: {}, mmRequest: {}", 
        		redirectApi,
        		adaRequest,
        		adaRequest.getMmRequest().debugToString());

		switch (redirectApi) {
			// Common requests from FE
			case OmniChannelCommonCommandConstants.CONTACT_TRANSFER_TO_AGENT:
				commonService.transferContactToAgent(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.CONTACT_TRANSFER_TO_QUEUE:
				commonService.transferContactToQueue(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.FETCH_TRANSFERABLE_AGENTS:
				commonService.fetchTransferableAgents(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.FETCH_TRANSFERABLE_QUEUES:
				commonService.fetchTransferableQueues(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.CONTACT_WRAP_UP:
				commonService.wrapUpContact(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.CONTACT_COMPLETED:
				commonService.completeContact(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.GET_RESOURCES_LIST:
				commonService.getResourcesList(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.GET_CHANNELS:
				commonService.getChannels(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.GET_ENTRY_POINTS:
				commonService.getEntryPoints(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.GET_MACRO:
				commonService.getMacro(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.SAVE_AGENT_RESOURCE:
				commonService.saveAgentResource(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.UPDATE_AGENT_RESOURCE:
				commonService.updateAgentResource(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.DELETE_AGENT_RESOURCE:
				commonService.deleteAgentResource(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.GET_PROCESS_GUIDES:
				commonService.getProcessGuides(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.PROCESS_GUIDES_BODY:
				commonService.processGuidesBody(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.RTCC_HEALTH_CHECK:
				commonService.rtccHealthCheck(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.LOGOUT_REQUEST:
				commonService.agentLogout(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.INITIATE_TRANSFER_REQUEST:
				commonService.initiateTransferRequest(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.CONTACT_TRANSFER_REQUEST:
				commonService.contactTransferRequest(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.FOLLOW_UP_CONTACT_RETIRE:
				commonService.followUpContactRetire(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.FOLLOW_UP_CONTACT_REMIND_LATER:
				commonService.followUpContactRemindLater(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.REFRESH_AGENT:
				commonService.refreshAgent(adaRequest);
				break;
			case OmniChannelCommonCommandConstants.FETCH_FOLLOW_UP_CONTACTS_ON_LOGIN:
				commonService.fetchFollowUpContactsOnLogin(adaRequest);
				break;	
			case OmniChannelCommonCommandConstants.CONTEXT_DATA:
				commonService.contextData(adaRequest);
				break;
				
			// Chat requests from FE
			case OmniChannelChatCommandConstants.CHAT_CONTACT_ACCEPT:
				chatService.acceptContact(adaRequest);
				break;
			case OmniChannelChatCommandConstants.CHAT_WITH_CUSTOMER_START_TYPING:
				chatService.startTyping(adaRequest);
				break;
			case OmniChannelChatCommandConstants.CHAT_WITH_CUSTOMER_STOP_TYPING:
				chatService.stopTyping(adaRequest);
				break;
			case OmniChannelChatCommandConstants.CHAT_CONFERENCE_FETCH_AGENTS:
				chatService.fetchAgents(adaRequest);
				break;
			case OmniChannelChatCommandConstants.CHAT_CONFERENCE_START:
				chatService.startConference(adaRequest);
				break;
			case OmniChannelChatCommandConstants.CHAT_CONFERENCE_SEND_PRIVATE_MESSAGE:
				chatService.sendConferencePrivateMessage(adaRequest);
				break;
			case OmniChannelChatCommandConstants.CHAT_SEND_MESSAGE:
				chatService.sendMessage(adaRequest);
				break;
			case OmniChannelChatCommandConstants.CHAT_PUSH_URL:
				chatService.pushUrl(adaRequest);
				break;

			// Email requests from FE
			case OmniChannelEmailCommandConstants.ACCEPT_EMAIL_CONTACT:
				emailService.acceptContact(adaRequest);
				break;
			case OmniChannelEmailCommandConstants.REMOVE_EMAIL_ATTACHMENT:
				emailService.removeEmailAttachment(adaRequest);
				break;
			case OmniChannelEmailCommandConstants.DELETE_TEMP_ATTACHMENT:
				emailService.deleteTempAttachment(adaRequest);
				break;
			case OmniChannelEmailCommandConstants.INITIATE_OUTBOUND_EMAIL:
				emailService.initiateOutboundEmail(adaRequest);
				break;
			case OmniChannelEmailCommandConstants.ACCEPT_COMPOSED_EMAIL_CONTACT:
				emailService.acceptComposedEmailContact(adaRequest);
				break;
			case OmniChannelEmailCommandConstants.ACTIVATE_EMAIL_DRAFT:
				emailService.activateEmailDraft(adaRequest);
				break;
			case OmniChannelEmailCommandConstants.ACCEPT_DRAFTED_EMAIL_CONTACT:
				emailService.acceptDraftedEmailContact(adaRequest);
				break;
			case OmniChannelEmailCommandConstants.DELETE_EMAIL_DRAFT:
				emailService.deleteEmailDraft(adaRequest);
				break;
			case OmniChannelEmailCommandConstants.PARSE_MACRO:
				emailService.parseMacro(adaRequest);
				break;
			case OmniChannelEmailCommandConstants.ACTIVATE_FOLLOW_UP_OUTBOUND:
				emailService.activateFollowUpOutbound(adaRequest);
				break;
			case OmniChannelEmailCommandConstants.ACTIVATE_FOLLOW_UP_EMAIL:
				emailService.activateFollowUpEmail(adaRequest);
				break;
			case OmniChannelEmailCommandConstants.ACTIVATE_FOLLOW_UP_CHAT:
				emailService.activateFollowUpChat(adaRequest);
				break;
			case OmniChannelEmailCommandConstants.ACCEPT_FOLLOW_UP_EMAIL:
				emailService.acceptFollowUpEmail(adaRequest);
				break;
			case OmniChannelEmailCommandConstants.ACCEPT_FOLLOW_UP_CHAT:
				emailService.acceptFollowUpChat(adaRequest);
				break;
			default:
				LOGGER.error("Default case route() : redirectApi: {}, with AdaRequest: {} ", 
		        		redirectApi,
		        		adaRequest);
				break;
		}
        LOGGER.debug("Finished processing on redirectApi: {}, with AdaRequest: {} ", 
        		redirectApi,
        		adaRequest);
	}
}
