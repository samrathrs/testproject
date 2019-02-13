/**
 * 
 */
package com.transerainc.adaws.service;

import java.util.Iterator;
import java.util.SortedMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AgentStateConstants;
import com.transerainc.adaws.constants.CallPropertyConstants;
import com.transerainc.adaws.constants.ChannelStateConstant;
import com.transerainc.adaws.constants.ChannelType;
import com.transerainc.adaws.exception.ServerNotFoundException;
import com.transerainc.adaws.json.ChannelMessageConveyer;
import com.transerainc.adaws.model.AdaRequest;
import com.transerainc.adaws.model.AuxCode;
import com.transerainc.adaws.model.CallAssociatedData;
import com.transerainc.adaws.model.CallAssociatedData.Data;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.util.GenerateXmlUtil;
import com.transerainc.adaws.util.ParsingUtils;
import com.transerainc.adaws.util.StringUtils;
import com.transerainc.adaws.util.XmlInterpreter;

/**
 * @author rajeev.lochanam
 */
@Service
public class CallStateService extends BaseService implements AgentStateConstants {
    private static Logger LOGGER = LoggerFactory.getLogger(CallStateService.class.getName());

    @Autowired
    private XmlInterpreter xmlInterpreter;

    @Autowired
    private ChannelMessageConveyer channelMessage;

    @Autowired
    private DesktopConfigManager agentDesktopConfigMap;

    @Autowired
    private GenerateXmlUtil generateXmlUtil;

    @Autowired
    private DataPostService dataPostService;
    
    @Autowired
    private AgentStateService agentStateService;
    
    /**
     * @param adaRequest
     */
    public void requestHold(final AdaRequest adaRequest) {
        final String agentSessionId = adaRequest.getagentSessionId();
        LOGGER.info(agentSessionId + " :===>> Inside request hold : " + adaRequest);

        String callType = adaRequest.getCallType();
        final String strHoldFlag = adaRequest.getHoldFlag();

        if (StringUtils.isEmpty(callType)) {
            final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
            final String callParam = CallPropertyConstants.CALL_ID;

            callType = getCallProperty(desktopConfig, callParam);

            if (StringUtils.isEmpty(callType)) {
                callType = desktopConfig.getStateChangeData().getCallId();
            }
        }
        LOGGER.info(agentSessionId + " :===>> in requestHold(). CallType: " + callType + " holdFlag: " + strHoldFlag);
        final boolean holdFlag = StringUtils.getBoolean(strHoldFlag);
        LOGGER.info(agentSessionId + " :===>> in requestHold(). CallType: " + callType);

        String xml;
        if (holdFlag) {
            xml = generateXmlUtil.getAgentCommandXml(agentSessionId, HOLD, callType);
            LOGGER.info(agentSessionId + " :===>> Sending hold request to tacg " + xml);
        } else {
            xml = generateXmlUtil.getAgentCommandXml(agentSessionId, UNHOLD, callType);
            LOGGER.info(agentSessionId + " :===>> Sending unhold request to tacg " + xml);
        }

        String responseString = null;
        try {
            responseString = doHttpPost(agentSessionId, xml);
        } catch (final ServerNotFoundException e) {
            LOGGER.info("{} :===>> " + "server not found for hold request : {} ", agentSessionId, responseString);
        }

        LOGGER.info(agentSessionId + " :===>> response to hold request : " + responseString);
    }

    /**
     * @param adaRequest
     */
    public void requestCallEnd(final AdaRequest adaRequest) {
        final String agentSessionId = adaRequest.getagentSessionId();
        LOGGER.info(agentSessionId + " :===>> Inside request call end : " + adaRequest);

        final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);

        final String callParam = CallPropertyConstants.CALL_ID;
        String callId = getCallProperty(desktopConfig, callParam);

        if (StringUtils.isNotEmpty(adaRequest.getUpdatedCadJson())) {
            final CallAssociatedData cad = desktopConfig.getStateChangeData().getCallAssociatedData();
            LOGGER.info(agentSessionId + " :===>> existing call associated data : " + cad);
            final CallAssociatedData updatedCad = ParsingUtils.jsonStringToCad(cad, adaRequest.getUpdatedCadJson());

            if (updatedCad != null) {
                LOGGER.info(agentSessionId + " :===>> Adding updated call associated data : " + updatedCad);
                publishUpdatedCalldata(updatedCad, desktopConfig.getCallDataConfig(), agentSessionId);
            }
        }

        if (StringUtils.isEmpty(callId)) {
            callId = desktopConfig.getStateChangeData().getCallId();
        }
        final String xmlMessage = generateXmlUtil.getAgentCommandXml(agentSessionId, CallPropertyConstants.END_CALL,
                callId);

        LOGGER.info(agentSessionId + " :===>> call end requested: " + xmlMessage);

