/*
 * An XML document type.
 * Localname: commandMessage
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.CommandMessageDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one commandMessage(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class CommandMessageDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.CommandMessageDocument
{
    private static final long serialVersionUID = 1L;
    
    public CommandMessageDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMMANDMESSAGE$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "commandMessage");
    
    
    /**
     * Gets the "commandMessage" element
     */
    public com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage getCommandMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage target = null;
            target = (com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage)get_store().find_element_user(COMMANDMESSAGE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "commandMessage" element
     */
    public void setCommandMessage(com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage commandMessage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage target = null;
            target = (com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage)get_store().find_element_user(COMMANDMESSAGE$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage)get_store().add_element_user(COMMANDMESSAGE$0);
            }
            target.set(commandMessage);
        }
    }
    
    /**
     * Appends and returns a new empty "commandMessage" element
     */
    public com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage addNewCommandMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage target = null;
            target = (com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage)get_store().add_element_user(COMMANDMESSAGE$0);
            return target;
        }
    }
    /**
     * An XML commandMessage(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class CommandMessageImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage
    {
        private static final long serialVersionUID = 1L;
        
        public CommandMessageImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName PARAM$0 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "param");
        
        
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
    }
}
