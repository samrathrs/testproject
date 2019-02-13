package com.transerainc.adaws.controller;

import java.util.UUID;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.transerainc.adaws.model.AdaRequest;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.SpringContextHelper;

/**
 * @author varsha.shivaram
 */
@Controller
public class AuthenticationController {

    private static Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class.getName());

    /**
     * @param adaRequest
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/generateId", method = RequestMethod.GET)
    public @ResponseBody
    String generateUniqueId(final AdaRequest adaRequest) throws Exception {
        long startTime = 0;
        if (LOGGER.isDebugEnabled()) {
            startTime = System.currentTimeMillis();
            LOGGER.debug("===>> Starting generating unique id : " + startTime);
        }

        JSONObject json = new JSONObject();
        json.put("agentSessionId", noteNewSession(adaRequest));
        json = SpringContextHelper.getBean(PropertiesUtil.class).getInitParamsAsJson(json);

        if (LOGGER.isDebugEnabled()) {
            final long endTime = System.currentTimeMillis() - startTime;
            LOGGER.debug("===>> Finished generating unique id : " + endTime);
        }

        return json.toString();
    }

    /**
     * @param adaRequest
     * @return
     */
    private String noteNewSession(final AdaRequest adaRequest) {
        final String uuid = UUID.randomUUID().toString();
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("==>> New agent session is : " + uuid + " for user : " + adaRequest.getUserName());
        }

        return uuid;
    }
}
