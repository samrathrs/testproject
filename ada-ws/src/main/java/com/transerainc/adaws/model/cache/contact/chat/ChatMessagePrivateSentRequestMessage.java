package com.transerainc.adaws.model.cache.contact.chat;

/**
 * @author tnguyen
 *
 */
public class ChatMessagePrivateSentRequestMessage {

	private String action;
	private String callbackUrl;
	private ChatMessagePrivateSentRequestData requestData;

	/**
	 * 
	 */
	public ChatMessagePrivateSentRequestMessage() {
	}

	/**
	 * @param action
	 * @param callbackUrl
	 * @param requestData
	 */
	public ChatMessagePrivateSentRequestMessage(String action, String callbackUrl,
			ChatMessagePrivateSentRequestData requestData) {
		this.action = action;
		this.callbackUrl = callbackUrl;
		this.requestData = requestData;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the callbackUrl
	 */
	public String getCallbackUrl() {
		return callbackUrl;
	}

	/**
	 * @param callbackUrl the callbackUrl to set
	 */
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	/**
	 * @return the requestData
	 */
	public ChatMessagePrivateSentRequestData getRequestData() {
		return requestData;
	}

	/**
	 * @param requestData the requestData to set
	 */
	public void setRequestData(ChatMessagePrivateSentRequestData requestData) {
		this.requestData = requestData;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatMessagePrivateSentRequestMessage [action=");
		builder.append(action);
		builder.append(", callbackUrl=");
		builder.append(callbackUrl);
		builder.append(", requestData=");
		if (requestData != null) {
			builder.append(requestData.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

	public ChatMessage constructChatMessage() {
		if (this.requestData != null) {
			final String fromId = this.requestData.getFromMember();

			// TODO:
			// FIX ME!!!
			// Determine and set fromName
			
			final String fromName = "";
			final String message = this.requestData.getMessage();
			
			// TODO:
			// FIX ME!!!
			// Determine and set sendTime
			final String sendTime = "";

			final ChatMessage chatMessage = new ChatMessage(fromId, fromName, message, sendTime);
			return chatMessage;
		} 

		return null;
	}

	public String getToMemberId() {
		if (this.requestData != null) {
			return requestData.getToMemberId();
		}

		return null;
	}

	public String getFromMemberId() {
		if (this.requestData != null) {
			return requestData.getFromMember();
		}

		return null;
	}

	public String getCduId() {
		if (this.requestData != null) {
			return requestData.getCduId();
		}

		return null;
	}

}
