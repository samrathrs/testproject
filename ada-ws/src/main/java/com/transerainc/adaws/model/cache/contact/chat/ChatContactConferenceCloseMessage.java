package com.transerainc.adaws.model.cache.contact.chat;

/**
 * @author tringuyen
 *
 */
public class ChatContactConferenceCloseMessage {

	private ChatContactConferenceCloseMmResponse mmResponse;

	/**
	 * 
	 */
	public ChatContactConferenceCloseMessage() {
	}

	/**
	 * @param mmResponse
	 */
	public ChatContactConferenceCloseMessage(ChatContactConferenceCloseMmResponse mmResponse) {
		this.mmResponse = mmResponse;
	}

	/**
	 * @return the mmResponse
	 */
	public ChatContactConferenceCloseMmResponse getMmResponse() {
		return mmResponse;
	}

	/**
	 * @param mmResponse the mmResponse to set
	 */
	public void setMmResponse(ChatContactConferenceCloseMmResponse mmResponse) {
		this.mmResponse = mmResponse;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatContactConferenceCloseMessage [mmResponse=");
		if (mmResponse != null) {
			builder.append(mmResponse.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

}
