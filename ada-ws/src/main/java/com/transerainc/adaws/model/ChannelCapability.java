/**
 * 
 */
package com.transerainc.adaws.model;

import com.transerainc.adaws.constants.ChannelType;

/**
 * @author jnarain
 *
 */
public class ChannelCapability {
		
	public static final int CHAT_CHANNEL_ID = 3;
	public static final int EMAIL_CHANNEL_ID = 1;
	
	// These Ids and status are populated from ICX specifics in OmniChannelController
	private boolean chatChannelsLoggedIn = false;
	private boolean emailChannelsLoggedIn = false;
	private boolean teleChannelsLoggedIn = false;
	
	private int chatChannels = 0;
	private int emailChannels = 0;
	private int teleChannels = 0;
	
	private int blendingMode = 0;
	
	/**
	 * @param chatChannels
	 * @param emailChannels
	 * @param teleChannels
	 */
	public ChannelCapability(int chatChannels, int emailChannels, int teleChannels, int blendingMode) {
		super();
		this.chatChannels = chatChannels;
		this.emailChannels = emailChannels;
		this.teleChannels = teleChannels;
		this.blendingMode = blendingMode;
	}
	/**
	 * @return the chatChannels
	 */
	public int getChatChannels() {
		return chatChannels;
	}
	/**
	 * @param chatChannels the chatChannels to set
	 */
	public void setChatChannels(int chatChannels) {
		this.chatChannels = chatChannels;
	}
	/**
	 * @return the emailChannels
	 */
	public int getEmailChannels() {
		return emailChannels;
	}
	/**
	 * @param emailChannels the emailChannels to set
	 */
	public void setEmailChannels(int emailChannels) {
		this.emailChannels = emailChannels;
	}
	/**
	 * @return the teleChannels
	 */
	public int getTeleChannels() {
		return teleChannels;
	}
	/**
	 * @param teleChannels the teleChannels to set
	 */
	public void setTeleChannels(int teleChannels) {
		this.teleChannels = teleChannels;
	}

	public boolean hasTelephonyCapability() {
		return (this.getTeleChannels() > 0) ? true : false;
	}

	public boolean hasChatCapability() {
		return (this.getChatChannels() > 0) ? true : false;
	}

	public boolean hasEmailCapability() {
		return (this.getEmailChannels() > 0) ? true : false;
	}

	public boolean hasAnyOmniChannelCapability() {
		return (this.hasChatCapability() || this.hasEmailCapability());
	}

	public boolean hasAllCapabilities() {
		return (this.hasTelephonyCapability() &&
				this.hasChatCapability() && 
				this.hasEmailCapability());
	}
	/**
	 * @return the chatChannelsLoggedIn
	 */
	public boolean isChatChannelsLoggedIn() {
		return chatChannelsLoggedIn;
	}
	/**
	 * @param chatChannelsLoggedIn the chatChannelsLoggedIn to set
	 */
	public void setChatChannelsLoggedIn(boolean chatChannelsLoggedIn) {
		this.chatChannelsLoggedIn = chatChannelsLoggedIn;
	}
	/**
	 * @return the emailChannelsLoggedIn
	 */
	public boolean isEmailChannelsLoggedIn() {
		return emailChannelsLoggedIn;
	}
	/**
	 * @param emailChannelsLoggedIn the emailChannelsLoggedIn to set
	 */
	public void setEmailChannelsLoggedIn(boolean emailChannelsLoggedIn) {
		this.emailChannelsLoggedIn = emailChannelsLoggedIn;
	}
	/**
	 * @return the teleChannelsLoggedIn
	 */
	public boolean isTeleChannelsLoggedIn() {
		return teleChannelsLoggedIn;
	}
	/**
	 * @param teleChannelsLoggedIn the teleChannelsLoggedIn to set
	 */
	public void setTeleChannelsLoggedIn(boolean teleChannelsLoggedIn) {
		this.teleChannelsLoggedIn = teleChannelsLoggedIn;
	}
	/**
	 * @return the blendingMode
	 */
	public int getBlendingMode() {
		return blendingMode;
	}
	/**
	 * @param blendingMode the blendingMode to set
	 */
	public void setBlendingMode(int blendingMode) {
		this.blendingMode = blendingMode;
	}

	public boolean hasChannelCapability(ChannelType channelType) {
		switch (channelType) {
		case Telephony:
			return hasTelephonyCapability();
		case Chat:
			return hasChatCapability();
		case Email:
			return hasEmailCapability();
		default:
			return false;
		}
	}
}
