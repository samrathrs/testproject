package com.transerainc.adaws.constants;

/**
 * @author rajeev.lochanam
 */
public interface ChannelStateConstant {

    // System States
    final String IDLE = "Idle";
    final String AVAILABLE = "Available";
    final String RESERVED = "Ringing";
    final String NOT_RESPONDING = "NotResponding";
    final String WRAP_UP = "WrapUp";
    final String OUTDIAL_RESERVED = "OutdialReserved";

    // System States (Compound)
    final String CONSULT_RESERVED = "ConsultReserved";
    final String CONSULTING = "Consulting";

    final String AVAILABLE_CONSULT_RESERVED = "AvailableConsultReserved";
    final String CONNECTED_CONSULT_RESERVED = "ConnectedConsultReserved";

    final String AVAILABLE_CONSULTING = "AvailableConsulting";
    final String CONNECTED_CONSULTING = "ConnectedConsulting";
}
