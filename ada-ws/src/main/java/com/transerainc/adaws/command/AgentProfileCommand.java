package com.transerainc.adaws.command;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AgentProfileConstants;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.AgentProfile;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.DialPlan;
import com.transerainc.adaws.util.StringUtils;
import com.transerainc.adaws.util.XMLtoJsonConverter;
import com.transerainc.agent.profile.DialPlanEntityDocument.DialPlanEntity;
import com.transerainc.agent.profile.EntityDocument.Entity;
import com.transerainc.agent.profile.EntityListDocument.EntityList;
import com.transerainc.agent.profile.ProfileAttributeDocument.ProfileAttribute;

/**
 * @author rajeev.lochanam
 */
@Component
public class AgentProfileCommand implements AgentProfileConstants {
    private static Logger LOGGER = LoggerFactory.getLogger(AgentProfileCommand.class.getName());

    @Autowired
    private DesktopConfigManager agentDesktopConfigMap;

    /**
     * @param agentProfileDoc
     * @param agentSessionId
     * @return
     */
    public AdaResponse processData(
            final com.transerainc.agent.profile.AgentProfileDocument.AgentProfile agentProfileDoc,
            final String agentSessionId, final String xml) {
        final AgentProfile agentProfile = new AgentProfile();

        long startTime = 0;
        if (LOGGER.isDebugEnabled()) {
            startTime = System.currentTimeMillis();
            LOGGER.debug("===>> Started agent profile process : " + startTime);
        }

        if (agentProfileDoc.getProfileAttributeArray() != null && agentProfileDoc.getProfileAttributeArray().length > 0) {
            for (final ProfileAttribute attribute : agentProfileDoc.getProfileAttributeArray()) {
                final String key = attribute.getName();
                final String value = StringUtils.isEmpty(attribute.getValue()) ? "" : attribute.getValue();

                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("Profile attribute: " + key + " = " + value);
                }
                agentProfile.setAttribute(key, value);
            }
        }

        if (agentProfileDoc.getEntityListArray() != null && agentProfileDoc.getEntityListArray().length > 0) {
            for (final EntityList entityList : agentProfileDoc.getEntityListArray()) {
                final String entityType = entityList.getType();
                
                final Map<String, String> entityMap = getEntities(entityList.getEntityArray());
                agentProfile.setEntityList(entityType, entityMap);
                if (!entityMap.isEmpty()) {
                    agentProfile.setAttribute(NODE_DEFAULT + entityType, entityList.getEntityArray(0).getId());
                }
                
                if (AgentProfileConstants.IDLE_CODE.equalsIgnoreCase(entityType )) { // for entityList type="idleCode"
                	final Map<Integer, AgentProfile.Tuple> entityMapIdle = getEntitiesIdleCode(entityList.getEntityArray());
	                if (!entityMapIdle.isEmpty()) {
	                	agentProfile.setIdleCodes(entityMapIdle);
	                }
                }
            }
        }

        if (agentProfileDoc.getDialPlanArray() != null && agentProfileDoc.getDialPlanArray().length > 0) {
            for (final com.transerainc.agent.profile.DialPlanDocument.DialPlan dialPlan : agentProfileDoc
                    .getDialPlanArray()) {
                final String dialPlanType = dialPlan.getType();
                final DialPlan dPlan = getDialPlan(dialPlanType, dialPlan.getDialPlanEntityArray());
                agentProfile.addDialPlan(dialPlanType, dPlan);
            }
        }

        final DesktopConfiguration conf = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
        if (conf != null) {
            conf.setAgentProfile(agentProfile);
        }

        // COV 10156 Dereference null return value
        final JSONObject jsonResponse = XMLtoJsonConverter.convertXMLtoJSON(xml);
        String jsonStr = (jsonResponse != null) ? jsonResponse.toString() :  "";
		LOGGER.info("agent profile updated " + jsonStr);

        if (LOGGER.isDebugEnabled()) {
            final long endTime = System.currentTimeMillis() - startTime;
            LOGGER.debug("===>> Finished agen profile process : " + endTime);
        }

        if (conf != null) {
            conf.setStringifiedAgentProfileJSON(jsonStr);
        }

