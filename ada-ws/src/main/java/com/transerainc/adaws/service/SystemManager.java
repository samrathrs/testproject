package com.transerainc.adaws.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transerainc.adaws.exception.BaseException;

@Service
public class SystemManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemManager.class);

    @Autowired
    private transient TpmManager tpmManager;

    @Autowired
    private ConnectionStateService connectionStateService;

    private boolean reloadApp = false;

    private boolean contextClosed = false;

    /**
     * @throws AdxException
     */
    @PostConstruct
    public void initialize() throws BaseException {
        continueInitialize();
    }

    /**
     * @throws AdxException
     */
    public void reloadConfig() throws BaseException {
        reloadApp = true;
        initialize();
        connectionStateService.rescheduleAllJobs();
    }

    /**
     * @throws AdxException
     */
    private void continueInitialize() throws BaseException {
        // register with tpm
        if (!reloadApp) {
            tpmManager.register();
        }
    }

    public void stop() {

        if (!contextClosed) {

            LOGGER.info("Trying to stop all scheduler...");
            contextClosed = true;
            try {
                // elapse time
                Thread.sleep(5000l);
            } catch (final InterruptedException e) {
                LOGGER.info("InterruptedException...");
            }
        }

    }

}
