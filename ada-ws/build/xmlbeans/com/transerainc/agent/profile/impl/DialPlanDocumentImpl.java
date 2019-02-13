/*
 * An XML document type.
 * Localname: dialPlan
 * Namespace: http://agent.transerainc.com/profile
 * Java type: com.transerainc.agent.profile.DialPlanDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.agent.profile.impl;
/**
 * A document containing one dialPlan(@http://agent.transerainc.com/profile) element.
 *
 * This is a complex type.
 */
public class DialPlanDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.agent.profile.DialPlanDocument
{
    private static final long serialVersionUID = 1L;
    
    public DialPlanDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DIALPLAN$0 = 
        new javax.xml.namespace.QName("http://agent.transerainc.com/profile", "dialPlan");
    
    
    /**
     * Gets the "dialPlan" element
     */
    public com.transerainc.agent.profile.DialPlanDocument.DialPlan getDialPlan()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.DialPlanDocument.DialPlan target = null;
            target = (com.transerainc.agent.profile.DialPlanDocument.DialPlan)get_store().find_element_user(DIALPLAN$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "dialPlan" element
     */
    public void setDialPlan(com.transerainc.agent.profile.DialPlanDocument.DialPlan dialPlan)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.DialPlanDocument.DialPlan target = null;
            target = (com.transerainc.agent.profile.DialPlanDocument.DialPlan)get_store().find_element_user(DIALPLAN$0, 0);
            if (target == null)
            {
                target = (com.transerainc.agent.profile.DialPlanDocument.DialPlan)get_store().add_element_user(DIALPLAN$0);
            }
            target.set(dialPlan);
        }
    }
    
    /**
     * Appends and returns a new empty "dialPlan" element
     */
    public com.transerainc.agent.profile.DialPlanDocument.DialPlan addNewDialPlan()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.DialPlanDocument.DialPlan target = null;
            target = (com.transerainc.agent.profile.DialPlanDocument.DialPlan)get_store().add_element_user(DIALPLAN$0);
            return target;
        }
    }
    /**
     * An XML dialPlan(@http://agent.transerainc.com/profile).
     *
     * This is a complex type.
     */
    public static class DialPlanImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.agent.profile.DialPlanDocument.DialPlan
    {
        private static final long serialVersionUID = 1L;
        
        public DialPlanImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName DIALPLANENTITY$0 = 
            new javax.xml.namespace.QName("http://agent.transerainc.com/profile", "dialPlanEntity");
        private static final javax.xml.namespace.QName TYPE$2 = 
            new javax.xml.namespace.QName("", "type");
        
        
        /**
         * Gets array of all "dialPlanEntity" elements
         */
        public com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity[] getDialPlanEntityArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(DIALPLANENTITY$0, targetList);
                com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity[] result = new com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "dialPlanEntity" element
         */
        public com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity getDialPlanEntityArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity target = null;
                target = (com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity)get_store().find_element_user(DIALPLANENTITY$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "dialPlanEntity" element
         */
        public int sizeOfDialPlanEntityArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(DIALPLANENTITY$0);
            }
        }
        
        /**
         * Sets array of all "dialPlanEntity" element
         */
        public void setDialPlanEntityArray(com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity[] dialPlanEntityArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(dialPlanEntityArray, DIALPLANENTITY$0);
            }
        }
        
        /**
         * Sets ith "dialPlanEntity" element
         */
        public void setDialPlanEntityArray(int i, com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity dialPlanEntity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity target = null;
                target = (com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity)get_store().find_element_user(DIALPLANENTITY$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(dialPlanEntity);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "dialPlanEntity" element
         */
        public com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity insertNewDialPlanEntity(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity target = null;
                target = (com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity)get_store().insert_element_user(DIALPLANENTITY$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "dialPlanEntity" element
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
         * Removes the ith "dialPlanEntity" element
         */
        public void removeDialPlanEntity(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(DIALPLANENTITY$0, i);
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
