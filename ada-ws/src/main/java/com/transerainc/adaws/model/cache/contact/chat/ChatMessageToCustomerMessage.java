package com.transerainc.adaws.model.cache.contact.chat;

/**
 * @author tringuyen
 *
 */
public class ChatMessageToCustomerMessage {

	private ChatMessageToCustomerMmResponse mmResponse;

	/**
	 * 
	 */
	public ChatMessageToCustomerMessage() {
	}

	/**
	 * @param mmResponse
	 */
	public ChatMessageToCustomerMessage(ChatMessageToCustomerMmResponse mmResponse) {
		this.mmResponse = mmResponse;
	}

	/**
	 * @return the mmResponse
	 */
	public ChatMessageToCustomerMmResponse getMmResponse() {
		return mmResponse;
	}

	/**
	 * @param mmResponse the mmResponse to set
	 */
	public void setMmResponse(ChatMessageToCustomerMmResponse mmResponse) {
		this.mmResponse = mmResponse;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatMessageToCustomerMessage [mmResponse=");
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
			final String msgType = mmResponse.getResponseData().getMessageType();
			if (
					(MessageType.SEND_MESSAGE.getId().equals(msgType)) || 
					(MessageType.PUSH_URL.getId().equals(msgType))
			) {
				final String fromId = mmResponse.getResponseData().getFromId();
				final String fromName = mmResponse.getResponseData().getFromName();
				final String message = mmResponse.getResponseData().getMessage();
				final String sendTime = mmResponse.getResponseData().getSendTime();
				final ChatMessage chatMessage = new ChatMessage(msgType, fromId, fromName, message, sendTime);
				return chatMessage;
			}
		} 

		return null;
	}

}
