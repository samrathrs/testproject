package com.transerainc.adaws.model.cache.profile;

/**
 * @author tnguyen
 *
 */
public class MmProfile {

	private String sessionId;
	private long agentId;
	private Channel[] channels;
	private String fileServer;

	/**
	 * 
	 */
	public MmProfile() {
	}

	/**
	 * @param sessionId
	 * @param agentId
	 * @param channels
	 * @param fileServer
	 */
	public MmProfile(String sessionId, long agentId, Channel[] channels, String fileServer) {
		this.sessionId = sessionId;
		this.agentId = agentId;
		this.channels = channels;
		this.fileServer = fileServer;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the agentId
	 */
	public long getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return the channels
	 */
	public Channel[] getChannels() {
		return channels;
	}

	/**
	 * @param channels the channels to set
	 */
	public void setChannels(Channel[] channels) {
		this.channels = channels;
	}

	/**
	 * @return the fileServer
	 */
	public String getFileServer() {
		return fileServer;
	}

	/**
	 * @param fileServer the fileServer to set
	 */
	public void setFileServer(String fileServer) {
		this.fileServer = fileServer;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MmProfile [sessionId=");
		builder.append(sessionId);
		builder.append(", agentId=");
		builder.append(agentId);
		builder.append(", channels=");
		if ((channels != null) && (channels.length > 0)) {
			for(Channel channel : channels) {
				builder.append(channel.debugToString());
			}
		} else {
			builder.append("null");
		}
		builder.append(", fileServer=");
		builder.append(fileServer);
		builder.append("]");
		return builder.toString();
	}

}
