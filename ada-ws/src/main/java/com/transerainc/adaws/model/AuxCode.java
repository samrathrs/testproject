package com.transerainc.adaws.model;

import com.transerainc.adaws.constants.AgentStateConstants;

public class AuxCode {

    public static final String TYPE_IDLE = AgentStateConstants.SUBSTATE_IDLE;
    public static final String TYPE_WRAPUP = AgentStateConstants.SUBSTATE_WRAP_UP;

    private String type;
    private String id;
    private String desc;

    /**
     * @param type
     * @param id
     * @param desc
     */
    public AuxCode(final String type, final String id, final String desc) {
        this.type = type;
        this.id = id;
        this.desc = desc;
    }

    /**
     * @return
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc
     */
    public void setDesc(final String desc) {
        this.desc = desc;
    }

    /**
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * 
     */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(type);
        sb.append("(").append(id).append(",").append(desc).append(")");
        return sb.toString();
    }

    /**
     * 
     */
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (desc == null ? 0 : desc.hashCode());
        result = PRIME * result + (id == null ? 0 : id.hashCode());
        result = PRIME * result + (type == null ? 0 : type.hashCode());
        return result;
    }

    /**
     * 
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) { return true; }
        if (obj == null) { return false; }
        if (getClass() != obj.getClass()) { return false; }
        final AuxCode other = (AuxCode) obj;
        if (type == null) {
            if (other.type != null) { return false; }
        } else if (!type.equals(other.type)) { return false; }
        if (desc == null) {
            if (other.desc != null) { return false; }
        } else if (!desc.equals(other.desc)) { return false; }
        if (id == null) {
            if (other.id != null) { return false; }
        } else if (!id.equals(other.id)) { return false; }

        return true;
    }
}
