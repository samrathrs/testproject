package com.transerainc.adaws.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.constants.AgentStateConstants;
import com.transerainc.adaws.constants.ChannelStateConstant;
import com.transerainc.adaws.constants.ChannelType;
import com.transerainc.adaws.model.AuxCode;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.util.GenerateXmlUtil;

/**
 * @author rajeev.lochanam
 */
@Component
public class ChannelMessageConveyer implements AgentStateConstants {

    private static Logger LOGGER = LoggerFactory.getLogger(ChannelMessageConveyer.class.getName());

    @Autowired
    private GenerateXmlUtil generateXmlUtil;

    private AuxCode lastIdleAuxCode = null;
    private AuxCode lastWrapUpAuxCode = null;

    /**
     * @param config
     * @param subState
     * @param state
     * @param auxCodes
     * @return
     */
    public String updateAgentState(final DesktopConfiguration config, final ChannelType channelType,
			final String subState, final String state, final AuxCode[] auxCodes) {
        final String agentSessionId = config.getAgentSessionId();
        long startTime = 0;
        if (LOGGER.isDebugEnabled()) {
            startTime = System.currentTimeMillis();
            LOGGER.debug("{} ===>> Starting update agent state : {}", agentSessionId, startTime);
        }
        
        if (auxCodes != null) {
	        for (final AuxCode aux : auxCodes) {
	            if (aux != null) {
	            		LOGGER.debug("updateAgentState() -- > passed in auxCodes : {}", aux);
	            }
	        }
	    }
        
        if (ChannelStateConstant.IDLE.equals(subState)) {
            updateIdleAuxCode(auxCodes, config);
        }      
        // if (ChannelStateConstant.IDLE.equals(subState) || ChannelStateConstant.AVAILABLE.equals(subState)) {
        // updateWrapUpAuxCode(auxCodes, config);
        // }
        config.getStateChangeData().setAuxCodes(auxCodes);
        
        final String message = generateXmlUtil.updateAgentState(agentSessionId, true, channelType);

        LOGGER.info("{} Sending agent state update message: {}", agentSessionId, message);

        if (LOGGER.isDebugEnabled()) {
            final long endTime = System.currentTimeMillis() - startTime;
            LOGGER.debug("{} ===>> Finished update agent state : {}", agentSessionId, endTime);
        }
        return message;
    }

    /**
     * @param auxCodes
     * @param config
     */
    private void updateIdleAuxCode(final AuxCode[] auxCodes, final DesktopConfiguration config) {
        if (auxCodes == null) {
            lastIdleAuxCode = null;
        } else {
            for (final AuxCode aux : auxCodes) {
                if (aux != null && AuxCode.TYPE_IDLE.equals(aux.getType())) {
                    lastIdleAuxCode = aux;
                    config.setLastIdleAuxCode(aux);
                }
            }
        }
    }

    /**
     * @param auxCodes
     */
    // public void updateWrapUpAuxCode(final AuxCode[] auxCodes, final DesktopConfiguration config) {
    // for (int i = 0; auxCodes != null && i < auxCodes.length; i++) {
    // final AuxCode aux = auxCodes[i];
    // if (aux != null && AuxCode.TYPE_WRAPUP.equals(aux.getType())) {
    // lastWrapUpAuxCode = aux;
    // config.setLastWrapUpAuxCode(aux);
    // }
    // }
    // }

    public AuxCode getLastIdleAuxCode() {
        return lastIdleAuxCode;
    }

    public AuxCode getLastWrapUpAuxCode() {
        return lastWrapUpAuxCode;
    }

}
