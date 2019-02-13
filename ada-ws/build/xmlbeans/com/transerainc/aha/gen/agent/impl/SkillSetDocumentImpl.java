/*
 * An XML document type.
 * Localname: skill-set
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.SkillSetDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one skill-set(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class SkillSetDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.SkillSetDocument
{
    private static final long serialVersionUID = 1L;
    
    public SkillSetDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SKILLSET$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "skill-set");
    
    
    /**
     * Gets the "skill-set" element
     */
    public com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet getSkillSet()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet target = null;
            target = (com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet)get_store().find_element_user(SKILLSET$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
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
            target = (com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet)get_store().find_element_user(SKILLSET$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet)get_store().add_element_user(SKILLSET$0);
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
            target = (com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet)get_store().add_element_user(SKILLSET$0);
            return target;
        }
    }
    /**
     * An XML skill-set(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class SkillSetImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.SkillSetDocument.SkillSet
    {
        private static final long serialVersionUID = 1L;
        
        public SkillSetImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName SKILL$0 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "skill");
        private static final javax.xml.namespace.QName SKILLPROFILEID$2 = 
            new javax.xml.namespace.QName("", "skillProfileId");
        private static final javax.xml.namespace.QName PROFILENAME$4 = 
            new javax.xml.namespace.QName("", "profileName");
        private static final javax.xml.namespace.QName AGENTID$6 = 
            new javax.xml.namespace.QName("", "agentId");
        private static final javax.xml.namespace.QName TEAMID$8 = 
            new javax.xml.namespace.QName("", "teamId");
        private static final javax.xml.namespace.QName TENANTID$10 = 
            new javax.xml.namespace.QName("", "tenantId");
        
        
        /**
         * Gets array of all "skill" elements
         */
        public com.transerainc.aha.gen.agent.SkillDocument.Skill[] getSkillArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(SKILL$0, targetList);
                com.transerainc.aha.gen.agent.SkillDocument.Skill[] result = new com.transerainc.aha.gen.agent.SkillDocument.Skill[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "skill" element
         */
        public com.transerainc.aha.gen.agent.SkillDocument.Skill getSkillArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.SkillDocument.Skill target = null;
                target = (com.transerainc.aha.gen.agent.SkillDocument.Skill)get_store().find_element_user(SKILL$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "skill" element
         */
        public int sizeOfSkillArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(SKILL$0);
            }
        }
        
        /**
         * Sets array of all "skill" element
         */
        public void setSkillArray(com.transerainc.aha.gen.agent.SkillDocument.Skill[] skillArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(skillArray, SKILL$0);
            }
        }
        
        /**
         * Sets ith "skill" element
         */
        public void setSkillArray(int i, com.transerainc.aha.gen.agent.SkillDocument.Skill skill)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.SkillDocument.Skill target = null;
                target = (com.transerainc.aha.gen.agent.SkillDocument.Skill)get_store().find_element_user(SKILL$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(skill);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "skill" element
         */
        public com.transerainc.aha.gen.agent.SkillDocument.Skill insertNewSkill(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.SkillDocument.Skill target = null;
                target = (com.transerainc.aha.gen.agent.SkillDocument.Skill)get_store().insert_element_user(SKILL$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "skill" element
         */
        public com.transerainc.aha.gen.agent.SkillDocument.Skill addNewSkill()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.SkillDocument.Skill target = null;
                target = (com.transerainc.aha.gen.agent.SkillDocument.Skill)get_store().add_element_user(SKILL$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "skill" element
         */
        public void removeSkill(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(SKILL$0, i);
            }
        }
        
        /**
         * Gets the "skillProfileId" attribute
         */
        public java.lang.String getSkillProfileId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SKILLPROFILEID$2);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "skillProfileId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetSkillProfileId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SKILLPROFILEID$2);
                return target;
            }
        }
        
        /**
         * True if has "skillProfileId" attribute
         */
        public boolean isSetSkillProfileId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(SKILLPROFILEID$2) != null;
            }
        }
        
        /**
         * Sets the "skillProfileId" attribute
         */
        public void setSkillProfileId(java.lang.String skillProfileId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SKILLPROFILEID$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SKILLPROFILEID$2);
                }
                target.setStringValue(skillProfileId);
            }
        }
        
        /**
         * Sets (as xml) the "skillProfileId" attribute
         */
        public void xsetSkillProfileId(org.apache.xmlbeans.XmlString skillProfileId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SKILLPROFILEID$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(SKILLPROFILEID$2);
                }
                target.set(skillProfileId);
            }
        }
        
        /**
         * Unsets the "skillProfileId" attribute
         */
        public void unsetSkillProfileId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(SKILLPROFILEID$2);
            }
        }
        
        /**
         * Gets the "profileName" attribute
         */
        public java.lang.String getProfileName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROFILENAME$4);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "profileName" attribute
         */
        public org.apache.xmlbeans.XmlString xgetProfileName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROFILENAME$4);
                return target;
            }
        }
        
        /**
         * True if has "profileName" attribute
         */
        public boolean isSetProfileName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(PROFILENAME$4) != null;
            }
        }
        
        /**
         * Sets the "profileName" attribute
         */
        public void setProfileName(java.lang.String profileName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROFILENAME$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PROFILENAME$4);
                }
                target.setStringValue(profileName);
            }
        }
        
        /**
         * Sets (as xml) the "profileName" attribute
         */
        public void xsetProfileName(org.apache.xmlbeans.XmlString profileName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROFILENAME$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PROFILENAME$4);
                }
                target.set(profileName);
            }
        }
        
        /**
         * Unsets the "profileName" attribute
         */
        public void unsetProfileName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(PROFILENAME$4);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTID$6);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTID$6);
                return target;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTID$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AGENTID$6);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTID$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(AGENTID$6);
                }
                target.set(agentId);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TEAMID$8);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TEAMID$8);
                return target;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TEAMID$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TEAMID$8);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TEAMID$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TEAMID$8);
                }
                target.set(teamId);
            }
        }
        
        /**
         * Gets the "tenantId" attribute
         */
        public java.lang.String getTenantId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TENANTID$10);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "tenantId" attribute
         */
        public org.apache.xmlbeans.XmlString xgetTenantId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TENANTID$10);
                return target;
            }
        }
        
        /**
         * Sets the "tenantId" attribute
         */
        public void setTenantId(java.lang.String tenantId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TENANTID$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TENANTID$10);
                }
                target.setStringValue(tenantId);
            }
        }
        
        /**
         * Sets (as xml) the "tenantId" attribute
         */
        public void xsetTenantId(org.apache.xmlbeans.XmlString tenantId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TENANTID$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TENANTID$10);
                }
                target.set(tenantId);
            }
        }
    }
}
