/**
 * 
 */
package com.transerainc.adaws.json;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.ContextConstants;

/**
 * @author trin3
 *
 */
public class AdaResponseJsonUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdaResponseJsonUtil.class.getName());

	public static String extractStatus(final String payloadData) {
		try {
			JSONObject payloadJson = new JSONObject(payloadData);
			return payloadJson.getString(ContextConstants.PARAM_STATE);
		} catch (Exception exception) {
			LOGGER.debug("Cannot extract {} from payloadData: {}", ContextConstants.PARAM_STATE, payloadData);
		}
		return null;
	}

	public static String extractSubStatus(final String payloadData) {
		try {
			JSONObject payloadJson = new JSONObject(payloadData);
			return payloadJson.getString(ContextConstants.PARAM_SUB_STATE);
		} catch (Exception exception) {
			LOGGER.debug("Cannot extract {} from payloadData: {}", ContextConstants.PARAM_SUB_STATE, payloadData);
		}
		return null;
	}

}
