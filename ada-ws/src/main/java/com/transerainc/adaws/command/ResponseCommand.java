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

import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.exception.InterpretationException;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.StationLoginToken;
import com.transerainc.adaws.model.TacgResponse;
import com.transerainc.aha.gen.agent.ResponseDocument.Response;

/**
 * @author rajeev.lochanam
 */
@Component
public class ResponseCommand {
    static Logger LOGGER = LoggerFactory.getLogger(ResponseCommand.class.getName());

    @Autowired
    private WebSocketCacheManager webSocketCacheManager;
    @Autowired
    private StationLoginToken stationlogintoken ;

    /**
     * @param tacgResp
     * @return
     * @throws InterpretationException
     */
    public AdaResponse processData(final TacgResponse tacgResp) throws InterpretationException {
        JSONObject jsonResponse = null;

        try {
            final Response response = tacgResp.getResponse();
            if (response != null) {
                jsonResponse = new JSONObject();
                final int code = response.getCode();
                if (code == 409) {
                	LOGGER.info("Coming  after checkKeyInProcList : {} ", stationlogintoken.getProcKeys().toString() +
            				" auth" + stationlogintoken.getauthKeyList());
                    jsonResponse.put(AdaConstants.CODE, String.valueOf(ContextConstants.ERROR_DUPLICATE_DN));
                    if(stationlogintoken.checkKeyInProcList(webSocketCacheManager.getToken(tacgResp.getAgentSessionId()))){
                		stationlogintoken.removeFromPocessingList(webSocketCacheManager.getToken(tacgResp.getAgentSessionId()));
                		stationlogintoken.removeKeyFromAuth(webSocketCacheManager.getToken(tacgResp.getAgentSessionId()));
                		stationlogintoken.setDupDn(webSocketCacheManager.getToken(tacgResp.getAgentSessionId()),true);
                	}
                }
                jsonResponse.put(AdaConstants.DETAIL, response.getReason());
            }
        } catch (final JSONException e) {
            LOGGER.error("Exception occured while forming json string on response command condition." + e);
        }

        if (null != jsonResponse) { return new AdaResponse(CommandConstants.ERROR_OCCURRED, jsonResponse.toString(),
                tacgResp.getAgentSessionId()); }

        LOGGER.warn("No valid elements to interpret");
        throw new InterpretationException("No valid elements to interpret");
    }

}
