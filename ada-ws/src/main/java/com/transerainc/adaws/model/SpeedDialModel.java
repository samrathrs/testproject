/**
 * 
 */
package com.transerainc.adaws.model;

/**
 * @author rajeev.lochanam
 */
public class SpeedDialModel {
    private String desc;
    private String dn;

    /**
     * @param desc
     * @param dn
     */
    public SpeedDialModel(final String desc, final String dn) {
        this.desc = desc;
        this.dn = dn;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @return the dn
     */
    public String getDn() {
        return dn;
    }
}
