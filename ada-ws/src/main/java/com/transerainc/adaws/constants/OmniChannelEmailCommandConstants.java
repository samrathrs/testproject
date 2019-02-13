package com.transerainc.adaws.constants;

/**
 * @author tringuyen
 *
 */
public interface OmniChannelEmailCommandConstants {

    // email related constants
	final String EMAIL_CONTACT_DETAILS_KEY = "emailContactDetail";

	// contact arrival from ICX to ADA BE (eventCallbacks)
    final String EMAIL_CONTACT_ARRIVAL = "mm.emailContactArrived"; // "action": "EmailContactArrivalCallback"
    final String EMAIL_CONTACT_ARRIVAL_FOLLOWUP = "mm.emailContactArrivalFollowup"; // "action": "FollowUpContactArrivalCallback"
    
    final String ACCEPT_EMAIL_CONTACT = "mm.acceptingEmailContact"; // "action": "AcceptEmailContact"
    final String EMAIL_CONTACT_ACCEPTED = "mm.emailContactAccepted";
    
    final String GET_EMAIL_BODY = "mm.getEmailBody"; // "action": "FetchEmailDetails"
    final String EMAIL_BODY_FETCHED = "mm.emailBodyFetched";
    
    final String ADD_EMAIL_ATTACHMENT = "mm.addEmailAttachment"; //  "action": "FileUpload"
    final String EMAIL_ATTACHMENT_ADDED = "mm.emailAttachmentAdded";
    
    final String REMOVE_EMAIL_ATTACHMENT = "mm.removeEmailAttachment"; // "action": "RemoveAttachment"
    final String EMAIL_ATTACHMENT_REMOVED = "mm.emailAttachmentRemoved";
    
    final String DELETE_TEMP_ATTACHMENT = "mm.deleteTempAttachment"; // "action": "DeleteTempAttachments"
    final String TEMP_ATTACHMENT_DELETED = "mm.tempAttachmentDeleted";
    
    final String SEND_EMAIL_PLAIN_TEXT = "mm.sendEmailPlainText"; // "action": "SendPlainTextEmail"
    final String PLAIN_TEXT_EMAIL_SENT = "mm.plainTextEmailSent";
    
    final String SEND_EMAIL_RICH_TEXT = "mm.sendEmailRichText"; // "action": "SendRichTextEmail"
    final String RICH_TEXT_EMAIL_SENT = "mm.richTextEmailSent";
    
    final String INITIATE_OUTBOUND_EMAIL = "mm.initiateOutboundEmail"; // "action": "InitiateOutboundEmail"
    final String OUTBOUND_EMAIL_INITIATED = "mm.outboundEmailInitiated";
    
    final String ACCEPT_COMPOSED_EMAIL_CONTACT = "mm.acceptOutboundEmailContact"; //  "action": "AcceptOutboundEmailContact"
    final String OUTBOUND_EMAIL_CONTACT_ACCEPTED = "mm.outboundEmailContactAccepted";
    
    final String SEND_COMPOSED_EMAIL = "mm.sendOutboundEmail"; //  "action": "SendRichTextEmailOutbound"
    final String COMPOSED_EMAIL_SENT = "mm.outboundEmailSent";
    
    final String SAVE_EMAIL_DRAFT = "mm.saveEmailDraft"; // "action": "SaveEmailDraft"
    final String EMAIL_DRAFT_SAVED = "mm.emailDraftSaved";
    
    final String FETCH_EMAIL_DRAFT = "mm.fetchEmailDraft"; // "action": "FetchEmailDrafts"
    final String EMAIL_DRAFT_FETCHED = "mm.emailDraftFetched";
    
    final String ACTIVATE_EMAIL_DRAFT = "mm.activateEmailDraft"; // "action": "ActivateEmailDraft"
    final String EMAIL_DRAFT_ACTIVATED = "mm.emailDraftActivated";
    
    final String ACCEPT_DRAFTED_EMAIL_CONTACT = "mm.acceptDraftedEmailContact"; // "action": "AcceptDraftedEmailContact"
    final String DRAFTED_EMAIL_CONTACT_ACCEPTED = "mm.draftedEmailContactAccepted";
    
    final String DELETE_EMAIL_DRAFT = "mm.deleteEmailDraft"; // "action": "DeleteEmailDraft",
    final String EMAIL_DRAFT_DELETED = "mm.emailDraftDeleted";
	
	final String PARSE_MACRO = "mm.parseMacro"; // "action": "ParseMacro"
	final String MACRO_PARSED = "mm.macroParsed";
	
	final String ACTIVATE_FOLLOW_UP_OUTBOUND = "mm.activateFollowUpOutbound"; // "action":"ActivateFollowUpOutbound"
	final String FOLLOW_UP_OUTBOUND_ACTIVATED = "mm.followUpOutboundActivated";
	
	final String ACTIVATE_FOLLOW_UP_EMAIL = "mm.activateFollowUpEmail"; // "action":"ActivateFollowUpEmail"
	final String FOLLOW_UP_EMAIL_ACTIVATED = "mm.followUpEmailActivated";
	
	final String ACTIVATE_FOLLOW_UP_CHAT = "mm.activateFollowUpChat"; // "action": "ActivateFollowUpChat"
	final String FOLLOW_UP_CHAT_ACTIVATED = "mm.followUpChatActivated";
	
    final String FOLLOW_UP_CONTACT_HISTORY = "mm.followUpContactHistory"; // "action": "FollowUpContactHistory"
    final String CONTACT_HISTORY_FOLLOWED_UP = "mm.contactHistoryFollowedUp";
    
    final String ACCEPT_FOLLOW_UP_EMAIL = "mm.acceptFollowUpEmail"; // "action": "AcceptFollowUpEmail"
    final String FOLLOW_UP_EMAIL_ACCEPTED = "mm.followUpEmailAccepted";
    
    final String ACCEPT_FOLLOW_UP_CHAT = "mm.acceptFollowUpChat"; // "action": "AcceptFollowUpChat"
    final String FOLLOW_UP_CHAT_ACCEPTED = "mm.followUpChatAccepted";
    
    final String FETCH_FOLLOW_UP_EMAIL_DETAILS = "mm.fetchFollowUpEmailDetails"; //"action": "FetchFollwUpEmailDetails"
    final String FOLLOW_UP_EMAIL_DETAILS_FETCHED = "mm.followUpEmailDetailsFetched";
    
    final String SEND_FOLLOW_UP_OUTBOUND_EMAIL = "mm.sendFollowUpOutboundEmail"; //"action": "SendFollowUpOutboundEmail"
    final String FOLLOW_UP_OUTBOUND_EMAIL_SENT = "mm.followUpOutboundEmailSent";
    
    final String SEND_FOLLOW_UP_EMAIL = "mm.sendFollowUpEmail"; // "action": "SendFollowUpEmail"
    final String FOLLOW_UP_EMAIL_SENT = "mm.followUpEmailSent"; 
    
    final String EMAIL_CONVERSATION = "mm.emailConversation"; // "action":"EmailConversation"
    final String EMAIL_CONVERSATION_FETCHED = "mm.emailConversationFetched";
    
    final String CORRECT_DISAPPROVED_EMAIL = "mm.correctDisapprovedEmail"; // "action": "CorrectDisapprovedEmail"
    final String SENDING_CORRECT_DISAPPROVED_EMAIL = "mm.sendingCorrectDisapprovedEmail";
}
