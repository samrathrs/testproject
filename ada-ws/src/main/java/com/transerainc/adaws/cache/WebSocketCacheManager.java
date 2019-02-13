package com.transerainc.adaws.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.pac4j.core.context.J2EContext;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.ProfileManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.model.UserEnterpriseInfo;

/**
 * @author rajeev.lochanam
 */
@Component
public class WebSocketCacheManager {
	
	private static Logger LOGGER = LoggerFactory.getLogger(WebSocketCacheManager.class.getName());
			
	private static Map<String, String> tokenAgentMap = new HashMap<String, String>();
	private static Map<String, String> agentTokenMap = new HashMap<String, String>();
	private static Map<String, UserEnterpriseInfo> agentUserEnterpriseInfoMap = new HashMap<String, UserEnterpriseInfo>();
	private static Map<String, Authentication> agentAuthenticationMap = new HashMap<String, Authentication>();
	private static Map<String, HttpSession> tokenHttpSessionMap = new HashMap<String, HttpSession>();
	private static Map<String, SecurityContext> tokenSecurityContextMap = new HashMap<String, SecurityContext>();
	private static Map<String, J2EContext> tokenJ2EContextMap = new HashMap<String, J2EContext>();
	private static Map<String, ProfileManager<CommonProfile>> tokenProfileManagerMap = new HashMap<String, ProfileManager<CommonProfile>>();
	private static Map<String, List<CommonProfile>> tokenCommonProfilesMap  = new HashMap<String, List<CommonProfile>>();
	private static Map<String, String> tokenHttpSessionIdMap = new HashMap<String, String>();

	/**
	 * @param websocketToken
	 * @param agentSession
	 */
	public void populateToken(final String websocketToken, final String agentSession) {
		tokenAgentMap.put(websocketToken, agentSession);
		agentTokenMap.put(agentSession, websocketToken);
	}

	public void populateUserEnterprise(final String agentSession, final UserEnterpriseInfo userEnterpriseInfo) {
		agentUserEnterpriseInfoMap.put(agentSession, userEnterpriseInfo);
	}

	public void populateAgentAuthenticationSession (
													final String webTokenFrontEndId, 
													final String backendAgentSession, 
													final Authentication authentication, 
													final HttpSession httpSession, 
													final SecurityContext securityContext, 
													final J2EContext webContext, 
													final ProfileManager<CommonProfile> profileManager, 
													final List<CommonProfile> commonProfiles
	) {
		agentAuthenticationMap.put(backendAgentSession, authentication);
		tokenHttpSessionMap.put(webTokenFrontEndId, httpSession);
		tokenSecurityContextMap.put(webTokenFrontEndId, securityContext);
		tokenJ2EContextMap.put(webTokenFrontEndId, webContext);
		tokenProfileManagerMap.put(webTokenFrontEndId, profileManager);
		tokenCommonProfilesMap.put(webTokenFrontEndId, commonProfiles);
		tokenHttpSessionIdMap.put(webTokenFrontEndId, httpSession.getId());
	}

	/**
	 * @param websocketToken
	 * @param agentSession
	 */
	public void populate(final String websocketToken, final String agentSession, final UserEnterpriseInfo userEnterpriseInfo) {
		tokenAgentMap.put(websocketToken, agentSession);
		agentTokenMap.put(agentSession, websocketToken);
		agentUserEnterpriseInfoMap.put(agentSession, userEnterpriseInfo);
	}

	/**
	 * @param websocketToken
	 * @return
	 */
	public boolean isTokenCached(final String websocketToken) {
		return tokenAgentMap.containsKey(websocketToken);
	}

	/**
	 * @param websocketToken
	 * @return
	 */
	public boolean isAgentCached(final String session) {
		return agentTokenMap.containsKey(session);
	}

	public boolean isAgentSessionUserEnterpriseCached(final String agentSession) {
		return agentUserEnterpriseInfoMap.containsKey(agentSession);
	}

	public boolean isHttpSessionCached(final String websocketToken) {
		return tokenHttpSessionMap.containsKey(websocketToken);
	}

	public boolean isHttpSessionIdCached(final String websocketToken) {
		return tokenHttpSessionIdMap.containsKey(websocketToken);
	}

	public boolean isSecurityContextCached(final String websocketToken) {
		return tokenSecurityContextMap.containsKey(websocketToken);
	}

	/**
	 * @param webToken
	 * @return
	 */
	public String getAgent(final String webToken) {
		return tokenAgentMap.get(webToken);
	}

	/**
	 * @param session
	 * @return
	 */
	public String getToken(final String session) {
		return agentTokenMap.get(session);
	}

	public UserEnterpriseInfo getUserEnterprise(final String agentSession) {
		return agentUserEnterpriseInfoMap.get(agentSession);
	}

	public Authentication getAuthenticationAgent(final String backendAgentSessionId) {
		return agentAuthenticationMap.get(backendAgentSessionId);
	}

	public HttpSession getHttpSession(final String webTokenFrontendId) {
		return tokenHttpSessionMap.get(webTokenFrontendId);
	}

