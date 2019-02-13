package com.transerainc.adaws.model;

import java.util.ArrayList;
import java.util.List;

public class DialPlan {

    private String type;

    private final List<Allowed> allowedList = new ArrayList<Allowed>();

    /**
     * @param type
     */
    public DialPlan(final String type) {
        setType(type);
    }

    /**
     * @return
     */
    public List<Allowed> getAllowedList() {
        return allowedList;
    }

    /**
     * @param allowed
     */
    public void addAllowed(final Allowed allowed) {
        allowedList.add(allowed);
    }

    /**
     * @param type
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * @return
     */
    public String getType() {
        return type;
    }

    public static class Allowed {

        private final String name;
        private String regex;
        private String prefix;
        private String strippedChars;

        /**
         * @param name
         */
        public Allowed(final String name) {
            this.name = name;
        }

        /**
         * @return
         */
        public String getName() {
            return name;
        }

        /**
         * @return
         */
        public String getPrefix() {
            return prefix;
        }

        /**
         * @param prefix
         */
        public void setPrefix(final String prefix) {
            this.prefix = prefix;
        }

        /**
         * @return
         */
        public String getRegex() {
            return regex;
        }

        /**
         * @param regex
         */
        public void setRegex(final String regex) {
            this.regex = regex;
        }

        /**
         * @return
         */
        public String getStrippedChars() {
            return strippedChars;
        }

        /**
         * @param strippedChars
         */
        public void setStrippedChars(final String strippedChars) {
            this.strippedChars = strippedChars;
        }
    }
}
