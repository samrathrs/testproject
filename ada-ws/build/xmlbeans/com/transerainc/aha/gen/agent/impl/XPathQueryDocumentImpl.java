/*
 * An XML document type.
 * Localname: xPathQuery
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.XPathQueryDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one xPathQuery(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class XPathQueryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.XPathQueryDocument
{
    private static final long serialVersionUID = 1L;
    
    public XPathQueryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName XPATHQUERY$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "xPathQuery");
    
    
    /**
     * Gets the "xPathQuery" element
     */
    public com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery getXPathQuery()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery target = null;
            target = (com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery)get_store().find_element_user(XPATHQUERY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "xPathQuery" element
     */
    public void setXPathQuery(com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery xPathQuery)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery target = null;
            target = (com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery)get_store().find_element_user(XPATHQUERY$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery)get_store().add_element_user(XPATHQUERY$0);
            }
            target.set(xPathQuery);
        }
    }
    
    /**
     * Appends and returns a new empty "xPathQuery" element
     */
    public com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery addNewXPathQuery()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery target = null;
            target = (com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery)get_store().add_element_user(XPATHQUERY$0);
            return target;
        }
    }
    /**
     * An XML xPathQuery(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class XPathQueryImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery
    {
        private static final long serialVersionUID = 1L;
        
        public XPathQueryImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName REQUESTID$0 = 
            new javax.xml.namespace.QName("", "requestId");
        private static final javax.xml.namespace.QName AGENTID$2 = 
            new javax.xml.namespace.QName("", "agentId");
        private static final javax.xml.namespace.QName QUERYSTRING$4 = 
            new javax.xml.namespace.QName("", "queryString");
        private static final javax.xml.namespace.QName CHANNELID$6 = 
            new javax.xml.namespace.QName("", "channelId");
        private static final javax.xml.namespace.QName CHANNELTYPE$8 = 
            new javax.xml.namespace.QName("", "channelType");
        
        
        /**
         * Gets the "requestId" attribute
         */
        public java.lang.String getRequestId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REQUESTID$0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(REQUESTID$0);
                return target;
            }
        }
        
        /**
         * True if has "requestId" attribute
         */
        public boolean isSetRequestId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(REQUESTID$0) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REQUESTID$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(REQUESTID$0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(REQUESTID$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(REQUESTID$0);
                }
                target.set(requestId);
            }
        }
        
        /**
         * Unsets the "requestId" attribute
         */
        public void unsetRequestId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(REQUESTID$0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTID$2);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTID$2);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTID$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AGENTID$2);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTID$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(AGENTID$2);
                }
                target.set(agentId);
            }
        }
        
        /**
         * Gets the "queryString" attribute
         */
        public java.lang.String getQueryString()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(QUERYSTRING$4);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "queryString" attribute
         */
        public org.apache.xmlbeans.XmlString xgetQueryString()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(QUERYSTRING$4);
                return target;
            }
        }
        
        /**
         * Sets the "queryString" attribute
         */
        public void setQueryString(java.lang.String queryString)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(QUERYSTRING$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(QUERYSTRING$4);
                }
                target.setStringValue(queryString);
            }
        }
        
        /**
         * Sets (as xml) the "queryString" attribute
         */
        public void xsetQueryString(org.apache.xmlbeans.XmlString queryString)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(QUERYSTRING$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(QUERYSTRING$4);
                }
                target.set(queryString);
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
