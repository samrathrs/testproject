package com.transerainc.adaws.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.model.CallAssociatedData;
import com.transerainc.adaws.model.CallAssociatedData.Data;
import com.transerainc.util.CreditCardHelper;

public class ParsingUtils {

    private static Logger LOGGER = LoggerFactory.getLogger(ParsingUtils.class.getName());

    public static List<String> getListFromCSV(final String csvString) {
        final List<String> tokens = new ArrayList<String>();

        if (csvString != null) {
            final String[] values = csvString.split(",");
            for (final String value : values) {
                tokens.add(value.trim());
            }
        }
        return tokens;
    }

    public static Map<String, String> getMapFromCSV(final String csvString) {
        final Map<String, String> map = new HashMap<String, String>();

        if (csvString != null) {
            final String[] values = csvString.split(",");
            for (final String kv : values) {
                final String[] pair = kv.split("=", 2);
                if (pair.length > 1) {
                    map.put(pair[0].trim(), pair[1].trim());
                } else {
                    map.put(kv, "");
                }
            }
        }
        return map;
    }

    public static Map<String, String> createMap(final String keyString, final String valueString) {
        final List<String> keys = getListFromCSV(keyString);
        final List<String> values = getListFromCSV(valueString);
        final Map<String, String> map = new HashMap<String, String>();
        // assume that the lists are the same size
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }
        return map;
    }

    @SuppressWarnings("unchecked")
    public static CallAssociatedData jsonStringToCad(final CallAssociatedData existingCad, final String jsonString) {
        if (jsonString == null || "{}".equals(jsonString)) { return null; }
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Converting jsonString " + jsonString + " to call associated data");
        }
        CreditCardHelper creditCardValidator = new CreditCardHelper() ;  //jcb , maestro
        final CallAssociatedData cad = new CallAssociatedData();
        try {
            final Object jv = JSONValue.parse(jsonString);
            if (jv instanceof JSONObject) {
                final JSONObject jo = (JSONObject) jv;
                for (final Map.Entry<String, String> e : (Set<Map.Entry<String, String>>) jo.entrySet()) {
                    final Data d = existingCad.getData(e.getKey());
                    String cadVal = e.getValue();
                    String ccNumStripped = cadVal.replaceAll("[ \\-]", "");
                   if(creditCardValidator.isValid(cadVal)){
                    	cadVal= ccNumStripped;
                    	cadVal=cadVal.replaceAll(".", "x");
                    }
                    if (LOGGER.isInfoEnabled()) {
                        LOGGER.info("CAD value " + cadVal + " "+  d.getName() +" to call associated data");
                    }	
                    cad.putData(d.getId(), d.getName(), cadVal, d.isEditable());
                }
            }
        } catch (final Exception e) {
            LOGGER.error("Exception while converting json string to call associated data. ", e);
        }
        return cad;
    }

}
