/**
 * 
 */
package com.transerainc.adaws.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.transerainc.adaws.model.ServerData;

/**
 * @author rajeev.lochanam
 */
@Component
public class CacheServerManager {
    private static Map<String, ServerData> serversTacg = new HashMap<String, ServerData>();

    /**
     * @param agentSessionId
     * @param tacg
     */
    public void populateServer(final String serverIp, final ServerData server) {
        // synchronized (serversTacg) {
        if (serversTacg.containsKey(serverIp)) {
            final ServerData savedSvr = serversTacg.get(serverIp);
            server.setTaskId(savedSvr.getTaskId());
        }
        synchronized(this){
        serversTacg.put(serverIp, server);
        }
        // }
    }

    /**
     * @param agentSessionId
     * @param tacg
     */
    public void updateServer(final String serverIp, final String serverToken) {
        if (serversTacg.containsKey(serverIp)) {
            final ServerData server = serversTacg.get(serverIp);
            server.setTacgToken(serverToken);

            populateServer(serverIp, server);
        }
    }

    /**
     * 
     */
    public void clearServer() {
        serversTacg.clear();
    }

    /**
     * @param agentSessionId
     * @return
     */
    public boolean serverExists(final String serverIp) {
        return serversTacg.containsKey(serverIp);
    }

    /**
     * @param agentSessionId
     * @return
     */
    public boolean serverExists() {
        return !serversTacg.isEmpty();
    }

    /**
     * @param agentSessionId
     * @return
     */
    public ServerData getServer(final String serverIp) {
        return serversTacg.get(serverIp);
    }

    /**
     * @param agentSessionId
     */
    public void removeServer(final String serverIp) {
        serversTacg.remove(serverIp);
    }
}
