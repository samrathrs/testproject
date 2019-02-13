/**
 * 
 */
package com.transerainc.adaws.command;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.CallPropertyConstants;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.CallModel;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.TacgResponse;
import com.transerainc.adaws.util.StringUtils;
import com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand;

/**
 * @author varsha.shivaram
 */
@Component
public class PrivacyShieldCommand {
    private static Logger LOGGER = LoggerFactory.getLogger(PrivacyShieldCommand.class.getName());

    @Autowired
    private DesktopConfigManager configMap;

    /**
     * @param state
     * @param shieldOn
     * @param tacgResp
     * @return
     * @throws JSONException
     */
    public AdaResponse processPrivacyShieldResponse(final int state, final boolean shieldOn, final TacgResponse tacgResp)
            throws JSONException {
        final AgentCommand agentCommand = tacgResp.getAgentCommand();
        final String agentSessionId = tacgResp.getAgentSessionId();
        final DesktopConfiguration config = configMap.getConfigForAgent(agentSessionId);

        final String reason = getFailureReason(agentCommand.getReason());
        final String callId = StringUtils.isEmpty(agentCommand.getCallId()) ? "" : agentCommand.getCallId();

        switch (state) {
        case ContextConstants.STATE_OK:
            return setPrivacyShieldOn(callId, shieldOn, config.getCallModel(), agentSessionId);
        case ContextConstants.STATE_FAILED:
            return privacyShieldError(callId, shieldOn, true, reason, config.getCallModel(), agentSessionId);
        case ContextConstants.STATE_REJECTED:
            return privacyShieldError(callId, shieldOn, false, reason, config.getCallModel(), agentSessionId);
        }

        return null;
    }

    /**
     * @param callId
     * @param shieldOn
     * @param callModel
     * @param agentSessionId
     * @return
     * @throws JSONException
     */
    private AdaResponse setPrivacyShieldOn(final String callId, final boolean shieldOn, final CallModel callModel,
            final String agentSessionId) throws JSONException {
        LOGGER.info(agentSessionId + " setPrivacyShieldOn(" + callId + "," + shieldOn + ")");

        callModel.setPrivacyShieldOn(shieldOn);

        AdaResponse adaResponse = null;

        final JSONObject jsonResponse = new JSONObject();
        jsonResponse.put(CallPropertyConstants.PAUSE_DURATION, "" + callModel.getPrivacyShieldDuration());
        jsonResponse.put(ContextConstants.PARAM_PRIVACY_SHIELD_STATE, "" + callModel.getPrivacyShieldState());
		if (shieldOn) {
			LOGGER.info(agentSessionId + " starting privacy shield timer");
			adaResponse = new AdaResponse(
					CommandConstants.START_PRIVACY_SHIELD_TIMER,
					jsonResponse.toString(), agentSessionId);
		} else {
			LOGGER.info(agentSessionId + " stopping privacy shield timer");
			adaResponse = new AdaResponse(
					CommandConstants.STOP_PRIVACY_SHIELD_TIMER,
					jsonResponse.toString(), agentSessionId);
		}
        return adaResponse;
    }

    /**
     * @param callId
     * @param shieldOn
     * @param recoverable
     * @param reason
     * @param callModel
     * @param agentSessionId
     * @return
     * @throws JSONException
     */
    private AdaResponse privacyShieldError(final String callId, final boolean shieldOn, final boolean recoverable,
            final String reason, final CallModel callModel, final String agentSessionId) throws JSONException {
        if (recoverable) {
            setPrivacyShieldOn(callId, !shieldOn, callModel, agentSessionId);
        } else {
            callModel.setPrivacyShieldEnabled(false);
        }

        AdaResponse adaResponse = null;
        final JSONObject errorString = errorOccurred(ContextConstants.ERROR_PRIVACY_SHIELD_REQUEST, reason);

        if (null != errorString) {
            adaResponse = new AdaResponse(CommandConstants.ERROR_OCCURRED, errorString.toString(), agentSessionId);
        }
        return adaResponse;
    }

    /**
     * @param privacyShieldEnabled
     * @param pauseDuration
     * @param agentSessionId
     */
    public void setPrivacyShieldParams(final boolean privacyShieldEnabled, final int pauseDuration,
            final String agentSessionId) {
        final DesktopConfiguration config = configMap.getConfigForAgent(agentSessionId);

        if (privacyShieldEnabled) {
            config.getCallModel().setPrivacyShieldEnabled(true);
            config.getCallModel().setPrivacyShieldOn(false);
        }

        config.getCallModel().setPrivacyShieldDuration(pauseDuration);

    }

    /**
     * @param authError
     * @param detail
     */
    private JSONObject errorOccurred(final int authError, final String detail) {
        final JSONObject jsonResponse = new JSONObject();
        try {
            jsonResponse.put(AdaConstants.CODE, String.valueOf(authError));
            jsonResponse.put(AdaConstants.DETAIL, detail);
        } catch (final JSONException e) {
            LOGGER.error("Exception occured while forming json string on errorOccured condition." + e);
        }
        return jsonResponse;
    }

    /**
     * @param reason
     * @return
     */
    private String getFailureReason(String reason) {
        if (reason != null) {
            try {
                reason = URLDecoder.decode(reason, "UTF-8");
            } catch (final UnsupportedEncodingException e) {
                // leave reason as is
            }
        }
        return reason;
    }

}
