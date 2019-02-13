/*
 * An XML document type.
 * Localname: desktopConfiguration
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.DesktopConfigurationDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one desktopConfiguration(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class DesktopConfigurationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.DesktopConfigurationDocument
{
    private static final long serialVersionUID = 1L;
    
    public DesktopConfigurationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DESKTOPCONFIGURATION$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "desktopConfiguration");
    
    
    /**
     * Gets the "desktopConfiguration" element
     */
    public com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration getDesktopConfiguration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration target = null;
            target = (com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration)get_store().find_element_user(DESKTOPCONFIGURATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "desktopConfiguration" element
     */
    public void setDesktopConfiguration(com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration desktopConfiguration)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration target = null;
            target = (com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration)get_store().find_element_user(DESKTOPCONFIGURATION$0, 0);
            if (target == null)
            {
                target = (com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration)get_store().add_element_user(DESKTOPCONFIGURATION$0);
            }
            target.set(desktopConfiguration);
        }
    }
    
    /**
     * Appends and returns a new empty "desktopConfiguration" element
     */
    public com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration addNewDesktopConfiguration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration target = null;
            target = (com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration)get_store().add_element_user(DESKTOPCONFIGURATION$0);
            return target;
        }
    }
    /**
     * An XML desktopConfiguration(@http://aha.transerainc.com/gen/agent).
     *
     * This is a complex type.
     */
    public static class DesktopConfigurationImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration
    {
        private static final long serialVersionUID = 1L;
        
        public DesktopConfigurationImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName AUXILIARYLIST$0 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "auxiliaryList");
        private static final javax.xml.namespace.QName AGENTPROFILEXMLDATA$2 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "agentProfileXmlData");
        private static final javax.xml.namespace.QName ATTRIBUTE$4 = 
            new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "attribute");
        private static final javax.xml.namespace.QName PROTOCOLVERSION$6 = 
            new javax.xml.namespace.QName("", "protocolVersion");
        private static final javax.xml.namespace.QName AGENTID$8 = 
            new javax.xml.namespace.QName("", "agentId");
        private static final javax.xml.namespace.QName SITEID$10 = 
            new javax.xml.namespace.QName("", "siteId");
        private static final javax.xml.namespace.QName SITENAME$12 = 
            new javax.xml.namespace.QName("", "siteName");
        private static final javax.xml.namespace.QName TEAMIDS$14 = 
            new javax.xml.namespace.QName("", "teamIds");
        private static final javax.xml.namespace.QName TEAMNAMES$16 = 
            new javax.xml.namespace.QName("", "teamNames");
        private static final javax.xml.namespace.QName DEFAULTDN$18 = 
            new javax.xml.namespace.QName("", "defaultDn");
        private static final javax.xml.namespace.QName AGENTNAME$20 = 
            new javax.xml.namespace.QName("", "agentName");
        
        
        /**
         * Gets the "auxiliaryList" element
         */
        public com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList getAuxiliaryList()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList target = null;
                target = (com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList)get_store().find_element_user(AUXILIARYLIST$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "auxiliaryList" element
         */
        public void setAuxiliaryList(com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList auxiliaryList)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList target = null;
                target = (com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList)get_store().find_element_user(AUXILIARYLIST$0, 0);
                if (target == null)
                {
                    target = (com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList)get_store().add_element_user(AUXILIARYLIST$0);
                }
                target.set(auxiliaryList);
            }
        }
        
        /**
         * Appends and returns a new empty "auxiliaryList" element
         */
        public com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList addNewAuxiliaryList()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList target = null;
                target = (com.transerainc.aha.gen.agent.AuxiliaryListDocument.AuxiliaryList)get_store().add_element_user(AUXILIARYLIST$0);
                return target;
            }
        }
        
        /**
         * Gets the "agentProfileXmlData" element
         */
        public java.lang.String getAgentProfileXmlData()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AGENTPROFILEXMLDATA$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "agentProfileXmlData" element
         */
        public org.apache.xmlbeans.XmlString xgetAgentProfileXmlData()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AGENTPROFILEXMLDATA$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "agentProfileXmlData" element
         */
        public void setAgentProfileXmlData(java.lang.String agentProfileXmlData)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AGENTPROFILEXMLDATA$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AGENTPROFILEXMLDATA$2);
                }
                target.setStringValue(agentProfileXmlData);
            }
        }
        
        /**
         * Sets (as xml) the "agentProfileXmlData" element
         */
        public void xsetAgentProfileXmlData(org.apache.xmlbeans.XmlString agentProfileXmlData)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AGENTPROFILEXMLDATA$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(AGENTPROFILEXMLDATA$2);
                }
                target.set(agentProfileXmlData);
            }
        }
        
        /**
         * Gets array of all "attribute" elements
         */
        public com.transerainc.aha.gen.agent.AttributeDocument.Attribute[] getAttributeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(ATTRIBUTE$4, targetList);
                com.transerainc.aha.gen.agent.AttributeDocument.Attribute[] result = new com.transerainc.aha.gen.agent.AttributeDocument.Attribute[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "attribute" element
         */
        public com.transerainc.aha.gen.agent.AttributeDocument.Attribute getAttributeArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AttributeDocument.Attribute target = null;
                target = (com.transerainc.aha.gen.agent.AttributeDocument.Attribute)get_store().find_element_user(ATTRIBUTE$4, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "attribute" element
         */
        public int sizeOfAttributeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ATTRIBUTE$4);
            }
        }
        
        /**
         * Sets array of all "attribute" element
         */
        public void setAttributeArray(com.transerainc.aha.gen.agent.AttributeDocument.Attribute[] attributeArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(attributeArray, ATTRIBUTE$4);
            }
        }
        
        /**
         * Sets ith "attribute" element
         */
        public void setAttributeArray(int i, com.transerainc.aha.gen.agent.AttributeDocument.Attribute attribute)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AttributeDocument.Attribute target = null;
                target = (com.transerainc.aha.gen.agent.AttributeDocument.Attribute)get_store().find_element_user(ATTRIBUTE$4, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(attribute);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "attribute" element
         */
        public com.transerainc.aha.gen.agent.AttributeDocument.Attribute insertNewAttribute(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AttributeDocument.Attribute target = null;
                target = (com.transerainc.aha.gen.agent.AttributeDocument.Attribute)get_store().insert_element_user(ATTRIBUTE$4, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "attribute" element
         */
        public com.transerainc.aha.gen.agent.AttributeDocument.Attribute addNewAttribute()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.transerainc.aha.gen.agent.AttributeDocument.Attribute target = null;
                target = (com.transerainc.aha.gen.agent.AttributeDocument.Attribute)get_store().add_element_user(ATTRIBUTE$4);
                return target;
            }
        }
        
        /**
         * Removes the ith "attribute" element
         */
        public void removeAttribute(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ATTRIBUTE$4, i);
            }
        }
        
        /**
         * Gets the "protocolVersion" attribute
         */
        public java.lang.String getProtocolVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROTOCOLVERSION$6);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "protocolVersion" attribute
         */
        public org.apache.xmlbeans.XmlString xgetProtocolVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROTOCOLVERSION$6);
                return target;
            }
        }
        
        /**
         * True if has "protocolVersion" attribute
         */
        public boolean isSetProtocolVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(PROTOCOLVERSION$6) != null;
            }
        }
        
        /**
         * Sets the "protocolVersion" attribute
         */
        public void setProtocolVersion(java.lang.String protocolVersion)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROTOCOLVERSION$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PROTOCOLVERSION$6);
                }
                target.setStringValue(protocolVersion);
            }
        }
        
        /**
         * Sets (as xml) the "protocolVersion" attribute
         */
        public void xsetProtocolVersion(org.apache.xmlbeans.XmlString protocolVersion)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROTOCOLVERSION$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PROTOCOLVERSION$6);
                }
                target.set(protocolVersion);
            }
        }
        
        /**
         * Unsets the "protocolVersion" attribute
         */
        public void unsetProtocolVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(PROTOCOLVERSION$6);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTID$8);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTID$8);
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
                return get_store().find_attribute_user(AGENTID$8) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTID$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AGENTID$8);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTID$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(AGENTID$8);
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
                get_store().remove_attribute(AGENTID$8);
            }
        }
        
        /**
         * Gets the "siteId" attribute
         */
        public int getSiteId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SITEID$10);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "siteId" attribute
         */
        public org.apache.xmlbeans.XmlInt xgetSiteId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(SITEID$10);
                return target;
            }
        }
        
        /**
         * True if has "siteId" attribute
         */
        public boolean isSetSiteId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(SITEID$10) != null;
            }
        }
        
        /**
         * Sets the "siteId" attribute
         */
        public void setSiteId(int siteId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SITEID$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SITEID$10);
                }
                target.setIntValue(siteId);
            }
        }
        
        /**
         * Sets (as xml) the "siteId" attribute
         */
        public void xsetSiteId(org.apache.xmlbeans.XmlInt siteId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(SITEID$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(SITEID$10);
                }
                target.set(siteId);
            }
        }
        
        /**
         * Unsets the "siteId" attribute
         */
        public void unsetSiteId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(SITEID$10);
            }
        }
        
        /**
         * Gets the "siteName" attribute
         */
        public java.lang.String getSiteName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SITENAME$12);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "siteName" attribute
         */
        public org.apache.xmlbeans.XmlString xgetSiteName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SITENAME$12);
                return target;
            }
        }
        
        /**
         * True if has "siteName" attribute
         */
        public boolean isSetSiteName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(SITENAME$12) != null;
            }
        }
        
        /**
         * Sets the "siteName" attribute
         */
        public void setSiteName(java.lang.String siteName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SITENAME$12);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SITENAME$12);
                }
                target.setStringValue(siteName);
            }
        }
        
        /**
         * Sets (as xml) the "siteName" attribute
         */
        public void xsetSiteName(org.apache.xmlbeans.XmlString siteName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SITENAME$12);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(SITENAME$12);
                }
                target.set(siteName);
            }
        }
        
        /**
         * Unsets the "siteName" attribute
         */
        public void unsetSiteName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(SITENAME$12);
            }
        }
        
        /**
         * Gets the "teamIds" attribute
         */
        public java.lang.String getTeamIds()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TEAMIDS$14);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "teamIds" attribute
         */
        public org.apache.xmlbeans.XmlString xgetTeamIds()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TEAMIDS$14);
                return target;
            }
        }
        
        /**
         * True if has "teamIds" attribute
         */
        public boolean isSetTeamIds()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(TEAMIDS$14) != null;
            }
        }
        
        /**
         * Sets the "teamIds" attribute
         */
        public void setTeamIds(java.lang.String teamIds)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TEAMIDS$14);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TEAMIDS$14);
                }
                target.setStringValue(teamIds);
            }
        }
        
        /**
         * Sets (as xml) the "teamIds" attribute
         */
        public void xsetTeamIds(org.apache.xmlbeans.XmlString teamIds)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TEAMIDS$14);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TEAMIDS$14);
                }
                target.set(teamIds);
            }
        }
        
        /**
         * Unsets the "teamIds" attribute
         */
        public void unsetTeamIds()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(TEAMIDS$14);
            }
        }
        
        /**
         * Gets the "teamNames" attribute
         */
        public java.lang.String getTeamNames()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TEAMNAMES$16);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "teamNames" attribute
         */
        public org.apache.xmlbeans.XmlString xgetTeamNames()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TEAMNAMES$16);
                return target;
            }
        }
        
        /**
         * True if has "teamNames" attribute
         */
        public boolean isSetTeamNames()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(TEAMNAMES$16) != null;
            }
        }
        
        /**
         * Sets the "teamNames" attribute
         */
        public void setTeamNames(java.lang.String teamNames)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TEAMNAMES$16);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TEAMNAMES$16);
                }
                target.setStringValue(teamNames);
            }
        }
        
        /**
         * Sets (as xml) the "teamNames" attribute
         */
        public void xsetTeamNames(org.apache.xmlbeans.XmlString teamNames)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TEAMNAMES$16);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TEAMNAMES$16);
                }
                target.set(teamNames);
            }
        }
        
        /**
         * Unsets the "teamNames" attribute
         */
        public void unsetTeamNames()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(TEAMNAMES$16);
            }
        }
        
        /**
         * Gets the "defaultDn" attribute
         */
        public java.lang.String getDefaultDn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DEFAULTDN$18);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "defaultDn" attribute
         */
        public org.apache.xmlbeans.XmlString xgetDefaultDn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(DEFAULTDN$18);
                return target;
            }
        }
        
        /**
         * True if has "defaultDn" attribute
         */
        public boolean isSetDefaultDn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(DEFAULTDN$18) != null;
            }
        }
        
        /**
         * Sets the "defaultDn" attribute
         */
        public void setDefaultDn(java.lang.String defaultDn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DEFAULTDN$18);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DEFAULTDN$18);
                }
                target.setStringValue(defaultDn);
            }
        }
        
        /**
         * Sets (as xml) the "defaultDn" attribute
         */
        public void xsetDefaultDn(org.apache.xmlbeans.XmlString defaultDn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(DEFAULTDN$18);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(DEFAULTDN$18);
                }
                target.set(defaultDn);
            }
        }
        
        /**
         * Unsets the "defaultDn" attribute
         */
        public void unsetDefaultDn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(DEFAULTDN$18);
            }
        }
        
        /**
         * Gets the "agentName" attribute
         */
        public java.lang.String getAgentName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTNAME$20);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "agentName" attribute
         */
        public org.apache.xmlbeans.XmlString xgetAgentName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTNAME$20);
                return target;
            }
        }
        
        /**
         * True if has "agentName" attribute
         */
        public boolean isSetAgentName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(AGENTNAME$20) != null;
            }
        }
        
        /**
         * Sets the "agentName" attribute
         */
        public void setAgentName(java.lang.String agentName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGENTNAME$20);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AGENTNAME$20);
                }
                target.setStringValue(agentName);
            }
        }
        
        /**
         * Sets (as xml) the "agentName" attribute
         */
        public void xsetAgentName(org.apache.xmlbeans.XmlString agentName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(AGENTNAME$20);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(AGENTNAME$20);
                }
                target.set(agentName);
            }
        }
        
        /**
         * Unsets the "agentName" attribute
         */
        public void unsetAgentName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(AGENTNAME$20);
            }
        }
    }
}
