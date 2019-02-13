package com.transerainc.adaws.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.HttpConstants;
import com.transerainc.adaws.constants.OmniChannelChatCommandConstants;
import com.transerainc.adaws.constants.OmniChannelChatMessageTypeConstants;
import com.transerainc.adaws.constants.OmniChannelCommonCommandConstants;
import com.transerainc.adaws.constants.OmniChannelCommonMessageTypeConstants;
import com.transerainc.adaws.constants.OmniChannelCommonWebServiceConstants;
import com.transerainc.adaws.constants.OmniChannelConstants;
import com.transerainc.adaws.constants.OmniChannelEmailCommandConstants;
import com.transerainc.adaws.constants.OmniChannelEmailMessageTypeConstants;
import com.transerainc.adaws.json.OmniChannelJsonUtil;
import com.transerainc.adaws.model.ChannelCapability;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.service.AuthenticationService;
import com.transerainc.adaws.service.AuxCodeService;
import com.transerainc.adaws.service.OmniChannelUtilService;

/**
 * @author jnarain
 *
 */
@Controller
public class OmniChannelController {

	private static Logger LOGGER = LoggerFactory.getLogger(OmniChannelController.class.getName());

	@Autowired
	private DesktopConfigManager agentDesktopConfigMap;

	@Autowired
	private AuxCodeService auxCodeService;

	@Autowired
	private AuthenticationService authService;

	@Autowired
	private OmniChannelUtilService omniChannelUtilService;

	private void handleRequest(final HttpServletRequest request, final HttpServletResponse response,
			final String payloadData, final String jsMethod, final String messageType) {

		omniChannelUtilService.handleRequest(request, response, payloadData, jsMethod, messageType);

		LOGGER.debug("Finished processing ICX Request of action/message type: {}, " + "with message data: {}",
				messageType, payloadData);
	}

