/*
 * An XML document type.
 * Localname: entityList
 * Namespace: http://agent.transerainc.com/profile
 * Java type: com.transerainc.agent.profile.EntityListDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.agent.profile.impl;
/**
 * A document containing one entityList(@http://agent.transerainc.com/profile) element.
 *
 * This is a complex type.
 */
public class EntityListDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.agent.profile.EntityListDocument
{
    private static final long serialVersionUID = 1L;
    
    public EntityListDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENTITYLIST$0 = 
        new javax.xml.namespace.QName("http://agent.transerainc.com/profile", "entityList");
    
    
    /**
     * Gets the "entityList" element
     */
    public com.transerainc.agent.profile.EntityListDocument.EntityList getEntityList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.EntityListDocument.EntityList target = null;
            target = (com.transerainc.agent.profile.EntityListDocument.EntityList)get_store().find_element_user(ENTITYLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "entityList" element
     */
    public void setEntityList(com.transerainc.agent.profile.EntityListDocument.EntityList entityList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.EntityListDocument.EntityList target = null;
            target = (com.transerainc.agent.profile.EntityListDocument.EntityList)get_store().find_element_user(ENTITYLIST$0, 0);
            if (target == null)
            {
                target = (com.transerainc.agent.profile.EntityListDocument.EntityList)get_store().add_element_user(ENTITYLIST$0);
            }
            target.set(entityList);
        }
    }
    
    /**
     * Appends and returns a new empty "entityList" element
     */
    public com.transerainc.agent.profile.EntityListDocument.EntityList addNewEntityList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.EntityListDocument.EntityList target = null;
            target = (com.transerainc.agent.profile.EntityListDocument.EntityList)get_store().add_element_user(ENTITYLIST$0);
            return target;
        }
    }
    /**
     * An XML entityList(@http://agent.transerainc.com/profile).
     *
     * This is a complex type.
     */
    public static class EntityListImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.agent.profile.EntityListDocument.EntityList
    {
        private static final long serialVersionUID = 1L;
        
        public EntityListImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ENTITY$0 = 
            new javax.xml.namespace.QName("http://agent.transerainc.com/profile", "entity");
        private static final javax.xml.namespace.QName TYPE$2 = 
            new javax.xml.namespace.QName("", "type");
        
        
        /**
         * Gets array of all "entity" elements
         */
        public com.transerainc.agent.profile.EntityDocument.Entity[] getEntityArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(ENTITY$0, targetList);
                com.transerainc.agent.profile.EntityDocument.Entity[] result = new com.transerainc.agent.profile.EntityDocument.Entity[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "entity" element
         */
        public com.transerainc.agent.profile.EntityDocument.Entity getEntityArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.EntityDocument.Entity target = null;
                target = (com.transerainc.agent.profile.EntityDocument.Entity)get_store().find_element_user(ENTITY$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "entity" element
         */
        public int sizeOfEntityArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ENTITY$0);
            }
        }
        
        /**
         * Sets array of all "entity" element
         */
        public void setEntityArray(com.transerainc.agent.profile.EntityDocument.Entity[] entityArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(entityArray, ENTITY$0);
            }
        }
        
        /**
         * Sets ith "entity" element
         */
        public void setEntityArray(int i, com.transerainc.agent.profile.EntityDocument.Entity entity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.EntityDocument.Entity target = null;
                target = (com.transerainc.agent.profile.EntityDocument.Entity)get_store().find_element_user(ENTITY$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(entity);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "entity" element
         */
        public com.transerainc.agent.profile.EntityDocument.Entity insertNewEntity(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.EntityDocument.Entity target = null;
                target = (com.transerainc.agent.profile.EntityDocument.Entity)get_store().insert_element_user(ENTITY$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "entity" element
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
         * Removes the ith "entity" element
         */
        public void removeEntity(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ENTITY$0, i);
            }
        }
        
        /**
         * Gets the "type" attribute
         */
        public java.lang.String getType()
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
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "type" attribute
         */
        public org.apache.xmlbeans.XmlString xgetType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TYPE$2);
                return target;
            }
        }
        
        /**
         * Sets the "type" attribute
         */
        public void setType(java.lang.String type)
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
                target.setStringValue(type);
            }
        }
        
        /**
         * Sets (as xml) the "type" attribute
         */
        public void xsetType(org.apache.xmlbeans.XmlString type)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TYPE$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TYPE$2);
                }
                target.set(type);
            }
        }
    }
}
