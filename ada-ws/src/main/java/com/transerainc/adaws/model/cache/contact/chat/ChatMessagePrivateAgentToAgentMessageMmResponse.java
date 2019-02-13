package com.transerainc.adaws.model.cache.contact.chat;

/**
 * @author tringuyen
 *
 */
public class ChatMessagePrivateAgentToAgentMessageMmResponse {

	private String action;
	private boolean success;
	private String message;
	private ChatMessagePrivateAgentToAgentMessageResponseData responseData;

	/**
	 * 
	 */
	public ChatMessagePrivateAgentToAgentMessageMmResponse() {
	}

	/**
	 * @param action
	 * @param success
	 * @param message
	 * @param responseData
	 */
	public ChatMessagePrivateAgentToAgentMessageMmResponse(String action, boolean success, String message,
			ChatMessagePrivateAgentToAgentMessageResponseData responseData) {
		this.action = action;
		this.success = success;
		this.message = message;
		this.responseData = responseData;
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
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the responseData
	 */
	public ChatMessagePrivateAgentToAgentMessageResponseData getResponseData() {
		return responseData;
	}

	/**
	 * @param responseData the responseData to set
	 */
	public void setResponseData(ChatMessagePrivateAgentToAgentMessageResponseData responseData) {
		this.responseData = responseData;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatMessagePrivateAgentToAgentMessageMmResponse [action=");
		builder.append(action);
		builder.append(", success=");
		builder.append(success);
		builder.append(", message=");
		builder.append(message);
		builder.append(", responseData=");
		if (responseData != null) {
			builder.append(responseData.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

}
