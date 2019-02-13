/*
 * An XML document type.
 * Localname: channel-set
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.ChannelSetDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one channel-set(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class ChannelSetDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.ChannelSetDocument
{
    private static final long serialVersionUID = 1L;
    
    public ChannelSetDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CHANNELSET$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "channel-set");
    
    
    /**
     * Gets the "channel-set" element
     */
    public com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet getChannelSet()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet target = null;
            target = (com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet)get_store().find_element_user(CHANNELSET$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
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
            target = (com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet)get_store().find_element_user(CHANNELSET$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet)get_store().add_element_user(CHANNELSET$0);
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
            target = (com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet)get_store().add_element_user(CHANNELSET$0);
            return target;
        }
    }
    /**
     * An XML channel-set(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class ChannelSetImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet
    {
        private static final long serialVersionUID = 1L;
        
        public ChannelSetImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CHANNEL$0 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "channel");
        private static final javax.xml.namespace.QName PROFILEID$2 = 
            new javax.xml.namespace.QName("", "profile-id");
        private static final javax.xml.namespace.QName PROFILENAME$4 = 
            new javax.xml.namespace.QName("", "profile-name");
        private static final javax.xml.namespace.QName TENANTID$6 = 
            new javax.xml.namespace.QName("", "tenantId");
        
        
        /**
         * Gets array of all "channel" elements
         */
        public com.transerainc.aha.gen.agent.ChannelDocument.Channel[] getChannelArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(CHANNEL$0, targetList);
                com.transerainc.aha.gen.agent.ChannelDocument.Channel[] result = new com.transerainc.aha.gen.agent.ChannelDocument.Channel[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "channel" element
         */
        public com.transerainc.aha.gen.agent.ChannelDocument.Channel getChannelArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ChannelDocument.Channel target = null;
                target = (com.transerainc.aha.gen.agent.ChannelDocument.Channel)get_store().find_element_user(CHANNEL$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "channel" element
         */
        public int sizeOfChannelArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(CHANNEL$0);
            }
        }
        
        /**
         * Sets array of all "channel" element
         */
        public void setChannelArray(com.transerainc.aha.gen.agent.ChannelDocument.Channel[] channelArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(channelArray, CHANNEL$0);
            }
        }
        
        /**
         * Sets ith "channel" element
         */
        public void setChannelArray(int i, com.transerainc.aha.gen.agent.ChannelDocument.Channel channel)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ChannelDocument.Channel target = null;
                target = (com.transerainc.aha.gen.agent.ChannelDocument.Channel)get_store().find_element_user(CHANNEL$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(channel);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "channel" element
         */
        public com.transerainc.aha.gen.agent.ChannelDocument.Channel insertNewChannel(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ChannelDocument.Channel target = null;
                target = (com.transerainc.aha.gen.agent.ChannelDocument.Channel)get_store().insert_element_user(CHANNEL$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "channel" element
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
         * Removes the ith "channel" element
         */
        public void removeChannel(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(CHANNEL$0, i);
            }
        }
        
        /**
         * Gets the "profile-id" attribute
         */
        public java.lang.String getProfileId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROFILEID$2);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "profile-id" attribute
         */
        public org.apache.xmlbeans.XmlString xgetProfileId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROFILEID$2);
                return target;
            }
        }
        
        /**
         * True if has "profile-id" attribute
         */
        public boolean isSetProfileId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(PROFILEID$2) != null;
            }
        }
        
        /**
         * Sets the "profile-id" attribute
         */
        public void setProfileId(java.lang.String profileId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROFILEID$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PROFILEID$2);
                }
                target.setStringValue(profileId);
            }
        }
        
        /**
         * Sets (as xml) the "profile-id" attribute
         */
        public void xsetProfileId(org.apache.xmlbeans.XmlString profileId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROFILEID$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PROFILEID$2);
                }
                target.set(profileId);
            }
        }
        
        /**
         * Unsets the "profile-id" attribute
         */
        public void unsetProfileId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(PROFILEID$2);
            }
        }
        
        /**
         * Gets the "profile-name" attribute
         */
        public java.lang.String getProfileName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROFILENAME$4);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "profile-name" attribute
         */
        public org.apache.xmlbeans.XmlString xgetProfileName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROFILENAME$4);
                return target;
            }
        }
        
        /**
         * True if has "profile-name" attribute
         */
        public boolean isSetProfileName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(PROFILENAME$4) != null;
            }
        }
        
        /**
         * Sets the "profile-name" attribute
         */
        public void setProfileName(java.lang.String profileName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROFILENAME$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PROFILENAME$4);
                }
                target.setStringValue(profileName);
            }
        }
        
        /**
         * Sets (as xml) the "profile-name" attribute
         */
        public void xsetProfileName(org.apache.xmlbeans.XmlString profileName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROFILENAME$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PROFILENAME$4);
                }
                target.set(profileName);
            }
        }
        
        /**
         * Unsets the "profile-name" attribute
         */
        public void unsetProfileName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(PROFILENAME$4);
            }
        }
        
        /**
         * Gets the "tenantId" attribute
         */
        public java.lang.String getTenantId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TENANTID$6);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "tenantId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetTenantId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TENANTID$6);
                return target;
            }
        }
        
        /**
         * True if has "tenantId" attribute
         */
        public boolean isSetTenantId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(TENANTID$6) != null;
            }
        }
        
        /**
         * Sets the "tenantId" attribute
         */
        public void setTenantId(java.lang.String tenantId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TENANTID$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TENANTID$6);
                }
                target.setStringValue(tenantId);
            }
        }
        
        /**
         * Sets (as xml) the "tenantId" attribute
         */
        public void xsetTenantId(org.apache.xmlbeans.XmlString tenantId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TENANTID$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TENANTID$6);
                }
                target.set(tenantId);
            }
        }
        
        /**
         * Unsets the "tenantId" attribute
         */
        public void unsetTenantId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(TENANTID$6);
            }
        }
    }
}
