/*
 * XML Type:  entity-types
 * Namespace: http://agent.transerainc.com/profile
 * Java type: com.transerainc.agent.profile.EntityTypes
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.agent.profile;


/**
 * An XML entity-types(@http://agent.transerainc.com/profile).
 *
 * This is an atomic type that is a restriction of com.transerainc.agent.profile.EntityTypes.
 */
public interface EntityTypes extends org.apache.xmlbeans.XmlString
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(EntityTypes.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("entitytypes896ctype");
    
    org.apache.xmlbeans.StringEnumAbstractBase enumValue();
    void set(org.apache.xmlbeans.StringEnumAbstractBase e);
    
    static final Enum VTEAM = Enum.forString("vteam");
    static final Enum TEAM = Enum.forString("team");
    static final Enum IDLE_CODE = Enum.forString("idleCode");
    static final Enum WRAPUP_CODE = Enum.forString("wrapupCode");
    static final Enum SPEED_DIAL_PLAN = Enum.forString("speedDialPlan");
    static final Enum SPEED_DIAL_LIST = Enum.forString("speedDialList");
    static final Enum AGENT_STATS_QUEUES = Enum.forString("agentStatsQueues");
    static final Enum AGENT_STATS_TEAMS = Enum.forString("agentStatsTeams");
    static final Enum DN_RESTRICTION_PLAN = Enum.forString("dnRestrictionPlan");
    
    static final int INT_VTEAM = Enum.INT_VTEAM;
    static final int INT_TEAM = Enum.INT_TEAM;
    static final int INT_IDLE_CODE = Enum.INT_IDLE_CODE;
    static final int INT_WRAPUP_CODE = Enum.INT_WRAPUP_CODE;
    static final int INT_SPEED_DIAL_PLAN = Enum.INT_SPEED_DIAL_PLAN;
    static final int INT_SPEED_DIAL_LIST = Enum.INT_SPEED_DIAL_LIST;
    static final int INT_AGENT_STATS_QUEUES = Enum.INT_AGENT_STATS_QUEUES;
    static final int INT_AGENT_STATS_TEAMS = Enum.INT_AGENT_STATS_TEAMS;
    static final int INT_DN_RESTRICTION_PLAN = Enum.INT_DN_RESTRICTION_PLAN;
    
    /**
     * Enumeration value class for com.transerainc.agent.profile.EntityTypes.
     * These enum values can be used as follows:
     * <pre>
     * enum.toString(); // returns the string value of the enum
     * enum.intValue(); // returns an int value, useful for switches
     * // e.g., case Enum.INT_VTEAM
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
        
        static final int INT_VTEAM = 1;
        static final int INT_TEAM = 2;
        static final int INT_IDLE_CODE = 3;
        static final int INT_WRAPUP_CODE = 4;
        static final int INT_SPEED_DIAL_PLAN = 5;
        static final int INT_SPEED_DIAL_LIST = 6;
        static final int INT_AGENT_STATS_QUEUES = 7;
        static final int INT_AGENT_STATS_TEAMS = 8;
        static final int INT_DN_RESTRICTION_PLAN = 9;
        
        public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
            new org.apache.xmlbeans.StringEnumAbstractBase.Table
        (
            new Enum[]
            {
                new Enum("vteam", INT_VTEAM),
                new Enum("team", INT_TEAM),
                new Enum("idleCode", INT_IDLE_CODE),
                new Enum("wrapupCode", INT_WRAPUP_CODE),
                new Enum("speedDialPlan", INT_SPEED_DIAL_PLAN),
                new Enum("speedDialList", INT_SPEED_DIAL_LIST),
                new Enum("agentStatsQueues", INT_AGENT_STATS_QUEUES),
                new Enum("agentStatsTeams", INT_AGENT_STATS_TEAMS),
                new Enum("dnRestrictionPlan", INT_DN_RESTRICTION_PLAN),
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
        public static com.transerainc.agent.profile.EntityTypes newValue(java.lang.Object obj) {
          return (com.transerainc.agent.profile.EntityTypes) type.newValue( obj ); }
        
        public static com.transerainc.agent.profile.EntityTypes newInstance() {
          return (com.transerainc.agent.profile.EntityTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.agent.profile.EntityTypes newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.agent.profile.EntityTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.agent.profile.EntityTypes parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.agent.profile.EntityTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.agent.profile.EntityTypes parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.agent.profile.EntityTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.agent.profile.EntityTypes parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.EntityTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.agent.profile.EntityTypes parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.EntityTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.agent.profile.EntityTypes parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.EntityTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.agent.profile.EntityTypes parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.EntityTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.agent.profile.EntityTypes parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.EntityTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.agent.profile.EntityTypes parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.EntityTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.agent.profile.EntityTypes parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.EntityTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.agent.profile.EntityTypes parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.agent.profile.EntityTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.agent.profile.EntityTypes parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.agent.profile.EntityTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.agent.profile.EntityTypes parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.agent.profile.EntityTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.agent.profile.EntityTypes parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.agent.profile.EntityTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.agent.profile.EntityTypes parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.agent.profile.EntityTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.agent.profile.EntityTypes parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.agent.profile.EntityTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.agent.profile.EntityTypes parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.agent.profile.EntityTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
