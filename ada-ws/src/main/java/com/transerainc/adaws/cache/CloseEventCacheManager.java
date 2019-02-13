/**
 * 
 */
package com.transerainc.adaws.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.model.AdaResponse;

/**
 * @author rajeev.lochanam
 */
@Component
public class CloseEventCacheManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CloseEventCacheManager.class.getName());

    private static Map<String, List<AdaResponse>> queueStates = new HashMap<String, List<AdaResponse>>();
    private static List<String> closeEvents = new ArrayList<String>();

    private ScheduledFuture<?> schedulerId = null;

    /**
     * @param agentSessionId
     */
    public void tieScheduler(final String agentSessionId) {
        if (!closeEvents.contains(agentSessionId)) {
            // synchronized (closeEvents) {
            closeEvents.add(agentSessionId);
            // }
        }
    }

    /**
     * @param agentSessionId
     */
    public void clearScheduler(final String agentSessionId) {
        if (closeEvents.contains(agentSessionId)) {
            // synchronized (closeEvents) {
            closeEvents.remove(agentSessionId);
            // }
        }
    }

    /**
     * @param agentSessionId
     */
    public boolean waitingForClose(final String agentSessionId) {
        return closeEvents.contains(agentSessionId);
    }

    /**
     * @return
     */
    public List<String> getAgents() {
        return closeEvents;
    }

    /**
     * 
     */
    public void clearScheduler() {
        // synchronized (closeEvents) {
        closeEvents.clear();
        // }
    }

    /**
     * @param clearingList
     */
    public void clearScheduler(final List<String> clearingList) {
        if (clearingList != null && !clearingList.isEmpty()) {
            // synchronized (closeEvents) {
            for (final String agentSessionId : clearingList) {
                if (closeEvents.contains(agentSessionId)) {
                    closeEvents.remove(agentSessionId);
                }

                clearQueueStates(agentSessionId);
            }
            // }
        }
    }

    /**
     * @return
     */
    public boolean isCloseScheduled() {
        return !closeEvents.isEmpty();
    }

    /**
     * @return the schedulerId
     */
    public ScheduledFuture<?> getSchedulerId() {
        return schedulerId;
    }

    /**
     * @param schedulerId
     *            the schedulerId to set
     */
    public void setSchedulerId(final ScheduledFuture<?> schedulerId) {
        this.schedulerId = schedulerId;
    }

    /**
     * @return the queueStates
     */
    public List<AdaResponse> getQueueStates(final String agentSession) {
        return queueStates.get(agentSession);
    }

    /**
     * @return the queueStates
     */
    public boolean isStatesQueued() {
        return !queueStates.isEmpty();
    }

    /**
     * @param queueStates
     *            the queueStates to set
     */
    public void setQueueStates(final String agentSession, final AdaResponse adaResponse) {
        List<AdaResponse> queuedResponse = null;

        if (queueStates.containsKey(agentSession)) {
            queuedResponse = queueStates.get(agentSession);
        } else {
            queuedResponse = new ArrayList<AdaResponse>();
        }

        queuedResponse.add(adaResponse);
        queueStates.put(agentSession, queuedResponse);
    }

    /**
     * @param queueStates
     *            the queueStates to set
     */
    public boolean isStatesQueueing(final String agentSession) {
        return queueStates.containsKey(agentSession);
    }

    /**
     * @param queueStates
     *            the queueStates to set
     */
    public void clearQueueStates(final String agentSession) {
	    	LOGGER.debug("Clearing queue states for agentSession: {}", agentSession);
	    	if (queueStates.containsKey(agentSession)) {
	            queueStates.remove(agentSession);
	        }
    }

    /**
     * @param queueStates
     *            the queueStates to set
     */
    public void clearQueuedStates() {
    		LOGGER.debug("Clearing all/entire queue states for all Agent Sessions");
        if (queueStates != null && isStatesQueued()) {
            queueStates.clear();
        }
    }
}
