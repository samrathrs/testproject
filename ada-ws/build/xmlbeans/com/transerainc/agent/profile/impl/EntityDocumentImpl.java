/*
 * An XML document type.
 * Localname: entity
 * Namespace: http://agent.transerainc.com/profile
 * Java type: com.transerainc.agent.profile.EntityDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.agent.profile.impl;
/**
 * A document containing one entity(@http://agent.transerainc.com/profile) element.
 *
 * This is a complex type.
 */
public class EntityDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.agent.profile.EntityDocument
{
    private static final long serialVersionUID = 1L;
    
    public EntityDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENTITY$0 = 
        new javax.xml.namespace.QName("http://agent.transerainc.com/profile", "entity");
    
    
    /**
     * Gets the "entity" element
     */
    public com.transerainc.agent.profile.EntityDocument.Entity getEntity()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.EntityDocument.Entity target = null;
            target = (com.transerainc.agent.profile.EntityDocument.Entity)get_store().find_element_user(ENTITY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "entity" element
     */
    public void setEntity(com.transerainc.agent.profile.EntityDocument.Entity entity)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.EntityDocument.Entity target = null;
            target = (com.transerainc.agent.profile.EntityDocument.Entity)get_store().find_element_user(ENTITY$0, 0);
            if (target == null)
            {
                target = (com.transerainc.agent.profile.EntityDocument.Entity)get_store().add_element_user(ENTITY$0);
            }
            target.set(entity);
        }
    }
    
    /**
     * Appends and returns a new empty "entity" element
     */
    public com.transerainc.agent.profile.EntityDocument.Entity addNewEntity()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.EntityDocument.Entity target = null;
            target = (com.transerainc.agent.profile.EntityDocument.Entity)get_store().add_element_user(ENTITY$0);
            return target;
        }
    }
    /**
     * An XML entity(@http://agent.transerainc.com/profile).
     *
     * This is a complex type.
     */
    public static class EntityImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.agent.profile.EntityDocument.Entity
    {
        private static final long serialVersionUID = 1L;
        
        public EntityImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ID$0 = 
            new javax.xml.namespace.QName("", "id");
        private static final javax.xml.namespace.QName NAME$2 = 
            new javax.xml.namespace.QName("", "name");
        private static final javax.xml.namespace.QName ISSYSTEM$4 = 
            new javax.xml.namespace.QName("", "isSystem");
        private static final javax.xml.namespace.QName OMNICHANNELAUXID$6 = 
            new javax.xml.namespace.QName("", "omniChannelAuxId");
        
        
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
         * Gets the "isSystem" attribute
         */
        public boolean getIsSystem()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ISSYSTEM$4);
                if (target == null)
                {
                    return false;
                }
                return target.getBooleanValue();
            }
        }
        
        /**
         * Gets (as xml) the "isSystem" attribute
         */
        public org.apache.xmlbeans.XmlBoolean xgetIsSystem()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(ISSYSTEM$4);
                return target;
            }
        }
        
        /**
         * Sets the "isSystem" attribute
         */
        public void setIsSystem(boolean isSystem)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ISSYSTEM$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ISSYSTEM$4);
                }
                target.setBooleanValue(isSystem);
            }
        }
        
        /**
         * Sets (as xml) the "isSystem" attribute
         */
        public void xsetIsSystem(org.apache.xmlbeans.XmlBoolean isSystem)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(ISSYSTEM$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(ISSYSTEM$4);
                }
                target.set(isSystem);
            }
        }
        
        /**
         * Gets the "omniChannelAuxId" attribute
         */
        public java.lang.String getOmniChannelAuxId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(OMNICHANNELAUXID$6);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "omniChannelAuxId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetOmniChannelAuxId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(OMNICHANNELAUXID$6);
                return target;
            }
        }
        
        /**
         * True if has "omniChannelAuxId" attribute
         */
        public boolean isSetOmniChannelAuxId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(OMNICHANNELAUXID$6) != null;
            }
        }
        
        /**
         * Sets the "omniChannelAuxId" attribute
         */
        public void setOmniChannelAuxId(java.lang.String omniChannelAuxId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(OMNICHANNELAUXID$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(OMNICHANNELAUXID$6);
                }
                target.setStringValue(omniChannelAuxId);
            }
        }
        
        /**
         * Sets (as xml) the "omniChannelAuxId" attribute
         */
        public void xsetOmniChannelAuxId(org.apache.xmlbeans.XmlString omniChannelAuxId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(OMNICHANNELAUXID$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(OMNICHANNELAUXID$6);
                }
                target.set(omniChannelAuxId);
            }
        }
        
        /**
         * Unsets the "omniChannelAuxId" attribute
         */
        public void unsetOmniChannelAuxId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(OMNICHANNELAUXID$6);
            }
        }
    }
}
