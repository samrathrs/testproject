package com.transerainc.adaws.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.exception.HeartBeatException;
import com.transerainc.adaws.exception.ServerNotFoundException;
import com.transerainc.adaws.model.ServerData;
import com.transerainc.adaws.model.TenantDataModel;
import com.transerainc.adaws.service.AuthenticationService;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.SpringContextHelper;

/**
 * @author rajeev.lochanam
 */
@Component("heartBeatTask")
@Scope("prototype")
public class HeartBeatTask extends BaseTask {
	private static final Logger LOGGER = LoggerFactory.getLogger(HeartBeatTask.class);

	private transient boolean recovering = false;

	private transient int retryCount = 0;

	private Long recoveryStartTime = 0L;

	
	@Autowired
	private AuthenticationService authenticationService;

	public HeartBeatTask() {
		super();
	}

	@Override
	public void run() {
		if (!cacheServer.serverExists(serverIp) || !tenantCache.tenantsSubscribed(serverIp)) {
			super.cancelTask();

			return;
		}
		final Map<String, TenantDataModel> tenants = tenantCache.getTenant(serverIp);

		if (tenants != null && !tenants.isEmpty()) {
			final ServerData server = cacheServer.getServer(serverIp);

			try {
				long seqNum = server.getSeqNum();
				this.postHeartBeat(serverIp, DesktopConfigManager.getTokenada(),seqNum);
					server.setSeqNum(seqNum + 1);
					cacheServer.populateServer(serverIp, server);
				this.setRetryCount(0);
				publishServerRecoveryIfAny();
			} catch (ServerNotFoundException e) {
				LOGGER.warn("Recovery - Heart beat to TACG server {} failed. Publishing the failure info to client",
						server);

				this.publishServerFailure();
			} catch (HeartBeatException e) {
				LOGGER.warn("Recovery - {} - TACG server restarted. Publishing the failure info to client", server);

				super.cancelTask();
				super.publishTokenMismatch(true);
			}
		}
	}

	/**
	 * @param tacgToken
	 */
	private void publishServerRecoveryIfAny() {
		if (this.isRecovering()) {
			final List<String> agents = new ArrayList<String>();
			if (tenantCache.tenantsSubscribed(serverIp)) {
				final List<TenantDataModel> tenants = tenantCache.getTenants(serverIp);

				if (tenants != null && !tenants.isEmpty()) {

					for (final TenantDataModel tenant : tenants) {
						tenant.setConnectionLost(false);
						//if(agentCache.getAgents(tenant.getTenantName())!=null) //MKOP-to avoid null pointer exception
					   // 	agents.addAll(agentCache.getAgents(tenant.getTenantName()));
							try{
								agents.addAll(agentCache.getAgents(tenant.getTenantName())); //FIXME - NullPointer Exception
							}
							catch(NullPointerException e){
								LOGGER.error("NullPointerException - Error",e);
							}
					}
					
				}
			}

			if (agents != null && !agents.isEmpty()) {
				final JSONObject jsonResponse = connectionRestored();

				for (final String agentSession : agents) {
					LOGGER.info("Published TACG {} heart beat failure to {} ", serverIp, agentSession);

					final ServerData serverData = adaTacgMap.getAdaTacgMap(agentSession);
					final String serverSaved = serverData.getHost() + ":" + serverData.getPort();
					if (serverSaved.equals(this.serverIp)) {
						publishToClient(webSocketCacheManager.getToken(agentSession), jsonResponse,
								CommandConstants.ERROR_OCCURRED, "in recovered", false);
					}
				}

				this.setRecovering(false);
			}
		}
	}

