/**
 * 
 */
package com.transerainc.adaws.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rajeev.lochanam
 */
public class ChannelSet {
    private Map<String, Channel> channelMap;

    /**
     * 
     */
    public ChannelSet() {
        channelMap = new HashMap<String, Channel>();
    }

    /**
     * @param channel
     */
    public void addChannel(final Channel channel) {
        channelMap.put(channel.getChannelId(), channel);
    }

    /**
     * @param channelMap
     */
    public void setChannelMap(final Map<String, Channel> channelMap) {
        this.channelMap = channelMap;
    }

    /**
     * @return
     */
    public Map<String, Channel> getChannelMap() {
        return channelMap;
    }
}
