/**
 *
 */
package com.transerainc.adaws.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.service.DiscoveryService;
import com.transerainc.adaws.service.SystemManager;

@Component
public class WebAppListener implements ApplicationListener<ContextClosedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebAppListener.class);

    @Autowired
    private transient SystemManager sysManager;
    
    @Autowired
    private DiscoveryService discoveryService;

    @Override
    public void onApplicationEvent(final ContextClosedEvent event) {

        LOGGER.info("Got ContextClosedEvent, so trying cleanup all running tasks...");

        	discoveryService.stop();
        sysManager.stop();

        LOGGER.info("Done!!!");

    }

}
