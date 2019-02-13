/**
 * 
 */
package com.transerainc.adaws.test;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.transerainc.adaws.model.AdaRequest;
import com.transerainc.adaws.model.AnalyzerContact;
import com.transerainc.adaws.service.AnalyzerService;
import com.transerainc.adaws.util.PropertiesUtil;

/**
 * @author pgujjeti
 *
 */
public class AnalyzerServiceTest {
	private final Logger lgr = LoggerFactory
			.getLogger(AnalyzerServiceTest.class);

	private String tenantId = "1";

	private String agentId = "1";

	private String ani = "1";
	
	private String customerPhone = "1";

	private AnalyzerService aService;
	
	private AdaRequest adaReq;

	@Before
	public void init() throws Exception {
		PropertiesUtil propertiesUtil = new PropertiesUtil();
		propertiesUtil.load();

		aService = new AnalyzerService();
		aService.setPropertiesUtil(propertiesUtil);
		aService.init();
	}

	@Test
	public void getContactHistory() throws Exception {
		long startTime = System.currentTimeMillis() - (86400 * 7 * 1000L);
		long endTime = System.currentTimeMillis();

		List<AnalyzerContact> contacts = aService
				.getContactHistoryByANI(tenantId, ani, customerPhone, startTime, endTime);
		lgr.info("Returned contacts size {}", contacts.size());

		contacts = aService.getContactHistoryByAgent(tenantId, agentId,
				startTime, endTime);
		lgr.info("Returned contacts size {}", contacts.size());
	}

	@Test
	public void getTranscript() throws Exception {
		String transcriptId = "";// TODO
		String transcript = aService.getTranscript(transcriptId, tenantId);
		lgr.info("Transcript for {} is: {}", transcriptId, transcript);
	}
	
	@Test
	public void publishConsulting() throws Exception {
		adaReq.setConsultingType("UC");
		adaReq.setConsultTime("12345");
		adaReq.setContactId("56");
		adaReq.setContactType("email");
		adaReq.setagentSessionId("145bc942-f8af-460d-a11e-41105860a7e7");
		
		aService.publishConsulting(adaReq);
		//aService.prepareRequest(adaReq, requestData, destination);
		lgr.info("Done sending UC Consulting to Analyzer");
	}
	@Test
	public void getTenantCustomerData() throws Exception {
		String tenantId = "10571";
		String response = aService.getTenantCustomerData(tenantId);
		Gson gson = new Gson();
		try {
			String tenantCustomerData = gson.toJson(response);
			final JSONObject tenantCustomerDataJson = new JSONObject(tenantCustomerData);
			JSONArray tenantCustomerDataList = (JSONArray) tenantCustomerDataJson.get("auxiliaryDataList");
			JSONObject tenantCustomerAttributes = (JSONObject) tenantCustomerDataList.getJSONObject(0).get("attributes");
			lgr.info("tenantCustomerAttributes: {}", tenantCustomerAttributes);
			lgr.info("WFO Enabled: {}", tenantCustomerAttributes.get("wfoEnabled__i"));
			lgr.info("Campaign Enabled: {}", tenantCustomerAttributes.get("campaignManagerEnabled__i"));
			//desktopConfig.setWfoEnabled(tenantCustomerAttributes.get("wfoEnabled__i").equals(1) ? "true": "false");
			//desktopConfig.setCampaignEnabled(tenantCustomerAttributes.get("campaignManagerEnabled__i").equals(1) ? "true": "false");
		} catch (Exception exception) {
			lgr.error("Error PARSING tenant customer data from analyzer: {}, with exception: {}",
					   response,exception.toString());
		}
	}
	

}
