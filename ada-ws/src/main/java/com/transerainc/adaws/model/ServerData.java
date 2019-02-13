package com.transerainc.adaws.model;

import java.util.concurrent.ScheduledFuture;

public class ServerData {

    private String host;
    private int port;
    private String protocol;
    private String tacgToken;
    private ScheduledFuture<?> taskId = null;
    private long seqNum;
    
    private boolean checked = false;

    /**
     * @return
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host
     */
    public void setHost(final String host) {
        this.host = host;
    }

    /**
     * @return
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port
     */
    public void setPort(final int port) {
        this.port = port;
    }

    /**
     * @return
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * @param protocol
     */
    public void setProtocol(final String protocol) {
        this.protocol = protocol;
    }

    /**
     * @return
     */
    public boolean isChecked() {
        return checked;
    }

    /**
     * @param checked
     */
    public void setChecked(final boolean checked) {
        this.checked = checked;
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return host + ":" + port;
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
     * @param tacgToken
     *            the tacgToken to set
     */
    public String getTacgHost() {
        return host + ":" + port;
    }

    /**
     * @return the taskId
     */
    public ScheduledFuture<?> getTaskId() {
        return taskId;
    }

    /**
     * @param taskId
     *            the taskId to set
     */
    public void setTaskId(final ScheduledFuture<?> taskId) {
        this.taskId = taskId;
    }

	public long getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(long seqNum) {
		synchronized(this){
		this.seqNum = seqNum;
		}
	}
}
