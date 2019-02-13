/**
 * 
 */
package com.transerainc.ara.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.transerainc.ara.prov.TpmManager;

/**
 * Calls to these APIs are protected by the /nondmz/ path - accessbile only
 * through the configured nondmz port
 * 
 * @author Prashanth
 * 
 */
@Controller
public class TpmController {
	private Logger lgr = LoggerFactory.getLogger(TpmController.class);

	private static final String TPM_PATH = "/nondmz/tpm";

	public static final String PING_PATH = TPM_PATH + "/pingIntf";

	public static final String SHUTDOWN_PATH = TPM_PATH + "/shutdownIntf";

	@Autowired
	private TpmManager tpmManager;

	public TpmController() {
	}

	@RequestMapping(value = PING_PATH, method = RequestMethod.POST)
	@ResponseBody
	public String handlePing(HttpServletRequest req, HttpServletResponse res) {
		lgr.debug("Handling TPM ping from {}", req.getRemoteAddr());
		return tpmManager.handlePing();
	}

	@RequestMapping(value = SHUTDOWN_PATH, method = RequestMethod.POST)
	public void handleShutdown(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		lgr.warn("***** SHUTDOWN request from TPM {} ******",
				req.getRemoteAddr());
		res.getWriter().write(tpmManager.handleShutdown());
		res.getWriter().flush();
		// Shutdown the process
		System.exit(0);
	}

}
