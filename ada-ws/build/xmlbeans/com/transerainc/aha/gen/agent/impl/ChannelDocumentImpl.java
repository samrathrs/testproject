/*
 * An XML document type.
 * Localname: channel
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.ChannelDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one channel(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class ChannelDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.ChannelDocument
{
    private static final long serialVersionUID = 1L;
    
    public ChannelDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CHANNEL$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "channel");
    
    
    /**
     * Gets the "channel" element
     */
    public com.transerainc.aha.gen.agent.ChannelDocument.Channel getChannel()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.ChannelDocument.Channel target = null;
            target = (com.transerainc.aha.gen.agent.ChannelDocument.Channel)get_store().find_element_user(CHANNEL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "channel" element
     */
    public void setChannel(com.transerainc.aha.gen.agent.ChannelDocument.Channel channel)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.ChannelDocument.Channel target = null;
            target = (com.transerainc.aha.gen.agent.ChannelDocument.Channel)get_store().find_element_user(CHANNEL$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.ChannelDocument.Channel)get_store().add_element_user(CHANNEL$0);
            }
            target.set(channel);
        }
    }
    
    /**
     * Appends and returns a new empty "channel" element
     */
    public com.transerainc.aha.gen.agent.ChannelDocument.Channel addNewChannel()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.ChannelDocument.Channel target = null;
            target = (com.transerainc.aha.gen.agent.ChannelDocument.Channel)get_store().add_element_user(CHANNEL$0);
            return target;
        }
    }
    /**
     * An XML channel(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class ChannelImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.ChannelDocument.Channel
    {
        private static final long serialVersionUID = 1L;
        
        public ChannelImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ID$0 = 
            new javax.xml.namespace.QName("", "id");
        private static final javax.xml.namespace.QName TYPE$2 = 
            new javax.xml.namespace.QName("", "type");
        private static final javax.xml.namespace.QName AGENTID$4 = 
            new javax.xml.namespace.QName("", "agentId");
        private static final javax.xml.namespace.QName TEAMID$6 = 
            new javax.xml.namespace.QName("", "teamId");
        
        
        /**
         * Gets the "id" attribute
         */
        public java.lang.String getId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "id" attribute
         */
        public org.apache.xmlbeans.XmlString xgetId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$0);
                return target;
            }
        }
        
        /**
         * Sets the "id" attribute
         */
        public void setId(java.lang.String id)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ID$0);
                }
                target.setStringValue(id);
            }
        }
        
        /**
         * Sets (as xml) the "id" attribute
         */
        public void xsetId(org.apache.xmlbeans.XmlString id)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ID$0);
                }
                target.set(id);
            }
        }
        
        /**
         * Gets the "type" attribute
         */
        public com.transerainc.aha.gen.agent.ChannelTypes.Enum getType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TYPE$2);
                if (target == null)
                {
                    return null;
                }
                return (com.transerainc.aha.gen.agent.ChannelTypes.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "type" attribute
         */
        public com.transerainc.aha.gen.agent.ChannelTypes xgetType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ChannelTypes target = null;
                target = (com.transerainc.aha.gen.agent.ChannelTypes)get_store().find_attribute_user(TYPE$2);
                return target;
            }
        }
        
        /**
         * Sets the "type" attribute
         */
        public void setType(com.transerainc.aha.gen.agent.ChannelTypes.Enum type)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TYPE$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TYPE$2);
                }
                target.setEnumValue(type);
            }
        }
        
        /**
         * Sets (as xml) the "type" attribute
         */
        public void xsetType(com.transerainc.aha.gen.agent.ChannelTypes type)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ChannelTypes target = null;
                target = (com.transerainc.aha.gen.agent.ChannelTypes)get_store().find_attribute_user(TYPE$2);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.ChannelTypes)get_store().add_attribute_user(TYPE$2);
                }
                target.set(type);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTID$4);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTID$4);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTID$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AGENTID$4);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTID$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(AGENTID$4);
                }
                target.set(agentId);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TEAMID$6);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TEAMID$6);
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
                return get_store().find_attribute_user(TEAMID$6) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TEAMID$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TEAMID$6);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TEAMID$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TEAMID$6);
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
                get_store().remove_attribute(TEAMID$6);
            }
        }
    }
}
