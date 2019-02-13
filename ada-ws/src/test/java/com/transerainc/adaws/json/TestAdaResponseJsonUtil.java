package com.transerainc.adaws.json;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.AgentStateConstants;

public class TestAdaResponseJsonUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestAdaResponseJsonUtil.class.getName());

	private static final String SAMPLE_ADA_RESPONSE_DATA = "{\"std.subStatus\":"						+
															"\""										+
															AgentStateConstants.SUBSTATE_IDLE		+
															"\", \"std.status\":\""					+
															AgentStateConstants.STATE_LOGGED_OUT		+
															"\"}";

	@Test
	public void testExtractStatusFromJson() {
		String status = null;
		try {
			status = AdaResponseJsonUtil.extractStatus(TestAdaResponseJsonUtil.SAMPLE_ADA_RESPONSE_DATA);
			LOGGER.info("status: {}", status);
			Assert.assertTrue(org.apache.commons.lang3.StringUtils.isNotBlank(status));
			Assert.assertEquals(status, AgentStateConstants.STATE_LOGGED_OUT);
		} catch (Exception exception) {
			LOGGER.error("Error retrieve RequestData from payload data: {}, with exception: {}",
					TestAdaResponseJsonUtil.SAMPLE_ADA_RESPONSE_DATA,
					exception.toString());
			Assert.fail(exception.toString());
		}
	}

	@Test
	public void testExtractSubStatusFromJson() {
		String subStatus = null;
		try {
			subStatus = AdaResponseJsonUtil.extractSubStatus(TestAdaResponseJsonUtil.SAMPLE_ADA_RESPONSE_DATA);
			LOGGER.info("subStatus: {}", subStatus);
			Assert.assertTrue(org.apache.commons.lang3.StringUtils.isNotBlank(subStatus));
			Assert.assertEquals(subStatus, AgentStateConstants.SUBSTATE_IDLE);
		} catch (Exception exception) {
			LOGGER.error("Error retrieve RequestData from payload data: {}, with exception: {}",
					TestAdaResponseJsonUtil.SAMPLE_ADA_RESPONSE_DATA,
					exception.toString());
			Assert.fail(exception.toString());
		}
	}


}
