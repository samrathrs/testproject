/**
 * 
 */

import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.connection.HttpUtil;

/**
 * @author jnarain
 *
 */
public class PostRequestToWatson {
	private static Logger LOGGER = LoggerFactory.getLogger(PostRequestToWatson.class.getName());
	
	private static final String WATSON_URL = "https://gateway.watsonplatform.net/tone-analyzer/api/v3/tone?version=2016-05-19";
	
	private static final String AUTH = "2ca45c54-ee49-4745-a5f9-e25d5b097a1c:IW0PwW4MPoOp";
	private static byte[] authEncBytes = Base64.encodeBase64(AUTH.getBytes());
	private static String authStringEnc = new String(authEncBytes);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws JSONException {		
		String body = "{\"text\": \"Too bad, you could not fix my problem today.\"}";
		String response = HttpUtil.doHttpJsonPostAuth(WATSON_URL, body, "Basic " + authStringEnc);
		LOGGER.info( "Response from Watson: {}", response );
	}
	
	@Test
	public void testPostRequestToWatson() throws JSONException {
		String body = "{\"text\": \"Thank you for helping out today.\"}";
		try {
		String response = HttpUtil.doHttpJsonPostAuth(WATSON_URL, body, "Basic " + authStringEnc);
		LOGGER.info( "Response from Watson: {}", response );
		Assert.assertNotNull("Response from Watson should not be null", response);
		} catch (Exception e ) {
			Assert.fail("Failed to POST request to Watson: " + WATSON_URL + e.toString() );
		}
	}

}
