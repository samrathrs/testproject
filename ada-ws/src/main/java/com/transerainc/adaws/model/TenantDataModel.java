/**
 * 
 */
package com.transerainc.adaws.model;

/**
 * @author rajeev.lochanam
 */
public class TenantDataModel {
    private Integer lostConnectionRecoveryTimeout = 12000;
    private Integer missedHeartBeatsAllowed = 3;
    private Integer heartBeatInterval = 3000;
    private String tenantName;
    private String agentSessions;
    private Integer retryCount = 0;
    private Boolean connectionLost = false;
    private String tacgServer;

    /**
     * @return the missedHeartBeatsAllowed
     */
    public Integer getMissedHeartBeatsAllowed() {
        return missedHeartBeatsAllowed;
    }

    /**
     * @param missedHeartBeatsAllowed
     *            the missedHeartBeatsAllowed to set
     */
    public void setMissedHeartBeatsAllowed(final Integer missedHeartBeatsAllowed) {
        this.missedHeartBeatsAllowed = missedHeartBeatsAllowed;
    }

    /**
     * @return the heartBeatInterval
     */
    public Integer getHeartBeatInterval() {
        return heartBeatInterval;
    }

    /**
     * @param heartBeatInterval
     *            the heartBeatInterval to set
     */
    public void setHeartBeatInterval(final Integer heartBeatInterval) {
        this.heartBeatInterval = heartBeatInterval;
    }

    /**
     * @return the agentSessions
     */
    public String getAgentSessions() {
        return agentSessions;
    }

    /**
     * @param agentSessions
     *            the agentSessions to set
     */
    public void setAgentSessions(final String agentSessions) {
        this.agentSessions = agentSessions;
    }

    /**
     * @return the lostConnectionRecoveryTimeout
     */
    public Integer getLostConnectionRecoveryTimeout() {
        return lostConnectionRecoveryTimeout;
    }

    /**
     * @param lostConnectionRecoveryTimeout
     *            the lostConnectionRecoveryTimeout to set
     */
    public void setLostConnectionRecoveryTimeout(final Integer lostConnectionRecoveryTimeout) {
        this.lostConnectionRecoveryTimeout = lostConnectionRecoveryTimeout;
    }

    public void clearFailureInfo() {
        setRetryCount(0);
        setConnectionLost(false);
    }

    /**
     * @return the retryCount
     */
    public Integer getRetryCount() {
        return retryCount;
    }

    /**
     * @param retryCount
     *            the retryCount to set
     */
    public void setRetryCount(final Integer retryCount) {
        this.retryCount = retryCount;
    }

    /**
     * @return the connectionLost
     */
    public Boolean getConnectionLost() {
        return connectionLost;
    }

    /**
     * @param connectionLost
     *            the connectionLost to set
     */
    public void setConnectionLost(final Boolean connectionLost) {
        this.connectionLost = connectionLost;
    }

    /**
     * @return the tacgServer
     */
    public String getTacgServer() {
        return tacgServer;
    }

    /**
     * @param tacgServer
     *            the tacgServer to set
     */
    public void setTacgServer(final String tacgServer) {
        this.tacgServer = tacgServer;
    }

    /**
     * @return the tenantName
     */
    public String getTenantName() {
        return tenantName;
    }

    /**
     * @param tenantName
     *            the tenantName to set
     */
    public void setTenantName(final String tenantName) {
        this.tenantName = tenantName;
    }
}
