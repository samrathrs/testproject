/**
 * 
 */
package com.transerainc.adaws.constants;

/**
 * @author jnarain
 *
 */
public interface OmniChannelEmailWebServiceConstants {
	final String BASE_EMAIL_URI = OmniChannelCommonWebServiceConstants.BASE_OMNI_CHANNEL_URI + 
			"/email";

	// Use Case of: "Contact Arrival"
	final String EMAIL_CONTACT_ARRIVED = BASE_EMAIL_URI + 
    		"/contactArrival";
	final String EMAIL_CONTACT_ARRIVAL_FOLLOWUP = BASE_EMAIL_URI + 
    		"/contactArrivalFollowup";

	// Use Case of: "Accept Email Contact"
	final String EMAIL_CONTACT_ACCEPTED = BASE_EMAIL_URI + 
    		"/contactAccepted";
	
	// Use Case of: "Fetch Email Body"
	final String EMAIL_BODY_FETCHED = BASE_EMAIL_URI + 
    		"/bodyFetched";
	
	// Use Case of: "Add Email Attachment"
	final String EMAIL_ATTACHMENT_ADDED = BASE_EMAIL_URI + 
    		"/attachmentAdded";
	
	// Use Case of: "Remove Email Attachment"
	final String EMAIL_ATTACHMENT_REMOVED = BASE_EMAIL_URI + 
    		"/attachmentRemoved";
	
	// Use Case of: "Delete Temp Attachment"
	final String TEMP_ATTACHMENT_DELETED = BASE_EMAIL_URI + 
    		"/tempAttachmentDeleted";
	
	// Use Case of: "Send Plain Text Email"
	final String PLAIN_TEXT_EMAIL_SENT = BASE_EMAIL_URI + 
    		"/plainEmailSent";
	
	// Use Case of: "Send Rich Text Email"
	final String RICH_TEXT_EMAIL_SENT = BASE_EMAIL_URI + 
    		"/richEmailSent";
	
	// Use Case of: "Compose Email"
	final String OUTBOUND_EMAIL_INITIATED = BASE_EMAIL_URI + 
    		"/composeEmail";
	
	// Use Case of: "Accept Outbound Email Contact"
	final String OUTBOUND_EMAIL_CONTACT_ACCEPTED = BASE_EMAIL_URI + 
	    	"/outboundContactAccepted";
		
	// Use Case of: "Send Email"
	final String COMPOSED_EMAIL_SENT = BASE_EMAIL_URI + 
	    	"/sendEmail";
		
	// Use Case of: "Save Email Draft"
    final String EMAIL_DRAFT_SAVED = BASE_EMAIL_URI + 
	    	"/draftSaved";
	
    // Use Case of: "Fetch Email Draft"
    final String EMAIL_DRAFT_FETCHED = BASE_EMAIL_URI + 
	    	"/draftFetched";
    
    // Use Case of: "Activate Email Draft"
    final String EMAIL_DRAFT_ACTIVATED = BASE_EMAIL_URI + 
	    	"/draftActivated";
    
    // Use Case of: "Accepted Drafted Email Contact"
    final String DRAFTED_EMAIL_CONTACT_ACCEPTED = BASE_EMAIL_URI + 
	    	"/draftContactAccepted";
    		
    // Use Case of: "Delete Email Draft"		
    final String EMAIL_DRAFT_DELETED = BASE_EMAIL_URI + 
	    	"/draftDeleted";
    
}





















