/*
 * An XML document type.
 * Localname: virtualTeamList
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.VirtualTeamListDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent;


/**
 * A document containing one virtualTeamList(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public interface VirtualTeamListDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(VirtualTeamListDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("virtualteamlistbec9doctype");
    
    /**
     * Gets the "virtualTeamList" element
     */
    com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList getVirtualTeamList();
    
    /**
     * Sets the "virtualTeamList" element
     */
    void setVirtualTeamList(com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList virtualTeamList);
    
    /**
     * Appends and returns a new empty "virtualTeamList" element
     */
    com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList addNewVirtualTeamList();
    
    /**
     * An XML virtualTeamList(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public interface VirtualTeamList extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(VirtualTeamList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("virtualteamlist6157elemtype");
        
        /**
         * Gets array of all "virtualTeam" elements
         */
        com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam[] getVirtualTeamArray();
        
        /**
         * Gets ith "virtualTeam" element
         */
        com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam getVirtualTeamArray(int i);
        
        /**
         * Returns number of "virtualTeam" element
         */
        int sizeOfVirtualTeamArray();
        
        /**
         * Sets array of all "virtualTeam" element
         */
        void setVirtualTeamArray(com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam[] virtualTeamArray);
        
        /**
         * Sets ith "virtualTeam" element
         */
        void setVirtualTeamArray(int i, com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam virtualTeam);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "virtualTeam" element
         */
        com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam insertNewVirtualTeam(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "virtualTeam" element
         */
        com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam addNewVirtualTeam();
        
        /**
         * Removes the ith "virtualTeam" element
         */
        void removeVirtualTeam(int i);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList newInstance() {
              return (com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.transerainc.aha.gen.agent.VirtualTeamListDocument newInstance() {
          return (com.transerainc.aha.gen.agent.VirtualTeamListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.aha.gen.agent.VirtualTeamListDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.aha.gen.agent.VirtualTeamListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.aha.gen.agent.VirtualTeamListDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.VirtualTeamListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.aha.gen.agent.VirtualTeamListDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.VirtualTeamListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.aha.gen.agent.VirtualTeamListDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.VirtualTeamListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.aha.gen.agent.VirtualTeamListDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.VirtualTeamListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.aha.gen.agent.VirtualTeamListDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.VirtualTeamListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.aha.gen.agent.VirtualTeamListDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.VirtualTeamListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.aha.gen.agent.VirtualTeamListDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.VirtualTeamListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.aha.gen.agent.VirtualTeamListDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.VirtualTeamListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.aha.gen.agent.VirtualTeamListDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.VirtualTeamListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.aha.gen.agent.VirtualTeamListDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.VirtualTeamListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.aha.gen.agent.VirtualTeamListDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.VirtualTeamListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.aha.gen.agent.VirtualTeamListDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.VirtualTeamListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.aha.gen.agent.VirtualTeamListDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.VirtualTeamListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.aha.gen.agent.VirtualTeamListDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.VirtualTeamListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.VirtualTeamListDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.VirtualTeamListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.VirtualTeamListDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.VirtualTeamListDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
