/**
 * 
 */
package com.transerainc.adaws.service;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.model.AdaRequest;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.AnalyzerContact;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.util.WebSocketDataPublisher;

/**
 * @author jnarain
 *
 */
@Service
public class AnalyzerServiceWrapper {
	
	private static final Gson GSON = new Gson();

	   @Autowired
	   private AnalyzerService analyzerService;
	   
	   @Autowired
	   private WebSocketDataPublisher dataPublisher;
	   
	   @Autowired
	   private WebSocketCacheManager webSocketCacheManager;
	   
	   @Autowired
	   private DesktopConfigManager configMap;
	   
	   private final Logger lgr = LoggerFactory.getLogger(AnalyzerServiceWrapper.class);

	   public void getTranscript(AdaRequest adaRequest) {
		   
		   final DesktopConfiguration conf = configMap
				   .getConfigForAgent(adaRequest.getagentSessionId());
		   String tenantId = conf.getEnterpriseId();
		   String response = analyzerService
				   .getTranscript(adaRequest.getTranscriptId(), tenantId);
		   
		   Gson gson = new Gson();
		   String transcript = gson.toJson(response);
		   
		   AdaResponse adaResponse = new AdaResponse(CommandConstants.TRANSCRIPT_FETCHED, 
	        				transcript, 
	        				webSocketCacheManager.getToken(adaRequest.getagentSessionId()));
		   
		   dataPublisher.publishData(adaResponse);		   
	   }
	   public JSONObject getTenantCustomerData(String tenantId) {
		   String response = analyzerService.getTenantCustomerData(tenantId);
		   try {
			   final JSONObject tenantCustomerDataJson = new JSONObject(response);
			   return tenantCustomerDataJson;
		   } catch (Exception exception) {
			   lgr.error("Error PARSING tenant customer data from analyzer: {}, with exception: {}",
					   response,exception.toString());
			   return null;
			}
		   
	   }
	   
	   public void publishConsulting(AdaRequest adaRequest) {
		   analyzerService.publishConsulting(adaRequest);	   
	   }

		public String getContactHistoryByAgent(String backendAgentSessionId, long startTime, long endTime) {
			String contactHistory = null;
			final DesktopConfiguration conf = configMap.getConfigForAgent(backendAgentSessionId);  // BE session id

			lgr.debug("DesktopConfiguration: {}, for backendAgentSessionId: {}", conf);

			if (conf != null) {
				List<AnalyzerContact> response = analyzerService.getContactHistoryByAgent(conf.getEnterpriseId(), // tenant id
						conf.getAgentId(),
						startTime,
						endTime);

				lgr.debug("response from analyzerService: {}, for backendAgentSessionId: {}", response, backendAgentSessionId);

				contactHistory = GSON.toJson(response);
			}

			lgr.debug("Agent contactHistory returning: {}", contactHistory);

			return contactHistory;
		}

		public String getContactHistoryByAni(String backendAgentSessionId, String ani, String customerPhoneNumber, long startTime, long endTime) {
			String contactHistory = null;
			final DesktopConfiguration conf = configMap.getConfigForAgent(backendAgentSessionId);  // BE session id

			if (conf != null) {
				List<AnalyzerContact> response = analyzerService.getContactHistoryByANI(conf.getEnterpriseId(), // tenant id
						ani,
						customerPhoneNumber,
						startTime,
						endTime);
				contactHistory = GSON.toJson(response);
			}
			lgr.debug("ANI contactHistory returning: {}", contactHistory);
			return contactHistory;
		}
}
