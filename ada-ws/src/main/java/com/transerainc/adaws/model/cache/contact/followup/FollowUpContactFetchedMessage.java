package com.transerainc.adaws.model.cache.contact.followup;

import java.util.ArrayList;
import java.util.List;

import com.transerainc.adaws.constants.CacheContactState;

/**
 * @author tringuyen
 *
 */
public class FollowUpContactFetchedMessage {

	private String action;
	private boolean success;
	private String message;
	private FollowUpContactFetchedResponseData responseData;

	/**
	 * 
	 */
	public FollowUpContactFetchedMessage() {
	}

	/**
	 * @param action
	 * @param success
	 * @param message
	 * @param responseData
	 */
	public FollowUpContactFetchedMessage(String action, boolean success, String message,
			FollowUpContactFetchedResponseData responseData) {
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
	public FollowUpContactFetchedResponseData getResponseData() {
		return responseData;
	}

	/**
	 * @param responseData the responseData to set
	 */
	public void setResponseData(FollowUpContactFetchedResponseData responseData) {
		this.responseData = responseData;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FollowUpContactFetchedMessage [action=");
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

	public List<FollowUpContact> constructFollowUpContacts() {
		if (responseData != null) {
			final String contactState = CacheContactState.NEW.getName();
			final long agentId = responseData.getAgentId();
			final List<FollowUpContactFetchedFollowUpDetails> followUpContactFetchedFollowUpDetails = 
					responseData.getFollowUpDetails();
			if (
					(followUpContactFetchedFollowUpDetails == null)		|| 
					(followUpContactFetchedFollowUpDetails.isEmpty())		|| 
					(followUpContactFetchedFollowUpDetails.size() < 1)
			) {
				return null;
			}
			List<FollowUpContact> followUpContacts = new ArrayList<FollowUpContact> ();
			for (FollowUpContactFetchedFollowUpDetails followUpContactFetchedFollowUpDetail : followUpContactFetchedFollowUpDetails) {
				final FollowUpDetail followUpDetail = followUpContactFetchedFollowUpDetail.constructFollowUpDetail();
				final FollowUpContact followUpContact = new FollowUpContact(
															null, 						// contactType
															contactState, 
															agentId, 
															null, 						// channelId
															followUpDetail
														);
				followUpContacts.add(followUpContact);
			}
			return followUpContacts;
		} else {
			return null;
		}
	}

}
