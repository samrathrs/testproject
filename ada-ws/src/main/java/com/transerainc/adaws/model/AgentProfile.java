package com.transerainc.adaws.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.transerainc.adaws.constants.AgentProfileConstants;
import com.transerainc.adaws.util.StringUtils;

public class AgentProfile implements AgentProfileConstants {

    private final Map<String, String> attributes; // <String, String>
    private final Map<String, Map<String, String>> entityLists; // <String, Map<String, String>>
    private final Map<String, DialPlan> dialPlans; // <String, DialPlan>
    private Map<Integer, Tuple> idleCodes; // <String, Tuple>

    public static class Tuple {
        String id;
        String name;
        boolean isSys;
        int omniAuxId;

	/**
	 * @param id
	 * @param name
	 * @param isSys
	 * @param omniAuxId
	 */
	public Tuple(String id, String name, boolean isSys, int omniAuxId) {
		super();
		this.id = id;
		this.name = name;
		this.isSys = isSys;
		this.omniAuxId = omniAuxId;
	}
		

		/**
		 * @return the id
		 */
	public String getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
	public void setId(String id) {
			this.id = id;
		}
		/**
		 * @return the name
		 */
	public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
	public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the isSys
		 */
	public boolean isSys() {
			return isSys;
		}
		/**
		 * @param isSys the isSys to set
		 */
	public void setSys(boolean isSys) {
			this.isSys = isSys;
		}
		/**
		 * @return the omniAuxId
		 */
	public int getOmniAuxId() {
			return omniAuxId;
		}
		/**
		 * @param omniAuxId the omniAuxId to set
		 */
	public void setOmniAuxId(int omniAuxId) {
			this.omniAuxId = omniAuxId;
		}

    }

      
    /**
     * 
     */
    public AgentProfile() {
        attributes = new HashMap<String, String>();
        entityLists = new HashMap<String, Map<String, String>>();
        dialPlans = new HashMap<String, DialPlan>();
        idleCodes = new HashMap<Integer, Tuple>();
    }

    /**
     * @param name
     * @param value
     */
    public void setAttribute(final String name, final String value) {
        attributes.put(name, value);
    }

    /**
     * @param name
     * @return
     */
    public String getAttribute(final String name) {
        return attributes.get(name);
    }

    /**
     * @return
     */
    public Set<String> getAttributeKeys() {
        return attributes.keySet();
    }

    /**
     * @return
     */
    public boolean getAutoWrapUpFlag() {
        return StringUtils.convertToBoolean(getAttribute(AUTO_WRAPUP_FLAG));
    }

    /**
     * @return
     */
    public int getAutoWrapUpInterval() {
        return StringUtils.getInt(getAttribute(AUTO_WRAPUP_INTERVAL));
    }

    /**
     * @param type
     * @return
     */
    public Map<String, String> getEntityList(final String type) {
        return entityLists.get(type);
    }

    /**
     * @return
     */
    public boolean getScreenPopupFlag() {
        return StringUtils.convertToBoolean(getAttribute(SCREEN_POPUP));
    }

    /**
     * @param type
     * @param map
     */
    public void setEntityList(final String type, final Map<String, String> map) {
        entityLists.put(type, map);
    }

    /**
     * @param type
     * @param dialPlan
     */
    public void addDialPlan(final String type, final DialPlan dialPlan) {
        dialPlans.put(type, dialPlan);
    }

    /**
     * @param type
     * @return
     */
    public DialPlan getDialPlan(final String type) {
        return dialPlans.get(type);
    }

    /**
     * @return
     */
    public boolean isAgentAvailableAfterOutdial() {
        return StringUtils.convertToBoolean(getAttribute(AVAILABLE_AFTER_OUTDIAL));
    }

    /**
     * @return
     */
    public boolean allowAutowrapupExtension() {
        return StringUtils.convertToBoolean(getAttribute(ALLOW_AUTOWRAPUP_EXTENSION));
    }

    /**
     * @return
     */
    public boolean isConsultToQueueAllowed() {
        return StringUtils.convertToBoolean(getAttribute(ALLOW_CONSULT_TO_QUEUE));
    }

	/**
	 * @return the idleCodes
	 */
	public Map<Integer, Tuple> getIdleCodes() {
		return idleCodes;
	}

	/**
	 * @param idleCodes the idleCodes to set
	 */
	public void setIdleCodes(Map<Integer, Tuple> idleCodes) {
		this.idleCodes = idleCodes;
	}



}