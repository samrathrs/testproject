package com.transerainc.adaws.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StationLoginToken {
	private static Logger LOGGER = LoggerFactory.getLogger(StationLoginToken.class.getName());
	public static Map<String, Integer> authMap = new HashMap<String, Integer>();
	public static ArrayList<String> processingList = new ArrayList<String>();
	public static Map<String, Boolean> dupDn = new HashMap<String, Boolean>();

	/**
	 * @param name
	 * @param value
	 */
	public void putAuthMap(final String name, final Integer value) {
		LOGGER.info("Coming  multiRequestForStationLogin : {} ", name + " auth" + value);
		if (authMap == null) {
			authMap = new HashMap<String, Integer>();
		}
		authMap.put(name, value);
	}

	/**
	 * @param value
	 */
	public void setDupDn(final String name, final boolean value) {
		dupDn.put(name, value);
	}

	/**
	 * @param value
	 * @return
	 */
	public Boolean getDupDn(final String value) {
		return dupDn.get(value);
	}

	/**
	 * @param name
	 * @return
	 */
	public Integer getAuthMap(final String name) {
		if ((authMap != null) && (!authMap.isEmpty())) {
			return authMap.get(name);
		} else {
			return 0;
		}
	}

	/**
	 * @return
	 */
	public void removeKeyFromAuth(final String name) {
		authMap.remove(name);
	}

	/**
	 * @param webToken
	 * @return
	 */
	public boolean checkKeyInAuth(final String webToken) {
		return authMap.containsKey(webToken);
	}

	/**
	 * @return
	 */
	public Map<String, Integer> getauthKeys() {
		return authMap;
	}

	/**
	 * @return
	 */
	public Set<String> getauthKeyList() {
		return authMap.keySet();
	}

	/**
	 * @param agentToken
	 */
	public void addProcessingList(final String agentToken) {
		processingList.add(agentToken);
	}

	/**
	 * @return
	 */
	public void removeFromPocessingList(final String agentToken) {
		if (processingList != null)
			processingList.remove(agentToken);
	}

	/**
	 * @param agentToken
	 * @return
	 */
	public boolean checkKeyInProcList(final String agentToken) {
		return processingList.contains(agentToken);
	}

	/**
	 * @return
	 */
	public ArrayList<String> getProcKeys() {
		return processingList;
	}

}
