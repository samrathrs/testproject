package com.transerainc.adaws.model.cache.icrm;

/**
 * @author tnguyen
 *
 */
public class IcrmResponse {

	private String id;
	private String name;
	private String mmpId;
	private long chatChannels;
	private long emailChannels;
	private long teleChannels;
	private String chatUrl;
	private String emailUrl;
	private boolean casEnabled;

	/**
	 * 
	 */
	public IcrmResponse() {
	}

	/**
	 * @param id
	 * @param name
	 * @param mmpId
	 * @param chatChannels
	 * @param emailChannels
	 * @param teleChannels
	 * @param chatUrl
	 * @param emailUrl
	 * @param casEnabled
	 */
	public IcrmResponse(String id, String name, String mmpId, long chatChannels, long emailChannels, long teleChannels,
			String chatUrl, String emailUrl, boolean casEnabled) {
		this.id = id;
		this.name = name;
		this.mmpId = mmpId;
		this.chatChannels = chatChannels;
		this.emailChannels = emailChannels;
		this.teleChannels = teleChannels;
		this.chatUrl = chatUrl;
		this.emailUrl = emailUrl;
		this.casEnabled = casEnabled;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mmpId
	 */
	public String getMmpId() {
		return mmpId;
	}

	/**
	 * @param mmpId the mmpId to set
	 */
	public void setMmpId(String mmpId) {
		this.mmpId = mmpId;
	}

	/**
	 * @return the chatChannels
	 */
	public long getChatChannels() {
		return chatChannels;
	}

	/**
	 * @param chatChannels the chatChannels to set
	 */
	public void setChatChannels(long chatChannels) {
		this.chatChannels = chatChannels;
	}

	/**
	 * @return the emailChannels
	 */
	public long getEmailChannels() {
		return emailChannels;
	}

	/**
	 * @param emailChannels the emailChannels to set
	 */
	public void setEmailChannels(long emailChannels) {
		this.emailChannels = emailChannels;
	}

	/**
	 * @return the teleChannels
	 */
	public long getTeleChannels() {
		return teleChannels;
	}

	/**
	 * @param teleChannels the teleChannels to set
	 */
	public void setTeleChannels(long teleChannels) {
		this.teleChannels = teleChannels;
	}

	/**
	 * @return the chatUrl
	 */
	public String getChatUrl() {
		return chatUrl;
	}

	/**
	 * @param chatUrl the chatUrl to set
	 */
	public void setChatUrl(String chatUrl) {
		this.chatUrl = chatUrl;
	}

	/**
	 * @return the emailUrl
	 */
	public String getEmailUrl() {
		return emailUrl;
	}

	/**
	 * @param emailUrl the emailUrl to set
	 */
	public void setEmailUrl(String emailUrl) {
		this.emailUrl = emailUrl;
	}

	/**
	 * @return the casEnabled
	 */
	public boolean isCasEnabled() {
		return casEnabled;
	}

	/**
	 * @param casEnabled the casEnabled to set
	 */
	public void setCasEnabled(boolean casEnabled) {
		this.casEnabled = casEnabled;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IcrmResponse [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", mmpId=");
		builder.append(mmpId);
		builder.append(", chatChannels=");
		builder.append(chatChannels);
		builder.append(", emailChannels=");
		builder.append(emailChannels);
		builder.append(", teleChannels=");
		builder.append(teleChannels);
		builder.append(", chatUrl=");
		builder.append(chatUrl);
		builder.append(", emailUrl=");
		builder.append(emailUrl);
		builder.append(", casEnabled=");
		builder.append(casEnabled);
		builder.append("]");
		return builder.toString();
	}

}
