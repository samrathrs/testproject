package com.transerainc.adaws.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.exception.BaseException;
import com.transerainc.adaws.model.AgentInfo;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.ResultInfo;
import com.transerainc.adaws.service.AdminService;
import com.transerainc.adaws.service.AuthenticationService;
import com.transerainc.adaws.service.SystemManager;
import com.transerainc.adaws.util.LogLevelInfo;
import com.transerainc.adaws.util.LogLevelInfoForm;
import com.transerainc.adaws.util.LoggingUtil;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.SpringContextHelper;

import ch.qos.logback.classic.Level;

@Controller
@RequestMapping("/nondmz/admin")
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
    private static final Gson GSON = new Gson();

    @Autowired
    private SystemManager sysManager;

    @Autowired
    private transient AdminService adminService;

    @Autowired
    private AuthenticationService authService;

    @Autowired
    private WebSocketCacheManager webSocketCacheManager;

    @Autowired
    private DesktopConfigManager agentDesktopConfigMap;

    @RequestMapping(value = { "", "/", "/home" }, method = RequestMethod.GET)
    public String index(final Model model) {
        model.addAttribute("appInfo", adminService.info());
        return "admin/home";
    }

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo healthCheck() {
        final ResultInfo response = new ResultInfo();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.name());
        return response;
    }

    @RequestMapping(value = "/agent-info", method = RequestMethod.GET)
    public ModelAndView agentInfo() {

        LOGGER.info("Getting agent info ");

        final List<AgentInfo> agentInfoList = new ArrayList<>();

        final Map<String, String> agentTokenMap = webSocketCacheManager.getAgentTokenMap();
        for (final Entry<String, String> agentToken : agentTokenMap.entrySet()) {
            final DesktopConfiguration config = agentDesktopConfigMap.getConfigForAgent(agentToken.getKey());

            if (config != null) {
                final AgentInfo agentInfo = new AgentInfo();

                agentInfo.setAgentSessionId(config.getAgentSessionId());
                agentInfo.setEnterpriseId(config.getEnterpriseName());
                agentInfo.setStatus(config.getStatus());
                agentInfo.setSubStatus(config.getSubStatus());
                agentInfo.setWebSocketId(agentToken.getValue());

                agentInfoList.add(agentInfo);
            }
        }
        return new ModelAndView("admin/agent-info", "agentInfo", agentInfoList);
    }

    @RequestMapping(value = "/logoutAgent", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo logout(@RequestParam(required = true, value = "agentSessionId") final String agentSessionId) {
        final ResultInfo resultInfo = new ResultInfo();

        LOGGER.info("logoutAgent() with agentSessionId: {}", agentSessionId);

        authService.requestLogout(agentSessionId, ContextConstants.BROWSER_CLOSED_REASON);
        resultInfo.setStatus(200);

        return resultInfo;
    }

    @RequestMapping(value = "/forceLogoutAgent", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo forceLogout(
            @RequestParam(required = true, value = "agentSessionId") final String agentSessionId) {
        final ResultInfo resultInfo = new ResultInfo();

        LOGGER.info("forceLogoutAgent() with agentSessionId: {} ", agentSessionId);

        authService.requestForceLogout(agentSessionId, ContextConstants.BROWSER_CLOSED_REASON);
        resultInfo.setStatus(200);

        return resultInfo;
    }

    @RequestMapping(value = "/reload", method = RequestMethod.GET)
    public ModelAndView reload() {
        try {

            LOGGER.info("Reloading ada properties.");

            sysManager.reloadConfig();
        } catch (final BaseException e) {
            LOGGER.error("Exception occured while reloading ada." + e.getMessage());
        }

        return new ModelAndView("admin/home", "appInfo", adminService.info());
    }

    @RequestMapping(value = "properties")
    public ModelAndView readProps(final HttpServletRequest req, final HttpServletResponse res) {
        LOGGER.info("==>> Got request to read properties");
        return new ModelAndView("/admin/properties", "properties",
                SpringContextHelper.getBean(PropertiesUtil.class).getPropertiesMap());
    }

    @RequestMapping(value = "/logging")
    public ModelAndView readLoggersLevels(final HttpServletRequest req, final HttpServletResponse res) {
        LOGGER.info("==>> Got request to read Loggers and Levels from remote IP {}", req.getRemoteAddr());
        final Map<String, Object> loggersModel = new Hashtable<>();

        // Actual loggers in system
        final List<ch.qos.logback.classic.Logger> loggersList = LoggingUtil.getLoggers(true);
        final List<LogLevelInfo> logLevelInfoItems = new ArrayList<>();
        for (final ch.qos.logback.classic.Logger logger : loggersList) {
            final Level level = logger.getLevel();
            final String loggerName = logger.getName();
            if (StringUtils.isNotBlank(loggerName) && level != null) {
                final String levelName = level == null ? "OFF" : level.toString();
                logLevelInfoItems.add(new LogLevelInfo(loggerName, levelName));
            }
        }
        loggersModel.put("logLevelInfoItems", logLevelInfoItems);
        loggersModel.put("logLevelInfoForm", new LogLevelInfoForm(logLevelInfoItems));
        return new ModelAndView("admin/logging", "loggersModel", loggersModel);
    }

    @RequestMapping(value = "/getLogLevels", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String getLogLevels(final HttpServletRequest req, final HttpServletResponse res,
            @RequestParam(required = false) final boolean showAll) {
        LOGGER.info("Getting log levels request from remote IP {}", req.getRemoteAddr());
        final List<ch.qos.logback.classic.Logger> loggers = LoggingUtil.getLoggers(showAll);
        final List<LogLevelInfo> list = new ArrayList<>();
        for (final ch.qos.logback.classic.Logger logger : loggers) {
            final Level level = logger.getLevel();
            list.add(new LogLevelInfo(logger.getName(), level == null ? "OFF" : level.toString()));
        }
        return GSON.toJson(list);
    }

    @RequestMapping(value = "/updateLogLevels", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String updateLogLevels(final HttpServletRequest req, final HttpServletResponse res,
            @RequestParam final String name, @RequestParam final String level) throws Exception {
        LOGGER.info("Updating log level {} to {} . Request is from remote IP {}", name, level, req.getRemoteAddr());
        final ch.qos.logback.classic.Logger logger = LoggingUtil.getLogger(name);
        if (logger != null && StringUtils.isNotBlank(level)) {
            logger.setLevel(Level.valueOf(level));
        }
        return GSON.toJson(ImmutableMap.of("success", "true"));
    }

    @RequestMapping(value = "/changeLogLevels", method = RequestMethod.POST)
    public ModelAndView changeLogLevels(final HttpServletRequest request, final HttpServletResponse response) {
        LOGGER.info("Changing logging levels");

        // Hack for now:
        // Assuming that listing of rows of logging levels returned by HTML form matches
        // listing of loggers retrieved internally,
        // because returning row of logger name as well as logging level is problematic.
        final Map<String, String[]> parameterMap = request.getParameterMap();
        final List<ch.qos.logback.classic.Logger> loggers = LoggingUtil.getLoggers(true);
        final List<ch.qos.logback.classic.Logger> loggersListToUpdate = new ArrayList<>();
        for (final ch.qos.logback.classic.Logger logger : loggers) {
            if (org.apache.commons.lang3.StringUtils.isNotBlank(logger.getName()) && logger.getLevel() != null) {
                loggersListToUpdate.add(logger);
            }
        }
        final Iterator<ch.qos.logback.classic.Logger> loggerIterator = loggersListToUpdate.iterator();
        for (final Map.Entry<String, String[]> parameterMapEntry : parameterMap.entrySet()) {
            final String paramKey = parameterMapEntry.getKey();
            final String[] stringArray = parameterMapEntry.getValue();
            if (stringArray != null && stringArray.length > 0) {
                for (final String element : stringArray) {
                    LOGGER.info("Request Param Key & Value = ({}, {})", paramKey, element);
                    if (loggerIterator.hasNext()) {
                        final ch.qos.logback.classic.Logger logger = loggerIterator.next();
                        logger.setLevel(Level.valueOf(element));
                        LOGGER.info("Setting logger name: {}, to logging level: {}", logger.getName(),
                                logger.getLevel().levelStr);
                    }
                }
            }
        }

        return new ModelAndView("admin/home", "appInfo", adminService.info());
    }
}
