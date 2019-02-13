package com.transerainc.adaws.model.cache.contact.email;

/**
 * @author tringuyen
 *
 */
public class EmailContactArrivedMessageResponseData {

	private String sessionId;
	private long agentId;
	private long channelId;
	private String contactType;
	private String sourceType;
	private long omniChannelQueueId;
	private EmailContactArrivedMessageContactDetail emailContactDetail;
	private EmailContactArrivedMessageAdditionalData additionalData;

	/**
	 * 
	 */
	public EmailContactArrivedMessageResponseData() {
	}

	/**
	 * @param sessionId
	 * @param agentId
	 * @param channelId
	 * @param contactType
	 * @param sourceType
	 * @param omniChannelQueueId
	 * @param emailContactDetail
	 * @param additionalData
	 */
	public EmailContactArrivedMessageResponseData(String sessionId, long agentId, long channelId, String contactType, String sourceType,
			long omniChannelQueueId, EmailContactArrivedMessageContactDetail emailContactDetail, EmailContactArrivedMessageAdditionalData additionalData) {
		this.sessionId = sessionId;
		this.agentId = agentId;
		this.channelId = channelId;
		this.contactType = contactType;
		this.sourceType = sourceType;
		this.omniChannelQueueId = omniChannelQueueId;
		this.emailContactDetail = emailContactDetail;
		this.additionalData = additionalData;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the agentId
	 */
	public long getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return the channelId
	 */
	public long getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

	/**
	 * @return the contactType
	 */
	public String getContactType() {
		return contactType;
	}

	/**
	 * @param contactType the contactType to set
	 */
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	/**
	 * @return the sourceType
	 */
	public String getSourceType() {
		return sourceType;
	}

	/**
	 * @param sourceType the sourceType to set
	 */
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	/**
	 * @return the omniChannelQueueId
	 */
	public long getOmniChannelQueueId() {
		return omniChannelQueueId;
	}

	/**
	 * @param omniChannelQueueId the omniChannelQueueId to set
	 */
	public void setOmniChannelQueueId(long omniChannelQueueId) {
		this.omniChannelQueueId = omniChannelQueueId;
	}

	/**
	 * @return the emailContactArrivedMessageContactDetail
	 */
	public EmailContactArrivedMessageContactDetail getEmailContactDetail() {
		return emailContactDetail;
	}

	/**
	 * @param emailContactDetail the emailContactArrivedMessageContactDetail to set
	 */
	public void setEmailContactDetail(EmailContactArrivedMessageContactDetail emailContactDetail) {
		this.emailContactDetail = emailContactDetail;
	}

	/**
	 * @return the emailContactArrivedMessageAdditionalData
	 */
	public EmailContactArrivedMessageAdditionalData getAdditionalData() {
		return additionalData;
	}

	/**
	 * @param additionalData the emailContactArrivedMessageAdditionalData to set
	 */
	public void setAdditionalData(EmailContactArrivedMessageAdditionalData additionalData) {
		this.additionalData = additionalData;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponseData [sessionId=");
		builder.append(sessionId);
		builder.append(", agentId=");
		builder.append(agentId);
		builder.append(", channelId=");
		builder.append(channelId);
		builder.append(", contactType=");
		builder.append(contactType);
		builder.append(", sourceType=");
		builder.append(sourceType);
		builder.append(", omniChannelQueueId=");
		builder.append(omniChannelQueueId);
		builder.append(", emailContactDetail=");
		if (emailContactDetail != null) {
			builder.append(emailContactDetail.debugToString());
		} else {
			builder.append("null");
		}
		builder.append(", additionalData=");
		if (additionalData != null) {
			builder.append(additionalData.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

}
