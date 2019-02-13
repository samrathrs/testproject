package com.transerainc.adaws.util;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.AgentProfileConstants;
import com.transerainc.adaws.exception.BaseException;
import com.transerainc.tam.config.ConfigAgentHelperForXMLBean;

@Component
public class ConfigAgentUtil {

    @Autowired
    private PropertiesUtil propertiesUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigAgentUtil.class);

    private String sendQuery(final String xpath, final String attributes) throws BaseException {
        LOGGER.info("Sending request to ConfigAgent {} for xpath {} with attributes {}", propertiesUtil.getAdaProperty("config.agent.url"), xpath, attributes);
        try {
            final String xml = ConfigAgentHelperForXMLBean.sendQuery(propertiesUtil.getAdaProperty("config.agent.url"), xpath, attributes);
            LOGGER.info("Data received from ConfigAgent for xpath {} is {}", xpath, xml);
            return xml;
        } catch (final Exception e) {
            throw new BaseException(String.format("Error in retrieving data from %s using xpath %s", propertiesUtil.getAdaProperty("config.agent.url"), xpath), e);
        }
    }

    /**
     * @param url
     * @param xpath
     * @param id
     * @return
     * @throws BaseException
     */
    public String getDataByXpath(final String xpath, final String enterpriseName) throws BaseException {
        final String filterXpath = String.format(xpath + "[@companyName='%s']", enterpriseName);
        return sendQuery(filterXpath, AdaConstants.ATTRIBUTES);
    }

    /**
     * @param enterpriseName
     * @return
     * @throws BaseException
     */
    public String getEnterpriseLarEnabledViaConfigAgent(final String enterpriseName) throws BaseException {
        final String xml = getDataByXpath(propertiesUtil.getAdaProperty("xpath.enterprise"), enterpriseName);
        final Document doc = parseDocument(xml);

        return getLarEnabled(doc);
    }

    /**
     * @param aniListId
     * @return
     * @throws BaseException
     */
    public JSONObject[] getMockOutdialList(final String aniListId) throws BaseException {
        final String filterXpath = String.format(propertiesUtil.getAdaProperty("xpath.mockOutdial") + "[@listId='%s']", aniListId);

        final Document doc = parseDocument(sendQuery(filterXpath, AdaConstants.ALL));

        return getMockAni(doc);
    }

    /**
     * @param xml
     * @return
     * @throws BaseException
     */
    private Document parseDocument(final String xml) throws BaseException {
        if (xml != null) {
            try {
                // Create an instance of DocumentBuilderFactory
                final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                factory.setNamespaceAware(true);
                final Reader reader = new StringReader(xml);
                final InputSource source = new InputSource(reader);
                return factory.newDocumentBuilder().parse(source);
            } catch (final Exception e) {
                LOGGER.error("Error in parsing xml {}", xml, e);
                throw new BaseException(e);
            }
        } else {
            return null;
        }
    }

    /**
     * @param doc
     */
    private JSONObject[] getMockAni(final Document doc) throws BaseException {
        JSONObject[] jsonArr = null;
        if (null != doc) {
            final NodeList nodes = doc.getElementsByTagName(AdaConstants.OUTDIAL_ANI_LIST_ENTRY);

            // JSONObject result = new JSONObject();
            if (null != nodes) {
                jsonArr = new JSONObject[nodes.getLength()];
                for (int i = 0; i < nodes.getLength(); i++) {
                    final Element element = (Element) nodes.item(i);
                    final JSONObject obj = new JSONObject();

                    try {

                        obj.put(AgentProfileConstants.NODE_ID, element.getAttribute(AdaConstants.OUTDIAL_ANI_KEY));
                        obj.put(AgentProfileConstants.NODE_NAME, element.getAttribute(AdaConstants.OUTDIAL_ANI_VALUE));

                        jsonArr[i] = obj;
                    } catch (final JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }

        return jsonArr;
    }

    /**
     * @param doc
     */
    private String getLarEnabled(final Document doc) throws BaseException {

        String larEnabled = "false";
        final NodeList nodes = doc.getElementsByTagName(AdaConstants.ENTERRPISE_ENTITY);

        if (null != nodes) {
            for (int i = 0; i < nodes.getLength(); i++) {
                final Element element = (Element) nodes.item(i);
                larEnabled = element.getAttribute(AdaConstants.ATTRIBUTES);
            }
        }

        return larEnabled;
    }

}
