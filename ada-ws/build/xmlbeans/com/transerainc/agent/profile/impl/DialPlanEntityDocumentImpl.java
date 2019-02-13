/*
 * An XML document type.
 * Localname: dialPlanEntity
 * Namespace: http://agent.transerainc.com/profile
 * Java type: com.transerainc.agent.profile.DialPlanEntityDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.agent.profile.impl;
/**
 * A document containing one dialPlanEntity(@http://agent.transerainc.com/profile) element.
 *
 * This is a complex type.
 */
public class DialPlanEntityDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.agent.profile.DialPlanEntityDocument
{
    private static final long serialVersionUID = 1L;
    
    public DialPlanEntityDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DIALPLANENTITY$0 = 
        new javax.xml.namespace.QName("http://agent.transerainc.com/profile", "dialPlanEntity");
    
    
    /**
     * Gets the "dialPlanEntity" element
     */
    public com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity getDialPlanEntity()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity target = null;
            target = (com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity)get_store().find_element_user(DIALPLANENTITY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "dialPlanEntity" element
     */
    public void setDialPlanEntity(com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity dialPlanEntity)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity target = null;
            target = (com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity)get_store().find_element_user(DIALPLANENTITY$0, 0);
            if (target == null)
            {
                target = (com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity)get_store().add_element_user(DIALPLANENTITY$0);
            }
            target.set(dialPlanEntity);
        }
    }
    
    /**
     * Appends and returns a new empty "dialPlanEntity" element
     */
    public com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity addNewDialPlanEntity()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity target = null;
            target = (com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity)get_store().add_element_user(DIALPLANENTITY$0);
            return target;
        }
    }
    /**
     * An XML dialPlanEntity(@http://agent.transerainc.com/profile).
     *
     * This is a complex type.
     */
    public static class DialPlanEntityImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity
    {
        private static final long serialVersionUID = 1L;
        
        public DialPlanEntityImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName NAME$0 = 
            new javax.xml.namespace.QName("", "name");
        private static final javax.xml.namespace.QName PREFIX$2 = 
            new javax.xml.namespace.QName("", "prefix");
        private static final javax.xml.namespace.QName STRIPPEDCHARS$4 = 
            new javax.xml.namespace.QName("", "strippedChars");
        private static final javax.xml.namespace.QName REGEX$6 = 
            new javax.xml.namespace.QName("", "regex");
        
        
        /**
         * Gets the "name" attribute
         */
        public java.lang.String getName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAME$0);
                }
                target.set(name);
            }
        }
        
        /**
         * Gets the "prefix" attribute
         */
        public java.lang.String getPrefix()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PREFIX$2);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "prefix" attribute
         */
        public org.apache.xmlbeans.XmlString xgetPrefix()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PREFIX$2);
                return target;
            }
        }
        
        /**
         * Sets the "prefix" attribute
         */
        public void setPrefix(java.lang.String prefix)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PREFIX$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PREFIX$2);
                }
                target.setStringValue(prefix);
            }
        }
        
        /**
         * Sets (as xml) the "prefix" attribute
         */
        public void xsetPrefix(org.apache.xmlbeans.XmlString prefix)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PREFIX$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PREFIX$2);
                }
                target.set(prefix);
            }
        }
        
        /**
         * Gets the "strippedChars" attribute
         */
        public java.lang.String getStrippedChars()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STRIPPEDCHARS$4);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "strippedChars" attribute
         */
        public org.apache.xmlbeans.XmlString xgetStrippedChars()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(STRIPPEDCHARS$4);
                return target;
            }
        }
        
        /**
         * Sets the "strippedChars" attribute
         */
        public void setStrippedChars(java.lang.String strippedChars)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STRIPPEDCHARS$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(STRIPPEDCHARS$4);
                }
                target.setStringValue(strippedChars);
            }
        }
        
        /**
         * Sets (as xml) the "strippedChars" attribute
         */
        public void xsetStrippedChars(org.apache.xmlbeans.XmlString strippedChars)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(STRIPPEDCHARS$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(STRIPPEDCHARS$4);
                }
                target.set(strippedChars);
            }
        }
        
        /**
         * Gets the "regex" attribute
         */
        public java.lang.String getRegex()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REGEX$6);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "regex" attribute
         */
        public org.apache.xmlbeans.XmlString xgetRegex()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(REGEX$6);
                return target;
            }
        }
        
        /**
         * Sets the "regex" attribute
         */
        public void setRegex(java.lang.String regex)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REGEX$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(REGEX$6);
                }
                target.setStringValue(regex);
            }
        }
        
        /**
         * Sets (as xml) the "regex" attribute
         */
        public void xsetRegex(org.apache.xmlbeans.XmlString regex)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(REGEX$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(REGEX$6);
                }
                target.set(regex);
            }
        }
    }
}
