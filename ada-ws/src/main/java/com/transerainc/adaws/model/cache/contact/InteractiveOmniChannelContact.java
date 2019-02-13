package com.transerainc.adaws.model.cache.contact;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.StateCacheConstants;

/**
 * @author tnguyen
 *
 */
public abstract class InteractiveOmniChannelContact extends OmniChannelContact {

	private static final Logger LOGGER = LoggerFactory.getLogger(InteractiveOmniChannelContact.class);

	protected long omniChannelQueueId;

	public InteractiveOmniChannelContact(String type, String contactType, String contactState) {
		super(type, contactType, contactState);
	}

	public InteractiveOmniChannelContact(String type, String contactType, String contactState, long agentId) {
		super(type, contactType, contactState, agentId);
	}

	public InteractiveOmniChannelContact(String type, String contactType, String contactState, String channelId) {
		super(type, contactType, contactState, channelId);
	}

	public InteractiveOmniChannelContact(String type, String contactType, String contactState, long agentId, String channelId) {
		super(type, contactType, contactState, agentId, channelId);
	}

	public InteractiveOmniChannelContact(String type, String contactType, String contactState, long agentId, String channelId, long omniChannelQueueId) {
		super(type, contactType, contactState, agentId, channelId);
		this.omniChannelQueueId = omniChannelQueueId;
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

	@Override
	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InteractiveOmniChannelContact ");
		builder.append("[");
		builder.append(super.debugToString());
		builder.append(", omniChannelQueueId=");
		builder.append(omniChannelQueueId);
		builder.append("]");
		return builder.toString();
	}

	public JSONObject toJsonObject() {
		final JSONObject interactiveOmniChannelContact = super.toJsonObject();
		interactiveOmniChannelContact.put(StateCacheConstants.OMNI_CHANNEL_QUEUE_ID_KEY, omniChannelQueueId);
		return interactiveOmniChannelContact;
	}

}
