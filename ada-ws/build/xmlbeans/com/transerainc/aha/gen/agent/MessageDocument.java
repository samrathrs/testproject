/*
 * An XML document type.
 * Localname: message
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.MessageDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent;


/**
 * A document containing one message(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public interface MessageDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(MessageDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("message2528doctype");
    
    /**
     * Gets the "message" element
     */
    com.transerainc.aha.gen.agent.MessageDocument.Message getMessage();
    
    /**
     * Sets the "message" element
     */
    void setMessage(com.transerainc.aha.gen.agent.MessageDocument.Message message);
    
    /**
     * Appends and returns a new empty "message" element
     */
    com.transerainc.aha.gen.agent.MessageDocument.Message addNewMessage();
    
    /**
     * An XML message(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public interface Message extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Message.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("messagec055elemtype");
        
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
         * Gets the "enterpriseId" attribute
         */
        java.lang.String getEnterpriseId();
        
        /**
         * Gets (as xml) the "enterpriseId" attribute
         */
        org.apache.xmlbeans.XmlString xgetEnterpriseId();
        
        /**
         * Sets the "enterpriseId" attribute
         */
        void setEnterpriseId(java.lang.String enterpriseId);
        
        /**
         * Sets (as xml) the "enterpriseId" attribute
         */
        void xsetEnterpriseId(org.apache.xmlbeans.XmlString enterpriseId);
        
        /**
         * Gets the "text" attribute
         */
        java.lang.String getText();
        
        /**
         * Gets (as xml) the "text" attribute
         */
        org.apache.xmlbeans.XmlString xgetText();
        
        /**
         * True if has "text" attribute
         */
        boolean isSetText();
        
        /**
         * Sets the "text" attribute
         */
        void setText(java.lang.String text);
        
        /**
         * Sets (as xml) the "text" attribute
         */
        void xsetText(org.apache.xmlbeans.XmlString text);
        
        /**
         * Unsets the "text" attribute
         */
        void unsetText();
        
        /**
         * Gets the "type" attribute
         */
        com.transerainc.aha.gen.agent.MessageType.Enum getType();
        
        /**
         * Gets (as xml) the "type" attribute
         */
        com.transerainc.aha.gen.agent.MessageType xgetType();
        
        /**
         * True if has "type" attribute
         */
        boolean isSetType();
        
        /**
         * Sets the "type" attribute
         */
        void setType(com.transerainc.aha.gen.agent.MessageType.Enum type);
        
        /**
         * Sets (as xml) the "type" attribute
         */
        void xsetType(com.transerainc.aha.gen.agent.MessageType type);
        
        /**
         * Unsets the "type" attribute
         */
        void unsetType();
        
        /**
         * Gets the "from" attribute
         */
        java.lang.String getFrom();
        
        /**
         * Gets (as xml) the "from" attribute
         */
        org.apache.xmlbeans.XmlString xgetFrom();
        
        /**
         * True if has "from" attribute
         */
        boolean isSetFrom();
        
        /**
         * Sets the "from" attribute
         */
        void setFrom(java.lang.String from);
        
        /**
         * Sets (as xml) the "from" attribute
         */
        void xsetFrom(org.apache.xmlbeans.XmlString from);
        
        /**
         * Unsets the "from" attribute
         */
        void unsetFrom();
        
        /**
         * Gets the "to" attribute
         */
        java.lang.String getTo();
        
        /**
         * Gets (as xml) the "to" attribute
         */
        org.apache.xmlbeans.XmlString xgetTo();
        
        /**
         * True if has "to" attribute
         */
        boolean isSetTo();
        
        /**
         * Sets the "to" attribute
         */
        void setTo(java.lang.String to);
        
        /**
         * Sets (as xml) the "to" attribute
         */
        void xsetTo(org.apache.xmlbeans.XmlString to);
        
        /**
         * Unsets the "to" attribute
         */
        void unsetTo();
        
        /**
         * Gets the "channelId" attribute
         */
        java.lang.String getChannelId();
        
        /**
         * Gets (as xml) the "channelId" attribute
         */
        org.apache.xmlbeans.XmlString xgetChannelId();
        
        /**
         * True if has "channelId" attribute
         */
        boolean isSetChannelId();
        
        /**
         * Sets the "channelId" attribute
         */
        void setChannelId(java.lang.String channelId);
        
        /**
         * Sets (as xml) the "channelId" attribute
         */
        void xsetChannelId(org.apache.xmlbeans.XmlString channelId);
        
        /**
         * Unsets the "channelId" attribute
         */
        void unsetChannelId();
        
        /**
         * Gets the "channelType" attribute
         */
        com.transerainc.aha.gen.agent.ChannelTypes.Enum getChannelType();
        
        /**
         * Gets (as xml) the "channelType" attribute
         */
        com.transerainc.aha.gen.agent.ChannelTypes xgetChannelType();
        
        /**
         * True if has "channelType" attribute
         */
        boolean isSetChannelType();
        
        /**
         * Sets the "channelType" attribute
         */
        void setChannelType(com.transerainc.aha.gen.agent.ChannelTypes.Enum channelType);
        
        /**
         * Sets (as xml) the "channelType" attribute
         */
        void xsetChannelType(com.transerainc.aha.gen.agent.ChannelTypes channelType);
        
        /**
         * Unsets the "channelType" attribute
         */
        void unsetChannelType();
        
        /**
         * Gets the "callId" attribute
         */
        java.lang.String getCallId();
        
        /**
         * Gets (as xml) the "callId" attribute
         */
        org.apache.xmlbeans.XmlString xgetCallId();
        
        /**
         * True if has "callId" attribute
         */
        boolean isSetCallId();
        
        /**
         * Sets the "callId" attribute
         */
        void setCallId(java.lang.String callId);
        
        /**
         * Sets (as xml) the "callId" attribute
         */
        void xsetCallId(org.apache.xmlbeans.XmlString callId);
        
        /**
         * Unsets the "callId" attribute
         */
        void unsetCallId();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.transerainc.aha.gen.agent.MessageDocument.Message newInstance() {
              return (com.transerainc.aha.gen.agent.MessageDocument.Message) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.transerainc.aha.gen.agent.MessageDocument.Message newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.transerainc.aha.gen.agent.MessageDocument.Message) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.transerainc.aha.gen.agent.MessageDocument newInstance() {
          return (com.transerainc.aha.gen.agent.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.aha.gen.agent.MessageDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.aha.gen.agent.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.aha.gen.agent.MessageDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.aha.gen.agent.MessageDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.aha.gen.agent.MessageDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.aha.gen.agent.MessageDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.aha.gen.agent.MessageDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.aha.gen.agent.MessageDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.aha.gen.agent.MessageDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.aha.gen.agent.MessageDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.aha.gen.agent.MessageDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.aha.gen.agent.MessageDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.aha.gen.agent.MessageDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.aha.gen.agent.MessageDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.aha.gen.agent.MessageDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.aha.gen.agent.MessageDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.MessageDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.MessageDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
