/*
 * An XML document type.
 * Localname: xPathQuery
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.XPathQueryDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent;


/**
 * A document containing one xPathQuery(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public interface XPathQueryDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(XPathQueryDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("xpathquerya112doctype");
    
    /**
     * Gets the "xPathQuery" element
     */
    com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery getXPathQuery();
    
    /**
     * Sets the "xPathQuery" element
     */
    void setXPathQuery(com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery xPathQuery);
    
    /**
     * Appends and returns a new empty "xPathQuery" element
     */
    com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery addNewXPathQuery();
    
    /**
     * An XML xPathQuery(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public interface XPathQuery extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(XPathQuery.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("xpathqueryedf9elemtype");
        
        /**
         * Gets the "requestId" attribute
         */
        java.lang.String getRequestId();
        
        /**
         * Gets (as xml) the "requestId" attribute
         */
        org.apache.xmlbeans.XmlString xgetRequestId();
        
        /**
         * True if has "requestId" attribute
         */
        boolean isSetRequestId();
        
        /**
         * Sets the "requestId" attribute
         */
        void setRequestId(java.lang.String requestId);
        
        /**
         * Sets (as xml) the "requestId" attribute
         */
        void xsetRequestId(org.apache.xmlbeans.XmlString requestId);
        
        /**
         * Unsets the "requestId" attribute
         */
        void unsetRequestId();
        
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
         * Gets the "queryString" attribute
         */
        java.lang.String getQueryString();
        
        /**
         * Gets (as xml) the "queryString" attribute
         */
        org.apache.xmlbeans.XmlString xgetQueryString();
        
        /**
         * Sets the "queryString" attribute
         */
        void setQueryString(java.lang.String queryString);
        
        /**
         * Sets (as xml) the "queryString" attribute
         */
        void xsetQueryString(org.apache.xmlbeans.XmlString queryString);
        
        /**
         * Gets the "channelId" attribute
         */
        java.lang.String getChannelId();
        
        /**
         * Gets (as xml) the "channelId" attribute
         */
        org.apache.xmlbeans.XmlString xgetChannelId();
        
        /**
         * Sets the "channelId" attribute
         */
        void setChannelId(java.lang.String channelId);
        
        /**
         * Sets (as xml) the "channelId" attribute
         */
        void xsetChannelId(org.apache.xmlbeans.XmlString channelId);
        
        /**
         * Gets the "channelType" attribute
         */
        com.transerainc.aha.gen.agent.ChannelTypes.Enum getChannelType();
        
        /**
         * Gets (as xml) the "channelType" attribute
         */
        com.transerainc.aha.gen.agent.ChannelTypes xgetChannelType();
        
        /**
         * Sets the "channelType" attribute
         */
        void setChannelType(com.transerainc.aha.gen.agent.ChannelTypes.Enum channelType);
        
        /**
         * Sets (as xml) the "channelType" attribute
         */
        void xsetChannelType(com.transerainc.aha.gen.agent.ChannelTypes channelType);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery newInstance() {
              return (com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.transerainc.aha.gen.agent.XPathQueryDocument newInstance() {
          return (com.transerainc.aha.gen.agent.XPathQueryDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.aha.gen.agent.XPathQueryDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.aha.gen.agent.XPathQueryDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.aha.gen.agent.XPathQueryDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.XPathQueryDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.aha.gen.agent.XPathQueryDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.XPathQueryDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.aha.gen.agent.XPathQueryDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.XPathQueryDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.aha.gen.agent.XPathQueryDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.XPathQueryDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.aha.gen.agent.XPathQueryDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.XPathQueryDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.aha.gen.agent.XPathQueryDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.XPathQueryDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.aha.gen.agent.XPathQueryDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.XPathQueryDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.aha.gen.agent.XPathQueryDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.XPathQueryDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.aha.gen.agent.XPathQueryDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.XPathQueryDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.aha.gen.agent.XPathQueryDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.XPathQueryDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.aha.gen.agent.XPathQueryDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.XPathQueryDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.aha.gen.agent.XPathQueryDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.XPathQueryDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.aha.gen.agent.XPathQueryDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.XPathQueryDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.aha.gen.agent.XPathQueryDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.XPathQueryDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.XPathQueryDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.XPathQueryDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.XPathQueryDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.XPathQueryDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
