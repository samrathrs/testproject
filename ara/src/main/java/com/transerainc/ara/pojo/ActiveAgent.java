/**
 * 
 */
package com.transerainc.ara.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://aim.transerainc.com/tpgintf")
public class ActiveAgent {

	private Long agentId;

	private String agentName;

	private Long tenantId;

	private Long teamId;

	private Long siteId;

	private String agentSessionId;

	private String channelId;

	private String channelType;

	private String acgUrl;

	private String channelStatus;

	private String subStatus;

	public ActiveAgent() {
	}

	@XmlAttribute(name = "agent-id")
	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	@XmlAttribute(name = "agent-name")
	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	@XmlAttribute(name = "tenant-id")
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	@XmlAttribute(name = "team-id")
	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	@XmlAttribute(name = "site-id")
	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	@XmlAttribute(name = "channel-id")
	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	@XmlAttribute(name = "channel-type")
	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	@XmlAttribute(name = "acg-url")
	public String getAcgUrl() {
		return acgUrl;
	}

	public void setAcgUrl(String acgUrl) {
		this.acgUrl = acgUrl;
	}

	@XmlAttribute(name = "channel-status")
	public String getChannelStatus() {
		return channelStatus;
	}

	public void setChannelStatus(String channelStatus) {
		this.channelStatus = channelStatus;
	}

	@XmlAttribute(name = "sub-status")
	public String getSubStatus() {
		return subStatus;
	}

	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}

	@XmlAttribute(name = "agent-session-id")
	public String getAgentSessionId() {
		return agentSessionId;
	}

	public void setAgentSessionId(String agentSessionId) {
		this.agentSessionId = agentSessionId;
	}
}