	/**
	 * @param tacgToken
	 */
	private void publishServerFailure() {
		if (!this.isRecovering()) {
			this.setRecoveryStartTime(System.currentTimeMillis());
		}

		this.setRecovering(true);

		List<String> clearingList = null;
		if (tenantCache.tenantsSubscribed(serverIp)) {
			this.setRecovering(true);
			final List<TenantDataModel> tenants = tenantCache.getTenants(serverIp);

			if (tenants != null && !tenants.isEmpty()) {

				JSONObject jsonResponse = null;
				for (final TenantDataModel tenant : tenants) {
					final String agentSession = tenant.getAgentSessions();
					final int heartBeatInterval = tenant.getHeartBeatInterval();
					final int recoveryTimeOut = tenant.getLostConnectionRecoveryTimeout();
					final int missedHeartBeatAllowed = tenant.getMissedHeartBeatsAllowed();
					final long elapsedFreeq = System.currentTimeMillis() - this.getRecoveryStartTime();
					String retryFrequency = SpringContextHelper.getBean(PropertiesUtil.class).getAdaProperty("heart.beat.rate");
					final int threadFreeq = Integer.valueOf(retryFrequency) * this.getRetryCount();

					LOGGER.info("Processing TACG {} for Tenant {} ", super.serverIp,
							tenant.getTenantName());

					final List<String> agents = new ArrayList<String>();
					if (tenant.getRetryCount() == 0 && this.getRetryCount() == 0 && !tenant.getConnectionLost()) {
						LOGGER.error("Publishing the TACG {} connection lost at retry count : {} and {} ",
								super.serverIp, tenant.getRetryCount(), this.getRetryCount());

						jsonResponse = super.connectionLost();
						try{
							agents.addAll(agentCache.getAgents(tenant.getTenantName())); //FIXME - NullPointer Exception
						}
						catch(NullPointerException e){
							LOGGER.error("NullPointerException - Error",e);
						}
						LOGGER.error("Publishing the TACG {} connection lost to {} ", super.serverIp,
								tenant.getTenantName());
						tenant.setConnectionLost(true);

						final List<String> publishingList = new ArrayList<String>();
						if (agents != null && !agents.isEmpty()) {
							final List<String> publishers = this.getListToPublish(agents);
							if (publishers != null && !publishers.isEmpty()) {
								for (final String sessionId : publishers) {
									publishingList.add(webSocketCacheManager.getToken(sessionId));
								}
							}
						}

						this.publishToClient(publishingList, jsonResponse, CommandConstants.ERROR_OCCURRED, "", false);
					} else if (tenant.getRetryCount() >= missedHeartBeatAllowed) {
						if (elapsedFreeq >= heartBeatInterval && elapsedFreeq < recoveryTimeOut) {
							//agents.addAll(agentCache.getAgents(tenant.getTenantName()));
							try{
								agents.addAll(agentCache.getAgents(tenant.getTenantName())); //FIXME - NullPointer Exception
							}
							catch(NullPointerException e){
								LOGGER.error("NullPointerException - Error",e);
							}
							LOGGER.error("Publishing the TACG {} connection lost to {} ", tenant, agentSession);
						} else if (elapsedFreeq >= recoveryTimeOut) {
							LOGGER.info("Publishing the TACG failure to TACG {} at elapsedFreeq : {} and recoveryTimeOut : {} to agentSessionId : {}",
									tenant, elapsedFreeq, recoveryTimeOut, agentSession);

							// agents.addAll(agentCache.getAgents(tenant.getTenantName()));
							try {
								agents.addAll(agentCache
										.getAgents(tenant.getTenantName())); // FIXME
																				// -
																				// NullPointer
																				// Exception
							} catch (NullPointerException e) {
								LOGGER.error("NullPointerException - Error", e);
							}
							LOGGER.error(
									"Publishing the recovery failure of TACG {} to tenant {} ",
									super.serverIp, tenant.getTenantName());
							clearingList = this.getListToPublish(agents);
						}
					}

					if (elapsedFreeq > 0) {
						tenant.setRetryCount(Integer.valueOf(String.valueOf(elapsedFreeq / heartBeatInterval)));
					}

					if (threadFreeq >= heartBeatInterval) {
						this.setRetryCount(0);
					}
				}
			}
		}

		if (clearingList != null && !clearingList.isEmpty()) {
			super.cancelTask();

			final List<String> publishingList = new ArrayList<String>();
			for (final String agentSessionId : clearingList) {
				LOGGER.error("Connection Lost to TACG. Logging out of ICX for AgentSessionId: {}", agentSessionId);
				authenticationService.requestLogoutOmniChannel(agentSessionId);
				publishingList.add(webSocketCacheManager.getToken(agentSessionId));
				super.clearAgentCache(agentSessionId);
			}

			this.publishToClient(publishingList, super.recoveryFailed(), CommandConstants.ERROR_OCCURRED, "", true);
		}
	}

	/**
	 * @return the retryCount
	 */
	public int getRetryCount() {
		return retryCount;
	}

	/**
	 * @param retryCount
	 *            the retryCount to set
	 */
	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

	/**
	 * @return the recovering
	 */
	public boolean isRecovering() {
		return recovering;
	}

	/**
	 * @param recovering
	 *            the recovering to set
	 */
	public void setRecovering(boolean recovering) {
		this.recovering = recovering;
	}

	/**
	 * @return the recoveryStartTime
	 */
	public Long getRecoveryStartTime() {
		return recoveryStartTime;
	}

	/**
	 * @param recoveryStartTime
	 *            the recoveryStartTime to set
	 */
	public void setRecoveryStartTime(Long recoveryStartTime) {
		this.recoveryStartTime = recoveryStartTime;
	}

}
