package com.transerainc.adaws.json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.transerainc.adaws.service.AnalyzerService;

public class TestTenantCustomerDataExtraction {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestTenantCustomerDataExtraction.class.getName());
	
	private AnalyzerService aService = new AnalyzerService();;

	private static final String SAMPLE_TENANT_CUSTOMER_DATA= "{ \"auxiliaryMetadata\" : { \"id\" : null, \"query\" : { \"anchorId\" : \"3cb58f78-9944-4f8e-ada3-3d2cb75ffe54\", \"columns\" : null, \"filterGroups\" : [ { \"operator\" : \"AND\", \"valueFilters\" : [ ] } ], \"auxiliaryDataType\" : \"RESOURCES\", \"objectType\" : \"customer\" }, \"columns\" : null, \"lastAccessTimestamp\" : 0, \"numberOfRecords\" : 1 }, \"auxiliaryDataList\" : [ { \"id\" : \"AV0Jb_5_9k-Q8AS0RbTX\", \"auxiliaryDataType\" : \"RESOURCES\", \"type\" : \"customer\", \"attributes\" : { \"mobile__s\" : \"\", \"cccEnabled__i\" : 0, \"externalId__s\" : \"\", \"work__s\" : \"\", \"maximumAddressBooks__i\" : 5, \"tid\" : \"10571\", \"maximumTextSkills__i\" : 50, \"maxChannels__l\" : 10, \"multipleTimeZoneEnabled__i\" : 1, \"tenantXmlUrl__s\" : \"http://ace001.dev.broadcloudcc.com:8000/FedEx/FedEx.xml\", \"permitAlert__i\" : 0, \"samCdxDataCompression__i\" : 0, \"maximumUsers__i\" : 2001, \"city__s\" : \"Memphis\", \"legRecordingEnabled__i\" : 1, \"watsonAnalyticsPassword__s\" : \"IW0PwW4MPoOp\", \"postalCode__s\" : \"901\", \"allowAgentThresholds__i\" : 0, \"watsonAnalyticsBaseUrl__s\" : \"https://gateway.watsonplatform.net/tone-analyzer/api/v3/tone?version=2016-05-19\", \"maximumCallbackAttempts__i\" : 0, \"allowUserToResetPassword__i\" : 0, \"maximumActiveAgents__i\" : 2000, \"domain__s\" : \"FedEx.domain\", \"email__s\" : \"pnarah@broadsoft.com\", \"pruningStrategy__s\" : \"NONE\", \"cstts\" : 1499101865566, \"inboundMaximumActiveCalls__l\" : 600, \"maximumActiveCalls__l\" : 1000, \"multiMediaEnabled__i\" : 1, \"firstName__s\" : \"Fred\", \"allowAgentToAccessRecordings__i\" : 0, \"maximumThresholdRules__i\" : 50, \"checkAgentAvailability__i\" : 0, \"recordAllCalls__i\" : 1, \"publishAgentEvents__i\" : 0, \"webCallBackEnabled__i\" : 0, \"lastName__s\" : \"Smith\", \"wfoEnabled__i\" : 1, \"jukeboxEnabled__i\" : 0, \"mapViewEnabled__i\" : 0, \"_lmts__l\" : 1522700321623, \"publishDynamicQueuedValues__i\" : 0, \"publishAgentCommandEvents__i\" : 0, \"recordingPauseDuration__i\" : 10, \"siteLevelTfnEnabled__i\" : 0, \"status__i\" : 1, \"ivrParkUrl__s\" : \"http://ace001.dev.broadcloudcc.com:8000/FedEx\", \"pauseResumeEnabled__i\" : 1, \"maximumVirtualTeams__i\" : 2001, \"outdialMaximumActiveCalls__l\" : 400, \"sid\" : \"AV0Jb_5_9k-Q8AS0RbTX\", \"allowPasswordReset__i\" : 0, \"retryCallbackInterval__i\" : 0, \"thresholdAlertsEnabled__i\" : 0, \"pruningValue__i\" : 1, \"shortCallThreshold__l\" : 5, \"cfbEnabled__i\" : 1, \"maximumSkills__i\" : 200, \"street__s\" : \"\", \"publishAgentDetailedValues__i\" : 0, \"publishCallEvents__i\" : 0, \"watsonAnalyticsUserName__s\" : \"2ca45c54-ee49-4745-a5f9-e25d5b097a1c\", \"country__s\" : \"USA\", \"samIdxDataCompression__i\" : 0, \"voiceCallBackEnabled__i\" : 0, \"seatMapEnabled__i\" : 0, \"tenantId__s\" : \"0\", \"_type__s\" : \"customer\", \"sbrEnabled__i\" : 1, \"dbId__l\" : 10571, \"lastAgentRouting__i\" : 0, \"state__s\" : \"TN\", \"lostCallThreshold__l\" : 10, \"lockUserAllowed__i\" : 0, \"numberOfCadVariables__i\" : 201, \"thirdPartyEnabled__i\" : 1, \"analyticsEnabled__i\" : 1, \"campaignManagerEnabled__i\" : 1, \"publishQueuedValues__i\" : 0, \"samDataCompressionType__s\" : \"NONE\" } } ] }";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Gson gson = new Gson();
		} catch (Exception exception) {
			LOGGER.error("Error PARSING RequestData from payload data: {}, with exception: {}",
					TestTenantCustomerDataExtraction.SAMPLE_TENANT_CUSTOMER_DATA,
					exception.toString());
		}
	}

	@Test
	public void testTenantCustomerData() {
		try {
			final JSONObject tenantCustomerDataJson = new JSONObject(TestTenantCustomerDataExtraction.SAMPLE_TENANT_CUSTOMER_DATA);
			JSONArray tenantCustomerDataList = (JSONArray) tenantCustomerDataJson.get("auxiliaryDataList");
			JSONObject tenantCustomerAttributes = (JSONObject) tenantCustomerDataList.getJSONObject(0).get("attributes");
			LOGGER.info("tenantCustomerAttributes: {}", tenantCustomerAttributes);
			LOGGER.info("Campaign Enabled: {}", tenantCustomerAttributes.get("campaignManagerEnabled__i"));
			String campaiognEnabled = (tenantCustomerAttributes.get("campaignManagerEnabled__i").equals(1) ? "true": "false");
			LOGGER.info("Campaign Enabled: {}", campaiognEnabled);
			Assert.assertTrue(tenantCustomerDataJson != null);
		} catch (Exception exception) {
			LOGGER.error("Error PARSING RequestData from payload data: {}, with exception: {}",
					TestTenantCustomerDataExtraction.SAMPLE_TENANT_CUSTOMER_DATA,
					exception.toString());
			Assert.fail(exception.toString());
		}
	}
	@Test
	public void getTenantCustomerData() throws Exception {
		String tenantId = "10571";
		String response = aService.getTenantCustomerData(tenantId);
		Gson gson = new Gson();
		try {
			//String tenantCustomerData = gson.toJson(response);
			final JSONObject tenantCustomerDataJson = new JSONObject(response);
			JSONArray tenantCustomerDataList = (JSONArray) tenantCustomerDataJson.get("auxiliaryDataList");
			JSONObject tenantCustomerAttributes = (JSONObject) tenantCustomerDataList.getJSONObject(0).get("attributes");
			LOGGER.info("tenantCustomerAttributes: {}", tenantCustomerAttributes);
			LOGGER.info("WFO Enabled: {}", tenantCustomerAttributes.get("wfoEnabled__i"));
			LOGGER.info("Campaign Enabled: {}", tenantCustomerAttributes.get("campaignManagerEnabled__i"));
			//desktopConfig.setWfoEnabled(tenantCustomerAttributes.get("wfoEnabled__i").equals(1) ? "true": "false");
			//desktopConfig.setCampaignEnabled(tenantCustomerAttributes.get("campaignManagerEnabled__i").equals(1) ? "true": "false");
		} catch (Exception exception) {
			LOGGER.error("Error PARSING tenant customer data from analyzer: {}, with exception: {}",
					   response,exception.toString());
		}
	}

}
