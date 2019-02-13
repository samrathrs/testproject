/**
 * 
 */
package com.transerainc.adaws.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.transerainc.adaws.cache.WebSocketCacheManager;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.OmniChannelEmailCommandConstants;
import com.transerainc.adaws.model.AdaRequest;
import com.transerainc.adaws.model.MmRequest;
import com.transerainc.adaws.service.OmniChannelEmailService;
import com.transerainc.adaws.service.OmniChannelUtilService;

/**
 * @author tringuyen
 *
 */
@Controller
public class EmailAttachmentController {

	private static Logger LOGGER = LoggerFactory
			.getLogger(EmailAttachmentController.class.getName());

	private static final Gson GSON = new Gson();

    private static final String DATA_KEY = "data";

	private static final String ATTACHMENT_KEY = "attachment";

	private static final String EMAIL_CONVERSATION_MAPPING_KEY = "/emailConversation";

	@Value("${ada.omnichannel.callback.url}")
	private String adaCallbackUrl;

	@Autowired
	protected DesktopConfigManager agentDesktopConfigMap;

	@Autowired
	private WebSocketCacheManager webSocketCacheManager;
	
	@Autowired
	OmniChannelEmailService emailService;
	
	@Autowired
	OmniChannelUtilService omniChannelUtilService;
	
	@RequestMapping(value = "/emailAttachment", method = RequestMethod.POST, 
			consumes = {MediaType.MULTIPART_FORM_DATA_VALUE })
	@ResponseBody
	public String handleAddEmailAttachment(@RequestParam("data") String data,
			@RequestParam("attachment") MultipartFile[] attachment) {
		String response = null;
		try {
			MmRequest mmrequest = GSON.fromJson(data, MmRequest.class);
			if (mmrequest == null) {
				throw new IllegalArgumentException("Request could not be parsed");
			}
			LOGGER.info("Received Add Email Attachment request.",
					mmrequest.toString());
			String token = mmrequest.getRequestData().getSessionId();
			String backendSessionId = webSocketCacheManager.getAgent(token);
			
			if (token != null)
				mmrequest.getRequestData()
						.setSessionId(backendSessionId);
			JSONObject reqAttr = new JSONObject();
			reqAttr.put("sessionId", mmrequest.getRequestData().getSessionId());
			reqAttr.put("cduId", mmrequest.getRequestData().getCduId());
			JSONObject reqData = new JSONObject();
			reqData.put("requestData", reqAttr);
			reqData.put("action", "AddAttachment");

			LOGGER.info("JSON Data part: {}", reqData);
			if ((attachment == null) || (attachment.length == 0)) {
				return "{}";
			}
			for (int idx = 0; idx < attachment.length; idx++) {
				try {
					LOGGER.info(
							"Received Add Email Attachment request for name: {}, "
									+ "with filename: {}, " + "with file size: {}",
							attachment[idx].getName(),
							attachment[idx].getOriginalFilename(),
							attachment[idx].getSize());
					StringBuilder builder = new StringBuilder();
					byte[] fileAttachmentContents = attachment[idx].getBytes();
					for (int cntIdx = 0; (fileAttachmentContents != null)
							&& (fileAttachmentContents.length > 0)
							&& (cntIdx < fileAttachmentContents.length); cntIdx++) {
						builder.append(fileAttachmentContents[cntIdx]);
					}
					// LOGGER.debug("File contents: {}", builder.toString());
				} catch (IOException e) {
					LOGGER.error("Exception logging file attachment: {}, "
							+ "with name: {}, " + "with original filename: {}", idx,
							attachment[idx].getName(),
							attachment[idx].getOriginalFilename());
				}
			}

			final String omniChannelFileuploadUrl = omniChannelUtilService
					.getMimUrl(backendSessionId, OmniChannelEmailCommandConstants.ADD_EMAIL_ATTACHMENT);
			LOGGER.info("handleAddEmailAttachment(): omniChannelFileuploadUrl: {}", omniChannelFileuploadUrl);
			
			try {
				response = doHttpMultipartPost(omniChannelFileuploadUrl,
						reqData.toString(), attachment);
				
				LOGGER.info("handleAddEmailAttachment(): reqData.toString(): {}", reqData.toString());
				
			} catch (final HttpServerErrorException hse) {
				LOGGER.error("handleAddEmailAttachment(): Exception: {}", hse.getMessage());
				omniChannelUtilService.reportError(hse, backendSessionId);
				response = "{}";
				
			} catch (final ResourceAccessException rae) {
				LOGGER.error("handleAddEmailAttachment(): Exception: {}", rae.getCause());
				omniChannelUtilService.reportError(rae, backendSessionId);
				response = "{}";
				
			} catch (final HttpClientErrorException hce) {
				LOGGER.error("handleAddEmailAttachment(): Exception: {}", hce.getMessage());
				omniChannelUtilService.reportError(hce, backendSessionId);
				response = "{}";
				
			} catch (IOException transmissionException) {
				LOGGER.error(
						"Error sending Multipart Data to ICX with exception: {}, "
								+ "omniChannelUrl: {}, " + "requestToIcx: {}",
						transmissionException, omniChannelFileuploadUrl, data);
				response = "{}";
				
			} catch (Exception exception) {	
				LOGGER.error("handleAddEmailAttachment(): Exception: {}", exception.getMessage());
				
				omniChannelUtilService.reportError(OmniChannelEmailCommandConstants.ADD_EMAIL_ATTACHMENT, 
						backendSessionId, 0L, "AddAttachment");
				response = "{}";
			} 
		} catch (Exception exception) {
			LOGGER.error("Error handling email attachment data: {}, with exception: {}",
					data,
					exception.toString());
		}
		LOGGER.info("Add Attachment POST response: {}", response);
		return response;
	}

