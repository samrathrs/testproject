package com.transerainc.adaws.model.cache.contact.chat;

/**
 * @author tringuyen
 *
 */
public class ChatContactConferenceMemberJoinedMmResponse {

	private String action;
	private ChatContactConferenceMemberJoinedResponseData responseData;
	private boolean success;
	private String message;

	/**
	 * 
	 */
	public ChatContactConferenceMemberJoinedMmResponse() {
	}

	/**
	 * @param action
	 * @param responseData
	 * @param success
	 * @param message
	 */
	public ChatContactConferenceMemberJoinedMmResponse(String action, ChatContactConferenceMemberJoinedResponseData responseData,
			boolean success, String message) {
		this.action = action;
		this.responseData = responseData;
		this.success = success;
		this.message = message;
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
	 * @return the responseData
	 */
	public ChatContactConferenceMemberJoinedResponseData getResponseData() {
		return responseData;
	}

	/**
	 * @param responseData the responseData to set
	 */
	public void setResponseData(ChatContactConferenceMemberJoinedResponseData responseData) {
		this.responseData = responseData;
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

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatContactConferenceMemberJoinedMmResponse [action=");
		builder.append(action);
		builder.append(", responseData=");
		if (responseData != null) {
			builder.append(responseData.debugToString());
		} else {
			builder.append("null");
		}
		builder.append(", success=");
		builder.append(success);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}

}
