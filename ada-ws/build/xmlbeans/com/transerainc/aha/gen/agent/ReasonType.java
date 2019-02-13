/*
 * XML Type:  reasonType
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.ReasonType
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent;


/**
 * An XML reasonType(@http://aha.transerainc.com/gen/agent).
 *
 * This is an atomic type that is a restriction of com.transerainc.aha.gen.agent.ReasonType.
 */
public interface ReasonType extends org.apache.xmlbeans.XmlString
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ReasonType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("reasontypeb76ftype");
    
    org.apache.xmlbeans.StringEnumAbstractBase enumValue();
    void set(org.apache.xmlbeans.StringEnumAbstractBase e);
    
    static final Enum AUTHENTICATING = Enum.forString("authenticating");
    static final Enum LOGGING_OUT_ANOTHER_INSTANCE = Enum.forString("loggingOutAnotherInstance");
    static final Enum BAD_OR_MISSING_DESKTOP_CONFIGURATION_FOR_THIS_ENTERPRISE = Enum.forString("badOrMissingDesktopConfigurationForThisEnterprise");
    static final Enum NOT_VALID_CREDENTIALS = Enum.forString("Not valid credentials");
    static final Enum AGENT_ACCOUNT_IS_LOCKED = Enum.forString("Agent account is locked");
    static final Enum DUE_TO_MULTIPLE_FAILED_ATTEMPTS_TO_LOGIN_YOUR_ACCOUNT_HAS_BEEN_BLOCKED_CONTACT_YOUR_SUPERVISOR = Enum.forString("Due to multiple failed attempts to login your account has been blocked, contact your supervisor");
    static final Enum VERSION_MISMATCH = Enum.forString("versionMismatch");
    static final Enum PASSWORD_EXPIRED = Enum.forString("passwordExpired");
    static final Enum FORCED_PASSWORD_CHANGE = Enum.forString("ForcedPasswordChange");
    static final Enum FAILED = Enum.forString("failed");
    
    static final int INT_AUTHENTICATING = Enum.INT_AUTHENTICATING;
    static final int INT_LOGGING_OUT_ANOTHER_INSTANCE = Enum.INT_LOGGING_OUT_ANOTHER_INSTANCE;
    static final int INT_BAD_OR_MISSING_DESKTOP_CONFIGURATION_FOR_THIS_ENTERPRISE = Enum.INT_BAD_OR_MISSING_DESKTOP_CONFIGURATION_FOR_THIS_ENTERPRISE;
    static final int INT_NOT_VALID_CREDENTIALS = Enum.INT_NOT_VALID_CREDENTIALS;
    static final int INT_AGENT_ACCOUNT_IS_LOCKED = Enum.INT_AGENT_ACCOUNT_IS_LOCKED;
    static final int INT_DUE_TO_MULTIPLE_FAILED_ATTEMPTS_TO_LOGIN_YOUR_ACCOUNT_HAS_BEEN_BLOCKED_CONTACT_YOUR_SUPERVISOR = Enum.INT_DUE_TO_MULTIPLE_FAILED_ATTEMPTS_TO_LOGIN_YOUR_ACCOUNT_HAS_BEEN_BLOCKED_CONTACT_YOUR_SUPERVISOR;
    static final int INT_VERSION_MISMATCH = Enum.INT_VERSION_MISMATCH;
    static final int INT_PASSWORD_EXPIRED = Enum.INT_PASSWORD_EXPIRED;
    static final int INT_FORCED_PASSWORD_CHANGE = Enum.INT_FORCED_PASSWORD_CHANGE;
    static final int INT_FAILED = Enum.INT_FAILED;
    
    /**
     * Enumeration value class for com.transerainc.aha.gen.agent.ReasonType.
     * These enum values can be used as follows:
     * <pre>
     * enum.toString(); // returns the string value of the enum
     * enum.intValue(); // returns an int value, useful for switches
     * // e.g., case Enum.INT_AUTHENTICATING
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
        
        static final int INT_AUTHENTICATING = 1;
        static final int INT_LOGGING_OUT_ANOTHER_INSTANCE = 2;
        static final int INT_BAD_OR_MISSING_DESKTOP_CONFIGURATION_FOR_THIS_ENTERPRISE = 3;
        static final int INT_NOT_VALID_CREDENTIALS = 4;
        static final int INT_AGENT_ACCOUNT_IS_LOCKED = 5;
        static final int INT_DUE_TO_MULTIPLE_FAILED_ATTEMPTS_TO_LOGIN_YOUR_ACCOUNT_HAS_BEEN_BLOCKED_CONTACT_YOUR_SUPERVISOR = 6;
        static final int INT_VERSION_MISMATCH = 7;
        static final int INT_PASSWORD_EXPIRED = 8;
        static final int INT_FORCED_PASSWORD_CHANGE = 9;
        static final int INT_FAILED = 10;
        
        public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
            new org.apache.xmlbeans.StringEnumAbstractBase.Table
        (
            new Enum[]
            {
                new Enum("authenticating", INT_AUTHENTICATING),
                new Enum("loggingOutAnotherInstance", INT_LOGGING_OUT_ANOTHER_INSTANCE),
                new Enum("badOrMissingDesktopConfigurationForThisEnterprise", INT_BAD_OR_MISSING_DESKTOP_CONFIGURATION_FOR_THIS_ENTERPRISE),
                new Enum("Not valid credentials", INT_NOT_VALID_CREDENTIALS),
                new Enum("Agent account is locked", INT_AGENT_ACCOUNT_IS_LOCKED),
                new Enum("Due to multiple failed attempts to login your account has been blocked, contact your supervisor", INT_DUE_TO_MULTIPLE_FAILED_ATTEMPTS_TO_LOGIN_YOUR_ACCOUNT_HAS_BEEN_BLOCKED_CONTACT_YOUR_SUPERVISOR),
                new Enum("versionMismatch", INT_VERSION_MISMATCH),
                new Enum("passwordExpired", INT_PASSWORD_EXPIRED),
                new Enum("ForcedPasswordChange", INT_FORCED_PASSWORD_CHANGE),
                new Enum("failed", INT_FAILED),
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
        public static com.transerainc.aha.gen.agent.ReasonType newValue(java.lang.Object obj) {
          return (com.transerainc.aha.gen.agent.ReasonType) type.newValue( obj ); }
        
        public static com.transerainc.aha.gen.agent.ReasonType newInstance() {
          return (com.transerainc.aha.gen.agent.ReasonType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.aha.gen.agent.ReasonType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.aha.gen.agent.ReasonType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.aha.gen.agent.ReasonType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.ReasonType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.aha.gen.agent.ReasonType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.ReasonType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.aha.gen.agent.ReasonType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.ReasonType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.aha.gen.agent.ReasonType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.ReasonType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.aha.gen.agent.ReasonType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.ReasonType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.aha.gen.agent.ReasonType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.ReasonType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.aha.gen.agent.ReasonType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.ReasonType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.aha.gen.agent.ReasonType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.ReasonType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.aha.gen.agent.ReasonType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.ReasonType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.aha.gen.agent.ReasonType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.ReasonType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.aha.gen.agent.ReasonType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.ReasonType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.aha.gen.agent.ReasonType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.ReasonType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.aha.gen.agent.ReasonType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.ReasonType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.aha.gen.agent.ReasonType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.ReasonType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.ReasonType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.ReasonType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.ReasonType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.ReasonType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