	private String doHttpMultipartPost(final String url, final String jsonData,
			final MultipartFile[] attachmentFiles) throws IOException {
		String response = null;
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		String attachFileName;
		for (MultipartFile file : attachmentFiles) {
			attachFileName = file.getOriginalFilename();
			// COV 11942 - whitelist the file name
			attachFileName = attachFileName.replaceAll("[^A-Za-z0-9_\\-\\.]", "")
					.replaceAll("[\\.]+", ".");
			try (FileOutputStream fo = new FileOutputStream(attachFileName)) {
				fo.write(file.getBytes());
				fo.flush();
			}
			map.add(DATA_KEY, jsonData);
			map.add(ATTACHMENT_KEY, new FileSystemResource(attachFileName));

			HttpHeaders headers = new HttpHeaders();			
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);
			
			HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(
					map, headers);
			
			RestTemplate restTemplate = new RestTemplate();
			response = restTemplate.postForObject(url, requestEntity,
					String.class);
		}

		return response;
	}
	
	@RequestMapping(value = "/sendRichTextEmail", method = RequestMethod.POST)
	@ResponseBody
	public String handleSendRichTextEmail(final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		
		String response = null;
		
		LOGGER.info("Received: sendRichTextEmail request from UI");
		LOGGER.debug("Received: sendRichTextEmail request from UI: {}", req);
		
		final String bodyPayloadData = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		LOGGER.debug("/sendRichTextEmail : Raw body payload data: {}", bodyPayloadData);
		
		try {
			AdaRequest adaRequest = GSON.fromJson(bodyPayloadData, AdaRequest.class);
			
			final String agentToken = adaRequest.getagentSessionId();
			final String backendAgentSessionId = webSocketCacheManager.getAgent(agentToken);
			LOGGER.info("sendFollowUpEmail: FE agent web token: {}, backendSessionId:{}", agentToken, backendAgentSessionId);
	
			adaRequest.setagentSessionId(backendAgentSessionId);
			
			LOGGER.debug("Received: sendRichTextEmail request from UI: {}", adaRequest);
			final String omniChannelUrl = omniChannelUtilService.getMimUrl(adaRequest.getagentSessionId());
			response = omniChannelUtilService.processAndPostAdaRequestToIcx(
					adaRequest, 
					OmniChannelEmailCommandConstants.RICH_TEXT_EMAIL_SENT,
					adaCallbackUrl,
					omniChannelUrl,
					res);

		} catch (Exception e) {
			LOGGER.error("Error handling sendRichTextEmail data: {}, with exception: {}",
					req,
					e.toString());
		}	
		return response;
	}
	
	@RequestMapping(value = "/sendRichTextEmailOutbound", method = RequestMethod.POST)
	@ResponseBody
	public String handleSendRichTextEmailOutbound(final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		
		String response = null;
		
		LOGGER.info("Received: sendRichTextEmailOutbound request from UI");
		LOGGER.debug("Received: sendRichTextEmailOutbound request from UI: {}", req);
		
		final String bodyPayloadData = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		LOGGER.debug("/sendRichTextEmailOutbound : Raw body payload data: {}", bodyPayloadData);
		
		try {
			AdaRequest adaRequest = GSON.fromJson(bodyPayloadData, AdaRequest.class);
			
			final String agentToken = adaRequest.getagentSessionId();
			final String backendAgentSessionId = webSocketCacheManager.getAgent(agentToken);
			LOGGER.info("sendFollowUpEmail: FE agent web token: {}, backendSessionId:{}", agentToken, backendAgentSessionId);
	
			adaRequest.setagentSessionId(backendAgentSessionId);
			
			LOGGER.debug("Received: sendRichTextEmailOutbound request from UI: {}", adaRequest);
			final String omniChannelUrl = omniChannelUtilService.getMimUrl(adaRequest.getagentSessionId());

			response = omniChannelUtilService.processAndPostAdaRequestToIcx(
					adaRequest, 
					OmniChannelEmailCommandConstants.COMPOSED_EMAIL_SENT,
					adaCallbackUrl,
					omniChannelUrl,
					res);

		} catch (Exception e) {
			LOGGER.error("Error handling sendRichTextEmailOutbound data: {}, with exception: {}",
					req,
					e.toString());
		}	
		return response;
	}

	@RequestMapping(value = "/correctDisapprovedEmail", method = RequestMethod.POST)
	@ResponseBody
	public String handleCorrectDisapprovedEmail(final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		
		String response = null;
		
		LOGGER.info("Received: correctDisapprovedEmail request from UI");
		LOGGER.debug("Received: correctDisapprovedEmail request from UI: {}", req);
		
		final String bodyPayloadData = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		LOGGER.debug("/correctDisapprovedEmail : Raw body payload data: {}", bodyPayloadData);
		
		try {
			AdaRequest adaRequest = GSON.fromJson(bodyPayloadData, AdaRequest.class);
			
			final String agentToken = adaRequest.getagentSessionId();
			final String backendAgentSessionId = webSocketCacheManager.getAgent(agentToken);
			LOGGER.info("sendFollowUpEmail: FE agent web token: {}, backendSessionId:{}", agentToken, backendAgentSessionId);
	
			adaRequest.setagentSessionId(backendAgentSessionId);
			
			LOGGER.debug("Received: correctDisapprovedEmail request from UI: {}", adaRequest);
			final String omniChannelUrl = omniChannelUtilService.getMimUrl(adaRequest.getagentSessionId());
			response = omniChannelUtilService.processAndPostAdaRequestToIcx(
					adaRequest, 
					OmniChannelEmailCommandConstants.SENDING_CORRECT_DISAPPROVED_EMAIL,
					adaCallbackUrl,
					omniChannelUrl,
					res);

		} catch (Exception e) {
			LOGGER.error("Error handling correctDisapprovedEmail data: {}, with exception: {}",
					req,
					e.toString());
		}	
		return response;
	}
	
	@RequestMapping(value = "/saveEmailDraft", method = RequestMethod.POST)
	@ResponseBody
	public String handleSaveEmailDraft(final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		
		String response = null;
		
		LOGGER.info("Received: saveEmailDraft request from UI");
		LOGGER.debug("Received: saveEmailDraft request from UI: {}", req);
		
		final String bodyPayloadData = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		LOGGER.debug("/saveEmailDraft : Raw body payload data: {}", bodyPayloadData);
		
		try {
			AdaRequest adaRequest = GSON.fromJson(bodyPayloadData, AdaRequest.class);
			
			final String agentToken = adaRequest.getagentSessionId();
			final String backendAgentSessionId = webSocketCacheManager.getAgent(agentToken);
			LOGGER.info("sendFollowUpEmail: FE agent web token: {}, backendSessionId:{}", agentToken, backendAgentSessionId);
			
			adaRequest.setagentSessionId(backendAgentSessionId);
			
			LOGGER.debug("Received: saveEmailDraft request from UI: {}", adaRequest);
			final String omniChannelUrl = omniChannelUtilService.getMimUrl(adaRequest.getagentSessionId());
			response = omniChannelUtilService.processAndPostAdaRequestToIcx(
					adaRequest, 
					OmniChannelEmailCommandConstants.EMAIL_DRAFT_SAVED,
					adaCallbackUrl,
					omniChannelUrl,
					res);

		} catch (Exception e) {
			LOGGER.error("Error handling saveEmailDraft data: {}, with exception: {}",
					req,
					e.toString());
		}	
		return response;
	}
	
	@RequestMapping(value = "/sendFollowUpEmail", method = RequestMethod.POST)
	@ResponseBody
	public String handleSendFollowUpEmail(final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		
		String response = null;
		
		LOGGER.info("Received: sendFollowUpEmail request from UI");
		LOGGER.debug("Received: sendFollowUpEmail request from UI: {}", req);
		
		final String bodyPayloadData = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		LOGGER.debug("sendFollowUpEmail : Raw body payload data: {}", bodyPayloadData);
		
		try {
			AdaRequest adaRequest = GSON.fromJson(bodyPayloadData, AdaRequest.class);
			
			final String agentToken = adaRequest.getagentSessionId();
			final String backendAgentSessionId = webSocketCacheManager.getAgent(agentToken);
			LOGGER.info("sendFollowUpEmail: FE agent web token: {}, backendSessionId:{}", agentToken, backendAgentSessionId);
	
			adaRequest.setagentSessionId(backendAgentSessionId);
			
			LOGGER.debug("Received: sendFollowUpEmail request from UI: {}", adaRequest);
			final String omniChannelUrl = omniChannelUtilService.getMimUrl(adaRequest.getagentSessionId());
			response = omniChannelUtilService.processAndPostAdaRequestToIcx(
					adaRequest, 
					OmniChannelEmailCommandConstants.FOLLOW_UP_EMAIL_SENT,
					adaCallbackUrl,
					omniChannelUrl,
					res);

		} catch (Exception e) {
			LOGGER.error("Error handling sendFollowUpEmail data: {}, with exception: {}",
					req,
					e.toString());
		}	
		return response;
	}

	@RequestMapping(
			value = EMAIL_CONVERSATION_MAPPING_KEY, 
			method = RequestMethod.POST,
			produces = "text/plain;charset=utf-8"
			)
	@ResponseBody
	public String handleEmailConversation(final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		
		String response = null;
		
		LOGGER.info("Received: emailConversation request from UI");
		LOGGER.debug("Received: emailConversation request from UI: {}", req);
		
		final String bodyPayloadData = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		LOGGER.debug("/emailConversation : Raw body payload data: {}", bodyPayloadData);
		
		try {
			AdaRequest adaRequest = GSON.fromJson(bodyPayloadData, AdaRequest.class);
			
			final String agentToken = adaRequest.getagentSessionId();
			final String backendAgentSessionId = webSocketCacheManager.getAgent(agentToken);
			LOGGER.info("emailConversation: FE agent web token: {}, backendSessionId:{}", agentToken, backendAgentSessionId);
			
			adaRequest.setagentSessionId(backendAgentSessionId);
			
			LOGGER.debug("Received: emailConversation request from UI: {}", adaRequest);
			final String omniChannelUrl = omniChannelUtilService.getMimUrl(adaRequest.getagentSessionId());
			response = omniChannelUtilService.processAndPostAdaRequestToIcx(
					adaRequest, 
					OmniChannelEmailCommandConstants.EMAIL_CONVERSATION_FETCHED,
					adaCallbackUrl,
					omniChannelUrl,
					res);
		} catch (Exception e) {
			LOGGER.error("Error handling emailConversation data: {}, with exception: {}",
					req,
					e.toString());
		}	
		return response;
	}
	
	@RequestMapping(value = "/getEmailBody", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String handleFetchEmailDetails(final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		
		String response = null;
		
		LOGGER.info("Received: getEmailBody request from UI");
		LOGGER.debug("Received: getEmailBody request from UI: {}", req);
		
		final String bodyPayloadData = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		LOGGER.debug("/getEmailBody : Raw body payload data: {}", bodyPayloadData);
		
		try {
			AdaRequest adaRequest = GSON.fromJson(bodyPayloadData, AdaRequest.class);
			
			final String agentToken = adaRequest.getagentSessionId();
			final String backendAgentSessionId = webSocketCacheManager.getAgent(agentToken);
			LOGGER.info("getEmailBody: FE agent web token: {}, backendSessionId:{}", agentToken, backendAgentSessionId);
	
			adaRequest.setagentSessionId(backendAgentSessionId);
			
			LOGGER.debug("Received: getEmailBody request from UI: {}", adaRequest);
			final String omniChannelUrl = omniChannelUtilService.getMimUrl(adaRequest.getagentSessionId());
			response = omniChannelUtilService.processAndPostAdaRequestToIcx(
					adaRequest, 
					OmniChannelEmailCommandConstants.EMAIL_BODY_FETCHED,
					adaCallbackUrl,
					omniChannelUrl,
					res);

		} catch (Exception e) {
			LOGGER.error("Error handling getEmailBody data: {}, with exception: {}",
					req,
					e.toString());
		}	
		return response;
	}

	@RequestMapping(value = "/fetchEmailDraft", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String handleFetchEmailDrafts(final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		
		String response = null;
		
		LOGGER.info("Received: fetchEmailDraft request from UI");
		LOGGER.debug("Received: fetchEmailDraft request from UI: {}", req);
		
		final String bodyPayloadData = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		LOGGER.debug("/fetchEmailDraft : Raw body payload data: {}", bodyPayloadData);
		
		try {
			AdaRequest adaRequest = GSON.fromJson(bodyPayloadData, AdaRequest.class);
			
			final String agentToken = adaRequest.getagentSessionId();
			final String backendAgentSessionId = webSocketCacheManager.getAgent(agentToken);
			LOGGER.info("fetchEmailDraft: FE agent web token: {}, backendSessionId:{}", agentToken, backendAgentSessionId);
	
			adaRequest.setagentSessionId(backendAgentSessionId);
			
			LOGGER.debug("Received: fetchEmailDraft request from UI: {}", adaRequest);
			final String omniChannelUrl = omniChannelUtilService.getMimUrl(adaRequest.getagentSessionId());
			response = omniChannelUtilService.processAndPostAdaRequestToIcx(
					adaRequest, 
					OmniChannelEmailCommandConstants.EMAIL_DRAFT_FETCHED,
					adaCallbackUrl,
					omniChannelUrl,
					res);

		} catch (Exception e) {
			LOGGER.error("Error handling fetchEmailDraft data: {}, with exception: {}",
					req,
					e.toString());
		}	
		return response;
	}
	
	@RequestMapping(value = "/sendEmailPlainText", method = RequestMethod.POST)
	@ResponseBody
	public String handleSendPlainTextEmail(final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		
		String response = null;
		
		LOGGER.info("Received: sendEmailPlainText request from UI");
		LOGGER.debug("Received: sendEmailPlainText request from UI: {}", req);
		
		final String bodyPayloadData = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		LOGGER.debug("/sendEmailPlainText : Raw body payload data: {}", bodyPayloadData);
		
		try {
			AdaRequest adaRequest = GSON.fromJson(bodyPayloadData, AdaRequest.class);
			
			final String agentToken = adaRequest.getagentSessionId();
			final String backendAgentSessionId = webSocketCacheManager.getAgent(agentToken);
			LOGGER.info("sendEmailPlainText: FE agent web token: {}, backendSessionId:{}", agentToken, backendAgentSessionId);
	
			adaRequest.setagentSessionId(backendAgentSessionId);
			
			LOGGER.debug("Received: sendEmailPlainText request from UI: {}", adaRequest);
			final String omniChannelUrl = omniChannelUtilService.getMimUrl(adaRequest.getagentSessionId());
			response = omniChannelUtilService.processAndPostAdaRequestToIcx(
					adaRequest, 
					OmniChannelEmailCommandConstants.PLAIN_TEXT_EMAIL_SENT,
					adaCallbackUrl,
					omniChannelUrl,
					res);

		} catch (Exception e) {
			LOGGER.error("Error handling sendEmailPlainText data: {}, with exception: {}",
					req,
					e.toString());
		}	
		return response;
	}
	
	@RequestMapping(value = "/followUpContactHistory", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String handleFollowUpContactHistory(final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		
		String response = null;
		
		LOGGER.info("Received: followUpContactHistory request from UI");
		LOGGER.debug("Received: followUpContactHistory request from UI: {}", req);
		
		final String bodyPayloadData = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		LOGGER.debug("/followUpContactHistory : Raw body payload data: {}", bodyPayloadData);
		
		try {
			AdaRequest adaRequest = GSON.fromJson(bodyPayloadData, AdaRequest.class);
			
			final String agentToken = adaRequest.getagentSessionId();
			final String backendAgentSessionId = webSocketCacheManager.getAgent(agentToken);
			LOGGER.info("followUpContactHistory: FE agent web token: {}, backendSessionId:{}", agentToken, backendAgentSessionId);
	
			adaRequest.setagentSessionId(backendAgentSessionId);
			
			LOGGER.debug("Received: followUpContactHistory request from UI: {}", adaRequest);
			final String omniChannelUrl = omniChannelUtilService.getMimUrl(adaRequest.getagentSessionId());
			response = omniChannelUtilService.processAndPostAdaRequestToIcx(
					adaRequest, 
					OmniChannelEmailCommandConstants.CONTACT_HISTORY_FOLLOWED_UP,
					adaCallbackUrl,
					omniChannelUrl,
					res);

		} catch (Exception e) {
			LOGGER.error("Error handling followUpContactHistory data: {}, with exception: {}",
					req,
					e.toString());
		}	
		return response;
	}
	
	@RequestMapping(value = "/fetchFollowUpEmailDetails", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String handleFetchFollowUpEmailDetails(final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		
		String response = null;
		
		LOGGER.info("Received: fetchFollowUpEmailDetails request from UI");
		LOGGER.debug("Received: fetchFollowUpEmailDetails request from UI: {}", req);
		
		final String bodyPayloadData = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		LOGGER.debug("/fetchFollowUpEmailDetails : Raw body payload data: {}", bodyPayloadData);
		
		try {
			AdaRequest adaRequest = GSON.fromJson(bodyPayloadData, AdaRequest.class);
			
			final String agentToken = adaRequest.getagentSessionId();
			final String backendAgentSessionId = webSocketCacheManager.getAgent(agentToken);
			LOGGER.info("fetchFollowUpEmailDetails: FE agent web token: {}, backendSessionId:{}", agentToken, backendAgentSessionId);
	
			adaRequest.setagentSessionId(backendAgentSessionId);
			
			LOGGER.debug("Received: fetchFollowUpEmailDetails request from UI: {}", adaRequest);
			final String omniChannelUrl = omniChannelUtilService.getMimUrl(adaRequest.getagentSessionId());
			response = omniChannelUtilService.processAndPostAdaRequestToIcx(
					adaRequest, 
					OmniChannelEmailCommandConstants.FOLLOW_UP_EMAIL_DETAILS_FETCHED,
					adaCallbackUrl,
					omniChannelUrl,
					res);

		} catch (Exception e) {
			LOGGER.error("Error handling fetchFollowUpEmailDetails data: {}, with exception: {}",
					req,
					e.toString());
		}	
		return response;
	}
	
	@RequestMapping(value = "/sendFollowUpOutboundEmail", method = RequestMethod.POST)
	@ResponseBody
	public String handleSendFollowUpOutboundEmail(final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		
		String response = null;
		
		LOGGER.info("Received: sendFollowUpOutboundEmail request from UI");
		LOGGER.debug("Received: sendFollowUpOutboundEmail request from UI: {}", req);
		
		final String bodyPayloadData = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		LOGGER.debug("/sendFollowUpOutboundEmail : Raw body payload data: {}", bodyPayloadData);
		
		try {
			AdaRequest adaRequest = GSON.fromJson(bodyPayloadData, AdaRequest.class);
			
			final String agentToken = adaRequest.getagentSessionId();
			final String backendAgentSessionId = webSocketCacheManager.getAgent(agentToken);
			LOGGER.info("sendFollowUpOutboundEmail: FE agent web token: {}, backendSessionId:{}", agentToken, backendAgentSessionId);
	
			adaRequest.setagentSessionId(backendAgentSessionId);
			
			LOGGER.debug("Received: sendFollowUpOutboundEmail request from UI: {}", adaRequest);
			final String omniChannelUrl = omniChannelUtilService.getMimUrl(adaRequest.getagentSessionId());
			response = omniChannelUtilService.processAndPostAdaRequestToIcx(
					adaRequest, 
					OmniChannelEmailCommandConstants.FOLLOW_UP_OUTBOUND_EMAIL_SENT,
					adaCallbackUrl,
					omniChannelUrl,
					res);

		} catch (Exception e) {
			LOGGER.error("Error handling sendFollowUpOutboundEmail data: {}, with exception: {}",
					req,
					e.toString());
		}	
		return response;
	}
	
}
