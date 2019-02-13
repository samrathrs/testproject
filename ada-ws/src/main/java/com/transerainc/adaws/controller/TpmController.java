/**
 *
 */
package com.transerainc.adaws.controller;

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

import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.service.TpmManager;

/**
 * Calls to these APIs are protected by the /nondmz/ path - accessbile only
 * through the configured nondmz port
 */
@Controller
public class TpmController {

    private final Logger LOGGER = LoggerFactory.getLogger(TpmController.class);

    @Autowired
    private TpmManager tpmManager;

    @RequestMapping(value = AdaConstants.PING_PATH, method = RequestMethod.POST)
    @ResponseBody
    public String handlePing(final HttpServletRequest req, final HttpServletResponse res) {
        LOGGER.debug("Handling TPM ping from {}", req.getRemoteAddr());
        return tpmManager.handlePing();
    }

    @RequestMapping(value = AdaConstants.SHUTDOWN_PATH, method = RequestMethod.POST)
    public void handleShutdown(final HttpServletRequest req, final HttpServletResponse res) throws IOException {
        LOGGER.warn("***** SHUTDOWN request from TPM {} ******", req.getRemoteAddr());
        res.getWriter().write(tpmManager.handleShutdown());
        res.getWriter().flush();
        // Shutdown the process
        System.exit(0);
    }

}
