package com.transerainc.adaws.model.cache.profile;

/**
 * @author tnguyen
 *
 */
public class MmResponse {

	private boolean success;
	private String message;
	private String action;
	private MmProfile responseData;

	/**
	 * 
	 */
	public MmResponse() {
	}

	/**
	 * @param success
	 * @param message
	 * @param action
	 * @param responseData
	 */
	public MmResponse(boolean success, String message, String action, MmProfile responseData) {
		this.success = success;
		this.message = message;
		this.action = action;
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
	public MmProfile getResponseData() {
		return responseData;
	}

	/**
	 * @param responseData the responseData to set
	 */
	public void setResponseData(MmProfile responseData) {
		this.responseData = responseData;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AgentLoginResponseBody [success=");
		builder.append(success);
		builder.append(", message=");
		builder.append(message);
		builder.append(", action=");
		builder.append(action);
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
