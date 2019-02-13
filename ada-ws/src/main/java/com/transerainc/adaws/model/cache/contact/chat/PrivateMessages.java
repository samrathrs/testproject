package com.transerainc.adaws.model.cache.contact.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.json.JSONObject;

import com.google.gson.Gson;

/**
 * @author tnguyen
 *
 */
public class PrivateMessages {

	private static final Gson GSON = new Gson();

	private SortedMap<String, List<ChatMessage>> messages = new TreeMap<String, List<ChatMessage>>();

	/**
	 * 
	 */
	public PrivateMessages() {
	}

	/**
	 * @param messages
	 */
	public PrivateMessages(SortedMap<String, List<ChatMessage>> messages) {
		this.messages = messages;
	}

	/**
	 * @return the messages
	 */
	public SortedMap<String, List<ChatMessage>> getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(SortedMap<String, List<ChatMessage>> messages) {
		this.messages = messages;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PrivateMessages [messages=");
		if ((messages != null) && (!messages.isEmpty())) {
			builder.append('{');
			for (Map.Entry<String, List<ChatMessage>> messagesEntry : messages.entrySet()) {
				List<ChatMessage> chatMessages = messagesEntry.getValue();
				if ((chatMessages != null) && (!chatMessages.isEmpty())) {
					builder.append('"');
					builder.append(messagesEntry.getKey());
					builder.append('"');
					builder.append(" : [");
					for(ChatMessage chatMessage : chatMessages) {
						builder.append(chatMessage.debugToString());
						builder.append(',');
					}
					builder.append(']');
				}
			}
			builder.append('}');
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

	private String getMessagesAsJsonString() {
		String messagesJsonString = null;
		if ((this.messages != null) && (!this.messages.isEmpty())) {
			messagesJsonString = GSON.toJson(this.messages);
		}
		return messagesJsonString;
	}

	public JSONObject toJsonObject() {
		JSONObject messagesJsonObject = null;
		final String messagesAsJsonString = getMessagesAsJsonString();
		if (org.apache.commons.lang3.StringUtils.isNotBlank(messagesAsJsonString)) {
			messagesJsonObject = new JSONObject(messagesAsJsonString);
		}
		return messagesJsonObject;
	}

	public void addMessage(final String agentId, final ChatMessage chatMessage) {
		List<ChatMessage> chatMessagesOfAgent = messages.get(agentId);
		if (chatMessagesOfAgent == null) {
			chatMessagesOfAgent = new ArrayList<ChatMessage>();
			chatMessagesOfAgent.add(chatMessage);
			messages.put(agentId, chatMessagesOfAgent);
		} else {
			chatMessagesOfAgent.add(chatMessage);
		}
	}

	public void removeAllMessagesOfAgent(final String agentId) {
		messages.remove(agentId);
	}

	public void clearAllMessages() {
		messages.clear();
	}

}
