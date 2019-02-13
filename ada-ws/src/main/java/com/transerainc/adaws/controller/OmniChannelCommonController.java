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
import com.transerainc.adaws.constants.OmniChannelCommonCommandConstants;
import com.transerainc.adaws.constants.OmniChannelCommonWebServiceConstants;
import com.transerainc.adaws.service.OmniChannelUtilService;


/**
 * @author tringuyen
 */
@Controller
public class OmniChannelCommonController {

	private static Logger LOGGER = LoggerFactory.getLogger(OmniChannelCommonController.class.getName());

    @Autowired
    private OmniChannelUtilService omniChannelUtilService;

    private void handleRequest(final HttpServletRequest request, 
    		final HttpServletResponse response,
    		String payloadData,
    		String jsMethod,
    		String mappedRequest) {
        LOGGER.debug("Received Common Request at: {}, " +
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

        LOGGER.debug("Finished processing Common Request at: {}, " +
        		"from ICX with message data: {}",
        		mappedRequest,
                payloadData);
    }

    @RequestMapping(value = OmniChannelCommonWebServiceConstants.CONTACT_TRANSFER_TO_QUEUE,
    		method = RequestMethod.POST, 
    		headers = HttpConstants.CONTENT_TYPE + MediaType.APPLICATION_JSON_VALUE, 
    		produces = { MediaType.APPLICATION_JSON_VALUE })
    public void handleContactTransferToQueueRequest(final HttpServletRequest request, final HttpServletResponse response,
                                @RequestBody(required = true) String payloadData) {
    	handleRequest(request, 
    			response, 
    			payloadData, 
    			OmniChannelCommonCommandConstants.CONTACT_TO_QUEUE_TRANSFERRED,
    			OmniChannelCommonWebServiceConstants.CONTACT_TRANSFER_TO_QUEUE);
    }
    
    @RequestMapping(value = OmniChannelCommonWebServiceConstants.CONTACT_TRANSFER_TO_AGENT,
    		method = RequestMethod.POST, 
    		headers = HttpConstants.CONTENT_TYPE + MediaType.APPLICATION_JSON_VALUE, 
    		produces = { MediaType.APPLICATION_JSON_VALUE })
    public void handleContactTransferToAgentRequest(final HttpServletRequest request, final HttpServletResponse response,
                                @RequestBody(required = true) String payloadData) {
    	handleRequest(request, 
    			response, 
    			payloadData, 
    			OmniChannelCommonCommandConstants.CONTACT_TO_AGENT_TRANSFERRED,
    			OmniChannelCommonWebServiceConstants.CONTACT_TRANSFER_TO_AGENT);
    }
    
    @RequestMapping(value = OmniChannelCommonWebServiceConstants.FETCH_TRANSFERABLE_AGENTS,
    		method = RequestMethod.POST, 
    		headers = HttpConstants.CONTENT_TYPE + MediaType.APPLICATION_JSON_VALUE, 
    		produces = { MediaType.APPLICATION_JSON_VALUE })
    public void handleFetchTransferableAgents(final HttpServletRequest request, final HttpServletResponse response,
                                @RequestBody(required = true) String payloadData) {
    	handleRequest(request, 
    			response, 
    			payloadData, 
    			OmniChannelCommonCommandConstants.TRANSFERABLE_AGENTS_FETCHED,
    			OmniChannelCommonWebServiceConstants.FETCH_TRANSFERABLE_AGENTS);
    }
    
    @RequestMapping(value = OmniChannelCommonWebServiceConstants.FETCH_TRANSFERABLE_QUEUES,
    		method = RequestMethod.POST, 
    		headers = HttpConstants.CONTENT_TYPE + MediaType.APPLICATION_JSON_VALUE, 
    		produces = { MediaType.APPLICATION_JSON_VALUE })
    public void handleFetchTransferableQueues(final HttpServletRequest request, final HttpServletResponse response,
                                @RequestBody(required = true) String payloadData) {
    	handleRequest(request, 
    			response, 
    			payloadData, 
    			OmniChannelCommonCommandConstants.TRANSFERABLE_QUEUES_FETCHED,
    			OmniChannelCommonWebServiceConstants.FETCH_TRANSFERABLE_QUEUES);
    }
    
    @RequestMapping(value = OmniChannelCommonWebServiceConstants.WRAPUP_CONTACT,
    		method = RequestMethod.POST, 
    		headers = HttpConstants.CONTENT_TYPE + MediaType.APPLICATION_JSON_VALUE, 
    		produces = { MediaType.APPLICATION_JSON_VALUE })
    public void handleWrapupRequest(final HttpServletRequest request, final HttpServletResponse response,
                                @RequestBody(required = true) String payloadData) {
    	handleRequest(request, 
    			response, 
    			payloadData, 
    			OmniChannelCommonCommandConstants.CONTACT_WRAPPED_UP,
    			OmniChannelCommonWebServiceConstants.WRAPUP_CONTACT);
    }

}
