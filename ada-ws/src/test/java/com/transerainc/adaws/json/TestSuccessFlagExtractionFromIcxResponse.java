package com.transerainc.adaws.json;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tnguyen
 *
 */
public class TestSuccessFlagExtractionFromIcxResponse {

	private static Logger LOGGER = LoggerFactory.getLogger(TestSuccessFlagExtractionFromIcxResponse.class.getName());

	private static final String MESSAGE_FROM_ICX_TO_ADA = 
			"{ \"action\":\"AcceptChatContact\", \"responseData\":{ \"sessionId\":\"ffdf836e000b001e0aee324fa0640000\", \"agentId\":11, \"omniChannelQueueId\":0 }, \"success\":true, \"message\":\"Success/Error message\" }";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final boolean isSuccessful = OmniChannelJsonUtil.extractSuccessFlagFromResponse(MESSAGE_FROM_ICX_TO_ADA);
		LOGGER.info( "success flag: {}, from ICX to ADA FE: {}", 
				Boolean.valueOf(isSuccessful),
				MESSAGE_FROM_ICX_TO_ADA );
	}
	
	@Test
	public void testExtractSuccessFlag() {
		final boolean isSuccessful = OmniChannelJsonUtil.extractSuccessFlagFromResponse(MESSAGE_FROM_ICX_TO_ADA);
		Assert.assertTrue(isSuccessful);
    }

}
