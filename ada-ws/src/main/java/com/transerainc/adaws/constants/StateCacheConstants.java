package com.transerainc.adaws.constants;

import java.util.List;

import com.transerainc.adaws.model.cache.contact.email.EmailContactAgentMessage;

/**
 * @author tnguyen
 *
 */
public interface StateCacheConstants {

	// Element Keys for Comprehensive JSON object sent to FE for Browser Reload
	final String AGENT_PROFILE_KEY = "agent-profile";
	final String DESKTOP_CONFIGURATION_KEY = "desktopConfiguration";
	final String MM_PROFILE_KEY = "mmProfile";
	final String MM_LOGGED_IN_AGENTS_KEY = "mmLoggedInAgents";
	final String CONTACTS_KEY = "contacts";
	final String ICRM_RESPONSE_KEY = CommandConstants.ICRMRESPONSE;
	final String CALL_LINE_DATA_1_KEY = "line1";
	final String CALL_LINE_DATA_2_KEY = "line1";
	final String COMPONENT_INFORMATION_KEY = "componentInfo";
	final String AGENT_ID_KEY = "agentId";
	final String LAST_EVENT_TIMESTAMP_KEY = "lastEventTimestamp";
	final String CHANNEL_ID_KEY = "channelId";
	
	final String TYPE_KEY = "type";

	// Contact States
	final String CONTACT_STATE_KEY = "contactState";

	// Contact Types for ICX/OmniChannel
	final String CONTACT_TYPE_KEY = "contactType";
	final String OMNI_CHANNEL_QUEUE_ID_KEY = "omniChannelQueueId";
	final String ADDITIONAL_DATA_KEY = "additionalData";
	final String TRACKING_ID_KEY = "trackingId";
	final String CDU_ID_KEY = "cduId";
	final String OUTBOUND_ID = "outboundId";

	// FollowUpDetail
	final String FOLLOW_UP_DETAILS_KEY = "followUpDetails";
	final String STATUS_KEY = "status";
	final String DATE_TIME_KEY = "dateTime";
	final String COMMENTS_KEY = "comments";
	final String CREATE_DATE_TIME_KEY = "createDateTime";
	final String CONTACT_PKEY_KEY = "contactPkey";
	final String FROM_EMAIL_ADDRESS_KEY = "fromEmailAddress";

	// Chat
	final String CUSTOMER_ID_KEY = "customerId";
	final String CONTACT_DETAILS_KEY = "contactDetails";
	final String MESSAGES_KEY = "messages";
	final String CONF_PARTICIPANTS_KEY = "confParticipants";
	final String PRIVATE_MESSAGES_KEY = "privateMessages";


	// Email
	final String SESSION_ID_KEY = "sessionId";
	final String SOURCE_TYPE_KEY = "sourceType";
	final String EMAIL_CONTACT_DETAIL_KEY = "emailContactDetail";
	final String SUBJECT_KEY = "subject";
	final String BODY_KEY = "body";
	final String ENTRY_POINT_ID_KEY = "entryPointId";
	final String CREATE_TIME_KEY = "createTime";
	final String RONA_TIME_KEY = "ronaTime";
	final String FROM_KEY = "from";
	final String TO_KEY = "to";
	final String CC_KEY = "cc";
	final String BCC_KEY = "bcc";
	final String HAS_ATTACHMENTS_KEY = "hasAttachments";
	final String IS_FROM_SUPERVISOR_KEY = "isFromSupervisor";
	final String NAME_KEY = "name";
	final String EMAIL_KEY = "email";
	final String AGENT_COMMENT_KEY = "agentComment";
	final String SUPERVISOR_COMMENT_KEY = "supervisorComment";
	final String AGENT_MESSAGE_KEY = "agentMessage";
	final String SUGGESTED_TEMPLATES_KEY = "suggestedTemplates";
	final String SUGGESTED_GUIDES_KEY = "suggestedGuides";
	final String CHERRY_PICK_COMMENT = "cherryPickComment";
	final String EMAIL_BODY_KEY = "emailBody";
	final String ATTACHMENTS_KEY = "attachments";
	final String FILE_NAME_KEY = "fileName";
	final String FILE_PATH_KEY = "filePath";

}
