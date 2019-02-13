package com.transerainc.adaws.model;

import com.transerainc.adaws.constants.CallStateConstants;

public class CallModel {

    private boolean holdEnabled = false;
    private boolean conferencing = false;
    private boolean consulting = false;
    private int privacyShieldState = CallStateConstants.SHIELD_ON_DISABLED;
    private int privacyShieldDuration = 0;
    private String vteamId = null;
    private boolean ctqCancel = false;

    public boolean isHoldEnabled() {
        return holdEnabled;
    }

    public void setHoldEnabled(final boolean hold) {
        if (holdEnabled != hold) {
            holdEnabled = hold;
        }
    }

    public boolean isConferencing() {
        return conferencing;
    }

    public void setConferencing(final boolean flag) {
        if (conferencing != flag) {
            conferencing = flag;

            if (conferencing) {
                // implicit un-hold
                holdEnabled = false;
            }
        }
    }

    public int getPrivacyShieldState() {
        return privacyShieldState;
    }

    public void setPrivacyShieldState(final int privacyShieldState) {
        this.privacyShieldState = privacyShieldState;
    }

    /**
     * @return the vteamId
     */
    public String getVteamId() {
        return vteamId == null ? "" : vteamId;
    }

    /**
     * @param vteamId
     *            the vteamId to set
     */
    public void setVteamId(final String vteamId) {
        if (this.vteamId != vteamId) {
            this.vteamId = vteamId;
        }
    }

    /**
     * @return the privacyShieldDuration
     */
    public int getPrivacyShieldDuration() {
        return privacyShieldDuration;
    }

    /**
     * @param privacyShieldDuration
     *            the privacyShieldDuration to set
     */
    public void setPrivacyShieldDuration(final int privacyShieldDuration) {
        this.privacyShieldDuration = privacyShieldDuration;
    }

    public void setPrivacyShieldEnabled(final boolean flag) {
        if (flag) {
            if (privacyShieldState == CallStateConstants.SHIELD_ON_DISABLED) {
                privacyShieldState = CallStateConstants.SHIELD_ON;
            } else if (privacyShieldState == CallStateConstants.SHIELD_OFF_DISABLED) {
                privacyShieldState = CallStateConstants.SHIELD_OFF;
            }
        } else {
            if (privacyShieldState == CallStateConstants.SHIELD_ON) {
                privacyShieldState = CallStateConstants.SHIELD_ON_DISABLED;
            } else if (privacyShieldState == CallStateConstants.SHIELD_OFF) {
                privacyShieldState = CallStateConstants.SHIELD_OFF_DISABLED;
            }
        }
    }

    public void setPrivacyShieldOn(final boolean flag) {
        if (flag && privacyShieldState != CallStateConstants.SHIELD_ON) {
            privacyShieldState = CallStateConstants.SHIELD_ON;
        } else if (!flag && privacyShieldState != CallStateConstants.SHIELD_OFF) {
            privacyShieldState = CallStateConstants.SHIELD_OFF;
        }
    }

    /**
     * @return the consulting
     */
    public boolean isConsulting() {
        return consulting;
    }

    /**
     * @param consulting
     *            the consulting to set
     */
    public void setConsulting(final boolean consulting) {
        this.consulting = consulting;
    }

    /**
     * @return the ctqCancel
     */
    public boolean isCtqCancel() {
        return ctqCancel;
    }

    /**
     * @param ctqCancel
     *            the ctqCancel to set
     */
    public void setCtqCancel(final boolean ctqCancel) {
        this.ctqCancel = ctqCancel;
    }

}
