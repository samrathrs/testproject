package com.transerainc.adaws.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.transerainc.adaws.constants.HttpConstants;
import com.transerainc.adaws.constants.OmniChannelEmailCommandConstants;
import com.transerainc.adaws.constants.OmniChannelEmailWebServiceConstants;
import com.transerainc.adaws.service.OmniChannelUtilService;


/**
 * @author jnarain
 *
 */

@Controller
public class OmniChannelEmailController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(OmniChannelEmailController.class.getName());

	@Autowired
	private OmniChannelUtilService omniChannelUtilService;

	private void handleRequest( final HttpServletRequest request, 
								final HttpServletResponse response,
								final String payloadData,
								final String jsMethod,
								final String mappedRequest) {
		LOGGER.debug("Received Email Request at: {}, " +
				"from ICX with message data: {}",
				mappedRequest,
				payloadData);

		omniChannelUtilService.handleRequest(
												request, 
												response, 
												payloadData, 
												jsMethod, 
												mappedRequest
											);

		LOGGER.debug("Finished processing Email Request at: {}, from ICX with message data: {}",
					mappedRequest,
					payloadData);
	}

	// handling the EventCallbacks for email

	@RequestMapping(value = OmniChannelEmailWebServiceConstants.EMAIL_CONTACT_ARRIVED, 
			method = RequestMethod.POST, 
			headers = HttpConstants.CONTENT_TYPE + MediaType.APPLICATION_JSON_VALUE, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public void handleEmailContactArrivalRequest(final HttpServletRequest request, final HttpServletResponse response,
								@RequestBody(required = true) final String payloadData) {
			handleRequest(
							request, 
							response, 
							payloadData, 
							OmniChannelEmailCommandConstants.EMAIL_CONTACT_ARRIVAL, 
							OmniChannelEmailWebServiceConstants.EMAIL_CONTACT_ARRIVED
						);
	}
	
	@RequestMapping(value = OmniChannelEmailWebServiceConstants.EMAIL_CONTACT_ARRIVAL_FOLLOWUP, 
			method = RequestMethod.POST, 
			headers = HttpConstants.CONTENT_TYPE + MediaType.APPLICATION_JSON_VALUE, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public void handleEmailContactArrivalFollowupRequest(final HttpServletRequest request, final HttpServletResponse response,
								@RequestBody(required = true) final String payloadData) {
		handleRequest(
						request, 
						response, 
						payloadData, 
						OmniChannelEmailCommandConstants.EMAIL_CONTACT_ARRIVAL_FOLLOWUP, 
						OmniChannelEmailWebServiceConstants.EMAIL_CONTACT_ARRIVAL_FOLLOWUP
					);
	}

}
