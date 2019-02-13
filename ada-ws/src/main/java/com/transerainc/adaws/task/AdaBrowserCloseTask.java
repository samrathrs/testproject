package com.transerainc.adaws.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.cache.CloseEventCacheManager;
import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AppParams;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.service.AuthenticationService;
import com.transerainc.adaws.util.StringUtils;

/**
 * @author rajeev.lochanam
 */
@Component("adaBrowserCloseTask")
@Scope("prototype")
public class AdaBrowserCloseTask implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdaBrowserCloseTask.class);

    @Autowired
    protected DesktopConfigManager agentDesktopConfigMap;

    @Autowired
    private WebSocketCacheManager webSocketCacheManager;

    @Autowired
    private CloseEventCacheManager eventCacheManager;

    @Autowired
    private AuthenticationService autService;

    private static final String LOST_CONNECTION_REC_TIMEOUT = "120000";

    @Override
    public void run() {
        final List<String> agents = eventCacheManager.getAgents();

        final List<String> clearingList = new ArrayList<String>();
        for (final String websocketId : agents) {
            final String agentSessionId = webSocketCacheManager.getAgent(websocketId);
            final DesktopConfiguration deskConf = agentDesktopConfigMap.getConfigForAgent(agentSessionId);

            if (deskConf != null) {
                String connecRecTimeout = deskConf.getValue(AppParams.RECOVERY_MAX_TIME);
                if (StringUtils.isEmpty(connecRecTimeout)) {
                    connecRecTimeout = LOST_CONNECTION_REC_TIMEOUT;
                }
                final Long lastHeartbeatTime = deskConf.getConnectionStateModel().getHbTimestamp()
                        + Long.valueOf(connecRecTimeout);
                // final Long lastHeartbeatTime = deskConf.getHeartbeatTime() + Long.valueOf(connecRecTimeout);
                // final Long lastHeartbeatTime = deskConf.getHeartbeatTime() + Long.valueOf(waitOnCloseEvent);

                if (System.currentTimeMillis() > lastHeartbeatTime) {
                    LOGGER.info("{} Sending the logout request", websocketId);

                    autService.requestLogout(agentSessionId, ContextConstants.BROWSER_CLOSED_REASON);
                }
            }

            clearingList.add(websocketId);
        }

        if (!clearingList.isEmpty()) {
        	LOGGER.debug("Clearing buffer/queue of AdaResponses, " + 
    				"because Scheduler is closed for following list of agent sessions.");
        	// TODO:
        	// Remove for-loop after debugging Connection Recovery is complete
        	for (final String agentSessionId : clearingList) {
            	LOGGER.debug("AgentSession: {}, is part of clearing list of closed scheduler. " + 
            			"It's corresponding queue of AdaResponses will be cleared.",
            			agentSessionId);
            }

            eventCacheManager.clearScheduler(clearingList);
        }

        if (!eventCacheManager.isCloseScheduled() && eventCacheManager.getSchedulerId() != null) {
            final ScheduledFuture<?> schedulerId = eventCacheManager.getSchedulerId();

            if (schedulerId != null) {
                schedulerId.cancel(true);
            }

            eventCacheManager.setSchedulerId(null);
        }
    }
}
