/**
 * 
 */
package com.transerainc.adaws.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author rajeev.lochanam
 */
@Component
public class AgentCacheManager {
    private static Map<String, List<String>> enterpriseAgents = new HashMap<String, List<String>>();

    /**
     * @param enterprise
     * @param agentSession
     */
    public void populateAgent(final String enterprise, final String agentSession) {
        List<String> agents = new ArrayList<String>();
        if (enterpriseAgents.containsKey(enterprise)) {
            agents = enterpriseAgents.get(enterprise);
        }

        if (!agents.contains(agentSession)) {
            agents.add(agentSession);
        }

        populateAgent(enterprise, agents);
    }

    /**
     * @param enterprise
     * @param agents
     */
    public void populateAgent(final String enterprise, final List<String> agents) {
        synchronized (enterpriseAgents) {
            enterpriseAgents.put(enterprise, agents);
        }
    }

    /**
     * 
     */
    public void clearAgents() {
        enterpriseAgents.clear();
    }

    /**
     * @param enterprise
     * @return
     */
    public List<String> getAgents(final String enterprise) {
        return enterpriseAgents.get(enterprise);
    }

    /**
     * @param enterprise
     */
    public void removeAgents(final String enterprise) {
        enterpriseAgents.remove(enterprise);
    }

    /**
     * @param enterprise
     */
    public boolean agentSubscribed(final String enterprise) {
        return enterpriseAgents.containsKey(enterprise);
    }

    /**
     * @param enterprise
     * @param agent
     */
    public void removeAgent(final String enterprise, final String agent) {
        if (enterpriseAgents.containsKey(enterprise)) {
            final List<String> agents = enterpriseAgents.get(enterprise);
            if (agents != null && !agents.isEmpty() && agents.contains(agent)) {
                agents.remove(agent);
            }

            if (agents == null || agents.isEmpty()) {
                removeAgents(enterprise);
            } else {
                this.populateAgent(enterprise, agents);
            }
        }
    }
    
    /**
     * @return the enterpriseAgents
     */
    public Map<String, List<String>> getEnterpriseAgents() {
        return enterpriseAgents;
    }
}
