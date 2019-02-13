/*
 * An XML document type.
 * Localname: nameResolution
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.NameResolutionDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one nameResolution(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class NameResolutionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.NameResolutionDocument
{
    private static final long serialVersionUID = 1L;
    
    public NameResolutionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NAMERESOLUTION$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "nameResolution");
    
    
    /**
     * Gets the "nameResolution" element
     */
    public com.transerainc.aha.gen.agent.NameResolutionDocument.NameResolution getNameResolution()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.NameResolutionDocument.NameResolution target = null;
            target = (com.transerainc.aha.gen.agent.NameResolutionDocument.NameResolution)get_store().find_element_user(NAMERESOLUTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "nameResolution" element
     */
    public void setNameResolution(com.transerainc.aha.gen.agent.NameResolutionDocument.NameResolution nameResolution)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.NameResolutionDocument.NameResolution target = null;
            target = (com.transerainc.aha.gen.agent.NameResolutionDocument.NameResolution)get_store().find_element_user(NAMERESOLUTION$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.NameResolutionDocument.NameResolution)get_store().add_element_user(NAMERESOLUTION$0);
            }
            target.set(nameResolution);
        }
    }
    
    /**
     * Appends and returns a new empty "nameResolution" element
     */
    public com.transerainc.aha.gen.agent.NameResolutionDocument.NameResolution addNewNameResolution()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.NameResolutionDocument.NameResolution target = null;
            target = (com.transerainc.aha.gen.agent.NameResolutionDocument.NameResolution)get_store().add_element_user(NAMERESOLUTION$0);
            return target;
        }
    }
    /**
     * An XML nameResolution(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class NameResolutionImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.NameResolutionDocument.NameResolution
    {
        private static final long serialVersionUID = 1L;
        
        public NameResolutionImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName NAMERESOLUTIONPARAM$0 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "nameResolutionParam");
        private static final javax.xml.namespace.QName TYPE$2 = 
            new javax.xml.namespace.QName("", "type");
        private static final javax.xml.namespace.QName ID$4 = 
            new javax.xml.namespace.QName("", "id");
        
        
        /**
         * Gets array of all "nameResolutionParam" elements
         */
        public com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam[] getNameResolutionParamArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(NAMERESOLUTIONPARAM$0, targetList);
                com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam[] result = new com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "nameResolutionParam" element
         */
        public com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam getNameResolutionParamArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam target = null;
                target = (com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam)get_store().find_element_user(NAMERESOLUTIONPARAM$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "nameResolutionParam" element
         */
        public int sizeOfNameResolutionParamArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(NAMERESOLUTIONPARAM$0);
            }
        }
        
        /**
         * Sets array of all "nameResolutionParam" element
         */
        public void setNameResolutionParamArray(com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam[] nameResolutionParamArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(nameResolutionParamArray, NAMERESOLUTIONPARAM$0);
            }
        }
        
        /**
         * Sets ith "nameResolutionParam" element
         */
        public void setNameResolutionParamArray(int i, com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam nameResolutionParam)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam target = null;
                target = (com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam)get_store().find_element_user(NAMERESOLUTIONPARAM$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(nameResolutionParam);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "nameResolutionParam" element
         */
        public com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam insertNewNameResolutionParam(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam target = null;
                target = (com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam)get_store().insert_element_user(NAMERESOLUTIONPARAM$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "nameResolutionParam" element
         */
        public com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam addNewNameResolutionParam()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam target = null;
                target = (com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam)get_store().add_element_user(NAMERESOLUTIONPARAM$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "nameResolutionParam" element
         */
        public void removeNameResolutionParam(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(NAMERESOLUTIONPARAM$0, i);
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
        
        /**
         * Gets the "id" attribute
         */
        public java.lang.String getId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$4);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$4);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ID$4);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ID$4);
                }
                target.set(id);
            }
        }
    }
}