	@RequestMapping(value = OmniChannelCommonWebServiceConstants.BASE_OMNI_CHANNEL_URI, method = RequestMethod.POST, headers = HttpConstants.CONTENT_TYPE
			+ MediaType.APPLICATION_JSON_VALUE, produces = { MediaType.APPLICATION_JSON_VALUE })
	public void handleRequest(final HttpServletRequest request, final HttpServletResponse response,
			@RequestBody(required = true) final String payloadData) throws Exception {
		LOGGER.info("Received ICX payload : {}", payloadData);

		if (StringUtils.isBlank(payloadData)) {
			LOGGER.error(
					"Received ICX payload is null or Blank (Apache StringUtils' definition). Stop further processing. ");
			return;
		}

		final String messageType = OmniChannelJsonUtil.extractMessageType(payloadData);

		if (StringUtils.isBlank(messageType)) {
			LOGGER.error(
					"Received message type of ICX payload is null or Blank (Apache StringUtils' definition). Stop further processing on ICX payload: {} ",
					payloadData);
			return;
		}

		try {
			switch (messageType) {
			// Common message types
			case OmniChannelCommonMessageTypeConstants.AGENT_STATE_CHANGE_CB:
				// State-Change-CB may have system-auxcodes that need to be translated &
				// propagated to tacg
				auxCodeService.handleRequestSystemAuxCode(request, response, payloadData,
						OmniChannelCommonCommandConstants.STATE_CHANGE_ACCEPTED,
						OmniChannelCommonMessageTypeConstants.AGENT_STATE_CHANGE_CB);
				break;
			case OmniChannelCommonMessageTypeConstants.AGENT_LOGGED_IN_CB:
				// Mark the omnichannel as logged-in
				handleRequestLoginCB(payloadData);
				handleRequest(request, response, payloadData, OmniChannelCommonCommandConstants.AGENT_LOGGED_IN,
						OmniChannelCommonMessageTypeConstants.AGENT_LOGGED_IN_CB);
				break;
			case OmniChannelCommonMessageTypeConstants.AGENT_LOGGED_OUT_CB:
				// Mark the omnichannel as logged-out
				if (handleRequestLogoutCB(payloadData)) {
					LOGGER.debug("success with handleRequestLogoutCB()");
					handleRequest(request, response, payloadData, OmniChannelCommonCommandConstants.AGENT_LOGGED_OUT,
							OmniChannelCommonMessageTypeConstants.AGENT_LOGGED_OUT_CB);
				} else {
					LOGGER.debug("handleRequestLogoutCB() returned false as agent may already be logged out");
				}
				break;
			case OmniChannelCommonMessageTypeConstants.CONTACT_COMPLETED_CB:
				handleRequest(request, response, payloadData, OmniChannelCommonCommandConstants.CONTACT_COMPLETED,
						OmniChannelCommonMessageTypeConstants.CONTACT_COMPLETED_CB);
				break;
			case OmniChannelCommonMessageTypeConstants.CONTACT_TRANSFERRED_CB:
				handleRequest(request, response, payloadData, OmniChannelCommonCommandConstants.CONTACT_TRANSFERRED,
						OmniChannelCommonMessageTypeConstants.CONTACT_TRANSFERRED_CB);
				break;
			case OmniChannelCommonMessageTypeConstants.RONA_CONTACT_REDIRECT:
				handleRequest(request, response, payloadData, OmniChannelCommonCommandConstants.RONA_NOTIFICATION,
						OmniChannelCommonMessageTypeConstants.RONA_CONTACT_REDIRECT);
				break;

			// Email message types
			case OmniChannelEmailMessageTypeConstants.EMAIL_CONTACT_ARRIVAL_CB:
				handleRequest(request, response, payloadData, OmniChannelEmailCommandConstants.EMAIL_CONTACT_ARRIVAL,
						OmniChannelEmailMessageTypeConstants.EMAIL_CONTACT_ARRIVAL_CB);
				break;
			case OmniChannelEmailMessageTypeConstants.EMAIL_CONTACT_ARRIVED_FOLLOWUP_CB:
				handleRequest(request, response, payloadData,
						OmniChannelEmailCommandConstants.EMAIL_CONTACT_ARRIVAL_FOLLOWUP,
						OmniChannelEmailMessageTypeConstants.EMAIL_CONTACT_ARRIVED_FOLLOWUP_CB);
				break;

			// Chat message types
			case OmniChannelChatMessageTypeConstants.CHAT_CONTACT_ARRIVAL_CB:
				handleRequest(request, response, payloadData, OmniChannelChatCommandConstants.CHAT_CONTACT_ARRIVED,
						OmniChannelChatMessageTypeConstants.CHAT_CONTACT_ARRIVAL_CB);
				break;
			case OmniChannelChatMessageTypeConstants.CHAT_ACCEPT_CONTACT:
				handleRequest(request, response, payloadData, OmniChannelChatCommandConstants.CHAT_CONTACT_ACCEPT,
						OmniChannelChatMessageTypeConstants.CHAT_ACCEPT_CONTACT);
				break;
			case OmniChannelChatMessageTypeConstants.CHAT_CONTACT_ASSIGNED_CB:
				handleRequest(request, response, payloadData, OmniChannelChatCommandConstants.CHAT_CONTACT_ASSIGNED,
						OmniChannelChatMessageTypeConstants.CHAT_CONTACT_ASSIGNED_CB);
				break;
			case OmniChannelChatMessageTypeConstants.CHAT_CONTACT_ACCEPTED_CB:
				handleRequest(request, response, payloadData, OmniChannelChatCommandConstants.CHAT_CONTACT_READY,
						OmniChannelChatMessageTypeConstants.CHAT_CONTACT_ACCEPTED_CB);
				break;
			case OmniChannelChatMessageTypeConstants.CHAT_CONFERENCE_CLOSE_CB:
				handleRequest(request, response, payloadData, OmniChannelChatCommandConstants.CHAT_CONFERENCE_CLOSED,
						OmniChannelChatMessageTypeConstants.CHAT_CONFERENCE_CLOSE_CB);
				break;
			case OmniChannelChatMessageTypeConstants.CHAT_CONTACT_CLOSE_CB:
				handleRequest(request, response, payloadData, OmniChannelChatCommandConstants.CHAT_CONTACT_CLOSED,
						OmniChannelChatMessageTypeConstants.CHAT_CONTACT_CLOSE_CB);
				break;
			case OmniChannelChatMessageTypeConstants.CHAT_CONTACT_MEMBER_JOINED_CB:
				handleRequest(request, response, payloadData, OmniChannelChatCommandConstants.CHAT_MEMBER_JOINED,
						OmniChannelChatMessageTypeConstants.CHAT_CONTACT_MEMBER_JOINED_CB);
				break;
			case OmniChannelChatMessageTypeConstants.CHAT_CONFERENCE_MEMBER_JOINED_CB:
				handleRequest(request, response, payloadData, OmniChannelChatCommandConstants.CHAT_CONFERENCE_ACCEPTED,
						OmniChannelChatMessageTypeConstants.CHAT_CONFERENCE_MEMBER_JOINED_CB);
				break;
			case OmniChannelChatMessageTypeConstants.CHAT_CONTACT_TERMINATED_CB:
				handleRequest(request, response, payloadData, OmniChannelChatCommandConstants.CHAT_CONTACT_TERMINATED,
						OmniChannelChatMessageTypeConstants.CHAT_CONTACT_TERMINATED_CB);
				break;
			case OmniChannelChatMessageTypeConstants.CHAT_SEND_MESSAGE_IN_CONFERENCE_CB:
				handleRequest(request, response, payloadData,
						OmniChannelChatCommandConstants.CHAT_CONFERENCE_AGENT_TO_AGENT_MESSAGE_SENT,
						OmniChannelChatMessageTypeConstants.CHAT_SEND_MESSAGE_IN_CONFERENCE_CB);
				break;
			case OmniChannelChatMessageTypeConstants.CHAT_SEND_MESSAGE_TO_CUSTOMER_CB:
				handleRequest(request, response, payloadData, OmniChannelChatCommandConstants.CHAT_MESSAGE_RECEIVED,
						OmniChannelChatMessageTypeConstants.CHAT_SEND_MESSAGE_TO_CUSTOMER_CB);
				break;
			case OmniChannelChatMessageTypeConstants.CHAT_START_CONFERENCE:
				handleRequest(request, response, payloadData,
						OmniChannelChatCommandConstants.CHAT_CONFERENCE_EVENT_STARTED,
						OmniChannelChatMessageTypeConstants.CHAT_START_CONFERENCE);
				break;
			case OmniChannelChatMessageTypeConstants.CHAT_MEMBER_JOINED_COACHING_CB:
				handleRequest(request, response, payloadData,
						OmniChannelChatCommandConstants.CHAT_MEMBER_JOINED_COACHING,
						OmniChannelChatMessageTypeConstants.CHAT_MEMBER_JOINED_COACHING_CB);
				break;
			case OmniChannelChatMessageTypeConstants.CHAT_MEMBER_LEFT_COACHING_CB:
				handleRequest(request, response, payloadData, OmniChannelChatCommandConstants.CHAT_MEMBER_LEFT_COACHING,
						OmniChannelChatMessageTypeConstants.CHAT_MEMBER_LEFT_COACHING_CB);
				break;
			case OmniChannelChatMessageTypeConstants.CHAT_CONFERENCE_CONVERSATION:
				break;
			case OmniChannelChatMessageTypeConstants.CHAT_CONFERENCE_START_CB:
				break;
			default:
				LOGGER.error("Default case: Received messageType : {}", messageType);
				break;
			}
		} catch (Exception exception) {
			LOGGER.error(
					"Error occurred while handling request from ICX with message type: {}, payloadData: {}, exception: {}",
					messageType, payloadData, exception.getMessage());
		}
		LOGGER.info("Finished processing on ICX action/message type: {}", messageType);
	}

