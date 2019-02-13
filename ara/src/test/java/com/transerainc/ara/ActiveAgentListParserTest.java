/**
 * 
 */
package com.transerainc.ara;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.transerainc.ara.pojo.ActiveAgent;
import com.transerainc.ara.pojo.ActiveAgentList;
import com.transerainc.tam.tpm.TPMFacade;
import com.transerainc.tam.util.IOUtil;

/**
 * @author pgujjeti
 *
 */
public class ActiveAgentListParserTest {
	private final Logger lgr = LoggerFactory
			.getLogger(ActiveAgentListParserTest.class);

	private JAXBContext jc;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		jc = JAXBContext.newInstance(ActiveAgentList.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws JsonParseException, JsonMappingException,
			IOException, JAXBException {
		String agentResponseFile = "src/test/resources/agent-list.xml";
		lgr.debug("Parsing activeAgentList file {}", agentResponseFile);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		String agentResponse = IOUtil
				.getInputAsString(new FileInputStream(agentResponseFile));
		ActiveAgentList activeAgentList = (ActiveAgentList) unmarshaller
				.unmarshal(new StringReader(agentResponse));
		lgr.info("Active agents {}", activeAgentList.getActiveAgents());
		if (parseAgentResponse(activeAgentList, "telephony") == null) {
			throw new IOException("Agent not found");
		}
	}

	private ActiveAgent parseAgentResponse(ActiveAgentList activeAgentList,
			String channelType) throws JAXBException {
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

	@Test
	public void testTPMFacade() throws IOException {
		TPMFacade tf = TPMFacade.getInstance();
		String respondToPing = tf.respondToPing("0");
		lgr.info("Response to ping: {}", respondToPing);
	}
}
