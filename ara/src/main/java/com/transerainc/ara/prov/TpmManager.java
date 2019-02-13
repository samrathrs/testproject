/**
 * 
 */
package com.transerainc.ara.prov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.ara.controller.TpmController;
import com.transerainc.tam.tpm.TPMFacade;

/**
 * @author Prashanth
 * 
 */
public class TpmManager {
	private static final Logger lgr = LoggerFactory
			.getLogger(TpmManager.class);

	private TPMFacade tpmFacade;

	private String baseUrl;

	public TpmManager() {
	}

	public void init() {
		lgr.info("Initializing the TPM Adapter");

		try {
			tpmFacade = TPMFacade.getInstance();
			String pid = System.getProperty("process.id");
			String pingUrl = baseUrl + TpmController.PING_PATH;
			String shutdownUrl = baseUrl + TpmController.SHUTDOWN_PATH;
			lgr.info("Registering the processId {} with TPM. Ping URL is '{}'"
					+ " and Shutdown URL is '{}'", pid, pingUrl, shutdownUrl);
			tpmFacade.register(System.getProperty("application.name"), pid,
					pingUrl, shutdownUrl);
		} catch (Exception e) {
			lgr.warn("Exception initializing the TPM Facade", e);
		}
	}

	public String handlePing() {
		return tpmFacade.respondToPing("0");
	}

	public String handleShutdown() {
		return tpmFacade.respondToShutdown("0");
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

}
