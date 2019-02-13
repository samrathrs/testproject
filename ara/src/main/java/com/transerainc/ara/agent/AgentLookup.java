/**
 * 
 */
package com.transerainc.ara.agent;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.ara.pojo.ActiveAgent;
import com.transerainc.ara.pojo.ActiveAgentList;
import com.transerainc.tam.util.HttpUtil;

/**
 * @author pgujjeti
 *
 */
public class AgentLookup {
	private static final Logger lgr = LoggerFactory
			.getLogger(AgentLookup.class);

	private static JAXBContext jc = initJaxb();

	private static JAXBContext initJaxb() {
		JAXBContext jaxbContext = null;
		try {
			jaxbContext = JAXBContext.newInstance(ActiveAgentList.class);
		} catch (JAXBException e) {
			throw new RuntimeException(
					"Could not initiliaze the ActiveAgentList JAXB context");
		}
		return jaxbContext;
	}

	public AgentLookup() throws JAXBException {
	}

	public ActiveAgent lookupAgent(String aimUrl, Long agentId,
			String channelType) throws Exception {
		ActiveAgent aa = null;
		lgr.debug("Looking for agent {} at {}", agentId, aimUrl);
		String url = aimUrl + (aimUrl.contains("?") ? "&" : "?") + "agentId="
				+ agentId;
		String agentResponse = HttpUtil.doHttpGet(url, "AgentLookup");
		lgr.debug("Response from aim {} is {}", url, agentResponse);
		aa = parseAgentResponse(agentResponse, channelType);
		return aa;
	}

	private ActiveAgent parseAgentResponse(String agentResponse,
			String channelType) throws JAXBException {
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		ActiveAgentList activeAgentList = (ActiveAgentList) unmarshaller
				.unmarshal(new StringReader(agentResponse));
		List<ActiveAgent> aAgents = null;
		if (activeAgentList != null
				&& (aAgents = activeAgentList.getActiveAgents()) != null) {
			for (ActiveAgent a : aAgents) {
				if (channelType == null
						|| channelType.equals(a.getChannelType()))
					return a;
			}
		}
		return null;
	}

}
