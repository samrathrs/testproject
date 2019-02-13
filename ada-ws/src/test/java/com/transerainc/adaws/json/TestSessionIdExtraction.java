/**
 * 
 */
package com.transerainc.adaws.json;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.OmniChannelCommonConstants;
import com.transerainc.adaws.constants.OmniChannelCommonFrontendRequests;
import com.transerainc.adaws.service.OmniChannelUtilService;

/**
 * @author tnguyen
 *
 */
public class TestSessionIdExtraction {

	private static Logger LOGGER = LoggerFactory.getLogger(TestSessionIdExtraction.class.getName());

	private static final String MESSAGE_FROM_ICX_TO_ADA = 
			"{ \"action\":\"AcceptChatContact\", \"responseData\":{ \"sessionId\":\"ffdf836e000b001e0aee324fa0640000\", \"agentId\":11, \"omniChannelQueueId\":0 }, \"success\":true, \"message\":\"Success/Error message\" }";
	private static final String SESSION_ID = "ffdf836e000b001e0aee324fa0640000";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String sessionId = OmniChannelJsonUtil.extractSessionId(MESSAGE_FROM_ICX_TO_ADA);
		
		LOGGER.info( "Session Id from ICX to ADA FE: {}", sessionId );
		
		LOGGER.info( "Orig Msg to ADA FE: {}", MESSAGE_FROM_ICX_TO_ADA );
	}
	
	@Test
	public void testExtractedSessionId() {
            String sessionId = OmniChannelJsonUtil
                            .extractSessionId("{\"success\":false,\"action\":\"Logout\",\"responseData\":{\"agentId\":621,\"sessionId\":\"C25A59DB3E429F1772EC946929BC96BB\"},\"message\":\"Logout Failed.\"}");
            LOGGER.info("extracted session-id from response {} ", sessionId);

            sessionId = OmniChannelJsonUtil
                            .extractSessionIdFromMmResponse("{\"mmResponse\":{\"success\":false,\"action\":\"Logout\",\"responseData\":{\"agentId\":337,\"sessionId\":\"7024B9D65D5A577D508E7431C2D332D8\"},\"message\":\"Logout Failed.\"}}");
            LOGGER.info("extracted session-id from mmresponse {} ", sessionId);
    }

    @Test
     public void testInjectSessionIdAgentId() {
            String response = null;
            response = OmniChannelJsonUtil.injectBackendSessionIdAgentIdMessageIntoResponse(OmniChannelCommonConstants.LOGOUT_FAILED_RESPONSE1,
                                                    "123",
                                                    456,
                                                    "400 Bad Request");
            StringBuilder wrappedMessageStrBldr = OmniChannelUtilService.wrapResponseMessage(response);            
            LOGGER.info("testInjectSessionIdAgentId(): logout failed response {} : {}", response, wrappedMessageStrBldr);

            response = OmniChannelJsonUtil.injectBackendSessionIdAgentIdIntoResponse(OmniChannelCommonConstants.LOGIN_FAILED_RESPONSE1,
                            "123",
                            456);
            wrappedMessageStrBldr = OmniChannelUtilService.wrapResponseMessage(response);
            LOGGER.info("testInjectSessionIdAgentId(): login failed response {} : {}", response, wrappedMessageStrBldr);
    }

    @Test
    public void testLogoutMsg() {
            String request = null;
            request = OmniChannelJsonUtil.injectSessionAgentIdsIntoRequest(
                            SESSION_ID, 456, OmniChannelCommonFrontendRequests.AGENT_LOGOUT_REQUEST);
            LOGGER.info("injected session-id agent-id in logout request {} ", request);
    }
    
    @Test
    public void testXmlMsg() {
    		/*
    		final String responseString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
    			"<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:ns=\"urn:Xera\">\n" + 
    			"<SOAP-ENV:Body SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" id=\"_0\">\n" + 
    			"<SOAP-ENV:Fault>\n" + 
    			"<faultcode>SOAP-ENV:Client</faultcode>\n" + 
    			"<faultstring>HTTP Error: 'Not Found'</faultstring>\n" + 
    			"</SOAP-ENV:Fault></SOAP-ENV:Body>\n" + 
    			"</SOAP-ENV:Envelope>";
    		*/
    		final String responseString = null;
    			boolean isError = checkResponse(responseString);
    			if (isError) {
    				LOGGER.info("Error in responseString");
    			}
    }
    
    private boolean checkResponse(String resp) {
		SOAPMessage msg = null;
		SOAPBody body = null;
		SOAPFault fault = null;
		String  fcode = null;
		String fstr = null;
		
		try {
			msg = getSoapMessageFromString(resp);
			if (msg != null) {
				body = msg.getSOAPBody();
				
				if (body != null) {
					fault = body.getFault();
				
					if (fault != null) {
						fcode = fault.getFaultCode();
						fstr = fault.getFaultString();
						LOGGER.info("Error Authentication response fcode:{}, fstr:{}", fcode, fstr);
						return true;
					}
				}
			}
			LOGGER.info("No Error found in xml-- fcode:{}, fstr:{}",fcode, fstr);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
    }
    
    private SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
        MessageFactory factory = MessageFactory.newInstance();
        if (xml != null) {
        		SOAPMessage message = factory.createMessage(new MimeHeaders(), new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
        		return message;
        }
        return null;
    }

}
