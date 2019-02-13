/*
 * An XML document type.
 * Localname: agentControlCommand
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.AgentControlCommandDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one agentControlCommand(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class AgentControlCommandDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AgentControlCommandDocument
{
    private static final long serialVersionUID = 1L;
    
    public AgentControlCommandDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AGENTCONTROLCOMMAND$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "agentControlCommand");
    
    
    /**
     * Gets the "agentControlCommand" element
     */
    public com.transerainc.aha.gen.agent.AgentControlCommandDocument.AgentControlCommand getAgentControlCommand()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AgentControlCommandDocument.AgentControlCommand target = null;
            target = (com.transerainc.aha.gen.agent.AgentControlCommandDocument.AgentControlCommand)get_store().find_element_user(AGENTCONTROLCOMMAND$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "agentControlCommand" element
     */
    public void setAgentControlCommand(com.transerainc.aha.gen.agent.AgentControlCommandDocument.AgentControlCommand agentControlCommand)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AgentControlCommandDocument.AgentControlCommand target = null;
            target = (com.transerainc.aha.gen.agent.AgentControlCommandDocument.AgentControlCommand)get_store().find_element_user(AGENTCONTROLCOMMAND$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.AgentControlCommandDocument.AgentControlCommand)get_store().add_element_user(AGENTCONTROLCOMMAND$0);
            }
            target.set(agentControlCommand);
        }
    }
    
    /**
     * Appends and returns a new empty "agentControlCommand" element
     */
    public com.transerainc.aha.gen.agent.AgentControlCommandDocument.AgentControlCommand addNewAgentControlCommand()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AgentControlCommandDocument.AgentControlCommand target = null;
            target = (com.transerainc.aha.gen.agent.AgentControlCommandDocument.AgentControlCommand)get_store().add_element_user(AGENTCONTROLCOMMAND$0);
            return target;
        }
    }
    /**
     * An XML agentControlCommand(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class AgentControlCommandImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AgentControlCommandDocument.AgentControlCommand
    {
        private static final long serialVersionUID = 1L;
        
        public AgentControlCommandImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName PARAM$0 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "param");
        private static final javax.xml.namespace.QName NAME$2 = 
            new javax.xml.namespace.QName("", "name");
        
        
        /**
         * Gets array of all "param" elements
         */
        public com.transerainc.aha.gen.agent.ParamDocument.Param[] getParamArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(PARAM$0, targetList);
                com.transerainc.aha.gen.agent.ParamDocument.Param[] result = new com.transerainc.aha.gen.agent.ParamDocument.Param[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "param" element
         */
        public com.transerainc.aha.gen.agent.ParamDocument.Param getParamArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ParamDocument.Param target = null;
                target = (com.transerainc.aha.gen.agent.ParamDocument.Param)get_store().find_element_user(PARAM$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "param" element
         */
        public int sizeOfParamArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(PARAM$0);
            }
        }
        
        /**
         * Sets array of all "param" element
         */
        public void setParamArray(com.transerainc.aha.gen.agent.ParamDocument.Param[] paramArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(paramArray, PARAM$0);
            }
        }
        
        /**
         * Sets ith "param" element
         */
        public void setParamArray(int i, com.transerainc.aha.gen.agent.ParamDocument.Param param)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ParamDocument.Param target = null;
                target = (com.transerainc.aha.gen.agent.ParamDocument.Param)get_store().find_element_user(PARAM$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(param);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "param" element
         */
        public com.transerainc.aha.gen.agent.ParamDocument.Param insertNewParam(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ParamDocument.Param target = null;
                target = (com.transerainc.aha.gen.agent.ParamDocument.Param)get_store().insert_element_user(PARAM$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "param" element
         */
        public com.transerainc.aha.gen.agent.ParamDocument.Param addNewParam()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.ParamDocument.Param target = null;
                target = (com.transerainc.aha.gen.agent.ParamDocument.Param)get_store().add_element_user(PARAM$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "param" element
         */
        public void removeParam(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(PARAM$0, i);
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
    }
}
