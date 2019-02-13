/**
 * 
 */
package com.transerainc.adaws.model;


/**
 * @author pgujjeti
 *
 */
public class AnalyzerContact {
	private String agentName;

	private String ani;

	private String sid;

	private String entrypointName;

	private Long cstts;

	private Long cetts;

	private String channelType;

	private String transcript;

	private String outboundTranscript;

	private String terminationType;

	private Long talkDuration;
	
	private String subject;
	
	private String customerName;
	
	private String dnis;
	
	private String callDirection;

	public AnalyzerContact() {
		super();
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAni() {
		return ani;
	}

	public void setAni(String ani) {
		this.ani = ani;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getEntrypointName() {
		return entrypointName;
	}

	public void setEntrypointName(String entrypointName) {
		this.entrypointName = entrypointName;
	}

	public Long getCstts() {
		return cstts;
	}

	public void setCstts(Long cstts) {
		this.cstts = cstts;
	}

	public Long getCetts() {
		return cetts;
	}

	public void setCetts(Long cetts) {
		this.cetts = cetts;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getTranscript() {
		return transcript;
	}

	public void setTranscript(String transcript) {
		this.transcript = transcript;
	}

	public String getTerminationType() {
		return terminationType;
	}

	public void setTerminationType(String terminationType) {
		this.terminationType = terminationType;
	}

	public Long getTalkDuration() {
		return talkDuration;
	}

	public void setTalkDuration(Long talkDuration) {
		this.talkDuration = talkDuration;
	}

	public String getOutboundTranscript() {
		return outboundTranscript;
	}

	public void setOutboundTranscript(String outboundTranscript) {
		this.outboundTranscript = outboundTranscript;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDnis() {
		return dnis;
	}

	public void setDnis(String dnis) {
		this.dnis = dnis;
	}
	
	public String  getCallDirection() {
		return callDirection;
	}
	
	public void setCallDirection(String callDirection) {
		this.callDirection = callDirection;
	}
}
