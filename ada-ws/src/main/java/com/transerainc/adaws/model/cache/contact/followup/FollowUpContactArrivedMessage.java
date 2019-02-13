package com.transerainc.adaws.model.cache.contact.followup;

import com.transerainc.adaws.constants.CacheContactState;

/**
 * @author tringuyen
 *
 */
public class FollowUpContactArrivedMessage {

	private FollowUpContactArrivedMmResponse mmResponse;

	/**
	 * 
	 */
	public FollowUpContactArrivedMessage() {
	}

	/**
	 * @param mmResponse
	 */
	public FollowUpContactArrivedMessage(FollowUpContactArrivedMmResponse mmResponse) {
		this.mmResponse = mmResponse;
	}

	/**
	 * @return the mmResponse
	 */
	public FollowUpContactArrivedMmResponse getMmResponse() {
		return mmResponse;
	}

	/**
	 * @param mmResponse the mmResponse to set
	 */
	public void setMmResponse(FollowUpContactArrivedMmResponse mmResponse) {
		this.mmResponse = mmResponse;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FollowUpContactArrivedMessage ");
		builder.append("[");
		builder.append("mmResponse=");
		if (mmResponse != null) {
			builder.append(mmResponse.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

	public FollowUpContact constructFollowUpContact() {
		if (
				(mmResponse != null)		&& 
				(mmResponse.getResponseData() != null) 
		) {
			final FollowUpContactArrivedResponseData responseData = mmResponse.getResponseData();
			final String contactState = CacheContactState.NEW.getName();
			final long agentId = responseData.getAgentId();
			final String channelId = responseData.getChannelId();
			final String contactType = responseData.getContactType();
			final FollowUpContactArrivedFollowUpDetails followUpContactArrivedFollowUpDetails = 
					responseData.getFollowUpDetails();
			FollowUpDetail followUpDetails = null;
			if (followUpContactArrivedFollowUpDetails != null) {
				followUpDetails = followUpContactArrivedFollowUpDetails.constructFollowUpDetail();
			}
			final FollowUpContact followUpContact = new FollowUpContact(
														contactType, 
														contactState, 
														agentId, 
														channelId, 
														followUpDetails
													);
			return followUpContact;
		} else {
			return null;
		}
	}

}