        return new AdaResponse(CommandConstants.AGENT_PROFILE_UPDATE, jsonStr, agentSessionId);
    }

    /**
     * @param dialPlanType
     * @param dialPlanEntity
     * @return
     */
    private DialPlan getDialPlan(final String dialPlanType, final DialPlanEntity[] dialPlanEntityArray) {
        long startTime = 0;
        if (LOGGER.isDebugEnabled()) {
            startTime = System.currentTimeMillis();
            LOGGER.debug("===>> Started getting dial plan : " + startTime);
        }

        LOGGER.info("Adding dial plan: " + dialPlanType);
        final DialPlan dialPlan = new DialPlan(dialPlanType);

        for (final DialPlanEntity dialPlanEntity : dialPlanEntityArray) {
            final String name = dialPlanEntity.getName();
            final String regex = dialPlanEntity.getRegex();
            final String prefix = dialPlanEntity.getPrefix();
            final String strippedChars = dialPlanEntity.getStrippedChars();

            final DialPlan.Allowed allowed = new DialPlan.Allowed(name);

            LOGGER.info("===>> Allowed: {}", allowed);

            if (allowed != null) {
                allowed.setRegex(regex);
                allowed.setPrefix(prefix);
                allowed.setStrippedChars(strippedChars);
                dialPlan.addAllowed(allowed);
            }
        }

        if (LOGGER.isDebugEnabled()) {
            final long endTime = System.currentTimeMillis() - startTime;
            LOGGER.debug("===>> returning deial plan : " + endTime);
        }
        return dialPlan;
    }

    /**
     * @param entityArray
     * @return
     */
    private Map<String, String> getEntities(final Entity[] entityArray) {
        long startTime = 0;
        if (LOGGER.isDebugEnabled()) {
            startTime = System.currentTimeMillis();
            LOGGER.debug("===>> Started getting entities : " + startTime);
        }

        //NOTE: This *MUST* be a LinkedHashMap to preserve insertion order - first element should be the default code
        final Map<String, String> map = new LinkedHashMap<String, String>();
        for (final Entity entity : entityArray) {
            final String id = entity.getId();
            final String name = StringUtils.isEmpty(entity.getName()) ? "" : entity.getName();

            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Entity: " + id + " = " + name);
            }
            map.put(id, name);
        }

        if (LOGGER.isDebugEnabled()) {
            final long endTime = System.currentTimeMillis() - startTime;
            LOGGER.debug("===>> Returning entities : " + endTime);
        }
        return map;
    }
    
    /**
     * @param entityArray
     * @return
     */
    private Map<Integer, AgentProfile.Tuple> getEntitiesIdleCode(final Entity[] entityArray) {
        long startTime = 0;
        if (LOGGER.isDebugEnabled()) {
            startTime = System.currentTimeMillis();
            LOGGER.debug("===>> Started getting entities : " + startTime);
        }

        final Map<Integer, AgentProfile.Tuple> map = new LinkedHashMap<Integer, AgentProfile.Tuple>();
        for (final Entity entity : entityArray) {
        	
            final String id = entity.getId();
            final String name = StringUtils.isEmpty(entity.getName()) ? "" : entity.getName();
            final Boolean isSys = entity.getIsSystem();

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("===>> Got entities :{}, {}, {}, {}", id, name, isSys, entity.getOmniChannelAuxId());
            }
            
            if (isSys) {     
            	final String omniAuxIdString = entity.getOmniChannelAuxId();
            	if (org.apache.commons.lang3.StringUtils.isNotBlank(omniAuxIdString)) {
            		try {
                    	int omniAuxId = Integer.valueOf(omniAuxIdString);
                    	
        	            if (LOGGER.isInfoEnabled()) {
        	                //LOGGER.info("Entity: {} = {} , omniChannelAuxId = {}", id, name, omniAuxId);
        	            }
        	            
                        final AgentProfile.Tuple tuple = new AgentProfile.Tuple(id, name, isSys, omniAuxId);
        	            map.put(omniAuxId, tuple);
            		} catch (Exception exception) {
            			LOGGER.error("Error exception while retrieving System Aux Code: {}", exception);
            		}
            	}
            }
        }

        if (LOGGER.isDebugEnabled()) {
            final long endTime = System.currentTimeMillis() - startTime;
            LOGGER.debug("===>> Returning entities : " + endTime);
        }
        return map;
    }


}