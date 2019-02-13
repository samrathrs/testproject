/**
 * 
 */
package com.transerainc.adaws.json;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author trin3
 *
 */
public class TestExtractNameEmailFromCustomerEmailInformation {

	private static Logger LOGGER = LoggerFactory.getLogger(TestExtractNameEmailFromCustomerEmailInformation.class.getName());

	private static final String MESSAGE_FROM_ADA_TO_ICX_WITH_ONE_CUSTOMER_EMAIL = 
		"{ "															+ 
			"\"action\": \"ContactCompletedRequest\", "				+ 
			"\"requestData\": { "									+ 
				"\"to\": [{ "								+
					"\"name\": \"tri.nguyen.m.tri\", "				+ 
					"\"email\": \"tri.nguyen.m.tri@gmail.com\" "		+ 
				"}]"													+ 
			"} "														+ 
		"} "
		;
	
	private static final String MESSAGE_FROM_ADA_TO_ICX_WITH_NO_CUSTOMER_EMAIL_AT_ALL = 
			"{ "															+ 
				"\"action\": \"ContactCompletedRequest\", "				+ 
				"\"requestData\": { "									+ 
				"} "														+ 
			"} "
			;
		
	private static final String MESSAGE_FROM_ADA_TO_ICX_WITH_EMPTY_CUSTOMER_EMAIL_ARRAY = 
			"{ "															+ 
				"\"action\": \"ContactCompletedRequest\", "				+ 
				"\"requestData\": { "									+ 
					"\"customerEmail\": [ "								+ 
					"]"													+ 
				"} "														+ 
			"} "
			;
		
	private static final String MESSAGE_FROM_ADA_TO_ICX_WITH_TWO_CUSTOMER_EMAILS = 
			"{ "															+ 
				"\"action\": \"ContactCompletedRequest\", "				+ 
				"\"requestData\": { "									+ 
					"\"to\": [ "								+
						"{ \"name\": \"tri.nguyen.m.tri\", "				+ 
						"\"email\": \"tri.nguyen.m.tri@gmail.com\" }"	+ 
						" , "											+ 
						"{ \"name\": \"nguyentn02\", "				+ 
						"\"email\": \"nguyentn02@gmail.com\" }"	+ 
						"]"												+
				"} "														+
			"} "
			;
		
	@Test
	public void testNameEmailPairFromCustomerInfoWithOneElement() {
		final Map<String, String> nameEmailPairMap = OmniChannelJsonUtil.extractNameEmailFromCustomerEmailInformation(MESSAGE_FROM_ADA_TO_ICX_WITH_ONE_CUSTOMER_EMAIL);
		
		Assert.assertTrue(nameEmailPairMap != null);
		Assert.assertTrue(!nameEmailPairMap.isEmpty());
		Assert.assertTrue(nameEmailPairMap.size() == 1);
		Assert.assertTrue("tri.nguyen.m.tri@gmail.com".equals(nameEmailPairMap.get("tri.nguyen.m.tri")));
	}

	@Test
	public void testNameEmailPairFromCustomerInfoWithNoElementsAtAll() {
		final Map<String, String> nameEmailPairMap = OmniChannelJsonUtil.extractNameEmailFromCustomerEmailInformation(MESSAGE_FROM_ADA_TO_ICX_WITH_NO_CUSTOMER_EMAIL_AT_ALL);
		
		Assert.assertTrue(
							(nameEmailPairMap == null) 		|| 
							(nameEmailPairMap.isEmpty())		|| 
							(nameEmailPairMap.size() == 0)
						);
	}

	@Test
	public void testNameEmailPairFromCustomerInfoWithEmptyArray() {
		final Map<String, String> nameEmailPairMap = OmniChannelJsonUtil.extractNameEmailFromCustomerEmailInformation(MESSAGE_FROM_ADA_TO_ICX_WITH_EMPTY_CUSTOMER_EMAIL_ARRAY);
		
		Assert.assertTrue(
							(nameEmailPairMap == null) 		|| 
							(nameEmailPairMap.isEmpty())		|| 
							(nameEmailPairMap.size() == 0)
						);
	}

	@Test
	public void testNameEmailPairFromCustomerInfoWithTwoElements() {
		final Map<String, String> nameEmailPairMap = OmniChannelJsonUtil.extractNameEmailFromCustomerEmailInformation(MESSAGE_FROM_ADA_TO_ICX_WITH_TWO_CUSTOMER_EMAILS);
		
		Assert.assertTrue(nameEmailPairMap != null);
		Assert.assertTrue(!nameEmailPairMap.isEmpty());
		Assert.assertTrue(nameEmailPairMap.size() == 2);
		Assert.assertTrue("tri.nguyen.m.tri@gmail.com".equals(nameEmailPairMap.get("tri.nguyen.m.tri")));
		Assert.assertTrue("nguyentn02@gmail.com".equals(nameEmailPairMap.get("nguyentn02")));
	}

}
