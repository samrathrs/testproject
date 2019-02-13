package com.transerainc.adaws.command;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.TacgResponse;
import com.transerainc.adaws.service.AuthenticationService;
import com.transerainc.adaws.util.WebSocketDataPublisher;
import com.transerainc.aha.gen.agent.AuthenticateStatusDocument.AuthenticateStatus;

/**
 * @author rajeev.lochanam
 */
@Component
public class AuthenticationStatusCommand implements AdaConstants {

	private static Logger LOGGER = LoggerFactory.getLogger(AuthenticationStatusCommand.class.getName());

	@Autowired
	private AuthenticationService autService;

	@Autowired
	private WebSocketCacheManager webSocketCacheManager;
	
	@Autowired
    protected WebSocketDataPublisher dataPublisher;

	/**
	 * @param tacgResp
	 * @return
	 */
	public AdaResponse processData(final TacgResponse tacgResp) {

		LOGGER.debug("AuthenticationStatusCommand.processData() with tacgResp: {}",
				tacgResp);

		final String agentSessionId = tacgResp.getAgentSessionId();

		final AuthenticateStatus authenticationStatus = tacgResp.getAgentList().getAuthenticateStatus();
		String reason = FAILED;
		if (authenticationStatus.getReason() != null) {
			reason = authenticationStatus.getReason().toString();
		}
		authenticationStatus.getMaxInvAtps();
		//MKOP - cesna feature
		int maxInvAtps = 0;
		int curInvAtps = 0;
		boolean invFlag = false;
		if(authenticationStatus.getMaxInvAtps() != 0){
			maxInvAtps = authenticationStatus.getMaxInvAtps();
			 if(authenticationStatus.getCurInvAtps() != 0){
				curInvAtps = authenticationStatus.getCurInvAtps();
			 }
			 invFlag = true;
		}

		JSONObject jsonResponse;

		LOGGER.debug("agentSessionId: {} :===>> Login failed for agent for reason: {}",
				agentSessionId,
				reason);

		switch (reason) {
			case ANOTHER_INSTANCE_LOGOUT:
				jsonResponse = null;
				break;
				// remove cache
			case NOT_VALID_CREDENTIALS:
				LOGGER.warn("{} :===>> invalid credentials", agentSessionId);
				if(invFlag && isLastButSecondAttmpt(maxInvAtps, curInvAtps))
					jsonResponse = loginFailed(ContextConstants.WARNING_AGENT_LOCK);
				else
					jsonResponse = loginFailed(ContextConstants.ERROR_AUTHENTICATION);
				break;
			case ACCOUNT_LOCKED:
			case LOGIN_BLOCKED:
				LOGGER.warn(agentSessionId + " :===>> Maximum unsuccessful login attempts exceeded.");
				jsonResponse = loginFailed(ContextConstants.ERROR_AUTH_MAX_ATTEMPTS_EXCEEDED);
				break;
			case CONFIG_ERROR:
				LOGGER.warn(agentSessionId + " :===>> Invalid configuration for enterprise.");
				if(invFlag && isLastButSecondAttmpt(maxInvAtps, curInvAtps))
					jsonResponse = loginFailed(ContextConstants.WARNING_AGENT_LOCK);
				else
					jsonResponse = loginFailed(ContextConstants.ERROR_AUTH_CONFIG);
				break;
			case VERSION_MISMATCH:
				LOGGER.warn(agentSessionId + " :===>> " + VERSION_MISMATCH_DESC);
				if(invFlag && isLastButSecondAttmpt(maxInvAtps, curInvAtps))
					jsonResponse = loginFailed(ContextConstants.WARNING_AGENT_LOCK);
				else
					jsonResponse = loginFailed(ContextConstants.ERROR_VERSION_MISMATCH);
				break;
			case PASSWORD_EXPIRED:
				LOGGER.warn(agentSessionId + " :===>> Password expired.");
				if(invFlag && isLastButSecondAttmpt(maxInvAtps, curInvAtps))
					jsonResponse = loginFailed(ContextConstants.WARNING_AGENT_LOCK);
				else
					jsonResponse = loginFailed(ContextConstants.ERROR_PASSWORD_EXPIRED);
				break;
			case PASSWORD_CHANGE:
				LOGGER.warn(agentSessionId + " :===>> Force password change.");
				if(invFlag && isLastButSecondAttmpt(maxInvAtps, curInvAtps))
					jsonResponse = loginFailed(ContextConstants.WARNING_AGENT_LOCK);
				else
					jsonResponse = loginFailed(ContextConstants.ERROR_FORCE_PASSWORD_CHANGE);
				break;
			default:
				LOGGER.warn(agentSessionId + " :===>> Unknown reason type for authentication response: " + reason);
				if(invFlag && isLastButSecondAttmpt(maxInvAtps, curInvAtps))
					jsonResponse = loginFailed(ContextConstants.WARNING_AGENT_LOCK);
				else
					jsonResponse = loginFailed(ContextConstants.ERROR_AUTH_UNKNOWN);
				break;
		}

		final String token = webSocketCacheManager.getToken(agentSessionId);
		AdaResponse adaResponse = null;
		if (null != jsonResponse) {
			adaResponse = new AdaResponse(CommandConstants.ERROR_OCCURRED, jsonResponse.toString(), token);
		}
		
		LOGGER.warn("Warning/Error: agentSessionId:{}, adaResponse:{}", agentSessionId, adaResponse);
		try {
			dataPublisher.publishData(adaResponse);
		} catch (final Exception e) {
			LOGGER.error("{} Exception publishing failure response from TACG to FE UI: adaResponse:{} exception:{} cause:{}", 
					agentSessionId, adaResponse, e.getMessage(), e.getCause());
		}
		
		autService.requestLogoutWithReason(agentSessionId, reason);
	
		return adaResponse;
	}

	private boolean isLastButSecondAttmpt(int maxInvAtps, int curInvAtps){
		if(maxInvAtps-curInvAtps == 1){
				return true;
			}
		return false;
	}

	/**
	 * @param authError
	 * @return
	 */
	private JSONObject loginFailed(final int authError) {
		switch (authError) {
			case ContextConstants.ERROR_AUTHENTICATION:
				return errorOccurred(authError, AUTH_FAILED);
			case ContextConstants.ERROR_AUTH_MAX_ATTEMPTS_EXCEEDED:
				return errorOccurred(authError, ACCOUNT_BLOCKED_DESC);
			case ContextConstants.ERROR_AUTH_CONFIG:
				return errorOccurred(authError, NOT_ACCESSIBLE_DESC);
			case ContextConstants.ERROR_VERSION_MISMATCH:
				return errorOccurred(authError, VERSION_MISMATCH_DESC);
			case ContextConstants.WARNING_AGENT_LOCK:
				return errorOccurred(authError, ACC_LOCK_WARNING);
			default:
				return errorOccurred(authError, AUTH_FAILED);
		}
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
}
