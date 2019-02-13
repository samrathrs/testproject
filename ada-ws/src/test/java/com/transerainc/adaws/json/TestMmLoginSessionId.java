/**
 * 
 */
package com.transerainc.adaws.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.TempStubbedICXResponses;

/**
 * @author jnarain
 *
 */
public class TestMmLoginSessionId {

	private static Logger LOGGER = LoggerFactory.getLogger(TestMmLoginSessionId.class.getName());
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String backendId = "1234";
		String mmResponseWithSessionId = OmniChannelJsonUtil.injectBackendSessionId(TempStubbedICXResponses.LOGIN_RESPONSE, backendId);
		
		LOGGER.info(
				"Modified mmResponse with SessionID transmitted to ADA FE: {}",
				mmResponseWithSessionId
				);
		
		LOGGER.info(
				"Original mmResponse sent to ADA FE: {}",
				TempStubbedICXResponses.LOGIN_RESPONSE
				);
		
	}

}
