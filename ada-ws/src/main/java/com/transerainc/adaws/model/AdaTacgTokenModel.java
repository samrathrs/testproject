/**
 * 
 */
package com.transerainc.adaws.model;

/**
 * @author rajeev.lochanam
 */
public class AdaTacgTokenModel {
    private String tacgId;
    private String adaToken;
    private String tacgToken;
    private Boolean recovering = false;
    private Boolean heartbeatStarted = false;

    /**
     * @return the tacgId
     */
    public String getTacgId() {
        return tacgId;
    }

    /**
     * @param tacgId
     *            the tacgId to set
     */
    public void setTacgId(final String tacgId) {
        this.tacgId = tacgId;
    }

    /**
     * @return the adaToken
     */
    public String getAdaToken() {
        return adaToken;
    }

    /**
     * @param adaToken
     *            the adaToken to set
     */
    public void setAdaToken(final String adaToken) {
        this.adaToken = adaToken;
    }

    /**
     * @return the tacgToken
     */
    public String getTacgToken() {
        return tacgToken;
    }

    /**
     * @param tacgToken
     *            the tacgToken to set
     */
    public void setTacgToken(final String tacgToken) {
        this.tacgToken = tacgToken;
    }

    /**
     * @return the recovering
     */
    public Boolean isRecovering() {
        return recovering;
    }

    /**
     * @param recovering
     *            the recovering to set
     */
    public void setRecovering(final Boolean recovering) {
        this.recovering = recovering;
    }

    /**
     * @return the heartbeatStarted
     */
    public Boolean isHeartbeatStarted() {
        return heartbeatStarted;
    }

    /**
     * @param heartbeatStarted
     *            the heartbeatStarted to set
     */
    public void setHeartbeatStarted(final Boolean heartbeatStarted) {
        this.heartbeatStarted = heartbeatStarted;
    }
}
