/**
 *
 */
package com.transerainc.adaws.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.tam.tpm.TPMFacade;

/**
 * @author suresh.kumar
 */
@Component
public class TpmManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(TpmManager.class);

    @Value("${base.url}")
    private transient String baseUrl;

    private transient TPMFacade tpmFacade;

    /**
     * This is used for registering with TPM
     */
    public void register() {

        try {

            LOGGER.info("-- Started registering with TPM  for {} ---", baseUrl);

            // Read environment variables
            final String appName = StringUtils.trim(System.getProperty("application.name"));
            final String tpmUrl = StringUtils.trim(System.getProperty("tpm.url"));
            final String pidFile = StringUtils.trim(System.getProperty("process.id.file"));

            final String pid = StringUtils.isNotBlank(tpmUrl) ? StringUtils.trim(System.getProperty("process.id"))
                    : StringUtils.trim(getProcessId(pidFile));

            LOGGER.info("-- Application Name {}, PID {}, PID file {} and tpmUrl {} ---", appName, pid, pidFile, tpmUrl);

            final String pingUrl = baseUrl + AdaConstants.PING_PATH;
            final String shutdownUrl = baseUrl + AdaConstants.SHUTDOWN_PATH;

            tpmFacade = TPMFacade.getInstance();

            final int result = tpmFacade.register(appName, pid, pingUrl, shutdownUrl);

            LOGGER.info("-- Completed registering with TPM using url {}, PID {} and response code is {} ---", baseUrl,
                    pid, result);

        } catch (final Exception e) {
            LOGGER.error("Error in registering with tpm.", e);
        }
    }

    public String handlePing() {
        return tpmFacade.respondToPing("0");
    }

    public String handleShutdown() {
        return tpmFacade.respondToShutdown("0");
    }

    /**
     * Read pid from a file.
     *
     * @param pidFile
     * @return
     * @throws IOException
     */
    private String getProcessId(final String pidFile) throws IOException {
        BufferedReader pidReader = null;
        String pid = "";
        LOGGER.info("Reading  PID from file {} ", pidFile);
        try {
            pidReader = new BufferedReader(new FileReader(pidFile));
            pid = StringUtils.trimToEmpty(pidReader.readLine());
        } finally {
            if (pidReader != null) {
                pidReader.close();
            }
        }
        return pid;
    }
}
