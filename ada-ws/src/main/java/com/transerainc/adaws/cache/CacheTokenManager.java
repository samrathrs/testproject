/**
 * 
 */
package com.transerainc.adaws.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.transerainc.adaws.util.StringUtils;

/**
 * @author rajeev.lochanam
 */
@Component
public class CacheTokenManager {
    private static Map<String, String> tokenTacg = new HashMap<String, String>();

    /**
     * @param token
     * @param serverIp
     */
    public void populateToken(final String token, final String serverIp) {
        synchronized (tokenTacg) {
            tokenTacg.put(token, serverIp);
        }
    }

    /**
     * @param serverToken
     * @param serverIp
     */
    public void updateToken(final String serverToken, final String serverIp) {
        String oldToken = "";
        if (!tokenTacg.isEmpty() && tokenTacg.values().contains(serverIp)) {
            for (final String token : tokenTacg.keySet()) {
                if (tokenTacg.get(token).equals(serverIp)) {
                    oldToken = token;
                }
            }
        }

        if (StringUtils.isNotEmpty(oldToken)) {
            removeToken(oldToken);
        }

        populateToken(serverToken, serverIp);
    }

    /**
     * 
     */
    public void clearToken() {
        tokenTacg.clear();
    }

    /**
     * @param token
     * @return
     */
    public boolean tokenExists(final String token) {
        return tokenTacg.containsKey(token);
    }

    /**
     * @return
     */
    public boolean tokenExists() {
        return !tokenTacg.isEmpty();
    }

    /**
     * @param token
     * @return
     */
    public String getToken(final String token) {
        return tokenTacg.get(token);
    }

    /**
     * @param token
     */
    public void removeToken(final String token) {
        tokenTacg.remove(token);
    }

}
