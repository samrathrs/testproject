/*
 * An XML document type.
 * Localname: channel-set
 * Namespace: http://agent.transerainc.com/profile
 * Java type: com.transerainc.agent.profile.ChannelSetDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.agent.profile;


/**
 * A document containing one channel-set(@http://agent.transerainc.com/profile) element.
 *
 * This is a complex type.
 */
public interface ChannelSetDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ChannelSetDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("channelset3a45doctype");
    
    /**
     * Gets the "channel-set" element
     */
    com.transerainc.agent.profile.ChannelSetDocument.ChannelSet getChannelSet();
    
    /**
     * Sets the "channel-set" element
     */
    void setChannelSet(com.transerainc.agent.profile.ChannelSetDocument.ChannelSet channelSet);
    
    /**
     * Appends and returns a new empty "channel-set" element
     */
    com.transerainc.agent.profile.ChannelSetDocument.ChannelSet addNewChannelSet();
    
    /**
     * An XML channel-set(@http://agent.transerainc.com/profile).
     *
     * This is a complex type.
     */
    public interface ChannelSet extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ChannelSet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("channelsete6c1elemtype");
        
        /**
         * Gets array of all "channel" elements
         */
        com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel[] getChannelArray();
        
        /**
         * Gets ith "channel" element
         */
        com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel getChannelArray(int i);
        
        /**
         * Returns number of "channel" element
         */
        int sizeOfChannelArray();
        
        /**
         * Sets array of all "channel" element
         */
        void setChannelArray(com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel[] channelArray);
        
        /**
         * Sets ith "channel" element
         */
        void setChannelArray(int i, com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel channel);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "channel" element
         */
        com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel insertNewChannel(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "channel" element
         */
        com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel addNewChannel();
        
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
         * An XML channel(@http://agent.transerainc.com/profile).
         *
         * This is a complex type.
         */
        public interface Channel extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Channel.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("channelf332elemtype");
            
            /**
             * Gets the "id" attribute
             */
            java.lang.String getId();
            
            /**
             * Gets (as xml) the "id" attribute
             */
            org.apache.xmlbeans.XmlString xgetId();
            
            /**
             * Sets the "id" attribute
             */
            void setId(java.lang.String id);
            
            /**
             * Sets (as xml) the "id" attribute
             */
            void xsetId(org.apache.xmlbeans.XmlString id);
            
            /**
             * Gets the "type" attribute
             */
            com.transerainc.agent.profile.ChannelTypes.Enum getType();
            
            /**
             * Gets (as xml) the "type" attribute
             */
            com.transerainc.agent.profile.ChannelTypes xgetType();
            
            /**
             * Sets the "type" attribute
             */
            void setType(com.transerainc.agent.profile.ChannelTypes.Enum type);
            
            /**
             * Sets (as xml) the "type" attribute
             */
            void xsetType(com.transerainc.agent.profile.ChannelTypes type);
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel newInstance() {
                  return (com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.transerainc.agent.profile.ChannelSetDocument.ChannelSet newInstance() {
              return (com.transerainc.agent.profile.ChannelSetDocument.ChannelSet) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.transerainc.agent.profile.ChannelSetDocument.ChannelSet newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.transerainc.agent.profile.ChannelSetDocument.ChannelSet) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.transerainc.agent.profile.ChannelSetDocument newInstance() {
          return (com.transerainc.agent.profile.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.agent.profile.ChannelSetDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.agent.profile.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.agent.profile.ChannelSetDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.agent.profile.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.agent.profile.ChannelSetDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.agent.profile.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.agent.profile.ChannelSetDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.agent.profile.ChannelSetDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.agent.profile.ChannelSetDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.agent.profile.ChannelSetDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.agent.profile.ChannelSetDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.agent.profile.ChannelSetDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.agent.profile.ChannelSetDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.agent.profile.ChannelSetDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.agent.profile.ChannelSetDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.agent.profile.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.agent.profile.ChannelSetDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.agent.profile.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.agent.profile.ChannelSetDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.agent.profile.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.agent.profile.ChannelSetDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.agent.profile.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.agent.profile.ChannelSetDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.agent.profile.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.agent.profile.ChannelSetDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.agent.profile.ChannelSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
