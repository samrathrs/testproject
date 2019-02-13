/*
 * An XML document type.
 * Localname: agent-profile
 * Namespace: http://agent.transerainc.com/profile
 * Java type: com.transerainc.agent.profile.AgentProfileDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.agent.profile.impl;
/**
 * A document containing one agent-profile(@http://agent.transerainc.com/profile) element.
 *
 * This is a complex type.
 */
public class AgentProfileDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.agent.profile.AgentProfileDocument
{
    private static final long serialVersionUID = 1L;
    
    public AgentProfileDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AGENTPROFILE$0 = 
        new javax.xml.namespace.QName("http://agent.transerainc.com/profile", "agent-profile");
    
    
    /**
     * Gets the "agent-profile" element
     */
    public com.transerainc.agent.profile.AgentProfileDocument.AgentProfile getAgentProfile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.AgentProfileDocument.AgentProfile target = null;
            target = (com.transerainc.agent.profile.AgentProfileDocument.AgentProfile)get_store().find_element_user(AGENTPROFILE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "agent-profile" element
     */
    public void setAgentProfile(com.transerainc.agent.profile.AgentProfileDocument.AgentProfile agentProfile)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.AgentProfileDocument.AgentProfile target = null;
            target = (com.transerainc.agent.profile.AgentProfileDocument.AgentProfile)get_store().find_element_user(AGENTPROFILE$0, 0);
            if (target == null)
            {
                target = (com.transerainc.agent.profile.AgentProfileDocument.AgentProfile)get_store().add_element_user(AGENTPROFILE$0);
            }
            target.set(agentProfile);
        }
    }
    
    /**
     * Appends and returns a new empty "agent-profile" element
     */
    public com.transerainc.agent.profile.AgentProfileDocument.AgentProfile addNewAgentProfile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.agent.profile.AgentProfileDocument.AgentProfile target = null;
            target = (com.transerainc.agent.profile.AgentProfileDocument.AgentProfile)get_store().add_element_user(AGENTPROFILE$0);
            return target;
        }
    }
    /**
     * An XML agent-profile(@http://agent.transerainc.com/profile).
     *
     * This is a complex type.
     */
    public static class AgentProfileImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.agent.profile.AgentProfileDocument.AgentProfile
    {
        private static final long serialVersionUID = 1L;
        
        public AgentProfileImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName PROFILEATTRIBUTE$0 = 
            new javax.xml.namespace.QName("http://agent.transerainc.com/profile", "profile-attribute");
        private static final javax.xml.namespace.QName ENTITYLIST$2 = 
            new javax.xml.namespace.QName("http://agent.transerainc.com/profile", "entityList");
        private static final javax.xml.namespace.QName DIALPLAN$4 = 
            new javax.xml.namespace.QName("http://agent.transerainc.com/profile", "dialPlan");
        private static final javax.xml.namespace.QName CHANNELSET$6 = 
            new javax.xml.namespace.QName("http://agent.transerainc.com/profile", "channel-set");
        
        
        /**
         * Gets array of all "profile-attribute" elements
         */
        public com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute[] getProfileAttributeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(PROFILEATTRIBUTE$0, targetList);
                com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute[] result = new com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "profile-attribute" element
         */
        public com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute getProfileAttributeArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute target = null;
                target = (com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute)get_store().find_element_user(PROFILEATTRIBUTE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "profile-attribute" element
         */
        public int sizeOfProfileAttributeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(PROFILEATTRIBUTE$0);
            }
        }
        
        /**
         * Sets array of all "profile-attribute" element
         */
        public void setProfileAttributeArray(com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute[] profileAttributeArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(profileAttributeArray, PROFILEATTRIBUTE$0);
            }
        }
        
        /**
         * Sets ith "profile-attribute" element
         */
        public void setProfileAttributeArray(int i, com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute profileAttribute)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute target = null;
                target = (com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute)get_store().find_element_user(PROFILEATTRIBUTE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(profileAttribute);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "profile-attribute" element
         */
        public com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute insertNewProfileAttribute(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute target = null;
                target = (com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute)get_store().insert_element_user(PROFILEATTRIBUTE$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "profile-attribute" element
         */
        public com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute addNewProfileAttribute()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute target = null;
                target = (com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute)get_store().add_element_user(PROFILEATTRIBUTE$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "profile-attribute" element
         */
        public void removeProfileAttribute(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(PROFILEATTRIBUTE$0, i);
            }
        }
        
        /**
         * Gets array of all "entityList" elements
         */
        public com.transerainc.agent.profile.EntityListDocument.EntityList[] getEntityListArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(ENTITYLIST$2, targetList);
                com.transerainc.agent.profile.EntityListDocument.EntityList[] result = new com.transerainc.agent.profile.EntityListDocument.EntityList[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "entityList" element
         */
        public com.transerainc.agent.profile.EntityListDocument.EntityList getEntityListArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.EntityListDocument.EntityList target = null;
                target = (com.transerainc.agent.profile.EntityListDocument.EntityList)get_store().find_element_user(ENTITYLIST$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "entityList" element
         */
        public int sizeOfEntityListArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ENTITYLIST$2);
            }
        }
        
        /**
         * Sets array of all "entityList" element
         */
        public void setEntityListArray(com.transerainc.agent.profile.EntityListDocument.EntityList[] entityListArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(entityListArray, ENTITYLIST$2);
            }
        }
        
        /**
         * Sets ith "entityList" element
         */
        public void setEntityListArray(int i, com.transerainc.agent.profile.EntityListDocument.EntityList entityList)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.EntityListDocument.EntityList target = null;
                target = (com.transerainc.agent.profile.EntityListDocument.EntityList)get_store().find_element_user(ENTITYLIST$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(entityList);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "entityList" element
         */
        public com.transerainc.agent.profile.EntityListDocument.EntityList insertNewEntityList(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.EntityListDocument.EntityList target = null;
                target = (com.transerainc.agent.profile.EntityListDocument.EntityList)get_store().insert_element_user(ENTITYLIST$2, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "entityList" element
         */
        public com.transerainc.agent.profile.EntityListDocument.EntityList addNewEntityList()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.EntityListDocument.EntityList target = null;
                target = (com.transerainc.agent.profile.EntityListDocument.EntityList)get_store().add_element_user(ENTITYLIST$2);
                return target;
            }
        }
        
        /**
         * Removes the ith "entityList" element
         */
        public void removeEntityList(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ENTITYLIST$2, i);
            }
        }
        
        /**
         * Gets array of all "dialPlan" elements
         */
        public com.transerainc.agent.profile.DialPlanDocument.DialPlan[] getDialPlanArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(DIALPLAN$4, targetList);
                com.transerainc.agent.profile.DialPlanDocument.DialPlan[] result = new com.transerainc.agent.profile.DialPlanDocument.DialPlan[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "dialPlan" element
         */
        public com.transerainc.agent.profile.DialPlanDocument.DialPlan getDialPlanArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.DialPlanDocument.DialPlan target = null;
                target = (com.transerainc.agent.profile.DialPlanDocument.DialPlan)get_store().find_element_user(DIALPLAN$4, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "dialPlan" element
         */
        public int sizeOfDialPlanArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(DIALPLAN$4);
            }
        }
        
        /**
         * Sets array of all "dialPlan" element
         */
        public void setDialPlanArray(com.transerainc.agent.profile.DialPlanDocument.DialPlan[] dialPlanArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(dialPlanArray, DIALPLAN$4);
            }
        }
        
        /**
         * Sets ith "dialPlan" element
         */
        public void setDialPlanArray(int i, com.transerainc.agent.profile.DialPlanDocument.DialPlan dialPlan)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.DialPlanDocument.DialPlan target = null;
                target = (com.transerainc.agent.profile.DialPlanDocument.DialPlan)get_store().find_element_user(DIALPLAN$4, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(dialPlan);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "dialPlan" element
         */
        public com.transerainc.agent.profile.DialPlanDocument.DialPlan insertNewDialPlan(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.DialPlanDocument.DialPlan target = null;
                target = (com.transerainc.agent.profile.DialPlanDocument.DialPlan)get_store().insert_element_user(DIALPLAN$4, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "dialPlan" element
         */
        public com.transerainc.agent.profile.DialPlanDocument.DialPlan addNewDialPlan()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.DialPlanDocument.DialPlan target = null;
                target = (com.transerainc.agent.profile.DialPlanDocument.DialPlan)get_store().add_element_user(DIALPLAN$4);
                return target;
            }
        }
        
        /**
         * Removes the ith "dialPlan" element
         */
        public void removeDialPlan(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(DIALPLAN$4, i);
            }
        }
        
        /**
         * Gets array of all "channel-set" elements
         */
        public com.transerainc.agent.profile.ChannelSetDocument.ChannelSet[] getChannelSetArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(CHANNELSET$6, targetList);
                com.transerainc.agent.profile.ChannelSetDocument.ChannelSet[] result = new com.transerainc.agent.profile.ChannelSetDocument.ChannelSet[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "channel-set" element
         */
        public com.transerainc.agent.profile.ChannelSetDocument.ChannelSet getChannelSetArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.ChannelSetDocument.ChannelSet target = null;
                target = (com.transerainc.agent.profile.ChannelSetDocument.ChannelSet)get_store().find_element_user(CHANNELSET$6, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "channel-set" element
         */
        public int sizeOfChannelSetArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(CHANNELSET$6);
            }
        }
        
        /**
         * Sets array of all "channel-set" element
         */
        public void setChannelSetArray(com.transerainc.agent.profile.ChannelSetDocument.ChannelSet[] channelSetArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(channelSetArray, CHANNELSET$6);
            }
        }
        
        /**
         * Sets ith "channel-set" element
         */
        public void setChannelSetArray(int i, com.transerainc.agent.profile.ChannelSetDocument.ChannelSet channelSet)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.ChannelSetDocument.ChannelSet target = null;
                target = (com.transerainc.agent.profile.ChannelSetDocument.ChannelSet)get_store().find_element_user(CHANNELSET$6, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(channelSet);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "channel-set" element
         */
        public com.transerainc.agent.profile.ChannelSetDocument.ChannelSet insertNewChannelSet(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.ChannelSetDocument.ChannelSet target = null;
                target = (com.transerainc.agent.profile.ChannelSetDocument.ChannelSet)get_store().insert_element_user(CHANNELSET$6, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "channel-set" element
         */
        public com.transerainc.agent.profile.ChannelSetDocument.ChannelSet addNewChannelSet()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.agent.profile.ChannelSetDocument.ChannelSet target = null;
                target = (com.transerainc.agent.profile.ChannelSetDocument.ChannelSet)get_store().add_element_user(CHANNELSET$6);
                return target;
            }
        }
        
        /**
         * Removes the ith "channel-set" element
         */
        public void removeChannelSet(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(CHANNELSET$6, i);
            }
        }
    }
}
