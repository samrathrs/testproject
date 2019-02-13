/**
 * 
 */
package com.transerainc.adaws.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.ServiceProvider;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;
import org.apache.curator.x.discovery.strategies.RoundRobinStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.tam.config.ConfigAgentHelperForXMLBean;
import com.transerainc.tam.config.PopMapping;
import com.transerainc.tam.discovery.InstanceDetails;


/**
 * @author jnarain
 *
 */
@Service
public class DiscoveryService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(DiscoveryService.class);
	
	@Autowired
	private PropertiesUtil propertiesUtil;
	
	@Value("${ace.prov.realm}")
	private String aceRealm;
	
	@Value("${ace.pop.name}")
	private String acePop;
	
	@Value("${ccone.services.path}")
	private String servicesPath;
	
	//private String SERVICES_PATH = "/com/broadsoft/ccone/services";

	private String ZK_STRING = "ace008.dev.broadcloudcc.com,ace009.dev.broadcloudcc.com";
	
	private String zkString = null;
	
	private String serviceName = "mim";

	private CuratorFramework curatorClient = null;
	
	private ServiceDiscovery<InstanceDetails> serviceDiscovery = null;
	
	private ServiceProvider<InstanceDetails> serviceProvider = null;
	
	private List<ServiceInstance<InstanceDetails>> allInstances;
	
	public DiscoveryService() {
		super();
	}

	@PostConstruct
	public void init() throws Exception {
		populatePopMapping();
		
		if (zkString != null) {
			init(zkString);
		} else {
			init(ZK_STRING);
		}
	}
	
	public void init(String zk) {
		
		try {			
			// Client
			curatorClient = CuratorFrameworkFactory
					.newClient(zk, new ExponentialBackoffRetry(1000, 3));			
			curatorClient.start();
			curatorClient.blockUntilConnected(2, TimeUnit.SECONDS);
			LOGGER.info("curatorClient started");

			// Service Discovery
			JsonInstanceSerializer<InstanceDetails> serializer = new JsonInstanceSerializer<InstanceDetails>(InstanceDetails.class);			
			serviceDiscovery = ServiceDiscoveryBuilder.builder(InstanceDetails.class)
						.client(curatorClient)
						.basePath(servicesPath)
						.serializer(serializer)
						.build();
			serviceDiscovery.start();
			LOGGER.info("ServiceDiscovery started");
			
			// Service Provider
			serviceProvider = serviceDiscovery.serviceProviderBuilder()
						.serviceName(serviceName)
						.providerStrategy(new RoundRobinStrategy<InstanceDetails>())
						.build();
			serviceProvider.start();
			LOGGER.info("ServiceProvider started");
			
			// DEBUGGING PURPOSES
			LOGGER.debug("init done: Listing all instances");
			allInstances = Lists.newArrayList(serviceProvider.getAllInstances());
			for (ServiceInstance<InstanceDetails> instance : allInstances) {
				LOGGER.debug("Instance id: {}", instance.getId());
			}		
			
		} catch (Exception e ) {
			LOGGER.error("Exception: starting DiscoveryService: {}", e.getMessage());
			stop();
		}
	}
	
	public String getOmniUrl() {
		
		String response = null;
		try {
			ServiceInstance<InstanceDetails> instance = serviceProvider.getInstance();
			
			if (instance.isEnabled()) {
				response = "http://" + instance.getAddress() + ":" + instance.getPort();
				
			} else {
				LOGGER.debug("getOmniUrl(): Getting all instances for service: {}", serviceName);
				
				allInstances = Lists.newArrayList(serviceProvider.getAllInstances());
				
				for (ServiceInstance<InstanceDetails> inst: allInstances) {
					if (inst.isEnabled()) {
						LOGGER.debug("getOmniUrl(): Found Instance id: {}", inst.getId());
						return response = "http://" + inst.getAddress() + ":" + inst.getPort();					
					}		
				}
			}
		} catch (Exception e) {
			LOGGER.error("getOmniUrl(): Exception while finding a service provider instance :{}", e.getMessage());
		}

		return response;
	}
	
	public String getOmniUrl(final Integer tenantId) {
		
		String response = null;
		try {
			allInstances = Lists.newArrayList(serviceProvider
		            .getAllInstances());
			for (ServiceInstance<InstanceDetails> instance : allInstances) {
				LOGGER.info("Instance id: {}", instance.getId());
				
				if (instance.getPayload() != null) {
					if (!instance.getPayload().getTenantIds().isEmpty()) {
						LOGGER.info("tenantIds: {}", instance.getPayload().getTenantIds());
						
						Iterator<Integer> i= instance.getPayload().getTenantIds().iterator();
						
						while (i.hasNext()) {
							if (i.next().intValue() == tenantId.intValue()) {
								LOGGER.info("Found tenantId in this instance: {}", instance.getId());
								return response = "http://" + instance.getAddress() + ":" + instance.getPort();
							}
						}					
						LOGGER.info("Unable to find tenantId in this instance", instance.getId());				
					} else {
						LOGGER.info("instance.getPayload().getTenantIds().isEmpty() for instanceId = {}",instance.getId());
					}
				} else {
					LOGGER.error("instance.getPayload() = null, instanceId = {}", instance.getId());
				}
			}
		} catch (Exception e) {
			LOGGER.error("getOmniUrl(tenantId): Exception while finding a matching instance for supplied tenantId:{}, Exception:{}", tenantId, e.getMessage());
		}
		return response;
	}
	
	public void populatePopMapping() {

		final String configAgentUrl = propertiesUtil.getAdaProperty(AdaConstants.CONFIG_AGENT_URL_PROPERTY_KEY);
		
		LOGGER.info("populating Pop Mapping");
		try {
			final List<PopMapping> popMappingList =
					ConfigAgentHelperForXMLBean.getPopMappings(configAgentUrl,
							// "/pop-mapping[@componentType='zookeeper' and @popName='ace-dev']", "ace");					
							"/pop-mapping[@componentType='zookeeper' and @popName='"+ acePop + "']", aceRealm);
			if ((popMappingList != null) && (popMappingList.size() > 0)) {
				Iterator<PopMapping> pm = popMappingList.iterator();
			    
			    StringBuilder builder = new StringBuilder();
			    builder.append(pm.next().getHost());
			    while (pm.hasNext()) {
			        builder.append(',').append(pm.next().getHost());
			    }			
				this.zkString = builder.toString();
			}
		} catch (Exception e) {
			LOGGER.error("Error while retrieving pop mapping information");
		}
		
		LOGGER.info("populated ZooKeeper from Pop Mapping: {}", zkString);
	}
	
	public void stop() {
		LOGGER.info("Closing Discovery Services");
		try {
			CloseableUtils.closeQuietly(serviceProvider);
			CloseableUtils.closeQuietly(serviceDiscovery);
			CloseableUtils.closeQuietly(curatorClient);
		} catch (Exception e) {
			LOGGER.warn("Error while stopping Discovery Services: {}", e.getCause());
		}
	}

}
