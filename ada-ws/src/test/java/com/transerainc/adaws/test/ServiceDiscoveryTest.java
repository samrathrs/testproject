/**
 * 
 */
package com.transerainc.adaws.test;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.service.DiscoveryService;

/**
 * @author jnarain
 *
 */
public class ServiceDiscoveryTest {
	
	private final static Logger lgr = LoggerFactory.getLogger(ServiceDiscoveryTest.class);
	
	private String ZK_STRING = "ace008.dev.broadcloudcc.com,ace009.dev.broadcloudcc.com";

	//private static Integer tenantId = 11077;
	
	private static DiscoveryService aService;
	
	@Before
	public void initialize() throws Exception {
		// Note: Add SERVICES_PATH in DiscoveryService class and use in serviceDiscovery build
		// private String SERVICES_PATH = "/com/broadsoft/ccone/services";
		
		aService = new DiscoveryService();
		aService.init(ZK_STRING);
		lgr.info("init done");
	}
	
	@Test
	public void getOmniUrl() {
		int i = 5;
		for(i=0; i < 5; i++) {
			String response = aService.getOmniUrl();
			lgr.info("OmniUrl = {}", response);
		}
		aService.stop();
	}
	
}
