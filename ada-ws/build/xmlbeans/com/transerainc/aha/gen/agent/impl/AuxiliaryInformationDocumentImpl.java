/*
 * An XML document type.
 * Localname: auxiliaryInformation
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.AuxiliaryInformationDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one auxiliaryInformation(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class AuxiliaryInformationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AuxiliaryInformationDocument
{
    private static final long serialVersionUID = 1L;
    
    public AuxiliaryInformationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AUXILIARYINFORMATION$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "auxiliaryInformation");
    
    
    /**
     * Gets the "auxiliaryInformation" element
     */
    public com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation getAuxiliaryInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation target = null;
            target = (com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation)get_store().find_element_user(AUXILIARYINFORMATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "auxiliaryInformation" element
     */
    public void setAuxiliaryInformation(com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation auxiliaryInformation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation target = null;
            target = (com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation)get_store().find_element_user(AUXILIARYINFORMATION$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation)get_store().add_element_user(AUXILIARYINFORMATION$0);
            }
            target.set(auxiliaryInformation);
        }
    }
    
    /**
     * Appends and returns a new empty "auxiliaryInformation" element
     */
    public com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation addNewAuxiliaryInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation target = null;
            target = (com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation)get_store().add_element_user(AUXILIARYINFORMATION$0);
            return target;
        }
    }
    /**
     * An XML auxiliaryInformation(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class AuxiliaryInformationImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation
    {
        private static final long serialVersionUID = 1L;
        
        public AuxiliaryInformationImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CODE$0 = 
            new javax.xml.namespace.QName("", "code");
        private static final javax.xml.namespace.QName NAME$2 = 
            new javax.xml.namespace.QName("", "name");
        private static final javax.xml.namespace.QName CODETYPE$4 = 
            new javax.xml.namespace.QName("", "codeType");
        
        
        /**
         * Gets the "code" attribute
         */
        public int getCode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CODE$0);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "code" attribute
         */
        public org.apache.xmlbeans.XmlInt xgetCode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(CODE$0);
                return target;
            }
        }
        
        /**
         * Sets the "code" attribute
         */
        public void setCode(int code)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CODE$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CODE$0);
                }
                target.setIntValue(code);
            }
        }
        
        /**
         * Sets (as xml) the "code" attribute
         */
        public void xsetCode(org.apache.xmlbeans.XmlInt code)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(CODE$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(CODE$0);
                }
                target.set(code);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$2);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$2);
                return target;
            }
        }
        
        /**
         * True if has "name" attribute
         */
        public boolean isSetName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(NAME$2) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$2);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAME$2);
                }
                target.set(name);
            }
        }
        
        /**
         * Unsets the "name" attribute
         */
        public void unsetName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(NAME$2);
            }
        }
        
        /**
         * Gets the "codeType" attribute
         */
        public java.lang.String getCodeType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CODETYPE$4);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "codeType" attribute
         */
        public org.apache.xmlbeans.XmlString xgetCodeType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CODETYPE$4);
                return target;
            }
        }
        
        /**
         * Sets the "codeType" attribute
         */
        public void setCodeType(java.lang.String codeType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CODETYPE$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CODETYPE$4);
                }
                target.setStringValue(codeType);
            }
        }
        
        /**
         * Sets (as xml) the "codeType" attribute
         */
        public void xsetCodeType(org.apache.xmlbeans.XmlString codeType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CODETYPE$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(CODETYPE$4);
                }
                target.set(codeType);
            }
        }
    }
}
