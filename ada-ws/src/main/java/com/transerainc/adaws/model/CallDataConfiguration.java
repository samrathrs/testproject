package com.transerainc.adaws.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.transerainc.adaws.util.ParsingUtils;

public class CallDataConfiguration {

    private static final String WILDCARD = "*";

    private final Map<String, String> labelNames;
    private final Set<String> suppressedKeys;
    private final Set<String> allowedKeys;
    private boolean denyFirst = false; // for backward compatibility

    private boolean showEmpty = true;

    /**
     * 
     */
    public CallDataConfiguration() {
        labelNames = new HashMap<String, String>();
        allowedKeys = new HashSet<String>();
        suppressedKeys = new HashSet<String>();
    }

    /**
     * @param key
     * @param label
     */
    public void addLabelName(final String key, final String label) {
        labelNames.put(key, label);
    }

    /**
     * @param key
     * @return
     */
    public String getLabel(final String key) {
        if (labelNames.containsKey(key)) {
            return labelNames.get(key);
        } else {
            return key;
        }
    }

    /**
     * 
     */
    public void clear() {
        labelNames.clear();
        allowedKeys.clear();
        suppressedKeys.clear();
    }

    /**
     * @param denyFirst
     */
    public void setDenyFirst(final boolean denyFirst) {
        this.denyFirst = denyFirst;
    }

    /**
     * @param key
     */
    public void addSuppressedKey(final String key) {
        suppressedKeys.add(key);
    }

    /**
     * @param key
     */
    public void addAllowedKey(final String key) {
        allowedKeys.add(key);
    }

    /**
     * @param key
     * @return
     */
    public boolean isAllowedKey(final String key) {
        if (denyFirst) {
            return !isInSuppressed(key) && isInAllowed(key);
        } else {
            return isInAllowed(key) || !isInSuppressed(key);
        }
    }

    /**
     * @param other
     */
    public void merge(final CallDataConfiguration other) {
        labelNames.putAll(other.labelNames);
        suppressedKeys.addAll(other.suppressedKeys);
        allowedKeys.addAll(other.allowedKeys);
        denyFirst = other.denyFirst;
    }

    /**
     * @param csv
     */
    public void setLabelNamesCsv(final String csv) {
        labelNames.clear();
        if (csv != null) {
            final Map<String, String> map = ParsingUtils.getMapFromCSV(csv);
            labelNames.putAll(map);
        }
    }

    /**
     * @param showEmpty
     */
    public void setShowEmpty(final boolean showEmpty) {
        this.showEmpty = showEmpty;
    }

    /**
     * @return
     */
    public boolean isShowEmpty() {
        return showEmpty;
    }

    /**
     * @param key
     * @return
     */
    private boolean isInAllowed(final String key) {
        return allowedKeys.contains(WILDCARD) || allowedKeys.contains(key);
    }

    /**
     * @param key
     * @return
     */
    private boolean isInSuppressed(final String key) {
        return suppressedKeys.contains(WILDCARD) || suppressedKeys.contains(key);
    }
}
