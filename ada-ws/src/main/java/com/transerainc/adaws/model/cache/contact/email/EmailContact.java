package com.transerainc.adaws.model.cache.contact.email;

import org.json.JSONObject;

import com.transerainc.adaws.constants.StateCacheConstants;
import com.transerainc.adaws.constants.StateCacheContactType;
import com.transerainc.adaws.model.RequestData;
import com.transerainc.adaws.model.cache.contact.InteractiveOmniChannelContact;

/**
 * @author tringuyen
 *
 */
public class EmailContact extends InteractiveOmniChannelContact {

	private String sessionId;
	private String sourceType;
	private EmailContactDetails emailContactDetail;
	private EmailContactAdditionalData additionalData;

	/**
	 * @param contactState
	 * @param agentId
	 * @param channelId
	 * @param contactType
	 * @param omniChannelQueueId
	 * @param sessionId
	 * @param sourceType
	 * @param emailContactDetail
	 * @param additionalData
	 */
	public EmailContact(
			String contactType, 
			String contactState, 
			long agentId, 
			long channelId, 
			long omniChannelQueueId,
			String sessionId, 
			String sourceType, 
			EmailContactDetails contactDetails,
			EmailContactAdditionalData additionalData
		) {
		super(
				StateCacheContactType.EMAIL.getName(), 
				contactType, 
				contactState, 
				agentId, 
				Long.valueOf(channelId).toString(), 
				omniChannelQueueId
			);
		this.sessionId = sessionId;
		this.sourceType = sourceType;
		this.emailContactDetail = contactDetails;
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
	 * @return the emailContactDetail
	 */
	public EmailContactDetails getContactDetails() {
		return emailContactDetail;
	}

	/**
	 * @param emailContactDetail the emailContactDetail to set
	 */
	public void setContactDetails(EmailContactDetails contactDetails) {
		this.emailContactDetail = contactDetails;
	}

	/**
	 * @return the additionalData
	 */
	public EmailContactAdditionalData getAdditionalData() {
		return additionalData;
	}

	/**
	 * @param additionalData the additionalData to set
	 */
	public void setAdditionalData(EmailContactAdditionalData additionalData) {
		this.additionalData = additionalData;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailContact ");
		builder.append("[");
		builder.append(super.debugToString());
		builder.append(", sessionId=");
		builder.append(sessionId);
		builder.append(", sourceType=");
		builder.append(sourceType);
		builder.append(", emailContactDetail=");
		if (emailContactDetail != null) {
			builder.append(emailContactDetail.debugToString());
		} else {
			builder.append("null");
		}
		builder.append(", additionalData=");
		builder.append(additionalData);
		if (additionalData != null) {
			builder.append(additionalData.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

	public void copyAttributes(RequestData requestData) {
		if (requestData == null) {
			return;
		}

		// emailContactDetail
		if (this.emailContactDetail == null) {
			this.emailContactDetail = new EmailContactDetails();
		}
		this.emailContactDetail.copyAttributes(requestData);

		// additionalData
		if (this.additionalData == null) {
			this.additionalData = new EmailContactAdditionalData();
		}
		this.additionalData.copyAttributes(requestData);
	}

	public String toJsonString() {
		return this.toJsonObject().toString();
	}

	public JSONObject toJsonObject() {
		final JSONObject emailContactJsonObject = super.toJsonObject();
		emailContactJsonObject.put(StateCacheConstants.SESSION_ID_KEY, this.sessionId);
		emailContactJsonObject.put(StateCacheConstants.SOURCE_TYPE_KEY, this.sourceType);
		JSONObject emailContactDetailJsonObject = null;
		if (emailContactDetail != null) {
			emailContactDetailJsonObject = emailContactDetail.toJsonObject();
		}
		emailContactJsonObject.put(StateCacheConstants.EMAIL_CONTACT_DETAIL_KEY, emailContactDetailJsonObject);
		JSONObject additionalDataJsonObject = null;
		if (additionalData != null) {
			additionalDataJsonObject = additionalData.toJsonObject();
		}
		emailContactJsonObject.put(StateCacheConstants.ADDITIONAL_DATA_KEY, additionalDataJsonObject);
		return emailContactJsonObject;
	}

}
