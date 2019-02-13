/*
 * An XML document type.
 * Localname: agentProfileXmlData
 * Namespace: http://aha.transerainc.com/gen/agent
 * Java type: com.transerainc.aha.gen.agent.AgentProfileXmlDataDocument
 *
 * Automatically generated - do not modify.
 */
package com.transerainc.aha.gen.agent.impl;
/**
 * A document containing one agentProfileXmlData(@http://aha.transerainc.com/gen/agent) element.
 *
 * This is a complex type.
 */
public class AgentProfileXmlDataDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.transerainc.aha.gen.agent.AgentProfileXmlDataDocument
{
    private static final long serialVersionUID = 1L;
    
    public AgentProfileXmlDataDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AGENTPROFILEXMLDATA$0 = 
        new javax.xml.namespace.QName("http://aha.transerainc.com/gen/agent", "agentProfileXmlData");
    
    
    /**
     * Gets the "agentProfileXmlData" element
     */
    public java.lang.String getAgentProfileXmlData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AGENTPROFILEXMLDATA$0, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AGENTPROFILEXMLDATA$0, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AGENTPROFILEXMLDATA$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AGENTPROFILEXMLDATA$0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AGENTPROFILEXMLDATA$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(AGENTPROFILEXMLDATA$0);
            }
            target.set(agentProfileXmlData);
        }
    }
}