	private void handleRequestLoginCB(String payloadData) {
		LOGGER.info("starting with  handleRequestLoginCB()");
		final String backendSessionId = OmniChannelJsonUtil.extractSessionId(payloadData);
		final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);

		if (desktopConfig.getChannelCapability() != null) {
			try {
				final Long channelIdLongObjectValue = OmniChannelJsonUtil.extractChannelId(payloadData);
				if (channelIdLongObjectValue != null) {
					final int channelId = channelIdLongObjectValue.intValue();
					LOGGER.info("Received channelId : {}", channelId);

					if (channelId == ChannelCapability.CHAT_CHANNEL_ID) {
						LOGGER.debug("set channel login status of chat channel");
						desktopConfig.getChannelCapability().setChatChannelsLoggedIn(true);
						LOGGER.debug("set channel login status of chat channel true");
					} else if (channelId == ChannelCapability.EMAIL_CHANNEL_ID) {
						LOGGER.debug("set channel login status of email channel");
						desktopConfig.getChannelCapability().setEmailChannelsLoggedIn(true);
						LOGGER.debug("set channel login status of email channel true");
					} else {
						LOGGER.error("Received login for an unknown channel from ICX");
					}
				}
			} catch (final Exception e) {
				LOGGER.error("Unable to set channel login status for payload: {}", payloadData);
			}
		} else {
			LOGGER.debug("No OmniChannel capability is set for this agent: {}", backendSessionId);
		}
	}

	private boolean handleRequestLogoutCB(String payloadData) {
		try {
			final String backendSessionId = OmniChannelJsonUtil.extractSessionId(payloadData);
			final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(backendSessionId);
			final ChannelCapability chCap = desktopConfig.getChannelCapability();

			if ((desktopConfig != null) && chCap != null) {
				// extract ChannelId from ICX profileData
				final Long channelIdLongObjectValue = OmniChannelJsonUtil.extractChannelId(payloadData);
				if (channelIdLongObjectValue != null) {
					final int channelId = channelIdLongObjectValue.intValue();
					LOGGER.info("Received channelId : {}", channelId);

					if (channelId == ChannelCapability.CHAT_CHANNEL_ID) {
						chCap.setChatChannelsLoggedIn(false);
						LOGGER.debug("set channel login status of chat channel false");
					} else if (channelId == ChannelCapability.EMAIL_CHANNEL_ID) {
						chCap.setEmailChannelsLoggedIn(false);
						LOGGER.debug("set channel login status of email channel false");
					} else {
						LOGGER.error("Received login for an unknown channel from ICX payload: {}", payloadData);
						return false;
					}

					// Check if we are logged out of both chat and email channels
					// logout of telephony if not already logged-out

					if (!chCap.isChatChannelsLoggedIn() && !chCap.isEmailChannelsLoggedIn()) {
						LOGGER.info("Logged-out of chat and email; Request Logout from tacg: {}", backendSessionId);
						authService.requestLogoutFromTacg(backendSessionId,
								OmniChannelConstants.LOGOUT_FROM_OMNICHANNEL);
					}
				} else {
					LOGGER.warn("Received null channel-id for this agent: {}", backendSessionId);
					return false;
				}
			} else {
				LOGGER.info("Agent already logged out or no channel capability is set for this agent: {}",
						backendSessionId);
				return false;
			}
		} catch (Exception e) {
			LOGGER.info("Dropping this request as UI has already logged out : payload: {}", payloadData);
			return false;
		}
		return true;
	}

}
