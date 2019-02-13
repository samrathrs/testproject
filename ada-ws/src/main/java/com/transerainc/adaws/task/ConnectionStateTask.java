/**
 * 
 */
package com.transerainc.adaws.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.cache.CloseEventCacheManager;
import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AgentStateConstants;
import com.transerainc.adaws.constants.AppParams;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.controller.AdaPingController;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.service.AuthenticationService;
import com.transerainc.adaws.service.CacheService;

/**
 * @author varsha.shivaram
 */
@Component("connectionStateTask")
@Scope("prototype")
public class ConnectionStateTask implements Runnable {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionStateTask.class);

	@Autowired
	protected DesktopConfigManager agentDesktopConfigMap;

	@Autowired
	private WebSocketCacheManager webSocketCacheManager;

	@Autowired
	private AuthenticationService authService;

	@Autowired
	private CloseEventCacheManager eventCacheManager;
	
	@Autowired
	private CacheService cacheService;

	private String websocketId;
	private long heartbeatRate;

	/**
	 * @param websocketId
	 * @param heartbeatRate
	 */
	public void init(final String websocketId, final long heartbeatRate) {
		this.websocketId = websocketId;
		this.heartbeatRate = heartbeatRate;
	}

	@Override
	public void run() {
		final String agentSessionId = webSocketCacheManager.getAgent(websocketId);
		try {
			final DesktopConfiguration deskConf = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
			
			if (deskConf != null) {
				
				final long delta = 1000; 
				// Add a delta to heartbeatRate to prevent this scheduled task from detecting a false positive
				// case of lost heart beat e.g. when cadence of this task is the same as the heartbeatRate.
				
				String missedHeartBeatAllowed = deskConf.getValue(AppParams.MISSED_HEART_BEATS_ALLOWED);
				//If missedHeartBeatAllowed is ""
				if(missedHeartBeatAllowed.isEmpty() || missedHeartBeatAllowed == null || missedHeartBeatAllowed==""){
					missedHeartBeatAllowed = AppParams.DEFAULT_MISSED_HB_ALLOWED;
				}
		
				String lostConnectionRecoveryTimeout = deskConf.getValue("lostConnectionRecoveryTimeout");
				if(lostConnectionRecoveryTimeout.isEmpty() || lostConnectionRecoveryTimeout == null || lostConnectionRecoveryTimeout==""){
					lostConnectionRecoveryTimeout = AppParams.LOST_CONNECTION_REC_TIMEOUT;
				}

				if (System.currentTimeMillis() - deskConf.getConnectionStateModel().getHbTimestamp() > (heartbeatRate + delta)) {
					int missedHeartbeatCount = deskConf.getConnectionStateModel().getMissedHeartbeatCount();
					missedHeartbeatCount = missedHeartbeatCount + 1;
					deskConf.getConnectionStateModel().setMissedHeartbeatCount(missedHeartbeatCount);
					LOGGER.info(agentSessionId + " Missed heartbeat count - " + missedHeartbeatCount);
		
					if((missedHeartbeatCount == 1) && AdaPingController.synchMapForValue.containsKey(websocketId)){
						String logoutReason = null;
						logoutReason = AdaPingController.synchMapForValue.get(websocketId);
						LOGGER.warn("{} ===>> logout reason: {} ", agentSessionId, logoutReason);
					}
					
					if (deskConf.getConnectionStateModel().getMissedHeartbeatCount() > Integer
							.valueOf(missedHeartBeatAllowed)) {
						
						deskConf.getConnectionStateModel().setConnectionLost(true);
		
						LOGGER.warn(agentSessionId + " Connection Lost. Trying to recover connection");
		
						long currentTime = System.currentTimeMillis();
						long lastHeartbeatTimestamp = deskConf.getConnectionStateModel().getHbTimestamp();
						long lostConnectionRecoveryTimeoutAsLongValue = Long.valueOf(lostConnectionRecoveryTimeout);
						int currentMissedHeartbeatCounter = deskConf.getConnectionStateModel().getMissedHeartbeatCount();
						int missedHeartBeatAllowedAsIntValue = Integer.valueOf(missedHeartBeatAllowed);
		
						LOGGER.warn(
								"currentTime: {}, " + 
								"lastHeartbeatTimestamp: {}, " +
								"lostConnectionRecoveryTimeoutAsLongValue: {}, " +
								"currentMissedHeartbeatCounter: {}, " +
								"missedHeartBeatAllowedAsIntValue: {}, " +
								"heartbeatRate: {}, "	+ 
								"agentSessionId: {}",
								currentTime,
								lastHeartbeatTimestamp,
								lostConnectionRecoveryTimeoutAsLongValue,
								currentMissedHeartbeatCounter,
								missedHeartBeatAllowedAsIntValue,
								heartbeatRate, 
								agentSessionId
						);
						
						boolean isDiffBetweenCurrentTimeAndLastHeartbeatAboveLostConnectionRecoverTimeoutThreshold = 
								(currentTime - lastHeartbeatTimestamp) > lostConnectionRecoveryTimeoutAsLongValue;
	
						boolean isCurrentMissedHeartbeatCounterAtOrAboveMissedHeartbeatAllowedThreshold = 
								currentMissedHeartbeatCounter >= missedHeartBeatAllowedAsIntValue;
	
						LOGGER.debug(
								"isDiffBetweenCurrentTimeAndLastHeartbeatAboveLostConnectionRecoverTimeoutThreshold: {}",
								isDiffBetweenCurrentTimeAndLastHeartbeatAboveLostConnectionRecoverTimeoutThreshold
								);
						LOGGER.debug(
								"isCurrentMissedHeartbeatCounterAtOrAboveMissedHeartbeatAllowedThreshold: {}",
								isCurrentMissedHeartbeatCounterAtOrAboveMissedHeartbeatAllowedThreshold
								);
						boolean conditionForLoggingOutAgent = 
							(isDiffBetweenCurrentTimeAndLastHeartbeatAboveLostConnectionRecoverTimeoutThreshold
							&&
							isCurrentMissedHeartbeatCounterAtOrAboveMissedHeartbeatAllowedThreshold);
	
						LOGGER.warn(
								"Combined condition for lost connection recovery and logging out agent is: {}",
								conditionForLoggingOutAgent
								);
		
						if (conditionForLoggingOutAgent) {
							deskConf.getConnectionStateModel().setConnectionRecovery(true);
		
							LOGGER.error(agentSessionId + " Connection Recovery failed. Logging out agent.");
		
							
							String logoutReason = null;
							// tacgResp.setLogoutReason("Browser closed"); //Changing the reason phrase.
							if(AdaPingController.synchMapForValue.containsKey(websocketId)){
								logoutReason = AdaPingController.synchMapForValue.get(websocketId);
								AdaPingController.synchMapForValue.remove(websocketId);
								LOGGER.error("{} ===>> logout reason: {} ", websocketId, logoutReason);
							} else {
								logoutReason = AgentStateConstants.LOST_CONNECTION;
								LOGGER.error("{} ===>> logout reason: {} ", websocketId, logoutReason);
							}
							
							int logoutRequestSent = deskConf.getConnectionStateModel().getRecoveryLogoutRequest();
							if (logoutRequestSent < ContextConstants.MAX_RECOVERY_LOGOUT_ATTEMPTS) {
								deskConf.getConnectionStateModel().setRecoveryLogoutRequest(logoutRequestSent+1);
								authService.requestLogout(agentSessionId, logoutReason);
							} else {
								// give up logging out, and clear cache here
								deskConf.getConnectionStateModel().setMissedHeartbeatCount(0);
								deskConf.getConnectionStateModel().setRecoveryLogoutRequest(0);
							}
							
							try {
								LOGGER.warn("Invoking cacheService.clearAgentCacheWithSessionInvalidation() to log out with CAS for "		+
										"BE agentSessionId: {} , "								+
										"UserName: {} , "										+
										"AgentName: {} , "										+ 
										"for Lost Connection and logging out agent",
										agentSessionId,
										deskConf.getUserName(),
										deskConf.getAgentName());
								cacheService.clearAgentCacheWithSessionInvalidation(agentSessionId);
							} catch (Exception exception) {
								LOGGER.error("Error occurred while Invoking cacheService.clearAgentCacheWithSessionInvalidation() to log out with CAS for " + 
																				"BE agentSessionId: {} , " + 
																				"UserName: {} , " + 
																				"AgentName: {} , " + 
																				"for Lost Connection and logging out agent; " +
																				"With exception: {}", 
																				agentSessionId, 
																				deskConf.getUserName(), 
																				deskConf.getAgentName(),
																				exception);
							}

							try {
								LOGGER.warn("Clearing buffer/queue of AdaResponses, " + 
										"because connection has been lost entirely for and logging out FE webTokenId: {}",
										websocketId);		                		
								clearQueuedStates();
							} catch (Exception exception) {
								LOGGER.error("Error occurred while Clearing buffer/queue of AdaResponses for " + 
										"BE agentSessionId: {} , " + 
										"UserName: {} , " + 
										"AgentName: {} , " + 
										"FE webTokenId: {} , " + 
										"for Lost Connection and logging out agent; " +
										"With exception: {}", 
										agentSessionId, 
										deskConf.getUserName(), 
										deskConf.getAgentName(),
										websocketId,
										exception);
							}
							
						} else {
							LOGGER.debug("Conditions for lost connection recovery and logging out agent are not met!");
						}
					}
				} else {
					// Reset missed heartbeat count to zero (0), 
					// because connection recovered or there was no missed heartbeat
					deskConf.getConnectionStateModel().setMissedHeartbeatCount(0);
					clearQueuedStates();
				}
			}
		} catch (Exception exception) {
			LOGGER.error("Exception occurred in connectionStateTask.run(): {}", exception);
			try {
				cacheService.clearAgentCacheWithSessionInvalidation(agentSessionId);
			} catch (Exception e) {
				LOGGER.error("Exception occurred in catch() clause of try-catch block in connectionStateTask.run(): {}", e);
			}
		}
	}

	private void clearQueuedStates() {
			eventCacheManager.clearQueueStates(websocketId);
	}

}
