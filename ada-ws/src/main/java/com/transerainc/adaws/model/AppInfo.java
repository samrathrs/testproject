/**
 *
 */
package com.transerainc.adaws.model;

import java.sql.Timestamp;

/**
 * @author suresh.kumar
 */
public class AppInfo {

    private String version;
    private Timestamp startTime;
    private Timestamp currentTime;

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version
     *            the version to set
     */
    public void setVersion(final String version) {
        this.version = version;
    }

    /**
     * @return the startTime
     */
    public Timestamp getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     *            the startTime to set
     */
    public void setStartTime(final Timestamp startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the currentTime
     */
    public Timestamp getCurrentTime() {
        return currentTime;
    }

    /**
     * @param currentTime
     *            the currentTime to set
     */
    public void setCurrentTime(final Timestamp currentTime) {
        this.currentTime = currentTime;
    }

}
