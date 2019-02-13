/*
 * An XML document type.
 * Localname: wrapUpList
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.WrapUpListDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one wrapUpList(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class WrapUpListDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.WrapUpListDocument
{
    private static final long serialVersionUID = 1L;
    
    public WrapUpListDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WRAPUPLIST$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "wrapUpList");
    
    
    /**
     * Gets the "wrapUpList" element
     */
    public com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList getWrapUpList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList target = null;
            target = (com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList)get_store().find_element_user(WRAPUPLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "wrapUpList" element
     */
    public void setWrapUpList(com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList wrapUpList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList target = null;
            target = (com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList)get_store().find_element_user(WRAPUPLIST$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList)get_store().add_element_user(WRAPUPLIST$0);
            }
            target.set(wrapUpList);
        }
    }
    
    /**
     * Appends and returns a new empty "wrapUpList" element
     */
    public com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList addNewWrapUpList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList target = null;
            target = (com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList)get_store().add_element_user(WRAPUPLIST$0);
            return target;
        }
    }
    /**
     * An XML wrapUpList(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class WrapUpListImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList
    {
        private static final long serialVersionUID = 1L;
        
        public WrapUpListImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName IDS$0 = 
            new javax.xml.namespace.QName("", "ids");
        private static final javax.xml.namespace.QName NAMES$2 = 
            new javax.xml.namespace.QName("", "names");
        private static final javax.xml.namespace.QName INTERVAL$4 = 
            new javax.xml.namespace.QName("", "interval");
        
        
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
        
        /**
         * Gets the "interval" attribute
         */
        public long getInterval()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(INTERVAL$4);
                if (target == null)
                {
                    return 0L;
                }
                return target.getLongValue();
            }
        }
        
        /**
         * Gets (as xml) the "interval" attribute
         */
        public org.apache.xmlbeans.XmlLong xgetInterval()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlLong target = null;
                target = (org.apache.xmlbeans.XmlLong)get_store().find_attribute_user(INTERVAL$4);
                return target;
            }
        }
        
        /**
         * True if has "interval" attribute
         */
        public boolean isSetInterval()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(INTERVAL$4) != null;
            }
        }
        
        /**
         * Sets the "interval" attribute
         */
        public void setInterval(long interval)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(INTERVAL$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(INTERVAL$4);
                }
                target.setLongValue(interval);
            }
        }
        
        /**
         * Sets (as xml) the "interval" attribute
         */
        public void xsetInterval(org.apache.xmlbeans.XmlLong interval)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlLong target = null;
                target = (org.apache.xmlbeans.XmlLong)get_store().find_attribute_user(INTERVAL$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlLong)get_store().add_attribute_user(INTERVAL$4);
                }
                target.set(interval);
            }
        }
        
        /**
         * Unsets the "interval" attribute
         */
        public void unsetInterval()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(INTERVAL$4);
            }
        }
    }
}
