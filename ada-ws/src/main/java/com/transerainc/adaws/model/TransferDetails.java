package com.transerainc.adaws.model;

/**
 * @author tringuyen
 *
 */

public class TransferDetails {
    private Long transferQueueId;
    private Long transferAgentId;
    private String agentComments;

    public TransferDetails() {
    }

    public TransferDetails(Long transferQueueId, Long transferAgentId, String agentComments) {
        this.transferQueueId = transferQueueId;
        this.transferAgentId = transferAgentId;
        this.agentComments = agentComments;
    }

    public Long getTransferQueueId() {
        return this.transferQueueId;
    }

    public void setTransferQueueId(Long transferQueueId) {
        this.transferQueueId = transferQueueId;
    }

    public Long getTransferAgentId() {
        return this.transferAgentId;
    }

    public void setTransferAgentId(Long transferAgentId) {
        this.transferAgentId = transferAgentId;
    }

    public String getAgentComments() {
        return this.agentComments;
    }

    public void setAgentComments(String agentComments) {
        this.agentComments = agentComments;
    }

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransferDetails [transferQueueId=");
		builder.append(transferQueueId);
		builder.append(", transferAgentId=");
		builder.append(transferAgentId);
		builder.append(", agentComments=");
		builder.append(agentComments);
		builder.append("]");
		return builder.toString();
	}
}