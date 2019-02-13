/**
 * 
 */
package com.transerainc.ara.pojo;

/**
 * @author pgujjeti
 *
 */
public class AgentStateResponse {
	private Long agentId;

	private boolean status;

	private Long timestamp;

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
