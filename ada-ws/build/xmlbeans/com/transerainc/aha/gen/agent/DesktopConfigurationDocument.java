/*
 * An XML document type.
 * Localname: desktopConfiguration
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.DesktopConfigurationDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent;


/**
 * A document containing one desktopConfiguration(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public interface DesktopConfigurationDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DesktopConfigurationDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("desktopconfiguration6583doctype");
    
    /**
     * Gets the "desktopConfiguration" element
     */
    com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration getDesktopConfiguration();
    
    /**
     * Sets the "desktopConfiguration" element
     */
    void setDesktopConfiguration(com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration desktopConfiguration);
    
    /**
     * Appends and returns a new empty "desktopConfiguration" element
     */
    com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration addNewDesktopConfiguration();
    
    /**
     * An XML desktopConfiguration(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public interface DesktopConfiguration extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DesktopConfiguration.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("desktopconfiguration7f59elemtype");
        
        /**
         * Gets the "auxiliaryList" element
         */
        com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList getAuxiliaryList();
        
        /**
         * Sets the "auxiliaryList" element
         */
        void setAuxiliaryList(com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList auxiliaryList);
        
        /**
         * Appends and returns a new empty "auxiliaryList" element
         */
        com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList addNewAuxiliaryList();
        
        /**
         * Gets the "agentProfileXmlData" element
         */
        java.lang.String getAgentProfileXmlData();
        
        /**
         * Gets (as xml) the "agentProfileXmlData" element
         */
        org.apache.xmlbeans.XmlString xgetAgentProfileXmlData();
        
        /**
         * Sets the "agentProfileXmlData" element
         */
        void setAgentProfileXmlData(java.lang.String agentProfileXmlData);
        
        /**
         * Sets (as xml) the "agentProfileXmlData" element
         */
        void xsetAgentProfileXmlData(org.apache.xmlbeans.XmlString agentProfileXmlData);
        
        /**
         * Gets array of all "attribute" elements
         */
        com.transerainc.aha.gen.agent.AttributeDocument.Attribute[] getAttributeArray();
        
        /**
         * Gets ith "attribute" element
         */
        com.transerainc.aha.gen.agent.AttributeDocument.Attribute getAttributeArray(int i);
        
        /**
         * Returns number of "attribute" element
         */
        int sizeOfAttributeArray();
        
        /**
         * Sets array of all "attribute" element
         */
        void setAttributeArray(com.transerainc.aha.gen.agent.AttributeDocument.Attribute[] attributeArray);
        
        /**
         * Sets ith "attribute" element
         */
        void setAttributeArray(int i, com.transerainc.aha.gen.agent.AttributeDocument.Attribute attribute);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "attribute" element
         */
        com.transerainc.aha.gen.agent.AttributeDocument.Attribute insertNewAttribute(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "attribute" element
         */
        com.transerainc.aha.gen.agent.AttributeDocument.Attribute addNewAttribute();
        
        /**
         * Removes the ith "attribute" element
         */
        void removeAttribute(int i);
        
        /**
         * Gets the "protocolVersion" attribute
         */
        java.lang.String getProtocolVersion();
        
        /**
         * Gets (as xml) the "protocolVersion" attribute
         */
        org.apache.xmlbeans.XmlString xgetProtocolVersion();
        
        /**
         * True if has "protocolVersion" attribute
         */
        boolean isSetProtocolVersion();
        
        /**
         * Sets the "protocolVersion" attribute
         */
        void setProtocolVersion(java.lang.String protocolVersion);
        
        /**
         * Sets (as xml) the "protocolVersion" attribute
         */
        void xsetProtocolVersion(org.apache.xmlbeans.XmlString protocolVersion);
        
        /**
         * Unsets the "protocolVersion" attribute
         */
        void unsetProtocolVersion();
        
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
         * Gets the "siteId" attribute
         */
        int getSiteId();
        
        /**
         * Gets (as xml) the "siteId" attribute
         */
        org.apache.xmlbeans.XmlInt xgetSiteId();
        
        /**
         * True if has "siteId" attribute
         */
        boolean isSetSiteId();
        
        /**
         * Sets the "siteId" attribute
         */
        void setSiteId(int siteId);
        
        /**
         * Sets (as xml) the "siteId" attribute
         */
        void xsetSiteId(org.apache.xmlbeans.XmlInt siteId);
        
        /**
         * Unsets the "siteId" attribute
         */
        void unsetSiteId();
        
        /**
         * Gets the "siteName" attribute
         */
        java.lang.String getSiteName();
        
        /**
         * Gets (as xml) the "siteName" attribute
         */
        org.apache.xmlbeans.XmlString xgetSiteName();
        
        /**
         * True if has "siteName" attribute
         */
        boolean isSetSiteName();
        
        /**
         * Sets the "siteName" attribute
         */
        void setSiteName(java.lang.String siteName);
        
        /**
         * Sets (as xml) the "siteName" attribute
         */
        void xsetSiteName(org.apache.xmlbeans.XmlString siteName);
        
        /**
         * Unsets the "siteName" attribute
         */
        void unsetSiteName();
        
        /**
         * Gets the "teamIds" attribute
         */
        java.lang.String getTeamIds();
        
        /**
         * Gets (as xml) the "teamIds" attribute
         */
        org.apache.xmlbeans.XmlString xgetTeamIds();
        
        /**
         * True if has "teamIds" attribute
         */
        boolean isSetTeamIds();
        
        /**
         * Sets the "teamIds" attribute
         */
        void setTeamIds(java.lang.String teamIds);
        
        /**
         * Sets (as xml) the "teamIds" attribute
         */
        void xsetTeamIds(org.apache.xmlbeans.XmlString teamIds);
        
        /**
         * Unsets the "teamIds" attribute
         */
        void unsetTeamIds();
        
        /**
         * Gets the "teamNames" attribute
         */
        java.lang.String getTeamNames();
        
        /**
         * Gets (as xml) the "teamNames" attribute
         */
        org.apache.xmlbeans.XmlString xgetTeamNames();
        
        /**
         * True if has "teamNames" attribute
         */
        boolean isSetTeamNames();
        
        /**
         * Sets the "teamNames" attribute
         */
        void setTeamNames(java.lang.String teamNames);
        
        /**
         * Sets (as xml) the "teamNames" attribute
         */
        void xsetTeamNames(org.apache.xmlbeans.XmlString teamNames);
        
        /**
         * Unsets the "teamNames" attribute
         */
        void unsetTeamNames();
        
        /**
         * Gets the "defaultDn" attribute
         */
        java.lang.String getDefaultDn();
        
        /**
         * Gets (as xml) the "defaultDn" attribute
         */
        org.apache.xmlbeans.XmlString xgetDefaultDn();
        
        /**
         * True if has "defaultDn" attribute
         */
        boolean isSetDefaultDn();
        
        /**
         * Sets the "defaultDn" attribute
         */
        void setDefaultDn(java.lang.String defaultDn);
        
        /**
         * Sets (as xml) the "defaultDn" attribute
         */
        void xsetDefaultDn(org.apache.xmlbeans.XmlString defaultDn);
        
        /**
         * Unsets the "defaultDn" attribute
         */
        void unsetDefaultDn();
        
        /**
         * Gets the "agentName" attribute
         */
        java.lang.String getAgentName();
        
        /**
         * Gets (as xml) the "agentName" attribute
         */
        org.apache.xmlbeans.XmlString xgetAgentName();
        
        /**
         * True if has "agentName" attribute
         */
        boolean isSetAgentName();
        
        /**
         * Sets the "agentName" attribute
         */
        void setAgentName(java.lang.String agentName);
        
        /**
         * Sets (as xml) the "agentName" attribute
         */
        void xsetAgentName(org.apache.xmlbeans.XmlString agentName);
        
        /**
         * Unsets the "agentName" attribute
         */
        void unsetAgentName();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration newInstance() {
              return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument newInstance() {
          return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.DesktopConfigurationDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.DesktopConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
