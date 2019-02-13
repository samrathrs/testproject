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
public class LineData2 {

	private static final Logger LOGGER = LoggerFactory.getLogger(LineData2.class.getName());
	private static final Gson GSON = new Gson();

	private String status;
	private long lastEventTimestamp = 0;
	private SortedMap<String, Data> dataMap = new TreeMap<String, Data>();

	/**
	 * 
	 */
	public LineData2() {
	}

	/**
	 * @param status
	 */
	public LineData2(
			final String status,
			final SortedMap<String, Data> dataMap) {
		this.status = status;
		setDataMap(dataMap);
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

	public void setCallId(final String callId) {
		if (this.dataMap == null) {
			this.dataMap = new TreeMap<String, Data>();
		}
		Data callIdData = new Data();
		callIdData.setId(LineDataConstants.CALL_ID_KEY);
		callIdData.setName(LineDataConstants.CALL_ID_KEY);
		callIdData.setValue(callId);
		this.dataMap.put(LineDataConstants.CALL_ID_KEY, callIdData);
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
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the dataMap
	 */
	public SortedMap<String, Data> getDataMap() {
		return dataMap;
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
		resetLastEventTimestamp();
		this.dataMap.clear();
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LineData2 ");
		builder.append("[");
		builder.append("callId=");
		builder.append(getCallId());
		builder.append(", status=");
		builder.append(status);
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
			dataMapJsonString = GSON.toJson(dataMap);
		}
		return dataMapJsonString;
	}

	public JSONObject toJsonObject() {
		JSONObject lineDataJsonObject = null;
		final String dataMapAsJsonString = getDataMapAsJsonString();
		if (org.apache.commons.lang3.StringUtils.isNotBlank(dataMapAsJsonString)) {
			lineDataJsonObject = new JSONObject(getDataMapAsJsonString());
		} else {
			lineDataJsonObject = new JSONObject();
		}
		lineDataJsonObject.put(LineDataConstants.STATUS_KEY, status);
		lineDataJsonObject.put(StateCacheConstants.LAST_EVENT_TIMESTAMP_KEY, lastEventTimestamp);
		return lineDataJsonObject;
	}

}
