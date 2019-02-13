/*
 * An XML document type.
 * Localname: enterpriseDesktopConfiguration
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.EnterpriseDesktopConfigurationDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one enterpriseDesktopConfiguration(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class EnterpriseDesktopConfigurationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.EnterpriseDesktopConfigurationDocument
{
    private static final long serialVersionUID = 1L;
    
    public EnterpriseDesktopConfigurationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENTERPRISEDESKTOPCONFIGURATION$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "enterpriseDesktopConfiguration");
    
    
    /**
     * Gets the "enterpriseDesktopConfiguration" element
     */
    public com.transerainc.aha.gen.agent.EnterpriseDesktopConfigurationDocument.EnterpriseDesktopConfiguration getEnterpriseDesktopConfiguration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.EnterpriseDesktopConfigurationDocument.EnterpriseDesktopConfiguration target = null;
            target = (com.transerainc.aha.gen.agent.EnterpriseDesktopConfigurationDocument.EnterpriseDesktopConfiguration)get_store().find_element_user(ENTERPRISEDESKTOPCONFIGURATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "enterpriseDesktopConfiguration" element
     */
    public void setEnterpriseDesktopConfiguration(com.transerainc.aha.gen.agent.EnterpriseDesktopConfigurationDocument.EnterpriseDesktopConfiguration enterpriseDesktopConfiguration)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.EnterpriseDesktopConfigurationDocument.EnterpriseDesktopConfiguration target = null;
            target = (com.transerainc.aha.gen.agent.EnterpriseDesktopConfigurationDocument.EnterpriseDesktopConfiguration)get_store().find_element_user(ENTERPRISEDESKTOPCONFIGURATION$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.EnterpriseDesktopConfigurationDocument.EnterpriseDesktopConfiguration)get_store().add_element_user(ENTERPRISEDESKTOPCONFIGURATION$0);
            }
            target.set(enterpriseDesktopConfiguration);
        }
    }
    
    /**
     * Appends and returns a new empty "enterpriseDesktopConfiguration" element
     */
    public com.transerainc.aha.gen.agent.EnterpriseDesktopConfigurationDocument.EnterpriseDesktopConfiguration addNewEnterpriseDesktopConfiguration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.EnterpriseDesktopConfigurationDocument.EnterpriseDesktopConfiguration target = null;
            target = (com.transerainc.aha.gen.agent.EnterpriseDesktopConfigurationDocument.EnterpriseDesktopConfiguration)get_store().add_element_user(ENTERPRISEDESKTOPCONFIGURATION$0);
            return target;
        }
    }
    /**
     * An XML enterpriseDesktopConfiguration(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class EnterpriseDesktopConfigurationImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.EnterpriseDesktopConfigurationDocument.EnterpriseDesktopConfiguration
    {
        private static final long serialVersionUID = 1L;
        
        public EnterpriseDesktopConfigurationImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ATTRIBUTE$0 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "attribute");
        private static final javax.xml.namespace.QName VERSION$2 = 
            new javax.xml.namespace.QName("", "version");
        
        
        /**
         * Gets array of all "attribute" elements
         */
        public com.transerainc.aha.gen.agent.AttributeDocument.Attribute[] getAttributeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(ATTRIBUTE$0, targetList);
                com.transerainc.aha.gen.agent.AttributeDocument.Attribute[] result = new com.transerainc.aha.gen.agent.AttributeDocument.Attribute[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "attribute" element
         */
        public com.transerainc.aha.gen.agent.AttributeDocument.Attribute getAttributeArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AttributeDocument.Attribute target = null;
                target = (com.transerainc.aha.gen.agent.AttributeDocument.Attribute)get_store().find_element_user(ATTRIBUTE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "attribute" element
         */
        public int sizeOfAttributeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ATTRIBUTE$0);
            }
        }
        
        /**
         * Sets array of all "attribute" element
         */
        public void setAttributeArray(com.transerainc.aha.gen.agent.AttributeDocument.Attribute[] attributeArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(attributeArray, ATTRIBUTE$0);
            }
        }
        
        /**
         * Sets ith "attribute" element
         */
        public void setAttributeArray(int i, com.transerainc.aha.gen.agent.AttributeDocument.Attribute attribute)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AttributeDocument.Attribute target = null;
                target = (com.transerainc.aha.gen.agent.AttributeDocument.Attribute)get_store().find_element_user(ATTRIBUTE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(attribute);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "attribute" element
         */
        public com.transerainc.aha.gen.agent.AttributeDocument.Attribute insertNewAttribute(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AttributeDocument.Attribute target = null;
                target = (com.transerainc.aha.gen.agent.AttributeDocument.Attribute)get_store().insert_element_user(ATTRIBUTE$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "attribute" element
         */
        public com.transerainc.aha.gen.agent.AttributeDocument.Attribute addNewAttribute()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AttributeDocument.Attribute target = null;
                target = (com.transerainc.aha.gen.agent.AttributeDocument.Attribute)get_store().add_element_user(ATTRIBUTE$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "attribute" element
         */
        public void removeAttribute(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ATTRIBUTE$0, i);
            }
        }
        
        /**
         * Gets the "version" attribute
         */
        public java.lang.String getVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VERSION$2);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "version" attribute
         */
        public org.apache.xmlbeans.XmlString xgetVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VERSION$2);
                return target;
            }
        }
        
        /**
         * True if has "version" attribute
         */
        public boolean isSetVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(VERSION$2) != null;
            }
        }
        
        /**
         * Sets the "version" attribute
         */
        public void setVersion(java.lang.String version)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VERSION$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VERSION$2);
                }
                target.setStringValue(version);
            }
        }
        
        /**
         * Sets (as xml) the "version" attribute
         */
        public void xsetVersion(org.apache.xmlbeans.XmlString version)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VERSION$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(VERSION$2);
                }
                target.set(version);
            }
        }
        
        /**
         * Unsets the "version" attribute
         */
        public void unsetVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(VERSION$2);
            }
        }
    }
}
