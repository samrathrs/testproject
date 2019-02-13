/**
 * 
 */
package com.transerainc.adaws.test;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.transerainc.adaws.config.WebAppConfig;
import com.transerainc.adaws.service.DesktopService;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.SpringContextHelper;
import com.transerainc.adaws.util.TacgServerUtil;

/**
 * @author varsha.shivaram
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebAppConfig.class, TacgServerUtil.class,
		DesktopService.class })
@WebAppConfiguration
public class LoadAcgServersTest {

	@Autowired
	public TacgServerUtil configUtil;

	@Before
	public void init() {
	    SpringContextHelper.getBean(PropertiesUtil.class).loadProperties(new Properties(), "ada-ws.properties");
//		configUtil.uploadBootstrapServerUrls();
//		for (String enterpriseName : configUtil.getLsitOfEnterprise()) {
//			configUtil.updateAcgServers(enterpriseName);
//			configUtil.resetChecked(enterpriseName);
//		}
	}

	@Test
	public void test() {
//		List<ServerData> data = configUtil
//				.getTacgServerListForEnterprise("GuthyRenker");
//		System.out.println(data.get(0).getHost() + ":" + data.get(0).getPort());
	}

}
