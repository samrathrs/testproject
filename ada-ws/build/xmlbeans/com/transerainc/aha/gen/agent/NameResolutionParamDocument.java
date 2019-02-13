/*
 * An XML document type.
 * Localname: nameResolutionParam
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.NameResolutionParamDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent;


/**
 * A document containing one nameResolutionParam(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public interface NameResolutionParamDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(NameResolutionParamDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("nameresolutionparam27d9doctype");
    
    /**
     * Gets the "nameResolutionParam" element
     */
    com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam getNameResolutionParam();
    
    /**
     * Sets the "nameResolutionParam" element
     */
    void setNameResolutionParam(com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam nameResolutionParam);
    
    /**
     * Appends and returns a new empty "nameResolutionParam" element
     */
    com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam addNewNameResolutionParam();
    
    /**
     * An XML nameResolutionParam(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public interface NameResolutionParam extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(NameResolutionParam.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("nameresolutionparam48f7elemtype");
        
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
         * True if has "name" attribute
         */
        boolean isSetName();
        
        /**
         * Sets the "name" attribute
         */
        void setName(java.lang.String name);
        
        /**
         * Sets (as xml) the "name" attribute
         */
        void xsetName(org.apache.xmlbeans.XmlString name);
        
        /**
         * Unsets the "name" attribute
         */
        void unsetName();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam newInstance() {
              return (com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.transerainc.aha.gen.agent.NameResolutionParamDocument.NameResolutionParam) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.transerainc.aha.gen.agent.NameResolutionParamDocument newInstance() {
          return (com.transerainc.aha.gen.agent.NameResolutionParamDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.aha.gen.agent.NameResolutionParamDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.aha.gen.agent.NameResolutionParamDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.aha.gen.agent.NameResolutionParamDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.NameResolutionParamDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.aha.gen.agent.NameResolutionParamDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.NameResolutionParamDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.aha.gen.agent.NameResolutionParamDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.NameResolutionParamDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.aha.gen.agent.NameResolutionParamDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.NameResolutionParamDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.aha.gen.agent.NameResolutionParamDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.NameResolutionParamDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.aha.gen.agent.NameResolutionParamDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.NameResolutionParamDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.aha.gen.agent.NameResolutionParamDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.NameResolutionParamDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.aha.gen.agent.NameResolutionParamDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.NameResolutionParamDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.aha.gen.agent.NameResolutionParamDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.NameResolutionParamDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.aha.gen.agent.NameResolutionParamDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.NameResolutionParamDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.aha.gen.agent.NameResolutionParamDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.NameResolutionParamDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.aha.gen.agent.NameResolutionParamDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.NameResolutionParamDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.aha.gen.agent.NameResolutionParamDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.NameResolutionParamDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.aha.gen.agent.NameResolutionParamDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.NameResolutionParamDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.NameResolutionParamDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.NameResolutionParamDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.NameResolutionParamDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.NameResolutionParamDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
