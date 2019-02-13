/*
 * An XML document type.
 * Localname: routing-data
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.RoutingDataDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent;


/**
 * A document containing one routing-data(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public interface RoutingDataDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(RoutingDataDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("routingdata34ccdoctype");
    
    /**
     * Gets the "routing-data" element
     */
    com.transerainc.aha.gen.agent.RoutingDataDocument.RoutingData getRoutingData();
    
    /**
     * Sets the "routing-data" element
     */
    void setRoutingData(com.transerainc.aha.gen.agent.RoutingDataDocument.RoutingData routingData);
    
    /**
     * Appends and returns a new empty "routing-data" element
     */
    com.transerainc.aha.gen.agent.RoutingDataDocument.RoutingData addNewRoutingData();
    
    /**
     * An XML routing-data(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public interface RoutingData extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(RoutingData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("routingdataa939elemtype");
        
        /**
         * Gets the "media-profile" element
         */
        com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile getMediaProfile();
        
        /**
         * Sets the "media-profile" element
         */
        void setMediaProfile(com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile mediaProfile);
        
        /**
         * Appends and returns a new empty "media-profile" element
         */
        com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile addNewMediaProfile();
        
        /**
         * Gets the "skill-set" element
         */
        com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet getSkillSet();
        
        /**
         * True if has "skill-set" element
         */
        boolean isSetSkillSet();
        
        /**
         * Sets the "skill-set" element
         */
        void setSkillSet(com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet skillSet);
        
        /**
         * Appends and returns a new empty "skill-set" element
         */
        com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet addNewSkillSet();
        
        /**
         * Unsets the "skill-set" element
         */
        void unsetSkillSet();
        
        /**
         * Gets the "agentId" attribute
         */
        java.lang.String getAgentId();
        
        /**
         * Gets (as xml) the "agentId" attribute
         */
        org.apache.xmlbeans.XmlString xgetAgentId();
        
        /**
         * True if has "agentId" attribute
         */
        boolean isSetAgentId();
        
        /**
         * Sets the "agentId" attribute
         */
        void setAgentId(java.lang.String agentId);
        
        /**
         * Sets (as xml) the "agentId" attribute
         */
        void xsetAgentId(org.apache.xmlbeans.XmlString agentId);
        
        /**
         * Unsets the "agentId" attribute
         */
        void unsetAgentId();
        
        /**
         * Gets the "teamId" attribute
         */
        java.lang.String getTeamId();
        
        /**
         * Gets (as xml) the "teamId" attribute
         */
        org.apache.xmlbeans.XmlString xgetTeamId();
        
        /**
         * True if has "teamId" attribute
         */
        boolean isSetTeamId();
        
        /**
         * Sets the "teamId" attribute
         */
        void setTeamId(java.lang.String teamId);
        
        /**
         * Sets (as xml) the "teamId" attribute
         */
        void xsetTeamId(org.apache.xmlbeans.XmlString teamId);
        
        /**
         * Unsets the "teamId" attribute
         */
        void unsetTeamId();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.transerainc.aha.gen.agent.RoutingDataDocument.RoutingData newInstance() {
              return (com.transerainc.aha.gen.agent.RoutingDataDocument.RoutingData) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.transerainc.aha.gen.agent.RoutingDataDocument.RoutingData newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.transerainc.aha.gen.agent.RoutingDataDocument.RoutingData) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.transerainc.aha.gen.agent.RoutingDataDocument newInstance() {
          return (com.transerainc.aha.gen.agent.RoutingDataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.aha.gen.agent.RoutingDataDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.aha.gen.agent.RoutingDataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.aha.gen.agent.RoutingDataDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.RoutingDataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.aha.gen.agent.RoutingDataDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.RoutingDataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.aha.gen.agent.RoutingDataDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.RoutingDataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.aha.gen.agent.RoutingDataDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.RoutingDataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.aha.gen.agent.RoutingDataDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.RoutingDataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.aha.gen.agent.RoutingDataDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.RoutingDataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.aha.gen.agent.RoutingDataDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.RoutingDataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.aha.gen.agent.RoutingDataDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.RoutingDataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.aha.gen.agent.RoutingDataDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.RoutingDataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.aha.gen.agent.RoutingDataDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.RoutingDataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.aha.gen.agent.RoutingDataDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.RoutingDataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.aha.gen.agent.RoutingDataDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.RoutingDataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.aha.gen.agent.RoutingDataDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.RoutingDataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.aha.gen.agent.RoutingDataDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.RoutingDataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.RoutingDataDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.RoutingDataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.RoutingDataDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.RoutingDataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
