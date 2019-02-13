/*
 * An XML document type.
 * Localname: profile-attribute
 * Namespace: http://agent.transerainc.com/profile
 * Java type: com.transerainc.agent.profile.ProfileAttributeDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.agent.profile.impl;
/**
 * A document containing one profile-attribute(@http://agent.transerainc.com/profile) element.
 *
 * This is a complex type.
 */
public class ProfileAttributeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.agent.profile.ProfileAttributeDocument
{
    private static final long serialVersionUID = 1L;
    
    public ProfileAttributeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROFILEATTRIBUTE$0 = 
        new javax.xml.namespace.QName("http://agent.transerainc.com/profile", "profile-attribute");
    
    
    /**
     * Gets the "profile-attribute" element
     */
    public com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute getProfileAttribute()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute target = null;
            target = (com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute)get_store().find_element_user(PROFILEATTRIBUTE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "profile-attribute" element
     */
    public void setProfileAttribute(com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute profileAttribute)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute target = null;
            target = (com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute)get_store().find_element_user(PROFILEATTRIBUTE$0, 0);
            if (target == null)
            {
                target = (com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute)get_store().add_element_user(PROFILEATTRIBUTE$0);
            }
            target.set(profileAttribute);
        }
    }
    
    /**
     * Appends and returns a new empty "profile-attribute" element
     */
    public com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute addNewProfileAttribute()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute target = null;
            target = (com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute)get_store().add_element_user(PROFILEATTRIBUTE$0);
            return target;
        }
    }
    /**
     * An XML profile-attribute(@http://agent.transerainc.com/profile).
     *
     * This is a complex type.
     */
    public static class ProfileAttributeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute
    {
        private static final long serialVersionUID = 1L;
        
        public ProfileAttributeImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName NAME$0 = 
            new javax.xml.namespace.QName("", "name");
        private static final javax.xml.namespace.QName VALUE$2 = 
            new javax.xml.namespace.QName("", "value");
        
        
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
         * Gets the "value" attribute
         */
        public java.lang.String getValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALUE$2);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "value" attribute
         */
        public org.apache.xmlbeans.XmlString xgetValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VALUE$2);
                return target;
            }
        }
        
        /**
         * Sets the "value" attribute
         */
        public void setValue(java.lang.String value)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALUE$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VALUE$2);
                }
                target.setStringValue(value);
            }
        }
        
        /**
         * Sets (as xml) the "value" attribute
         */
        public void xsetValue(org.apache.xmlbeans.XmlString value)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VALUE$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(VALUE$2);
                }
                target.set(value);
            }
        }
    }
}
