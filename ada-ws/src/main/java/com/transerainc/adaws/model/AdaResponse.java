package com.transerainc.adaws.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author jasmin.menezes
 */
public class AdaResponse {
	public String data;
	public String jsMethod;
	public String callData;
	public String agentSessionId;
	public long timeStamp;

	/**
	 * @param jsMethod
	 * @param data
	 * @param agentSessionId
	 * @param callData
	 */
	public AdaResponse(final String jsMethod, final String data,
			final String agentSessionId, final String callData) {
		this(jsMethod, data, agentSessionId);
		this.callData = callData;
//		timeStamp=System.currentTimeMillis();
		
	}

	/**
	 * @param jsMethod
	 * @param data
	 * @param agentSessionId
	 */
	public AdaResponse(final String jsMethod, final String data,
			final String agentSessionId) {
		this.jsMethod = jsMethod;
		this.data = data;
		this.agentSessionId = agentSessionId;
		timeStamp=System.currentTimeMillis();
	}

	/**
	 * @return the jsMethod
	 */
	public String getJsMethod() {
		return jsMethod;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @return the agentSessionId
	 */
	public String getAgentSessionId() {
		return agentSessionId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("agentSessionId", agentSessionId)
				.append("data", getData()).append("jsMethod", getJsMethod())
				.append("callData", callData).toString();
	}

	/**
	 * @param agentSessionId
	 *            the agentSessionId to set
	 */
	public void setAgentSessionId(final String agentSessionId) {
		this.agentSessionId = agentSessionId;
	}
}
