/**
 * 
 */
package com.transerainc.adaws.command;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.exception.InterpretationException;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.Channel;
import com.transerainc.adaws.model.ChannelSet;
import com.transerainc.adaws.model.TacgResponse;

/**
 * @author rajeev.lochanam
 */
@Component
public class ChannelSetCommand {
    static Logger LOGGER = LoggerFactory.getLogger(ChannelSetCommand.class.getName());

    @Autowired
    private DesktopConfigManager config;

    /**
     * @param tacgResp
     * @return
     * @throws InterpretationException
     * @throws JSONException
     */
    public AdaResponse processData(final TacgResponse tacgResp) throws InterpretationException, JSONException {
        createChannelSetCommand(tacgResp);

        // This is just to update the config object. Nothing to return to UI layer
        return null;
    }

    /**
     * @param tacgResp
     */
    private AdaResponse createChannelSetCommand(final TacgResponse tacgResp) {
        long startTime = 0;
        if (LOGGER.isDebugEnabled()) {
            startTime = System.currentTimeMillis();
            LOGGER.debug("===>> Starting create channel set command : " + startTime);
        }

        final String agentSessionId = tacgResp.getAgentSessionId();
        JSONObject jsonResp = new JSONObject();
        LOGGER.info("Parsing channelset message");
        final ChannelSet channelSet = new ChannelSet();
        if (tacgResp.getChannelSet() != null) {
            if (tacgResp.getChannelSet().getChannelArray() != null
                    && tacgResp.getChannelSet().getChannelArray().length > 0) {
                for (final com.transerainc.agent.profile.ChannelSetDocument.ChannelSet.Channel channel : tacgResp
                        .getChannelSet().getChannelArray()) {
                    final String id = channel.getId();
                    final String type = channel.getType() != null ? channel.getType().toString() : "";
                    config.getConfigForAgent(agentSessionId).setChannelId(type, id);
                //    config.getConfigForAgent(agentSessionId).setChannelInfo(id, type);
                    try {
                        jsonResp.put(id, type);
                    } catch (Exception e) {
                    	LOGGER.error(
                    			"Error putting into JSON Response: {}, with id: {}, type: {}",
                    			jsonResp,
                    			id,
                    			type
                    			);
                    }
                    LOGGER.info("Added " + type + " channel with id : " + id);
                    channelSet.addChannel(new Channel(id, type));
                }
            }
        }

        // channelSetUpdated(channelSet);
        if (LOGGER.isDebugEnabled()) {
            final long endTime = System.currentTimeMillis() - startTime;
            LOGGER.debug("===>> Finished create channel set command : " + endTime);
        }
        if(jsonResp !=null){
        	return new AdaResponse(CommandConstants.CHANNEL_SET,jsonResp.toString(),tacgResp.getAgentSessionId());
        }
		return null;
    }
}
