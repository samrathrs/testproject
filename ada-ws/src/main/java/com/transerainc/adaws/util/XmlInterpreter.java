package com.transerainc.adaws.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.constants.ChannelStateConstant;
import com.transerainc.adaws.model.AuxCode;
import com.transerainc.adaws.model.CallAssociatedData;
import com.transerainc.adaws.model.DesktopConfiguration;

@Component
public class XmlInterpreter {

    private static Logger LOGGER = LoggerFactory.getLogger(XmlInterpreter.class.getName());

    /**
     * @param state
     * @param subState
     * @param auxCodes
     * @param cad
     * @param desktopConfig
     */
    public void requestStateChange(final String state, final String subState, final AuxCode[] auxCodes,
            final CallAssociatedData cad, final DesktopConfiguration desktopConfig) {
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put("auxCodes", StringUtils.printList(auxCodes));
        if (cad != null) {
            params.put("cad", StringUtils.printMap(cad.getKeyValueMap()));
        }
        LOGGER.info("State change with auxCodes requested: " + state + "," + subState, params);
        doStateChangeRequest(state, subState, auxCodes, cad, desktopConfig);
        desktopConfig.setStatus(state);
        desktopConfig.setSubStatus(subState);
    }

    /**
     * @param state
     * @param subState
     * @param auxCodes
     * @param callAssociatedData
     * @param desktopConfig
     */
    public void doStateChangeRequest(final String state, final String subState, final AuxCode[] auxCodes,
            final CallAssociatedData callAssociatedData, final DesktopConfiguration desktopConfig) {

        if (ChannelStateConstant.IDLE.equals(subState)) {
            updateIdleAuxCode(auxCodes, desktopConfig);
        }

        // if ((ChannelStateConstant.IDLE.equals(subState)) || (ChannelStateConstant.AVAILABLE.equals(subState))) {
        // updateWrapUpAuxCode(auxCodes, desktopConfig);
        // }

        desktopConfig.getStateChangeData().setAuxCodes(auxCodes);
        desktopConfig.getStateChangeData().setCallAssociatedData(callAssociatedData);
    }

    /**
     * @param auxCodes
     * @param desktopConfig
     */
    private void updateIdleAuxCode(final AuxCode[] auxCodes, final DesktopConfiguration desktopConfig) {
        if (auxCodes == null) {
            desktopConfig.setLastIdleAuxCode(null);

        } else {
            for (final AuxCode aux : auxCodes) {
                if (aux != null && AuxCode.TYPE_IDLE.equals(aux.getType())) {
                    desktopConfig.setLastIdleAuxCode(aux);
                }
            }
        }
    }

    /**
     * @param auxCodes
     * @param desktopConfig
     */
    // private void updateWrapUpAuxCode(AuxCode[] auxCodes, DesktopConfiguration desktopConfig) {
    // for (int i = 0; auxCodes != null && i < auxCodes.length; i++) {
    // AuxCode aux = auxCodes[i];
    // if (aux != null && AuxCode.TYPE_WRAPUP.equals(aux.getType())) {
    // desktopConfig.setLastWrapUpAuxCode(aux);
    // }
    // }
    // }
}
