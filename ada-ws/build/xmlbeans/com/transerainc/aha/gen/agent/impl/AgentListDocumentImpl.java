/*
 * An XML document type.
 * Localname: agentList
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.AgentListDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one agentList(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class AgentListDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AgentListDocument
{
    private static final long serialVersionUID = 1L;
    
    public AgentListDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AGENTLIST$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "agentList");
    
    
    /**
     * Gets the "agentList" element
     */
    public com.transerainc.aha.gen.agent.AgentListDocument.AgentList getAgentList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AgentListDocument.AgentList target = null;
            target = (com.transerainc.aha.gen.agent.AgentListDocument.AgentList)get_store().find_element_user(AGENTLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "agentList" element
     */
    public void setAgentList(com.transerainc.aha.gen.agent.AgentListDocument.AgentList agentList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AgentListDocument.AgentList target = null;
            target = (com.transerainc.aha.gen.agent.AgentListDocument.AgentList)get_store().find_element_user(AGENTLIST$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.AgentListDocument.AgentList)get_store().add_element_user(AGENTLIST$0);
            }
            target.set(agentList);
        }
    }
    
    /**
     * Appends and returns a new empty "agentList" element
     */
    public com.transerainc.aha.gen.agent.AgentListDocument.AgentList addNewAgentList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.AgentListDocument.AgentList target = null;
            target = (com.transerainc.aha.gen.agent.AgentListDocument.AgentList)get_store().add_element_user(AGENTLIST$0);
            return target;
        }
    }
    /**
     * An XML agentList(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class AgentListImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AgentListDocument.AgentList
    {
        private static final long serialVersionUID = 1L;
        
        public AgentListImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName AGENT$0 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "agent");
        private static final javax.xml.namespace.QName AUTHENTICATE$2 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "authenticate");
        private static final javax.xml.namespace.QName AUTHENTICATESTATUS$4 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "authenticateStatus");
        private static final javax.xml.namespace.QName DESKTOPCONFIGURATION$6 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "desktopConfiguration");
        private static final javax.xml.namespace.QName MESSAGE$8 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "message");
        private static final javax.xml.namespace.QName VIRTUALTEAMLIST$10 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "virtualTeamList");
        private static final javax.xml.namespace.QName AGENTPROFILEXMLDATA$12 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "agentProfileXmlData");
        private static final javax.xml.namespace.QName AGENTCOMMAND$14 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "agent-command");
        private static final javax.xml.namespace.QName AEPURL$16 = 
            new javax.xml.namespace.QName("", "aepUrl");
        private static final javax.xml.namespace.QName INFO$18 = 
            new javax.xml.namespace.QName("", "info");
        
        
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
        
        /**
         * Gets the "authenticate" element
         */
        public com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate getAuthenticate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate target = null;
                target = (com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate)get_store().find_element_user(AUTHENTICATE$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "authenticate" element
         */
        public boolean isSetAuthenticate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(AUTHENTICATE$2) != 0;
            }
        }
        
        /**
         * Sets the "authenticate" element
         */
        public void setAuthenticate(com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate authenticate)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate target = null;
                target = (com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate)get_store().find_element_user(AUTHENTICATE$2, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate)get_store().add_element_user(AUTHENTICATE$2);
                }
                target.set(authenticate);
            }
        }
        
        /**
         * Appends and returns a new empty "authenticate" element
         */
        public com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate addNewAuthenticate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate target = null;
                target = (com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate)get_store().add_element_user(AUTHENTICATE$2);
                return target;
            }
        }
        
        /**
         * Unsets the "authenticate" element
         */
        public void unsetAuthenticate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(AUTHENTICATE$2, 0);
            }
        }
        
        /**
         * Gets the "authenticateStatus" element
         */
        public com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus getAuthenticateStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus target = null;
                target = (com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus)get_store().find_element_user(AUTHENTICATESTATUS$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "authenticateStatus" element
         */
        public boolean isSetAuthenticateStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(AUTHENTICATESTATUS$4) != 0;
            }
        }
        
        /**
         * Sets the "authenticateStatus" element
         */
        public void setAuthenticateStatus(com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus authenticateStatus)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus target = null;
                target = (com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus)get_store().find_element_user(AUTHENTICATESTATUS$4, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus)get_store().add_element_user(AUTHENTICATESTATUS$4);
                }
                target.set(authenticateStatus);
            }
        }
        
        /**
         * Appends and returns a new empty "authenticateStatus" element
         */
        public com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus addNewAuthenticateStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus target = null;
                target = (com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus)get_store().add_element_user(AUTHENTICATESTATUS$4);
                return target;
            }
        }
        
        /**
         * Unsets the "authenticateStatus" element
         */
        public void unsetAuthenticateStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(AUTHENTICATESTATUS$4, 0);
            }
        }
        
        /**
         * Gets the "desktopConfiguration" element
         */
        public com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration getDesktopConfiguration()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration target = null;
                target = (com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration)get_store().find_element_user(DESKTOPCONFIGURATION$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "desktopConfiguration" element
         */
        public boolean isSetDesktopConfiguration()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(DESKTOPCONFIGURATION$6) != 0;
            }
        }
        
        /**
         * Sets the "desktopConfiguration" element
         */
        public void setDesktopConfiguration(com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration desktopConfiguration)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration target = null;
                target = (com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration)get_store().find_element_user(DESKTOPCONFIGURATION$6, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration)get_store().add_element_user(DESKTOPCONFIGURATION$6);
                }
                target.set(desktopConfiguration);
            }
        }
        
        /**
         * Appends and returns a new empty "desktopConfiguration" element
         */
        public com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration addNewDesktopConfiguration()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration target = null;
                target = (com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration)get_store().add_element_user(DESKTOPCONFIGURATION$6);
                return target;
            }
        }
        
        /**
         * Unsets the "desktopConfiguration" element
         */
        public void unsetDesktopConfiguration()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(DESKTOPCONFIGURATION$6, 0);
            }
        }
        
        /**
         * Gets array of all "message" elements
         */
        public com.transerainc.aha.gen.agent.MessageDocument.Message[] getMessageArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(MESSAGE$8, targetList);
                com.transerainc.aha.gen.agent.MessageDocument.Message[] result = new com.transerainc.aha.gen.agent.MessageDocument.Message[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "message" element
         */
        public com.transerainc.aha.gen.agent.MessageDocument.Message getMessageArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.MessageDocument.Message target = null;
                target = (com.transerainc.aha.gen.agent.MessageDocument.Message)get_store().find_element_user(MESSAGE$8, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "message" element
         */
        public int sizeOfMessageArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(MESSAGE$8);
            }
        }
        
        /**
         * Sets array of all "message" element
         */
        public void setMessageArray(com.transerainc.aha.gen.agent.MessageDocument.Message[] messageArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(messageArray, MESSAGE$8);
            }
        }
        
        /**
         * Sets ith "message" element
         */
        public void setMessageArray(int i, com.transerainc.aha.gen.agent.MessageDocument.Message message)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.MessageDocument.Message target = null;
                target = (com.transerainc.aha.gen.agent.MessageDocument.Message)get_store().find_element_user(MESSAGE$8, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(message);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "message" element
         */
        public com.transerainc.aha.gen.agent.MessageDocument.Message insertNewMessage(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.MessageDocument.Message target = null;
                target = (com.transerainc.aha.gen.agent.MessageDocument.Message)get_store().insert_element_user(MESSAGE$8, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "message" element
         */
        public com.transerainc.aha.gen.agent.MessageDocument.Message addNewMessage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.MessageDocument.Message target = null;
                target = (com.transerainc.aha.gen.agent.MessageDocument.Message)get_store().add_element_user(MESSAGE$8);
                return target;
            }
        }
        
        /**
         * Removes the ith "message" element
         */
        public void removeMessage(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(MESSAGE$8, i);
            }
        }
        
        /**
         * Gets the "virtualTeamList" element
         */
        public com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList getVirtualTeamList()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList target = null;
                target = (com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList)get_store().find_element_user(VIRTUALTEAMLIST$10, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "virtualTeamList" element
         */
        public boolean isSetVirtualTeamList()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(VIRTUALTEAMLIST$10) != 0;
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
                target = (com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList)get_store().find_element_user(VIRTUALTEAMLIST$10, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList)get_store().add_element_user(VIRTUALTEAMLIST$10);
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
                target = (com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList)get_store().add_element_user(VIRTUALTEAMLIST$10);
                return target;
            }
        }
        
        /**
         * Unsets the "virtualTeamList" element
         */
        public void unsetVirtualTeamList()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(VIRTUALTEAMLIST$10, 0);
            }
        }
        
        /**
         * Gets the "agentProfileXmlData" element
         */
        public java.lang.String getAgentProfileXmlData()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AGENTPROFILEXMLDATA$12, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "agentProfileXmlData" element
         */
        public org.apache.xmlbeans.XmlString xgetAgentProfileXmlData()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AGENTPROFILEXMLDATA$12, 0);
                return target;
            }
        }
        
        /**
         * True if has "agentProfileXmlData" element
         */
        public boolean isSetAgentProfileXmlData()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(AGENTPROFILEXMLDATA$12) != 0;
            }
        }
        
        /**
         * Sets the "agentProfileXmlData" element
         */
        public void setAgentProfileXmlData(java.lang.String agentProfileXmlData)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AGENTPROFILEXMLDATA$12, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AGENTPROFILEXMLDATA$12);
                }
                target.setStringValue(agentProfileXmlData);
            }
        }
        
        /**
         * Sets (as xml) the "agentProfileXmlData" element
         */
        public void xsetAgentProfileXmlData(org.apache.xmlbeans.XmlString agentProfileXmlData)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AGENTPROFILEXMLDATA$12, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(AGENTPROFILEXMLDATA$12);
                }
                target.set(agentProfileXmlData);
            }
        }
        
        /**
         * Unsets the "agentProfileXmlData" element
         */
        public void unsetAgentProfileXmlData()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(AGENTPROFILEXMLDATA$12, 0);
            }
        }
        
        /**
         * Gets array of all "agent-command" elements
         */
        public com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand[] getAgentCommandArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(AGENTCOMMAND$14, targetList);
                com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand[] result = new com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "agent-command" element
         */
        public com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand getAgentCommandArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand target = null;
                target = (com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand)get_store().find_element_user(AGENTCOMMAND$14, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "agent-command" element
         */
        public int sizeOfAgentCommandArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(AGENTCOMMAND$14);
            }
        }
        
        /**
         * Sets array of all "agent-command" element
         */
        public void setAgentCommandArray(com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand[] agentCommandArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(agentCommandArray, AGENTCOMMAND$14);
            }
        }
        
        /**
         * Sets ith "agent-command" element
         */
        public void setAgentCommandArray(int i, com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand agentCommand)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand target = null;
                target = (com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand)get_store().find_element_user(AGENTCOMMAND$14, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(agentCommand);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "agent-command" element
         */
        public com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand insertNewAgentCommand(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand target = null;
                target = (com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand)get_store().insert_element_user(AGENTCOMMAND$14, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "agent-command" element
         */
        public com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand addNewAgentCommand()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand target = null;
                target = (com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand)get_store().add_element_user(AGENTCOMMAND$14);
                return target;
            }
        }
        
        /**
         * Removes the ith "agent-command" element
         */
        public void removeAgentCommand(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(AGENTCOMMAND$14, i);
            }
        }
        
        /**
         * Gets the "aepUrl" attribute
         */
        public java.lang.String getAepUrl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AEPURL$16);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "aepUrl" attribute
         */
        public org.apache.xmlbeans.XmlAnyURI xgetAepUrl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(AEPURL$16);
                return target;
            }
        }
        
        /**
         * True if has "aepUrl" attribute
         */
        public boolean isSetAepUrl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(AEPURL$16) != null;
            }
        }
        
        /**
         * Sets the "aepUrl" attribute
         */
        public void setAepUrl(java.lang.String aepUrl)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AEPURL$16);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AEPURL$16);
                }
                target.setStringValue(aepUrl);
            }
        }
        
        /**
         * Sets (as xml) the "aepUrl" attribute
         */
        public void xsetAepUrl(org.apache.xmlbeans.XmlAnyURI aepUrl)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(AEPURL$16);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(AEPURL$16);
                }
                target.set(aepUrl);
            }
        }
        
        /**
         * Unsets the "aepUrl" attribute
         */
        public void unsetAepUrl()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(AEPURL$16);
            }
        }
        
        /**
         * Gets the "info" attribute
         */
        public java.lang.String getInfo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(INFO$18);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "info" attribute
         */
        public org.apache.xmlbeans.XmlString xgetInfo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(INFO$18);
                return target;
            }
        }
        
        /**
         * True if has "info" attribute
         */
        public boolean isSetInfo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(INFO$18) != null;
            }
        }
        
        /**
         * Sets the "info" attribute
         */
        public void setInfo(java.lang.String info)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(INFO$18);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(INFO$18);
                }
                target.setStringValue(info);
            }
        }
        
        /**
         * Sets (as xml) the "info" attribute
         */
        public void xsetInfo(org.apache.xmlbeans.XmlString info)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(INFO$18);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(INFO$18);
                }
                target.set(info);
            }
        }
        
        /**
         * Unsets the "info" attribute
         */
        public void unsetInfo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(INFO$18);
            }
        }
    }
}
