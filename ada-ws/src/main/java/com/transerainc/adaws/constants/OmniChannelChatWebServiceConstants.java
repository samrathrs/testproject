/**
 * 
 */
package com.transerainc.adaws.constants;

/**
 * @author tnguyen
 *
 */
public interface OmniChannelChatWebServiceConstants {

	final String BASE_CHAT_URI = OmniChannelCommonWebServiceConstants.BASE_OMNI_CHANNEL_URI + 
			"/chat";

	// Use Case of: "Contact"
	final String CHAT_CONTACT_ARRIVAL = BASE_CHAT_URI + 
    		"/contactArrival";

	final String CHAT_MESSAGE_RECEIVED = BASE_CHAT_URI + 
    		"/messageReception";

	// Use Case of: "Accept Chat Contact"
	final String CHAT_CONTACT_ACCEPTED = BASE_CHAT_URI +
			"/contactAccepted";
	final String CHAT_CONTACT_SUCCESSFULLY_ASSIGNED = BASE_CHAT_URI + 
    		"/contactSuccessfulAssignment";
	final String CHAT_CONTACT_READY = BASE_CHAT_URI + 
    		"/contactReady";
	final String CHAT_CONTACT_MEMBER_JOINED_MUC = BASE_CHAT_URI + 
    		"/contactMemberJoinedMuc";

	// Use Case of: "Conference Chat"
	final String CHAT_CONFERENCE_EVENT_STARTED = BASE_CHAT_URI + 
    		"/conferenceEventStart";
	final String CHAT_CONFERENCE_ACCEPTED = BASE_CHAT_URI + 
    		"/conferenceAccept";
	final String CHAT_CONFERENCE_CLOSE = BASE_CHAT_URI + 
    		"/conferenceClose";
	final String CHAT_CONFERENCE_AGENT_TO_AGENT_MESSAGE_SEND = BASE_CHAT_URI + 
    		"/conferenceAgentToAgentMessageSend";
	
	// Use Case of: "Ending Contact"
	final String CHAT_CONTACT_CLOSED = BASE_CHAT_URI + 
    		"/contactClose";
	final String CHAT_CONTACT_TERMINATED = BASE_CHAT_URI + 
    		"/contactTerminate";
	final String CHAT_CONTACT_COMPLETED = BASE_CHAT_URI + 
    		"/contactComplete";

}
