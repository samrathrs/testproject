/*
 * An XML document type.
 * Localname: virtualTeamList
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.VirtualTeamListDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one virtualTeamList(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class VirtualTeamListDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.VirtualTeamListDocument
{
    private static final long serialVersionUID = 1L;
    
    public VirtualTeamListDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VIRTUALTEAMLIST$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "virtualTeamList");
    
    
    /**
     * Gets the "virtualTeamList" element
     */
    public com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList getVirtualTeamList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList target = null;
            target = (com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList)get_store().find_element_user(VIRTUALTEAMLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "virtualTeamList" element
     */
    public void setVirtualTeamList(com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList virtualTeamList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList target = null;
            target = (com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList)get_store().find_element_user(VIRTUALTEAMLIST$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList)get_store().add_element_user(VIRTUALTEAMLIST$0);
            }
            target.set(virtualTeamList);
        }
    }
    
    /**
     * Appends and returns a new empty "virtualTeamList" element
     */
    public com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList addNewVirtualTeamList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList target = null;
            target = (com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList)get_store().add_element_user(VIRTUALTEAMLIST$0);
            return target;
        }
    }
    /**
     * An XML virtualTeamList(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class VirtualTeamListImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList
    {
        private static final long serialVersionUID = 1L;
        
        public VirtualTeamListImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName VIRTUALTEAM$0 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "virtualTeam");
        
        
        /**
         * Gets array of all "virtualTeam" elements
         */
        public com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam[] getVirtualTeamArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(VIRTUALTEAM$0, targetList);
                com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam[] result = new com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "virtualTeam" element
         */
        public com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam getVirtualTeamArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam target = null;
                target = (com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam)get_store().find_element_user(VIRTUALTEAM$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "virtualTeam" element
         */
        public int sizeOfVirtualTeamArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(VIRTUALTEAM$0);
            }
        }
        
        /**
         * Sets array of all "virtualTeam" element
         */
        public void setVirtualTeamArray(com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam[] virtualTeamArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(virtualTeamArray, VIRTUALTEAM$0);
            }
        }
        
        /**
         * Sets ith "virtualTeam" element
         */
        public void setVirtualTeamArray(int i, com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam virtualTeam)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam target = null;
                target = (com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam)get_store().find_element_user(VIRTUALTEAM$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(virtualTeam);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "virtualTeam" element
         */
        public com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam insertNewVirtualTeam(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam target = null;
                target = (com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam)get_store().insert_element_user(VIRTUALTEAM$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "virtualTeam" element
         */
        public com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam addNewVirtualTeam()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam target = null;
                target = (com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam)get_store().add_element_user(VIRTUALTEAM$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "virtualTeam" element
         */
        public void removeVirtualTeam(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(VIRTUALTEAM$0, i);
            }
        }
    }
}
