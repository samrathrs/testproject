/**
 * 
 */
package com.transerainc.adaws.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.transerainc.adaws.model.ServerData;

/**
 * @author varsha.shivaram
 */
@Component
public class TacgCacheManager {

    private static Map<String, ServerData> agentsessionTacgMap = new HashMap<String, ServerData>();
    private static Map<String, List<String>> tacgAgentMap = new HashMap<String, List<String>>();

    /**
     * @param agentSessionId
     * @param tacg
     */
    public void populateAdaTacgMap(final String agentSessionId, final ServerData tacg) {
        List<String> agents = new ArrayList<String>();
        if (tacg != null) {
            final String tacgIp = tacg.getHost() + ":" + tacg.getPort();
            if (tacgAgentMap.containsKey(tacgIp)) {
                agents = tacgAgentMap.get(tacgIp);
            }
            agents.add(agentSessionId);
            tacgAgentMap.put(tacgIp, agents);
        }

        agentsessionTacgMap.put(agentSessionId, tacg);
    }

    public boolean ipTiedWithAgents(final String tacgIp) {
        if (tacgAgentMap == null || tacgAgentMap.isEmpty()) {
            return false;
        } else if (tacgAgentMap.containsKey(tacgIp) && tacgAgentMap.get(tacgIp) != null
                && !tacgAgentMap.get(tacgIp).isEmpty()) { return true; }

        return false;
    }

    public void removeAgent(final String tacgIp, final String agentSessionId) {
        if (tacgAgentMap == null || tacgAgentMap.isEmpty()) { return; }

        if (tacgAgentMap.containsKey(tacgIp)) {
            final List<String> agents = tacgAgentMap.get(tacgIp);
            if (agents != null && !agents.isEmpty()) {
                if (agents.contains(agentSessionId)) {
                    agents.remove(agentSessionId);
                }

                if (agents.isEmpty()) {
                    tacgAgentMap.remove(tacgIp);
                } else {
                    tacgAgentMap.put(tacgIp, agents);
                }
            }
        }
    }

    /**
     * 
     */
    public void clearAdaTacgMapping() {
        agentsessionTacgMap.clear();
    }

    /**
     * @param agentSessionId
     * @return
     */
    public ServerData getAdaTacgMap(final String agentSessionId) {
        return agentsessionTacgMap.get(agentSessionId);
    }

    /**
     * @param agentSessionId
     */
    public void removeAdaTacgMapping(final String agentSessionId) {
        agentsessionTacgMap.remove(agentSessionId);
    }
}
