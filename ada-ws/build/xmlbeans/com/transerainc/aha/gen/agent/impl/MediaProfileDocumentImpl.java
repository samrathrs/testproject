/*
 * An XML document type.
 * Localname: media-profile
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.MediaProfileDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one media-profile(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class MediaProfileDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.MediaProfileDocument
{
    private static final long serialVersionUID = 1L;
    
    public MediaProfileDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MEDIAPROFILE$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "media-profile");
    
    
    /**
     * Gets the "media-profile" element
     */
    public com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile getMediaProfile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile target = null;
            target = (com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile)get_store().find_element_user(MEDIAPROFILE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "media-profile" element
     */
    public void setMediaProfile(com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile mediaProfile)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile target = null;
            target = (com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile)get_store().find_element_user(MEDIAPROFILE$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile)get_store().add_element_user(MEDIAPROFILE$0);
            }
            target.set(mediaProfile);
        }
    }
    
    /**
     * Appends and returns a new empty "media-profile" element
     */
    public com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile addNewMediaProfile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile target = null;
            target = (com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile)get_store().add_element_user(MEDIAPROFILE$0);
            return target;
        }
    }
    /**
     * An XML media-profile(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class MediaProfileImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile
    {
        private static final long serialVersionUID = 1L;
        
        public MediaProfileImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName TELEPHONY$0 = 
            new javax.xml.namespace.QName("", "telephony");
        private static final javax.xml.namespace.QName EMAIL$2 = 
            new javax.xml.namespace.QName("", "email");
        private static final javax.xml.namespace.QName FAX$4 = 
            new javax.xml.namespace.QName("", "fax");
        private static final javax.xml.namespace.QName CHAT$6 = 
            new javax.xml.namespace.QName("", "chat");
        private static final javax.xml.namespace.QName VIDEO$8 = 
            new javax.xml.namespace.QName("", "video");
        private static final javax.xml.namespace.QName OTHER$10 = 
            new javax.xml.namespace.QName("", "other");
        private static final javax.xml.namespace.QName ID$12 = 
            new javax.xml.namespace.QName("", "id");
        private static final javax.xml.namespace.QName NAME$14 = 
            new javax.xml.namespace.QName("", "name");
        private static final javax.xml.namespace.QName AGENTID$16 = 
            new javax.xml.namespace.QName("", "agentId");
        private static final javax.xml.namespace.QName TENANTID$18 = 
            new javax.xml.namespace.QName("", "tenantId");
        
        
        /**
         * Gets the "telephony" attribute
         */
        public int getTelephony()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TELEPHONY$0);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "telephony" attribute
         */
        public org.apache.xmlbeans.XmlInt xgetTelephony()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(TELEPHONY$0);
                return target;
            }
        }
        
        /**
         * True if has "telephony" attribute
         */
        public boolean isSetTelephony()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(TELEPHONY$0) != null;
            }
        }
        
        /**
         * Sets the "telephony" attribute
         */
        public void setTelephony(int telephony)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TELEPHONY$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TELEPHONY$0);
                }
                target.setIntValue(telephony);
            }
        }
        
        /**
         * Sets (as xml) the "telephony" attribute
         */
        public void xsetTelephony(org.apache.xmlbeans.XmlInt telephony)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(TELEPHONY$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(TELEPHONY$0);
                }
                target.set(telephony);
            }
        }
        
        /**
         * Unsets the "telephony" attribute
         */
        public void unsetTelephony()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(TELEPHONY$0);
            }
        }
        
        /**
         * Gets the "email" attribute
         */
        public int getEmail()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(EMAIL$2);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "email" attribute
         */
        public org.apache.xmlbeans.XmlInt xgetEmail()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(EMAIL$2);
                return target;
            }
        }
        
        /**
         * True if has "email" attribute
         */
        public boolean isSetEmail()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(EMAIL$2) != null;
            }
        }
        
        /**
         * Sets the "email" attribute
         */
        public void setEmail(int email)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(EMAIL$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(EMAIL$2);
                }
                target.setIntValue(email);
            }
        }
        
        /**
         * Sets (as xml) the "email" attribute
         */
        public void xsetEmail(org.apache.xmlbeans.XmlInt email)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(EMAIL$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(EMAIL$2);
                }
                target.set(email);
            }
        }
        
        /**
         * Unsets the "email" attribute
         */
        public void unsetEmail()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(EMAIL$2);
            }
        }
        
        /**
         * Gets the "fax" attribute
         */
        public int getFax()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FAX$4);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "fax" attribute
         */
        public org.apache.xmlbeans.XmlInt xgetFax()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(FAX$4);
                return target;
            }
        }
        
        /**
         * True if has "fax" attribute
         */
        public boolean isSetFax()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(FAX$4) != null;
            }
        }
        
        /**
         * Sets the "fax" attribute
         */
        public void setFax(int fax)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FAX$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(FAX$4);
                }
                target.setIntValue(fax);
            }
        }
        
        /**
         * Sets (as xml) the "fax" attribute
         */
        public void xsetFax(org.apache.xmlbeans.XmlInt fax)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(FAX$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(FAX$4);
                }
                target.set(fax);
            }
        }
        
        /**
         * Unsets the "fax" attribute
         */
        public void unsetFax()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(FAX$4);
            }
        }
        
        /**
         * Gets the "chat" attribute
         */
        public int getChat()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHAT$6);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "chat" attribute
         */
        public org.apache.xmlbeans.XmlInt xgetChat()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(CHAT$6);
                return target;
            }
        }
        
        /**
         * True if has "chat" attribute
         */
        public boolean isSetChat()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(CHAT$6) != null;
            }
        }
        
        /**
         * Sets the "chat" attribute
         */
        public void setChat(int chat)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHAT$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CHAT$6);
                }
                target.setIntValue(chat);
            }
        }
        
        /**
         * Sets (as xml) the "chat" attribute
         */
        public void xsetChat(org.apache.xmlbeans.XmlInt chat)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(CHAT$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(CHAT$6);
                }
                target.set(chat);
            }
        }
        
        /**
         * Unsets the "chat" attribute
         */
        public void unsetChat()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(CHAT$6);
            }
        }
        
        /**
         * Gets the "video" attribute
         */
        public int getVideo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VIDEO$8);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "video" attribute
         */
        public org.apache.xmlbeans.XmlInt xgetVideo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(VIDEO$8);
                return target;
            }
        }
        
        /**
         * True if has "video" attribute
         */
        public boolean isSetVideo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(VIDEO$8) != null;
            }
        }
        
        /**
         * Sets the "video" attribute
         */
        public void setVideo(int video)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VIDEO$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VIDEO$8);
                }
                target.setIntValue(video);
            }
        }
        
        /**
         * Sets (as xml) the "video" attribute
         */
        public void xsetVideo(org.apache.xmlbeans.XmlInt video)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(VIDEO$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(VIDEO$8);
                }
                target.set(video);
            }
        }
        
        /**
         * Unsets the "video" attribute
         */
        public void unsetVideo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(VIDEO$8);
            }
        }
        
        /**
         * Gets the "other" attribute
         */
        public int getOther()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(OTHER$10);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "other" attribute
         */
        public org.apache.xmlbeans.XmlInt xgetOther()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(OTHER$10);
                return target;
            }
        }
        
        /**
         * True if has "other" attribute
         */
        public boolean isSetOther()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(OTHER$10) != null;
            }
        }
        
        /**
         * Sets the "other" attribute
         */
        public void setOther(int other)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(OTHER$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(OTHER$10);
                }
                target.setIntValue(other);
            }
        }
        
        /**
         * Sets (as xml) the "other" attribute
         */
        public void xsetOther(org.apache.xmlbeans.XmlInt other)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(OTHER$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(OTHER$10);
                }
                target.set(other);
            }
        }
        
        /**
         * Unsets the "other" attribute
         */
        public void unsetOther()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(OTHER$10);
            }
        }
        
        /**
         * Gets the "id" attribute
         */
        public java.lang.String getId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$12);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$12);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$12);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ID$12);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$12);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ID$12);
                }
                target.set(id);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$14);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$14);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$14);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$14);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$14);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAME$14);
                }
                target.set(name);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTID$16);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTID$16);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTID$16);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AGENTID$16);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTID$16);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(AGENTID$16);
                }
                target.set(agentId);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TENANTID$18);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TENANTID$18);
                return target;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TENANTID$18);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TENANTID$18);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TENANTID$18);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TENANTID$18);
                }
                target.set(tenantId);
            }
        }
    }
}
