/*
 * An XML document type.
 * Localname: commandMessage
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.CommandMessageDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent;


/**
 * A document containing one commandMessage(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public interface CommandMessageDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CommandMessageDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("commandmessage4c01doctype");
    
    /**
     * Gets the "commandMessage" element
     */
    com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage getCommandMessage();
    
    /**
     * Sets the "commandMessage" element
     */
    void setCommandMessage(com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage commandMessage);
    
    /**
     * Appends and returns a new empty "commandMessage" element
     */
    com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage addNewCommandMessage();
    
    /**
     * An XML commandMessage(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public interface CommandMessage extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CommandMessage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("commandmessage56d9elemtype");
        
        /**
         * Gets array of all "param" elements
         */
        com.transerainc.aha.gen.agent.ParamDocument.Param[] getParamArray();
        
        /**
         * Gets ith "param" element
         */
        com.transerainc.aha.gen.agent.ParamDocument.Param getParamArray(int i);
        
        /**
         * Returns number of "param" element
         */
        int sizeOfParamArray();
        
        /**
         * Sets array of all "param" element
         */
        void setParamArray(com.transerainc.aha.gen.agent.ParamDocument.Param[] paramArray);
        
        /**
         * Sets ith "param" element
         */
        void setParamArray(int i, com.transerainc.aha.gen.agent.ParamDocument.Param param);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "param" element
         */
        com.transerainc.aha.gen.agent.ParamDocument.Param insertNewParam(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "param" element
         */
        com.transerainc.aha.gen.agent.ParamDocument.Param addNewParam();
        
        /**
         * Removes the ith "param" element
         */
        void removeParam(int i);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage newInstance() {
              return (com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.transerainc.aha.gen.agent.CommandMessageDocument newInstance() {
          return (com.transerainc.aha.gen.agent.CommandMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.aha.gen.agent.CommandMessageDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.aha.gen.agent.CommandMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.aha.gen.agent.CommandMessageDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.CommandMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.aha.gen.agent.CommandMessageDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.CommandMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.aha.gen.agent.CommandMessageDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.CommandMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.aha.gen.agent.CommandMessageDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.CommandMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.aha.gen.agent.CommandMessageDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.CommandMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.aha.gen.agent.CommandMessageDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.CommandMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.aha.gen.agent.CommandMessageDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.CommandMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.aha.gen.agent.CommandMessageDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.CommandMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.aha.gen.agent.CommandMessageDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.CommandMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.aha.gen.agent.CommandMessageDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.CommandMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.aha.gen.agent.CommandMessageDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.CommandMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.aha.gen.agent.CommandMessageDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.CommandMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.aha.gen.agent.CommandMessageDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.CommandMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.aha.gen.agent.CommandMessageDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.CommandMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.CommandMessageDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.CommandMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.CommandMessageDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.CommandMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
