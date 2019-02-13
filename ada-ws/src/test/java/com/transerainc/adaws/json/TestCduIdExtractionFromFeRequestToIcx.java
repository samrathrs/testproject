package com.transerainc.adaws.json;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tnguyen
 *
 */
public class TestCduIdExtractionFromFeRequestToIcx {

	private static Logger LOGGER = LoggerFactory.getLogger(TestCduIdExtractionFromFeRequestToIcx.class.getName());

	private static final String MESSAGE_FROM_ADA_TO_ICX = 
		"{ "															+
			"\"action\": \"SendPlainTextEmail\", "					+
			"\"requestData\": { "									+
				"\"cduId\": \"ffe0969c01b901200aee3250270f0000\" "	+ 
			"} "														+ 
		"} "
		;
	
	private static final String MESSAGE_FROM_ADA_TO_ICX2 = 
		"{ " +
			"\"action\": \"DeleteEmailDraft\", " +
			// "\"callbackUrl\":\"http://ace006.dev.broadcloudcc.com:9402/ada-ws/handleOmni\", " + 
			"\"requestData\": { " +
				"\"cduId\":\"bcd7881dc0a4420687eb88b92a5eda8a\", " +
				"\"sessionId\":\"49c10db2-90c0-4553-a687-776d6a9d7a25\", " +
				"\"tenantId\":10571, " +
				"\"agentId\":354, " +
				"\"persistentCallbackUrl\":\"http://ace006.dev.broadcloudcc.com:9402/ada-ws/handleOmni\", " +
				"\"outboundId\":163801 " +
				"} " +
		"} "
		;

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String cduId = OmniChannelJsonUtil.extractCduIdFromFeRequestToIcx(MESSAGE_FROM_ADA_TO_ICX2);
		LOGGER.info( "cduId: {}, from ICX to ADA FE: {}", 
				cduId,
				MESSAGE_FROM_ADA_TO_ICX );
	}
	
	@Test
	public void testExtractSuccessFlag() {
		final String cduId = OmniChannelJsonUtil.extractCduIdFromFeRequestToIcx(MESSAGE_FROM_ADA_TO_ICX);
		final boolean isNonBlankCduId = org.apache.commons.lang3.StringUtils.isNotBlank(cduId);
		Assert.assertTrue(isNonBlankCduId);
    }

}
