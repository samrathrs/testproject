/**
 * 
 */
package com.transerainc.adaws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AgentStateConstants;
import com.transerainc.adaws.exception.ServerNotFoundException;
import com.transerainc.adaws.model.AdaRequest;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.util.GenerateXmlUtil;

/**
 * @author rajeev.lochanam
 */
@Component
public class OutdialService extends BaseService {
    private static Logger LOGGER = LoggerFactory.getLogger(ConsultTransferService.class.getName());

    @Autowired
    private GenerateXmlUtil generateXmlUtil;

    @Autowired
    private DesktopConfigManager agentDesktopConfigMap;

    @Autowired
    private AgentStateService agentStateService;

    /**
     * @param adaRequest
     */
    public void requestOutdial(final AdaRequest adaRequest) {
        final String agentSessionId = adaRequest.getagentSessionId();
        final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
        long startTime = 0;

        if (LOGGER.isInfoEnabled()) {
            startTime = System.currentTimeMillis();
            LOGGER.info(agentSessionId + " :===>> got outdial request at : " + startTime);
        }

        if (desktopConfig.getSubStatus().equals(AgentStateConstants.AVAILABLE)) {
            LOGGER.info(agentSessionId + " :===>> got outdial request in Available state at : " + startTime
                    + " . Going to place agent in Idle state.");

            agentStateService.requestStateChange(AgentStateConstants.LOGGED_IN, AgentStateConstants.IDLE,
                    agentSessionId);
        }

        final String xml = generateXmlUtil.getOutdialAgentCommand(agentSessionId, adaRequest.getTargetId(),
                adaRequest.getOutDialAni(), adaRequest.getLcmContact());

        desktopConfig.getStateChangeData().clearCallAssociatedData();

        String responseString = null;
        try {
            responseString = doHttpPost(agentSessionId, xml);

            desktopConfig.setOutdialCall(true);
            desktopConfig.setOutdialCallCheck(true);
        } catch (final ServerNotFoundException e) {
            LOGGER.error("{} :===> server not found for agent list request :  : {}", agentSessionId, responseString);
        }
        LOGGER.info(agentSessionId + " :===> response to agent list request :  : " + responseString);

        if (LOGGER.isInfoEnabled()) {
            final long endTime = System.currentTimeMillis() - startTime;
            LOGGER.info(agentSessionId + " :===>> Finished handle oudial request : " + endTime);
        }

    }

}
