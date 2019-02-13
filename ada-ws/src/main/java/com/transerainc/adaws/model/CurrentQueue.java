
package com.transerainc.adaws.model;

/**
 * @author jnarain
 *
 */

public class CurrentQueue {
    private Long omniChannelQueueId;
    private Long channelId;

    public CurrentQueue() {
    }

    public CurrentQueue(Long omniChannelQueueId, Long channelId) {
        this.omniChannelQueueId = omniChannelQueueId;
        this.channelId = channelId;
    }

    public Long getOmniChannelQueueId() {
        return this.omniChannelQueueId;
    }

    public void setOmniChannelQueueId(Long omniChannelQueueId) {
        this.omniChannelQueueId = omniChannelQueueId;
    }

    public Long getChannelId() {
        return this.channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CurrentQueue [omniChannelQueueId=");
		builder.append(omniChannelQueueId);
		builder.append(", channelId=");
		builder.append(channelId);
		builder.append("]");
		return builder.toString();
	}
}