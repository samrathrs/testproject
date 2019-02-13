package com.transerainc.adaws.model.cache.contact.followup;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.StateCacheConstants;
import com.transerainc.adaws.constants.StateCacheContactType;
import com.transerainc.adaws.model.cache.contact.OmniChannelContact;

/**
 * @author tringuyen
 *
 */
public class FollowUpContact extends OmniChannelContact {

	private static final Logger LOGGER = LoggerFactory.getLogger(FollowUpContact.class);

	private FollowUpDetail followUpDetails;

	/**
	 * @param contactType
	 * @param contactState
	 * @param agentId
	 * @param channelId
	 * @param followUpDetails
	 */
	public FollowUpContact(
			String contactType,
			String contactState, 
			long agentId, 
			String channelId, 
			FollowUpDetail followUpDetails
		) {
		super(StateCacheContactType.FOLLOW_UP.getName(), contactType, contactState, agentId, channelId);
		this.followUpDetails = followUpDetails;
	}

	/**
	 * @return the contactState
	 */
	public String getContactState() {
		return contactState;
	}

	/**
	 * @param contactState the contactState to set
	 */
	public void setContactState(String contactState) {
		this.contactState = contactState;
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
	public String getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(String channelId) {
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
	 * @return the followUpDetails
	 */
	public FollowUpDetail getFollowUpDetails() {
		return followUpDetails;
	}

	/**
	 * @param followUpDetails the followUpDetails to set
	 */
	public void setFollowUpDetails(FollowUpDetail followUpDetails) {
		this.followUpDetails = followUpDetails;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FollowUpContact ");
		builder.append("[");
		builder.append(super.debugToString());
		builder.append(", followUpDetails=");
		builder.append(followUpDetails);
		if (followUpDetails != null) {
			builder.append(followUpDetails.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

	public JSONObject toJsonObject() {
		final JSONObject followUpContactJsonObject = super.toJsonObject();
		JSONObject followUpDetailsJsonObject = null;
		if (followUpDetails != null) {
			followUpDetailsJsonObject = followUpDetails.toJsonObject();
		}
		followUpContactJsonObject.put(StateCacheConstants.FOLLOW_UP_DETAILS_KEY, followUpDetailsJsonObject);
		return followUpContactJsonObject;
	}

}
