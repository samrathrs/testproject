/**
 * 
 */
package com.transerainc.adaws.model;

/**
 * @author varsha.shivaram
 *
 */
public class AgentInfo {
	
	private String agentSessionId;
	private String status;
	private String subStatus;
	private String webSocketId;
	private String enterpriseId;
	
	/**
	 * @return the agentSessionId
	 */
	public String getAgentSessionId() {
		return agentSessionId;
	}
	/**
	 * @param agentSessionId the agentSessionId to set
	 */
	public void setAgentSessionId(String agentSessionId) {
		this.agentSessionId = agentSessionId;
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
	/**
	 * @return the subStatus
	 */
	public String getSubStatus() {
		return subStatus;
	}
	/**
	 * @param subStatus the subStatus to set
	 */
	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}
	/**
	 * @return the webSocketId
	 */
	public String getWebSocketId() {
		return webSocketId;
	}
	/**
	 * @param webSocketId the webSocketId to set
	 */
	public void setWebSocketId(String webSocketId) {
		this.webSocketId = webSocketId;
	}
	/**
	 * @return the enterpriseId
	 */
	public String getEnterpriseId() {
		return enterpriseId;
	}
	/**
	 * @param enterpriseId the enterpriseId to set
	 */
	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	
	
}
