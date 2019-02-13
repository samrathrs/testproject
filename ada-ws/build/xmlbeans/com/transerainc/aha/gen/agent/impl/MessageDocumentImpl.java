/*
 * An XML document type.
 * Localname: message
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.MessageDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one message(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class MessageDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.MessageDocument
{
    private static final long serialVersionUID = 1L;
    
    public MessageDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MESSAGE$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "message");
    
    
    /**
     * Gets the "message" element
     */
    public com.transerainc.aha.gen.agent.MessageDocument.Message getMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.MessageDocument.Message target = null;
            target = (com.transerainc.aha.gen.agent.MessageDocument.Message)get_store().find_element_user(MESSAGE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "message" element
     */
    public void setMessage(com.transerainc.aha.gen.agent.MessageDocument.Message message)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.MessageDocument.Message target = null;
            target = (com.transerainc.aha.gen.agent.MessageDocument.Message)get_store().find_element_user(MESSAGE$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.MessageDocument.Message)get_store().add_element_user(MESSAGE$0);
            }
            target.set(message);
        }
    }
    
    /**
     * Appends and returns a new empty "message" element
     */
    public com.transerainc.aha.gen.agent.MessageDocument.Message addNewMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.MessageDocument.Message target = null;
            target = (com.transerainc.aha.gen.agent.MessageDocument.Message)get_store().add_element_user(MESSAGE$0);
            return target;
        }
    }
    /**
     * An XML message(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class MessageImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.MessageDocument.Message
    {
        private static final long serialVersionUID = 1L;
        
        public MessageImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName AGENTID$0 = 
            new javax.xml.namespace.QName("", "agentId");
        private static final javax.xml.namespace.QName ENTERPRISEID$2 = 
            new javax.xml.namespace.QName("", "enterpriseId");
        private static final javax.xml.namespace.QName TEXT$4 = 
            new javax.xml.namespace.QName("", "text");
        private static final javax.xml.namespace.QName TYPE$6 = 
            new javax.xml.namespace.QName("", "type");
        private static final javax.xml.namespace.QName FROM$8 = 
            new javax.xml.namespace.QName("", "from");
        private static final javax.xml.namespace.QName TO$10 = 
            new javax.xml.namespace.QName("", "to");
        private static final javax.xml.namespace.QName CHANNELID$12 = 
            new javax.xml.namespace.QName("", "channelId");
        private static final javax.xml.namespace.QName CHANNELTYPE$14 = 
            new javax.xml.namespace.QName("", "channelType");
        private static final javax.xml.namespace.QName CALLID$16 = 
            new javax.xml.namespace.QName("", "callId");
        
        
        /**
         * Gets the "agentId" attribute
         */
        public java.lang.String getAgentId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTID$0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTID$0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTID$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AGENTID$0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTID$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(AGENTID$0);
                }
                target.set(agentId);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENTERPRISEID$2);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ENTERPRISEID$2);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENTERPRISEID$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ENTERPRISEID$2);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ENTERPRISEID$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ENTERPRISEID$2);
                }
                target.set(enterpriseId);
            }
        }
        
        /**
         * Gets the "text" attribute
         */
        public java.lang.String getText()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TEXT$4);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "text" attribute
         */
        public org.apache.xmlbeans.XmlString xgetText()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TEXT$4);
                return target;
            }
        }
        
        /**
         * True if has "text" attribute
         */
        public boolean isSetText()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(TEXT$4) != null;
            }
        }
        
        /**
         * Sets the "text" attribute
         */
        public void setText(java.lang.String text)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TEXT$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TEXT$4);
                }
                target.setStringValue(text);
            }
        }
        
        /**
         * Sets (as xml) the "text" attribute
         */
        public void xsetText(org.apache.xmlbeans.XmlString text)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TEXT$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TEXT$4);
                }
                target.set(text);
            }
        }
        
        /**
         * Unsets the "text" attribute
         */
        public void unsetText()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(TEXT$4);
            }
        }
        
        /**
         * Gets the "type" attribute
         */
        public com.transerainc.aha.gen.agent.MessageType.Enum getType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TYPE$6);
                if (target == null)
                {
                    return null;
                }
                return (com.transerainc.aha.gen.agent.MessageType.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "type" attribute
         */
        public com.transerainc.aha.gen.agent.MessageType xgetType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.MessageType target = null;
                target = (com.transerainc.aha.gen.agent.MessageType)get_store().find_attribute_user(TYPE$6);
                return target;
            }
        }
        
        /**
         * True if has "type" attribute
         */
        public boolean isSetType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(TYPE$6) != null;
            }
        }
        
        /**
         * Sets the "type" attribute
         */
        public void setType(com.transerainc.aha.gen.agent.MessageType.Enum type)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TYPE$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TYPE$6);
                }
                target.setEnumValue(type);
            }
        }
        
        /**
         * Sets (as xml) the "type" attribute
         */
        public void xsetType(com.transerainc.aha.gen.agent.MessageType type)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.MessageType target = null;
                target = (com.transerainc.aha.gen.agent.MessageType)get_store().find_attribute_user(TYPE$6);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.MessageType)get_store().add_attribute_user(TYPE$6);
                }
                target.set(type);
            }
        }
        
        /**
         * Unsets the "type" attribute
         */
        public void unsetType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(TYPE$6);
            }
        }
        
        /**
         * Gets the "from" attribute
         */
        public java.lang.String getFrom()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FROM$8);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "from" attribute
         */
        public org.apache.xmlbeans.XmlString xgetFrom()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(FROM$8);
                return target;
            }
        }
        
        /**
         * True if has "from" attribute
         */
        public boolean isSetFrom()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(FROM$8) != null;
            }
        }
        
        /**
         * Sets the "from" attribute
         */
        public void setFrom(java.lang.String from)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FROM$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(FROM$8);
                }
                target.setStringValue(from);
            }
        }
        
        /**
         * Sets (as xml) the "from" attribute
         */
        public void xsetFrom(org.apache.xmlbeans.XmlString from)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(FROM$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(FROM$8);
                }
                target.set(from);
            }
        }
        
        /**
         * Unsets the "from" attribute
         */
        public void unsetFrom()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(FROM$8);
            }
        }
        
        /**
         * Gets the "to" attribute
         */
        public java.lang.String getTo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TO$10);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "to" attribute
         */
        public org.apache.xmlbeans.XmlString xgetTo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TO$10);
                return target;
            }
        }
        
        /**
         * True if has "to" attribute
         */
        public boolean isSetTo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(TO$10) != null;
            }
        }
        
        /**
         * Sets the "to" attribute
         */
        public void setTo(java.lang.String to)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TO$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TO$10);
                }
                target.setStringValue(to);
            }
        }
        
        /**
         * Sets (as xml) the "to" attribute
         */
        public void xsetTo(org.apache.xmlbeans.XmlString to)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TO$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TO$10);
                }
                target.set(to);
            }
        }
        
        /**
         * Unsets the "to" attribute
         */
        public void unsetTo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(TO$10);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHANNELID$12);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CHANNELID$12);
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
                return get_store().find_attribute_user(CHANNELID$12) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHANNELID$12);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CHANNELID$12);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CHANNELID$12);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(CHANNELID$12);
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
                get_store().remove_attribute(CHANNELID$12);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHANNELTYPE$14);
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
                target = (com.transerainc.aha.gen.agent.ChannelTypes)get_store().find_attribute_user(CHANNELTYPE$14);
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
                return get_store().find_attribute_user(CHANNELTYPE$14) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHANNELTYPE$14);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CHANNELTYPE$14);
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
                target = (com.transerainc.aha.gen.agent.ChannelTypes)get_store().find_attribute_user(CHANNELTYPE$14);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.ChannelTypes)get_store().add_attribute_user(CHANNELTYPE$14);
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
                get_store().remove_attribute(CHANNELTYPE$14);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CALLID$16);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CALLID$16);
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
                return get_store().find_attribute_user(CALLID$16) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CALLID$16);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CALLID$16);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CALLID$16);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(CALLID$16);
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
                get_store().remove_attribute(CALLID$16);
            }
        }
    }
}
