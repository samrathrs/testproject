/*
 * An XML document type.
 * Localname: routing-data
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.RoutingDataDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one routing-data(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class RoutingDataDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.RoutingDataDocument
{
    private static final long serialVersionUID = 1L;
    
    public RoutingDataDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ROUTINGDATA$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "routing-data");
    
    
    /**
     * Gets the "routing-data" element
     */
    public com.transerainc.aha.gen.agent.RoutingDataDocument.RoutingData getRoutingData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.RoutingDataDocument.RoutingData target = null;
            target = (com.transerainc.aha.gen.agent.RoutingDataDocument.RoutingData)get_store().find_element_user(ROUTINGDATA$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "routing-data" element
     */
    public void setRoutingData(com.transerainc.aha.gen.agent.RoutingDataDocument.RoutingData routingData)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.RoutingDataDocument.RoutingData target = null;
            target = (com.transerainc.aha.gen.agent.RoutingDataDocument.RoutingData)get_store().find_element_user(ROUTINGDATA$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.RoutingDataDocument.RoutingData)get_store().add_element_user(ROUTINGDATA$0);
            }
            target.set(routingData);
        }
    }
    
    /**
     * Appends and returns a new empty "routing-data" element
     */
    public com.transerainc.aha.gen.agent.RoutingDataDocument.RoutingData addNewRoutingData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.RoutingDataDocument.RoutingData target = null;
            target = (com.transerainc.aha.gen.agent.RoutingDataDocument.RoutingData)get_store().add_element_user(ROUTINGDATA$0);
            return target;
        }
    }
    /**
     * An XML routing-data(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class RoutingDataImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.RoutingDataDocument.RoutingData
    {
        private static final long serialVersionUID = 1L;
        
        public RoutingDataImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName MEDIAPROFILE$0 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "media-profile");
        private static final javax.xml.namespace.QName SKILLSET$2 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "skill-set");
        private static final javax.xml.namespace.QName AGENTID$4 = 
            new javax.xml.namespace.QName("", "agentId");
        private static final javax.xml.namespace.QName TEAMID$6 = 
            new javax.xml.namespace.QName("", "teamId");
        
        
        /**
         * Gets the "media-profile" element
         */
        public com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile getMediaProfile()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile target = null;
                target = (com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile)get_store().find_element_user(MEDIAPROFILE$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "media-profile" element
         */
        public void setMediaProfile(com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile mediaProfile)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile target = null;
                target = (com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile)get_store().find_element_user(MEDIAPROFILE$0, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile)get_store().add_element_user(MEDIAPROFILE$0);
                }
                target.set(mediaProfile);
            }
        }
        
        /**
         * Appends and returns a new empty "media-profile" element
         */
        public com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile addNewMediaProfile()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile target = null;
                target = (com.transerainc.aha.gen.agent.MediaProfileDocument.MediaProfile)get_store().add_element_user(MEDIAPROFILE$0);
                return target;
            }
        }
        
        /**
         * Gets the "skill-set" element
         */
        public com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet getSkillSet()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet target = null;
                target = (com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet)get_store().find_element_user(SKILLSET$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "skill-set" element
         */
        public boolean isSetSkillSet()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(SKILLSET$2) != 0;
            }
        }
        
        /**
         * Sets the "skill-set" element
         */
        public void setSkillSet(com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet skillSet)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet target = null;
                target = (com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet)get_store().find_element_user(SKILLSET$2, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet)get_store().add_element_user(SKILLSET$2);
                }
                target.set(skillSet);
            }
        }
        
        /**
         * Appends and returns a new empty "skill-set" element
         */
        public com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet addNewSkillSet()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet target = null;
                target = (com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet)get_store().add_element_user(SKILLSET$2);
                return target;
            }
        }
        
        /**
         * Unsets the "skill-set" element
         */
        public void unsetSkillSet()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(SKILLSET$2, 0);
            }
        }
        
        /**
         * Gets the "agentId" attribute
         */
        public java.lang.String getAgentId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTID$4);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "agentId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetAgentId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTID$4);
                return target;
            }
        }
        
        /**
         * True if has "agentId" attribute
         */
        public boolean isSetAgentId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(AGENTID$4) != null;
            }
        }
        
        /**
         * Sets the "agentId" attribute
         */
        public void setAgentId(java.lang.String agentId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTID$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AGENTID$4);
                }
                target.setStringValue(agentId);
            }
        }
        
        /**
         * Sets (as xml) the "agentId" attribute
         */
        public void xsetAgentId(org.apache.xmlbeans.XmlString agentId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTID$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(AGENTID$4);
                }
                target.set(agentId);
            }
        }
        
        /**
         * Unsets the "agentId" attribute
         */
        public void unsetAgentId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(AGENTID$4);
            }
        }
        
        /**
         * Gets the "teamId" attribute
         */
        public java.lang.String getTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TEAMID$6);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "teamId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TEAMID$6);
                return target;
            }
        }
        
        /**
         * True if has "teamId" attribute
         */
        public boolean isSetTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(TEAMID$6) != null;
            }
        }
        
        /**
         * Sets the "teamId" attribute
         */
        public void setTeamId(java.lang.String teamId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TEAMID$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TEAMID$6);
                }
                target.setStringValue(teamId);
            }
        }
        
        /**
         * Sets (as xml) the "teamId" attribute
         */
        public void xsetTeamId(org.apache.xmlbeans.XmlString teamId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TEAMID$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TEAMID$6);
                }
                target.set(teamId);
            }
        }
        
        /**
         * Unsets the "teamId" attribute
         */
        public void unsetTeamId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(TEAMID$6);
            }
        }
    }
}
