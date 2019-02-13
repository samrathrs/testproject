/**
 * 
 */
package com.transerainc.adaws.command;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AgentStateConstants;
import com.transerainc.adaws.constants.CallStateConstants;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.exception.InterpretationException;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.CallAssociatedData;
import com.transerainc.adaws.model.CallAssociatedData.Data;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.TacgResponse;
import com.transerainc.adaws.service.CallStateService;
import com.transerainc.adaws.util.StringUtils;
import com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand;
import com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage;
import com.transerainc.aha.gen.agent.ParamDocument.Param;

/**
 * @author rajeev.lochanam
 */
@Component
public class OutdialCommand {
    static Logger LOGGER = LoggerFactory.getLogger(OutdialCommand.class.getName());

    @Autowired
    private DesktopConfigManager configMap;

    @Autowired
    private CallStateService callStateService;

    /**
     * @param tacgResp
     * @return
     */
    public AdaResponse processOutdialAccepted(final TacgResponse tacgResp) {
        final String jsMethod = CommandConstants.AGENT_PROPERTY_CHANGED;

        // final NamedNodeMap attrs = tacgResp.getAttributes();
        final String agentSessionId = tacgResp.getAgentSessionId();

        final DesktopConfiguration conf = configMap.getConfigForAgent(agentSessionId);

        final Map<String, String> map = conf.getProperties();
        map.put(ContextConstants.PARAM_SUB_STATE, CallStateConstants.OUTDIAL_REQUEST_ACCEPTED);
        map.put(ContextConstants.PARAM_STATE, conf.getStatus());

        final Gson gson = new GsonBuilder().create();
        final String json = gson.toJson(map);

        // final PeerAgent peerAgent = new PeerAgent();

        // peerAgent.setDn(getValue(attrs, CallPropertyConstants.PEER_DN));
        // peerAgent.setTeamId(getValue(attrs, CallPropertyConstants.PEER_TEAM_ID));
        // peerAgent.setAgentId(getValue(attrs, CallPropertyConstants.PEER_AGENT_ID));
        // peerAgent.setChannelId(getValue(attrs, CallPropertyConstants.PEER_CHANNEL_ID));
        // peerAgent.setChannelType(getValue(attrs, CallPropertyConstants.PEER_CHANNEL_TYPE));
        // peerAgent.setSessionId(getValue(attrs, CallPropertyConstants.PEER_AGENT_SESSION_ID));
        //
        // final DesktopConfiguration config = configMap.getConfigForAgent(agentSessionId);
        // config.setPeerAgentDetails(peerAgent);

        return new AdaResponse(jsMethod, json, tacgResp.getAgentSessionId());
    }

    /**
     * @param tacgResp
     * @return
     * @throws JSONException
     * @throws InterpretationException
     */
    public AdaResponse processOutdialConsulting(final TacgResponse tacgResp) throws InterpretationException,
            JSONException {

        final String agentSessionId = tacgResp.getAgentSessionId();

        final DesktopConfiguration conf = configMap.getConfigForAgent(agentSessionId);

        if (conf.isAgentavailable()) {
            if (!conf.isServiceRequested() && conf.getRoutedCallId() != null) {
                LOGGER.info(agentSessionId + " Putting routed call on hold while consulting.");
                callStateService.requestHold(agentSessionId, conf.getRoutedCallId());
            }
            if (tacgResp.getAgentCommand().getName().trim().equals(CallStateConstants.CONSULTING)) {
                if (AgentStateConstants.CONNECTED_CONSULTING.equals(conf.getSubStatus())) {
                    conf.getCallModel().setConsulting(true);
                }
            }
            return null;
        }

        final String jsMethod = CommandConstants.CALL_PROPERTY_CHANGED;

        final AgentCommand agentCommand = tacgResp.getAgentCommand();

        // Process command message, if any
        final CommandMessage commandMessage = agentCommand.getCommandMessage();

        if (commandMessage != null) {
            // commandMessageCommand.processData(commandMessage, conf, agentCommand.getCallId());
        }

        setConferenceStatus(agentSessionId, false);

        // Bug fix 17564
        // String callData = formatShowableCalldata(conf);
        final String callData = formatShowableCalldata(commandMessage, conf);

        final String json = null;
        return new AdaResponse(jsMethod, json, agentSessionId, callData);
    }

    /**
     * @param agentSessionId
     * @param status
     */
    private void setConferenceStatus(final String agentSessionId, final boolean status) {
        final DesktopConfiguration config = configMap.getConfigForAgent(agentSessionId);

        config.getCallModel().setConferencing(status);
    }

    /**
     * @param conf
     * @return
     */
    private String formatShowableCalldata(final DesktopConfiguration conf) {
        String callData = null;

        if (conf.getStateChangeData() != null && conf.getStateChangeData().getCallAssociatedData() != null) {
            final SortedMap<String, Data> dataMap = conf.getStateChangeData().getCallAssociatedData().getDataMap();
            final TreeMap<String, Data> filteredMap = new TreeMap<String, Data>();
            if (dataMap != null && !dataMap.isEmpty()) {
                final Iterator<String> itr = dataMap.keySet().iterator();
                while (itr.hasNext()) {
                    final String key = itr.next();
                    if (conf.getCallDataConfig().isAllowedKey(key)) {
                        filteredMap.put(key, dataMap.get(key));
                    }
                }

                callData = toJson(filteredMap);
            }
        }

        return callData;
    }

    /**
     * @param commandMessage
     * @param conf
     * @return
     */
    private String formatShowableCalldata(final CommandMessage commandMessage, final DesktopConfiguration conf) {
        String callData = null;

        if (commandMessage != null && commandMessage.getParamArray() != null
                && commandMessage.getParamArray().length > 2) {
            final TreeMap<String, Data> filteredMap = new TreeMap<String, Data>();
            for (final Param param : commandMessage.getParamArray()) {
                final String id = StringUtils.isEmpty(param.getId()) ? "" : param.getId();
                final String name = StringUtils.isEmpty(param.getName()) ? "" : param.getName();
                final String value = StringUtils.isEmpty(param.getValue()) ? "" : param.getValue();
                final boolean isEditable = param.getEditable() ? true : false;

                if (conf.getCallDataConfig().isAllowedKey(name)) {
                    final CallAssociatedData cad = new CallAssociatedData();
                    cad.putData(id, name, value, isEditable);
                    filteredMap.put(name, cad.getDataMap().get(name));
                }
            }
            callData = toJson(filteredMap);
        } else {
            callData = formatShowableCalldata(conf);
        }

        return callData;
    }

    /**
     * @param request
     * @return
     */
    private static String toJson(final SortedMap<String, Data> request) {
        // convert to json
        final Gson gson = new GsonBuilder().create();
        final String json = gson.toJson(request);

        return json;
    }

}
