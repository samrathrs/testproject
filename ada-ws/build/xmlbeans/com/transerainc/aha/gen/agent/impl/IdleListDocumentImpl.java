/*
 * An XML document type.
 * Localname: idleList
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.IdleListDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one idleList(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class IdleListDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.IdleListDocument
{
    private static final long serialVersionUID = 1L;
    
    public IdleListDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName IDLELIST$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "idleList");
    
    
    /**
     * Gets the "idleList" element
     */
    public com.transerainc.aha.gen.agent.IdleListDocument.IdleList getIdleList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.IdleListDocument.IdleList target = null;
            target = (com.transerainc.aha.gen.agent.IdleListDocument.IdleList)get_store().find_element_user(IDLELIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "idleList" element
     */
    public void setIdleList(com.transerainc.aha.gen.agent.IdleListDocument.IdleList idleList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.IdleListDocument.IdleList target = null;
            target = (com.transerainc.aha.gen.agent.IdleListDocument.IdleList)get_store().find_element_user(IDLELIST$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.IdleListDocument.IdleList)get_store().add_element_user(IDLELIST$0);
            }
            target.set(idleList);
        }
    }
    
    /**
     * Appends and returns a new empty "idleList" element
     */
    public com.transerainc.aha.gen.agent.IdleListDocument.IdleList addNewIdleList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.IdleListDocument.IdleList target = null;
            target = (com.transerainc.aha.gen.agent.IdleListDocument.IdleList)get_store().add_element_user(IDLELIST$0);
            return target;
        }
    }
    /**
     * An XML idleList(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class IdleListImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.IdleListDocument.IdleList
    {
        private static final long serialVersionUID = 1L;
        
        public IdleListImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName IDS$0 = 
            new javax.xml.namespace.QName("", "ids");
        private static final javax.xml.namespace.QName NAMES$2 = 
            new javax.xml.namespace.QName("", "names");
        
        
        /**
         * Gets the "ids" attribute
         */
        public java.lang.String getIds()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(IDS$0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ids" attribute
         */
        public org.apache.xmlbeans.XmlString xgetIds()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(IDS$0);
                return target;
            }
        }
        
        /**
         * Sets the "ids" attribute
         */
        public void setIds(java.lang.String ids)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(IDS$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(IDS$0);
                }
                target.setStringValue(ids);
            }
        }
        
        /**
         * Sets (as xml) the "ids" attribute
         */
        public void xsetIds(org.apache.xmlbeans.XmlString ids)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(IDS$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(IDS$0);
                }
                target.set(ids);
            }
        }
        
        /**
         * Gets the "names" attribute
         */
        public java.lang.String getNames()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAMES$2);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "names" attribute
         */
        public org.apache.xmlbeans.XmlString xgetNames()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAMES$2);
                return target;
            }
        }
        
        /**
         * Sets the "names" attribute
         */
        public void setNames(java.lang.String names)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAMES$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAMES$2);
                }
                target.setStringValue(names);
            }
        }
        
        /**
         * Sets (as xml) the "names" attribute
         */
        public void xsetNames(org.apache.xmlbeans.XmlString names)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAMES$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAMES$2);
                }
                target.set(names);
            }
        }
    }
}
