package com.transerainc.adaws.model.cache.contact.email;

import com.transerainc.adaws.constants.CacheContactState;

/**
 * @author tringuyen
 *
 */
public class EmailContactArrivedMessage {

	private EmailContactArrivedMessageMmResponse mmResponse;

	/**
	 * 
	 */
	public EmailContactArrivedMessage() {
	}

	/**
	 * @param emailContactArrivedMessageMmResponse
	 */
	public EmailContactArrivedMessage(EmailContactArrivedMessageMmResponse mmResponse) {
		this.mmResponse = mmResponse;
	}

	/**
	 * @return the mmResponse
	 */
	public EmailContactArrivedMessageMmResponse getMmResponse() {
		return mmResponse;
	}

	/**
	 * @param emailContactArrivedMessageMmResponse the mmResponse to set
	 */
	public void setMmResponse(EmailContactArrivedMessageMmResponse mmResponse) {
		this.mmResponse = mmResponse;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailContactArrivedMessage [mmResponse=");
		if (mmResponse != null) {
			builder.append(mmResponse.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

	public EmailContact constructEmailContact() {
		if (
				(mmResponse != null) && 
				(mmResponse.getResponseData() != null)
			) {
			final EmailContactArrivedMessageResponseData responseData = mmResponse.getResponseData();

			final String contactState = CacheContactState.NEW.getName();

			final long agentId = responseData.getAgentId();
			final long channelId = responseData.getChannelId();
			final String contactType = responseData.getContactType();
			final long omniChannelQueueId = responseData.getOmniChannelQueueId();
			final String sessionId = responseData.getSessionId();
			final String sourceType = responseData.getSourceType();

			final EmailContactArrivedMessageContactDetail emailContactArrivedMessageDetail = 
					responseData.getEmailContactDetail();
			EmailContactDetails contactDetails = null;
			if (emailContactArrivedMessageDetail != null) {
				contactDetails = emailContactArrivedMessageDetail.constructEmailContactDetails();
			}

			final EmailContactArrivedMessageAdditionalData emailContactArrivedMessageAdditionalData =
					responseData.getAdditionalData();
			EmailContactAdditionalData additionalData = null;
			if (emailContactArrivedMessageAdditionalData != null) {
				additionalData = 
						emailContactArrivedMessageAdditionalData.constructEmailContactAdditionalData();
			}
			final EmailContact emailContact = 
					new EmailContact(
							contactType, 
							contactState,
							agentId, 
							channelId, 
							omniChannelQueueId, 
							sessionId, 
							sourceType, 
							contactDetails,
							additionalData
							);
			return emailContact;
		} else {
			return null;
		}
	}

}
