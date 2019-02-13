/**
 * 
 */
package com.transerainc.adaws.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author jnarain
 *
 */
public class TestMessageTypeExtraction {

	private static Logger LOGGER = LoggerFactory.getLogger(TestMessageTypeExtraction.class.getName());
	
	private static final String MESSAGE_FROM_ICX_TO_ADA = 
			"{ \"action\": \"AgentStateChange\", \"responseData\": { \"sessionId\": \"081b5205-1f42-4a66-8fcf-d13360fabb6d\", \"agentId\": 14 }, \"success\": true, \"message\": \"Success/Error message\"}";
	private static final String MESSAGE_TO_ICX =
			"{\"action\":\"ContactCompletedRequest\",\"callbackUrl\":\"http://ace006.dev.broadcloudcc.com:9400/ada-ws/handleOmni\",\"requestData\":{\"cduId\":\"ffe06cc703510306ac1f019b270c0000\",\"sessionId\":\"34907B2FA3CD70D01F96C548726753E6\",\"tenantId\":10571,\"agentId\":337,\"persistentCallbackUrl\":\"http://ace006.dev.broadcloudcc.com:9400/ada-ws/handleOmni\",\"outboundId\":0,\"answerTime\":0,\"currentQueue\":{\"omniChannelQueueId\":4,\"channelId\":3},\"isReminderSet\":false,\"wrapupDetail\":{\"comment\":\"\",\"conversationStatus\":4,\"emotionTone\":0,\"urgencyTone\":0,\"category\":{\"id\":0,\"code\":\"-- Select Wrap up reason --\"}},\"followUp\":{}}}";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final String msgT = OmniChannelJsonUtil.extractMessageType(MESSAGE_FROM_ICX_TO_ADA);
		
		LOGGER.info( "Message Type from ICX to ADA FE: {}", msgT );
		
		LOGGER.info( "Orig Msg to ADA FE: {}", MESSAGE_FROM_ICX_TO_ADA );
		
		final String msgT2 = OmniChannelJsonUtil.extractMessageType(MESSAGE_TO_ICX);
		
		LOGGER.info( "Message Type from ICX to ADA FE: {}", msgT2 );
		
		LOGGER.info( "Orig Msg to ADA FE: {}", MESSAGE_TO_ICX );
		
	}

}

