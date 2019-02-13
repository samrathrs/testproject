/**
 * 
 */
package com.transerainc.adaws.model;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import com.transerainc.agent.profile.AgentProfileDocument.AgentProfile;
import com.transerainc.agent.profile.ChannelSetDocument.ChannelSet;
import com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand;
import com.transerainc.aha.gen.agent.AgentListDocument.AgentList;
import com.transerainc.aha.gen.agent.ResponseDocument.Response;
import com.transerainc.aha.gen.agent.XPathQueryResultDocument.XPathQueryResult;

/**
 * @author rajeev.lochanam
 */
public class TacgResponse {
    private String xml;
    private String error;
    private Element element;
    private String logoutReason;
    private String agentSessionId;
    private NamedNodeMap attributes;
    private boolean holdFalg = false;
    private String errorMessage;
    private String errorCode;
    private AgentCommand agentCommand;
    private AgentList agentList;
    private XPathQueryResult xpathQueryResult;
    private AgentProfile agentProfile;
    private ChannelSet channelSet;
    private Response response;

    public TacgResponse(final String agentSessionId, final String xml) {
        this.agentSessionId = agentSessionId;
        this.xml = xml;
    }

    /**
     * @return the xml
     */
    public String getXml() {
        return xml;
    }

    /**
     * @param xml
     *            the xml to set
     */
    public void setXml(final String xml) {
        this.xml = xml;
    }

    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error
     *            the error to set
     */
    public void setError(final String error) {
        this.error = error;
    }

    /**
     * @return the element
     */
    public Element getElement() {
        return element;
    }

    /**
     * @param element
     *            the element to set
     */
    public void setElement(final Element element) {
        this.element = element;
    }

    /**
     * @return the holdFalg
     */
    public boolean isHoldFalg() {
        return holdFalg;
    }

    /**
     * @param holdFalg
     *            the holdFalg to set
     */
    public void setHoldFalg(final boolean holdFalg) {
        this.holdFalg = holdFalg;
    }

    /**
     * @return the attributes
     */
    public NamedNodeMap getAttributes() {
        return attributes;
    }

    /**
     * @param attributes
     *            the attributes to set
     */
    public void setAttributes(final NamedNodeMap attributes) {
        this.attributes = attributes;
    }

    /**
     * @return the agentSessionId
     */
    public String getAgentSessionId() {
        return agentSessionId;
    }

    /**
     * @param agentSessionId
     *            the agentSessionId to set
     */
    public void setAgentSessionId(final String agentSessionId) {
        this.agentSessionId = agentSessionId;
    }

    /**
     * @return the logoutReason
     */
    public String getLogoutReason() {
        return logoutReason;
    }

    /**
     * @param logoutReason
     *            the logoutReason to set
     */
    public void setLogoutReason(final String logoutReason) {
        this.logoutReason = logoutReason;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage
     *            the errorMessage to set
     */
    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode
     *            the errorCode to set
     */
    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return the agentCommand
     */
    public AgentCommand getAgentCommand() {
        return agentCommand;
    }

    /**
     * @param agentCommand
     *            the agentCommand to set
     */
    public void setAgentCommand(final AgentCommand agentCommand) {
        this.agentCommand = agentCommand;
    }

    /**
     * @return the agentList
     */
    public AgentList getAgentList() {
        return agentList;
    }

    /**
     * @param agentList
     *            the agentList to set
     */
    public void setAgentList(final AgentList agentList) {
        this.agentList = agentList;
    }

    /**
     * @return the xpathQueryResult
     */
    public XPathQueryResult getXpathQueryResult() {
        return xpathQueryResult;
    }

    /**
     * @param xpathQueryResult
     *            the xpathQueryResult to set
     */
    public void setXpathQueryResult(final XPathQueryResult xpathQueryResult) {
        this.xpathQueryResult = xpathQueryResult;
    }

    /**
     * @return the agentProfile
     */
    public AgentProfile getAgentProfile() {
        return agentProfile;
    }

    /**
     * @param agentProfile
     *            the agentProfile to set
     */
    public void setAgentProfile(final AgentProfile agentProfile) {
        this.agentProfile = agentProfile;
    }

    /**
     * @return the channelSet
     */
    public ChannelSet getChannelSet() {
        return channelSet;
    }

    /**
     * @param channelSet
     *            the channelSet to set
     */
    public void setChannelSet(final ChannelSet channelSet) {
        this.channelSet = channelSet;
    }

    /**
     * @return the response
     */
    public Response getResponse() {
        return response;
    }

    /**
     * @param response
     *            the response to set
     */
    public void setResponse(final Response response) {
        this.response = response;
    }

}
