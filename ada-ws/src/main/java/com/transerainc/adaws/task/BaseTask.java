package com.transerainc.adaws.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ScheduledFuture;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.transerainc.adaws.cache.AgentCacheManager;
import com.transerainc.adaws.cache.CacheServerManager;
import com.transerainc.adaws.cache.TacgCacheManager;
import com.transerainc.adaws.cache.TenantCacheManager;
import com.transerainc.adaws.connection.HttpUtil;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.AppParams;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.exception.HeartBeatException;
import com.transerainc.adaws.exception.ServerNotFoundException;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.ServerData;
import com.transerainc.adaws.model.TenantDataModel;
import com.transerainc.adaws.service.AuthenticationService;
import com.transerainc.adaws.service.CacheService;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.StringUtils;
import com.transerainc.adaws.util.WebSocketDataPublisher;

/**
 * @author rajeev.lochanam
 */
public abstract class BaseTask extends CacheService implements Runnable {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseTask.class);

	protected final String DELIMITER = "~";

	@Autowired
	protected HttpUtil httpUtil;

	@Autowired
	protected TacgCacheManager adaTacgMap;

	@Autowired
	protected WebSocketDataPublisher dataPublisher;

	private ScheduledFuture<?> taskId = null;

	protected transient String serverIp;

	@Autowired
	protected AgentCacheManager agentCache;

	@Autowired
	protected CacheServerManager cacheServer;

	@Autowired
	protected TenantCacheManager tenantCache;

	@Autowired
	private PropertiesUtil propertiesUtil;
	
	@Autowired
	private AuthenticationService authenticationService;

	private String adaHost;
	private String adaPort;

	protected BaseTask() {

		final File propertiesFile = new File("./config/ada-ws.properties");
		
		try (FileInputStream fileStream = new FileInputStream(
				propertiesFile)) {
			final Properties properties = new Properties();
			properties.load(fileStream);
			adaPort = properties.getProperty(AdaConstants.PORT_NUMBER);
			adaHost = properties.getProperty(AdaConstants.HOST_NAME);
		} catch (final FileNotFoundException e) {
			LOGGER.error("Exception occured while forming callBackUrl: " + e);
		} catch (final IOException e) {
			LOGGER.error("Exception occured while forming callBackUrl: " + e);
		}
	}

	/**
	 * @return the serverIp
	 */
	public String getServerIp() {
		return serverIp;
	}

	/**
	 * @param serverIp
	 *            the serverIp to set
	 */
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	/**
	 * @return
	 */
	protected JSONObject connectionRestored() {
		final JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put(AdaConstants.CODE, String.valueOf(ContextConstants.ERROR_CONNECTION_RESTORED));
			jsonResponse.put(AdaConstants.DETAIL, "");
		} catch (final JSONException e) {
			LOGGER.error("Exception occured while forming json string on errorOccured condition {} " + e);
		}
		return jsonResponse;
	}

	/**
	 * @return
	 */
	protected JSONObject connectionLost() {
		final JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put(AdaConstants.CODE, String.valueOf(ContextConstants.ERROR_CONNECTION_LOST));
			jsonResponse.put(AdaConstants.DETAIL, "");
		} catch (final JSONException e) {
			LOGGER.error("Exception occured while forming json string on errorOccured condition {} " + e);
		}
		return jsonResponse;
	}

	/**
	 * @return
	 */
	protected JSONObject connectionFailed() {
		final JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put(AdaConstants.CODE, String.valueOf(ContextConstants.ERROR_CONNECTION_FAILURE_NOT_ENABLED));
			jsonResponse.put(AdaConstants.DETAIL, "");
		} catch (final JSONException e) {
			LOGGER.error("Exception occured while forming json string on errorOccured condition {} " + e);
		}
		return jsonResponse;
	}

	/**
	 * @return
	 */
	protected JSONObject recoveryFailed() {
		final JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put(AdaConstants.CODE, String.valueOf(ContextConstants.ERROR_RECOVERY_FAILED));
			jsonResponse.put(AdaConstants.DETAIL, "");
		} catch (final JSONException e) {
			LOGGER.error("Exception occured while forming json string on errorOccured condition {} " + e);
		}
		return jsonResponse;
	}

	/**
	 * @return
	 */
	protected JSONObject tokenChanged() {
		final JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put(AdaConstants.CODE, String.valueOf(ContextConstants.ERROR_TOKEN_CHANGED));
			jsonResponse.put(AdaConstants.DETAIL, "");
		} catch (final JSONException e) {
			LOGGER.error("Exception occured while forming json string on errorOccured condition {} " + e);
		}
		return jsonResponse;
	}

	/**
	 * @param tokenModel
	 */
	protected void publishTokenMismatch(final boolean publishReconnect) {
		// final List<String> reconnectAgents = new ArrayList<String>();
		if (tenantCache.tenantsSubscribed(serverIp)) {
			JSONObject jsonResponse = this.tokenChanged();

			for (final TenantDataModel tenantModel : tenantCache.getTenants(serverIp)) {
				final List<String> agents = agentCache.getAgents(tenantModel.getTenantName());
				final List<String> clearingList = this.getListToPublish(agents);

				if (clearingList != null && !clearingList.isEmpty()) {
					final List<String> publishingList = new ArrayList<String>();
					for (final String agentSessionId : clearingList) {
						publishingList.add(webSocketCacheManager.getToken(agentSessionId));
						LOGGER.debug("TACG Heartbeat failed: Logging out of ICX for agentSessionId: {}", agentSessionId);
						authenticationService.requestLogoutOmniChannel(agentSessionId);
						super.clearAgentCache(agentSessionId);
					}

					this.publishToClient(publishingList, jsonResponse, CommandConstants.ERROR_OCCURRED,
							"in Heartbeat failed", publishReconnect);
				}

			}
		}
	}

	/**
	 * @param agents
	 * @param adaResponse
	 * @param logMessage
	 */
	protected List<String> getListToPublish(final List<String> agents) {
		final List<String> clearingList = new ArrayList<String>();

		if (agents != null && !agents.isEmpty()) {
			for (final String agentSession : agents) {
				final ServerData serverData = adaTacgMap.getAdaTacgMap(agentSession);
				final String serverSaved = serverData.getHost() + ":" + serverData.getPort();
				if (serverSaved.equals(this.serverIp)) {
					clearingList.add(agentSession);
				}
			}
		}

		return clearingList;
	}

	/**
	 * @param agents
	 * @param adaResponse
	 * @param logMessage
	 */
	protected void publishToClient(final List<String> agents, final JSONObject jsonResponse, final String jsMethod,
			final String logMessage, final boolean publishReconnect) {

		if (agents != null && !agents.isEmpty()) {
			for (final String agentSession : agents) {
				this.publishToClient(agentSession, jsonResponse, jsMethod, logMessage, publishReconnect);
				LOGGER.warn("Publishing to client, agentSession: {}, jsonResponse: {}, jsMethod: {}, logMessage: {}, and publishReconnect: {}",
						agentSession, jsonResponse, jsMethod, logMessage, publishReconnect);
			}
		}
	}

	/**
	 * @param agentSession
	 * @param adaResponse
	 */
	protected void publishToClient(final String agentSession, JSONObject jsonResponse, final String jsMethod,
			final String logMessage, final boolean publishReconnect) {

		// If failure is not enabled for the instance of ADA then, logout the user and clear the agent cache
		if (publishReconnect) {
			if (StringUtils.isNotEmpty(propertiesUtil.getAdaProperty(AppParams.FAILOVER_ENABLED))
					&& !Boolean.valueOf(propertiesUtil.getAdaProperty(AppParams.FAILOVER_ENABLED))) {
				jsonResponse = this.connectionFailed();
			}
		}

		final AdaResponse adaResponse = new AdaResponse(CommandConstants.ERROR_OCCURRED, jsonResponse.toString(),
				agentSession);

		try {
			dataPublisher.publishData(adaResponse);
		} catch (final Exception e) {
			LOGGER.info("{} problem while publishing data to queue {} {} ", agentSession, logMessage, e);
			LOGGER.info("{} ada response {} : {}", agentSession, logMessage, adaResponse);
		}
	}

	/**
	 * @param server
	 * @param adaToken
	 * @return
	 * @throws ServerNotFoundException
	 * @throws HeartBeatException
	 */
	protected String postHeartBeat(final String server, final String adaToken,long seqNum) throws ServerNotFoundException,
			HeartBeatException {
		final long timestampLong = System.currentTimeMillis()/1000L;
		final String paramBody = String.valueOf(seqNum) + DELIMITER + String.valueOf(timestampLong) + DELIMITER + adaToken + DELIMITER + adaHost + ":" + adaPort;
		LOGGER.debug("The Adas's ping request is --> {}", paramBody);
		String responseString = httpUtil.doHeartBeatPost(paramBody, server,
				StringUtils.getBoolean(propertiesUtil.getAdaProperty("sslEnabled")),
				propertiesUtil.getAdaProperty("heart.beat.context"));
		LOGGER.info("The tacg's response for ada's ping {}", responseString);
		if(responseString.contains("~")){
			responseString = responseString.substring(responseString.lastIndexOf("~")+1);
		}
		final String token = responseString;

		if (cacheServer.serverExists(serverIp)) {
			final ServerData dServer = cacheServer.getServer(serverIp);

			if (StringUtils.isEmpty(dServer.getTacgToken())) { throw new HeartBeatException("Null Token"); }

			if (StringUtils.isEmpty(token)) { throw new ServerNotFoundException("Null Token"); }

			if (!responseString.equals(dServer.getTacgToken())) {
				cacheServer.updateServer(server, responseString);

				throw new HeartBeatException("Token Mismatch");
			}
		}

		return responseString;
	}

	/**
	 * @return the recoveryTask
	 */
	public ScheduledFuture<?> getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId
	 *            the recoveryTask to set
	 */
	public void setTaskId(ScheduledFuture<?> taskId) {
		this.taskId = taskId;
	}

	/**
	 * @param taskId
	 *            the recoveryTask to set
	 */
	public void cancelTask() {
		if (this.taskId != null) {
			this.taskId.cancel(true);
		}
	}
}
