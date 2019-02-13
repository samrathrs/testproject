package com.transerainc.adaws.model.cache.contact.chat;

/**
 * @author tringuyen
 *
 */
public class ChatContactMemberJoinedMessage {

	private ChatContactMemberJoinedMmResponse mmResponse;

	/**
	 * 
	 */
	public ChatContactMemberJoinedMessage() {
	}

	/**
	 * @param mmResponse
	 */
	public ChatContactMemberJoinedMessage(ChatContactMemberJoinedMmResponse mmResponse) {
		this.mmResponse = mmResponse;
	}

	/**
	 * @return the mmResponse
	 */
	public ChatContactMemberJoinedMmResponse getMmResponse() {
		return mmResponse;
	}

	/**
	 * @param mmResponse the mmResponse to set
	 */
	public void setMmResponse(ChatContactMemberJoinedMmResponse mmResponse) {
		this.mmResponse = mmResponse;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatContactMemberJoinedMessage [mmResponse=");
		if (mmResponse != null) {
			builder.append(mmResponse.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

}
