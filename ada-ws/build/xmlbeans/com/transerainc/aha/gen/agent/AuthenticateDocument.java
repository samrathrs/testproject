/*
 * An XML document type.
 * Localname: authenticate
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.AuthenticateDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent;


/**
 * A document containing one authenticate(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public interface AuthenticateDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AuthenticateDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("authenticate4cc8doctype");
    
    /**
     * Gets the "authenticate" element
     */
    com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate getAuthenticate();
    
    /**
     * Sets the "authenticate" element
     */
    void setAuthenticate(com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate authenticate);
    
    /**
     * Appends and returns a new empty "authenticate" element
     */
    com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate addNewAuthenticate();
    
    /**
     * An XML authenticate(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public interface Authenticate extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Authenticate.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("authenticate31b9elemtype");
        
        /**
         * Gets the "username" attribute
         */
        java.lang.String getUsername();
        
        /**
         * Gets (as xml) the "username" attribute
         */
        org.apache.xmlbeans.XmlString xgetUsername();
        
        /**
         * Sets the "username" attribute
         */
        void setUsername(java.lang.String username);
        
        /**
         * Sets (as xml) the "username" attribute
         */
        void xsetUsername(org.apache.xmlbeans.XmlString username);
        
        /**
         * Gets the "password" attribute
         */
        java.lang.String getPassword();
        
        /**
         * Gets (as xml) the "password" attribute
         */
        org.apache.xmlbeans.XmlString xgetPassword();
        
        /**
         * True if has "password" attribute
         */
        boolean isSetPassword();
        
        /**
         * Sets the "password" attribute
         */
        void setPassword(java.lang.String password);
        
        /**
         * Sets (as xml) the "password" attribute
         */
        void xsetPassword(org.apache.xmlbeans.XmlString password);
        
        /**
         * Unsets the "password" attribute
         */
        void unsetPassword();
        
        /**
         * Gets the "enterprise" attribute
         */
        java.lang.String getEnterprise();
        
        /**
         * Gets (as xml) the "enterprise" attribute
         */
        org.apache.xmlbeans.XmlString xgetEnterprise();
        
        /**
         * Sets the "enterprise" attribute
         */
        void setEnterprise(java.lang.String enterprise);
        
        /**
         * Sets (as xml) the "enterprise" attribute
         */
        void xsetEnterprise(org.apache.xmlbeans.XmlString enterprise);
        
        /**
         * Gets the "casAuthenticated" attribute
         */
        boolean getCasAuthenticated();
        
        /**
         * Gets (as xml) the "casAuthenticated" attribute
         */
        org.apache.xmlbeans.XmlBoolean xgetCasAuthenticated();
        
        /**
         * True if has "casAuthenticated" attribute
         */
        boolean isSetCasAuthenticated();
        
        /**
         * Sets the "casAuthenticated" attribute
         */
        void setCasAuthenticated(boolean casAuthenticated);
        
        /**
         * Sets (as xml) the "casAuthenticated" attribute
         */
        void xsetCasAuthenticated(org.apache.xmlbeans.XmlBoolean casAuthenticated);
        
        /**
         * Unsets the "casAuthenticated" attribute
         */
        void unsetCasAuthenticated();
        
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
         * Gets the "appletVersion" attribute
         */
        java.lang.String getAppletVersion();
        
        /**
         * Gets (as xml) the "appletVersion" attribute
         */
        org.apache.xmlbeans.XmlString xgetAppletVersion();
        
        /**
         * True if has "appletVersion" attribute
         */
        boolean isSetAppletVersion();
        
        /**
         * Sets the "appletVersion" attribute
         */
        void setAppletVersion(java.lang.String appletVersion);
        
        /**
         * Sets (as xml) the "appletVersion" attribute
         */
        void xsetAppletVersion(org.apache.xmlbeans.XmlString appletVersion);
        
        /**
         * Unsets the "appletVersion" attribute
         */
        void unsetAppletVersion();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate newInstance() {
              return (com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.transerainc.aha.gen.agent.AuthenticateDocument newInstance() {
          return (com.transerainc.aha.gen.agent.AuthenticateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.aha.gen.agent.AuthenticateDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.aha.gen.agent.AuthenticateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.aha.gen.agent.AuthenticateDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AuthenticateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AuthenticateDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AuthenticateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.aha.gen.agent.AuthenticateDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AuthenticateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AuthenticateDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AuthenticateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AuthenticateDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AuthenticateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AuthenticateDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AuthenticateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AuthenticateDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AuthenticateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AuthenticateDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AuthenticateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AuthenticateDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AuthenticateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AuthenticateDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AuthenticateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AuthenticateDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AuthenticateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AuthenticateDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AuthenticateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AuthenticateDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AuthenticateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AuthenticateDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AuthenticateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.AuthenticateDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.AuthenticateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.AuthenticateDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.AuthenticateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
