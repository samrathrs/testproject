/*
 * An XML document type.
 * Localname: authenticate
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.AuthenticateDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one authenticate(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class AuthenticateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AuthenticateDocument
{
    private static final long serialVersionUID = 1L;
    
    public AuthenticateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AUTHENTICATE$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "authenticate");
    
    
    /**
     * Gets the "authenticate" element
     */
    public com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate getAuthenticate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate target = null;
            target = (com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate)get_store().find_element_user(AUTHENTICATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "authenticate" element
     */
    public void setAuthenticate(com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate authenticate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate target = null;
            target = (com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate)get_store().find_element_user(AUTHENTICATE$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate)get_store().add_element_user(AUTHENTICATE$0);
            }
            target.set(authenticate);
        }
    }
    
    /**
     * Appends and returns a new empty "authenticate" element
     */
    public com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate addNewAuthenticate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate target = null;
            target = (com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate)get_store().add_element_user(AUTHENTICATE$0);
            return target;
        }
    }
    /**
     * An XML authenticate(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class AuthenticateImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate
    {
        private static final long serialVersionUID = 1L;
        
        public AuthenticateImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName USERNAME$0 = 
            new javax.xml.namespace.QName("", "username");
        private static final javax.xml.namespace.QName PASSWORD$2 = 
            new javax.xml.namespace.QName("", "password");
        private static final javax.xml.namespace.QName ENTERPRISE$4 = 
            new javax.xml.namespace.QName("", "enterprise");
        private static final javax.xml.namespace.QName CASAUTHENTICATED$6 = 
            new javax.xml.namespace.QName("", "casAuthenticated");
        private static final javax.xml.namespace.QName PROTOCOLVERSION$8 = 
            new javax.xml.namespace.QName("", "protocolVersion");
        private static final javax.xml.namespace.QName APPLETVERSION$10 = 
            new javax.xml.namespace.QName("", "appletVersion");
        
        
        /**
         * Gets the "username" attribute
         */
        public java.lang.String getUsername()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(USERNAME$0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "username" attribute
         */
        public org.apache.xmlbeans.XmlString xgetUsername()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(USERNAME$0);
                return target;
            }
        }
        
        /**
         * Sets the "username" attribute
         */
        public void setUsername(java.lang.String username)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(USERNAME$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(USERNAME$0);
                }
                target.setStringValue(username);
            }
        }
        
        /**
         * Sets (as xml) the "username" attribute
         */
        public void xsetUsername(org.apache.xmlbeans.XmlString username)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(USERNAME$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(USERNAME$0);
                }
                target.set(username);
            }
        }
        
        /**
         * Gets the "password" attribute
         */
        public java.lang.String getPassword()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PASSWORD$2);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "password" attribute
         */
        public org.apache.xmlbeans.XmlString xgetPassword()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PASSWORD$2);
                return target;
            }
        }
        
        /**
         * True if has "password" attribute
         */
        public boolean isSetPassword()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(PASSWORD$2) != null;
            }
        }
        
        /**
         * Sets the "password" attribute
         */
        public void setPassword(java.lang.String password)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PASSWORD$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PASSWORD$2);
                }
                target.setStringValue(password);
            }
        }
        
        /**
         * Sets (as xml) the "password" attribute
         */
        public void xsetPassword(org.apache.xmlbeans.XmlString password)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PASSWORD$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PASSWORD$2);
                }
                target.set(password);
            }
        }
        
        /**
         * Unsets the "password" attribute
         */
        public void unsetPassword()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(PASSWORD$2);
            }
        }
        
        /**
         * Gets the "enterprise" attribute
         */
        public java.lang.String getEnterprise()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENTERPRISE$4);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "enterprise" attribute
         */
        public org.apache.xmlbeans.XmlString xgetEnterprise()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ENTERPRISE$4);
                return target;
            }
        }
        
        /**
         * Sets the "enterprise" attribute
         */
        public void setEnterprise(java.lang.String enterprise)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENTERPRISE$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ENTERPRISE$4);
                }
                target.setStringValue(enterprise);
            }
        }
        
        /**
         * Sets (as xml) the "enterprise" attribute
         */
        public void xsetEnterprise(org.apache.xmlbeans.XmlString enterprise)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ENTERPRISE$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ENTERPRISE$4);
                }
                target.set(enterprise);
            }
        }
        
        /**
         * Gets the "casAuthenticated" attribute
         */
        public boolean getCasAuthenticated()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CASAUTHENTICATED$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(CASAUTHENTICATED$6);
                }
                if (target == null)
                {
                    return false;
                }
                return target.getBooleanValue();
            }
        }
        
        /**
         * Gets (as xml) the "casAuthenticated" attribute
         */
        public org.apache.xmlbeans.XmlBoolean xgetCasAuthenticated()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(CASAUTHENTICATED$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_default_attribute_value(CASAUTHENTICATED$6);
                }
                return target;
            }
        }
        
        /**
         * True if has "casAuthenticated" attribute
         */
        public boolean isSetCasAuthenticated()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(CASAUTHENTICATED$6) != null;
            }
        }
        
        /**
         * Sets the "casAuthenticated" attribute
         */
        public void setCasAuthenticated(boolean casAuthenticated)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CASAUTHENTICATED$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CASAUTHENTICATED$6);
                }
                target.setBooleanValue(casAuthenticated);
            }
        }
        
        /**
         * Sets (as xml) the "casAuthenticated" attribute
         */
        public void xsetCasAuthenticated(org.apache.xmlbeans.XmlBoolean casAuthenticated)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(CASAUTHENTICATED$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(CASAUTHENTICATED$6);
                }
                target.set(casAuthenticated);
            }
        }
        
        /**
         * Unsets the "casAuthenticated" attribute
         */
        public void unsetCasAuthenticated()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(CASAUTHENTICATED$6);
            }
        }
        
        /**
         * Gets the "protocolVersion" attribute
         */
        public java.lang.String getProtocolVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROTOCOLVERSION$8);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "protocolVersion" attribute
         */
        public org.apache.xmlbeans.XmlString xgetProtocolVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROTOCOLVERSION$8);
                return target;
            }
        }
        
        /**
         * True if has "protocolVersion" attribute
         */
        public boolean isSetProtocolVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(PROTOCOLVERSION$8) != null;
            }
        }
        
        /**
         * Sets the "protocolVersion" attribute
         */
        public void setProtocolVersion(java.lang.String protocolVersion)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROTOCOLVERSION$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PROTOCOLVERSION$8);
                }
                target.setStringValue(protocolVersion);
            }
        }
        
        /**
         * Sets (as xml) the "protocolVersion" attribute
         */
        public void xsetProtocolVersion(org.apache.xmlbeans.XmlString protocolVersion)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROTOCOLVERSION$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PROTOCOLVERSION$8);
                }
                target.set(protocolVersion);
            }
        }
        
        /**
         * Unsets the "protocolVersion" attribute
         */
        public void unsetProtocolVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(PROTOCOLVERSION$8);
            }
        }
        
        /**
         * Gets the "appletVersion" attribute
         */
        public java.lang.String getAppletVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(APPLETVERSION$10);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "appletVersion" attribute
         */
        public org.apache.xmlbeans.XmlString xgetAppletVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(APPLETVERSION$10);
                return target;
            }
        }
        
        /**
         * True if has "appletVersion" attribute
         */
        public boolean isSetAppletVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(APPLETVERSION$10) != null;
            }
        }
        
        /**
         * Sets the "appletVersion" attribute
         */
        public void setAppletVersion(java.lang.String appletVersion)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(APPLETVERSION$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(APPLETVERSION$10);
                }
                target.setStringValue(appletVersion);
            }
        }
        
        /**
         * Sets (as xml) the "appletVersion" attribute
         */
        public void xsetAppletVersion(org.apache.xmlbeans.XmlString appletVersion)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(APPLETVERSION$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(APPLETVERSION$10);
                }
                target.set(appletVersion);
            }
        }
        
        /**
         * Unsets the "appletVersion" attribute
         */
        public void unsetAppletVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(APPLETVERSION$10);
            }
        }
    }
}
