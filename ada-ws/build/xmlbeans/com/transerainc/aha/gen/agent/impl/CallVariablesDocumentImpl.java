/*
 * An XML document type.
 * Localname: callVariables
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.CallVariablesDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one callVariables(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class CallVariablesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.CallVariablesDocument
{
    private static final long serialVersionUID = 1L;
    
    public CallVariablesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CALLVARIABLES$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "callVariables");
    
    
    /**
     * Gets the "callVariables" element
     */
    public com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables getCallVariables()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables target = null;
            target = (com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables)get_store().find_element_user(CALLVARIABLES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "callVariables" element
     */
    public void setCallVariables(com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables callVariables)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables target = null;
            target = (com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables)get_store().find_element_user(CALLVARIABLES$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables)get_store().add_element_user(CALLVARIABLES$0);
            }
            target.set(callVariables);
        }
    }
    
    /**
     * Appends and returns a new empty "callVariables" element
     */
    public com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables addNewCallVariables()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables target = null;
            target = (com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables)get_store().add_element_user(CALLVARIABLES$0);
            return target;
        }
    }
    /**
     * An XML callVariables(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class CallVariablesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables
    {
        private static final long serialVersionUID = 1L;
        
        public CallVariablesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName SUPPRESSED$0 = 
            new javax.xml.namespace.QName("", "suppressed");
        private static final javax.xml.namespace.QName BASEURL$2 = 
            new javax.xml.namespace.QName("", "baseUrl");
        
        
        /**
         * Gets the "suppressed" attribute
         */
        public java.lang.String getSuppressed()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SUPPRESSED$0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "suppressed" attribute
         */
        public org.apache.xmlbeans.XmlString xgetSuppressed()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SUPPRESSED$0);
                return target;
            }
        }
        
        /**
         * Sets the "suppressed" attribute
         */
        public void setSuppressed(java.lang.String suppressed)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SUPPRESSED$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SUPPRESSED$0);
                }
                target.setStringValue(suppressed);
            }
        }
        
        /**
         * Sets (as xml) the "suppressed" attribute
         */
        public void xsetSuppressed(org.apache.xmlbeans.XmlString suppressed)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SUPPRESSED$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(SUPPRESSED$0);
                }
                target.set(suppressed);
            }
        }
        
        /**
         * Gets the "baseUrl" attribute
         */
        public java.lang.String getBaseUrl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(BASEURL$2);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "baseUrl" attribute
         */
        public org.apache.xmlbeans.XmlString xgetBaseUrl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(BASEURL$2);
                return target;
            }
        }
        
        /**
         * True if has "baseUrl" attribute
         */
        public boolean isSetBaseUrl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(BASEURL$2) != null;
            }
        }
        
        /**
         * Sets the "baseUrl" attribute
         */
        public void setBaseUrl(java.lang.String baseUrl)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(BASEURL$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(BASEURL$2);
                }
                target.setStringValue(baseUrl);
            }
        }
        
        /**
         * Sets (as xml) the "baseUrl" attribute
         */
        public void xsetBaseUrl(org.apache.xmlbeans.XmlString baseUrl)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(BASEURL$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(BASEURL$2);
                }
                target.set(baseUrl);
            }
        }
        
        /**
         * Unsets the "baseUrl" attribute
         */
        public void unsetBaseUrl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(BASEURL$2);
            }
        }
    }
}
