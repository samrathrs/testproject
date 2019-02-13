/**
 * 
 */
package com.transerainc.adaws.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.transerainc.adaws.model.DesktopConfiguration;

/**
 * @author varsha.shivaram
 */
@Component
public class DesktopConfigAgentMapping {

    private static Map<String, DesktopConfiguration> agentDesktopConfigMap = new HashMap<String, DesktopConfiguration>();

    /**
     * @param agentSessionId
     * @param conf
     */
    public void populateAgentDesktopConfigMap(final String agentSessionId, final DesktopConfiguration conf) {
        agentDesktopConfigMap.put(agentSessionId, conf);
    }

    /**
     * 
     */
    public void clearAgentDesktopConfigMapping() {
        agentDesktopConfigMap.clear();
    }

    /**
     * @param agentSessionId
     */
    public void removeAgentDesktopConfigMapping(final String agentSessionId) {
        agentDesktopConfigMap.remove(agentSessionId);
    }

    /**
     * @param sessionId
     * @return
     */
    public DesktopConfiguration getConfigForAgent(final String sessionId) {
        return agentDesktopConfigMap.get(sessionId);
    }
}
