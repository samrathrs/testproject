/*
 * An XML document type.
 * Localname: agents
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.AgentsDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one agents(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class AgentsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AgentsDocument
{
    private static final long serialVersionUID = 1L;
    
    public AgentsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AGENTS$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "agents");
    
    
    /**
     * Gets the "agents" element
     */
    public com.transerainc.aha.gen.agent.AgentsDocument.Agents getAgents()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AgentsDocument.Agents target = null;
            target = (com.transerainc.aha.gen.agent.AgentsDocument.Agents)get_store().find_element_user(AGENTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "agents" element
     */
    public void setAgents(com.transerainc.aha.gen.agent.AgentsDocument.Agents agents)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AgentsDocument.Agents target = null;
            target = (com.transerainc.aha.gen.agent.AgentsDocument.Agents)get_store().find_element_user(AGENTS$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.AgentsDocument.Agents)get_store().add_element_user(AGENTS$0);
            }
            target.set(agents);
        }
    }
    
    /**
     * Appends and returns a new empty "agents" element
     */
    public com.transerainc.aha.gen.agent.AgentsDocument.Agents addNewAgents()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AgentsDocument.Agents target = null;
            target = (com.transerainc.aha.gen.agent.AgentsDocument.Agents)get_store().add_element_user(AGENTS$0);
            return target;
        }
    }
    /**
     * An XML agents(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class AgentsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AgentsDocument.Agents
    {
        private static final long serialVersionUID = 1L;
        
        public AgentsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName AGENT$0 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "agent");
        
        
        /**
         * Gets array of all "agent" elements
         */
        public com.transerainc.aha.gen.agent.AgentDocument.Agent[] getAgentArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(AGENT$0, targetList);
                com.transerainc.aha.gen.agent.AgentDocument.Agent[] result = new com.transerainc.aha.gen.agent.AgentDocument.Agent[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "agent" element
         */
        public com.transerainc.aha.gen.agent.AgentDocument.Agent getAgentArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AgentDocument.Agent target = null;
                target = (com.transerainc.aha.gen.agent.AgentDocument.Agent)get_store().find_element_user(AGENT$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "agent" element
         */
        public int sizeOfAgentArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(AGENT$0);
            }
        }
        
        /**
         * Sets array of all "agent" element
         */
        public void setAgentArray(com.transerainc.aha.gen.agent.AgentDocument.Agent[] agentArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(agentArray, AGENT$0);
            }
        }
        
        /**
         * Sets ith "agent" element
         */
        public void setAgentArray(int i, com.transerainc.aha.gen.agent.AgentDocument.Agent agent)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AgentDocument.Agent target = null;
                target = (com.transerainc.aha.gen.agent.AgentDocument.Agent)get_store().find_element_user(AGENT$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(agent);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "agent" element
         */
        public com.transerainc.aha.gen.agent.AgentDocument.Agent insertNewAgent(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AgentDocument.Agent target = null;
                target = (com.transerainc.aha.gen.agent.AgentDocument.Agent)get_store().insert_element_user(AGENT$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "agent" element
         */
        public com.transerainc.aha.gen.agent.AgentDocument.Agent addNewAgent()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AgentDocument.Agent target = null;
                target = (com.transerainc.aha.gen.agent.AgentDocument.Agent)get_store().add_element_user(AGENT$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "agent" element
         */
        public void removeAgent(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(AGENT$0, i);
            }
        }
    }
}
