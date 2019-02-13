/*
 * An XML document type.
 * Localname: xPathQueryResult
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.XPathQueryResultDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one xPathQueryResult(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class XPathQueryResultDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.XPathQueryResultDocument
{
    private static final long serialVersionUID = 1L;
    
    public XPathQueryResultDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName XPATHQUERYRESULT$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "xPathQueryResult");
    
    
    /**
     * Gets the "xPathQueryResult" element
     */
    public com.transerainc.aha.gen.agent.XPathQueryResultDocument.XPathQueryResult getXPathQueryResult()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.XPathQueryResultDocument.XPathQueryResult target = null;
            target = (com.transerainc.aha.gen.agent.XPathQueryResultDocument.XPathQueryResult)get_store().find_element_user(XPATHQUERYRESULT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "xPathQueryResult" element
     */
    public void setXPathQueryResult(com.transerainc.aha.gen.agent.XPathQueryResultDocument.XPathQueryResult xPathQueryResult)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.XPathQueryResultDocument.XPathQueryResult target = null;
            target = (com.transerainc.aha.gen.agent.XPathQueryResultDocument.XPathQueryResult)get_store().find_element_user(XPATHQUERYRESULT$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.XPathQueryResultDocument.XPathQueryResult)get_store().add_element_user(XPATHQUERYRESULT$0);
            }
            target.set(xPathQueryResult);
        }
    }
    
    /**
     * Appends and returns a new empty "xPathQueryResult" element
     */
    public com.transerainc.aha.gen.agent.XPathQueryResultDocument.XPathQueryResult addNewXPathQueryResult()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.XPathQueryResultDocument.XPathQueryResult target = null;
            target = (com.transerainc.aha.gen.agent.XPathQueryResultDocument.XPathQueryResult)get_store().add_element_user(XPATHQUERYRESULT$0);
            return target;
        }
    }
    /**
     * An XML xPathQueryResult(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class XPathQueryResultImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.XPathQueryResultDocument.XPathQueryResult
    {
        private static final long serialVersionUID = 1L;
        
        public XPathQueryResultImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName AGENTS$0 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "agents");
        private static final javax.xml.namespace.QName VIRTUALTEAMLIST$2 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "virtualTeamList");
        private static final javax.xml.namespace.QName REQUESTID$4 = 
            new javax.xml.namespace.QName("", "requestId");
        private static final javax.xml.namespace.QName CHANNELID$6 = 
            new javax.xml.namespace.QName("", "channelId");
        private static final javax.xml.namespace.QName CHANNELTYPE$8 = 
            new javax.xml.namespace.QName("", "channelType");
        
        
        /**
         * Gets the "agents" element
         */
        public com.transerainc.aha.gen.agent.AgentsDocument.Agents getAgents()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AgentsDocument.Agents target = null;
                target = (com.transerainc.aha.gen.agent.AgentsDocument.Agents)get_store().find_element_user(AGENTS$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "agents" element
         */
        public boolean isSetAgents()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(AGENTS$0) != 0;
            }
        }
        
        /**
         * Sets the "agents" element
         */
        public void setAgents(com.transerainc.aha.gen.agent.AgentsDocument.Agents agents)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AgentsDocument.Agents target = null;
                target = (com.transerainc.aha.gen.agent.AgentsDocument.Agents)get_store().find_element_user(AGENTS$0, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.AgentsDocument.Agents)get_store().add_element_user(AGENTS$0);
                }
                target.set(agents);
            }
        }
        
        /**
         * Appends and returns a new empty "agents" element
         */
        public com.transerainc.aha.gen.agent.AgentsDocument.Agents addNewAgents()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AgentsDocument.Agents target = null;
                target = (com.transerainc.aha.gen.agent.AgentsDocument.Agents)get_store().add_element_user(AGENTS$0);
                return target;
            }
        }
        
        /**
         * Unsets the "agents" element
         */
        public void unsetAgents()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(AGENTS$0, 0);
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
                target = (com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList)get_store().find_element_user(VIRTUALTEAMLIST$2, 0);
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
                return get_store().count_elements(VIRTUALTEAMLIST$2) != 0;
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
                target = (com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList)get_store().find_element_user(VIRTUALTEAMLIST$2, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList)get_store().add_element_user(VIRTUALTEAMLIST$2);
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
                target = (com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList)get_store().add_element_user(VIRTUALTEAMLIST$2);
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
                get_store().remove_element(VIRTUALTEAMLIST$2, 0);
            }
        }
        
        /**
         * Gets the "requestId" attribute
         */
        public java.lang.String getRequestId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REQUESTID$4);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "requestId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetRequestId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(REQUESTID$4);
                return target;
            }
        }
        
        /**
         * Sets the "requestId" attribute
         */
        public void setRequestId(java.lang.String requestId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REQUESTID$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(REQUESTID$4);
                }
                target.setStringValue(requestId);
            }
        }
        
        /**
         * Sets (as xml) the "requestId" attribute
         */
        public void xsetRequestId(org.apache.xmlbeans.XmlString requestId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(REQUESTID$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(REQUESTID$4);
                }
                target.set(requestId);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHANNELID$6);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CHANNELID$6);
                return target;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHANNELID$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CHANNELID$6);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CHANNELID$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(CHANNELID$6);
                }
                target.set(channelId);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHANNELTYPE$8);
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
                target = (com.transerainc.aha.gen.agent.ChannelTypes)get_store().find_attribute_user(CHANNELTYPE$8);
                return target;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHANNELTYPE$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CHANNELTYPE$8);
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
                target = (com.transerainc.aha.gen.agent.ChannelTypes)get_store().find_attribute_user(CHANNELTYPE$8);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.ChannelTypes)get_store().add_attribute_user(CHANNELTYPE$8);
                }
                target.set(channelType);
            }
        }
    }
}
