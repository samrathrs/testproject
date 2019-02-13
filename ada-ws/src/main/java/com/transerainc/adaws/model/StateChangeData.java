/**
 * 
 */
package com.transerainc.adaws.model;

/**
 * @author varsha.shivaram
 */
public class StateChangeData {

    private String callId;
    private String connectionId;
    private String sendId;
    private String positionId;
    private String reason;
    private String retry;
    private AuxCode wrapUpAuxCode;
    private AuxCode idleAuxCode;
    private CallAssociatedData callAssociatedData;

    /**
     * @return
     */
    public String getCallId() {
        return callId;
    }

    /**
     * @param callId
     */
    public void setCallId(final String callId) {
        this.callId = callId;
    }

    /**
     * @return
     */
    public String getPositionId() {
        return positionId;
    }

    /**
     * @param positionId
     */
    public void setPositionId(final String positionId) {
        this.positionId = positionId;
    }

    /**
     * @return
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason
     */
    public void setReason(final String reason) {
        this.reason = reason;
    }

    /**
     * @return
     */
    public String getRetry() {
        return retry;
    }

    /**
     * @param flag
     */
    public void setRetry(final boolean flag) {
        retry = flag ? "true" : "false";
    }

    /**
     * @return
     */
    public AuxCode getWrapUpAuxCode() {
        return wrapUpAuxCode;
    }

    /**
     * @return
     */
    public AuxCode getIdleAuxCode() {
        return idleAuxCode;
    }

    /**
     * @return
     */
    public CallAssociatedData getCallAssociatedData() {
        return callAssociatedData;
    }

    /**
     * @param callAssociatedData
     */
    public void setCallAssociatedData(final CallAssociatedData callAssociatedData) {
        this.callAssociatedData = callAssociatedData;
    }

    /**
     * @param aux
     */
    public void setAuxCode(final AuxCode aux) {
        if (aux == null) { return; }
        if (AuxCode.TYPE_IDLE.equals(aux.getType())) {
            idleAuxCode = aux;
        } else if (AuxCode.TYPE_WRAPUP.equals(aux.getType())) {
            wrapUpAuxCode = aux;
        }
    }

    /**
     * @param auxCodes
     */
    public void setAuxCodes(final AuxCode[] auxCodes) {
        for (int i = 0; auxCodes != null && i < auxCodes.length; i++) {
            final AuxCode aux = auxCodes[i];

            if (aux != null) {
                if (AuxCode.TYPE_IDLE.equals(aux.getType())) {
                    idleAuxCode = aux;
                } else if (AuxCode.TYPE_WRAPUP.equals(aux.getType())) {
                    wrapUpAuxCode = aux;
                }
            }
        }
    }

    /**
     * @return
     */
    public boolean isWrappedUp() {
        return wrapUpAuxCode != null;
    }

    public void clearCallAssociatedData() {
        if (callAssociatedData != null) {
            callAssociatedData = null;
        }
    }

    /**
     * @return the connectionId
     */
    public String getConnectionId() {
        return connectionId;
    }

    /**
     * @param connectionId
     *            the connectionId to set
     */
    public void setConnectionId(final String connectionId) {
        this.connectionId = connectionId;
    }

    /**
     * @return the sendId
     */
    public String getSendId() {
        return sendId;
    }

    /**
     * @param sendId
     *            the sendId to set
     */
    public void setSendId(final String sendId) {
        this.sendId = sendId;
    }
}
