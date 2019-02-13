/**
 * 
 */
package com.transerainc.adaws.command.factory;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.command.AgentCommand;
import com.transerainc.adaws.command.AuthenticationStatusCommand;
import com.transerainc.adaws.command.DesktopConfigurationCommand;
import com.transerainc.adaws.exception.InterpretationException;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.TacgResponse;
import com.transerainc.adaws.util.XbeanHelper;
import com.transerainc.aha.gen.agent.AgentListDocument.AgentList;

/**
 * @author rajeev.lochanam
 */
@Component
public class AgentCommandFactory {
    private static Logger LOGGER = LoggerFactory.getLogger(AgentCommandFactory.class.getName());

    @Autowired
    private AgentCommand agentCommand;

    @Autowired
    private AuthenticationStatusCommand authenticationStatusCommand;

    @Autowired
    private DesktopConfigurationCommand desktopConfigurationCommand;

    @Autowired
    private XbeanHelper xbeanHelper;

    /**
     * @param tacgResp
     * @return
     * @throws InterpretationException
     * @throws JSONException
     */
    protected AdaResponse getCommand(final TacgResponse tacgResp) throws InterpretationException, JSONException {
        final String agentSessionId = tacgResp.getAgentSessionId();

        long startTime = 0;
        if (LOGGER.isDebugEnabled()) {
            startTime = System.currentTimeMillis();
            LOGGER.debug(agentSessionId + "===>> Starting create agent list command : " + startTime);
        }

        AdaResponse adaResponse = null;
        final AgentList agentList = xbeanHelper.parseAgentListXml(tacgResp.getXml(), agentSessionId);

        tacgResp.setAgentList(agentList);

        if (agentList.getDesktopConfiguration() != null) {
            adaResponse = desktopConfigurationCommand.processData(tacgResp);
        } else if (agentList.getAuthenticateStatus() != null) {
            adaResponse = authenticationStatusCommand.processData(tacgResp);
        } else if (agentList.getAgentArray() != null && agentList.getAgentArray().length > 0) {
            adaResponse = agentCommand.processData(tacgResp);
        } else if (agentList.getMessageArray() != null && agentList.getMessageArray().length > 0) {
            // return new MessageCommand(childElem);
        } else if (agentList.getAgentProfileXmlData() != null) {
            // return new AgentProfileCommand(childElem);
        } else {
            throw new InterpretationException("No valid elements to interpret");
        }

        return adaResponse;
    }
}
