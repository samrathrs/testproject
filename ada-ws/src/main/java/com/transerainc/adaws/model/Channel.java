/**
 * 
 */
package com.transerainc.adaws.model;

/**
 * @author Prashanth
 */
public class Channel {

    private String channelId;

    private String type;

    /**
     * 
     */
    public Channel() {
    }

    /**
     * @param channelId
     * @param type
     */
    public Channel(final String channelId, final String type) {
        this();
        this.channelId = channelId;
        this.type = type;
    }

    /**
     * @return
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * @param channelId
     */
    public void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    /**
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return channelId + " (" + type + ")";
    }
}
