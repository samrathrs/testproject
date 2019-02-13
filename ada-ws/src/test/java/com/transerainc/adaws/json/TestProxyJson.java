package com.transerainc.adaws.json;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestProxyJson {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestProxyJson.class.getName());

	private static final String SAMPLE_GET_AGENT_CALL_GUIDE_MODEL = "{\"agentSessionId\":\"5175aa9a-6206-48a6-98a5-72ddd64dea5f\",\"requestData\":{\"AccountNumber\":\"72|3|4|0|0|21|2\"}}";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ProxyJson.getRequestDataFromJson(TestProxyJson.SAMPLE_GET_AGENT_CALL_GUIDE_MODEL);
		} catch (Exception exception) {
			LOGGER.error("Error retrieve RequestData from payload data: {}, with exception: {}",
					TestProxyJson.SAMPLE_GET_AGENT_CALL_GUIDE_MODEL,
					exception.toString());
		}
	}

	@Test
	public void testGetRequestDataFromJson() {
		String requestDataAsJson = null;
		try {
			requestDataAsJson = ProxyJson.getRequestDataFromJson(TestProxyJson.SAMPLE_GET_AGENT_CALL_GUIDE_MODEL);
			LOGGER.info("requestDataAsJson: {}", requestDataAsJson);
			Assert.assertTrue(org.apache.commons.lang3.StringUtils.isNotBlank(requestDataAsJson));
		} catch (Exception exception) {
			LOGGER.error("Error retrieve RequestData from payload data: {}, with exception: {}",
					TestProxyJson.SAMPLE_GET_AGENT_CALL_GUIDE_MODEL,
					exception.toString());
			Assert.fail(exception.toString());
		}
	}

}