	public String getHttpSessionId(final String webTokenFrontendId) {
		return tokenHttpSessionIdMap.get(webTokenFrontendId);
	}

	public SecurityContext getSecurityContext(final String webTokenFrontendId) {
		return tokenSecurityContextMap.get(webTokenFrontendId);
	}

	public J2EContext getJ2EContext(final String webTokenFrontendId) {
		return tokenJ2EContextMap.get(webTokenFrontendId);
	}

   
	public ProfileManager<CommonProfile> getProfileManager(final String webTokenFrontendId) {
		return tokenProfileManagerMap.get(webTokenFrontendId);
	}

	public List<CommonProfile> getCommonProfiles(final String webTokenFrontendId) {
		return tokenCommonProfilesMap.get(webTokenFrontendId);
	}

	/**
	 * @param websocketToken
	 */
	public void removeToken(final String agent) {
		if (agentTokenMap.containsKey(agent)) {
			final String websocketToken = agentTokenMap.get(agent);

			// Clean up mappings for CAS Login Security Context
			agentAuthenticationMap.remove(agent);
			tokenHttpSessionMap.remove(websocketToken);
			tokenSecurityContextMap.remove(websocketToken);
			tokenJ2EContextMap.remove(websocketToken);
			tokenProfileManagerMap.remove(websocketToken);
			tokenCommonProfilesMap.remove(websocketToken);
			tokenHttpSessionIdMap.remove(websocketToken);
		} else {
			LOGGER.warn("No token to remove for FE WebToken in CAS Login Security Context Maps for BE agentSessionId: {}", agent);
		}

		tokenAgentMap.remove(agentTokenMap.get(agent));
		agentTokenMap.remove(agent);

		if (agentUserEnterpriseInfoMap.containsKey(agent)) {
			agentUserEnterpriseInfoMap.remove(agent);
		} else {
			LOGGER.warn("No token to remove for BE SessionId in AgentUserEnterprise Map: {}", agent);
		}
	}

	/**
	 * @param websocketToken
	 */
	public void removeAgent(final String websocketToken) {
		if (tokenAgentMap.containsKey(websocketToken)) {
			final String agent = tokenAgentMap.get(websocketToken);

			// Clean up mappings for CAS Login Security Context
			agentAuthenticationMap.remove(agent);
			tokenHttpSessionMap.remove(websocketToken);
			tokenSecurityContextMap.remove(websocketToken);
			tokenJ2EContextMap.remove(websocketToken);
			tokenProfileManagerMap.remove(websocketToken);
			tokenCommonProfilesMap.remove(websocketToken);
			tokenHttpSessionIdMap.remove(websocketToken);

			if (agentUserEnterpriseInfoMap.containsKey(tokenAgentMap.get(websocketToken))) {
				agentUserEnterpriseInfoMap.remove(tokenAgentMap.get(websocketToken));
			}
			agentTokenMap.remove(tokenAgentMap.get(websocketToken));
			tokenAgentMap.remove(websocketToken);
		}
	}

	/**
	 * @param websocketToken
	 * @param agentSession
	 */
	public void updateSession(final String websocketToken, final String agentSession) {
		if (tokenAgentMap.containsKey(websocketToken)) {
			if (agentUserEnterpriseInfoMap.containsKey(tokenAgentMap.get(websocketToken))) {
				UserEnterpriseInfo userEnterprise = agentUserEnterpriseInfoMap.get(tokenAgentMap.get(websocketToken));
				agentUserEnterpriseInfoMap.remove(tokenAgentMap.get(websocketToken));
				agentUserEnterpriseInfoMap.put(agentSession, userEnterprise);
			}
			agentTokenMap.remove(tokenAgentMap.get(websocketToken));
			tokenAgentMap.put(websocketToken, agentSession);
			agentTokenMap.put(agentSession, websocketToken);
		}
	}

	/**
	 * @param agentSession
	 * @param websocketToken
	 */
	public void updateToken(final String agentSession, final String websocketToken) {
		if (agentTokenMap.containsKey(agentSession)) {
			tokenAgentMap.remove(agentTokenMap.get(agentSession));
			agentTokenMap.put(agentSession, websocketToken);
			tokenAgentMap.put(websocketToken, agentSession);
		}
	}

	public void updateUserEnterprise(final String agentSession, final UserEnterpriseInfo userEnterprise) {
		if (agentUserEnterpriseInfoMap.containsKey(agentSession)) {
			agentUserEnterpriseInfoMap.remove(agentSession);
			agentUserEnterpriseInfoMap.put(agentSession, userEnterprise);
		}
	}

	/**
	 * @return the tokenAgentMap
	 */
	public Map<String, String> getTokenAgentMap() {
		return tokenAgentMap;
	}

	/**
	 * @return the agentTokenMap
	 */
	public Map<String, String> getAgentTokenMap() {
		return agentTokenMap;
	}

	/**
	 * @return the tokenUserEnterpriseInfoMap
	 */
	public Map<String, UserEnterpriseInfo> getTokenUserEnterpriseInfoMap() {
		return agentUserEnterpriseInfoMap;
	}

}
