/*
 * An XML document type.
 * Localname: agent-command
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.AgentCommandDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent;


/**
 * A document containing one agent-command(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public interface AgentCommandDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AgentCommandDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("agentcommandf36cdoctype");
    
    /**
     * Gets the "agent-command" element
     */
    com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand getAgentCommand();
    
    /**
     * Sets the "agent-command" element
     */
    void setAgentCommand(com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand agentCommand);
    
    /**
     * Appends and returns a new empty "agent-command" element
     */
    com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand addNewAgentCommand();
    
    /**
     * An XML agent-command(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public interface AgentCommand extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AgentCommand.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("agentcommand0bddelemtype");
        
        /**
         * Gets the "commandMessage" element
         */
        com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage getCommandMessage();
        
        /**
         * True if has "commandMessage" element
         */
        boolean isSetCommandMessage();
        
        /**
         * Sets the "commandMessage" element
         */
        void setCommandMessage(com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage commandMessage);
        
        /**
         * Appends and returns a new empty "commandMessage" element
         */
        com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage addNewCommandMessage();
        
        /**
         * Unsets the "commandMessage" element
         */
        void unsetCommandMessage();
        
        /**
         * Gets array of all "param" elements
         */
        com.transerainc.aha.gen.agent.ParamDocument.Param[] getParamArray();
        
        /**
         * Gets ith "param" element
         */
        com.transerainc.aha.gen.agent.ParamDocument.Param getParamArray(int i);
        
        /**
         * Returns number of "param" element
         */
        int sizeOfParamArray();
        
        /**
         * Sets array of all "param" element
         */
        void setParamArray(com.transerainc.aha.gen.agent.ParamDocument.Param[] paramArray);
        
        /**
         * Sets ith "param" element
         */
        void setParamArray(int i, com.transerainc.aha.gen.agent.ParamDocument.Param param);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "param" element
         */
        com.transerainc.aha.gen.agent.ParamDocument.Param insertNewParam(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "param" element
         */
        com.transerainc.aha.gen.agent.ParamDocument.Param addNewParam();
        
        /**
         * Removes the ith "param" element
         */
        void removeParam(int i);
        
        /**
         * Gets the "virtualTeamList" element
         */
        com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList getVirtualTeamList();
        
        /**
         * True if has "virtualTeamList" element
         */
        boolean isSetVirtualTeamList();
        
        /**
         * Sets the "virtualTeamList" element
         */
        void setVirtualTeamList(com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList virtualTeamList);
        
        /**
         * Appends and returns a new empty "virtualTeamList" element
         */
        com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList addNewVirtualTeamList();
        
        /**
         * Unsets the "virtualTeamList" element
         */
        void unsetVirtualTeamList();
        
        /**
         * Gets the "channel-set" element
         */
        com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet getChannelSet();
        
        /**
         * True if has "channel-set" element
         */
        boolean isSetChannelSet();
        
        /**
         * Sets the "channel-set" element
         */
        void setChannelSet(com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet channelSet);
        
        /**
         * Appends and returns a new empty "channel-set" element
         */
        com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet addNewChannelSet();
        
        /**
         * Unsets the "channel-set" element
         */
        void unsetChannelSet();
        
        /**
         * Gets the "skill-set" element
         */
        com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet getSkillSet();
        
        /**
         * True if has "skill-set" element
         */
        boolean isSetSkillSet();
        
        /**
         * Sets the "skill-set" element
         */
        void setSkillSet(com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet skillSet);
        
        /**
         * Appends and returns a new empty "skill-set" element
         */
        com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet addNewSkillSet();
        
        /**
         * Unsets the "skill-set" element
         */
        void unsetSkillSet();
        
        /**
         * Gets the "name" attribute
         */
        java.lang.String getName();
        
        /**
         * Gets (as xml) the "name" attribute
         */
        org.apache.xmlbeans.XmlString xgetName();
        
        /**
         * Sets the "name" attribute
         */
        void setName(java.lang.String name);
        
        /**
         * Sets (as xml) the "name" attribute
         */
        void xsetName(org.apache.xmlbeans.XmlString name);
        
        /**
         * Gets the "callId" attribute
         */
        java.lang.String getCallId();
        
        /**
         * Gets (as xml) the "callId" attribute
         */
        org.apache.xmlbeans.XmlString xgetCallId();
        
        /**
         * True if has "callId" attribute
         */
        boolean isSetCallId();
        
        /**
         * Sets the "callId" attribute
         */
        void setCallId(java.lang.String callId);
        
        /**
         * Sets (as xml) the "callId" attribute
         */
        void xsetCallId(org.apache.xmlbeans.XmlString callId);
        
        /**
         * Unsets the "callId" attribute
         */
        void unsetCallId();
        
        /**
         * Gets the "status" attribute
         */
        java.lang.String getStatus();
        
        /**
         * Gets (as xml) the "status" attribute
         */
        org.apache.xmlbeans.XmlString xgetStatus();
        
        /**
         * True if has "status" attribute
         */
        boolean isSetStatus();
        
        /**
         * Sets the "status" attribute
         */
        void setStatus(java.lang.String status);
        
        /**
         * Sets (as xml) the "status" attribute
         */
        void xsetStatus(org.apache.xmlbeans.XmlString status);
        
        /**
         * Unsets the "status" attribute
         */
        void unsetStatus();
        
        /**
         * Gets the "subStatus" attribute
         */
        java.lang.String getSubStatus();
        
        /**
         * Gets (as xml) the "subStatus" attribute
         */
        org.apache.xmlbeans.XmlString xgetSubStatus();
        
        /**
         * True if has "subStatus" attribute
         */
        boolean isSetSubStatus();
        
        /**
         * Sets the "subStatus" attribute
         */
        void setSubStatus(java.lang.String subStatus);
        
        /**
         * Sets (as xml) the "subStatus" attribute
         */
        void xsetSubStatus(org.apache.xmlbeans.XmlString subStatus);
        
        /**
         * Unsets the "subStatus" attribute
         */
        void unsetSubStatus();
        
        /**
         * Gets the "agentId" attribute
         */
        java.lang.String getAgentId();
        
        /**
         * Gets (as xml) the "agentId" attribute
         */
        org.apache.xmlbeans.XmlString xgetAgentId();
        
        /**
         * True if has "agentId" attribute
         */
        boolean isSetAgentId();
        
        /**
         * Sets the "agentId" attribute
         */
        void setAgentId(java.lang.String agentId);
        
        /**
         * Sets (as xml) the "agentId" attribute
         */
        void xsetAgentId(org.apache.xmlbeans.XmlString agentId);
        
        /**
         * Unsets the "agentId" attribute
         */
        void unsetAgentId();
        
        /**
         * Gets the "teamId" attribute
         */
        java.lang.String getTeamId();
        
        /**
         * Gets (as xml) the "teamId" attribute
         */
        org.apache.xmlbeans.XmlString xgetTeamId();
        
        /**
         * True if has "teamId" attribute
         */
        boolean isSetTeamId();
        
        /**
         * Sets the "teamId" attribute
         */
        void setTeamId(java.lang.String teamId);
        
        /**
         * Sets (as xml) the "teamId" attribute
         */
        void xsetTeamId(org.apache.xmlbeans.XmlString teamId);
        
        /**
         * Unsets the "teamId" attribute
         */
        void unsetTeamId();
        
        /**
         * Gets the "siteId" attribute
         */
        java.lang.String getSiteId();
        
        /**
         * Gets (as xml) the "siteId" attribute
         */
        org.apache.xmlbeans.XmlString xgetSiteId();
        
        /**
         * True if has "siteId" attribute
         */
        boolean isSetSiteId();
        
        /**
         * Sets the "siteId" attribute
         */
        void setSiteId(java.lang.String siteId);
        
        /**
         * Sets (as xml) the "siteId" attribute
         */
        void xsetSiteId(org.apache.xmlbeans.XmlString siteId);
        
        /**
         * Unsets the "siteId" attribute
         */
        void unsetSiteId();
        
        /**
         * Gets the "timestamp" attribute
         */
        long getTimestamp();
        
        /**
         * Gets (as xml) the "timestamp" attribute
         */
        org.apache.xmlbeans.XmlLong xgetTimestamp();
        
        /**
         * Sets the "timestamp" attribute
         */
        void setTimestamp(long timestamp);
        
        /**
         * Sets (as xml) the "timestamp" attribute
         */
        void xsetTimestamp(org.apache.xmlbeans.XmlLong timestamp);
        
        /**
         * Gets the "virtualTeamId" attribute
         */
        java.lang.String getVirtualTeamId();
        
        /**
         * Gets (as xml) the "virtualTeamId" attribute
         */
        org.apache.xmlbeans.XmlString xgetVirtualTeamId();
        
        /**
         * True if has "virtualTeamId" attribute
         */
        boolean isSetVirtualTeamId();
        
        /**
         * Sets the "virtualTeamId" attribute
         */
        void setVirtualTeamId(java.lang.String virtualTeamId);
        
        /**
         * Sets (as xml) the "virtualTeamId" attribute
         */
        void xsetVirtualTeamId(org.apache.xmlbeans.XmlString virtualTeamId);
        
        /**
         * Unsets the "virtualTeamId" attribute
         */
        void unsetVirtualTeamId();
        
        /**
         * Gets the "code" attribute
         */
        int getCode();
        
        /**
         * Gets (as xml) the "code" attribute
         */
        org.apache.xmlbeans.XmlInt xgetCode();
        
        /**
         * True if has "code" attribute
         */
        boolean isSetCode();
        
        /**
         * Sets the "code" attribute
         */
        void setCode(int code);
        
        /**
         * Sets (as xml) the "code" attribute
         */
        void xsetCode(org.apache.xmlbeans.XmlInt code);
        
        /**
         * Unsets the "code" attribute
         */
        void unsetCode();
        
        /**
         * Gets the "reason" attribute
         */
        java.lang.String getReason();
        
        /**
         * Gets (as xml) the "reason" attribute
         */
        org.apache.xmlbeans.XmlString xgetReason();
        
        /**
         * True if has "reason" attribute
         */
        boolean isSetReason();
        
        /**
         * Sets the "reason" attribute
         */
        void setReason(java.lang.String reason);
        
        /**
         * Sets (as xml) the "reason" attribute
         */
        void xsetReason(org.apache.xmlbeans.XmlString reason);
        
        /**
         * Unsets the "reason" attribute
         */
        void unsetReason();
        
        /**
         * Gets the "transferEnabled" attribute
         */
        boolean getTransferEnabled();
        
        /**
         * Gets (as xml) the "transferEnabled" attribute
         */
        org.apache.xmlbeans.XmlBoolean xgetTransferEnabled();
        
        /**
         * True if has "transferEnabled" attribute
         */
        boolean isSetTransferEnabled();
        
        /**
         * Sets the "transferEnabled" attribute
         */
        void setTransferEnabled(boolean transferEnabled);
        
        /**
         * Sets (as xml) the "transferEnabled" attribute
         */
        void xsetTransferEnabled(org.apache.xmlbeans.XmlBoolean transferEnabled);
        
        /**
         * Unsets the "transferEnabled" attribute
         */
        void unsetTransferEnabled();
        
        /**
         * Gets the "peerAgentId" attribute
         */
        java.lang.String getPeerAgentId();
        
        /**
         * Gets (as xml) the "peerAgentId" attribute
         */
        org.apache.xmlbeans.XmlString xgetPeerAgentId();
        
        /**
         * True if has "peerAgentId" attribute
         */
        boolean isSetPeerAgentId();
        
        /**
         * Sets the "peerAgentId" attribute
         */
        void setPeerAgentId(java.lang.String peerAgentId);
        
        /**
         * Sets (as xml) the "peerAgentId" attribute
         */
        void xsetPeerAgentId(org.apache.xmlbeans.XmlString peerAgentId);
        
        /**
         * Unsets the "peerAgentId" attribute
         */
        void unsetPeerAgentId();
        
        /**
         * Gets the "peerTeamId" attribute
         */
        java.lang.String getPeerTeamId();
        
        /**
         * Gets (as xml) the "peerTeamId" attribute
         */
        org.apache.xmlbeans.XmlString xgetPeerTeamId();
        
        /**
         * True if has "peerTeamId" attribute
         */
        boolean isSetPeerTeamId();
        
        /**
         * Sets the "peerTeamId" attribute
         */
        void setPeerTeamId(java.lang.String peerTeamId);
        
        /**
         * Sets (as xml) the "peerTeamId" attribute
         */
        void xsetPeerTeamId(org.apache.xmlbeans.XmlString peerTeamId);
        
        /**
         * Unsets the "peerTeamId" attribute
         */
        void unsetPeerTeamId();
        
        /**
         * Gets the "peerSiteId" attribute
         */
        java.lang.String getPeerSiteId();
        
        /**
         * Gets (as xml) the "peerSiteId" attribute
         */
        org.apache.xmlbeans.XmlString xgetPeerSiteId();
        
        /**
         * True if has "peerSiteId" attribute
         */
        boolean isSetPeerSiteId();
        
        /**
         * Sets the "peerSiteId" attribute
         */
        void setPeerSiteId(java.lang.String peerSiteId);
        
        /**
         * Sets (as xml) the "peerSiteId" attribute
         */
        void xsetPeerSiteId(org.apache.xmlbeans.XmlString peerSiteId);
        
        /**
         * Unsets the "peerSiteId" attribute
         */
        void unsetPeerSiteId();
        
        /**
         * Gets the "peerDn" attribute
         */
        java.lang.String getPeerDn();
        
        /**
         * Gets (as xml) the "peerDn" attribute
         */
        org.apache.xmlbeans.XmlString xgetPeerDn();
        
        /**
         * True if has "peerDn" attribute
         */
        boolean isSetPeerDn();
        
        /**
         * Sets the "peerDn" attribute
         */
        void setPeerDn(java.lang.String peerDn);
        
        /**
         * Sets (as xml) the "peerDn" attribute
         */
        void xsetPeerDn(org.apache.xmlbeans.XmlString peerDn);
        
        /**
         * Unsets the "peerDn" attribute
         */
        void unsetPeerDn();
        
        /**
         * Gets the "agentsessionid" attribute
         */
        java.lang.String getAgentsessionid();
        
        /**
         * Gets (as xml) the "agentsessionid" attribute
         */
        org.apache.xmlbeans.XmlString xgetAgentsessionid();
        
        /**
         * True if has "agentsessionid" attribute
         */
        boolean isSetAgentsessionid();
        
        /**
         * Sets the "agentsessionid" attribute
         */
        void setAgentsessionid(java.lang.String agentsessionid);
        
        /**
         * Sets (as xml) the "agentsessionid" attribute
         */
        void xsetAgentsessionid(org.apache.xmlbeans.XmlString agentsessionid);
        
        /**
         * Unsets the "agentsessionid" attribute
         */
        void unsetAgentsessionid();
        
        /**
         * Gets the "peerAgentSessionId" attribute
         */
        java.lang.String getPeerAgentSessionId();
        
        /**
         * Gets (as xml) the "peerAgentSessionId" attribute
         */
        org.apache.xmlbeans.XmlString xgetPeerAgentSessionId();
        
        /**
         * True if has "peerAgentSessionId" attribute
         */
        boolean isSetPeerAgentSessionId();
        
        /**
         * Sets the "peerAgentSessionId" attribute
         */
        void setPeerAgentSessionId(java.lang.String peerAgentSessionId);
        
        /**
         * Sets (as xml) the "peerAgentSessionId" attribute
         */
        void xsetPeerAgentSessionId(org.apache.xmlbeans.XmlString peerAgentSessionId);
        
        /**
         * Unsets the "peerAgentSessionId" attribute
         */
        void unsetPeerAgentSessionId();
        
        /**
         * Gets the "aepUrl" attribute
         */
        java.lang.String getAepUrl();
        
        /**
         * Gets (as xml) the "aepUrl" attribute
         */
        org.apache.xmlbeans.XmlAnyURI xgetAepUrl();
        
        /**
         * True if has "aepUrl" attribute
         */
        boolean isSetAepUrl();
        
        /**
         * Sets the "aepUrl" attribute
         */
        void setAepUrl(java.lang.String aepUrl);
        
        /**
         * Sets (as xml) the "aepUrl" attribute
         */
        void xsetAepUrl(org.apache.xmlbeans.XmlAnyURI aepUrl);
        
        /**
         * Unsets the "aepUrl" attribute
         */
        void unsetAepUrl();
        
        /**
         * Gets the "peerAgentName" attribute
         */
        java.lang.String getPeerAgentName();
        
        /**
         * Gets (as xml) the "peerAgentName" attribute
         */
        org.apache.xmlbeans.XmlString xgetPeerAgentName();
        
        /**
         * True if has "peerAgentName" attribute
         */
        boolean isSetPeerAgentName();
        
        /**
         * Sets the "peerAgentName" attribute
         */
        void setPeerAgentName(java.lang.String peerAgentName);
        
        /**
         * Sets (as xml) the "peerAgentName" attribute
         */
        void xsetPeerAgentName(org.apache.xmlbeans.XmlString peerAgentName);
        
        /**
         * Unsets the "peerAgentName" attribute
         */
        void unsetPeerAgentName();
        
        /**
         * Gets the "callLegId" attribute
         */
        java.lang.String getCallLegId();
        
        /**
         * Gets (as xml) the "callLegId" attribute
         */
        org.apache.xmlbeans.XmlString xgetCallLegId();
        
        /**
         * True if has "callLegId" attribute
         */
        boolean isSetCallLegId();
        
        /**
         * Sets the "callLegId" attribute
         */
        void setCallLegId(java.lang.String callLegId);
        
        /**
         * Sets (as xml) the "callLegId" attribute
         */
        void xsetCallLegId(org.apache.xmlbeans.XmlString callLegId);
        
        /**
         * Unsets the "callLegId" attribute
         */
        void unsetCallLegId();
        
        /**
         * Gets the "agentDn" attribute
         */
        java.lang.String getAgentDn();
        
        /**
         * Gets (as xml) the "agentDn" attribute
         */
        org.apache.xmlbeans.XmlString xgetAgentDn();
        
        /**
         * True if has "agentDn" attribute
         */
        boolean isSetAgentDn();
        
        /**
         * Sets the "agentDn" attribute
         */
        void setAgentDn(java.lang.String agentDn);
        
        /**
         * Sets (as xml) the "agentDn" attribute
         */
        void xsetAgentDn(org.apache.xmlbeans.XmlString agentDn);
        
        /**
         * Unsets the "agentDn" attribute
         */
        void unsetAgentDn();
        
        /**
         * Gets the "enterpriseId" attribute
         */
        java.lang.String getEnterpriseId();
        
        /**
         * Gets (as xml) the "enterpriseId" attribute
         */
        org.apache.xmlbeans.XmlString xgetEnterpriseId();
        
        /**
         * True if has "enterpriseId" attribute
         */
        boolean isSetEnterpriseId();
        
        /**
         * Sets the "enterpriseId" attribute
         */
        void setEnterpriseId(java.lang.String enterpriseId);
        
        /**
         * Sets (as xml) the "enterpriseId" attribute
         */
        void xsetEnterpriseId(org.apache.xmlbeans.XmlString enterpriseId);
        
        /**
         * Unsets the "enterpriseId" attribute
         */
        void unsetEnterpriseId();
        
        /**
         * Gets the "ahaUrl" attribute
         */
        java.lang.String getAhaUrl();
        
        /**
         * Gets (as xml) the "ahaUrl" attribute
         */
        org.apache.xmlbeans.XmlAnyURI xgetAhaUrl();
        
        /**
         * True if has "ahaUrl" attribute
         */
        boolean isSetAhaUrl();
        
        /**
         * Sets the "ahaUrl" attribute
         */
        void setAhaUrl(java.lang.String ahaUrl);
        
        /**
         * Sets (as xml) the "ahaUrl" attribute
         */
        void xsetAhaUrl(org.apache.xmlbeans.XmlAnyURI ahaUrl);
        
        /**
         * Unsets the "ahaUrl" attribute
         */
        void unsetAhaUrl();
        
        /**
         * Gets the "consultCallId" attribute
         */
        java.lang.String getConsultCallId();
        
        /**
         * Gets (as xml) the "consultCallId" attribute
         */
        org.apache.xmlbeans.XmlString xgetConsultCallId();
        
        /**
         * True if has "consultCallId" attribute
         */
        boolean isSetConsultCallId();
        
        /**
         * Sets the "consultCallId" attribute
         */
        void setConsultCallId(java.lang.String consultCallId);
        
        /**
         * Sets (as xml) the "consultCallId" attribute
         */
        void xsetConsultCallId(org.apache.xmlbeans.XmlString consultCallId);
        
        /**
         * Unsets the "consultCallId" attribute
         */
        void unsetConsultCallId();
        
        /**
         * Gets the "enablePauseResume" attribute
         */
        boolean getEnablePauseResume();
        
        /**
         * Gets (as xml) the "enablePauseResume" attribute
         */
        org.apache.xmlbeans.XmlBoolean xgetEnablePauseResume();
        
        /**
         * True if has "enablePauseResume" attribute
         */
        boolean isSetEnablePauseResume();
        
        /**
         * Sets the "enablePauseResume" attribute
         */
        void setEnablePauseResume(boolean enablePauseResume);
        
        /**
         * Sets (as xml) the "enablePauseResume" attribute
         */
        void xsetEnablePauseResume(org.apache.xmlbeans.XmlBoolean enablePauseResume);
        
        /**
         * Unsets the "enablePauseResume" attribute
         */
        void unsetEnablePauseResume();
        
        /**
         * Gets the "pauseDuration" attribute
         */
        int getPauseDuration();
        
        /**
         * Gets (as xml) the "pauseDuration" attribute
         */
        org.apache.xmlbeans.XmlInt xgetPauseDuration();
        
        /**
         * True if has "pauseDuration" attribute
         */
        boolean isSetPauseDuration();
        
        /**
         * Sets the "pauseDuration" attribute
         */
        void setPauseDuration(int pauseDuration);
        
        /**
         * Sets (as xml) the "pauseDuration" attribute
         */
        void xsetPauseDuration(org.apache.xmlbeans.XmlInt pauseDuration);
        
        /**
         * Unsets the "pauseDuration" attribute
         */
        void unsetPauseDuration();
        
        /**
         * Gets the "channelId" attribute
         */
        java.lang.String getChannelId();
        
        /**
         * Gets (as xml) the "channelId" attribute
         */
        org.apache.xmlbeans.XmlString xgetChannelId();
        
        /**
         * True if has "channelId" attribute
         */
        boolean isSetChannelId();
        
        /**
         * Sets the "channelId" attribute
         */
        void setChannelId(java.lang.String channelId);
        
        /**
         * Sets (as xml) the "channelId" attribute
         */
        void xsetChannelId(org.apache.xmlbeans.XmlString channelId);
        
        /**
         * Unsets the "channelId" attribute
         */
        void unsetChannelId();
        
        /**
         * Gets the "channelType" attribute
         */
        com.transerainc.aha.gen.agent.ChannelTypes.Enum getChannelType();
        
        /**
         * Gets (as xml) the "channelType" attribute
         */
        com.transerainc.aha.gen.agent.ChannelTypes xgetChannelType();
        
        /**
         * True if has "channelType" attribute
         */
        boolean isSetChannelType();
        
        /**
         * Sets the "channelType" attribute
         */
        void setChannelType(com.transerainc.aha.gen.agent.ChannelTypes.Enum channelType);
        
        /**
         * Sets (as xml) the "channelType" attribute
         */
        void xsetChannelType(com.transerainc.aha.gen.agent.ChannelTypes channelType);
        
        /**
         * Unsets the "channelType" attribute
         */
        void unsetChannelType();
        
        /**
         * Gets the "peerChannelId" attribute
         */
        java.lang.String getPeerChannelId();
        
        /**
         * Gets (as xml) the "peerChannelId" attribute
         */
        org.apache.xmlbeans.XmlString xgetPeerChannelId();
        
        /**
         * True if has "peerChannelId" attribute
         */
        boolean isSetPeerChannelId();
        
        /**
         * Sets the "peerChannelId" attribute
         */
        void setPeerChannelId(java.lang.String peerChannelId);
        
        /**
         * Sets (as xml) the "peerChannelId" attribute
         */
        void xsetPeerChannelId(org.apache.xmlbeans.XmlString peerChannelId);
        
        /**
         * Unsets the "peerChannelId" attribute
         */
        void unsetPeerChannelId();
        
        /**
         * Gets the "peerChannelType" attribute
         */
        java.lang.String getPeerChannelType();
        
        /**
         * Gets (as xml) the "peerChannelType" attribute
         */
        org.apache.xmlbeans.XmlString xgetPeerChannelType();
        
        /**
         * True if has "peerChannelType" attribute
         */
        boolean isSetPeerChannelType();
        
        /**
         * Sets the "peerChannelType" attribute
         */
        void setPeerChannelType(java.lang.String peerChannelType);
        
        /**
         * Sets (as xml) the "peerChannelType" attribute
         */
        void xsetPeerChannelType(org.apache.xmlbeans.XmlString peerChannelType);
        
        /**
         * Unsets the "peerChannelType" attribute
         */
        void unsetPeerChannelType();
        
        /**
         * Gets the "destinationVirtualTeamId" attribute
         */
        java.lang.String getDestinationVirtualTeamId();
        
        /**
         * Gets (as xml) the "destinationVirtualTeamId" attribute
         */
        org.apache.xmlbeans.XmlString xgetDestinationVirtualTeamId();
        
        /**
         * True if has "destinationVirtualTeamId" attribute
         */
        boolean isSetDestinationVirtualTeamId();
        
        /**
         * Sets the "destinationVirtualTeamId" attribute
         */
        void setDestinationVirtualTeamId(java.lang.String destinationVirtualTeamId);
        
        /**
         * Sets (as xml) the "destinationVirtualTeamId" attribute
         */
        void xsetDestinationVirtualTeamId(org.apache.xmlbeans.XmlString destinationVirtualTeamId);
        
        /**
         * Unsets the "destinationVirtualTeamId" attribute
         */
        void unsetDestinationVirtualTeamId();
        
        /**
         * Gets the "source" attribute
         */
        java.lang.String getSource();
        
        /**
         * Gets (as xml) the "source" attribute
         */
        org.apache.xmlbeans.XmlString xgetSource();
        
        /**
         * True if has "source" attribute
         */
        boolean isSetSource();
        
        /**
         * Sets the "source" attribute
         */
        void setSource(java.lang.String source);
        
        /**
         * Sets (as xml) the "source" attribute
         */
        void xsetSource(org.apache.xmlbeans.XmlString source);
        
        /**
         * Unsets the "source" attribute
         */
        void unsetSource();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand newInstance() {
              return (com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.transerainc.aha.gen.agent.AgentCommandDocument newInstance() {
          return (com.transerainc.aha.gen.agent.AgentCommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.aha.gen.agent.AgentCommandDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.aha.gen.agent.AgentCommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.aha.gen.agent.AgentCommandDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AgentCommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AgentCommandDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AgentCommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.aha.gen.agent.AgentCommandDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AgentCommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AgentCommandDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AgentCommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AgentCommandDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AgentCommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AgentCommandDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AgentCommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AgentCommandDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AgentCommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AgentCommandDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AgentCommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AgentCommandDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AgentCommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AgentCommandDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AgentCommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AgentCommandDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AgentCommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AgentCommandDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AgentCommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AgentCommandDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AgentCommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AgentCommandDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AgentCommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.AgentCommandDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.AgentCommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.AgentCommandDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.AgentCommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
