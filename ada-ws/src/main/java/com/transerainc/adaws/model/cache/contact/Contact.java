package com.transerainc.adaws.model.cache.contact;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.StateCacheConstants;

/**
 * @author tnguyen
 *
 */
public abstract class Contact {

	private static final Logger LOGGER = LoggerFactory.getLogger(Contact.class);

	protected String type;
	protected String contactType;
	protected String contactState;
	protected long agentId;

	/**
	 * @param type
	 * @param contactType
	 * @param contactState
	 */
	public Contact(String type, String contactType, String contactState) {
		super();
		this.type = type;
		this.contactType = contactType;
		this.contactState = contactState;
	}

	/**
	 * @param type
	 * @param contactType
	 * @param contactState
	 * @param agentId
	 */
	public Contact(String type, String contactType, String contactState, long agentId) {
		this.type = type;
		this.contactType = contactType;
		this.contactState = contactState;
		this.agentId = agentId;
	}

	public String getType() {
		return type;
	}

	public String getContactType() {
		return contactType;
	}

	public String getContactState() {
		return contactState;
	}

	public void setContactState(String contactState) {
		this.contactState = contactState;
	}

	public long getAgentId() {
		return agentId;
	}

	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contact ");
		builder.append("[");
		builder.append("type=");
		builder.append(type);
		builder.append(", contactType=");
		builder.append(contactType);
		builder.append(", contactState=");
		builder.append(contactState);
		builder.append(", agentId=");
		builder.append(agentId);
		builder.append("]");
		return builder.toString();
	}

	protected JSONObject toJsonObject() {
		final JSONObject callContactJsonObject = new JSONObject();
		callContactJsonObject.put(StateCacheConstants.TYPE_KEY, type);
		callContactJsonObject.put(StateCacheConstants.CONTACT_TYPE_KEY, contactType);
		callContactJsonObject.put(StateCacheConstants.CONTACT_STATE_KEY, contactState);
		callContactJsonObject.put(StateCacheConstants.AGENT_ID_KEY, agentId);
		return callContactJsonObject;
	}
}
