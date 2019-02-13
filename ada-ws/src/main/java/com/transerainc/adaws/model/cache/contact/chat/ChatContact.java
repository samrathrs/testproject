package com.transerainc.adaws.model.cache.contact.chat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.transerainc.adaws.constants.StateCacheConstants;
import com.transerainc.adaws.constants.StateCacheContactType;
import com.transerainc.adaws.model.cache.contact.InteractiveOmniChannelContact;

/**
 * @author tringuyen
 *
 */
public class ChatContact extends InteractiveOmniChannelContact {

	private static final Gson GSON = new Gson();

	private long customerId;
	private ContactDetails contactDetails;
	private AdditionalData additionalData;
	private List<ChatMessage> messages = new ArrayList<ChatMessage>();;
	private List<ConferenceParticipant> confParticipants = new ArrayList<ConferenceParticipant>();
	private PrivateMessages privateMessages;

	public ChatContact(
			String contactType, 
			String contactState, 
			long agentId, 
			long channelId, 
			long omniChannelQueueId,
			ContactDetails contactDetails, 
			AdditionalData additionalData
		) {
		super(
				StateCacheContactType.CHAT.getName(), 
				contactType, 
				contactState, 
				agentId, 
				Long.valueOf(channelId).toString(), 
				omniChannelQueueId
			);
		this.contactDetails = contactDetails;
		this.additionalData = additionalData;
	}

	/**
	 * @param contactState
	 * @param agentId
	 * @param contactType
	 * @param channelId
	 * @param omniChannelQueueId
	 * @param customerId
	 * @param contactDetails
	 * @param additionalData
	 * @param messages
	 * @param confParticipants
	 * @param privateMessages
	 */
	public ChatContact(
			String contactType, 
			String contactState, 
			long agentId, 
			long channelId, 
			long omniChannelQueueId,
			long customerId, 
			ContactDetails contactDetails, 
			AdditionalData additionalData, 
			List<ChatMessage> messages,
			List<ConferenceParticipant> confParticipants, 
			PrivateMessages privateMessages
		) {
		super(
				StateCacheContactType.CHAT.getName(), 
				contactType, 
				contactState, 
				agentId, 
				Long.valueOf(channelId).toString(), 
				omniChannelQueueId
			);
		this.customerId = customerId;
		this.contactDetails = contactDetails;
		this.additionalData = additionalData;
		this.messages = messages;
		this.confParticipants = confParticipants;
		this.privateMessages = privateMessages;
	}

	/**
	 * @return the contactState
	 */
	public String getContactState() {
		return contactState;
	}

	/**
	 * @param contactState the contactState to set
	 */
	public void setContactState(String contactState) {
		this.contactState = contactState;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the agentId
	 */
	public long getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return the contactType
	 */
	public String getContactType() {
		return contactType;
	}

	/**
	 * @param contactType the contactType to set
	 */
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	/**
	 * @return the omniChannelQueueId
	 */
	public long getOmniChannelQueueId() {
		return omniChannelQueueId;
	}

	/**
	 * @param omniChannelQueueId the omniChannelQueueId to set
	 */
	public void setOmniChannelQueueId(long omniChannelQueueId) {
		this.omniChannelQueueId = omniChannelQueueId;
	}

	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the contactDetails
	 */
	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	/**
	 * @param contactDetails the contactDetails to set
	 */
	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	/**
	 * @return the additionalData
	 */
	public AdditionalData getAdditionalData() {
		return additionalData;
	}



	/**
	 * @param additionalData the additionalData to set
	 */
	public void setAdditionalData(AdditionalData additionalData) {
		this.additionalData = additionalData;
	}



	/**
	 * @return the messages
	 */
	public List<ChatMessage> getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<ChatMessage> messages) {
		this.messages = messages;
	}

	/**
	 * @return the confParticipants
	 */
	public List<ConferenceParticipant> getConfParticipants() {
		return confParticipants;
	}

	/**
	 * @param confParticipants the confParticipants to set
	 */
	public void setConfParticipants(List<ConferenceParticipant> confParticipants) {
		this.confParticipants = confParticipants;
	}

	/**
	 * @return the privateMessages
	 */
	public PrivateMessages getPrivateMessages() {
		return privateMessages;
	}

