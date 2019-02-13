package com.transerainc.adaws.model.cache.contact;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.StateCacheConstants;

/**
 * @author tnguyen
 *
 */
public abstract class OmniChannelContact extends Contact {

	private static final Logger LOGGER = LoggerFactory.getLogger(OmniChannelContact.class);

	private long lastEventTimestamp = System.currentTimeMillis();

	protected String channelId = null;

	public OmniChannelContact(String type, String contactType, String contactState) {
		super(type, contactType, contactState);
	}

	public OmniChannelContact(String type, String contactType, String contactState, long agentId) {
		super(type, contactType, contactState, agentId);
	}

	public OmniChannelContact(String type, String contactType, String contactState, String channelId) {
		super(type, contactType, contactState);
		this.channelId = channelId;
	}

	public OmniChannelContact(String type, String contactType, String contactState, long agentId, String channelId) {
		super(type, contactType, contactState, agentId);
		this.channelId = channelId;
	}

	public long getLastEventTimestamp() {
		return lastEventTimestamp;
	}

	protected void setLastEventTimestamp(long lastEventTimestamp) {
		this.lastEventTimestamp = lastEventTimestamp;
	}

	public void setLastEventTimestampToCurrentTime() {
		setLastEventTimestamp(System.currentTimeMillis());
	}

	public void resetLastEventTimestamp() {
		setLastEventTimestamp(0);
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

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OmniChannelContact ");
		builder.append("[");
		builder.append(super.debugToString());
		builder.append(", lastEventTimestamp=");
		builder.append(lastEventTimestamp);
		builder.append(", channelId=");
		builder.append(channelId);
		builder.append("]");
		return builder.toString();
	}

	public JSONObject toJsonObject() {
		final JSONObject omniChannelContactJsonObject = super.toJsonObject();
		omniChannelContactJsonObject.put(StateCacheConstants.CHANNEL_ID_KEY, channelId);
		omniChannelContactJsonObject.put(StateCacheConstants.LAST_EVENT_TIMESTAMP_KEY, lastEventTimestamp);
		return omniChannelContactJsonObject;
	}

}
