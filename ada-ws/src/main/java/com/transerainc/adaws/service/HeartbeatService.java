/**
 * 
 */
package com.transerainc.adaws.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.AgentStateConstants;
import com.transerainc.adaws.constants.ChannelStateConstant;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.json.StateCacheJson;
import com.transerainc.adaws.model.AdaRequest;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.task.AdaBrowserCloseTask;

/**
 * @author rajeev.lochanam
 */
@Component
public class HeartbeatService extends CacheService {
	private static final Logger LOGGER = LoggerFactory.getLogger(HeartbeatService.class.getName());

	private final long CLOSE_CHECK_FREEQUENCY = 5000L;

	@Autowired
	protected TaskScheduler taskScheduler;

	@Autowired
	private AdaBrowserCloseTask adaBrowserCloseTask;

	@Autowired
	private StateCacheJson stateCacheJson;

	/**
	 * @param adaRequest
	 * @throws Exception
	 */
	public void processRequest(final AdaRequest adaRequest) throws Exception {
		final String agentSession = adaRequest.getagentSessionId();
		final String redirectApi = adaRequest.getReloadApi();

		LOGGER.info(agentSession + " ===> Reload request sent for agent, And the redirect API is : " + redirectApi);
		AdaResponse adaResponse = null;
		final String payLoad = adaRequest.getReloadRequestString();

		final JSONObject jsonObj = new JSONObject(payLoad);
		final String data = jsonObj.getString("data");

		adaResponse = new AdaResponse(redirectApi, data, agentSession);

		LOGGER.info(agentSession + " ===> publishing the response for reload request : " + adaResponse);
		publishData(adaResponse);
	}

	/**
	 * @param adaRequest
	 */
	public void processHeartBeat(final AdaRequest adaRequest) {
		final String agentSession = adaRequest.getagentSessionId();
		
		final JSONObject json = constructToken(adaRequest); 
		final AdaResponse adaResponse = new AdaResponse(AdaConstants.REQUEST_FOR_HEART_BEAT, json.toString(),
				agentSession);

		LOGGER.debug ( "processHeartBeat() for FE agentSession: {}", agentSession);
		
		publishData(adaResponse);

		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(webSocketCacheManager
				.getAgent(agentSession));

		if (desktopConfig != null) {
			if (desktopConfig.getConnectionStateModel() != null) {
				desktopConfig.getConnectionStateModel().setHbTimestamp(System.currentTimeMillis());
				desktopConfig.getConnectionStateModel().setMissedHeartbeatCount(0);
				LOGGER.debug( "setHbTimestamp: {} in desktop config", 
						desktopConfig.getConnectionStateModel().getHbTimestamp());
			} else {
				LOGGER.debug( "desktop Config getConnectionStateModel()  is NULL : Unable to update timestamp in desktop config");
			}
		} else {
			LOGGER.debug( "desktop Config is NULL : Unable to update timestamp in desktop config");
		}
	}

	/**
	 * @param adaRequest
	 */
	public void processBrowserClose(final AdaRequest adaRequest) {
		final String agentSession = adaRequest.getagentSessionId();
		final String logoutWaitTime = adaRequest.getReloadWaitTime();
		long logoutTime = CLOSE_CHECK_FREEQUENCY;

		LOGGER.info("{} : Token - reload wait time : {}", agentSession, logoutWaitTime);
		if (StringUtils.isNotEmpty(logoutWaitTime)) {
			logoutTime = Long.valueOf(logoutWaitTime);
		}

		if (!eventCacheManager.isCloseScheduled()) {
			final ScheduledFuture<?> sf = taskScheduler.scheduleAtFixedRate(adaBrowserCloseTask,
					new Date(System.currentTimeMillis() + logoutTime), logoutTime);

			eventCacheManager.setSchedulerId(sf);
		}

		eventCacheManager.tieScheduler(agentSession);
	}

	/**
	 * @param adaRequest
	 */
	public void processBrowserCloseCancel(final AdaRequest adaRequest) {
		final String agentToken = adaRequest.getagentSessionId();

		eventCacheManager.clearScheduler(agentToken);

		if (!eventCacheManager.isCloseScheduled()) {
			final ScheduledFuture<?> sf = eventCacheManager.getSchedulerId();

			if (sf != null) {
				sf.cancel(true);
				eventCacheManager.setSchedulerId(null);
			}
		}
	}

