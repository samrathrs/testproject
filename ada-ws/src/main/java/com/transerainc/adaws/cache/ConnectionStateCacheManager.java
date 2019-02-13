/**
 * 
 */
package com.transerainc.adaws.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import org.springframework.stereotype.Component;

/**
 * @author varsha.shivaram
 */
@Component
public class ConnectionStateCacheManager {

    private final Map<String, ScheduledFuture<?>> futures = new HashMap<String, ScheduledFuture<?>>();

    /**
     * @return the futures
     */
    public Map<String, ScheduledFuture<?>> getFutures() {
        return futures;
    }

    /**
     * @param websocketId
     * @param scheduleFuture
     */
    public void put(final String websocketId, final ScheduledFuture<?> scheduleFuture) {
        synchronized (futures) {
            futures.put(websocketId, scheduleFuture);
        }
    }

    /**
     * @param websocketId
     * @return
     */
    public ScheduledFuture<?> getScheduledFuture(final String websocketId) {
        return futures.get(websocketId);
    }

    public void clear() {
        futures.clear();
    }

}
