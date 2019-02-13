/**
 * 
 */
package com.transerainc.adaws.util;

import org.apache.xmlbeans.XmlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.exception.InterpretationException;
import com.transerainc.agent.profile.AgentProfileDocument;
import com.transerainc.agent.profile.AgentProfileDocument.AgentProfile;
import com.transerainc.agent.profile.ChannelSetDocument;
import com.transerainc.agent.profile.ChannelSetDocument.ChannelSet;
import com.transerainc.aha.gen.agent.AgentCommandDocument;
import com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand;
import com.transerainc.aha.gen.agent.AgentListDocument;
import com.transerainc.aha.gen.agent.AgentListDocument.AgentList;
import com.transerainc.aha.gen.agent.ResponseDocument;
import com.transerainc.aha.gen.agent.ResponseDocument.Response;
import com.transerainc.aha.gen.agent.XPathQueryResultDocument;
import com.transerainc.aha.gen.agent.XPathQueryResultDocument.XPathQueryResult;

/**
 * @author varsha.shivaram
 */

@Component
public class XbeanHelper {

    private static Logger LOGGER = LoggerFactory.getLogger(XbeanHelper.class.getName());

    /**
     * @param xml
     * @param agentSessionId
     * @return
     * @throws InterpretationException
     */
    public AgentCommand parseAgentCommandXml(final String xml, final String agentSessionId)
            throws InterpretationException {
        AgentCommand agentCommand = null;
        try {
            final AgentCommandDocument doc = AgentCommandDocument.Factory.parse(xml);
            agentCommand = doc.getAgentCommand();
        } catch (final XmlException e) {
            LOGGER.error(agentSessionId + "Exception occured while parsing agent command xml ", e);
            throw new InterpretationException("Exception occured while parsing agent command xml: " + xml);
        }
        return agentCommand;
    }

    /**
     * @param xml
     * @param agentSessionId
     * @return
     * @throws InterpretationException
     */
    public AgentList parseAgentListXml(final String xml, final String agentSessionId) throws InterpretationException {
        AgentList agentList = null;
        try {
            final AgentListDocument doc = AgentListDocument.Factory.parse(xml);
            agentList = doc.getAgentList();
        } catch (final XmlException e) {
            LOGGER.error(agentSessionId + "Exception occured while parsing agent list xml ", e);
            throw new InterpretationException("Exception occured while parsing agent list xml: " + xml);
        }
        return agentList;
    }

    /**
     * @param xml
     * @param agentSessionId
     * @return
     * @throws InterpretationException
     */
    public XPathQueryResult parseXpathQueryResultXml(final String xml, final String agentSessionId)
            throws InterpretationException {
        XPathQueryResult xpathQueryResult = null;
        try {
            final XPathQueryResultDocument doc = XPathQueryResultDocument.Factory.parse(xml);
            xpathQueryResult = doc.getXPathQueryResult();
        } catch (final XmlException e) {
            LOGGER.error(agentSessionId + "Exception occured while parsing xpath query result xml ", e);
            throw new InterpretationException("Exception occured while parsing xpath query result xml: " + xml);
        }
        return xpathQueryResult;
    }

    /**
     * @param xml
     * @param agentSessionId
     * @return
     * @throws InterpretationException
     */
    public AgentProfile parseAgentProfileXml(final String xml, final String agentSessionId)
            throws InterpretationException {
        AgentProfile agentProfile;
        try {
            final AgentProfileDocument doc = AgentProfileDocument.Factory.parse(xml);
            agentProfile = doc.getAgentProfile();
        } catch (final XmlException e) {
            LOGGER.error(agentSessionId + "Exception occured while parsing agent profile xml ", e);
            throw new InterpretationException("Exception occured while parsing agent profile xml: " + xml);
        }
        return agentProfile;
    }

    /**
     * @param xml
     * @param agentSessionId
     * @return
     */
    public ChannelSet parseChannelSetXml(final String xml, final String agentSessionId) throws InterpretationException {
        ChannelSet channelSet;
        try {
            final ChannelSetDocument doc = ChannelSetDocument.Factory.parse(xml);
            channelSet = doc.getChannelSet();
        } catch (final XmlException e) {
            LOGGER.error(agentSessionId + "Exception occured while parsing channel set xml ", e);
            throw new InterpretationException("Exception occured while parsing channel set xml: " + xml);
        }
        return channelSet;
    }

    /**
     * @param xml
     * @param agentSessionId
     * @return
     */
    public Response parseResponseXml(final String xml, final String agentSessionId) throws InterpretationException {
        Response response;
        try {
            final ResponseDocument doc = ResponseDocument.Factory.parse(xml);
            response = doc.getResponse();
        } catch (final XmlException e) {
            LOGGER.error(agentSessionId + "Exception occured while parsing response xml ", e);
            throw new InterpretationException("Exception occured while parsing response xml: " + xml);
        }
        return response;
    }

}
