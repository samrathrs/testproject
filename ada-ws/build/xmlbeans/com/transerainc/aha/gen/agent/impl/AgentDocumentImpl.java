/*
 * An XML document type.
 * Localname: agent
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.AgentDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one agent(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class AgentDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AgentDocument
{
    private static final long serialVersionUID = 1L;
    
    public AgentDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AGENT$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "agent");
    
    
    /**
     * Gets the "agent" element
     */
    public com.transerainc.aha.gen.agent.AgentDocument.Agent getAgent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AgentDocument.Agent target = null;
            target = (com.transerainc.aha.gen.agent.AgentDocument.Agent)get_store().find_element_user(AGENT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "agent" element
     */
    public void setAgent(com.transerainc.aha.gen.agent.AgentDocument.Agent agent)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AgentDocument.Agent target = null;
            target = (com.transerainc.aha.gen.agent.AgentDocument.Agent)get_store().find_element_user(AGENT$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.AgentDocument.Agent)get_store().add_element_user(AGENT$0);
            }
            target.set(agent);
        }
    }
    
    /**
     * Appends and returns a new empty "agent" element
     */
    public com.transerainc.aha.gen.agent.AgentDocument.Agent addNewAgent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AgentDocument.Agent target = null;
            target = (com.transerainc.aha.gen.agent.AgentDocument.Agent)get_store().add_element_user(AGENT$0);
            return target;
        }
    }
    /**
     * An XML agent(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class AgentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AgentDocument.Agent
    {
        private static final long serialVersionUID = 1L;
        
        public AgentImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName AUXILIARYINFORMATION$0 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "auxiliaryInformation");
        private static final javax.xml.namespace.QName CALLASSOCIATEDDATA$2 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "callAssociatedData");
        private static final javax.xml.namespace.QName RESPONSE$4 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "response");
        private static final javax.xml.namespace.QName ATTRIBUTE$6 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "attribute");
        private static final javax.xml.namespace.QName CHANNELSET$8 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "channel-set");
        private static final javax.xml.namespace.QName SKILLSET$10 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "skill-set");
        private static final javax.xml.namespace.QName COMMANDMESSAGE$12 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "commandMessage");
        private static final javax.xml.namespace.QName AGENTID$14 = 
            new javax.xml.namespace.QName("", "agentId");
        private static final javax.xml.namespace.QName LOGINUSERID$16 = 
            new javax.xml.namespace.QName("", "loginUserId");
        private static final javax.xml.namespace.QName NAME$18 = 
            new javax.xml.namespace.QName("", "name");
        private static final javax.xml.namespace.QName ENTERPRISEID$20 = 
            new javax.xml.namespace.QName("", "enterpriseId");
        private static final javax.xml.namespace.QName ENTERPRISENAME$22 = 
            new javax.xml.namespace.QName("", "enterpriseName");
        private static final javax.xml.namespace.QName SITEID$24 = 
            new javax.xml.namespace.QName("", "siteId");
        private static final javax.xml.namespace.QName SITENAME$26 = 
            new javax.xml.namespace.QName("", "siteName");
        private static final javax.xml.namespace.QName TEAMID$28 = 
            new javax.xml.namespace.QName("", "teamId");
        private static final javax.xml.namespace.QName TEAMNAME$30 = 
            new javax.xml.namespace.QName("", "teamName");
        private static final javax.xml.namespace.QName POSITIONID$32 = 
            new javax.xml.namespace.QName("", "positionId");
        private static final javax.xml.namespace.QName DN$34 = 
            new javax.xml.namespace.QName("", "dn");
        private static final javax.xml.namespace.QName STATUS$36 = 
            new javax.xml.namespace.QName("", "status");
        private static final javax.xml.namespace.QName SUBSTATUS$38 = 
            new javax.xml.namespace.QName("", "subStatus");
        private static final javax.xml.namespace.QName GROUPNAME$40 = 
            new javax.xml.namespace.QName("", "groupName");
        private static final javax.xml.namespace.QName HOSTIPADDRESS$42 = 
            new javax.xml.namespace.QName("", "hostIpAddress");
        private static final javax.xml.namespace.QName EXTERNALIPADDRESS$44 = 
            new javax.xml.namespace.QName("", "externalIpAddress");
        private static final javax.xml.namespace.QName TIMESTAMP$46 = 
            new javax.xml.namespace.QName("", "timestamp");
        private static final javax.xml.namespace.QName AVAILABLETIMESTAMP$48 = 
            new javax.xml.namespace.QName("", "availableTimestamp");
        private static final javax.xml.namespace.QName CALLID$50 = 
            new javax.xml.namespace.QName("", "callId");
        private static final javax.xml.namespace.QName AEPURL$52 = 
            new javax.xml.namespace.QName("", "aepUrl");
        private static final javax.xml.namespace.QName RETRY$54 = 
            new javax.xml.namespace.QName("", "retry");
        private static final javax.xml.namespace.QName AGENTSESSIONID$56 = 
            new javax.xml.namespace.QName("", "agentsessionid");
        private static final javax.xml.namespace.QName VIRTUALTEAMID$58 = 
            new javax.xml.namespace.QName("", "virtualTeamId");
        private static final javax.xml.namespace.QName LOGIN$60 = 
            new javax.xml.namespace.QName("", "login");
        private static final javax.xml.namespace.QName REASON$62 = 
            new javax.xml.namespace.QName("", "reason");
        private static final javax.xml.namespace.QName CALLLEGID$64 = 
            new javax.xml.namespace.QName("", "callLegId");
        private static final javax.xml.namespace.QName AHAURL$66 = 
            new javax.xml.namespace.QName("", "ahaurl");
        private static final javax.xml.namespace.QName ENABLEPAUSERESUME$68 = 
            new javax.xml.namespace.QName("", "enablePauseResume");
        private static final javax.xml.namespace.QName PAUSEDURATION$70 = 
            new javax.xml.namespace.QName("", "pauseDuration");
        private static final javax.xml.namespace.QName AHAURL$72 = 
            new javax.xml.namespace.QName("", "ahaUrl");
        private static final javax.xml.namespace.QName CHANNELID$74 = 
            new javax.xml.namespace.QName("", "channelId");
        private static final javax.xml.namespace.QName CHANNELTYPE$76 = 
            new javax.xml.namespace.QName("", "channelType");
        private static final javax.xml.namespace.QName CODE$78 = 
            new javax.xml.namespace.QName("", "code");
        private static final javax.xml.namespace.QName CONSULTCALLID$80 = 
            new javax.xml.namespace.QName("", "consultCallId");
        private static final javax.xml.namespace.QName DESTINATIONVIRTUALTEAMID$82 = 
            new javax.xml.namespace.QName("", "destinationVirtualTeamId");
        private static final javax.xml.namespace.QName PEERAGENTID$84 = 
            new javax.xml.namespace.QName("", "peerAgentId");
        private static final javax.xml.namespace.QName PEERTEAMID$86 = 
            new javax.xml.namespace.QName("", "peerTeamId");
        private static final javax.xml.namespace.QName PEERSITEID$88 = 
            new javax.xml.namespace.QName("", "peerSiteId");
        private static final javax.xml.namespace.QName PEERDN$90 = 
            new javax.xml.namespace.QName("", "peerDn");
        private static final javax.xml.namespace.QName PEERAGENTNAME$92 = 
            new javax.xml.namespace.QName("", "peerAgentName");
        private static final javax.xml.namespace.QName PEERAGENTSESSIONID$94 = 
            new javax.xml.namespace.QName("", "peerAgentSessionId");
        private static final javax.xml.namespace.QName PEERCHANNELID$96 = 
            new javax.xml.namespace.QName("", "peerChannelId");
        private static final javax.xml.namespace.QName PEERCHANNELTYPE$98 = 
            new javax.xml.namespace.QName("", "peerChannelType");
        private static final javax.xml.namespace.QName TRANSFERENABLED$100 = 
            new javax.xml.namespace.QName("", "transferEnabled");
        
        
        /**
         * Gets array of all "auxiliaryInformation" elements
         */
        public com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation[] getAuxiliaryInformationArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(AUXILIARYINFORMATION$0, targetList);
                com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation[] result = new com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "auxiliaryInformation" element
         */
        public com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation getAuxiliaryInformationArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation target = null;
                target = (com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation)get_store().find_element_user(AUXILIARYINFORMATION$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "auxiliaryInformation" element
         */
        public int sizeOfAuxiliaryInformationArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(AUXILIARYINFORMATION$0);
            }
        }
        
        /**
         * Sets array of all "auxiliaryInformation" element
         */
        public void setAuxiliaryInformationArray(com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation[] auxiliaryInformationArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(auxiliaryInformationArray, AUXILIARYINFORMATION$0);
            }
        }
        
        /**
         * Sets ith "auxiliaryInformation" element
         */
        public void setAuxiliaryInformationArray(int i, com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation auxiliaryInformation)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation target = null;
                target = (com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation)get_store().find_element_user(AUXILIARYINFORMATION$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(auxiliaryInformation);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "auxiliaryInformation" element
         */
        public com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation insertNewAuxiliaryInformation(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation target = null;
                target = (com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation)get_store().insert_element_user(AUXILIARYINFORMATION$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "auxiliaryInformation" element
         */
        public com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation addNewAuxiliaryInformation()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation target = null;
                target = (com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation)get_store().add_element_user(AUXILIARYINFORMATION$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "auxiliaryInformation" element
         */
        public void removeAuxiliaryInformation(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(AUXILIARYINFORMATION$0, i);
            }
        }
        
        /**
         * Gets array of all "callAssociatedData" elements
         */
        public com.transerainc.aha.gen.agent.CallAssociatedDataDocument.CallAssociatedData[] getCallAssociatedDataArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(CALLASSOCIATEDDATA$2, targetList);
                com.transerainc.aha.gen.agent.CallAssociatedDataDocument.CallAssociatedData[] result = new com.transerainc.aha.gen.agent.CallAssociatedDataDocument.CallAssociatedData[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "callAssociatedData" element
         */
        public com.transerainc.aha.gen.agent.CallAssociatedDataDocument.CallAssociatedData getCallAssociatedDataArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.CallAssociatedDataDocument.CallAssociatedData target = null;
                target = (com.transerainc.aha.gen.agent.CallAssociatedDataDocument.CallAssociatedData)get_store().find_element_user(CALLASSOCIATEDDATA$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "callAssociatedData" element
         */
        public int sizeOfCallAssociatedDataArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(CALLASSOCIATEDDATA$2);
            }
        }
        
        /**
         * Sets array of all "callAssociatedData" element
         */
        public void setCallAssociatedDataArray(com.transerainc.aha.gen.agent.CallAssociatedDataDocument.CallAssociatedData[] callAssociatedDataArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(callAssociatedDataArray, CALLASSOCIATEDDATA$2);
            }
        }
        
        /**
         * Sets ith "callAssociatedData" element
         */
        public void setCallAssociatedDataArray(int i, com.transerainc.aha.gen.agent.CallAssociatedDataDocument.CallAssociatedData callAssociatedData)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.CallAssociatedDataDocument.CallAssociatedData target = null;
                target = (com.transerainc.aha.gen.agent.CallAssociatedDataDocument.CallAssociatedData)get_store().find_element_user(CALLASSOCIATEDDATA$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(callAssociatedData);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "callAssociatedData" element
         */
        public com.transerainc.aha.gen.agent.CallAssociatedDataDocument.CallAssociatedData insertNewCallAssociatedData(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.CallAssociatedDataDocument.CallAssociatedData target = null;
                target = (com.transerainc.aha.gen.agent.CallAssociatedDataDocument.CallAssociatedData)get_store().insert_element_user(CALLASSOCIATEDDATA$2, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "callAssociatedData" element
         */
        public com.transerainc.aha.gen.agent.CallAssociatedDataDocument.CallAssociatedData addNewCallAssociatedData()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.CallAssociatedDataDocument.CallAssociatedData target = null;
                target = (com.transerainc.aha.gen.agent.CallAssociatedDataDocument.CallAssociatedData)get_store().add_element_user(CALLASSOCIATEDDATA$2);
                return target;
            }
        }
        
        /**
         * Removes the ith "callAssociatedData" element
         */
        public void removeCallAssociatedData(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(CALLASSOCIATEDDATA$2, i);
            }
        }
        
        /**
         * Gets the "response" element
         */
        public com.transerainc.aha.gen.agent.ResponseDocument.Response getResponse()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ResponseDocument.Response target = null;
                target = (com.transerainc.aha.gen.agent.ResponseDocument.Response)get_store().find_element_user(RESPONSE$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "response" element
         */
        public boolean isSetResponse()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(RESPONSE$4) != 0;
            }
        }
        
        /**
         * Sets the "response" element
         */
        public void setResponse(com.transerainc.aha.gen.agent.ResponseDocument.Response response)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ResponseDocument.Response target = null;
                target = (com.transerainc.aha.gen.agent.ResponseDocument.Response)get_store().find_element_user(RESPONSE$4, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.ResponseDocument.Response)get_store().add_element_user(RESPONSE$4);
                }
                target.set(response);
            }
        }
        
        /**
         * Appends and returns a new empty "response" element
         */
        public com.transerainc.aha.gen.agent.ResponseDocument.Response addNewResponse()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ResponseDocument.Response target = null;
                target = (com.transerainc.aha.gen.agent.ResponseDocument.Response)get_store().add_element_user(RESPONSE$4);
                return target;
            }
        }
        
        /**
         * Unsets the "response" element
         */
        public void unsetResponse()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(RESPONSE$4, 0);
            }
        }
        
        /**
         * Gets array of all "attribute" elements
         */
        public com.transerainc.aha.gen.agent.AttributeDocument.Attribute[] getAttributeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(ATTRIBUTE$6, targetList);
                com.transerainc.aha.gen.agent.AttributeDocument.Attribute[] result = new com.transerainc.aha.gen.agent.AttributeDocument.Attribute[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "attribute" element
         */
        public com.transerainc.aha.gen.agent.AttributeDocument.Attribute getAttributeArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AttributeDocument.Attribute target = null;
                target = (com.transerainc.aha.gen.agent.AttributeDocument.Attribute)get_store().find_element_user(ATTRIBUTE$6, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "attribute" element
         */
        public int sizeOfAttributeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ATTRIBUTE$6);
            }
        }
        
        /**
         * Sets array of all "attribute" element
         */
        public void setAttributeArray(com.transerainc.aha.gen.agent.AttributeDocument.Attribute[] attributeArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(attributeArray, ATTRIBUTE$6);
            }
        }
        
        /**
         * Sets ith "attribute" element
         */
        public void setAttributeArray(int i, com.transerainc.aha.gen.agent.AttributeDocument.Attribute attribute)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AttributeDocument.Attribute target = null;
                target = (com.transerainc.aha.gen.agent.AttributeDocument.Attribute)get_store().find_element_user(ATTRIBUTE$6, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(attribute);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "attribute" element
         */
        public com.transerainc.aha.gen.agent.AttributeDocument.Attribute insertNewAttribute(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AttributeDocument.Attribute target = null;
                target = (com.transerainc.aha.gen.agent.AttributeDocument.Attribute)get_store().insert_element_user(ATTRIBUTE$6, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "attribute" element
         */
        public com.transerainc.aha.gen.agent.AttributeDocument.Attribute addNewAttribute()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AttributeDocument.Attribute target = null;
                target = (com.transerainc.aha.gen.agent.AttributeDocument.Attribute)get_store().add_element_user(ATTRIBUTE$6);
                return target;
            }
        }
        
        /**
         * Removes the ith "attribute" element
         */
        public void removeAttribute(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ATTRIBUTE$6, i);
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
                target = (com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet)get_store().find_element_user(CHANNELSET$8, 0);
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
                return get_store().count_elements(CHANNELSET$8) != 0;
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
                target = (com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet)get_store().find_element_user(CHANNELSET$8, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet)get_store().add_element_user(CHANNELSET$8);
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
                target = (com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet)get_store().add_element_user(CHANNELSET$8);
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
                get_store().remove_element(CHANNELSET$8, 0);
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
                target = (com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet)get_store().find_element_user(SKILLSET$10, 0);
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
                return get_store().count_elements(SKILLSET$10) != 0;
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
                target = (com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet)get_store().find_element_user(SKILLSET$10, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet)get_store().add_element_user(SKILLSET$10);
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
                target = (com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet)get_store().add_element_user(SKILLSET$10);
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
                get_store().remove_element(SKILLSET$10, 0);
            }
        }
        
        /**
         * Gets the "commandMessage" element
         */
        public com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage getCommandMessage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage target = null;
                target = (com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage)get_store().find_element_user(COMMANDMESSAGE$12, 0);
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
                return get_store().count_elements(COMMANDMESSAGE$12) != 0;
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
                target = (com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage)get_store().find_element_user(COMMANDMESSAGE$12, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage)get_store().add_element_user(COMMANDMESSAGE$12);
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
                target = (com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage)get_store().add_element_user(COMMANDMESSAGE$12);
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
                get_store().remove_element(COMMANDMESSAGE$12, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTID$14);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTID$14);
                return target;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTID$14);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AGENTID$14);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTID$14);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(AGENTID$14);
                }
                target.set(agentId);
            }
        }
        
        /**
         * Gets the "loginUserId" attribute
         */
        public java.lang.String getLoginUserId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LOGINUSERID$16);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "loginUserId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetLoginUserId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(LOGINUSERID$16);
                return target;
            }
        }
        
        /**
         * True if has "loginUserId" attribute
         */
        public boolean isSetLoginUserId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(LOGINUSERID$16) != null;
            }
        }
        
        /**
         * Sets the "loginUserId" attribute
         */
        public void setLoginUserId(java.lang.String loginUserId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LOGINUSERID$16);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(LOGINUSERID$16);
                }
                target.setStringValue(loginUserId);
            }
        }
        
        /**
         * Sets (as xml) the "loginUserId" attribute
         */
        public void xsetLoginUserId(org.apache.xmlbeans.XmlString loginUserId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(LOGINUSERID$16);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(LOGINUSERID$16);
                }
                target.set(loginUserId);
            }
        }
        
        /**
         * Unsets the "loginUserId" attribute
         */
        public void unsetLoginUserId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(LOGINUSERID$16);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$18);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$18);
                return target;
            }
        }
        
        /**
         * True if has "name" attribute
         */
        public boolean isSetName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(NAME$18) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$18);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$18);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$18);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAME$18);
                }
                target.set(name);
            }
        }
        
        /**
         * Unsets the "name" attribute
         */
        public void unsetName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(NAME$18);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENTERPRISEID$20);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ENTERPRISEID$20);
                return target;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENTERPRISEID$20);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ENTERPRISEID$20);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ENTERPRISEID$20);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ENTERPRISEID$20);
                }
                target.set(enterpriseId);
            }
        }
        
        /**
         * Gets the "enterpriseName" attribute
         */
        public java.lang.String getEnterpriseName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENTERPRISENAME$22);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "enterpriseName" attribute
         */
        public org.apache.xmlbeans.XmlString xgetEnterpriseName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ENTERPRISENAME$22);
                return target;
            }
        }
        
        /**
         * True if has "enterpriseName" attribute
         */
        public boolean isSetEnterpriseName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(ENTERPRISENAME$22) != null;
            }
        }
        
        /**
         * Sets the "enterpriseName" attribute
         */
        public void setEnterpriseName(java.lang.String enterpriseName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENTERPRISENAME$22);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ENTERPRISENAME$22);
                }
                target.setStringValue(enterpriseName);
            }
        }
        
        /**
         * Sets (as xml) the "enterpriseName" attribute
         */
        public void xsetEnterpriseName(org.apache.xmlbeans.XmlString enterpriseName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ENTERPRISENAME$22);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ENTERPRISENAME$22);
                }
                target.set(enterpriseName);
            }
        }
        
        /**
         * Unsets the "enterpriseName" attribute
         */
        public void unsetEnterpriseName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(ENTERPRISENAME$22);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SITEID$24);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SITEID$24);
                return target;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SITEID$24);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SITEID$24);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SITEID$24);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(SITEID$24);
                }
                target.set(siteId);
            }
        }
        
        /**
         * Gets the "siteName" attribute
         */
        public java.lang.String getSiteName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SITENAME$26);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "siteName" attribute
         */
        public org.apache.xmlbeans.XmlString xgetSiteName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SITENAME$26);
                return target;
            }
        }
        
        /**
         * True if has "siteName" attribute
         */
        public boolean isSetSiteName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(SITENAME$26) != null;
            }
        }
        
        /**
         * Sets the "siteName" attribute
         */
        public void setSiteName(java.lang.String siteName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SITENAME$26);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SITENAME$26);
                }
                target.setStringValue(siteName);
            }
        }
        
        /**
         * Sets (as xml) the "siteName" attribute
         */
        public void xsetSiteName(org.apache.xmlbeans.XmlString siteName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SITENAME$26);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(SITENAME$26);
                }
                target.set(siteName);
            }
        }
        
        /**
         * Unsets the "siteName" attribute
         */
        public void unsetSiteName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(SITENAME$26);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TEAMID$28);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TEAMID$28);
                return target;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TEAMID$28);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TEAMID$28);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TEAMID$28);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TEAMID$28);
                }
                target.set(teamId);
            }
        }
        
        /**
         * Gets the "teamName" attribute
         */
        public java.lang.String getTeamName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TEAMNAME$30);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "teamName" attribute
         */
        public org.apache.xmlbeans.XmlString xgetTeamName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TEAMNAME$30);
                return target;
            }
        }
        
        /**
         * True if has "teamName" attribute
         */
        public boolean isSetTeamName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(TEAMNAME$30) != null;
            }
        }
        
        /**
         * Sets the "teamName" attribute
         */
        public void setTeamName(java.lang.String teamName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TEAMNAME$30);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TEAMNAME$30);
                }
                target.setStringValue(teamName);
            }
        }
        
        /**
         * Sets (as xml) the "teamName" attribute
         */
        public void xsetTeamName(org.apache.xmlbeans.XmlString teamName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TEAMNAME$30);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TEAMNAME$30);
                }
                target.set(teamName);
            }
        }
        
        /**
         * Unsets the "teamName" attribute
         */
        public void unsetTeamName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(TEAMNAME$30);
            }
        }
        
        /**
         * Gets the "positionId" attribute
         */
        public java.lang.String getPositionId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(POSITIONID$32);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "positionId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetPositionId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(POSITIONID$32);
                return target;
            }
        }
        
        /**
         * Sets the "positionId" attribute
         */
        public void setPositionId(java.lang.String positionId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(POSITIONID$32);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(POSITIONID$32);
                }
                target.setStringValue(positionId);
            }
        }
        
        /**
         * Sets (as xml) the "positionId" attribute
         */
        public void xsetPositionId(org.apache.xmlbeans.XmlString positionId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(POSITIONID$32);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(POSITIONID$32);
                }
                target.set(positionId);
            }
        }
        
        /**
         * Gets the "dn" attribute
         */
        public java.lang.String getDn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DN$34);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "dn" attribute
         */
        public org.apache.xmlbeans.XmlString xgetDn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(DN$34);
                return target;
            }
        }
        
        /**
         * Sets the "dn" attribute
         */
        public void setDn(java.lang.String dn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DN$34);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DN$34);
                }
                target.setStringValue(dn);
            }
        }
        
        /**
         * Sets (as xml) the "dn" attribute
         */
        public void xsetDn(org.apache.xmlbeans.XmlString dn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(DN$34);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(DN$34);
                }
                target.set(dn);
            }
        }
        
        /**
         * Gets the "status" attribute
         */
        public com.transerainc.aha.gen.agent.StatusType.Enum getStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STATUS$36);
                if (target == null)
                {
                    return null;
                }
                return (com.transerainc.aha.gen.agent.StatusType.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "status" attribute
         */
        public com.transerainc.aha.gen.agent.StatusType xgetStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.StatusType target = null;
                target = (com.transerainc.aha.gen.agent.StatusType)get_store().find_attribute_user(STATUS$36);
                return target;
            }
        }
        
        /**
         * Sets the "status" attribute
         */
        public void setStatus(com.transerainc.aha.gen.agent.StatusType.Enum status)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STATUS$36);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(STATUS$36);
                }
                target.setEnumValue(status);
            }
        }
        
        /**
         * Sets (as xml) the "status" attribute
         */
        public void xsetStatus(com.transerainc.aha.gen.agent.StatusType status)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.StatusType target = null;
                target = (com.transerainc.aha.gen.agent.StatusType)get_store().find_attribute_user(STATUS$36);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.StatusType)get_store().add_attribute_user(STATUS$36);
                }
                target.set(status);
            }
        }
        
        /**
         * Gets the "subStatus" attribute
         */
        public com.transerainc.aha.gen.agent.SubStatusType.Enum getSubStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SUBSTATUS$38);
                if (target == null)
                {
                    return null;
                }
                return (com.transerainc.aha.gen.agent.SubStatusType.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "subStatus" attribute
         */
        public com.transerainc.aha.gen.agent.SubStatusType xgetSubStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.SubStatusType target = null;
                target = (com.transerainc.aha.gen.agent.SubStatusType)get_store().find_attribute_user(SUBSTATUS$38);
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
                return get_store().find_attribute_user(SUBSTATUS$38) != null;
            }
        }
        
        /**
         * Sets the "subStatus" attribute
         */
        public void setSubStatus(com.transerainc.aha.gen.agent.SubStatusType.Enum subStatus)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SUBSTATUS$38);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SUBSTATUS$38);
                }
                target.setEnumValue(subStatus);
            }
        }
        
        /**
         * Sets (as xml) the "subStatus" attribute
         */
        public void xsetSubStatus(com.transerainc.aha.gen.agent.SubStatusType subStatus)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.SubStatusType target = null;
                target = (com.transerainc.aha.gen.agent.SubStatusType)get_store().find_attribute_user(SUBSTATUS$38);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.SubStatusType)get_store().add_attribute_user(SUBSTATUS$38);
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
                get_store().remove_attribute(SUBSTATUS$38);
            }
        }
        
        /**
         * Gets the "groupName" attribute
         */
        public java.lang.String getGroupName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(GROUPNAME$40);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "groupName" attribute
         */
        public org.apache.xmlbeans.XmlString xgetGroupName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(GROUPNAME$40);
                return target;
            }
        }
        
        /**
         * True if has "groupName" attribute
         */
        public boolean isSetGroupName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(GROUPNAME$40) != null;
            }
        }
        
        /**
         * Sets the "groupName" attribute
         */
        public void setGroupName(java.lang.String groupName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(GROUPNAME$40);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(GROUPNAME$40);
                }
                target.setStringValue(groupName);
            }
        }
        
        /**
         * Sets (as xml) the "groupName" attribute
         */
        public void xsetGroupName(org.apache.xmlbeans.XmlString groupName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(GROUPNAME$40);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(GROUPNAME$40);
                }
                target.set(groupName);
            }
        }
        
        /**
         * Unsets the "groupName" attribute
         */
        public void unsetGroupName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(GROUPNAME$40);
            }
        }
        
        /**
         * Gets the "hostIpAddress" attribute
         */
        public java.lang.String getHostIpAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(HOSTIPADDRESS$42);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "hostIpAddress" attribute
         */
        public org.apache.xmlbeans.XmlString xgetHostIpAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(HOSTIPADDRESS$42);
                return target;
            }
        }
        
        /**
         * True if has "hostIpAddress" attribute
         */
        public boolean isSetHostIpAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(HOSTIPADDRESS$42) != null;
            }
        }
        
        /**
         * Sets the "hostIpAddress" attribute
         */
        public void setHostIpAddress(java.lang.String hostIpAddress)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(HOSTIPADDRESS$42);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(HOSTIPADDRESS$42);
                }
                target.setStringValue(hostIpAddress);
            }
        }
        
        /**
         * Sets (as xml) the "hostIpAddress" attribute
         */
        public void xsetHostIpAddress(org.apache.xmlbeans.XmlString hostIpAddress)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(HOSTIPADDRESS$42);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(HOSTIPADDRESS$42);
                }
                target.set(hostIpAddress);
            }
        }
        
        /**
         * Unsets the "hostIpAddress" attribute
         */
        public void unsetHostIpAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(HOSTIPADDRESS$42);
            }
        }
        
        /**
         * Gets the "externalIpAddress" attribute
         */
        public java.lang.String getExternalIpAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(EXTERNALIPADDRESS$44);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "externalIpAddress" attribute
         */
        public org.apache.xmlbeans.XmlString xgetExternalIpAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(EXTERNALIPADDRESS$44);
                return target;
            }
        }
        
        /**
         * True if has "externalIpAddress" attribute
         */
        public boolean isSetExternalIpAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(EXTERNALIPADDRESS$44) != null;
            }
        }
        
        /**
         * Sets the "externalIpAddress" attribute
         */
        public void setExternalIpAddress(java.lang.String externalIpAddress)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(EXTERNALIPADDRESS$44);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(EXTERNALIPADDRESS$44);
                }
                target.setStringValue(externalIpAddress);
            }
        }
        
        /**
         * Sets (as xml) the "externalIpAddress" attribute
         */
        public void xsetExternalIpAddress(org.apache.xmlbeans.XmlString externalIpAddress)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(EXTERNALIPADDRESS$44);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(EXTERNALIPADDRESS$44);
                }
                target.set(externalIpAddress);
            }
        }
        
        /**
         * Unsets the "externalIpAddress" attribute
         */
        public void unsetExternalIpAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(EXTERNALIPADDRESS$44);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TIMESTAMP$46);
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
                target = (org.apache.xmlbeans.XmlLong)get_store().find_attribute_user(TIMESTAMP$46);
                return target;
            }
        }
        
        /**
         * True if has "timestamp" attribute
         */
        public boolean isSetTimestamp()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(TIMESTAMP$46) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TIMESTAMP$46);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TIMESTAMP$46);
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
                target = (org.apache.xmlbeans.XmlLong)get_store().find_attribute_user(TIMESTAMP$46);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlLong)get_store().add_attribute_user(TIMESTAMP$46);
                }
                target.set(timestamp);
            }
        }
        
        /**
         * Unsets the "timestamp" attribute
         */
        public void unsetTimestamp()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(TIMESTAMP$46);
            }
        }
        
        /**
         * Gets the "availableTimestamp" attribute
         */
        public long getAvailableTimestamp()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AVAILABLETIMESTAMP$48);
                if (target == null)
                {
                    return 0L;
                }
                return target.getLongValue();
            }
        }
        
        /**
         * Gets (as xml) the "availableTimestamp" attribute
         */
        public org.apache.xmlbeans.XmlLong xgetAvailableTimestamp()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlLong target = null;
                target = (org.apache.xmlbeans.XmlLong)get_store().find_attribute_user(AVAILABLETIMESTAMP$48);
                return target;
            }
        }
        
        /**
         * True if has "availableTimestamp" attribute
         */
        public boolean isSetAvailableTimestamp()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(AVAILABLETIMESTAMP$48) != null;
            }
        }
        
        /**
         * Sets the "availableTimestamp" attribute
         */
        public void setAvailableTimestamp(long availableTimestamp)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AVAILABLETIMESTAMP$48);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AVAILABLETIMESTAMP$48);
                }
                target.setLongValue(availableTimestamp);
            }
        }
        
        /**
         * Sets (as xml) the "availableTimestamp" attribute
         */
        public void xsetAvailableTimestamp(org.apache.xmlbeans.XmlLong availableTimestamp)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlLong target = null;
                target = (org.apache.xmlbeans.XmlLong)get_store().find_attribute_user(AVAILABLETIMESTAMP$48);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlLong)get_store().add_attribute_user(AVAILABLETIMESTAMP$48);
                }
                target.set(availableTimestamp);
            }
        }
        
        /**
         * Unsets the "availableTimestamp" attribute
         */
        public void unsetAvailableTimestamp()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(AVAILABLETIMESTAMP$48);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CALLID$50);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CALLID$50);
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
                return get_store().find_attribute_user(CALLID$50) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CALLID$50);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CALLID$50);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CALLID$50);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(CALLID$50);
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
                get_store().remove_attribute(CALLID$50);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AEPURL$52);
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
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(AEPURL$52);
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
                return get_store().find_attribute_user(AEPURL$52) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AEPURL$52);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AEPURL$52);
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
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(AEPURL$52);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(AEPURL$52);
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
                get_store().remove_attribute(AEPURL$52);
            }
        }
        
        /**
         * Gets the "retry" attribute
         */
        public boolean getRetry()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(RETRY$54);
                if (target == null)
                {
                    return false;
                }
                return target.getBooleanValue();
            }
        }
        
        /**
         * Gets (as xml) the "retry" attribute
         */
        public org.apache.xmlbeans.XmlBoolean xgetRetry()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(RETRY$54);
                return target;
            }
        }
        
        /**
         * True if has "retry" attribute
         */
        public boolean isSetRetry()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(RETRY$54) != null;
            }
        }
        
        /**
         * Sets the "retry" attribute
         */
        public void setRetry(boolean retry)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(RETRY$54);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(RETRY$54);
                }
                target.setBooleanValue(retry);
            }
        }
        
        /**
         * Sets (as xml) the "retry" attribute
         */
        public void xsetRetry(org.apache.xmlbeans.XmlBoolean retry)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(RETRY$54);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(RETRY$54);
                }
                target.set(retry);
            }
        }
        
        /**
         * Unsets the "retry" attribute
         */
        public void unsetRetry()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(RETRY$54);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTSESSIONID$56);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTSESSIONID$56);
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
                return get_store().find_attribute_user(AGENTSESSIONID$56) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTSESSIONID$56);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AGENTSESSIONID$56);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTSESSIONID$56);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(AGENTSESSIONID$56);
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
                get_store().remove_attribute(AGENTSESSIONID$56);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VIRTUALTEAMID$58);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VIRTUALTEAMID$58);
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
                return get_store().find_attribute_user(VIRTUALTEAMID$58) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VIRTUALTEAMID$58);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VIRTUALTEAMID$58);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VIRTUALTEAMID$58);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(VIRTUALTEAMID$58);
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
                get_store().remove_attribute(VIRTUALTEAMID$58);
            }
        }
        
        /**
         * Gets the "login" attribute
         */
        public boolean getLogin()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LOGIN$60);
                if (target == null)
                {
                    return false;
                }
                return target.getBooleanValue();
            }
        }
        
        /**
         * Gets (as xml) the "login" attribute
         */
        public org.apache.xmlbeans.XmlBoolean xgetLogin()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(LOGIN$60);
                return target;
            }
        }
        
        /**
         * True if has "login" attribute
         */
        public boolean isSetLogin()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(LOGIN$60) != null;
            }
        }
        
        /**
         * Sets the "login" attribute
         */
        public void setLogin(boolean login)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LOGIN$60);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(LOGIN$60);
                }
                target.setBooleanValue(login);
            }
        }
        
        /**
         * Sets (as xml) the "login" attribute
         */
        public void xsetLogin(org.apache.xmlbeans.XmlBoolean login)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(LOGIN$60);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(LOGIN$60);
                }
                target.set(login);
            }
        }
        
        /**
         * Unsets the "login" attribute
         */
        public void unsetLogin()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(LOGIN$60);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REASON$62);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(REASON$62);
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
                return get_store().find_attribute_user(REASON$62) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REASON$62);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(REASON$62);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(REASON$62);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(REASON$62);
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
                get_store().remove_attribute(REASON$62);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CALLLEGID$64);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CALLLEGID$64);
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
                return get_store().find_attribute_user(CALLLEGID$64) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CALLLEGID$64);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CALLLEGID$64);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CALLLEGID$64);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(CALLLEGID$64);
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
                get_store().remove_attribute(CALLLEGID$64);
            }
        }
        
        /**
         * Gets the "ahaurl" attribute
         */
        public java.lang.String getAhaurl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AHAURL$66);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ahaurl" attribute
         */
        public org.apache.xmlbeans.XmlAnyURI xgetAhaurl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(AHAURL$66);
                return target;
            }
        }
        
        /**
         * True if has "ahaurl" attribute
         */
        public boolean isSetAhaurl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(AHAURL$66) != null;
            }
        }
        
        /**
         * Sets the "ahaurl" attribute
         */
        public void setAhaurl(java.lang.String ahaurl)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AHAURL$66);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AHAURL$66);
                }
                target.setStringValue(ahaurl);
            }
        }
        
        /**
         * Sets (as xml) the "ahaurl" attribute
         */
        public void xsetAhaurl(org.apache.xmlbeans.XmlAnyURI ahaurl)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(AHAURL$66);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(AHAURL$66);
                }
                target.set(ahaurl);
            }
        }
        
        /**
         * Unsets the "ahaurl" attribute
         */
        public void unsetAhaurl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(AHAURL$66);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENABLEPAUSERESUME$68);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(ENABLEPAUSERESUME$68);
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
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(ENABLEPAUSERESUME$68);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_default_attribute_value(ENABLEPAUSERESUME$68);
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
                return get_store().find_attribute_user(ENABLEPAUSERESUME$68) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENABLEPAUSERESUME$68);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ENABLEPAUSERESUME$68);
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
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(ENABLEPAUSERESUME$68);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(ENABLEPAUSERESUME$68);
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
                get_store().remove_attribute(ENABLEPAUSERESUME$68);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PAUSEDURATION$70);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(PAUSEDURATION$70);
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
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(PAUSEDURATION$70);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_default_attribute_value(PAUSEDURATION$70);
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
                return get_store().find_attribute_user(PAUSEDURATION$70) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PAUSEDURATION$70);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PAUSEDURATION$70);
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
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(PAUSEDURATION$70);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(PAUSEDURATION$70);
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
                get_store().remove_attribute(PAUSEDURATION$70);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AHAURL$72);
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
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(AHAURL$72);
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
                return get_store().find_attribute_user(AHAURL$72) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AHAURL$72);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AHAURL$72);
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
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(AHAURL$72);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(AHAURL$72);
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
                get_store().remove_attribute(AHAURL$72);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHANNELID$74);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CHANNELID$74);
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
                return get_store().find_attribute_user(CHANNELID$74) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHANNELID$74);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CHANNELID$74);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CHANNELID$74);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(CHANNELID$74);
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
                get_store().remove_attribute(CHANNELID$74);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHANNELTYPE$76);
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
                target = (com.transerainc.aha.gen.agent.ChannelTypes)get_store().find_attribute_user(CHANNELTYPE$76);
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
                return get_store().find_attribute_user(CHANNELTYPE$76) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHANNELTYPE$76);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CHANNELTYPE$76);
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
                target = (com.transerainc.aha.gen.agent.ChannelTypes)get_store().find_attribute_user(CHANNELTYPE$76);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.ChannelTypes)get_store().add_attribute_user(CHANNELTYPE$76);
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
                get_store().remove_attribute(CHANNELTYPE$76);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CODE$78);
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
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(CODE$78);
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
                return get_store().find_attribute_user(CODE$78) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CODE$78);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CODE$78);
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
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(CODE$78);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(CODE$78);
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
                get_store().remove_attribute(CODE$78);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CONSULTCALLID$80);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CONSULTCALLID$80);
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
                return get_store().find_attribute_user(CONSULTCALLID$80) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CONSULTCALLID$80);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CONSULTCALLID$80);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CONSULTCALLID$80);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(CONSULTCALLID$80);
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
                get_store().remove_attribute(CONSULTCALLID$80);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DESTINATIONVIRTUALTEAMID$82);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(DESTINATIONVIRTUALTEAMID$82);
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
                return get_store().find_attribute_user(DESTINATIONVIRTUALTEAMID$82) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DESTINATIONVIRTUALTEAMID$82);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DESTINATIONVIRTUALTEAMID$82);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(DESTINATIONVIRTUALTEAMID$82);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(DESTINATIONVIRTUALTEAMID$82);
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
                get_store().remove_attribute(DESTINATIONVIRTUALTEAMID$82);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERAGENTID$84);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERAGENTID$84);
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
                return get_store().find_attribute_user(PEERAGENTID$84) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERAGENTID$84);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PEERAGENTID$84);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERAGENTID$84);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PEERAGENTID$84);
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
                get_store().remove_attribute(PEERAGENTID$84);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERTEAMID$86);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERTEAMID$86);
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
                return get_store().find_attribute_user(PEERTEAMID$86) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERTEAMID$86);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PEERTEAMID$86);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERTEAMID$86);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PEERTEAMID$86);
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
                get_store().remove_attribute(PEERTEAMID$86);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERSITEID$88);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERSITEID$88);
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
                return get_store().find_attribute_user(PEERSITEID$88) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERSITEID$88);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PEERSITEID$88);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERSITEID$88);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PEERSITEID$88);
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
                get_store().remove_attribute(PEERSITEID$88);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERDN$90);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERDN$90);
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
                return get_store().find_attribute_user(PEERDN$90) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERDN$90);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PEERDN$90);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERDN$90);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PEERDN$90);
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
                get_store().remove_attribute(PEERDN$90);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERAGENTNAME$92);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERAGENTNAME$92);
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
                return get_store().find_attribute_user(PEERAGENTNAME$92) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERAGENTNAME$92);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PEERAGENTNAME$92);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERAGENTNAME$92);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PEERAGENTNAME$92);
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
                get_store().remove_attribute(PEERAGENTNAME$92);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERAGENTSESSIONID$94);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERAGENTSESSIONID$94);
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
                return get_store().find_attribute_user(PEERAGENTSESSIONID$94) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERAGENTSESSIONID$94);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PEERAGENTSESSIONID$94);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERAGENTSESSIONID$94);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PEERAGENTSESSIONID$94);
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
                get_store().remove_attribute(PEERAGENTSESSIONID$94);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERCHANNELID$96);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERCHANNELID$96);
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
                return get_store().find_attribute_user(PEERCHANNELID$96) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERCHANNELID$96);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PEERCHANNELID$96);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERCHANNELID$96);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PEERCHANNELID$96);
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
                get_store().remove_attribute(PEERCHANNELID$96);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERCHANNELTYPE$98);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERCHANNELTYPE$98);
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
                return get_store().find_attribute_user(PEERCHANNELTYPE$98) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PEERCHANNELTYPE$98);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PEERCHANNELTYPE$98);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PEERCHANNELTYPE$98);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PEERCHANNELTYPE$98);
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
                get_store().remove_attribute(PEERCHANNELTYPE$98);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TRANSFERENABLED$100);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(TRANSFERENABLED$100);
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
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(TRANSFERENABLED$100);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_default_attribute_value(TRANSFERENABLED$100);
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
                return get_store().find_attribute_user(TRANSFERENABLED$100) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TRANSFERENABLED$100);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TRANSFERENABLED$100);
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
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(TRANSFERENABLED$100);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(TRANSFERENABLED$100);
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
                get_store().remove_attribute(TRANSFERENABLED$100);
            }
        }
    }
}
