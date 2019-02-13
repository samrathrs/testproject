/*
 * An XML document type.
 * Localname: agentList
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.AgentListDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent;


/**
 * A document containing one agentList(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public interface AgentListDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AgentListDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("agentlistc32cdoctype");
    
    /**
     * Gets the "agentList" element
     */
    com.transerainc.aha.gen.agent.AgentListDocument.AgentList getAgentList();
    
    /**
     * Sets the "agentList" element
     */
    void setAgentList(com.transerainc.aha.gen.agent.AgentListDocument.AgentList agentList);
    
    /**
     * Appends and returns a new empty "agentList" element
     */
    com.transerainc.aha.gen.agent.AgentListDocument.AgentList addNewAgentList();
    
    /**
     * An XML agentList(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public interface AgentList extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AgentList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("agentlistb35delemtype");
        
        /**
         * Gets array of all "agent" elements
         */
        com.transerainc.aha.gen.agent.AgentDocument.Agent[] getAgentArray();
        
        /**
         * Gets ith "agent" element
         */
        com.transerainc.aha.gen.agent.AgentDocument.Agent getAgentArray(int i);
        
        /**
         * Returns number of "agent" element
         */
        int sizeOfAgentArray();
        
        /**
         * Sets array of all "agent" element
         */
        void setAgentArray(com.transerainc.aha.gen.agent.AgentDocument.Agent[] agentArray);
        
        /**
         * Sets ith "agent" element
         */
        void setAgentArray(int i, com.transerainc.aha.gen.agent.AgentDocument.Agent agent);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "agent" element
         */
        com.transerainc.aha.gen.agent.AgentDocument.Agent insertNewAgent(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "agent" element
         */
        com.transerainc.aha.gen.agent.AgentDocument.Agent addNewAgent();
        
        /**
         * Removes the ith "agent" element
         */
        void removeAgent(int i);
        
        /**
         * Gets the "authenticate" element
         */
        com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate getAuthenticate();
        
        /**
         * True if has "authenticate" element
         */
        boolean isSetAuthenticate();
        
        /**
         * Sets the "authenticate" element
         */
        void setAuthenticate(com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate authenticate);
        
        /**
         * Appends and returns a new empty "authenticate" element
         */
        com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate addNewAuthenticate();
        
        /**
         * Unsets the "authenticate" element
         */
        void unsetAuthenticate();
        
        /**
         * Gets the "authenticateStatus" element
         */
        com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus getAuthenticateStatus();
        
        /**
         * True if has "authenticateStatus" element
         */
        boolean isSetAuthenticateStatus();
        
        /**
         * Sets the "authenticateStatus" element
         */
        void setAuthenticateStatus(com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus authenticateStatus);
        
        /**
         * Appends and returns a new empty "authenticateStatus" element
         */
        com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus addNewAuthenticateStatus();
        
        /**
         * Unsets the "authenticateStatus" element
         */
        void unsetAuthenticateStatus();
        
        /**
         * Gets the "desktopConfiguration" element
         */
        com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration getDesktopConfiguration();
        
        /**
         * True if has "desktopConfiguration" element
         */
        boolean isSetDesktopConfiguration();
        
        /**
         * Sets the "desktopConfiguration" element
         */
        void setDesktopConfiguration(com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration desktopConfiguration);
        
        /**
         * Appends and returns a new empty "desktopConfiguration" element
         */
        com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration addNewDesktopConfiguration();
        
        /**
         * Unsets the "desktopConfiguration" element
         */
        void unsetDesktopConfiguration();
        
        /**
         * Gets array of all "message" elements
         */
        com.transerainc.aha.gen.agent.MessageDocument.Message[] getMessageArray();
        
        /**
         * Gets ith "message" element
         */
        com.transerainc.aha.gen.agent.MessageDocument.Message getMessageArray(int i);
        
        /**
         * Returns number of "message" element
         */
        int sizeOfMessageArray();
        
        /**
         * Sets array of all "message" element
         */
        void setMessageArray(com.transerainc.aha.gen.agent.MessageDocument.Message[] messageArray);
        
        /**
         * Sets ith "message" element
         */
        void setMessageArray(int i, com.transerainc.aha.gen.agent.MessageDocument.Message message);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "message" element
         */
        com.transerainc.aha.gen.agent.MessageDocument.Message insertNewMessage(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "message" element
         */
        com.transerainc.aha.gen.agent.MessageDocument.Message addNewMessage();
        
        /**
         * Removes the ith "message" element
         */
        void removeMessage(int i);
        
        /**
         * Gets the "virtualTeamList" element
         */
        com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList getVirtualTeamList();
        
        /**
         * True if has "virtualTeamList" element
         */
        boolean isSetVirtualTeamList();
        
        /**
         * Sets the "virtualTeamList" element
         */
        void setVirtualTeamList(com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList virtualTeamList);
        
        /**
         * Appends and returns a new empty "virtualTeamList" element
         */
        com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList addNewVirtualTeamList();
        
        /**
         * Unsets the "virtualTeamList" element
         */
        void unsetVirtualTeamList();
        
        /**
         * Gets the "agentProfileXmlData" element
         */
        java.lang.String getAgentProfileXmlData();
        
        /**
         * Gets (as xml) the "agentProfileXmlData" element
         */
        org.apache.xmlbeans.XmlString xgetAgentProfileXmlData();
        
        /**
         * True if has "agentProfileXmlData" element
         */
        boolean isSetAgentProfileXmlData();
        
        /**
         * Sets the "agentProfileXmlData" element
         */
        void setAgentProfileXmlData(java.lang.String agentProfileXmlData);
        
        /**
         * Sets (as xml) the "agentProfileXmlData" element
         */
        void xsetAgentProfileXmlData(org.apache.xmlbeans.XmlString agentProfileXmlData);
        
        /**
         * Unsets the "agentProfileXmlData" element
         */
        void unsetAgentProfileXmlData();
        
        /**
         * Gets array of all "agent-command" elements
         */
        com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand[] getAgentCommandArray();
        
        /**
         * Gets ith "agent-command" element
         */
        com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand getAgentCommandArray(int i);
        
        /**
         * Returns number of "agent-command" element
         */
        int sizeOfAgentCommandArray();
        
        /**
         * Sets array of all "agent-command" element
         */
        void setAgentCommandArray(com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand[] agentCommandArray);
        
        /**
         * Sets ith "agent-command" element
         */
        void setAgentCommandArray(int i, com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand agentCommand);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "agent-command" element
         */
        com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand insertNewAgentCommand(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "agent-command" element
         */
        com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand addNewAgentCommand();
        
        /**
         * Removes the ith "agent-command" element
         */
        void removeAgentCommand(int i);
        
        /**
         * Gets the "aepUrl" attribute
         */
        java.lang.String getAepUrl();
        
        /**
         * Gets (as xml) the "aepUrl" attribute
         */
        org.apache.xmlbeans.XmlAnyURI xgetAepUrl();
        
        /**
         * True if has "aepUrl" attribute
         */
        boolean isSetAepUrl();
        
        /**
         * Sets the "aepUrl" attribute
         */
        void setAepUrl(java.lang.String aepUrl);
        
        /**
         * Sets (as xml) the "aepUrl" attribute
         */
        void xsetAepUrl(org.apache.xmlbeans.XmlAnyURI aepUrl);
        
        /**
         * Unsets the "aepUrl" attribute
         */
        void unsetAepUrl();
        
        /**
         * Gets the "info" attribute
         */
        java.lang.String getInfo();
        
        /**
         * Gets (as xml) the "info" attribute
         */
        org.apache.xmlbeans.XmlString xgetInfo();
        
        /**
         * True if has "info" attribute
         */
        boolean isSetInfo();
        
        /**
         * Sets the "info" attribute
         */
        void setInfo(java.lang.String info);
        
        /**
         * Sets (as xml) the "info" attribute
         */
        void xsetInfo(org.apache.xmlbeans.XmlString info);
        
        /**
         * Unsets the "info" attribute
         */
        void unsetInfo();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.transerainc.aha.gen.agent.AgentListDocument.AgentList newInstance() {
              return (com.transerainc.aha.gen.agent.AgentListDocument.AgentList) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.transerainc.aha.gen.agent.AgentListDocument.AgentList newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.transerainc.aha.gen.agent.AgentListDocument.AgentList) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.transerainc.aha.gen.agent.AgentListDocument newInstance() {
          return (com.transerainc.aha.gen.agent.AgentListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.aha.gen.agent.AgentListDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.aha.gen.agent.AgentListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.aha.gen.agent.AgentListDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AgentListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AgentListDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AgentListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.aha.gen.agent.AgentListDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AgentListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AgentListDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AgentListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AgentListDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AgentListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AgentListDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AgentListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AgentListDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AgentListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AgentListDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AgentListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AgentListDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AgentListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AgentListDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AgentListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AgentListDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AgentListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AgentListDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AgentListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AgentListDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AgentListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AgentListDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AgentListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.AgentListDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.AgentListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.AgentListDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.AgentListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
