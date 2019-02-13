/**
 * 
 */
package com.transerainc.adaws.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.bootstrap.LBResponseParser;
import com.transerainc.adaws.connection.HttpUtil;
import com.transerainc.adaws.model.ServerData;

/**
 * @author varsha.shivaram
 */
@Component
public class TacgServerUtil {
    private static Logger LOGGER = LoggerFactory.getLogger(TacgServerUtil.class.getName());

    @Autowired
    private HttpUtil httpUtil;

    @Autowired
    private PropertiesUtil propertiesUtil;

    // current list of acgServers for the enterprise <ServerData>
    private List<ServerData> acgServers = new LinkedList<ServerData>();

    private List<URL> bootstrapServers;

    // enterpriseID, List<TACG servers>
    private final Map<String, List<ServerData>> tenantTacgServerMap = new HashMap<String, List<ServerData>>();

    /**
     * 
     */
    public void uploadBootstrapServerUrls() {
        // bootstrapPath = AgentAppDefaults.BOOTSTRAP_PATH;

        final List<URL> bootstrapList = convertToUrls(
                getListFromCSV(propertiesUtil.getAdaProperty("bootstrap.server")),
                propertiesUtil.getAdaProperty("bootstap.path"));
        if (LOGGER.isInfoEnabled()) {
            final StringBuffer sb = new StringBuffer();
            sb.append("Bootstrap server urls: ");
            printList(bootstrapList, sb);
            sb.append("\nBootstrap path: " + propertiesUtil.getAdaProperty("bootstap.path"));
            LOGGER.info(sb.toString());
        }

        if (bootstrapList == null || bootstrapList.isEmpty()) {
            LOGGER.error("Bootstrap servers undefined. ACG List empty.");
            return;
        }

        bootstrapServers = bootstrapList;
    }

    /**
     * @param enterpriseName
     * @return
     */
    public boolean updateAcgServers(final String enterpriseName) {
        if (bootstrapServers == null) {
            LOGGER.error("Bootstrap servers undefined. ACG List empty.");
            return false;
        }

        for (URL url : bootstrapServers) {
            try {
                url = new URL(url, propertiesUtil.getAdaProperty("bootstap.path"));
            } catch (final MalformedURLException e1) {
                LOGGER.warn("Failed to create bootstrap url from base " + url + ", path "
                        + propertiesUtil.getAdaProperty("bootstap.path"));
            }
            try {
                final String response = requestAcgServerList(url, enterpriseName);
                if (response != null) {
                    loadAcgServers(response); // remove it later
                    final List<ServerData> tacgServers = LBResponseParser.parseLBResponse(response, "");
                    tenantTacgServerMap.put(enterpriseName, tacgServers);
                    return true;
                }
            } catch (final IOException e) {
                LOGGER.warn("Failed to get ACG servers from " + url);
            }
        }
        LOGGER.error("ACG List empty.");
        return false;
    }

    /**
     * @param enterpriseName
     * @param failedTacg
     * @return
     */
    public List<ServerData> getAcgServers(final String enterpriseName, final String failedTacg) {
        if (bootstrapServers == null) {
            LOGGER.error("Bootstrap servers undefined. ACG List empty.");
            return null;
        }

        for (URL url : bootstrapServers) {
            try {
                url = new URL(url, propertiesUtil.getAdaProperty("bootstap.path"));
            } catch (final MalformedURLException e1) {
                LOGGER.warn("Failed to create bootstrap url from base " + url + ", path "
                        + propertiesUtil.getAdaProperty("bootstap.path"));
            }
            try {
                final String response = requestAcgServerList(url, enterpriseName);
                if (response != null) {
                    loadAcgServers(response); // remove it later
                    LOGGER.info("===>> Reading the TACG servers for tenant : " + enterpriseName);
                    final List<ServerData> tacgServers = LBResponseParser.parseLBResponse(response, failedTacg);
                    tenantTacgServerMap.put(enterpriseName, tacgServers);

                    LOGGER.info("===>> Above are the list of TACG servers for tenant : " + enterpriseName);
                    return tacgServers;
                }
            } catch (final IOException e) {
                LOGGER.warn("Failed to get ACG servers from " + url + e);
            }
        }
        LOGGER.error("ACG List empty.");
        return null;
    }

    /**
     * @param enterprise
     * @return
     */
    public List<ServerData> getTacgServerListForEnterprise(final String enterprise) {
        return tenantTacgServerMap.get(enterprise);
    }

    /**
     * @param response
     */
    private void loadAcgServers(final String response) {
        acgServers = LBResponseParser.parseLBResponse(response, "");
        if (LOGGER.isInfoEnabled()) {
            final StringBuffer sb = new StringBuffer();
            StringUtils.printList(acgServers, sb);
            LOGGER.info("ACG Servers loaded: " + sb.toString());
        }
    }

    /**
     * @return
     */
    public List<String> getLsitOfEnterprise() {
        final List<String> tenants = new ArrayList<String>();
        tenants.add("GuthyRenker");
        return tenants;
    }

    /**
     * @param enterprise
     */
    public void resetChecked(final String enterprise) {
        for (final ServerData asd : tenantTacgServerMap.get(enterprise)) {
            asd.setChecked(false);
        }
    }

    /**
     * @return next ACG server to connect to. null if there are none.
     */
    public ServerData getNextServer() {
        ServerData nextAcg = null;
        for (final ServerData asd : acgServers) {
            if (!asd.isChecked()) {
                nextAcg = asd;
                asd.setChecked(true);
                break;
            }
        }
        return nextAcg;
    }

    /**
     * @param url
     * @param enterpriseName
     * @return
     * @throws IOException
     */
    protected String requestAcgServerList(final URL url, final String enterpriseName) throws IOException {
        // final HttpUtil req = new HttpUtil();
        final Map<String, String> params = new HashMap<String, String>();
        params.put("enterprise", enterpriseName);

        try {
            httpUtil.doPost(url.toString(), params);
            return httpUtil.getResponse();
        } catch (final Exception e) {
            LOGGER.warn("Exception occured while getting acg server list " + e);
        }
        return null;
    }

    /**
     * @param bootstrapServers
     * @param sb
     */
    public void printList(final List<URL> bootstrapServers, final StringBuffer sb) {
        sb.append("[");
        for (int i = 0; bootstrapServers != null && i < bootstrapServers.size(); i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(bootstrapServers.get(i));
        }
        sb.append("]");
    }

    /**
     * @param csvString
     * @return
     */
    public static List<String> getListFromCSV(final String csvString) {
        final List<String> tokens = new ArrayList<String>();

        if (csvString != null) {
            final String[] values = csvString.split(",");
            for (final String value : values) {
                if (value != null && !value.startsWith("#")) {
                    tokens.add(value.trim());
                }
            }
        }

        return tokens;
    }

    /**
     * @param urlStrings
     * @param defaultHost
     * @return
     */
    public static List<URL> convertToUrls(final List<String> urlStrings, final String defaultHost) {
        final List<URL> list = new LinkedList<URL>();
        for (String urlString : urlStrings) {
            if (urlString.indexOf(':') == 0) {
                urlString = defaultHost + urlString;
            }

            try {
                // just create a http URL for the valid parsing and storing
                // of the host and port
                urlString = urlString.trim();
                URL url = null;
                try {
                    url = new URL(urlString);
                } catch (final Exception e) {
                    // Add the http:// prefix
                    url = new URL("http://" + urlString);
                }
                list.add(url);
            } catch (final MalformedURLException e) {
                LOGGER.warn("Invalid server host and port format: " + urlString + ". Ignored.");
            }
        }
        return list;
    }

}
