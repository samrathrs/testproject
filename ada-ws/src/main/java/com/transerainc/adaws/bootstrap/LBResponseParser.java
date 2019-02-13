package com.transerainc.adaws.bootstrap;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.model.ServerData;
import com.transerainc.adaws.util.StringUtils;

/**
 * @author rajeev.lochanam
 */
@Component
public class LBResponseParser {
    private static Logger LOGGER = LoggerFactory.getLogger(LBResponseParser.class.getName());

    private static String START_HASH = "#";

    /**
     * @param s
     * @param failedTacg
     * @return
     */
    public static List<ServerData> parseLBResponse(final String s, final String failedTacg) {
        long startTime = 0;
        if (LOGGER.isInfoEnabled()) {
            startTime = System.currentTimeMillis();
            LOGGER.info("===>> Starting LBResponse parse : " + startTime);
        }

        final List<ServerData> list = new ArrayList<ServerData>();

        final StringTokenizer st = new StringTokenizer(s, "\n");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (StringUtils.isNotEmpty(token) && !token.startsWith(START_HASH)) {
                token = token.trim();
                final ServerData serverData = parseToken(token);

                if (serverData != null) {
                    list.add(serverData);

                    // If failed TACG is not null and ignore if the fresh TACG server list has the failed one
                    final String newTacg = serverData.getHost() + ":" + serverData.getPort();
                    if (failedTacg != null && !failedTacg.isEmpty() && failedTacg.equals(newTacg)) {
                        list.remove(list.size() - 1);
                    }

                    LOGGER.info("===>> TACG is : " + serverData.getHost() + ":" + serverData.getPort());
                }
            }
        }

        if (LOGGER.isInfoEnabled()) {
            final long endTime = System.currentTimeMillis() - startTime;
            LOGGER.info("===>> Finished LBResponse parse : " + endTime);
        }

        return list;
    }

    /**
     * @param token
     * @return
     */
    private static ServerData parseToken(final String token) {
        long startTime = 0;
        if (LOGGER.isDebugEnabled()) {
            startTime = System.currentTimeMillis();
            LOGGER.debug("===>> Starting LBResponse parse : " + startTime);
        }

        try {
            final StringTokenizer st = new StringTokenizer(token, ":");
            final String server = st.nextToken();
            final String portString = st.nextToken();
            final int port = StringUtils.convertToInt(portString, -1);

            if (port < 1) { return null; }

            final ServerData data = new ServerData();
            data.setHost(server);
            data.setPort(port);

            if (LOGGER.isDebugEnabled()) {
                final long endTime = System.currentTimeMillis() - startTime;
                LOGGER.debug("===>> Finished LBResponse parse : " + endTime);
            }

            return data;
        } catch (final Exception e) {
            return null;
        }
    }

}
