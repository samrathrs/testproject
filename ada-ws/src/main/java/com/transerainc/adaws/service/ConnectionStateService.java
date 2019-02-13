/**
 * 
 */
package com.transerainc.adaws.service;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import com.transerainc.adaws.cache.ConnectionStateCacheManager;
import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.task.ConnectionStateTask;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.SpringContextHelper;

/**
 * @author varsha.shivaram
 */
@Service
public class ConnectionStateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionStateService.class);

    @Autowired
    private TaskScheduler taskScheduler;

    @Autowired
    private ConnectionStateCacheManager connectionStateCacheManager;
    
    @Autowired
    private WebSocketCacheManager webSocketCacheManager;

    /**
     * @param websocketId
     */
    public void scheduleJob(final String websocketId) {
        final ConnectionStateTask task = SpringContextHelper.getBean(ConnectionStateTask.class);
        final PropertiesUtil propertiesUtil = SpringContextHelper.getBean(PropertiesUtil.class);

        final String taskDelay = propertiesUtil.getAdaProperty("task.initial.delay");
        final String taskInterval = propertiesUtil.getAdaProperty("task.run.interval");
        final String heartbeatRate = propertiesUtil.getAdaProperty("heart.beat.rate");

        task.init(websocketId, Long.valueOf(heartbeatRate));

        LOGGER.info("Scheduling connection lost task for websocketId - " + websocketId + " . With taskDelay:"
                + taskDelay + " ,taskInterval:" + taskInterval + " and heartbeatRate: " + heartbeatRate);

        if(websocketId != null) {
            final ScheduledFuture<?> scheduleFuture = taskScheduler.scheduleAtFixedRate(task,
                    new Date(System.currentTimeMillis() + Long.valueOf(taskDelay)), Long.valueOf(taskInterval));
            connectionStateCacheManager.put(websocketId, scheduleFuture);
        }
    }

    /**
     * @param websocketIds
     */
    public void scheduleAllJobs() {
        Set<String> websocketIds = webSocketCacheManager.getTokenAgentMap().keySet();
        for (String websocketId : websocketIds) {
            scheduleJob(websocketId);
        }
    }

    /**
     * @param websocketId
     */
    public void rescheduleJob(final String websocketId) {
        final ScheduledFuture<?> future = connectionStateCacheManager.getScheduledFuture(websocketId);
        if (future != null) {

            LOGGER.info("Cancelling connection lost task for websocketId - " + websocketId);

            future.cancel(true);
        }
        scheduleJob(websocketId);
    }

    /**
	 * 
	 */
    public void rescheduleAllJobs() {
        for (final Map.Entry<String, ScheduledFuture<?>> entry : connectionStateCacheManager.getFutures().entrySet()) {

            LOGGER.info("Cancelling connection lost task for websocketId - " + entry.getKey());

            entry.getValue().cancel(true);
        }
        connectionStateCacheManager.clear();
        scheduleAllJobs();
    }

    public void cancelJob(final String websocketId) {
        final ScheduledFuture<?> future = connectionStateCacheManager.getScheduledFuture(websocketId);
        if (future != null) {

            LOGGER.info("Cancelling connection lost task for websocketId - " + websocketId);

            future.cancel(true);
        }
    }

}
