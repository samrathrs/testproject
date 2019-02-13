package com.transerainc.adaws.model;

/**
 * @author tringuyen
 *
 */
public class DestinationDetails {

	private Long agentKey;
	private Long destinationQueueId;

	/**
	 * 
	 */
	public DestinationDetails() {
	}

	/**
	 * @param agentKey
	 * @param destinationQueueId
	 */
	public DestinationDetails(Long agentKey, Long destinationQueueId) {
		this.agentKey = agentKey;
		this.destinationQueueId = destinationQueueId;
	}

	/**
	 * @return the agentKey
	 */
	public Long getAgentKey() {
		return agentKey;
	}

	/**
	 * @param agentKey the agentKey to set
	 */
	public void setAgentKey(Long agentKey) {
		this.agentKey = agentKey;
	}

	/**
	 * @return the destinationQueueId
	 */
	public Long getDestinationQueueId() {
		return destinationQueueId;
	}

	/**
	 * @param destinationQueueId the destinationQueueId to set
	 */
	public void setDestinationQueueId(Long destinationQueueId) {
		this.destinationQueueId = destinationQueueId;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DestinationDetails [agentKey=");
		builder.append(agentKey);
		builder.append(", destinationQueueId=");
		builder.append(destinationQueueId);
		builder.append("]");
		return builder.toString();
	}
}
