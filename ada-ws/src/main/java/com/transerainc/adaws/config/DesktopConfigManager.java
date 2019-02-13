/**
 * 
 */
package com.transerainc.adaws.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.util.StringUtils;

/**
 * @author varsha.shivaram
 */
@Component
public class DesktopConfigManager {

    private static Map<String, DesktopConfiguration> configMap = new HashMap<String, DesktopConfiguration>();
    private static final String tokenAda = generateToken();

    /**
     * @param agentSessionId
     */
    public void populateDesktopConfig(final String agentSessionId) {
        final DesktopConfiguration config = new DesktopConfiguration();
        config.setAgentSessionId(agentSessionId);

        configMap.put(agentSessionId, config);
    }

    /**
     * 
     */
    public void clearDesktopConfig() {
        configMap.clear();
    }

    /**
     * @param agentSessionId
     */
    public void removeDesktopConfig(final String agentSessionId) {
        configMap.remove(agentSessionId);
    }

    /**
     * @param sessionId
     * @return
     */
    public DesktopConfiguration getConfigForAgent(final String sessionId) {
        return configMap.get(sessionId);
    }

    /**
     * @param sessionId
     * @return
     */
    public boolean containsAgentConfig(final String sessionId) {
        return configMap.containsKey(sessionId);
    }

    /**
     * @return
     */
    private static String generateToken() {
        // return String.valueOf(java.lang.System.currentTimeMillis());
        final String uid = StringUtils.generateSessionId();
        return uid;
    }

    /**
     * @return the tokenada
     */
    public static String getTokenada() {
        return tokenAda;
    }
}
