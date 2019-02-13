/**
 * 
 */
package com.transerainc.adaws.model;

/**
 * @author rajeev.lochanam
 */
public class PeerAgent {
    private String dn;
    private String teamId;
    private String agentId;
    private String sessionId;
    private String channelId;
    private String channelType;

    public PeerAgent() {
    }

    public PeerAgent(final String agentId) {
        this.agentId = agentId;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(final String agentId) {
        this.agentId = agentId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(final String teamId) {
        this.teamId = teamId;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(final String dn) {
        this.dn = dn;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(final String sessionId) {
        this.sessionId = sessionId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(final String channelType) {
        this.channelType = channelType;
    }
}
