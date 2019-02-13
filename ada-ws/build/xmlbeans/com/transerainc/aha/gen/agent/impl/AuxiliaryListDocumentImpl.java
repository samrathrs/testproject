/*
 * An XML document type.
 * Localname: auxiliaryList
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.AuxiliaryListDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one auxiliaryList(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class AuxiliaryListDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AuxiliaryListDocument
{
    private static final long serialVersionUID = 1L;
    
    public AuxiliaryListDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AUXILIARYLIST$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "auxiliaryList");
    
    
    /**
     * Gets the "auxiliaryList" element
     */
    public com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList getAuxiliaryList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList target = null;
            target = (com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList)get_store().find_element_user(AUXILIARYLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "auxiliaryList" element
     */
    public void setAuxiliaryList(com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList auxiliaryList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList target = null;
            target = (com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList)get_store().find_element_user(AUXILIARYLIST$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList)get_store().add_element_user(AUXILIARYLIST$0);
            }
            target.set(auxiliaryList);
        }
    }
    
    /**
     * Appends and returns a new empty "auxiliaryList" element
     */
    public com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList addNewAuxiliaryList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList target = null;
            target = (com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList)get_store().add_element_user(AUXILIARYLIST$0);
            return target;
        }
    }
    /**
     * An XML auxiliaryList(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class AuxiliaryListImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList
    {
        private static final long serialVersionUID = 1L;
        
        public AuxiliaryListImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName IDLELIST$0 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "idleList");
        private static final javax.xml.namespace.QName WRAPUPLIST$2 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "wrapUpList");
        private static final javax.xml.namespace.QName CALLVARIABLES$4 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "callVariables");
        private static final javax.xml.namespace.QName ENTERPRISEID$6 = 
            new javax.xml.namespace.QName("", "enterpriseId");
        
        
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
         * Gets the "wrapUpList" element
         */
        public com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList getWrapUpList()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList target = null;
                target = (com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList)get_store().find_element_user(WRAPUPLIST$2, 0);
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
                target = (com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList)get_store().find_element_user(WRAPUPLIST$2, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList)get_store().add_element_user(WRAPUPLIST$2);
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
                target = (com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList)get_store().add_element_user(WRAPUPLIST$2);
                return target;
            }
        }
        
        /**
         * Gets the "callVariables" element
         */
        public com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables getCallVariables()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables target = null;
                target = (com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables)get_store().find_element_user(CALLVARIABLES$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "callVariables" element
         */
        public boolean isSetCallVariables()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(CALLVARIABLES$4) != 0;
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
                target = (com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables)get_store().find_element_user(CALLVARIABLES$4, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables)get_store().add_element_user(CALLVARIABLES$4);
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
                target = (com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables)get_store().add_element_user(CALLVARIABLES$4);
                return target;
            }
        }
        
        /**
         * Unsets the "callVariables" element
         */
        public void unsetCallVariables()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(CALLVARIABLES$4, 0);
            }
        }
        
        /**
         * Gets the "enterpriseId" attribute
         */
        public java.lang.String getEnterpriseId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENTERPRISEID$6);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "enterpriseId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetEnterpriseId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ENTERPRISEID$6);
                return target;
            }
        }
        
        /**
         * True if has "enterpriseId" attribute
         */
        public boolean isSetEnterpriseId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(ENTERPRISEID$6) != null;
            }
        }
        
        /**
         * Sets the "enterpriseId" attribute
         */
        public void setEnterpriseId(java.lang.String enterpriseId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENTERPRISEID$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ENTERPRISEID$6);
                }
                target.setStringValue(enterpriseId);
            }
        }
        
        /**
         * Sets (as xml) the "enterpriseId" attribute
         */
        public void xsetEnterpriseId(org.apache.xmlbeans.XmlString enterpriseId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ENTERPRISEID$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ENTERPRISEID$6);
                }
                target.set(enterpriseId);
            }
        }
        
        /**
         * Unsets the "enterpriseId" attribute
         */
        public void unsetEnterpriseId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(ENTERPRISEID$6);
            }
        }
    }
}
