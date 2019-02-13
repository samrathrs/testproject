/*
 * An XML document type.
 * Localname: agent-command
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.AgentCommandDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one agent-command(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class AgentCommandDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AgentCommandDocument
{
    private static final long serialVersionUID = 1L;
    
    public AgentCommandDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AGENTCOMMAND$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "agent-command");
    
    
    /**
     * Gets the "agent-command" element
     */
    public com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand getAgentCommand()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand target = null;
            target = (com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand)get_store().find_element_user(AGENTCOMMAND$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "agent-command" element
     */
    public void setAgentCommand(com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand agentCommand)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand target = null;
            target = (com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand)get_store().find_element_user(AGENTCOMMAND$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand)get_store().add_element_user(AGENTCOMMAND$0);
            }
            target.set(agentCommand);
        }
    }
    
    /**
     * Appends and returns a new empty "agent-command" element
     */
    public com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand addNewAgentCommand()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand target = null;
            target = (com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand)get_store().add_element_user(AGENTCOMMAND$0);
            return target;
        }
    }
    /**
     * An XML agent-command(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class AgentCommandImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand
    {
        private static final long serialVersionUID = 1L;
        
        public AgentCommandImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName COMMANDMESSAGE$0 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "commandMessage");
        private static final javax.xml.namespace.QName PARAM$2 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "param");
        private static final javax.xml.namespace.QName VIRTUALTEAMLIST$4 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "virtualTeamList");
        private static final javax.xml.namespace.QName CHANNELSET$6 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "channel-set");
        private static final javax.xml.namespace.QName SKILLSET$8 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "skill-set");
        private static final javax.xml.namespace.QName NAME$10 = 
            new javax.xml.namespace.QName("", "name");
        private static final javax.xml.namespace.QName CALLID$12 = 
            new javax.xml.namespace.QName("", "callId");
        private static final javax.xml.namespace.QName STATUS$14 = 
            new javax.xml.namespace.QName("", "status");
        private static final javax.xml.namespace.QName SUBSTATUS$16 = 
            new javax.xml.namespace.QName("", "subStatus");
        private static final javax.xml.namespace.QName AGENTID$18 = 
            new javax.xml.namespace.QName("", "agentId");
        private static final javax.xml.namespace.QName TEAMID$20 = 
            new javax.xml.namespace.QName("", "teamId");
        private static final javax.xml.namespace.QName SITEID$22 = 
            new javax.xml.namespace.QName("", "siteId");
        private static final javax.xml.namespace.QName TIMESTAMP$24 = 
            new javax.xml.namespace.QName("", "timestamp");
        private static final javax.xml.namespace.QName VIRTUALTEAMID$26 = 
            new javax.xml.namespace.QName("", "virtualTeamId");
        private static final javax.xml.namespace.QName CODE$28 = 
            new javax.xml.namespace.QName("", "code");
        private static final javax.xml.namespace.QName REASON$30 = 
            new javax.xml.namespace.QName("", "reason");
        private static final javax.xml.namespace.QName TRANSFERENABLED$32 = 
            new javax.xml.namespace.QName("", "transferEnabled");
        private static final javax.xml.namespace.QName PEERAGENTID$34 = 
            new javax.xml.namespace.QName("", "peerAgentId");
        private static final javax.xml.namespace.QName PEERTEAMID$36 = 
            new javax.xml.namespace.QName("", "peerTeamId");
        private static final javax.xml.namespace.QName PEERSITEID$38 = 
            new javax.xml.namespace.QName("", "peerSiteId");
        private static final javax.xml.namespace.QName PEERDN$40 = 
            new javax.xml.namespace.QName("", "peerDn");
        private static final javax.xml.namespace.QName AGENTSESSIONID$42 = 
            new javax.xml.namespace.QName("", "agentsessionid");
        private static final javax.xml.namespace.QName PEERAGENTSESSIONID$44 = 
            new javax.xml.namespace.QName("", "peerAgentSessionId");
        private static final javax.xml.namespace.QName AEPURL$46 = 
            new javax.xml.namespace.QName("", "aepUrl");
        private static final javax.xml.namespace.QName PEERAGENTNAME$48 = 
            new javax.xml.namespace.QName("", "peerAgentName");
        private static final javax.xml.namespace.QName CALLLEGID$50 = 
            new javax.xml.namespace.QName("", "callLegId");
        private static final javax.xml.namespace.QName AGENTDN$52 = 
            new javax.xml.namespace.QName("", "agentDn");
        private static final javax.xml.namespace.QName ENTERPRISEID$54 = 
            new javax.xml.namespace.QName("", "enterpriseId");
        private static final javax.xml.namespace.QName AHAURL$56 = 
            new javax.xml.namespace.QName("", "ahaUrl");
        private static final javax.xml.namespace.QName CONSULTCALLID$58 = 
            new javax.xml.namespace.QName("", "consultCallId");
        private static final javax.xml.namespace.QName ENABLEPAUSERESUME$60 = 
            new javax.xml.namespace.QName("", "enablePauseResume");
        private static final javax.xml.namespace.QName PAUSEDURATION$62 = 
            new javax.xml.namespace.QName("", "pauseDuration");
        private static final javax.xml.namespace.QName CHANNELID$64 = 
            new javax.xml.namespace.QName("", "channelId");
        private static final javax.xml.namespace.QName CHANNELTYPE$66 = 
            new javax.xml.namespace.QName("", "channelType");
        private static final javax.xml.namespace.QName PEERCHANNELID$68 = 
            new javax.xml.namespace.QName("", "peerChannelId");
        private static final javax.xml.namespace.QName PEERCHANNELTYPE$70 = 
            new javax.xml.namespace.QName("", "peerChannelType");
        private static final javax.xml.namespace.QName DESTINATIONVIRTUALTEAMID$72 = 
            new javax.xml.namespace.QName("", "destinationVirtualTeamId");
        private static final javax.xml.namespace.QName SOURCE$74 = 
            new javax.xml.namespace.QName("", "source");
        
        
        /**
         * Gets the "commandMessage" element
         */
        public com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage getCommandMessage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage target = null;
                target = (com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage)get_store().find_element_user(COMMANDMESSAGE$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "commandMessage" element
         */
        public boolean isSetCommandMessage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(COMMANDMESSAGE$0) != 0;
            }
        }
        
        /**
         * Sets the "commandMessage" element
         */
        public void setCommandMessage(com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage commandMessage)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage target = null;
                target = (com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage)get_store().find_element_user(COMMANDMESSAGE$0, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage)get_store().add_element_user(COMMANDMESSAGE$0);
                }
                target.set(commandMessage);
            }
        }
        
        /**
         * Appends and returns a new empty "commandMessage" element
         */
        public com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage addNewCommandMessage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage target = null;
                target = (com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage)get_store().add_element_user(COMMANDMESSAGE$0);
                return target;
            }
        }
        
        /**
         * Unsets the "commandMessage" element
         */
        public void unsetCommandMessage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(COMMANDMESSAGE$0, 0);
            }
        }
        
        /**
         * Gets array of all "param" elements
         */
        public com.transerainc.aha.gen.agent.ParamDocument.Param[] getParamArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(PARAM$2, targetList);
                com.transerainc.aha.gen.agent.ParamDocument.Param[] result = new com.transerainc.aha.gen.agent.ParamDocument.Param[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "param" element
         */
        public com.transerainc.aha.gen.agent.ParamDocument.Param getParamArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ParamDocument.Param target = null;
                target = (com.transerainc.aha.gen.agent.ParamDocument.Param)get_store().find_element_user(PARAM$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "param" element
         */
        public int sizeOfParamArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(PARAM$2);
            }
        }
        
        /**
         * Sets array of all "param" element
         */
        public void setParamArray(com.transerainc.aha.gen.agent.ParamDocument.Param[] paramArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(paramArray, PARAM$2);
            }
        }
        
        /**
         * Sets ith "param" element
         */
        public void setParamArray(int i, com.transerainc.aha.gen.agent.ParamDocument.Param param)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ParamDocument.Param target = null;
                target = (com.transerainc.aha.gen.agent.ParamDocument.Param)get_store().find_element_user(PARAM$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(param);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "param" element
         */
        public com.transerainc.aha.gen.agent.ParamDocument.Param insertNewParam(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ParamDocument.Param target = null;
                target = (com.transerainc.aha.gen.agent.ParamDocument.Param)get_store().insert_element_user(PARAM$2, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "param" element
         */
        public com.transerainc.aha.gen.agent.ParamDocument.Param addNewParam()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ParamDocument.Param target = null;
                target = (com.transerainc.aha.gen.agent.ParamDocument.Param)get_store().add_element_user(PARAM$2);
                return target;
            }
        }
        
        /**
         * Removes the ith "param" element
         */
        public void removeParam(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(PARAM$2, i);
            }
        }
        
        /**
         * Gets the "virtualTeamList" element
         */
        public com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList getVirtualTeamList()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList target = null;
                target = (com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList)get_store().find_element_user(VIRTUALTEAMLIST$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "virtualTeamList" element
         */
        public boolean isSetVirtualTeamList()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(VIRTUALTEAMLIST$4) != 0;
            }
        }
        
        /**
         * Sets the "virtualTeamList" element
         */
        public void setVirtualTeamList(com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList virtualTeamList)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList target = null;
                target = (com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList)get_store().find_element_user(VIRTUALTEAMLIST$4, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList)get_store().add_element_user(VIRTUALTEAMLIST$4);
                }
                target.set(virtualTeamList);
            }
        }
        
        /**
         * Appends and returns a new empty "virtualTeamList" element
         */
        public com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList addNewVirtualTeamList()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList target = null;
                target = (com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList)get_store().add_element_user(VIRTUALTEAMLIST$4);
                return target;
            }
        }
        
        /**
         * Unsets the "virtualTeamList" element
         */
        public void unsetVirtualTeamList()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(VIRTUALTEAMLIST$4, 0);
            }
        }
        
        /**
         * Gets the "channel-set" element
         */
        public com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet getChannelSet()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet target = null;
                target = (com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet)get_store().find_element_user(CHANNELSET$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "channel-set" element
         */
        public boolean isSetChannelSet()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(CHANNELSET$6) != 0;
            }
        }
        
        /**
         * Sets the "channel-set" element
         */
        public void setChannelSet(com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet channelSet)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet target = null;
                target = (com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet)get_store().find_element_user(CHANNELSET$6, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet)get_store().add_element_user(CHANNELSET$6);
                }
                target.set(channelSet);
            }
        }
        
        /**
         * Appends and returns a new empty "channel-set" element
         */
        public com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet addNewChannelSet()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet target = null;
                target = (com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet)get_store().add_element_user(CHANNELSET$6);
                return target;
            }
        }
        
        /**
         * Unsets the "channel-set" element
         */
        public void unsetChannelSet()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(CHANNELSET$6, 0);
            }
        }
        
        /**
         * Gets the "skill-set" element
         */
        public com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet getSkillSet()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet target = null;
                target = (com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet)get_store().find_element_user(SKILLSET$8, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "skill-set" element
         */
        public boolean isSetSkillSet()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(SKILLSET$8) != 0;
            }
        }
        
        /**
         * Sets the "skill-set" element
         */
        public void setSkillSet(com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet skillSet)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet target = null;
                target = (com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet)get_store().find_element_user(SKILLSET$8, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet)get_store().add_element_user(SKILLSET$8);
                }
                target.set(skillSet);
            }
        }
        
        /**
         * Appends and returns a new empty "skill-set" element
         */
        public com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet addNewSkillSet()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet target = null;
                target = (com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet)get_store().add_element_user(SKILLSET$8);
                return target;
            }
        }
        
        /**
         * Unsets the "skill-set" element
         */
        public void unsetSkillSet()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(SKILLSET$8, 0);
            }
        }
        
        /**
         * Gets the "name" attribute
         */
        public java.lang.String getName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$10);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "name" attribute
         */
        public org.apache.xmlbeans.XmlString xgetName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$10);
                return target;
            }
        }
        
        /**
         * Sets the "name" attribute
         */
        public void setName(java.lang.String name)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$10);
                }
                target.setStringValue(name);
            }
        }
        
        /**
         * Sets (as xml) the "name" attribute
         */
        public void xsetName(org.apache.xmlbeans.XmlString name)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAME$10);
                }
                target.set(name);
            }
        }
        
        /**
         * Gets the "callId" attribute
         */
        public java.lang.String getCallId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CALLID$12);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "callId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetCallId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CALLID$12);
                return target;
            }
        }
        
        /**
         * True if has "callId" attribute
         */
        public boolean isSetCallId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(CALLID$12) != null;
            }
        }
        
        /**
         * Sets the "callId" attribute
         */
        public void setCallId(java.lang.String callId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CALLID$12);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CALLID$12);
                }
                target.setStringValue(callId);
            }
        }
        
        /**
         * Sets (as xml) the "callId" attribute
         */
        public void xsetCallId(org.apache.xmlbeans.XmlString callId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CALLID$12);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(CALLID$12);
                }
                target.set(callId);
            }
        }
        
        /**
         * Unsets the "callId" attribute
         */
        public void unsetCallId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(CALLID$12);
            }
        }
        
        /**
         * Gets the "status" attribute
         */
        public java.lang.String getStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STATUS$14);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "status" attribute
         */
        public org.apache.xmlbeans.XmlString xgetStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(STATUS$14);
                return target;
            }
        }
        
        /**
         * True if has "status" attribute
         */
        public boolean isSetStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(STATUS$14) != null;
            }
        }
        
        /**
         * Sets the "status" attribute
         */
        public void setStatus(java.lang.String status)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STATUS$14);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(STATUS$14);
                }
                target.setStringValue(status);
            }
        }
        
        /**
         * Sets (as xml) the "status" attribute
         */
        public void xsetStatus(org.apache.xmlbeans.XmlString status)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(STATUS$14);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(STATUS$14);
                }
                target.set(status);
            }
        }
        
        /**
         * Unsets the "status" attribute
         */
        public void unsetStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(STATUS$14);
            }
        }
        
        /**
         * Gets the "subStatus" attribute
         */
        public java.lang.String getSubStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SUBSTATUS$16);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "subStatus" attribute
         */
        public org.apache.xmlbeans.XmlString xgetSubStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SUBSTATUS$16);
                return target;
            }
        }
        
        /**
         * True if has "subStatus" attribute
         */
        public boolean isSetSubStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(SUBSTATUS$16) != null;
            }
        }
        
        /**
         * Sets the "subStatus" attribute
         */
        public void setSubStatus(java.lang.String subStatus)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SUBSTATUS$16);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SUBSTATUS$16);
                }
                target.setStringValue(subStatus);
            }
        }
        
        /**
         * Sets (as xml) the "subStatus" attribute
         */
        public void xsetSubStatus(org.apache.xmlbeans.XmlString subStatus)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SUBSTATUS$16);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(SUBSTATUS$16);
                }
                target.set(subStatus);
            }
        }
        
        /**
         * Unsets the "subStatus" attribute
         */
        public void unsetSubStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(SUBSTATUS$16);
            }
        }
        
        /**
         * Gets the "agentId" attribute
         */
        public java.lang.String getAgentId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTID$18);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "agentId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetAgentId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTID$18);
                return target;
            }
        }
        
        /**
         * True if has "agentId" attribute
         */
        public boolean isSetAgentId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(AGENTID$18) != null;
            }
        }
        
        /**
         * Sets the "agentId" attribute
         */
        public void setAgentId(java.lang.String agentId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTID$18);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AGENTID$18);
                }
                target.setStringValue(agentId);
            }
        }
        
        /**
         * Sets (as xml) the "agentId" attribute
         */
        public void xsetAgentId(org.apache.xmlbeans.XmlString agentId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTID$18);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(AGENTID$18);
                }
                target.set(agentId);
            }
        }
        
        /**
         * Unsets the "agentId" attribute
         */
        public void unsetAgentId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(AGENTID$18);
            }
        }
        
        /**
         * Gets the "teamId" attribute
         */
        public java.lang.String getTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TEAMID$20);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "teamId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TEAMID$20);
                return target;
            }
        }
        
        /**
         * True if has "teamId" attribute
         */
        public boolean isSetTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(TEAMID$20) != null;
            }
        }
        
        /**
         * Sets the "teamId" attribute
         */
        public void setTeamId(java.lang.String teamId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TEAMID$20);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TEAMID$20);
                }
                target.setStringValue(teamId);
            }
        }
        
        /**
         * Sets (as xml) the "teamId" attribute
         */
        public void xsetTeamId(org.apache.xmlbeans.XmlString teamId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TEAMID$20);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TEAMID$20);
                }
                target.set(teamId);
            }
        }
        
        /**
         * Unsets the "teamId" attribute
         */
        public void unsetTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(TEAMID$20);
            }
        }
        
        /**
         * Gets the "siteId" attribute
         */
        public java.lang.String getSiteId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SITEID$22);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "siteId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetSiteId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SITEID$22);
                return target;
            }
        }
        
        /**
         * True if has "siteId" attribute
         */
        public boolean isSetSiteId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(SITEID$22) != null;
            }
        }
        
        /**
         * Sets the "siteId" attribute
         */
        public void setSiteId(java.lang.String siteId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SITEID$22);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SITEID$22);
                }
                target.setStringValue(siteId);
            }
        }
        
        /**
         * Sets (as xml) the "siteId" attribute
         */
        public void xsetSiteId(org.apache.xmlbeans.XmlString siteId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SITEID$22);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(SITEID$22);
                }
                target.set(siteId);
            }
        }
        
        /**
         * Unsets the "siteId" attribute
         */
        public void unsetSiteId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(SITEID$22);
            }
        }
        
        /**
         * Gets the "timestamp" attribute
         */
        public long getTimestamp()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TIMESTAMP$24);
                if (target == null)
                {
                    return 0L;
                }
                return target.getLongValue();
            }
        }
        
        /**
         * Gets (as xml) the "timestamp" attribute
         */
        public org.apache.xmlbeans.XmlLong xgetTimestamp()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlLong target = null;
                target = (org.apache.xmlbeans.XmlLong)get_store().find_attribute_user(TIMESTAMP$24);
                return target;
            }
        }
        
        /**
         * Sets the "timestamp" attribute
         */
        public void setTimestamp(long timestamp)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TIMESTAMP$24);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TIMESTAMP$24);
                }
                target.setLongValue(timestamp);
            }
        }
        
        /**
         * Sets (as xml) the "timestamp" attribute
         */
        public void xsetTimestamp(org.apache.xmlbeans.XmlLong timestamp)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlLong target = null;
                target = (org.apache.xmlbeans.XmlLong)get_store().find_attribute_user(TIMESTAMP$24);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlLong)get_store().add_attribute_user(TIMESTAMP$24);
                }
                target.set(timestamp);
            }
        }
        
        /**
         * Gets the "virtualTeamId" attribute
         */
        public java.lang.String getVirtualTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VIRTUALTEAMID$26);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "virtualTeamId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetVirtualTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VIRTUALTEAMID$26);
                return target;
            }
        }
        
        /**
         * True if has "virtualTeamId" attribute
         */
        public boolean isSetVirtualTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(VIRTUALTEAMID$26) != null;
            }
        }
        
        /**
         * Sets the "virtualTeamId" attribute
         */
        public void setVirtualTeamId(java.lang.String virtualTeamId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VIRTUALTEAMID$26);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VIRTUALTEAMID$26);
                }
                target.setStringValue(virtualTeamId);
            }
        }
        
        /**
         * Sets (as xml) the "virtualTeamId" attribute
         */
        public void xsetVirtualTeamId(org.apache.xmlbeans.XmlString virtualTeamId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VIRTUALTEAMID$26);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(VIRTUALTEAMID$26);
                }
                target.set(virtualTeamId);
            }
        }
        
        /**
         * Unsets the "virtualTeamId" attribute
         */
        public void unsetVirtualTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(VIRTUALTEAMID$26);
            }
        }
        
        /**
         * Gets the "code" attribute
         */
        public int getCode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CODE$28);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "code" attribute
         */
        public org.apache.xmlbeans.XmlInt xgetCode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(CODE$28);
                return target;
            }
        }
        
        /**
         * True if has "code" attribute
         */
        public boolean isSetCode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(CODE$28) != null;
            }
        }
        
        /**
         * Sets the "code" attribute
         */
        public void setCode(int code)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CODE$28);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CODE$28);
                }
                target.setIntValue(code);
            }
        }
        
        /**
         * Sets (as xml) the "code" attribute
         */
        public void xsetCode(org.apache.xmlbeans.XmlInt code)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(CODE$28);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(CODE$28);
                }
                target.set(code);
            }
        }
        
        /**
         * Unsets the "code" attribute
         */
        public void unsetCode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(CODE$28);
            }
        }
        
        /**
         * Gets the "reason" attribute
         */
        public java.lang.String getReason()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REASON$30);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "reason" attribute
         */
        public org.apache.xmlbeans.XmlString xgetReason()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(REASON$30);
                return target;
            }
        }
        
        /**
         * True if has "reason" attribute
         */
        public boolean isSetReason()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(REASON$30) != null;
            }
        }
        
        /**
         * Sets the "reason" attribute
         */
        public void setReason(java.lang.String reason)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REASON$30);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(REASON$30);
                }
                target.setStringValue(reason);
            }
        }
        
        /**
         * Sets (as xml) the "reason" attribute
         */
        public void xsetReason(org.apache.xmlbeans.XmlString reason)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(REASON$30);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(REASON$30);
                }
                target.set(reason);
            }
        }
        
        /**
         * Unsets the "reason" attribute
         */
        public void unsetReason()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(REASON$30);
            }
        }
        
        /**
         * Gets the "transferEnabled" attribute
         */
        public boolean getTransferEnabled()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TRANSFERENABLED$32);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(TRANSFERENABLED$32);
                }
                if (target == null)
                {
                    return false;
                }
                return target.getBooleanValue();
            }
        }
        
        /**
         * Gets (as xml) the "transferEnabled" attribute
         */
        public org.apache.xmlbeans.XmlBoolean xgetTransferEnabled()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(TRANSFERENABLED$32);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_default_attribute_value(TRANSFERENABLED$32);
                }
                return target;
            }
        }
        
        /**
         * True if has "transferEnabled" attribute
         */
        public boolean isSetTransferEnabled()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(TRANSFERENABLED$32) != null;
            }
        }
        
        /**
         * Sets the "transferEnabled" attribute
         */
        public void setTransferEnabled(boolean transferEnabled)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TRANSFERENABLED$32);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TRANSFERENABLED$32);
                }
                target.setBooleanValue(transferEnabled);
            }
        }
        
        /**
         * Sets (as xml) the "transferEnabled" attribute
         */
        public void xsetTransferEnabled(org.apache.xmlbeans.XmlBoolean transferEnabled)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(TRANSFERENABLED$32);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(TRANSFERENABLED$32);
                }
                target.set(transferEnabled);
            }
        }
        
        /**
         * Unsets the "transferEnabled" attribute
         */
        public void unsetTransferEnabled()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(TRANSFERENABLED$32);
            }
        }
        
        /**
         * Gets the "peerAgentId" attribute
         */
        public java.lang.String getPeerAgentId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERAGENTID$34);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "peerAgentId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetPeerAgentId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERAGENTID$34);
                return target;
            }
        }
        
        /**
         * True if has "peerAgentId" attribute
         */
        public boolean isSetPeerAgentId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(PEERAGENTID$34) != null;
            }
        }
        
        /**
         * Sets the "peerAgentId" attribute
         */
        public void setPeerAgentId(java.lang.String peerAgentId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERAGENTID$34);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PEERAGENTID$34);
                }
                target.setStringValue(peerAgentId);
            }
        }
        
        /**
         * Sets (as xml) the "peerAgentId" attribute
         */
        public void xsetPeerAgentId(org.apache.xmlbeans.XmlString peerAgentId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERAGENTID$34);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PEERAGENTID$34);
                }
                target.set(peerAgentId);
            }
        }
        
        /**
         * Unsets the "peerAgentId" attribute
         */
        public void unsetPeerAgentId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(PEERAGENTID$34);
            }
        }
        
        /**
         * Gets the "peerTeamId" attribute
         */
        public java.lang.String getPeerTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERTEAMID$36);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "peerTeamId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetPeerTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERTEAMID$36);
                return target;
            }
        }
        
        /**
         * True if has "peerTeamId" attribute
         */
        public boolean isSetPeerTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(PEERTEAMID$36) != null;
            }
        }
        
        /**
         * Sets the "peerTeamId" attribute
         */
        public void setPeerTeamId(java.lang.String peerTeamId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERTEAMID$36);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PEERTEAMID$36);
                }
                target.setStringValue(peerTeamId);
            }
        }
        
        /**
         * Sets (as xml) the "peerTeamId" attribute
         */
        public void xsetPeerTeamId(org.apache.xmlbeans.XmlString peerTeamId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERTEAMID$36);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PEERTEAMID$36);
                }
                target.set(peerTeamId);
            }
        }
        
        /**
         * Unsets the "peerTeamId" attribute
         */
        public void unsetPeerTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(PEERTEAMID$36);
            }
        }
        
        /**
         * Gets the "peerSiteId" attribute
         */
        public java.lang.String getPeerSiteId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERSITEID$38);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "peerSiteId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetPeerSiteId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERSITEID$38);
                return target;
            }
        }
        
        /**
         * True if has "peerSiteId" attribute
         */
        public boolean isSetPeerSiteId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(PEERSITEID$38) != null;
            }
        }
        
        /**
         * Sets the "peerSiteId" attribute
         */
        public void setPeerSiteId(java.lang.String peerSiteId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERSITEID$38);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PEERSITEID$38);
                }
                target.setStringValue(peerSiteId);
            }
        }
        
        /**
         * Sets (as xml) the "peerSiteId" attribute
         */
        public void xsetPeerSiteId(org.apache.xmlbeans.XmlString peerSiteId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERSITEID$38);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PEERSITEID$38);
                }
                target.set(peerSiteId);
            }
        }
        
        /**
         * Unsets the "peerSiteId" attribute
         */
        public void unsetPeerSiteId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(PEERSITEID$38);
            }
        }
        
        /**
         * Gets the "peerDn" attribute
         */
        public java.lang.String getPeerDn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERDN$40);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "peerDn" attribute
         */
        public org.apache.xmlbeans.XmlString xgetPeerDn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERDN$40);
                return target;
            }
        }
        
        /**
         * True if has "peerDn" attribute
         */
        public boolean isSetPeerDn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(PEERDN$40) != null;
            }
        }
        
        /**
         * Sets the "peerDn" attribute
         */
        public void setPeerDn(java.lang.String peerDn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERDN$40);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PEERDN$40);
                }
                target.setStringValue(peerDn);
            }
        }
        
        /**
         * Sets (as xml) the "peerDn" attribute
         */
        public void xsetPeerDn(org.apache.xmlbeans.XmlString peerDn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERDN$40);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PEERDN$40);
                }
                target.set(peerDn);
            }
        }
        
        /**
         * Unsets the "peerDn" attribute
         */
        public void unsetPeerDn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(PEERDN$40);
            }
        }
        
        /**
         * Gets the "agentsessionid" attribute
         */
        public java.lang.String getAgentsessionid()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTSESSIONID$42);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "agentsessionid" attribute
         */
        public org.apache.xmlbeans.XmlString xgetAgentsessionid()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTSESSIONID$42);
                return target;
            }
        }
        
        /**
         * True if has "agentsessionid" attribute
         */
        public boolean isSetAgentsessionid()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(AGENTSESSIONID$42) != null;
            }
        }
        
        /**
         * Sets the "agentsessionid" attribute
         */
        public void setAgentsessionid(java.lang.String agentsessionid)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTSESSIONID$42);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AGENTSESSIONID$42);
                }
                target.setStringValue(agentsessionid);
            }
        }
        
        /**
         * Sets (as xml) the "agentsessionid" attribute
         */
        public void xsetAgentsessionid(org.apache.xmlbeans.XmlString agentsessionid)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTSESSIONID$42);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(AGENTSESSIONID$42);
                }
                target.set(agentsessionid);
            }
        }
        
        /**
         * Unsets the "agentsessionid" attribute
         */
        public void unsetAgentsessionid()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(AGENTSESSIONID$42);
            }
        }
        
        /**
         * Gets the "peerAgentSessionId" attribute
         */
        public java.lang.String getPeerAgentSessionId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERAGENTSESSIONID$44);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "peerAgentSessionId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetPeerAgentSessionId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERAGENTSESSIONID$44);
                return target;
            }
        }
        
        /**
         * True if has "peerAgentSessionId" attribute
         */
        public boolean isSetPeerAgentSessionId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(PEERAGENTSESSIONID$44) != null;
            }
        }
        
        /**
         * Sets the "peerAgentSessionId" attribute
         */
        public void setPeerAgentSessionId(java.lang.String peerAgentSessionId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERAGENTSESSIONID$44);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PEERAGENTSESSIONID$44);
                }
                target.setStringValue(peerAgentSessionId);
            }
        }
        
        /**
         * Sets (as xml) the "peerAgentSessionId" attribute
         */
        public void xsetPeerAgentSessionId(org.apache.xmlbeans.XmlString peerAgentSessionId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERAGENTSESSIONID$44);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PEERAGENTSESSIONID$44);
                }
                target.set(peerAgentSessionId);
            }
        }
        
        /**
         * Unsets the "peerAgentSessionId" attribute
         */
        public void unsetPeerAgentSessionId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(PEERAGENTSESSIONID$44);
            }
        }
        
        /**
         * Gets the "aepUrl" attribute
         */
        public java.lang.String getAepUrl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AEPURL$46);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "aepUrl" attribute
         */
        public org.apache.xmlbeans.XmlAnyURI xgetAepUrl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(AEPURL$46);
                return target;
            }
        }
        
        /**
         * True if has "aepUrl" attribute
         */
        public boolean isSetAepUrl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(AEPURL$46) != null;
            }
        }
        
        /**
         * Sets the "aepUrl" attribute
         */
        public void setAepUrl(java.lang.String aepUrl)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AEPURL$46);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AEPURL$46);
                }
                target.setStringValue(aepUrl);
            }
        }
        
        /**
         * Sets (as xml) the "aepUrl" attribute
         */
        public void xsetAepUrl(org.apache.xmlbeans.XmlAnyURI aepUrl)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(AEPURL$46);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(AEPURL$46);
                }
                target.set(aepUrl);
            }
        }
        
        /**
         * Unsets the "aepUrl" attribute
         */
        public void unsetAepUrl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(AEPURL$46);
            }
        }
        
        /**
         * Gets the "peerAgentName" attribute
         */
        public java.lang.String getPeerAgentName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERAGENTNAME$48);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "peerAgentName" attribute
         */
        public org.apache.xmlbeans.XmlString xgetPeerAgentName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERAGENTNAME$48);
                return target;
            }
        }
        
        /**
         * True if has "peerAgentName" attribute
         */
        public boolean isSetPeerAgentName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(PEERAGENTNAME$48) != null;
            }
        }
        
        /**
         * Sets the "peerAgentName" attribute
         */
        public void setPeerAgentName(java.lang.String peerAgentName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERAGENTNAME$48);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PEERAGENTNAME$48);
                }
                target.setStringValue(peerAgentName);
            }
        }
        
        /**
         * Sets (as xml) the "peerAgentName" attribute
         */
        public void xsetPeerAgentName(org.apache.xmlbeans.XmlString peerAgentName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERAGENTNAME$48);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PEERAGENTNAME$48);
                }
                target.set(peerAgentName);
            }
        }
        
        /**
         * Unsets the "peerAgentName" attribute
         */
        public void unsetPeerAgentName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(PEERAGENTNAME$48);
            }
        }
        
        /**
         * Gets the "callLegId" attribute
         */
        public java.lang.String getCallLegId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CALLLEGID$50);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "callLegId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetCallLegId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CALLLEGID$50);
                return target;
            }
        }
        
        /**
         * True if has "callLegId" attribute
         */
        public boolean isSetCallLegId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(CALLLEGID$50) != null;
            }
        }
        
        /**
         * Sets the "callLegId" attribute
         */
        public void setCallLegId(java.lang.String callLegId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CALLLEGID$50);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CALLLEGID$50);
                }
                target.setStringValue(callLegId);
            }
        }
        
        /**
         * Sets (as xml) the "callLegId" attribute
         */
        public void xsetCallLegId(org.apache.xmlbeans.XmlString callLegId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CALLLEGID$50);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(CALLLEGID$50);
                }
                target.set(callLegId);
            }
        }
        
        /**
         * Unsets the "callLegId" attribute
         */
        public void unsetCallLegId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(CALLLEGID$50);
            }
        }
        
        /**
         * Gets the "agentDn" attribute
         */
        public java.lang.String getAgentDn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTDN$52);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "agentDn" attribute
         */
        public org.apache.xmlbeans.XmlString xgetAgentDn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTDN$52);
                return target;
            }
        }
        
        /**
         * True if has "agentDn" attribute
         */
        public boolean isSetAgentDn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(AGENTDN$52) != null;
            }
        }
        
        /**
         * Sets the "agentDn" attribute
         */
        public void setAgentDn(java.lang.String agentDn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTDN$52);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AGENTDN$52);
                }
                target.setStringValue(agentDn);
            }
        }
        
        /**
         * Sets (as xml) the "agentDn" attribute
         */
        public void xsetAgentDn(org.apache.xmlbeans.XmlString agentDn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTDN$52);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(AGENTDN$52);
                }
                target.set(agentDn);
            }
        }
        
        /**
         * Unsets the "agentDn" attribute
         */
        public void unsetAgentDn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(AGENTDN$52);
            }
        }
        
        /**
         * Gets the "enterpriseId" attribute
         */
        public java.lang.String getEnterpriseId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENTERPRISEID$54);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "enterpriseId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetEnterpriseId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ENTERPRISEID$54);
                return target;
            }
        }
        
        /**
         * True if has "enterpriseId" attribute
         */
        public boolean isSetEnterpriseId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(ENTERPRISEID$54) != null;
            }
        }
        
        /**
         * Sets the "enterpriseId" attribute
         */
        public void setEnterpriseId(java.lang.String enterpriseId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENTERPRISEID$54);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ENTERPRISEID$54);
                }
                target.setStringValue(enterpriseId);
            }
        }
        
        /**
         * Sets (as xml) the "enterpriseId" attribute
         */
        public void xsetEnterpriseId(org.apache.xmlbeans.XmlString enterpriseId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ENTERPRISEID$54);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ENTERPRISEID$54);
                }
                target.set(enterpriseId);
            }
        }
        
        /**
         * Unsets the "enterpriseId" attribute
         */
        public void unsetEnterpriseId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(ENTERPRISEID$54);
            }
        }
        
        /**
         * Gets the "ahaUrl" attribute
         */
        public java.lang.String getAhaUrl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AHAURL$56);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ahaUrl" attribute
         */
        public org.apache.xmlbeans.XmlAnyURI xgetAhaUrl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(AHAURL$56);
                return target;
            }
        }
        
        /**
         * True if has "ahaUrl" attribute
         */
        public boolean isSetAhaUrl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(AHAURL$56) != null;
            }
        }
        
        /**
         * Sets the "ahaUrl" attribute
         */
        public void setAhaUrl(java.lang.String ahaUrl)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AHAURL$56);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AHAURL$56);
                }
                target.setStringValue(ahaUrl);
            }
        }
        
        /**
         * Sets (as xml) the "ahaUrl" attribute
         */
        public void xsetAhaUrl(org.apache.xmlbeans.XmlAnyURI ahaUrl)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(AHAURL$56);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(AHAURL$56);
                }
                target.set(ahaUrl);
            }
        }
        
        /**
         * Unsets the "ahaUrl" attribute
         */
        public void unsetAhaUrl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(AHAURL$56);
            }
        }
        
        /**
         * Gets the "consultCallId" attribute
         */
        public java.lang.String getConsultCallId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CONSULTCALLID$58);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "consultCallId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetConsultCallId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CONSULTCALLID$58);
                return target;
            }
        }
        
        /**
         * True if has "consultCallId" attribute
         */
        public boolean isSetConsultCallId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(CONSULTCALLID$58) != null;
            }
        }
        
        /**
         * Sets the "consultCallId" attribute
         */
        public void setConsultCallId(java.lang.String consultCallId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CONSULTCALLID$58);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CONSULTCALLID$58);
                }
                target.setStringValue(consultCallId);
            }
        }
        
        /**
         * Sets (as xml) the "consultCallId" attribute
         */
        public void xsetConsultCallId(org.apache.xmlbeans.XmlString consultCallId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CONSULTCALLID$58);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(CONSULTCALLID$58);
                }
                target.set(consultCallId);
            }
        }
        
        /**
         * Unsets the "consultCallId" attribute
         */
        public void unsetConsultCallId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(CONSULTCALLID$58);
            }
        }
        
        /**
         * Gets the "enablePauseResume" attribute
         */
        public boolean getEnablePauseResume()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENABLEPAUSERESUME$60);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(ENABLEPAUSERESUME$60);
                }
                if (target == null)
                {
                    return false;
                }
                return target.getBooleanValue();
            }
        }
        
        /**
         * Gets (as xml) the "enablePauseResume" attribute
         */
        public org.apache.xmlbeans.XmlBoolean xgetEnablePauseResume()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(ENABLEPAUSERESUME$60);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_default_attribute_value(ENABLEPAUSERESUME$60);
                }
                return target;
            }
        }
        
        /**
         * True if has "enablePauseResume" attribute
         */
        public boolean isSetEnablePauseResume()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(ENABLEPAUSERESUME$60) != null;
            }
        }
        
        /**
         * Sets the "enablePauseResume" attribute
         */
        public void setEnablePauseResume(boolean enablePauseResume)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENABLEPAUSERESUME$60);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ENABLEPAUSERESUME$60);
                }
                target.setBooleanValue(enablePauseResume);
            }
        }
        
        /**
         * Sets (as xml) the "enablePauseResume" attribute
         */
        public void xsetEnablePauseResume(org.apache.xmlbeans.XmlBoolean enablePauseResume)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(ENABLEPAUSERESUME$60);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(ENABLEPAUSERESUME$60);
                }
                target.set(enablePauseResume);
            }
        }
        
        /**
         * Unsets the "enablePauseResume" attribute
         */
        public void unsetEnablePauseResume()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(ENABLEPAUSERESUME$60);
            }
        }
        
        /**
         * Gets the "pauseDuration" attribute
         */
        public int getPauseDuration()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PAUSEDURATION$62);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(PAUSEDURATION$62);
                }
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "pauseDuration" attribute
         */
        public org.apache.xmlbeans.XmlInt xgetPauseDuration()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(PAUSEDURATION$62);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_default_attribute_value(PAUSEDURATION$62);
                }
                return target;
            }
        }
        
        /**
         * True if has "pauseDuration" attribute
         */
        public boolean isSetPauseDuration()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(PAUSEDURATION$62) != null;
            }
        }
        
        /**
         * Sets the "pauseDuration" attribute
         */
        public void setPauseDuration(int pauseDuration)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PAUSEDURATION$62);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PAUSEDURATION$62);
                }
                target.setIntValue(pauseDuration);
            }
        }
        
        /**
         * Sets (as xml) the "pauseDuration" attribute
         */
        public void xsetPauseDuration(org.apache.xmlbeans.XmlInt pauseDuration)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(PAUSEDURATION$62);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(PAUSEDURATION$62);
                }
                target.set(pauseDuration);
            }
        }
        
        /**
         * Unsets the "pauseDuration" attribute
         */
        public void unsetPauseDuration()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(PAUSEDURATION$62);
            }
        }
        
        /**
         * Gets the "channelId" attribute
         */
        public java.lang.String getChannelId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHANNELID$64);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "channelId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetChannelId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CHANNELID$64);
                return target;
            }
        }
        
        /**
         * True if has "channelId" attribute
         */
        public boolean isSetChannelId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(CHANNELID$64) != null;
            }
        }
        
        /**
         * Sets the "channelId" attribute
         */
        public void setChannelId(java.lang.String channelId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHANNELID$64);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CHANNELID$64);
                }
                target.setStringValue(channelId);
            }
        }
        
        /**
         * Sets (as xml) the "channelId" attribute
         */
        public void xsetChannelId(org.apache.xmlbeans.XmlString channelId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CHANNELID$64);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(CHANNELID$64);
                }
                target.set(channelId);
            }
        }
        
        /**
         * Unsets the "channelId" attribute
         */
        public void unsetChannelId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(CHANNELID$64);
            }
        }
        
        /**
         * Gets the "channelType" attribute
         */
        public com.transerainc.aha.gen.agent.ChannelTypes.Enum getChannelType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHANNELTYPE$66);
                if (target == null)
                {
                    return null;
                }
                return (com.transerainc.aha.gen.agent.ChannelTypes.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "channelType" attribute
         */
        public com.transerainc.aha.gen.agent.ChannelTypes xgetChannelType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ChannelTypes target = null;
                target = (com.transerainc.aha.gen.agent.ChannelTypes)get_store().find_attribute_user(CHANNELTYPE$66);
                return target;
            }
        }
        
        /**
         * True if has "channelType" attribute
         */
        public boolean isSetChannelType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(CHANNELTYPE$66) != null;
            }
        }
        
        /**
         * Sets the "channelType" attribute
         */
        public void setChannelType(com.transerainc.aha.gen.agent.ChannelTypes.Enum channelType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHANNELTYPE$66);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CHANNELTYPE$66);
                }
                target.setEnumValue(channelType);
            }
        }
        
        /**
         * Sets (as xml) the "channelType" attribute
         */
        public void xsetChannelType(com.transerainc.aha.gen.agent.ChannelTypes channelType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ChannelTypes target = null;
                target = (com.transerainc.aha.gen.agent.ChannelTypes)get_store().find_attribute_user(CHANNELTYPE$66);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.ChannelTypes)get_store().add_attribute_user(CHANNELTYPE$66);
                }
                target.set(channelType);
            }
        }
        
        /**
         * Unsets the "channelType" attribute
         */
        public void unsetChannelType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(CHANNELTYPE$66);
            }
        }
        
        /**
         * Gets the "peerChannelId" attribute
         */
        public java.lang.String getPeerChannelId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERCHANNELID$68);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "peerChannelId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetPeerChannelId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERCHANNELID$68);
                return target;
            }
        }
        
        /**
         * True if has "peerChannelId" attribute
         */
        public boolean isSetPeerChannelId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(PEERCHANNELID$68) != null;
            }
        }
        
        /**
         * Sets the "peerChannelId" attribute
         */
        public void setPeerChannelId(java.lang.String peerChannelId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERCHANNELID$68);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PEERCHANNELID$68);
                }
                target.setStringValue(peerChannelId);
            }
        }
        
        /**
         * Sets (as xml) the "peerChannelId" attribute
         */
        public void xsetPeerChannelId(org.apache.xmlbeans.XmlString peerChannelId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERCHANNELID$68);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PEERCHANNELID$68);
                }
                target.set(peerChannelId);
            }
        }
        
        /**
         * Unsets the "peerChannelId" attribute
         */
        public void unsetPeerChannelId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(PEERCHANNELID$68);
            }
        }
        
        /**
         * Gets the "peerChannelType" attribute
         */
        public java.lang.String getPeerChannelType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERCHANNELTYPE$70);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "peerChannelType" attribute
         */
        public org.apache.xmlbeans.XmlString xgetPeerChannelType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERCHANNELTYPE$70);
                return target;
            }
        }
        
        /**
         * True if has "peerChannelType" attribute
         */
        public boolean isSetPeerChannelType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(PEERCHANNELTYPE$70) != null;
            }
        }
        
        /**
         * Sets the "peerChannelType" attribute
         */
        public void setPeerChannelType(java.lang.String peerChannelType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERCHANNELTYPE$70);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PEERCHANNELTYPE$70);
                }
                target.setStringValue(peerChannelType);
            }
        }
        
        /**
         * Sets (as xml) the "peerChannelType" attribute
         */
        public void xsetPeerChannelType(org.apache.xmlbeans.XmlString peerChannelType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERCHANNELTYPE$70);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PEERCHANNELTYPE$70);
                }
                target.set(peerChannelType);
            }
        }
        
        /**
         * Unsets the "peerChannelType" attribute
         */
        public void unsetPeerChannelType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(PEERCHANNELTYPE$70);
            }
        }
        
        /**
         * Gets the "destinationVirtualTeamId" attribute
         */
        public java.lang.String getDestinationVirtualTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DESTINATIONVIRTUALTEAMID$72);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "destinationVirtualTeamId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetDestinationVirtualTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(DESTINATIONVIRTUALTEAMID$72);
                return target;
            }
        }
        
        /**
         * True if has "destinationVirtualTeamId" attribute
         */
        public boolean isSetDestinationVirtualTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(DESTINATIONVIRTUALTEAMID$72) != null;
            }
        }
        
        /**
         * Sets the "destinationVirtualTeamId" attribute
         */
        public void setDestinationVirtualTeamId(java.lang.String destinationVirtualTeamId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DESTINATIONVIRTUALTEAMID$72);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DESTINATIONVIRTUALTEAMID$72);
                }
                target.setStringValue(destinationVirtualTeamId);
            }
        }
        
        /**
         * Sets (as xml) the "destinationVirtualTeamId" attribute
         */
        public void xsetDestinationVirtualTeamId(org.apache.xmlbeans.XmlString destinationVirtualTeamId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(DESTINATIONVIRTUALTEAMID$72);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(DESTINATIONVIRTUALTEAMID$72);
                }
                target.set(destinationVirtualTeamId);
            }
        }
        
        /**
         * Unsets the "destinationVirtualTeamId" attribute
         */
        public void unsetDestinationVirtualTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(DESTINATIONVIRTUALTEAMID$72);
            }
        }
        
        /**
         * Gets the "source" attribute
         */
        public java.lang.String getSource()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SOURCE$74);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "source" attribute
         */
        public org.apache.xmlbeans.XmlString xgetSource()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SOURCE$74);
                return target;
            }
        }
        
        /**
         * True if has "source" attribute
         */
        public boolean isSetSource()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(SOURCE$74) != null;
            }
        }
        
        /**
         * Sets the "source" attribute
         */
        public void setSource(java.lang.String source)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SOURCE$74);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SOURCE$74);
                }
                target.setStringValue(source);
            }
        }
        
        /**
         * Sets (as xml) the "source" attribute
         */
        public void xsetSource(org.apache.xmlbeans.XmlString source)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SOURCE$74);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(SOURCE$74);
                }
                target.set(source);
            }
        }
        
        /**
         * Unsets the "source" attribute
         */
        public void unsetSource()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(SOURCE$74);
            }
        }
    }
}
