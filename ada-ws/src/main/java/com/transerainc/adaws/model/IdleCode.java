/**
 * 
 */
package com.transerainc.adaws.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jnarain
 *
 */
public class IdleCode {
	
	private String type;

    private final List<AllowedEntity> entityList = new ArrayList<AllowedEntity>();
    
    /**
     * @param type
     */
    public IdleCode(final String type) {
        setType(type);
    }

    /**
     * @return
     */
    public List<AllowedEntity> getEntityList() {
        return entityList;
    }

    /**
     * @param allowed
     */
    public void addAllowedEntity(final AllowedEntity allowedEntity) {
    	entityList.add(allowedEntity);
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

    public static class AllowedEntity {

        private final String name;
        private String id;
        private String isSystem;
        private String omniChannelAuxId;

        /**
         * @param name
         */
        public AllowedEntity(final String name) {
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
        public String getId() {
            return id;
        }

        /**
         * @param prefix
         */
        public void setId(final String id) {
            this.id = id;
        }

        /**
         * @return
         */
        public String getIsSystem() {
            return isSystem;
        }

        /**
         * @param regex
         */
        public void setIsSystem(final String isSystem) {
            this.isSystem = isSystem;
        }

        /**
         * @return
         */
        public String getOmniChannelAuxId() {
            return omniChannelAuxId;
        }

        /**
         * @param strippedChars
         */
        public void setOmniChannelAuxId(final String omniChannelAuxId) {
            this.omniChannelAuxId = omniChannelAuxId;
        }
    }

}
