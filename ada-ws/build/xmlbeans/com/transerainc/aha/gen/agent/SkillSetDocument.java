/*
 * An XML document type.
 * Localname: skill-set
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.SkillSetDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent;


/**
 * A document containing one skill-set(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public interface SkillSetDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(SkillSetDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("skillset8f69doctype");
    
    /**
     * Gets the "skill-set" element
     */
    com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet getSkillSet();
    
    /**
     * Sets the "skill-set" element
     */
    void setSkillSet(com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet skillSet);
    
    /**
     * Appends and returns a new empty "skill-set" element
     */
    com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet addNewSkillSet();
    
    /**
     * An XML skill-set(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public interface SkillSet extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(SkillSet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9C515513CCE7E30E3CBE9CDA773CCCEE").resolveHandle("skillsetd857elemtype");
        
        /**
         * Gets array of all "skill" elements
         */
        com.transerainc.aha.gen.agent.SkillDocument.Skill[] getSkillArray();
        
        /**
         * Gets ith "skill" element
         */
        com.transerainc.aha.gen.agent.SkillDocument.Skill getSkillArray(int i);
        
        /**
         * Returns number of "skill" element
         */
        int sizeOfSkillArray();
        
        /**
         * Sets array of all "skill" element
         */
        void setSkillArray(com.transerainc.aha.gen.agent.SkillDocument.Skill[] skillArray);
        
        /**
         * Sets ith "skill" element
         */
        void setSkillArray(int i, com.transerainc.aha.gen.agent.SkillDocument.Skill skill);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "skill" element
         */
        com.transerainc.aha.gen.agent.SkillDocument.Skill insertNewSkill(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "skill" element
         */
        com.transerainc.aha.gen.agent.SkillDocument.Skill addNewSkill();
        
        /**
         * Removes the ith "skill" element
         */
        void removeSkill(int i);
        
        /**
         * Gets the "skillProfileId" attribute
         */
        java.lang.String getSkillProfileId();
        
        /**
         * Gets (as xml) the "skillProfileId" attribute
         */
        org.apache.xmlbeans.XmlString xgetSkillProfileId();
        
        /**
         * True if has "skillProfileId" attribute
         */
        boolean isSetSkillProfileId();
        
        /**
         * Sets the "skillProfileId" attribute
         */
        void setSkillProfileId(java.lang.String skillProfileId);
        
        /**
         * Sets (as xml) the "skillProfileId" attribute
         */
        void xsetSkillProfileId(org.apache.xmlbeans.XmlString skillProfileId);
        
        /**
         * Unsets the "skillProfileId" attribute
         */
        void unsetSkillProfileId();
        
        /**
         * Gets the "profileName" attribute
         */
        java.lang.String getProfileName();
        
        /**
         * Gets (as xml) the "profileName" attribute
         */
        org.apache.xmlbeans.XmlString xgetProfileName();
        
        /**
         * True if has "profileName" attribute
         */
        boolean isSetProfileName();
        
        /**
         * Sets the "profileName" attribute
         */
        void setProfileName(java.lang.String profileName);
        
        /**
         * Sets (as xml) the "profileName" attribute
         */
        void xsetProfileName(org.apache.xmlbeans.XmlString profileName);
        
        /**
         * Unsets the "profileName" attribute
         */
        void unsetProfileName();
        
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
         * Gets the "teamId" attribute
         */
        java.lang.String getTeamId();
        
        /**
         * Gets (as xml) the "teamId" attribute
         */
        org.apache.xmlbeans.XmlString xgetTeamId();
        
        /**
         * Sets the "teamId" attribute
         */
        void setTeamId(java.lang.String teamId);
        
        /**
         * Sets (as xml) the "teamId" attribute
         */
        void xsetTeamId(org.apache.xmlbeans.XmlString teamId);
        
        /**
         * Gets the "tenantId" attribute
         */
        java.lang.String getTenantId();
        
        /**
         * Gets (as xml) the "tenantId" attribute
         */
        org.apache.xmlbeans.XmlString xgetTenantId();
        
        /**
         * Sets the "tenantId" attribute
         */
        void setTenantId(java.lang.String tenantId);
        
        /**
         * Sets (as xml) the "tenantId" attribute
         */
        void xsetTenantId(org.apache.xmlbeans.XmlString tenantId);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet newInstance() {
              return (com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.transerainc.aha.gen.agent.SkillSetDocument newInstance() {
          return (com.transerainc.aha.gen.agent.SkillSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.transerainc.aha.gen.agent.SkillSetDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.transerainc.aha.gen.agent.SkillSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.transerainc.aha.gen.agent.SkillSetDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.SkillSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.transerainc.aha.gen.agent.SkillSetDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.SkillSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.transerainc.aha.gen.agent.SkillSetDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.SkillSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.transerainc.aha.gen.agent.SkillSetDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.SkillSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.transerainc.aha.gen.agent.SkillSetDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.SkillSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.transerainc.aha.gen.agent.SkillSetDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.SkillSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.transerainc.aha.gen.agent.SkillSetDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.SkillSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.transerainc.aha.gen.agent.SkillSetDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.SkillSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.transerainc.aha.gen.agent.SkillSetDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.SkillSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.transerainc.aha.gen.agent.SkillSetDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.transerainc.aha.gen.agent.SkillSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.transerainc.aha.gen.agent.SkillSetDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.SkillSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.transerainc.aha.gen.agent.SkillSetDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.SkillSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.transerainc.aha.gen.agent.SkillSetDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.SkillSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.transerainc.aha.gen.agent.SkillSetDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.transerainc.aha.gen.agent.SkillSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.SkillSetDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.SkillSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.transerainc.aha.gen.agent.SkillSetDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.transerainc.aha.gen.agent.SkillSetDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
