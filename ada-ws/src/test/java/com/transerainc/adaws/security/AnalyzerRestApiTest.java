/**
 * 
 */
package com.transerainc.adaws.security;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.retriever.UserInformationRetriever;

/**
 * @author tnguyen
 * 
 * This class is based on AnalyzerRestApiTest in transera-cas project.
 *
 */
public class AnalyzerRestApiTest {

	private static final Logger lgr = LoggerFactory
			.getLogger(AnalyzerRestApiTest.class);
	private static final String AWS_USERNAME_VALUE = "DevAgentMM4@fedex.com";
	private static final String AWS_ENTERPRISE_VALUE = "FedEx";
	private static final String EXAMPLE_TENANT_JSON_RESPONSE = "{" + 
																  "\"code\": 200," +
																  "\"details\": {" +
																    "\"tenants\": [" +
																      "{" +
																        "\"id\": \"10571\"," +
																        "\"name\": \"FedEx\"," + 
																        "\"description\": \"\"," +
																        "\"tenantType\": \"CUSTOMER\"," +
																        "\"parentId\": \"1\"," +
																        "\"timezone\": \"Pacific/Tahiti\"," +
																        "\"maxCompRecords\": 0," +
																        "\"interactionRetentionDuration\": 0," +
																        "\"aarRetentionDuration\": 0," +
																        "\"maxCacheSize\": 0," +
																        "\"lastModifiedTimestamp\": \"Jul 3, 2017 5:10:55 PM\"" +
																      "}" +
																    "]" +
																  "}" +
																"}";
	private static final String EXAMPLE_USER_DETAILS_INFO_JSON_RESPONSE = 
			"{" +
				"\"auxiliaryMetadata\" : {" +
				"}," +
				"\"auxiliaryDataList\" : [ {" +
					"\"attributes\" : {" +
						"\"callCenterEnabled__i\" : 1" +
					"}" +
				"} ]" +
			"}"
			;

	@Test
	public void testGetCallCenterEnabledFlag() {
		UserInformationRetriever userInformationRetriever = new UserInformationRetriever();
		boolean isCallCenterEnabled = userInformationRetriever.extractCallCenterEnabledFlagFromResponse(EXAMPLE_USER_DETAILS_INFO_JSON_RESPONSE);
		Assert.assertTrue("Call Center Enabled of user should be true " + 
								", but is: " +
								isCallCenterEnabled, 
								isCallCenterEnabled);
	}

	@Test
	public void testGetEnterpriseNameOfUser() {
		UserInformationRetriever userInformationRetriever = new UserInformationRetriever();
		String enterpriseName = userInformationRetriever.extractEnterpriseNameFromResponse(EXAMPLE_TENANT_JSON_RESPONSE);
		Assert.assertTrue("Enterprise of user" + 
								AWS_USERNAME_VALUE + 
								" should be " + 
								AWS_ENTERPRISE_VALUE +
								", but is: " +
								enterpriseName, 
							StringUtils.equals(AWS_ENTERPRISE_VALUE, enterpriseName));
	}

}
