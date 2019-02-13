package com.transerainc.adaws.json;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.model.cache.profile.AgentLoginResponseBody;
import com.transerainc.adaws.model.cache.profile.MmProfile;

/**
 * @author tringuyen
 *
 */
public class TestStateCacheJson {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestStateCacheJson.class.getName());
	private static final String AGENT_LOGIN_SUCCESS_BE_TO_FE_PAYLOAD = "{\"mmResponse\":{\"action\":\"OmniChannelAgentLogin\",\"responseData\":{\"channels\":[{\"id\":1,\"name\":\"Email\",\"omniChannelQueues\":[{\"id\":111,\"name\":\"Email Q1\"},{\"id\":222,\"name\":\"Email Q2\"}]},{\"id\":3,\"name\":\"Chat\",\"omniChannelQueues\":[{\"id\":333,\"name\":\"Email Q1\"},{\"id\":444,\"name\":\"Chat Q2\"}]}],\"fileServer\":\"<host>:<port>/file-server\"},\"success\":true,\"message\":\"Authentication successful\"}}";;

	@Test
	public void testGetAgentLoginResponseBodyFromJsonString() {
		AgentLoginResponseBody agentLoginResponseBody = StateCacheJson.getAgentLoginResponseBodyFromJsonString(AGENT_LOGIN_SUCCESS_BE_TO_FE_PAYLOAD);
		MmProfile mmProfile = agentLoginResponseBody.getMmResponse().getResponseData();
		LOGGER.info("MmProfile: {}", mmProfile.debugToString());
	}

}
