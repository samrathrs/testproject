package com.transerainc.adaws.json;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tnguyen
 *
 */
public class TestCduIdExtractionFromIcxResponse {

	private static Logger LOGGER = LoggerFactory.getLogger(TestCduIdExtractionFromIcxResponse.class.getName());

	private static final String MESSAGE_FROM_ICX_TO_ADA = 
		"{ "																	+ 
			"\"action\": \"AcceptEmailContact\", "							+ 
			"\"responseData\": { " 										+ 
				"\"sessionId\": \"081b52051f424a668fcfd13360fabb6d\", "	+ 
				"\"agentId\": 12, "										+ 
				"\"cduId\": \"ffe0969c01b901200aee3250270f0000\" "		+ 
			"}, "														+ 
			"\"success\": true, "											+ 
			"\"message\": \"Success/Error message\" "						+
		"} "
		;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String cduId = OmniChannelJsonUtil.extractCduIdFromIcxResponse(MESSAGE_FROM_ICX_TO_ADA);
		LOGGER.info( "cduId: {}, from ICX to ADA FE: {}", 
				cduId,
				MESSAGE_FROM_ICX_TO_ADA );
	}
	
	@Test
	public void testExtractSuccessFlag() {
		final String cduId = OmniChannelJsonUtil.extractCduIdFromIcxResponse(MESSAGE_FROM_ICX_TO_ADA);
		final boolean isNonBlankCduId = org.apache.commons.lang3.StringUtils.isNotBlank(cduId);
		Assert.assertTrue(isNonBlankCduId);
    }

}