	/**
	 * @param adaRequest
	 */
	public void processBrowserReloaded(final AdaRequest adaRequest) {
		final String agentToken = adaRequest.getagentSessionId();

		final List<AdaResponse> queuedResponse = eventCacheManager.getQueueStates(agentToken);
		LOGGER.info("{} : Token - Queued states : {}", agentToken, queuedResponse);
		// eventCacheManager.clearQueueStates(agentToken);

		if (queuedResponse != null && !queuedResponse.isEmpty()) {
			for (final AdaResponse responseAda : queuedResponse) {
				dataPublisher.publishData(responseAda);
				LOGGER.info("processBrowserReloaded() - {} Publishing queued states : {}", responseAda.getAgentSessionId(), responseAda.getData());
			}
		}

		if (eventCacheManager.isCloseScheduled() && eventCacheManager.isStatesQueued()) {
			// TODO:
			// Why are we cleaning the entire map on successful reload of Agent's browser??
			LOGGER.info("Clearing all queued states...");
			eventCacheManager.clearQueuedStates();
			LOGGER.info("{} Cleared queued states : {}", agentToken, eventCacheManager.isStatesQueued());
		}

		final AdaResponse responseAda = new AdaResponse(CommandConstants.AGENT_RELOAD_SUCCESS, "", agentToken);
		/*
		 * if (!webSocketCacheManager.isTokenCached(agentToken)) {
		 * responseAda = new AdaResponse(CommandConstants.AGENT_STATE_MISSMATCH, "", agentToken);
		 * }
		 */
		dataPublisher.publishData(responseAda);
	}

	/**
	 * @param adaRequest
	 */
	public void restoreAgentState(final AdaRequest adaRequest) {
		final String agentToken = adaRequest.getagentSessionId();

		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(webSocketCacheManager
				.getAgent(agentToken));

		// Agent not found in Backend
		if (desktopConfig == null) {
			// Respond with error that frontend Agent Session id/Web Token is not found in backend map
			final AdaResponse lastResponseAda = 
					new AdaResponse(CommandConstants.AGENT_NOT_FOUND, "", agentToken);
			dataPublisher.publishData(lastResponseAda);
			LOGGER.info("{} Finished responding to restore UI state " +
					"without finding Agent in map for " + 
					"FE (Agent Session Id/Web Token) : {}", 
					lastResponseAda,
					agentToken);
			return;
		}

		// Retrieve queue of Backend's responses to FE Agent
		final List<AdaResponse> queuedResponsesList = eventCacheManager.getQueueStates(agentToken);
		LOGGER.info("{} : Token - Queued states : {}", agentToken, queuedResponsesList);

		// Send to Front End the queued of Backend's knowledge of Agent's states
		if (queuedResponsesList != null && !queuedResponsesList.isEmpty()) {
			LOGGER.debug("Clearing buffer/queue of AdaResponses, " + 
					"because restoring Connection for FE webTokenId: {}",
					agentToken);
			eventCacheManager.clearQueueStates(agentToken);
			for (final AdaResponse responseAda : queuedResponsesList) {
				dataPublisher.publishData(responseAda);
				LOGGER.info("restoreAgentState() - {} Publishing queued states : {}", responseAda.getAgentSessionId(), responseAda.getData());
			}
		}
		

		// Send closing message of Agent Connection Recovery to Front End
		final AdaResponse lastResponseAda = new AdaResponse(CommandConstants.AGENT_CONNECTION_RECOVERED, "", agentToken);
		dataPublisher.publishData(lastResponseAda);
		LOGGER.info("Finished responding to restore UI state for FE (Agent Session Id/Web Token) : {}", 
				lastResponseAda,
				agentToken);
	}


	/**
	 * 
	 * This method is used for new approach for Browser Reload feature.
	 * 
	 * @param adaRequest
	 */
	public void reloadAgentState(final AdaRequest adaRequest) {
		final String agentToken = adaRequest.getagentSessionId();

		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(webSocketCacheManager
				.getAgent(agentToken));

		// Agent not found in Backend
		if (desktopConfig == null) {
			// Respond with error that frontend Agent Session id/Web Token is not found in backend map
			final AdaResponse agentNotFoundAdaResponse = 
					new AdaResponse(CommandConstants.AGENT_NOT_FOUND, "", agentToken);
			dataPublisher.publishData(agentNotFoundAdaResponse);
			LOGGER.info("{} Finished responding to restore UI state " +
					"without finding Agent in map for " + 
					"FE (Agent Session Id/Web Token) : {}", 
					agentNotFoundAdaResponse,
					agentToken);
			return;
		}

		final AdaResponse freshestAgentStateAdaResponse = stateCacheJson.buildAgentStateData(adaRequest);
		if (freshestAgentStateAdaResponse != null) {
			dataPublisher.publishData(freshestAgentStateAdaResponse);
		}
		LOGGER.info("Finished responding to reload UI state: {}, for FE (Agent Session Id/Web Token) : {}", 
				freshestAgentStateAdaResponse,
				agentToken);
	}

