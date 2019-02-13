/**
 * 
 */
package com.transerainc.adaws.model;

/**
 * @author tringuyen
 *
 */
public class MmRequest {

	private String action;
	private String callbackUrl;
	private Boolean success;
	private String message;
	private Long inboundId;
	private Long outboundId;
	private Long wrapupStatus;
	private Long answerTime;
	private Boolean isReminderSet;
	
	private RequestData requestData;
	
	/**
	 * 
	 */
	public MmRequest() {
	}

	/**
	 * @param action
	 * @param callbackUrl
	 * @param success
	 * @param message
	 * @param inboundId
	 * @param outboundId
	 * @param wrapupStatus
	 * @param answerTime
	 * @param isReminderSet
	 * @param requestData
	 */
	public MmRequest(String action, String callbackUrl, Boolean success, String message, Long inboundId,
			Long outboundId, Long wrapupStatus, Long answerTime, Boolean isReminderSet, RequestData requestData) {
		super();
		this.action = action;
		this.callbackUrl = callbackUrl;
		this.success = success;
		this.message = message;
		this.inboundId = inboundId;
		this.outboundId = outboundId;
		this.wrapupStatus = wrapupStatus;
		this.answerTime = answerTime;
		this.isReminderSet = isReminderSet;
		this.requestData = requestData;
	}

	/**
	 * @return the action
	 */
	public final String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public final void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the callbackUrl
	 */
	public final String getCallbackUrl() {
		return callbackUrl;
	}

	/**
	 * @param callbackUrl the callbackUrl to set
	 */
	public final void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	/**
	 * @return the success
	 */
	public final Boolean getSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public final void setSuccess(Boolean success) {
		this.success = success;
	}

	/**
	 * @return the message
	 */
	public final String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public final void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the inboundId
	 */
	public Long getInboundId() {
		return inboundId;
	}

	/**
	 * @param inboundId the inboundId to set
	 */
	public void setInboundId(Long inboundId) {
		this.inboundId = inboundId;
	}

	/**
	 * @return the outboundId
	 */
	public Long getOutboundId() {
		return outboundId;
	}

	/**
	 * @param outboundId the outboundId to set
	 */
	public void setOutboundId(Long outboundId) {
		this.outboundId = outboundId;
	}

	/**
	 * @return the wrapupStatus
	 */
	public Long getWrapupStatus() {
		return wrapupStatus;
	}

	/**
	 * @param wrapupStatus the wrapupStatus to set
	 */
	public void setWrapupStatus(Long wrapupStatus) {
		this.wrapupStatus = wrapupStatus;
	}

	/**
	 * @return the answerTime
	 */
	public Long getAnswerTime() {
		return answerTime;
	}

	/**
	 * @param answerTime the answerTime to set
	 */
	public void setAnswerTime(Long answerTime) {
		this.answerTime = answerTime;
	}

	/**
	 * @return the isReminderSet
	 */
	public Boolean getIsReminderSet() {
		return isReminderSet;
	}

	/**
	 * @param isReminderSet the isReminderSet to set
	 */
	public void setIsReminderSet(Boolean isReminderSet) {
		this.isReminderSet = isReminderSet;
	}

	/**
	 * @return the requestData
	 */
	public final RequestData getRequestData() {
		return requestData;
	}

	/**
	 * @param requestData the requestData to set
	 */
	public final void setRequestData(RequestData requestData) {
		this.requestData = requestData;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MmRequest [action=");
		builder.append(action);
		builder.append(", callbackUrl=");
		builder.append(callbackUrl);
		builder.append(", success=");
		builder.append(success);
		builder.append(", message=");
		builder.append(message);
		builder.append(", inboundId=");
		builder.append(inboundId);
		builder.append(", outboundId=");
		builder.append(outboundId);
		builder.append(", wrapupStatus=");
		builder.append(wrapupStatus);
		builder.append(", answerTime=");
		builder.append(answerTime);
		builder.append(", isReminderSet=");
		builder.append(isReminderSet);
		builder.append(", requestData=");
		if (requestData != null) {
			builder.append(requestData.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

}
