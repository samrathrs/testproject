/*
 * XML Type:  subStatusType
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.SubStatusType
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent;


/**
 * An XML subStatusType(@http://aha.transerainc.com/gen/agent).
 *
 * This is an atomic type that is a restriction of com.transerainc.aha.gen.agent.SubStatusType.
 */
public interface SubStatusType extends org.apache.xmlbeans.XmlString
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(SubStatusType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("substatustype0ad3type");
    
    org.apache.xmlbeans.StringEnumAbstractBase enumValue();
    void set(org.apache.xmlbeans.StringEnumAbstractBase e);
    
    static final Enum AVAILABLE = Enum.forString("Available");
    static final Enum RINGING = Enum.forString("Ringing");
    static final Enum CONNECTED = Enum.forString("Connected");
    static final Enum WRAP_UP = Enum.forString("WrapUp");
    static final Enum NOT_RESPONDING = Enum.forString("NotResponding");
    static final Enum IDLE = Enum.forString("Idle");
    static final Enum NOT_REACHABLE = Enum.forString("NotReachable");
    static final Enum LOST_CONNECTION = Enum.forString("LostConnection");
    static final Enum CONSULTING = Enum.forString("Consulting");
    static final Enum CONSULT = Enum.forString("consult");
    static final Enum CONSULT_ERROR = Enum.forString("consult-error");
    static final Enum CONSULT_DONE = Enum.forString("consult-done");
    static final Enum TRANSFERRING = Enum.forString("Transferring");
    static final Enum TRANSFER_CONNECTED = Enum.forString("TransferConnected");
    static final Enum CONSULT_CONNECTED = Enum.forString("ConsultConnected");
    static final Enum CONNECTED_CONSULT_RESERVED = Enum.forString("ConnectedConsultReserved");
    static final Enum WRAP_UP_CONSULT_RESERVED = Enum.forString("WrapUpConsultReserved");
    static final Enum CONNECTED_CONSULTING = Enum.forString("ConnectedConsulting");
    static final Enum WRAP_UP_CONSULTING = Enum.forString("WrapUpConsulting");
    static final Enum AVAILABLE_CONSULT_RESERVED = Enum.forString("AvailableConsultReserved");
    static final Enum IDLE_CONSULT_RESERVED = Enum.forString("IdleConsultReserved");
    static final Enum AVAILABLE_CONSULTING = Enum.forString("AvailableConsulting");
    static final Enum IDLE_CONSULTING = Enum.forString("IdleConsulting");
    static final Enum OUTDIAL_RESERVED = Enum.forString("OutdialReserved");
    static final Enum SKILL_CONNECTED = Enum.forString("SkillConnected");
    
    static final int INT_AVAILABLE = Enum.INT_AVAILABLE;
    static final int INT_RINGING = Enum.INT_RINGING;
    static final int INT_CONNECTED = Enum.INT_CONNECTED;
    static final int INT_WRAP_UP = Enum.INT_WRAP_UP;
    static final int INT_NOT_RESPONDING = Enum.INT_NOT_RESPONDING;
    static final int INT_IDLE = Enum.INT_IDLE;
    static final int INT_NOT_REACHABLE = Enum.INT_NOT_REACHABLE;
    static final int INT_LOST_CONNECTION = Enum.INT_LOST_CONNECTION;
    static final int INT_CONSULTING = Enum.INT_CONSULTING;
    static final int INT_CONSULT = Enum.INT_CONSULT;
    static final int INT_CONSULT_ERROR = Enum.INT_CONSULT_ERROR;
    static final int INT_CONSULT_DONE = Enum.INT_CONSULT_DONE;
    static final int INT_TRANSFERRING = Enum.INT_TRANSFERRING;
    static final int INT_TRANSFER_CONNECTED = Enum.INT_TRANSFER_CONNECTED;
    static final int INT_CONSULT_CONNECTED = Enum.INT_CONSULT_CONNECTED;
    static final int INT_CONNECTED_CONSULT_RESERVED = Enum.INT_CONNECTED_CONSULT_RESERVED;
    static final int INT_WRAP_UP_CONSULT_RESERVED = Enum.INT_WRAP_UP_CONSULT_RESERVED;
    static final int INT_CONNECTED_CONSULTING = Enum.INT_CONNECTED_CONSULTING;
    static final int INT_WRAP_UP_CONSULTING = Enum.INT_WRAP_UP_CONSULTING;
    static final int INT_AVAILABLE_CONSULT_RESERVED = Enum.INT_AVAILABLE_CONSULT_RESERVED;
    static final int INT_IDLE_CONSULT_RESERVED = Enum.INT_IDLE_CONSULT_RESERVED;
    static final int INT_AVAILABLE_CONSULTING = Enum.INT_AVAILABLE_CONSULTING;
    static final int INT_IDLE_CONSULTING = Enum.INT_IDLE_CONSULTING;
    static final int INT_OUTDIAL_RESERVED = Enum.INT_OUTDIAL_RESERVED;
    static final int INT_SKILL_CONNECTED = Enum.INT_SKILL_CONNECTED;
    
    /**
     * Enumeration value class for com.transerainc.aha.gen.agent.SubStatusType.
     * These enum values can be used as follows:
     * <pre>
     * enum.toString(); // returns the string value of the enum
     * enum.intValue(); // returns an int value, useful for switches
     * // e.g., case Enum.INT_AVAILABLE
     * Enum.forString(s); // returns the enum value for a string
     * Enum.forInt(i); // returns the enum value for an int
     * </pre>
     * Enumeration objects are immutable singleton objects that
     * can be compared using == object equality. They have no
     * public constructor. See the constants defined within this
     * class for all the valid values.
     */
    static final class Enum extends org.apache.xmlbeans.StringEnumAbstractBase
    {
        /**
         * Returns the enum value for a string, or null if none.
         */
        public static Enum forString(java.lang.String s)
            { return (Enum)table.forString(s); }
        /**
         * Returns the enum value corresponding to an int, or null if none.
         */
        public static Enum forInt(int i)
            { return (Enum)table.forInt(i); }
        
        private Enum(java.lang.String s, int i)
            { super(s, i); }
        
        static final int INT_AVAILABLE = 1;
        static final int INT_RINGING = 2;
        static final int INT_CONNECTED = 3;
        static final int INT_WRAP_UP = 4;
        static final int INT_NOT_RESPONDING = 5;
        static final int INT_IDLE = 6;
        static final int INT_NOT_REACHABLE = 7;
        static final int INT_LOST_CONNECTION = 8;
        static final int INT_CONSULTING = 9;
        static final int INT_CONSULT = 10;
        static final int INT_CONSULT_ERROR = 11;
        static final int INT_CONSULT_DONE = 12;
        static final int INT_TRANSFERRING = 13;
        static final int INT_TRANSFER_CONNECTED = 14;
        static final int INT_CONSULT_CONNECTED = 15;
        static final int INT_CONNECTED_CONSULT_RESERVED = 16;
        static final int INT_WRAP_UP_CONSULT_RESERVED = 17;
        static final int INT_CONNECTED_CONSULTING = 18;
        static final int INT_WRAP_UP_CONSULTING = 19;
        static final int INT_AVAILABLE_CONSULT_RESERVED = 20;
        static final int INT_IDLE_CONSULT_RESERVED = 21;
        static final int INT_AVAILABLE_CONSULTING = 22;
        static final int INT_IDLE_CONSULTING = 23;
        static final int INT_OUTDIAL_RESERVED = 24;
        static final int INT_SKILL_CONNECTED = 25;
        
        public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
            new org.apache.xmlbeans.StringEnumAbstractBase.Table
        (
            new Enum[]
            {
                new Enum("Available", INT_AVAILABLE),
                new Enum("Ringing", INT_RINGING),
                new Enum("Connected", INT_CONNECTED),
                new Enum("WrapUp", INT_WRAP_UP),
                new Enum("NotResponding", INT_NOT_RESPONDING),
                new Enum("Idle", INT_IDLE),
                new Enum("NotReachable", INT_NOT_REACHABLE),
                new Enum("LostConnection", INT_LOST_CONNECTION),
                new Enum("Consulting", INT_CONSULTING),
                new Enum("consult", INT_CONSULT),
                new Enum("consult-error", INT_CONSULT_ERROR),
                new Enum("consult-done", INT_CONSULT_DONE),
                new Enum("Transferring", INT_TRANSFERRING),
                new Enum("TransferConnected", INT_TRANSFER_CONNECTED),
                new Enum("ConsultConnected", INT_CONSULT_CONNECTED),
                new Enum("ConnectedConsultReserved", INT_CONNECTED_CONSULT_RESERVED),
                new Enum("WrapUpConsultReserved", INT_WRAP_UP_CONSULT_RESERVED),
                new Enum("ConnectedConsulting", INT_CONNECTED_CONSULTING),
                new Enum("WrapUpConsulting", INT_WRAP_UP_CONSULTING),
                new Enum("AvailableConsultReserved", INT_AVAILABLE_CONSULT_RESERVED),
                new Enum("IdleConsultReserved", INT_IDLE_CONSULT_RESERVED),
                new Enum("AvailableConsulting", INT_AVAILABLE_CONSULTING),
                new Enum("IdleConsulting", INT_IDLE_CONSULTING),
                new Enum("OutdialReserved", INT_OUTDIAL_RESERVED),
                new Enum("SkillConnected", INT_SKILL_CONNECTED),
            }
        );
        private static final long serialVersionUID = 1L;
        private java.lang.Object readResolve() { return forInt(intValue()); } 
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.transerainc.aha.gen.agent.SubStatusType newValue(java.lang.Object obj) {
          return (com.transerainc.aha.gen.agent.SubStatusType) type.newValue( obj ); }
        
        public static com.transerainc.aha.gen.agent.SubStatusType newInstance() {
          return (com.transerainc.aha.gen.agent.SubStatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.aha.gen.agent.SubStatusType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.aha.gen.agent.SubStatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.aha.gen.agent.SubStatusType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.SubStatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.aha.gen.agent.SubStatusType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.SubStatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.aha.gen.agent.SubStatusType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.SubStatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.aha.gen.agent.SubStatusType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.SubStatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.aha.gen.agent.SubStatusType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.SubStatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.aha.gen.agent.SubStatusType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.SubStatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.aha.gen.agent.SubStatusType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.SubStatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.aha.gen.agent.SubStatusType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.SubStatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.aha.gen.agent.SubStatusType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.SubStatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.aha.gen.agent.SubStatusType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.SubStatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.aha.gen.agent.SubStatusType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.SubStatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.aha.gen.agent.SubStatusType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.SubStatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.aha.gen.agent.SubStatusType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.SubStatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.aha.gen.agent.SubStatusType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.SubStatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.SubStatusType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.SubStatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.SubStatusType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.SubStatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
