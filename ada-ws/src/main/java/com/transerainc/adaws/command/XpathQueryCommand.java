/**
 * 
 */
package com.transerainc.adaws.command;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AgentProfileConstants;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.TacgResponse;
import com.transerainc.adaws.util.StringUtils;
import com.transerainc.aha.gen.agent.AgentDocument.Agent;
import com.transerainc.aha.gen.agent.AgentsDocument.Agents;
import com.transerainc.aha.gen.agent.VirtualTeamDocument.VirtualTeam;
import com.transerainc.aha.gen.agent.VirtualTeamListDocument.VirtualTeamList;
import com.transerainc.aha.gen.agent.XPathQueryResultDocument.XPathQueryResult;

/**
 * @author rajeev.lochanam
 */
@Component
public class XpathQueryCommand implements AgentProfileConstants {
    private static Logger LOGGER = LoggerFactory.getLogger(XpathQueryCommand.class.getName());

    @Autowired
    private DesktopConfigManager agentDesktopConfigMap;

    /**
     * @param docElem
     * @param sessionId
     * @return
     * @throws JSONException
     */
    public AdaResponse processData(final TacgResponse tacgResp) throws JSONException {
        long startTime = 0;
        if (LOGGER.isDebugEnabled()) {
            startTime = System.currentTimeMillis();
            LOGGER.debug("===>> Starting create agent list command : " + startTime);
        }

        final XPathQueryResult xpathQueryResult = tacgResp.getXpathQueryResult();
        final AdaResponse response = processResponse(xpathQueryResult, tacgResp.getAgentSessionId());

        if (LOGGER.isDebugEnabled()) {
            final long endTime = System.currentTimeMillis() - startTime;
            LOGGER.debug("===>> Finished create agent list command : " + endTime);
        }
        return response;
    }

    /**
     * @param xpathQueryResult
     * @param agentSessionId
     * @return
     * @throws JSONException
     */
    private AdaResponse processResponse(final XPathQueryResult xpathQueryResult, final String agentSessionId)
            throws JSONException {
        JSONArray list = null;
        final JSONObject obj = new JSONObject();
        String commandType = CommandConstants.AGENT_LIST_CHANGED;

        if (xpathQueryResult.getAgents() != null) {
            list = processAgentList(xpathQueryResult.getAgents());
            obj.put(ContextConstants.PARAM_AGENT_LIST, list);
        }

        if (xpathQueryResult.getVirtualTeamList() != null) {
            list = processVteamList(xpathQueryResult.getVirtualTeamList());
            commandType = CommandConstants.VTEAM_LIST_CHANGED;
            obj.put(ContextConstants.PARAM_VTEAM_LIST, list);

            final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
            obj.put(ALLOW_CONSULT_TO_QUEUE, desktopConfig.getAgentProfile().isConsultToQueueAllowed());
        }

        return new AdaResponse(commandType, obj.toString(), agentSessionId);
    }

    /**
     * @param agents
     * @return
     * @throws JSONException
     */
    @SuppressWarnings("unchecked")
    private JSONArray processAgentList(final Agents agents) throws JSONException {
        final JSONArray agentProf = new JSONArray();

        for (final Agent agent : agents.getAgentArray()) {
            final JSONObject obj = new JSONObject();

            obj.put(NODE_ID, agent.getAgentId());

            if (agent.getName() != null) {
                obj.put(NODE_NAME, agent.getName());
            }

            if (agent.getLoginUserId() != null) {
                obj.put(LOGIN_USER_NAME, agent.getLoginUserId());
            }

            if (agent.getDn() != null) {
                obj.put(NODE_DN, agent.getDn());
            }

            if (agent.getSubStatus() != null) {
                obj.put(NODE_STATE, agent.getSubStatus() != null ? agent.getSubStatus().toString() : "");
            }

            if (agent.getTeamId() != null) {
                obj.put(NODE_TEAM_ID, agent.getTeamId());
            }

            if (agent.getTeamName() != null) {
                obj.put(NODE_TEAM_NAME, agent.getTeamName());
            }

            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Added to agent list: " + obj);
            }

            agentProf.add(obj);
        }

        return agentProf;
    }

    /**
     * @param virtualTeamList
     * @return
     * @throws JSONException
     */
    @SuppressWarnings("unchecked")
    private JSONArray processVteamList(final VirtualTeamList virtualTeamList) throws JSONException {
        final JSONArray agentProf = new JSONArray();
        for (final VirtualTeam vteam : virtualTeamList.getVirtualTeamArray()) {
            final JSONObject obj = new JSONObject();

            obj.put(NODE_ID, vteam.getId());

            if (vteam.getName() != null) {
                obj.put(NODE_NAME, vteam.getName());
            }

            if (vteam.getType() != null) {
                obj.put(NODE_TYPE, vteam.getType());
            }

            if (!StringUtils.toString(vteam.getSeratelAcd()).isEmpty()) {
                obj.put(NODE_IS_SERATEL_ACD, StringUtils.toString(vteam.getSeratelAcd()).equals(NODE_SERATEL_ACD_VALUE));
            }

            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Added to agent list: " + obj);
            }

            agentProf.add(obj);
        }

        return agentProf;
    }

}
