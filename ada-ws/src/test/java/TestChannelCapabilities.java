import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.OmniChannelCommonConstants;
import com.transerainc.adaws.json.OmniChannelJsonUtil;

/**
 * 
 */

/**
 * @author jnarain
 *
 */
public class TestChannelCapabilities {

	private static Logger LOGGER = LoggerFactory.getLogger(TestChannelCapabilities.class.getName());
	private static final int CHAT_ID = 1;
	private static final int EMAIL_ID = 2;
	private static final int TELE_ID = 3;
	private static final String MESSAGE_FROM_ICX_TO_ADA = 
			"{\"id\": \"56\",\"name\": \"Open_T1C1E1\",\"mmpId\": \"507\",\"chatChannels\": 1,\"emailChannels\": 2,\"teleChannels\": 3,\"chatUrl\": \"http://idc-dev-icrm01.dev.blr.broadsoft.com:41060/web-gateway/webresources/user/login\",\"emailUrl\": \"http://idc-dev-icrm01.dev.blr.broadsoft.com:41060/web-gateway/webresources/user/login\",\"casEnabled\": false}";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		try {
			int chatChannels = OmniChannelJsonUtil.extractChannelId(MESSAGE_FROM_ICX_TO_ADA, OmniChannelCommonConstants.CHAT_CHANNEL_KEY);		
			int emailChannels = OmniChannelJsonUtil.extractChannelId(MESSAGE_FROM_ICX_TO_ADA, OmniChannelCommonConstants.EMAIL_CHANNEL_KEY);		
			int teleChannels = OmniChannelJsonUtil.extractChannelId(MESSAGE_FROM_ICX_TO_ADA, OmniChannelCommonConstants.TELE_CHANNEL_KEY);
			
			LOGGER.info( "Orig Msg to ADA FE: {}", MESSAGE_FROM_ICX_TO_ADA );
			LOGGER.info( "chatCh: {}, emailCh: {}, teleCh: {}", chatChannels, emailChannels, teleChannels);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testExtractedSessionId() throws JSONException {
		try {
			int chatChannels = OmniChannelJsonUtil.extractChannelId(MESSAGE_FROM_ICX_TO_ADA, OmniChannelCommonConstants.CHAT_CHANNEL_KEY);
			int emailChannels = OmniChannelJsonUtil.extractChannelId(MESSAGE_FROM_ICX_TO_ADA, OmniChannelCommonConstants.EMAIL_CHANNEL_KEY);
			int teleChannels = OmniChannelJsonUtil.extractChannelId(MESSAGE_FROM_ICX_TO_ADA, OmniChannelCommonConstants.TELE_CHANNEL_KEY);
			Assert.assertTrue("Proper Channels should be extracted.", CHAT_ID == chatChannels && TELE_ID == teleChannels && EMAIL_ID == emailChannels);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
