/*
 * An XML document type.
 * Localname: authenticateStatus
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.AuthenticateStatusDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one authenticateStatus(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class AuthenticateStatusDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AuthenticateStatusDocument
{
    private static final long serialVersionUID = 1L;
    
    public AuthenticateStatusDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AUTHENTICATESTATUS$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "authenticateStatus");
    
    
    /**
     * Gets the "authenticateStatus" element
     */
    public com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus getAuthenticateStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus target = null;
            target = (com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus)get_store().find_element_user(AUTHENTICATESTATUS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "authenticateStatus" element
     */
    public void setAuthenticateStatus(com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus authenticateStatus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus target = null;
            target = (com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus)get_store().find_element_user(AUTHENTICATESTATUS$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus)get_store().add_element_user(AUTHENTICATESTATUS$0);
            }
            target.set(authenticateStatus);
        }
    }
    
    /**
     * Appends and returns a new empty "authenticateStatus" element
     */
    public com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus addNewAuthenticateStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus target = null;
            target = (com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus)get_store().add_element_user(AUTHENTICATESTATUS$0);
            return target;
        }
    }
    /**
     * An XML authenticateStatus(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class AuthenticateStatusImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus
    {
        private static final long serialVersionUID = 1L;
        
        public AuthenticateStatusImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName REASON$0 = 
            new javax.xml.namespace.QName("", "reason");
        private static final javax.xml.namespace.QName MAXINVATPS$2 = 
            new javax.xml.namespace.QName("", "maxInvAtps");
        private static final javax.xml.namespace.QName CURINVATPS$4 = 
            new javax.xml.namespace.QName("", "curInvAtps");
        
        
        /**
         * Gets the "reason" attribute
         */
        public com.transerainc.aha.gen.agent.ReasonType.Enum getReason()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REASON$0);
                if (target == null)
                {
                    return null;
                }
                return (com.transerainc.aha.gen.agent.ReasonType.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "reason" attribute
         */
        public com.transerainc.aha.gen.agent.ReasonType xgetReason()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ReasonType target = null;
                target = (com.transerainc.aha.gen.agent.ReasonType)get_store().find_attribute_user(REASON$0);
                return target;
            }
        }
        
        /**
         * Sets the "reason" attribute
         */
        public void setReason(com.transerainc.aha.gen.agent.ReasonType.Enum reason)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REASON$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(REASON$0);
                }
                target.setEnumValue(reason);
            }
        }
        
        /**
         * Sets (as xml) the "reason" attribute
         */
        public void xsetReason(com.transerainc.aha.gen.agent.ReasonType reason)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ReasonType target = null;
                target = (com.transerainc.aha.gen.agent.ReasonType)get_store().find_attribute_user(REASON$0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.ReasonType)get_store().add_attribute_user(REASON$0);
                }
                target.set(reason);
            }
        }
        
        /**
         * Gets the "maxInvAtps" attribute
         */
        public int getMaxInvAtps()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MAXINVATPS$2);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "maxInvAtps" attribute
         */
        public org.apache.xmlbeans.XmlInt xgetMaxInvAtps()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(MAXINVATPS$2);
                return target;
            }
        }
        
        /**
         * True if has "maxInvAtps" attribute
         */
        public boolean isSetMaxInvAtps()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(MAXINVATPS$2) != null;
            }
        }
        
        /**
         * Sets the "maxInvAtps" attribute
         */
        public void setMaxInvAtps(int maxInvAtps)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MAXINVATPS$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(MAXINVATPS$2);
                }
                target.setIntValue(maxInvAtps);
            }
        }
        
        /**
         * Sets (as xml) the "maxInvAtps" attribute
         */
        public void xsetMaxInvAtps(org.apache.xmlbeans.XmlInt maxInvAtps)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(MAXINVATPS$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(MAXINVATPS$2);
                }
                target.set(maxInvAtps);
            }
        }
        
        /**
         * Unsets the "maxInvAtps" attribute
         */
        public void unsetMaxInvAtps()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(MAXINVATPS$2);
            }
        }
        
        /**
         * Gets the "curInvAtps" attribute
         */
        public int getCurInvAtps()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CURINVATPS$4);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "curInvAtps" attribute
         */
        public org.apache.xmlbeans.XmlInt xgetCurInvAtps()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(CURINVATPS$4);
                return target;
            }
        }
        
        /**
         * True if has "curInvAtps" attribute
         */
        public boolean isSetCurInvAtps()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(CURINVATPS$4) != null;
            }
        }
        
        /**
         * Sets the "curInvAtps" attribute
         */
        public void setCurInvAtps(int curInvAtps)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CURINVATPS$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CURINVATPS$4);
                }
                target.setIntValue(curInvAtps);
            }
        }
        
        /**
         * Sets (as xml) the "curInvAtps" attribute
         */
        public void xsetCurInvAtps(org.apache.xmlbeans.XmlInt curInvAtps)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(CURINVATPS$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(CURINVATPS$4);
                }
                target.set(curInvAtps);
            }
        }
        
        /**
         * Unsets the "curInvAtps" attribute
         */
        public void unsetCurInvAtps()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(CURINVATPS$4);
            }
        }
    }
}