        String responseString = null;
        try {
            responseString = doHttpPost(agentSessionId, xmlMessage);
        } catch (final ServerNotFoundException e) {
            LOGGER.info("{} :===> server not found for call end request : {} ", agentSessionId, responseString);
        }
        LOGGER.info(agentSessionId + " :===> Request call end response : " + responseString);
    }

    /**
     * @param adaRequest
     */
    public void wrapUpCall(final AdaRequest adaRequest) {
        final String agentSessionId = adaRequest.getagentSessionId();
        LOGGER.info(agentSessionId + " :===>> Inside request wrap up call : " + adaRequest);

        final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
        final String wrapUpAuxCodeId = adaRequest.getWrapUpAuxCodeId();
        
        LOGGER.info("WrapUp AdaRequest IdleAuxCode: {}", adaRequest.getIdleAuxCodeId());
        
        final String idleAuxCodeId = getIdleAuxCodeId(adaRequest.getIdleAuxCodeId(), desktopConfig, agentSessionId);
        final String updatedCadJson = adaRequest.getUpdatedCadJson();

        LOGGER.info(agentSessionId + " :===>> WrapUpCall(" + wrapUpAuxCodeId + ", " + idleAuxCodeId + ", "
                + updatedCadJson + ")");
        final AuxCode[] auxCodes = new AuxCode[2];
        String nextState = getNextState(desktopConfig, agentSessionId);
        String xml = null;

        try {
            if (StringUtils.isNotEmpty(idleAuxCodeId)) {
                nextState = SUBSTATE_IDLE;
                final String idleDesc = desktopConfig.getCodeName(AuxCode.TYPE_IDLE, idleAuxCodeId);
                if (StringUtils.isEmpty(idleDesc)) {
                    auxCodes[0] = desktopConfig.getDefaultIdleAuxCode();
                } else {
                    auxCodes[0] = new AuxCode(AuxCode.TYPE_IDLE, idleAuxCodeId, idleDesc);
                }
                LOGGER.info(agentSessionId + " :===>> nextState : " + nextState);
            }

            if (StringUtils.isNotEmpty(wrapUpAuxCodeId)) {
                final String wrapUpDesc = desktopConfig.getCodeName(AuxCode.TYPE_WRAPUP, wrapUpAuxCodeId);

                if (StringUtils.isEmpty(wrapUpDesc)) {
                    auxCodes[1] = desktopConfig.getDefaultWrapUpAuxCode();
                } else {
                    auxCodes[1] = new AuxCode(AuxCode.TYPE_WRAPUP, wrapUpAuxCodeId, wrapUpDesc);
                }
                LOGGER.info(agentSessionId + " :===>> wrapUpDesc : " + wrapUpDesc);
            }

            LOGGER.info(agentSessionId + " :===>> Idle aux: " + (auxCodes[0] == null ? "" : auxCodes[0].getDesc()));
            LOGGER.info(agentSessionId + " :===>> wrapUp aux: " + (auxCodes[1] == null ? "" : auxCodes[1].getDesc()));
            LOGGER.info( desktopConfig.isOutdialCallCheck() + " :===>> Outdial call :::::::::: ");
            CallAssociatedData cad = desktopConfig.getStateChangeData().getCallAssociatedData();
            CallAssociatedData updatedCad = null;
            if (StringUtils.isNotEmpty(updatedCadJson)) {
                LOGGER.info(agentSessionId + " :===>> existing call associated data : " + cad);
                updatedCad = ParsingUtils.jsonStringToCad(cad, updatedCadJson);

                if (updatedCad != null) {
                    LOGGER.info(agentSessionId + " :===>> Adding updated call associated data : " + updatedCad);
                    cad = updatedCad;
                    publishUpdatedCalldata(cad, desktopConfig.getCallDataConfig(), agentSessionId);
                }

            }
            desktopConfig.setPrevState(ChannelStateConstant.WRAP_UP);
 
            xmlInterpreter.requestStateChange(STATE_LOGGED_IN, nextState, auxCodes, updatedCad, desktopConfig);
//MKOP Fix to 18406
          //xmlInterpreter.requestStateChange(STATE_LOGGED_IN, nextState, auxCodes, cad, desktopConfig);
            xml = channelMessage.updateAgentState(desktopConfig, ChannelType.Telephony,
					nextState, STATE_LOGGED_IN, auxCodes);

            LOGGER.info(agentSessionId + " :===>> Sending wrap up request to tacg : " + xml);
            Long agentId = Long.valueOf(desktopConfig.getAgentId());
            // Send State Change to ICX as well
			if (desktopConfig.isIcrmEnabled() && desktopConfig.isOutdialCallCheck()
					&& nextState.equals(SUBSTATE_AVAILABLE) && (desktopConfig.getChannelCapability() != null)
					&&		(desktopConfig.getChannelCapability().hasAnyOmniChannelCapability())) {
    	        try {
    	        	agentStateService.setStateOmniChannel(adaRequest, agentId);
    	    		} catch (Exception exception) {
    	    			LOGGER.error("Cannot set state of OmniChannels: {}", exception);
    	    			// TODO: Send setStateChange of OmniChannel failure/error to FE 			
    	    		}
    		} else {
    			LOGGER.debug("No omnichannels configured for this agent. No State Change request sent to ICX.");
    	    }
    		
            final String responseString = doHttpPost(agentSessionId, xml);
            desktopConfig.setOutdialCallCheck(false);
            LOGGER.info(agentSessionId + " :===>> response to call wrap-up : " + responseString);

            if (adaRequest.isDoLar()) {
                final String callParam = CallPropertyConstants.CALL_ID;
                String callId = getCallProperty(desktopConfig, callParam);

                if (StringUtils.isEmpty(callId)) {
                    callId = desktopConfig.getStateChangeData().getCallId();
                }

                dataPostService.postDataToCrmLite(adaRequest, agentSessionId, desktopConfig, callId);
            }

            desktopConfig.getStateChangeData().clearCallAssociatedData();

        } catch (final Exception e) {
            LOGGER.error(agentSessionId + " :===>> Failed to wrap up call", e);
        }
    }

    private String getNextState(DesktopConfiguration desktopConfig, String agentSessionId) {
        String nextState = SUBSTATE_AVAILABLE;

        AdaRequest bufferedAdaRequest = desktopConfig.getBufferedAdaRequest();
        if (bufferedAdaRequest != null) {
            LOGGER.info("About to flush Buffered AdaRequest of Frontend/FE AgentSessionId: {}, " +
                    "with Buffered SubStatus: {}, " + 
                    "and Buffered AdaRequest: {}",
                    agentSessionId,
                    bufferedAdaRequest.getState(),
                    bufferedAdaRequest);
            nextState = bufferedAdaRequest.getState();
            desktopConfig.resetBufferedAdaRequest();
            LOGGER.info("Flushed Buffered AdaRequest of Frontend/FE AgentSessionId: {}, " +
                    "with Buffered SubStatus: {}, " + 
                    "and Buffered AdaRequest: {}",
                    agentSessionId,
                    bufferedAdaRequest.getState(),
                    bufferedAdaRequest);
        } else {
            LOGGER.info("Not flushing Buffered AdaRequest of Frontend/FE AgentSessionId: {}, " +
                    "because Buffered AdaRequest is null: {}",
                    agentSessionId,
                    bufferedAdaRequest);
        }

        return nextState;
    }

    private String getIdleAuxCodeId(String defaultIdleAuxCodeId, DesktopConfiguration desktopConfig, String agentSessionId) {
        String idleAuxCodeId = defaultIdleAuxCodeId;

        AdaRequest bufferedAdaRequest = desktopConfig.getBufferedAdaRequest();
        if (bufferedAdaRequest != null) {
            LOGGER.info("About to flush Buffered AdaRequest of Frontend/FE AgentSessionId: {}, " +
                    "with Buffered SubStatus: {}, " + 
                    "and Buffered AdaRequest: {}",
                    agentSessionId,
                    bufferedAdaRequest.getState(),
                    bufferedAdaRequest);
            idleAuxCodeId = bufferedAdaRequest.getAuxCodeIdArray();
            LOGGER.info("Flushed Buffered AdaRequest of Frontend/FE AgentSessionId: {}, " +
                    "with Buffered SubStatus: {}, " + 
                    "Idle Aux Code Id: {}",
                    "Buffered AdaRequest: {}" +
                    agentSessionId,
                    bufferedAdaRequest.getState(),
                    bufferedAdaRequest.getAuxCodeIdArray(),
                    bufferedAdaRequest);
        } else {
            LOGGER.info("Not flushing Buffered AdaRequest of Frontend/FE AgentSessionId: {}, " +
                    "because Buffered AdaRequest is null: {}",
                    agentSessionId,
                    bufferedAdaRequest);
        }

    	return idleAuxCodeId;
    }

    /**
     * @param desktopConfig
     * @param callParam
     * @return
     */
    private String getCallProperty(final DesktopConfiguration desktopConfig, final String callParam) {
        String callId = "";
        final SortedMap<String, Data> dataMap = desktopConfig.getStateChangeData().getCallAssociatedData() != null ? desktopConfig
                .getStateChangeData().getCallAssociatedData().getDataMap()
                : null;
        if (dataMap != null && !dataMap.isEmpty()) {
            final Iterator<String> itr = dataMap.keySet().iterator();
            while (itr.hasNext()) {
                final String key = itr.next();

                if (key.equalsIgnoreCase(callParam)) {
                    final Data data = dataMap.get(key);
                    callId = data.getValue();
                }
            }
        }

        return callId;
    }

    /**
     * @param agentSessionId
     * @param callId
     */
    public void requestHold(final String agentSessionId, final String callId) {
        final String xml = generateXmlUtil.getAgentCommandXml(agentSessionId, HOLD, callId);
        LOGGER.info(agentSessionId + " :===>> Sending hold request to tacg " + xml);

        String responseString = null;
        try {
            responseString = doHttpPost(agentSessionId, xml);
        } catch (final ServerNotFoundException e) {
            LOGGER.info("{} :===>> " + "server not found for hold request : {} ", agentSessionId, responseString);
        }

        LOGGER.info(agentSessionId + " :===>> response to hold request : " + responseString);
    }

}