	/**
	 * @param adaRequest
	 * 
	 * Invoked only from Legacy Agent Desktop: desktop.jsp
	 */
	public void syncAgentState(final AdaRequest adaRequest) {
		final String agentToken = adaRequest.getagentSessionId();

		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(webSocketCacheManager
				.getAgent(agentToken));

		boolean stateMach = false;
		if (desktopConfig != null) {
			final String currentSubState = desktopConfig.getSubStatus();
			LOGGER.info("{} Sync agent states BE state {} and UIState {}", agentToken, currentSubState,
					adaRequest.getUiAgentState());
			if (stateMatches(adaRequest.getUiAgentState(), currentSubState)) {
				stateMach = true;
				LOGGER.debug("Clearing buffer/queue of AdaResponses, " + 
						"because sync-ing Agent State for FE webTokenId: {}",
						agentToken);
				eventCacheManager.clearQueueStates(agentToken);
			}
		}

		final List<AdaResponse> queuedResponse = eventCacheManager.getQueueStates(agentToken);
		LOGGER.info("{} : Token - Queued states : {}", agentToken, queuedResponse);

		LOGGER.info("{} Agent state matches : {}", agentToken, stateMach);
		if (!stateMach && queuedResponse != null && !queuedResponse.isEmpty()) {
			eventCacheManager.clearQueueStates(agentToken);

			boolean triggerEvent = false;
			for (final AdaResponse responseAda : queuedResponse) {
				boolean stateEqual = false;
				JSONObject json = null;
				try {
					json = new JSONObject(responseAda.getData());

					LOGGER.info("{} Agent state mis-matched UI state : {} and cached state : {} ", agentToken,
							json.getString("subStatus"));
					if (stateMatches(adaRequest.getUiAgentState(), json.getString("subStatus"))) {
						stateEqual = true;
					}
				} catch (final JSONException e) {
					// TODO Auto-generated catch block
					LOGGER.error("Error getting data from Ada Response: {}, with exception: {}", 
							responseAda,
							e);
				}

				if (stateEqual) {
					triggerEvent = true;
				}

				LOGGER.info("{} Agent state mis-matched stateEqual : {} and cached state : {} ", agentToken,
						stateEqual, triggerEvent);
				if (triggerEvent) {
					dataPublisher.publishData(responseAda);
				}
				LOGGER.info("syncAgentState() - {} Publishing queued states : {}", responseAda.getAgentSessionId(), responseAda.getData());
			}

			final AdaResponse responseAda = new AdaResponse(CommandConstants.AGENT_RELOAD_SUCCESS, "", agentToken);
			dataPublisher.publishData(responseAda);
		} else if (!stateMach && desktopConfig != null) {
			// final AdaResponse responseAda = new AdaResponse(CommandConstants.AGENT_STATE_MISSMATCH, "", agentToken);
			LOGGER.info("{} Publishing the state from desktopConfig : {}", agentToken,
					desktopConfig.getLastStateTriggered());
			dataPublisher.publishData(desktopConfig.getLastStateTriggered());
		}
	}

	private boolean stateMatches(final String uiState, final String currentSubState) {
		if (StringUtils.isNotEmpty(currentSubState)) {
			if (currentSubState.equalsIgnoreCase(uiState)) {
				return true;
			} else if (ChannelStateConstant.CONSULTING.equalsIgnoreCase(uiState)
					&& (ChannelStateConstant.AVAILABLE_CONSULTING.equalsIgnoreCase(currentSubState) || ChannelStateConstant.CONNECTED_CONSULTING
							.equalsIgnoreCase(currentSubState))) {
				return true;
				// || AgentStateConstants.CONSULT_RESERVED.equalsIgnoreCase(currentSubState)
			} else if ((ChannelStateConstant.AVAILABLE_CONSULTING.equalsIgnoreCase(uiState) || ChannelStateConstant.CONSULT_RESERVED
					.equalsIgnoreCase(uiState))
					&& (ChannelStateConstant.CONSULTING.equalsIgnoreCase(currentSubState) || ChannelStateConstant.AVAILABLE_CONSULT_RESERVED
							.equalsIgnoreCase(currentSubState))) {
				return true;
				// || AgentStateConstants.CONSULT_RESERVED.equalsIgnoreCase(currentSubState)
			} else if (AgentStateConstants.RESERVED.equalsIgnoreCase(currentSubState)
					&& AgentStateConstants.OUTDIAL_RESERVED.equalsIgnoreCase(uiState)) { return true; }
		}

		return false;
	}

	/**
	 * @param adaResponse
	 */
	private void publishData(final AdaResponse adaResponse) {
		try {
			dataPublisher.publishData(adaResponse);
		} catch (final Exception e) {
			LOGGER.warn("exception occured while publishing data to queue: " + e);
		}
	}

	/**
	 * @return
	 */
	private JSONObject constructToken(AdaRequest adaRequest) {
		final JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put(AdaConstants.CODE, "");
			jsonResponse.put(AdaConstants.ADA_TOKEN, DesktopConfigManager.getTokenada());
			jsonResponse.put("timestamp",System.currentTimeMillis());
			jsonResponse.put("pingCounter", adaRequest.getPingC());
		} catch (final JSONException e) {
			LOGGER.error("Exception occured while forming json string on errorOccured condition {} " + e);
		}
		return jsonResponse;
	}
}
