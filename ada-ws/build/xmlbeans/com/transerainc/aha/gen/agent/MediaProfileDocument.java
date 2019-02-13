/*
 * An XML document type.
 * Localname: media-profile
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.MediaProfileDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent;


/**
 * A document containing one media-profile(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public interface MediaProfileDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(MediaProfileDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("mediaprofilebd4fdoctype");
    
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
     * An XML media-profile(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public interface MediaProfile extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(MediaProfile.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("mediaprofile79a3elemtype");
        
        /**
         * Gets the "telephony" attribute
         */
        int getTelephony();
        
        /**
         * Gets (as xml) the "telephony" attribute
         */
        org.apache.xmlbeans.XmlInt xgetTelephony();
        
        /**
         * True if has "telephony" attribute
         */
        boolean isSetTelephony();
        
        /**
         * Sets the "telephony" attribute
         */
        void setTelephony(int telephony);
        
        /**
         * Sets (as xml) the "telephony" attribute
         */
        void xsetTelephony(org.apache.xmlbeans.XmlInt telephony);
        
        /**
         * Unsets the "telephony" attribute
         */
        void unsetTelephony();
        
        /**
         * Gets the "email" attribute
         */
        int getEmail();
        
        /**
         * Gets (as xml) the "email" attribute
         */
        org.apache.xmlbeans.XmlInt xgetEmail();
        
        /**
         * True if has "email" attribute
         */
        boolean isSetEmail();
        
        /**
         * Sets the "email" attribute
         */
        void setEmail(int email);
        
        /**
         * Sets (as xml) the "email" attribute
         */
        void xsetEmail(org.apache.xmlbeans.XmlInt email);
        
        /**
         * Unsets the "email" attribute
         */
        void unsetEmail();
        
        /**
         * Gets the "fax" attribute
         */
        int getFax();
        
        /**
         * Gets (as xml) the "fax" attribute
         */
        org.apache.xmlbeans.XmlInt xgetFax();
        
        /**
         * True if has "fax" attribute
         */
        boolean isSetFax();
        
        /**
         * Sets the "fax" attribute
         */
        void setFax(int fax);
        
        /**
         * Sets (as xml) the "fax" attribute
         */
        void xsetFax(org.apache.xmlbeans.XmlInt fax);
        
        /**
         * Unsets the "fax" attribute
         */
        void unsetFax();
        
        /**
         * Gets the "chat" attribute
         */
        int getChat();
        
        /**
         * Gets (as xml) the "chat" attribute
         */
        org.apache.xmlbeans.XmlInt xgetChat();
        
        /**
         * True if has "chat" attribute
         */
        boolean isSetChat();
        
        /**
         * Sets the "chat" attribute
         */
        void setChat(int chat);
        
        /**
         * Sets (as xml) the "chat" attribute
         */
        void xsetChat(org.apache.xmlbeans.XmlInt chat);
        
        /**
         * Unsets the "chat" attribute
         */
        void unsetChat();
        
        /**
         * Gets the "video" attribute
         */
        int getVideo();
        
        /**
         * Gets (as xml) the "video" attribute
         */
        org.apache.xmlbeans.XmlInt xgetVideo();
        
        /**
         * True if has "video" attribute
         */
        boolean isSetVideo();
        
        /**
         * Sets the "video" attribute
         */
        void setVideo(int video);
        
        /**
         * Sets (as xml) the "video" attribute
         */
        void xsetVideo(org.apache.xmlbeans.XmlInt video);
        
        /**
         * Unsets the "video" attribute
         */
        void unsetVideo();
        
        /**
         * Gets the "other" attribute
         */
        int getOther();
        
        /**
         * Gets (as xml) the "other" attribute
         */
        org.apache.xmlbeans.XmlInt xgetOther();
        
        /**
         * True if has "other" attribute
         */
        boolean isSetOther();
        
        /**
         * Sets the "other" attribute
         */
        void setOther(int other);
        
        /**
         * Sets (as xml) the "other" attribute
         */
        void xsetOther(org.apache.xmlbeans.XmlInt other);
        
        /**
         * Unsets the "other" attribute
         */
        void unsetOther();
        
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
         * Gets the "name" attribute
         */
        java.lang.String getName();
        
        /**
         * Gets (as xml) the "name" attribute
         */
        org.apache.xmlbeans.XmlString xgetName();
        
        /**
         * Sets the "name" attribute
         */
        void setName(java.lang.String name);
        
        /**
         * Sets (as xml) the "name" attribute
         */
        void xsetName(org.apache.xmlbeans.XmlString name);
        
        /**
         * Gets the "agentId" attribute
         */
        java.lang.String getAgentId();
        
        /**
         * Gets (as xml) the "agentId" attribute
         */
        org.apache.xmlbeans.XmlString xgetAgentId();
        
        /**
         * Sets the "agentId" attribute
         */
        void setAgentId(java.lang.String agentId);
        
        /**
         * Sets (as xml) the "agentId" attribute
         */
        void xsetAgentId(org.apache.xmlbeans.XmlString agentId);
        
        /**
         * Gets the "tenantId" attribute
         */
        java.lang.String getTenantId();
        
        /**
         * Gets (as xml) the "tenantId" attribute
         */
        org.apache.xmlbeans.XmlString xgetTenantId();
        
        /**
         * Sets the "tenantId" attribute
         */
        void setTenantId(java.lang.String tenantId);
        
        /**
         * Sets (as xml) the "tenantId" attribute
         */
        void xsetTenantId(org.apache.xmlbeans.XmlString tenantId);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile newInstance() {
              return (com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.transerainc.aha.gen.agent.MediaProfileDocument newInstance() {
          return (com.transerainc.aha.gen.agent.MediaProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.aha.gen.agent.MediaProfileDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.aha.gen.agent.MediaProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.aha.gen.agent.MediaProfileDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.MediaProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.aha.gen.agent.MediaProfileDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.MediaProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.aha.gen.agent.MediaProfileDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.MediaProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.aha.gen.agent.MediaProfileDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.MediaProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.aha.gen.agent.MediaProfileDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.MediaProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.aha.gen.agent.MediaProfileDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.MediaProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.aha.gen.agent.MediaProfileDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.MediaProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.aha.gen.agent.MediaProfileDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.MediaProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.aha.gen.agent.MediaProfileDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.MediaProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.aha.gen.agent.MediaProfileDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.MediaProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.aha.gen.agent.MediaProfileDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.MediaProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.aha.gen.agent.MediaProfileDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.MediaProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.aha.gen.agent.MediaProfileDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.MediaProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.aha.gen.agent.MediaProfileDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.MediaProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.MediaProfileDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.MediaProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.MediaProfileDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.MediaProfileDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