	/**
	 * @param privateMessages the privateMessages to set
	 */
	public void setPrivateMessages(PrivateMessages privateMessages) {
		this.privateMessages = privateMessages;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatContact ");
		builder.append("[");
		builder.append(super.debugToString());
		builder.append(", customerId=");
		builder.append(customerId);
		builder.append(", contactDetails=");
		if (contactDetails != null) {
			builder.append(contactDetails.debugToString());
		} else {
			builder.append("null");
		}
		builder.append(", additionalData=");
		if (additionalData != null) {
			builder.append(additionalData.debugToString());
		} else {
			builder.append("null");
		}
		builder.append(", messages=");
		if ((messages != null) && (messages.size() > 0)) {
			for (ChatMessage message : messages) {
				builder.append(message.debugToString());
			}
		} else {
			builder.append("null");
		}
		builder.append(", confParticipants=");
		if ((confParticipants != null) && (confParticipants.size() > 0)) {
			for (ConferenceParticipant conferenceParticipant : confParticipants) {
				builder.append(conferenceParticipant.debugToString());
			}
		} else {
			builder.append("null");
		}
		builder.append(", privateMessages=");
		if (privateMessages != null) {
			builder.append(privateMessages.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

	public void addChatMessage(ChatMessage chagMessage) {
		if (this.messages == null) {
			messages = new ArrayList<ChatMessage>();
		}
		messages.add(chagMessage);
	}
	
	public void addConferenceParticipant(final ConferenceParticipant conferenceParticipant) {
		this.confParticipants.add(conferenceParticipant);
	}
	
	public void removeAllConferenceParticipants() {
		this.confParticipants.clear();
	}

	public void removeConferenceParticipant(final long memberId) {
		Iterator<ConferenceParticipant> iterator = confParticipants.iterator();
		while (iterator.hasNext()) {
			ConferenceParticipant conferenceParticipant = iterator.next();
			if (memberId == conferenceParticipant.getId()) {
				iterator.remove();
				break;
			}
		}
	}

	public void removePrivateMessages(final long confParticipantIdLongValue) {
		if (this.privateMessages == null) {
			return;
		}
		final String confParticipantIdStringValue = Long.valueOf(confParticipantIdLongValue).toString();
		privateMessages.removeAllMessagesOfAgent(confParticipantIdStringValue);
	}

	public void addPrivateMessage(long confParticipantIdLongValue, ChatMessage chatMessage) {
		if (this.privateMessages == null) {
			privateMessages = new PrivateMessages();
		}
		final String confParticipantIdStringValue = Long.valueOf(confParticipantIdLongValue).toString();
		privateMessages.addMessage(confParticipantIdStringValue, chatMessage);
	}

	public String toJsonString() {
		return this.toJsonObject().toString();
	}

	public JSONObject toJsonObject() {
		final JSONObject chatContactJsonObject = super.toJsonObject();

		chatContactJsonObject.put(StateCacheConstants.CUSTOMER_ID_KEY, this.customerId);
		if (this.contactDetails != null) {
			final String contactDetailsJsonString = GSON.toJson(this.contactDetails, ContactDetails.class);
			final JSONObject contactDetailsJson = new JSONObject(contactDetailsJsonString);
			chatContactJsonObject.put(StateCacheConstants.CONTACT_DETAILS_KEY, contactDetailsJson);
		}
		if (this.additionalData != null) {
			final String additionalDataJsonString = GSON.toJson(this.additionalData, AdditionalData.class);
			final JSONObject additionalDataJson = new JSONObject(additionalDataJsonString);
			chatContactJsonObject.put(StateCacheConstants.ADDITIONAL_DATA_KEY, additionalDataJson);
		}
		if ((this.messages != null) && (!this.messages.isEmpty())) {
			chatContactJsonObject.put(StateCacheConstants.MESSAGES_KEY, this.messages);
		}
		if ((this.confParticipants != null) && (!this.confParticipants.isEmpty())) {
			chatContactJsonObject.put(StateCacheConstants.CONF_PARTICIPANTS_KEY, this.confParticipants);
		}
		if (this.privateMessages != null) {
			chatContactJsonObject.put(StateCacheConstants.PRIVATE_MESSAGES_KEY, this.privateMessages.toJsonObject());
		}
		
		return chatContactJsonObject;
	}

}
