package com.transerainc.adaws.util;

import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.AgentProfileConstants;

public class XMLtoJsonConverter {

    private static Logger LOGGER = LoggerFactory.getLogger(XMLtoJsonConverter.class.getName());

    /**
     * @param xml
     * @return
     */
    public static JSONObject convertXMLtoJSON(final String xml) {
        JSONObject json = null;
        try {
            json = XML.toJSONObject(xml);
        } catch (final JSONException e) {
            LOGGER.error(e.getMessage());
        }
        return json;
    }

    /**
     * @param map
     * @param attributeArray
     * @return
     */
    @SuppressWarnings("unchecked")
    public static org.json.simple.JSONArray convertMapToJsonArray(final Map<String, String> map,
            final org.json.simple.JSONArray attributeArray) {
        if (map != null && !map.isEmpty()) {
            for (final Entry<String, String> entry : map.entrySet()) {
                final JSONObject attributeObj = new JSONObject();
                try {
                    attributeObj.put(AgentProfileConstants.NODE_NAME, entry.getKey());
                    attributeObj.put(AgentProfileConstants.NODE_VALUE, entry.getValue());
                    attributeArray.add(attributeObj);
                } catch (final JSONException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }

        return attributeArray;
    }

}
