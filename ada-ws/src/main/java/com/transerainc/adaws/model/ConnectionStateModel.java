/**
 * 
 */
package com.transerainc.adaws.model;

/**
 * @author varsha.shivaram
 */
public class ConnectionStateModel {

    private long hbTimestamp = System.currentTimeMillis();
    private int missedHeartbeatCount;
    private boolean connectionLost = false;
    private boolean connectionRecovery = false;
    private int recoveryLogoutRequest = 0;

    /**
     * @return the hbTimestamp
     */
    public long getHbTimestamp() {
        return hbTimestamp;
    }

    /**
     * @param hbTimestamp
     *            the hbTimestamp to set
     */
    public void setHbTimestamp(final long hbTimestamp) {
        this.hbTimestamp = hbTimestamp;
    }

    /**
     * @return the missedHeartbeatCount
     */
    public int getMissedHeartbeatCount() {
        return missedHeartbeatCount;
    }

    /**
     * @param missedHeartbeatCount
     *            the missedHeartbeatCount to set
     */
    public void setMissedHeartbeatCount(final int missedHeartbeatCount) {
        this.missedHeartbeatCount = missedHeartbeatCount;
    }

    /**
     * @return the connectionLost
     */
    public boolean isConnectionLost() {
        return connectionLost;
    }

    /**
     * @param connectionLost
     *            the connectionLost to set
     */
    public void setConnectionLost(final boolean connectionLost) {
        this.connectionLost = connectionLost;
    }

    /**
     * @return the connectionRecovery
     */
    public boolean isConnectionRecovery() {
        return connectionRecovery;
    }

    /**
     * @param connectionRecovery
     *            the connectionRecovery to set
     */
    public void setConnectionRecovery(final boolean connectionRecovery) {
        this.connectionRecovery = connectionRecovery;
    }

	public int getRecoveryLogoutRequest() {
		return recoveryLogoutRequest;
	}

	public void setRecoveryLogoutRequest(int recoveryLogoutRequest) {
		this.recoveryLogoutRequest = recoveryLogoutRequest;
	}

}
