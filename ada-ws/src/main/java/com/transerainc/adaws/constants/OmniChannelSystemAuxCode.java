package com.transerainc.adaws.constants;

/**
 * @author tringuyen
 *
 */
public enum OmniChannelSystemAuxCode {

    BLENDED_AUX                (-5,    "Blended Aux"),
    DEFAULT_AUX                (-4,    "Default Aux"),
    OUTBOUND_AUX               (-3,    "Outbound Aux"),
    RONA                       (-2,    "RONA"),
    AUX_ON_LOGIN               (-1,    "Aux On Login");

    private final long id;
    private final String name;

    OmniChannelSystemAuxCode(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return the id
     */
    public final long getId() {
        return id;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    public static OmniChannelSystemAuxCode getOmniChannelAuxCodeFromId(final long id)
            throws EnumConstantNotPresentException {
        for (OmniChannelSystemAuxCode omniChannelAuxCode : OmniChannelSystemAuxCode.values()) {
            if (id == omniChannelAuxCode.getId()) {
                return omniChannelAuxCode;
            }
        }
        throw new EnumConstantNotPresentException(OmniChannelSystemAuxCode.class,
                "No OmniChannelAuxCode with id: " + id);
    }

    public static OmniChannelSystemAuxCode getOmniChannelAuxCodeFromName(final String name)
            throws EnumConstantNotPresentException {
        for (OmniChannelSystemAuxCode omniChannelAuxCode : OmniChannelSystemAuxCode.values()) {
            if (omniChannelAuxCode.getName().equalsIgnoreCase(name)) {
                return omniChannelAuxCode;
            }
        }
        throw new EnumConstantNotPresentException(OmniChannelSystemAuxCode.class,
                "No OmniChannelAuxCode with name: " + name);
    }
    
    public static boolean hasOmniChannelAuxCodeFromId(final long id) {
        for (OmniChannelSystemAuxCode omniChannelAuxCode : OmniChannelSystemAuxCode.values()) {
            if (id == omniChannelAuxCode.getId()) {
                return true;
            }
        }
        return false;
    }

}
