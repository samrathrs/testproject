package com.transerainc.adaws.model.cache.contact.call;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.CacheContactState;
import com.transerainc.adaws.constants.StateCacheContactType;
import com.transerainc.adaws.model.cache.contact.Contact;

/**
 * @author tnguyen
 *
 */
public class CallContact extends Contact {

	private static final Logger LOGGER = LoggerFactory.getLogger(CallContact.class);

	private static final String TARGET_ID_JSON_KEY = "targetId";
	private static final String TARGET_TYPE_JSON_KEY = "targetType";
	private static final String LINE_1_JSON_KEY = "line1";
	private static final String LINE_2_JSON_KEY = "line2";

	private String targetId;
	private String targetType;
	private final LineData1 line1 = new LineData1();
	private final LineData2 line2 = new LineData2();

	/**
	 * 
	 */
	public CallContact() {
		super(StateCacheContactType.CALL.getName(), StateCacheContactType.CALL.getName(), CacheContactState.NEW.getName());
	}


	/**
	 * @param agentId
	 * @param targetId
	 * @param targetType
	 */
	public CallContact(long agentId, String targetId, String targetType) {
		super(StateCacheContactType.CALL.getName(), StateCacheContactType.CALL.getName(), CacheContactState.NEW.getName(), agentId);
		this.targetId = targetId;
		this.targetType = targetType;
	}

	/**
	 * @return the line1
	 */
	public LineData1 getLine1() {
		return line1;
	}

	/**
	 * @return the line2
	 */
	public LineData2 getLine2() {
		return line2;
	}

	/**
	 * @return the targetId
	 */
	public String getTargetId() {
		return targetId;
	}

	/**
	 * @param targetId the targetId to set
	 */
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	/**
	 * @return the targetType
	 */
	public String getTargetType() {
		return targetType;
	}

	/**
	 * @param targetType the targetType to set
	 */
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public void reset() {
		agentId = 0;
		line1.reset();
		line2.reset();
		LOGGER.debug("CallContact reset: {}", debugToString());
	}

	public void resetLine1() {
		LOGGER.debug("CallContact BEFORE reset line1: {}", debugToString());
		line1.reset();
		LOGGER.debug("CallContact AFTER reset line1: {}", debugToString());
	}

	public void resetLine2() {
		LOGGER.debug("CallContact BEFORE reset line2: {}", debugToString());
		line2.reset();
		LOGGER.debug("CallContact AFTER reset line2: {}", debugToString());
	}

	
	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CallContact ");
		builder.append("[");
		builder.append(super.debugToString());
		builder.append(", targetId=");
		builder.append(targetId);
		builder.append(", targetType=");
		builder.append(targetType);
		builder.append(", line1=");
		if (line1 != null) {
			builder.append(line1.debugToString());
		} else {
			builder.append("null");
		}
		builder.append(", line2=");
		if (line2 != null) {
			builder.append(line2.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

	public JSONObject toJsonObject() {
		final JSONObject callContactJsonObject = super.toJsonObject();
		callContactJsonObject.put(TARGET_ID_JSON_KEY, targetId);
		callContactJsonObject.put(TARGET_TYPE_JSON_KEY, targetType);
		callContactJsonObject.put(LINE_1_JSON_KEY, line1.toJsonObject());
		callContactJsonObject.put(LINE_2_JSON_KEY, line2.toJsonObject());
		return callContactJsonObject;
	}
}
