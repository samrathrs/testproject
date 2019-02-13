/**
 * 
 */
package com.transerainc.ara.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author pgujjeti
 *
 */
@XmlRootElement(name = "active-agent-list", namespace = "http://aim.transerainc.com/tpgintf")
public class ActiveAgentList {

	List<ActiveAgent> activeAgents;

	public ActiveAgentList() {
	}

	@XmlElement(name = "active-agent")
	public List<ActiveAgent> getActiveAgents() {
		return activeAgents;
	}

	public void setActiveAgents(List<ActiveAgent> activeAgent) {
		this.activeAgents = activeAgent;
	}

}
