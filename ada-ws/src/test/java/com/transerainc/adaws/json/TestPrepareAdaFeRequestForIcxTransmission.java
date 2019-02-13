/**
 * 
 */
package com.transerainc.adaws.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tringuyen
 *
 */
public class TestPrepareAdaFeRequestForIcxTransmission {

    private static Logger LOGGER = LoggerFactory.getLogger(TestPrepareAdaFeRequestForIcxTransmission.class.getName());
	

	private static final String INCOMING_MM_REQUEST_FROM_ADA_FE = 
			"{ \"mmRequest\": { \"action\": \"OmniChannelAgentLogin\", \"requestData\": { \"key1\" : \"value1\", \"key2\" : \"value2\" } } }";
	private static final String SESSION_ID = "081b52051f424a668fcfd13360fabb6d";
	private static final long AGENT_ID = 14;
	private static final long TENANT_ID = 39;
	private static final String CALLBACK_URL = "http://mccg01-eng.transerainc.com:9410/ada-ws/omniChannel";
	
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		String requestToIcxStrippedOfMmRequest = OmniChannelJsonUtil.stripOutMmRequest(INCOMING_MM_REQUEST_FROM_ADA_FE);
//		String requestToIcx = OmniChannelJsonUtil.injectSessionAgentTenantIdsAndCallbackUrlIntoRequest(
//				SESSION_ID, 
//				AGENT_ID, 
//				TENANT_ID, 
//				CALLBACK_URL, 
//    			requestToIcxStrippedOfMmRequest);
//	
//		LOGGER.info(
//				"Modified Request Body transmitted to ICX: {}",
//				requestToIcx
//				);
//		
//		LOGGER.info(
//				"Original Request Body received by Ada BE: {}",
//				INCOMING_MM_REQUEST_FROM_ADA_FE
//				);
//		
//	}

}
