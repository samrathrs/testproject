/*
 * An XML document type.
 * Localname: channel-set
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.ChannelSetDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent;


/**
 * A document containing one channel-set(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public interface ChannelSetDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ChannelSetDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("channelsetc2b7doctype");
    
    /**
     * Gets the "channel-set" element
     */
    com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet getChannelSet();
    
    /**
     * Sets the "channel-set" element
     */
    void setChannelSet(com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet channelSet);
    
    /**
     * Appends and returns a new empty "channel-set" element
     */
    com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet addNewChannelSet();
    
    /**
     * An XML channel-set(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public interface ChannelSet extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ChannelSet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("channelset6f33elemtype");
        
        /**
         * Gets array of all "channel" elements
         */
        com.transerainc.aha.gen.agent.ChannelDocument.Channel[] getChannelArray();
        
        /**
         * Gets ith "channel" element
         */
        com.transerainc.aha.gen.agent.ChannelDocument.Channel getChannelArray(int i);
        
        /**
         * Returns number of "channel" element
         */
        int sizeOfChannelArray();
        
        /**
         * Sets array of all "channel" element
         */
        void setChannelArray(com.transerainc.aha.gen.agent.ChannelDocument.Channel[] channelArray);
        
        /**
         * Sets ith "channel" element
         */
        void setChannelArray(int i, com.transerainc.aha.gen.agent.ChannelDocument.Channel channel);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "channel" element
         */
        com.transerainc.aha.gen.agent.ChannelDocument.Channel insertNewChannel(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "channel" element
         */
        com.transerainc.aha.gen.agent.ChannelDocument.Channel addNewChannel();
        
        /**
         * Removes the ith "channel" element
         */
        void removeChannel(int i);
        
        /**
         * Gets the "profile-id" attribute
         */
        java.lang.String getProfileId();
        
        /**
         * Gets (as xml) the "profile-id" attribute
         */
        org.apache.xmlbeans.XmlString xgetProfileId();
        
        /**
         * True if has "profile-id" attribute
         */
        boolean isSetProfileId();
        
        /**
         * Sets the "profile-id" attribute
         */
        void setProfileId(java.lang.String profileId);
        
        /**
         * Sets (as xml) the "profile-id" attribute
         */
        void xsetProfileId(org.apache.xmlbeans.XmlString profileId);
        
        /**
         * Unsets the "profile-id" attribute
         */
        void unsetProfileId();
        
        /**
         * Gets the "profile-name" attribute
         */
        java.lang.String getProfileName();
        
        /**
         * Gets (as xml) the "profile-name" attribute
         */
        org.apache.xmlbeans.XmlString xgetProfileName();
        
        /**
         * True if has "profile-name" attribute
         */
        boolean isSetProfileName();
        
        /**
         * Sets the "profile-name" attribute
         */
        void setProfileName(java.lang.String profileName);
        
        /**
         * Sets (as xml) the "profile-name" attribute
         */
        void xsetProfileName(org.apache.xmlbeans.XmlString profileName);
        
        /**
         * Unsets the "profile-name" attribute
         */
        void unsetProfileName();
        
        /**
         * Gets the "tenantId" attribute
         */
        java.lang.String getTenantId();
        
        /**
         * Gets (as xml) the "tenantId" attribute
         */
        org.apache.xmlbeans.XmlString xgetTenantId();
        
        /**
         * True if has "tenantId" attribute
         */
        boolean isSetTenantId();
        
        /**
         * Sets the "tenantId" attribute
         */
        void setTenantId(java.lang.String tenantId);
        
        /**
         * Sets (as xml) the "tenantId" attribute
         */
        void xsetTenantId(org.apache.xmlbeans.XmlString tenantId);
        
        /**
         * Unsets the "tenantId" attribute
         */
        void unsetTenantId();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet newInstance() {
              return (com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.transerainc.aha.gen.agent.ChannelSetDocument.ChannelSet) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.transerainc.aha.gen.agent.ChannelSetDocument newInstance() {
          return (com.transerainc.aha.gen.agent.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.aha.gen.agent.ChannelSetDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.aha.gen.agent.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.aha.gen.agent.ChannelSetDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.aha.gen.agent.ChannelSetDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.aha.gen.agent.ChannelSetDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.aha.gen.agent.ChannelSetDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.aha.gen.agent.ChannelSetDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.aha.gen.agent.ChannelSetDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.aha.gen.agent.ChannelSetDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.aha.gen.agent.ChannelSetDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.aha.gen.agent.ChannelSetDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.aha.gen.agent.ChannelSetDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.aha.gen.agent.ChannelSetDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.aha.gen.agent.ChannelSetDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.aha.gen.agent.ChannelSetDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.aha.gen.agent.ChannelSetDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.ChannelSetDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.ChannelSetDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
