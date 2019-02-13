package com.transerainc.adaws.model.cache.contact.chat;

/**
 * @author tringuyen
 *
 */
public class ChatContactConferenceMemberJoinedMessage {

	private ChatContactConferenceMemberJoinedMmResponse mmResponse;

	/**
	 * 
	 */
	public ChatContactConferenceMemberJoinedMessage() {
	}

	/**
	 * @param mmResponse
	 */
	public ChatContactConferenceMemberJoinedMessage(ChatContactConferenceMemberJoinedMmResponse mmResponse) {
		this.mmResponse = mmResponse;
	}

	/**
	 * @return the mmResponse
	 */
	public ChatContactConferenceMemberJoinedMmResponse getMmResponse() {
		return mmResponse;
	}

	/**
	 * @param mmResponse the mmResponse to set
	 */
	public void setMmResponse(ChatContactConferenceMemberJoinedMmResponse mmResponse) {
		this.mmResponse = mmResponse;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatContactConferenceMemberJoinedMessage [mmResponse=");
		if (mmResponse != null) {
			builder.append(mmResponse.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

}
