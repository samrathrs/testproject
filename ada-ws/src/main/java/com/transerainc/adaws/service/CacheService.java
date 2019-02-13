package com.transerainc.adaws.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.pac4j.core.context.J2EContext;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.ProfileManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.cache.AgentCacheManager;
import com.transerainc.adaws.cache.CacheServerManager;
import com.transerainc.adaws.cache.CloseEventCacheManager;
import com.transerainc.adaws.cache.TacgCacheManager;
import com.transerainc.adaws.cache.TenantCacheManager;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.ServerData;
import com.transerainc.security.SecurityLogoutHandler;

/**
 * @author rajeev.lochanam
 */
@Component
public class CacheService extends BaseService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CacheService.class.getName());

	@Autowired
	protected DesktopConfigManager agentDesktopConfigMap;

	@Autowired
	protected CloseEventCacheManager eventCacheManager;

	@Autowired
	protected TenantCacheManager tenantCache;

	@Autowired
	protected CacheServerManager cacheServer;

	@Autowired
	protected AgentCacheManager agentCache;

	@Autowired
	protected TacgCacheManager adaTacgMap;

	@Autowired
	protected ConnectionStateService connectionStateService;

	@Autowired
	private SecurityLogoutHandler logoutHandler;

	/**
	 * @param agentSessionId
	 * @param enterpriseName
	 */
	protected void clearCache(final String agentSessionId, final String enterpriseName) {
		if (StringUtils.isBlank(agentSessionId)) {
			LOGGER.info("===>> Tried erroneously to clear cache for blank agentSessionId: {}", agentSessionId);
			return;
		}

		LOGGER.info("Removing desktop configuration for sesssion id: {}, enterpriseName: {}", agentSessionId,
				enterpriseName);
		try {
			synchronized (agentDesktopConfigMap) {
				agentDesktopConfigMap.removeDesktopConfig(agentSessionId);
			}
		} catch (Exception exception) {
			LOGGER.warn(
					"Exception occurred while removing desktop configuration for sesssion id: {}, enterpriseName: {}, exception: {}",
					agentSessionId, enterpriseName, exception);
		}

		LOGGER.info("Removing agent entries from agentCache for sesssion id: {}, enterpriseName: {}", agentSessionId,
				enterpriseName);
		try {
			synchronized (agentCache) {
				agentCache.removeAgent(enterpriseName, agentSessionId);
			}
		} catch (Exception exception) {
			LOGGER.warn(
					"Exception occurred while removing agent entries from agentCache for sesssion id: {}, enterpriseName: {}, exception: {}",
					agentSessionId, enterpriseName, exception);
		}

		LOGGER.info("clearing websocket cache for {} ", agentSessionId);
		final String websocketToken = webSocketCacheManager.getToken(agentSessionId);
		try {
			synchronized (webSocketCacheManager) {
				// Note that the method webSocketCacheManager.removeToken(xyz) expects
				// the BE agent session id: xyz, so that it removes the FE web token mapping
				// first
				// and then cleans up the rest of the mappings.
				webSocketCacheManager.removeToken(agentSessionId);
				webSocketCacheManager.removeAgent(websocketToken);
			}
		} catch (Exception exception) {
			LOGGER.warn(
					"Exception occurred while clearing websocket cache entry of webSocketCacheManager for agent with agentSessionId: {}, websocketToken: {}, exception: {}",
					agentSessionId, websocketToken, exception);
		}

		final ServerData serverData = adaTacgMap.getAdaTacgMap(agentSessionId);
		LOGGER.info("{} server details for {} ", serverData, agentSessionId);
		if (serverData != null) {
			final String serverIp = serverData.getHost() + ":" + serverData.getPort();

			LOGGER.info("{} Removing agent entry from adaTacgMap for serverIp: {}", agentSessionId, serverIp);
			try {
				synchronized (adaTacgMap) {
					adaTacgMap.removeAgent(serverIp, agentSessionId);
				}
			} catch (Exception exception) {
				LOGGER.warn(
						"Exception occurred while removing agent of adaTacgMap for serverIp: {}, sesssion id: {}, exception: {}",
						serverIp, agentSessionId, exception);
			}
			if (!agentCache.agentSubscribed(enterpriseName)) {
				// FIXME COV 10140 Copy-paste error?
				try {
					synchronized (tenantCache) {
						tenantCache.removeTenant(serverIp, enterpriseName);
					}
				} catch (Exception exception) {
					LOGGER.warn(
							"Exception occurred while removing tenant of tenantCache for enterpriseName: {}, serverIp: {}, sesssion id: {}, exception: {}",
							enterpriseName, serverIp, agentSessionId, exception);
				}
			}

			if (!tenantCache.tenantsSubscribed(serverIp)) {
				LOGGER.info("removing cache for server IP '{}' ", serverIp);
				try {
					synchronized (cacheServer) {
						cacheServer.removeServer(serverIp);
					}
				} catch (Exception exception) {
					LOGGER.warn(
							"Exception occurred while removing tenant of tenantCache for serverIp: {}, exception: {}",
							serverIp, exception);
				}
			}
		}
	}

	protected void invalidateSessionContext(final String agentSessionId) {
		if (StringUtils.isBlank(agentSessionId)) {
			LOGGER.info("===>> Tried erroneously to invalidate Session Context for blank agentSessionId: {}",
					agentSessionId);
			return;
		}
		LOGGER.info("Invalidating Session and Context for agentSessionId: {}", agentSessionId);
		try {
			final String webToken = webSocketCacheManager.getToken(agentSessionId);
			final J2EContext j2eContext = webSocketCacheManager.getJ2EContext(webToken);
			final ProfileManager<CommonProfile> profileManager = webSocketCacheManager.getProfileManager(webToken);
			final List<CommonProfile> commonProfilesList = webSocketCacheManager.getCommonProfiles(webToken);
			final HttpSession httpSession = webSocketCacheManager.getHttpSession(webToken);
			final SecurityContext securityContext = webSocketCacheManager.getSecurityContext(webToken);
			logoutHandler.invalidateSession(j2eContext, profileManager, commonProfilesList, httpSession,
					securityContext);
		} catch (Exception exception) {
			LOGGER.warn("Exception occurred while invalidating Session and Context for sesssion id: {}, exception: {}",
					agentSessionId, exception);
		}
	}

	public void clearAgentCacheWithSessionInvalidation(final String agentSessionId) {
		LOGGER.info("Invoking invalidateSessionContext() on agentSessionId: {}", agentSessionId);
		invalidateSessionContext(agentSessionId);
		clearAgentCache(agentSessionId);
	}

	/**
	 * @param agentSessionId
	 */
	public void clearAgentCache(final String agentSessionId) {
		if (StringUtils.isBlank(agentSessionId)) {
			LOGGER.info("===>> Tried erroneously to clear all cache entries for blank agentSessionId: {}",
					agentSessionId);
			return;
		}
		final String websocketToken = webSocketCacheManager.getToken(agentSessionId);
		LOGGER.info("{} :===>> Clearing all the cache for agent and webToken: {}", agentSessionId, websocketToken);
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);

		LOGGER.info("{} Cancelling the scheduled task", agentSessionId);
		try {
			synchronized (connectionStateService) {
				connectionStateService.cancelJob(websocketToken);
			}
		} catch (Exception exception) {
			LOGGER.warn(
					"Exception occurred while cancelling job of connectionStateService for sesssion id: {}, exception: {}",
					agentSessionId, exception);
		}

		if (desktopConfig != null) {
			LOGGER.info("{} Removing agent entry from agentCache", agentSessionId);
			try {
				synchronized (agentCache) {
					agentCache.removeAgent(desktopConfig.getEnterpriseName(), agentSessionId);
				}
			} catch (Exception exception) {
				LOGGER.warn(
						"Exception occurred while removing agent of agentCache for enterpriseName: {}, sesssion id: {}, exception: {}",
						desktopConfig.getEnterpriseName(), agentSessionId, exception);
			}
		}

		final ServerData serverData = adaTacgMap.getAdaTacgMap(agentSessionId);

		LOGGER.info("{} server details for {} ", serverData, agentSessionId);
		if (serverData != null) {
			final String serverIp = serverData.getHost() + ":" + serverData.getPort();

			LOGGER.info("{} Removing agent entry from adaTacgMap for serverIp: {}", agentSessionId, serverIp);
			try {
				synchronized (adaTacgMap) {
					adaTacgMap.removeAgent(serverIp, agentSessionId);
				}
			} catch (Exception exception) {
				LOGGER.warn(
						"Exception occurred while removing agent of adaTacgMap for serverIp: {}, sesssion id: {}, exception: {}",
						serverIp, agentSessionId, exception);
			}

			if (desktopConfig != null) {
				LOGGER.info("clearing cache for IP {} for enterprise {} ", serverIp, desktopConfig.getEnterpriseName());
				if (!adaTacgMap.ipTiedWithAgents(serverIp)) {// !agentCache.agentSubscribed(desktopConfig.getEnterpriseName()))
																// {
					try {
						synchronized (tenantCache) {
							tenantCache.removeTenant(serverIp, desktopConfig.getEnterpriseName());
						}
					} catch (Exception exception) {
						LOGGER.warn(
								"Exception occurred while removing tenant of tenantCache for enterpriseName: {}, serverIp: {}, sesssion id: {}, exception: {}",
								desktopConfig.getEnterpriseName(), serverIp, agentSessionId, exception);
					}
				}
			}

			LOGGER.info("For '{}' IP : tenant subscribed {} ", serverIp, tenantCache.tenantsSubscribed(serverIp));
			if (!tenantCache.tenantsSubscribed(serverIp)) {
				LOGGER.info("removing cache for server IP '{}' ", serverIp);
				try {
					synchronized (cacheServer) {
						cacheServer.removeServer(serverIp);
					}
				} catch (Exception exception) {
					LOGGER.warn(
							"Exception occurred while removing tenant of tenantCache for serverIp: {}, exception: {}",
							serverIp, exception);
				}
			}
		}

		LOGGER.info("removing AdaTacgMapping cache entry for agent '{}' ", agentSessionId);
		try {
			synchronized (adaTacgMap) {
				adaTacgMap.removeAdaTacgMapping(agentSessionId);
			}
		} catch (Exception exception) {
			LOGGER.warn(
					"Exception occurred while removing AdaTacgMapping cache entry of adaTacgMap for agent for desktopConfig.getAgentSessionId(): {}, exception: {}",
					agentSessionId, exception);
		}

		LOGGER.info("removing agent configuration for agentSessionId: {}, websocketToken: {}", agentSessionId,
				websocketToken);
		try {
			synchronized (agentDesktopConfigMap) {
				agentDesktopConfigMap.removeDesktopConfig(agentSessionId);
			}
		} catch (Exception exception) {
			LOGGER.warn(
					"Exception occurred while removing configuration entry of agentDesktopConfigMap for agent with agentSessionId: {}, websocketToken: {}, exception: {}",
					agentSessionId, websocketToken, exception);
		}

		LOGGER.info("clearing event cache (queue states) for {} ", websocketToken);
		try {
			synchronized (eventCacheManager) {
				LOGGER.debug(
						"Clearing buffer/queue of AdaResponses, clearAgentCache() method of super class: CacheService, invoked for FE webTokenId: {}",
						websocketToken);
				eventCacheManager.clearQueueStates(websocketToken);
			}
		} catch (Exception exception) {
			LOGGER.warn(
					"Exception occurred while clearing event cache (queue states) of eventCacheManager for agent with agentSessionId: {}, websocketToken: {}, exception: {}",
					agentSessionId, websocketToken, exception);
		}

		LOGGER.info("clearing websocket cache for {} ", agentSessionId);
		try {
			synchronized (webSocketCacheManager) {
				// Note that the method webSocketCacheManager.removeToken(xyz) expects
				// the BE agent session id: xyz, so that it removes the FE web token mapping
				// first
				// and then cleans up the rest of the mappings.
				webSocketCacheManager.removeToken(agentSessionId);
				webSocketCacheManager.removeAgent(websocketToken);
			}
		} catch (Exception exception) {
			LOGGER.warn(
					"Exception occurred while clearing websocket cache entry of webSocketCacheManager for agent with agentSessionId: {}, websocketToken: {}, exception: {}",
					agentSessionId, websocketToken, exception);
		}

		LOGGER.info("{} :===>> Cleared all the cache for agent and webToken: {}", agentSessionId, websocketToken);
	}

}
