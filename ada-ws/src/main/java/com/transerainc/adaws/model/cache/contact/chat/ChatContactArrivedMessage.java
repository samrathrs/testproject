package com.transerainc.adaws.model.cache.contact.chat;

import com.transerainc.adaws.constants.CacheContactState;

/**
 * @author tringuyen
 *
 */
public class ChatContactArrivedMessage {

	private MmResponse mmResponse;

	/**
	 * 
	 */
	public ChatContactArrivedMessage() {
	}

	/**
	 * @param mmResponse
	 */
	public ChatContactArrivedMessage(MmResponse mmResponse) {
		this.mmResponse = mmResponse;
	}

	/**
	 * @return the mmResponse
	 */
	public MmResponse getMmResponse() {
		return mmResponse;
	}

	/**
	 * @param mmResponse the mmResponse to set
	 */
	public void setMmResponse(MmResponse mmResponse) {
		this.mmResponse = mmResponse;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatContactArrivedMessage [mmResponse=");
		if (mmResponse != null) {
			builder.append(mmResponse.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

	public ChatContact constructChatContact() {
		if ((mmResponse != null) && (mmResponse.getResponseData() != null)) {
			final String contactState = CacheContactState.NEW.getName();
			final long agentId = mmResponse.getResponseData().getAgentId();
			final String contactType = mmResponse.getResponseData().getContactType();
			final long channelId = mmResponse.getResponseData().getChannelId();
			final long omniChannelQueueId = mmResponse.getResponseData().getOmniChannelQueueId();
			final ContactDetails contactDetails = mmResponse.getResponseData().getContactDetails();
			final AdditionalData additionalData = mmResponse.getResponseData().getAdditionalData();
			final ChatContact chatContact = new ChatContact(
					contactType, 
					contactState, 
					agentId, 
					channelId, 
					omniChannelQueueId,
					contactDetails,
					additionalData
				);
			return chatContact;
		} else {
			return null;
		}
	}

}
