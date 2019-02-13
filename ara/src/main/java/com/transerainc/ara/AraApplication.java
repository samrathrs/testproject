package com.transerainc.ara;

import java.util.concurrent.ScheduledThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.transerainc.ara.agent.AimProvider;
import com.transerainc.ara.pojo.Xpath;
import com.transerainc.ara.prov.ConfigProvider;
import com.transerainc.ara.prov.TpmManager;
import com.transerainc.ara.service.AgentService;
import com.transerainc.provisioning.ConfigAgentConnector;
import com.transerainc.provisioning.ns.NotificationServerConnector;
import com.transerainc.provisioning.ns.NotificationServerConnectorImpl;
import com.transerainc.provisioning.ns.NotificationServerInterfaceServlet;
import com.transerainc.provisioning.ns.NotificationServerRegistry;

@SpringBootApplication
public class AraApplication {
	private static final String NS_INTF = "/service/nsIntf";

	private static final Logger lgr = LoggerFactory
			.getLogger(AraApplication.class);

	// ConfigProvider tracks the component's configuration
	@Bean(name = "configProvider")
	public ConfigProvider configProvider(
			@Value("${xera.ara.config.agent.url:http://localhost:9877}") String configAgentUrl,
			@Value("${xera.ara.config.xpath}") String configXpath,
			@Value("${xera.ara.base.url}") String baseUrl) throws Exception {
		// Config Agent Connector
		lgr.info("Config Agent URL {}", configAgentUrl);
		ConfigProvider configProvider = new ConfigProvider(configAgentUrl,
				configXpath);
		configProvider.setBaseUrl(baseUrl);
		configProvider.init();
		return configProvider;
	}

	// Supporting classes for the Notification Server framework
	@Bean(name = "configAgentConnector")
	public ConfigAgentConnector configConnector(
			@Value("${xera.ara.config.agent.url:http://localhost:9877}") String configAgentUrl) {
		// Config Agent Connector
		lgr.info("Config Agent URL {}", configAgentUrl);
		ConfigAgentConnector cac = new ConfigAgentConnector();
		cac.setConfigAgentUrl(configAgentUrl);
		return cac;
	}

	// Supporting classes for the Notification Server framework
	@Bean(name = "provExecutorPool", destroyMethod = "shutdownNow")
	public ScheduledThreadPoolExecutor provThreadPool() {
		int corePoolSize = 5;
		ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(
				corePoolSize);
		return stpe;
	}

	// Supporting classes for the Notification Server framework
	// Notification Server callback servlet
	@Bean
	public ServletRegistrationBean nsServlet() {
		NotificationServerInterfaceServlet nsServlet = new NotificationServerInterfaceServlet();
		return new ServletRegistrationBean(nsServlet, NS_INTF);
	}

	// Supporting classes for the Notification Server framework
	@Bean(destroyMethod = "shutdown")
	public NotificationServerConnector nsConnector(
			ScheduledThreadPoolExecutor stpe, ConfigAgentConnector cac,
			@Value("${xera.ara.base.url}") String baseUrl) throws Exception {
		NotificationServerConnectorImpl nsImpl = new NotificationServerConnectorImpl(
				stpe);
		nsImpl.setCallbackUrl(baseUrl + NS_INTF);
		nsImpl.setConfigAgent(cac);
		lgr.info("Finished initializing NS Connector with "
				+ "ConfigAgentConnector {}", cac);
		nsImpl.init();
		return nsImpl;
	}

	// Supporting classes for the Notification Server framework
	@Bean
	public NotificationServerRegistry nsRegistry(
			NotificationServerConnector nsConnector) {
		NotificationServerRegistry nsr = new NotificationServerRegistry();
		nsr.addConnector(nsConnector);
		return nsr;
	}

	// Supporting class for TPM framework
	@Bean(initMethod = "init")
	public TpmManager tpmManager(ConfigProvider cp) {
		TpmManager tm = new TpmManager();
		tm.setBaseUrl(cp.getBaseUrl());
		return tm;
	}

	// AimProvider tracks AIM information
	@Bean(destroyMethod = "stop")
	public AimProvider aimProvider(ConfigProvider configProvider,
			ConfigAgentConnector cac, NotificationServerConnector nsConnector,
			ScheduledThreadPoolExecutor stpe) throws Exception {
		Xpath aimXpath = configProvider.getAraConfig().getAimXpath();
		AimProvider aimProvider = new AimProvider(cac.getConfigAgentUrl(),
				aimXpath, nsConnector);
		return aimProvider;
	}

	// AgentService - is the main bean providing agent related actions
	@Bean
	public AgentService agentService(ConfigProvider configProvider,
			AimProvider aimProvider) throws Exception {
		AgentService as = new AgentService(configProvider, aimProvider);
		return as;
	}

	public static void main(String[] args) {
		SpringApplication.run(AraApplication.class, args);
	}
}
