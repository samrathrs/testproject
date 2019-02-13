package com.transerainc.adaws.constants;

/**
 * @author jnarain
 *  Defines chat command constants for OmniChannel capability.
 *  In particular, this interface defines the JS Methods (jsMethod) that the Agent Desktop Application (Ada)
 *  Backend uses as a transmission communication endpoint of the Ada Frontend UI.
 */

public interface OmniChannelChatCommandConstants {
	// chat related constants
	final String CHAT_CONTACT_ARRIVED = "mm.chatContactArrived";
	final String CHAT_MESSAGE_RECEIVED = "mm.chatWithCustomerTypedMsgSentUrlPushed";
	
	final String CHAT_CONTACT_ACCEPT = "mm.chatAcceptContact";
	final String CHAT_CONTACT_ACCEPTED = "mm.chatContactAccepted";
	final String CHAT_CONTACT_ASSIGNED = "mm.chatContactSuccessfullyAssigned";
	final String CHAT_CONTACT_READY = "mm.chatContactIsReady";
	final String CHAT_MEMBER_JOINED = "mm.chatContactMemberJoined";
	
	final String CHAT_SEND_MESSAGE = "mm.chatSendMessage";
	final String CHAT_MESSAGE_SENT = "mm.chatMessageSent";
	
	final String CHAT_PUSH_URL = "mm.chatPushUrl";
	final String CHAT_URL_PUSHED = "mm.chatUrlPushed";
	
	final String CHAT_CONFERENCE_FETCH_AGENTS = "mm.chatConferenceFetchAgents";
	final String CHAT_CONFERENCE_AGENTS_FETCHED = "mm.chatConferenceAgentsFetched";
	
	final String CHAT_CONFERENCE_START = "mm.chatConferenceStart";
	final String CHAT_CONFERENCE_STARTED = "mm.chatConferenceStarted";
	final String CHAT_CONFERENCE_EVENT_STARTED = "mm.chatConferenceEventStarted";
	final String CHAT_CONFERENCE_ACCEPTED = "mm.chatConferenceAccepted";
	
	final String CHAT_CONFERENCE_SEND_PRIVATE_MESSAGE = "mm.chatConferenceSendPrivateMsg";
	final String CHAT_CONFERENCE_PRIVATE_MESSAGE_SENT = "mm.chatConferencePrivateMsgSent";
	final String CHAT_CONFERENCE_AGENT_TO_AGENT_MESSAGE_SENT = "mm.chatConferenceAgentToAgentMsgSent";
	final String CHAT_CONFERENCE_CLOSED = "mm.chatConferenceClosed";
	
	final String CHAT_WITH_CUSTOMER_START_TYPING = "mm.chatWithCustomerStartTyping";
	final String CHAT_WITH_CUSTOMER_TYPING_STARTED = "mm.chatWithCustomerTypingStarted";
	
	final String CHAT_WITH_CUSTOMER_STOP_TYPING = "mm.chatWithCustomerStopTyping";
	final String CHAT_WITH_CUSTOMER_TYPING_STOPPED = "mm.chatWithCustomerTypingStopped";
	
	final String CHAT_CONTACT_CLOSED = "mm.chatContactClosed";
	final String CHAT_CONTACT_TERMINATED = "mm.chatContactTerminated";
	
	final String CHAT_MEMBER_JOINED_COACHING = "mm.chatMemberJoinedCoaching";
	final String CHAT_MEMBER_LEFT_COACHING = "mm.chatMemberLeftCoaching";
}
