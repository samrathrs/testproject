package com.transerainc.adaws.model.cache.contact.call;

import java.util.SortedMap;
import java.util.TreeMap;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.transerainc.adaws.constants.LineDataConstants;
import com.transerainc.adaws.constants.StateCacheConstants;
import com.transerainc.adaws.model.CallAssociatedData.Data;

/**
 * @author tnguyen
 *
 */
public class LineData1 {

	private static final Logger LOGGER = LoggerFactory.getLogger(LineData1.class.getName());
	private static final Gson GSON = new Gson();

	private String status = null;
	private String wrapUpTime = null;
	private boolean callOnHold = false;
	private boolean callRecording = true;
	private long lastEventTimestamp = 0;
	private SortedMap<String, Data> dataMap = new TreeMap<String, Data>();

	/**
	 * 
	 */
	public LineData1() {
	}

	/**
	 * @param status
	 * @param wrapUpTime
	 * @param callOnHold
	 * @param callRecording
	 * @param dynamicValues
	 */
	public LineData1(
			final String status, 
			final String wrapUpTime,
			final boolean callOnHold, 
			final boolean callRecording, 
			final SortedMap<String, Data> dataMap) {
		this.status = status;
		this.wrapUpTime = wrapUpTime;
		this.callOnHold = callOnHold;
		this.callRecording = callRecording;
		resetLastEventTimestamp();
		this.setDataMap(dataMap);
	}

	/**
	 * @return the callId
	 */
	public Data getCallId() {
		Data callId = null;
		if ((this.dataMap != null) && (!this.dataMap.isEmpty())) {
			callId = this.dataMap.get(LineDataConstants.CALL_ID_KEY);
		}
		return callId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(final String status) {
		
		final Data statusData = this.dataMap.get(LineDataConstants.STATUS_KEY);
		
		String statusInsideDataMap = null;
		if (statusData != null) {
			statusInsideDataMap = statusData.getValue();
		}
		

		LOGGER.debug("Line1 Current Status: {}, new status: {}, statusInsideDataMap: {}, of Line1: {}",
				this.status,
				status,
				statusInsideDataMap,
				this.getDataMapAsJsonString());

		this.status = status;
	}

	/**
	 * @return the wrapUpTime
	 */
	public String getWrapUpTime() {
		return wrapUpTime;
	}

	/**
	 * @param wrapUpTime the wrapUpTime to set
	 */
	public void setWrapUpTime(String wrapUpTime) {
		this.wrapUpTime = wrapUpTime;
	}

	/**
	 * @return the callOnHold
	 */
	public boolean isCallOnHold() {
		return callOnHold;
	}

	/**
	 * @param callOnHold the callOnHold to set
	 */
	public void setCallOnHold(boolean callOnHold) {
		this.callOnHold = callOnHold;
	}

	/**
	 * @return the callRecording
	 */
	public boolean isCallRecording() {
		return callRecording;
	}

	/**
	 * @param callRecording the callRecording to set
	 */
	public void setCallRecording(boolean callRecording) {
		this.callRecording = callRecording;
	}

	public long getLastEventTimestamp() {
		return lastEventTimestamp;
	}

	public void setLastEventTimestamp(long lastEventTimestamp) {
		this.lastEventTimestamp = lastEventTimestamp;
	}

	public void setLastEventTimestampToCurrentTime() {
		setLastEventTimestamp(System.currentTimeMillis());
	}

	public void resetLastEventTimestamp() {
		setLastEventTimestamp(0);
	}

	/**
	 * @return the dataMap
	 */
	public SortedMap<String, Data> getDataMap() {
		return this.dataMap;
	}

	/**
	 * @param dataMap the dataMap to set
	 */
	public void setDataMap(final SortedMap<String, Data> dataMap) {
		this.dataMap.clear();
		this.dataMap.putAll(dataMap);
	}

	public void reset() {
		this.status = null;
		this.wrapUpTime = null;
		this.callOnHold = false;
		this.callRecording = true;
		this.dataMap.clear();
		this.resetLastEventTimestamp();
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LineData1 ");
		builder.append("[");
		builder.append("callId=");
		builder.append(getCallId());
		builder.append(", status=");
		builder.append(status);
		builder.append(", wrapUpTime=");
		builder.append(wrapUpTime);
		builder.append(", callOnHold=");
		builder.append(callOnHold);
		builder.append(", callRecording=");
		builder.append(callRecording);
		builder.append(", lastEventTimestamp=");
		builder.append(lastEventTimestamp);
		builder.append(", dataMap=");
		builder.append(getDataMapAsJsonString());
		builder.append("]");
		return builder.toString();
	}

	private String getDataMapAsJsonString() {
		String dataMapJsonString = null;
		if ((this.dataMap != null) && (!this.dataMap.isEmpty())) {
			dataMapJsonString = GSON.toJson(this.dataMap);
		}
		return dataMapJsonString;
	}

	public JSONObject toJsonObject() {
		JSONObject lineDataJsonObject = null;
		final String dataMapAsJsonString = getDataMapAsJsonString();
		if (org.apache.commons.lang3.StringUtils.isNotBlank(dataMapAsJsonString)) {
			lineDataJsonObject = new JSONObject(dataMapAsJsonString);
		} else {
			lineDataJsonObject = new JSONObject();
		}
		lineDataJsonObject.put(LineDataConstants.STATUS_KEY, status);
		lineDataJsonObject.put(LineDataConstants.WRAP_UP_TIME_KEY, wrapUpTime);
		lineDataJsonObject.put(LineDataConstants.CALL_ON_HOLD_KEY, callOnHold);
		lineDataJsonObject.put(LineDataConstants.CALL_RECORDING_KEY, callRecording);
		lineDataJsonObject.put(StateCacheConstants.LAST_EVENT_TIMESTAMP_KEY, lastEventTimestamp);
		return lineDataJsonObject;
	}

}
