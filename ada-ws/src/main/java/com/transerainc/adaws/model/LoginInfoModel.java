/**
 * 
 */
package com.transerainc.adaws.model;

/**
 * @author rajeev.lochanam
 */
public class LoginInfoModel {
    private String agentName = null;
    private String agentPasscode = null;
    private String agentEnterprise = null;

    private String stationOtherDn = null;
    private String stationTeam = null;
    private String stationDn = null;

    /**
     * @param agentName
     * @param agentPasscode
     * @param agentEnterprise
     */
    public LoginInfoModel(final String agentName, final String agentPasscode, final String agentEnterprise) {
        this.agentName = agentName;
        this.agentPasscode = agentPasscode;
        this.agentEnterprise = agentEnterprise;
    }

    /**
     * @param stationOtherDn
     * @param stationTeam
     * @param stationDn
     */
    public void setStationInfo(final String stationOtherDn, final String stationTeam, final String stationDn) {
        this.stationOtherDn = stationOtherDn;
        this.stationTeam = stationTeam;
        this.stationDn = stationDn;
    }

    /**
     * @return the agentName
     */
    public String getAgentName() {
        return agentName;
    }

    /**
     * @return the agentPasscode
     */
    public String getAgentPasscode() {
        return agentPasscode;
    }

    /**
     * @return the agentEnterprise
     */
    public String getAgentEnterprise() {
        return agentEnterprise;
    }

    /**
     * @return the stationOtherDn
     */
    public String getStationOtherDn() {
        return stationOtherDn;
    }

    /**
     * @return the stationTeam
     */
    public String getStationTeam() {
        return stationTeam;
    }

    /**
     * @return the stationDn
     */
    public String getStationDn() {
        return stationDn;
    }
}
