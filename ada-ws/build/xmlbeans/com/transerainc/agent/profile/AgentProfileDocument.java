/*
 * An XML document type.
 * Localname: agent-profile
 * Namespace: http://agent.transerainc.com/profile
 * Java type: com.transerainc.agent.profile.AgentProfileDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.agent.profile;


/**
 * A document containing one agent-profile(@http://agent.transerainc.com/profile) element.
 *
 * This is a complex type.
 */
public interface AgentProfileDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AgentProfileDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("agentprofile835cdoctype");
    
    /**
     * Gets the "agent-profile" element
     */
    com.transerainc.agent.profile.AgentProfileDocument.AgentProfile getAgentProfile();
    
    /**
     * Sets the "agent-profile" element
     */
    void setAgentProfile(com.transerainc.agent.profile.AgentProfileDocument.AgentProfile agentProfile);
    
    /**
     * Appends and returns a new empty "agent-profile" element
     */
    com.transerainc.agent.profile.AgentProfileDocument.AgentProfile addNewAgentProfile();
    
    /**
     * An XML agent-profile(@http://agent.transerainc.com/profile).
     *
     * This is a complex type.
     */
    public interface AgentProfile extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AgentProfile.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("agentprofileb02felemtype");
        
        /**
         * Gets array of all "profile-attribute" elements
         */
        com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute[] getProfileAttributeArray();
        
        /**
         * Gets ith "profile-attribute" element
         */
        com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute getProfileAttributeArray(int i);
        
        /**
         * Returns number of "profile-attribute" element
         */
        int sizeOfProfileAttributeArray();
        
        /**
         * Sets array of all "profile-attribute" element
         */
        void setProfileAttributeArray(com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute[] profileAttributeArray);
        
        /**
         * Sets ith "profile-attribute" element
         */
        void setProfileAttributeArray(int i, com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute profileAttribute);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "profile-attribute" element
         */
        com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute insertNewProfileAttribute(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "profile-attribute" element
         */
        com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute addNewProfileAttribute();
        
        /**
         * Removes the ith "profile-attribute" element
         */
        void removeProfileAttribute(int i);
        
        /**
         * Gets array of all "entityList" elements
         */
        com.transerainc.agent.profile.EntityListDocument.EntityList[] getEntityListArray();
        
        /**
         * Gets ith "entityList" element
         */
        com.transerainc.agent.profile.EntityListDocument.EntityList getEntityListArray(int i);
        
        /**
         * Returns number of "entityList" element
         */
        int sizeOfEntityListArray();
        
        /**
         * Sets array of all "entityList" element
         */
        void setEntityListArray(com.transerainc.agent.profile.EntityListDocument.EntityList[] entityListArray);
        
        /**
         * Sets ith "entityList" element
         */
        void setEntityListArray(int i, com.transerainc.agent.profile.EntityListDocument.EntityList entityList);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "entityList" element
         */
        com.transerainc.agent.profile.EntityListDocument.EntityList insertNewEntityList(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "entityList" element
         */
        com.transerainc.agent.profile.EntityListDocument.EntityList addNewEntityList();
        
        /**
         * Removes the ith "entityList" element
         */
        void removeEntityList(int i);
        
        /**
         * Gets array of all "dialPlan" elements
         */
        com.transerainc.agent.profile.DialPlanDocument.DialPlan[] getDialPlanArray();
        
        /**
         * Gets ith "dialPlan" element
         */
        com.transerainc.agent.profile.DialPlanDocument.DialPlan getDialPlanArray(int i);
        
        /**
         * Returns number of "dialPlan" element
         */
        int sizeOfDialPlanArray();
        
        /**
         * Sets array of all "dialPlan" element
         */
        void setDialPlanArray(com.transerainc.agent.profile.DialPlanDocument.DialPlan[] dialPlanArray);
        
        /**
         * Sets ith "dialPlan" element
         */
        void setDialPlanArray(int i, com.transerainc.agent.profile.DialPlanDocument.DialPlan dialPlan);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "dialPlan" element
         */
        com.transerainc.agent.profile.DialPlanDocument.DialPlan insertNewDialPlan(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "dialPlan" element
         */
        com.transerainc.agent.profile.DialPlanDocument.DialPlan addNewDialPlan();
        
        /**
         * Removes the ith "dialPlan" element
         */
        void removeDialPlan(int i);
        
        /**
         * Gets array of all "channel-set" elements
         */
        com.transerainc.agent.profile.ChannelSetDocument.ChannelSet[] getChannelSetArray();
        
        /**
         * Gets ith "channel-set" element
         */
        com.transerainc.agent.profile.ChannelSetDocument.ChannelSet getChannelSetArray(int i);
        
        /**
         * Returns number of "channel-set" element
         */
        int sizeOfChannelSetArray();
        
        /**
         * Sets array of all "channel-set" element
         */
        void setChannelSetArray(com.transerainc.agent.profile.ChannelSetDocument.ChannelSet[] channelSetArray);
        
        /**
         * Sets ith "channel-set" element
         */
        void setChannelSetArray(int i, com.transerainc.agent.profile.ChannelSetDocument.ChannelSet channelSet);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "channel-set" element
         */
        com.transerainc.agent.profile.ChannelSetDocument.ChannelSet insertNewChannelSet(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "channel-set" element
         */
        com.transerainc.agent.profile.ChannelSetDocument.ChannelSet addNewChannelSet();
        
        /**
         * Removes the ith "channel-set" element
         */
        void removeChannelSet(int i);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.transerainc.agent.profile.AgentProfileDocument.AgentProfile newInstance() {
              return (com.transerainc.agent.profile.AgentProfileDocument.AgentProfile) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.transerainc.agent.profile.AgentProfileDocument.AgentProfile newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.transerainc.agent.profile.AgentProfileDocument.AgentProfile) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.transerainc.agent.profile.AgentProfileDocument newInstance() {
          return (com.transerainc.agent.profile.AgentProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.agent.profile.AgentProfileDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.agent.profile.AgentProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.agent.profile.AgentProfileDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.agent.profile.AgentProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.agent.profile.AgentProfileDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.agent.profile.AgentProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.agent.profile.AgentProfileDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.AgentProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.agent.profile.AgentProfileDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.AgentProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.agent.profile.AgentProfileDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.AgentProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.agent.profile.AgentProfileDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.AgentProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.agent.profile.AgentProfileDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.AgentProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.agent.profile.AgentProfileDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.AgentProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.agent.profile.AgentProfileDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.AgentProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.agent.profile.AgentProfileDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.AgentProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.agent.profile.AgentProfileDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.agent.profile.AgentProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.agent.profile.AgentProfileDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.agent.profile.AgentProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.agent.profile.AgentProfileDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.agent.profile.AgentProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.agent.profile.AgentProfileDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.agent.profile.AgentProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.agent.profile.AgentProfileDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.agent.profile.AgentProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.agent.profile.AgentProfileDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.agent.profile.AgentProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
