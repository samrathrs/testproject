/*
 * An XML document type.
 * Localname: auxiliaryList
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.AuxiliaryListDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent;


/**
 * A document containing one auxiliaryList(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public interface AuxiliaryListDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AuxiliaryListDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("auxiliarylist5e0bdoctype");
    
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
     * An XML auxiliaryList(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public interface AuxiliaryList extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AuxiliaryList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("auxiliarylistc31belemtype");
        
        /**
         * Gets the "idleList" element
         */
        com.transerainc.aha.gen.agent.IdleListDocument.IdleList getIdleList();
        
        /**
         * Sets the "idleList" element
         */
        void setIdleList(com.transerainc.aha.gen.agent.IdleListDocument.IdleList idleList);
        
        /**
         * Appends and returns a new empty "idleList" element
         */
        com.transerainc.aha.gen.agent.IdleListDocument.IdleList addNewIdleList();
        
        /**
         * Gets the "wrapUpList" element
         */
        com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList getWrapUpList();
        
        /**
         * Sets the "wrapUpList" element
         */
        void setWrapUpList(com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList wrapUpList);
        
        /**
         * Appends and returns a new empty "wrapUpList" element
         */
        com.transerainc.aha.gen.agent.WrapUpListDocument.WrapUpList addNewWrapUpList();
        
        /**
         * Gets the "callVariables" element
         */
        com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables getCallVariables();
        
        /**
         * True if has "callVariables" element
         */
        boolean isSetCallVariables();
        
        /**
         * Sets the "callVariables" element
         */
        void setCallVariables(com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables callVariables);
        
        /**
         * Appends and returns a new empty "callVariables" element
         */
        com.transerainc.aha.gen.agent.CallVariablesDocument.CallVariables addNewCallVariables();
        
        /**
         * Unsets the "callVariables" element
         */
        void unsetCallVariables();
        
        /**
         * Gets the "enterpriseId" attribute
         */
        java.lang.String getEnterpriseId();
        
        /**
         * Gets (as xml) the "enterpriseId" attribute
         */
        org.apache.xmlbeans.XmlString xgetEnterpriseId();
        
        /**
         * True if has "enterpriseId" attribute
         */
        boolean isSetEnterpriseId();
        
        /**
         * Sets the "enterpriseId" attribute
         */
        void setEnterpriseId(java.lang.String enterpriseId);
        
        /**
         * Sets (as xml) the "enterpriseId" attribute
         */
        void xsetEnterpriseId(org.apache.xmlbeans.XmlString enterpriseId);
        
        /**
         * Unsets the "enterpriseId" attribute
         */
        void unsetEnterpriseId();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList newInstance() {
              return (com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.transerainc.aha.gen.agent.AuxiliaryListDocument newInstance() {
          return (com.transerainc.aha.gen.agent.AuxiliaryListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.aha.gen.agent.AuxiliaryListDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.aha.gen.agent.AuxiliaryListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.aha.gen.agent.AuxiliaryListDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AuxiliaryListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AuxiliaryListDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AuxiliaryListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.aha.gen.agent.AuxiliaryListDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AuxiliaryListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AuxiliaryListDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AuxiliaryListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AuxiliaryListDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AuxiliaryListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AuxiliaryListDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AuxiliaryListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AuxiliaryListDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AuxiliaryListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AuxiliaryListDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AuxiliaryListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AuxiliaryListDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AuxiliaryListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AuxiliaryListDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.AuxiliaryListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AuxiliaryListDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AuxiliaryListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AuxiliaryListDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AuxiliaryListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.aha.gen.agent.AuxiliaryListDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AuxiliaryListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.aha.gen.agent.AuxiliaryListDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.AuxiliaryListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.AuxiliaryListDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.AuxiliaryListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.AuxiliaryListDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.AuxiliaryListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
