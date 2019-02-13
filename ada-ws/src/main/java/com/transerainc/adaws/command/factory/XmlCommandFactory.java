package com.transerainc.adaws.command.factory;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.command.AgentProfileCommand;
import com.transerainc.adaws.command.ChannelSetCommand;
import com.transerainc.adaws.command.ResponseCommand;
import com.transerainc.adaws.command.XpathQueryCommand;
import com.transerainc.adaws.constants.AgentStateConstants;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.exception.InterpretationException;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.TacgResponse;
import com.transerainc.adaws.util.XbeanHelper;
import com.transerainc.agent.profile.AgentProfileDocument.AgentProfile;
import com.transerainc.agent.profile.ChannelSetDocument.ChannelSet;
import com.transerainc.aha.gen.agent.ResponseDocument.Response;
import com.transerainc.aha.gen.agent.XPathQueryResultDocument.XPathQueryResult;

/**
 * @author rajeev.lochanam
 */
@Component
public class XmlCommandFactory implements AgentStateConstants {
    static Logger LOGGER = LoggerFactory.getLogger(XmlCommandFactory.class.getName());

    @Autowired
    private ResponseCommand responseCommand;

    @Autowired
    private XpathQueryCommand queryResBuilder;

    @Autowired
    private ChannelSetCommand channelSetCommand;

    @Autowired
    private AgentProfileCommand agentProfileCommand;

    @Autowired
    private XbeanHelper xbeanHelper;

    /**
     * @param tacgResp
     * @return
     * @throws InterpretationException
     */
    protected AdaResponse getCommand(final TacgResponse tacgResp) throws InterpretationException {
        final String agentSessionId = tacgResp.getAgentSessionId();
        long startTime = 0;

        if (LOGGER.isDebugEnabled()) {
            startTime = System.currentTimeMillis();
            LOGGER.debug(agentSessionId + "===>> Starting create command : " + startTime);
        }

        AdaResponse adaResponse = null;
        try {
            final String rootElemName = tacgResp.getElement().getNodeName();

            switch (rootElemName) {
            case CommandConstants.XPATH_QUERY_RESULT:
                final XPathQueryResult xpathQueryResult = xbeanHelper.parseXpathQueryResultXml(tacgResp.getXml(),
                        agentSessionId);
                tacgResp.setXpathQueryResult(xpathQueryResult);
                adaResponse = queryResBuilder.processData(tacgResp);
                break;
            case CommandConstants.AGENT_PROFILE:
                final AgentProfile agentProfile = xbeanHelper.parseAgentProfileXml(tacgResp.getXml(), agentSessionId);
                tacgResp.setAgentProfile(agentProfile);
                adaResponse = agentProfileCommand.processData(tacgResp.getAgentProfile(), tacgResp.getAgentSessionId(),
                        tacgResp.getXml());
                break;
            case CommandConstants.CHANNEL_SET:
                final ChannelSet channelSet = xbeanHelper.parseChannelSetXml(tacgResp.getXml(), agentSessionId);
                tacgResp.setChannelSet(channelSet);
                adaResponse = channelSetCommand.processData(tacgResp);
                break;
            case CommandConstants.RESPONSE:
                final Response response = xbeanHelper.parseResponseXml(tacgResp.getXml(), agentSessionId);
                tacgResp.setResponse(response);
                adaResponse = responseCommand.processData(tacgResp);
                break;
            case CommandConstants.AGENT_CONTROL_COMMAND:

                // return createAgentControlCommand(docElem);
                break;
            case CommandConstants.NAME_RESOLUTION:

                // return creteNameResolutionCommand(docElem);
                break;
            default:
                LOGGER.warn(agentSessionId + "Unexpected root element: " + rootElemName);
                throw new InterpretationException("Unexpected root element: " + rootElemName);
            }
        } catch (JSONException e) {
            LOGGER.info("{} exception occured converting xml to json {} ", agentSessionId, e);
            LOGGER.info("{} xml received {} ", agentSessionId, tacgResp.getXml());
            throw new InterpretationException("Cannot interpret xml: " + tacgResp.getXml(), e);
        }

        if (LOGGER.isDebugEnabled()) {
            final long endTime = System.currentTimeMillis() - startTime;
            LOGGER.debug(agentSessionId + "===>> Finished create command : " + endTime);
        }

        return adaResponse;
    }
}
