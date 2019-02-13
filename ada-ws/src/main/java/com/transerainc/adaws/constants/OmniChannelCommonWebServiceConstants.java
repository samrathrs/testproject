/**
 * 
 */
package com.transerainc.adaws.constants;

/**
 * @author tringuyen
 *
 */
public interface OmniChannelCommonWebServiceConstants {
	final String BASE_OMNI_CHANNEL_URI = "/handleOmni";

	final String BASE_COMMON_URI = BASE_OMNI_CHANNEL_URI + 
			"/common";

	// Use Case of: "Contacts"
	final String CONTACT_TRANSFER_TO_QUEUE = BASE_COMMON_URI + 
    		"/contactTransferToQueue";
	
	final String CONTACT_TRANSFER_TO_AGENT = BASE_COMMON_URI + 
    		"/contactTransferToAgent";
	
	final String FETCH_TRANSFERABLE_AGENTS = BASE_COMMON_URI + 
    		"/fetchTransferableAgent";
	
	final String FETCH_TRANSFERABLE_QUEUES = BASE_COMMON_URI + 
    		"/fetchTransferableQueues";
	
	final String WRAPUP_CONTACT = BASE_COMMON_URI +
			"/wrapUpContact";

}
