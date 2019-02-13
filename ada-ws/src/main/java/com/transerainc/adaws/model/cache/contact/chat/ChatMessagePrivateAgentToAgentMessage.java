package com.transerainc.adaws.model.cache.contact.chat;

/**
 * @author tringuyen
 *
 */
public class ChatMessagePrivateAgentToAgentMessage {

	private ChatMessagePrivateAgentToAgentMessageMmResponse mmResponse;

	/**
	 * 
	 */
	public ChatMessagePrivateAgentToAgentMessage() {
	}

	/**
	 * @param mmResponse
	 */
	public ChatMessagePrivateAgentToAgentMessage(ChatMessagePrivateAgentToAgentMessageMmResponse mmResponse) {
		this.mmResponse = mmResponse;
	}

	/**
	 * @return the mmResponse
	 */
	public ChatMessagePrivateAgentToAgentMessageMmResponse getMmResponse() {
		return mmResponse;
	}

	/**
	 * @param mmResponse the mmResponse to set
	 */
	public void setMmResponse(ChatMessagePrivateAgentToAgentMessageMmResponse mmResponse) {
		this.mmResponse = mmResponse;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatMessagePrivateAgentToAgentMessage [mmResponse=");
		if (mmResponse != null) {
			builder.append(mmResponse.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

	public ChatMessage constructChatMessage() {
		if ((mmResponse != null) && (mmResponse.getResponseData() != null)) {
			final String fromId = mmResponse.getResponseData().getFromId();
			final String fromName = mmResponse.getResponseData().getFromName();
			final String message = mmResponse.getResponseData().getMessage();
			final String sendTime = mmResponse.getResponseData().getSendTime();
			final ChatMessage chatMessage = new ChatMessage(fromId, fromName, message, sendTime);
			return chatMessage;
		} 

		return null;
	}

}
