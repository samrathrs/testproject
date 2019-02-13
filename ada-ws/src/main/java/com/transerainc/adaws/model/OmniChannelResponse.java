package com.transerainc.adaws.model;

import javax.validation.constraints.NotNull;

/**
 * @author tnguyen
 *
 * Represents OmniChannelResponse from ICX.
 *
 */
public class OmniChannelResponse {
	
	@NotNull
	public String action;

	@NotNull
	public OmniChannelResponseData responseData;

	@NotNull
	public boolean success;
	
	@NotNull
	public String message;

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
	public OmniChannelResponseData getResponseData() {
		return responseData;
	}

	/**
	 * @param responseData the responseData to set
	 */
	public void setResponseData(OmniChannelResponseData responseData) {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OmniChannelResponse ");
		builder.append("[");
		builder.append("action=");
		builder.append(action);
		builder.append(", responseData=");
		builder.append(responseData);
		builder.append(", success=");
		builder.append(success);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}
}
