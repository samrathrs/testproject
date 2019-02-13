/*
 * An XML document type.
 * Localname: channel-set
 * Namespace: http://agent.transerainc.com/profile
 * Java type: com.transerainc.agent.profile.ChannelSetDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.agent.profile.impl;
/**
 * A document containing one channel-set(@http://agent.transerainc.com/profile) element.
 *
 * This is a complex type.
 */
public class ChannelSetDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.agent.profile.ChannelSetDocument
{
    private static final long serialVersionUID = 1L;
    
    public ChannelSetDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CHANNELSET$0 = 
        new javax.xml.namespace.QName("http://agent.transerainc.com/profile", "channel-set");
    
    
    /**
     * Gets the "channel-set" element
     */
    public com.transerainc.agent.profile.ChannelSetDocument.ChannelSet getChannelSet()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.ChannelSetDocument.ChannelSet target = null;
            target = (com.transerainc.agent.profile.ChannelSetDocument.ChannelSet)get_store().find_element_user(CHANNELSET$0, 0);
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
    public void setChannelSet(com.transerainc.agent.profile.ChannelSetDocument.ChannelSet channelSet)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.ChannelSetDocument.ChannelSet target = null;
            target = (com.transerainc.agent.profile.ChannelSetDocument.ChannelSet)get_store().find_element_user(CHANNELSET$0, 0);
            if (target == null)
            {
                target = (com.transerainc.agent.profile.ChannelSetDocument.ChannelSet)get_store().add_element_user(CHANNELSET$0);
            }
            target.set(channelSet);
        }
    }
    
    /**
     * Appends and returns a new empty "channel-set" element
     */
    public com.transerainc.agent.profile.ChannelSetDocument.ChannelSet addNewChannelSet()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.ChannelSetDocument.ChannelSet target = null;
            target = (com.transerainc.agent.profile.ChannelSetDocument.ChannelSet)get_store().add_element_user(CHANNELSET$0);
            return target;
        }
    }
    /**
     * An XML channel-set(@http://agent.transerainc.com/profile).
     *
     * This is a complex type.
     */
    public static class ChannelSetImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.agent.profile.ChannelSetDocument.ChannelSet
    {
        private static final long serialVersionUID = 1L;
        
        public ChannelSetImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CHANNEL$0 = 
            new javax.xml.namespace.QName("http://agent.transerainc.com/profile", "channel");
        private static final javax.xml.namespace.QName PROFILEID$2 = 
            new javax.xml.namespace.QName("", "profile-id");
        private static final javax.xml.namespace.QName PROFILENAME$4 = 
            new javax.xml.namespace.QName("", "profile-name");
        
        
        /**
         * Gets array of all "channel" elements
         */
        public com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel[] getChannelArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(CHANNEL$0, targetList);
                com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel[] result = new com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "channel" element
         */
        public com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel getChannelArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel target = null;
                target = (com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel)get_store().find_element_user(CHANNEL$0, i);
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
        public void setChannelArray(com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel[] channelArray)
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
        public void setChannelArray(int i, com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel channel)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel target = null;
                target = (com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel)get_store().find_element_user(CHANNEL$0, i);
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
        public com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel insertNewChannel(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel target = null;
                target = (com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel)get_store().insert_element_user(CHANNEL$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "channel" element
         */
        public com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel addNewChannel()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel target = null;
                target = (com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel)get_store().add_element_user(CHANNEL$0);
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
         * An XML channel(@http://agent.transerainc.com/profile).
         *
         * This is a complex type.
         */
        public static class ChannelImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel
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
            public com.transerainc.agent.profile.ChannelTypes.Enum getType()
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
                    return (com.transerainc.agent.profile.ChannelTypes.Enum)target.getEnumValue();
                }
            }
            
            /**
             * Gets (as xml) the "type" attribute
             */
            public com.transerainc.agent.profile.ChannelTypes xgetType()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    com.transerainc.agent.profile.ChannelTypes target = null;
                    target = (com.transerainc.agent.profile.ChannelTypes)get_store().find_attribute_user(TYPE$2);
                    return target;
                }
            }
            
            /**
             * Sets the "type" attribute
             */
            public void setType(com.transerainc.agent.profile.ChannelTypes.Enum type)
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
            public void xsetType(com.transerainc.agent.profile.ChannelTypes type)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    com.transerainc.agent.profile.ChannelTypes target = null;
                    target = (com.transerainc.agent.profile.ChannelTypes)get_store().find_attribute_user(TYPE$2);
                    if (target == null)
                    {
                      target = (com.transerainc.agent.profile.ChannelTypes)get_store().add_attribute_user(TYPE$2);
                    }
                    target.set(type);
                }
            }
        }
    }
}
