package com.transerainc.adaws.constants;

/**
 * @author rajeev.lochanam
 */
public interface AgentStateConstants {

    final String STATE_LOGIN = "Login";
    final String STATE_LOGOUT = "Logout";
    final String STATE_LOGGED_IN = "LoggedIn";
    final String STATE_LOGGED_OUT = "LoggedOut";

    final String SUBSTATE_CONNECTED = "Connected";
    final String SUBSTATE_AVAILABLE = "Available";
    final String SUBSTATE_RINGING = "Ringing";
    final String SUBSTATE_WRAP_UP = "WrapUp";
    final String SUBSTATE_IDLE = "Idle";

    // Internal States
    final String LOGGED_IN = "LoggedIn";
    final String HOLD = "hold";
    final String UNHOLD = "unhold";

    final String IDLE = "Idle";
    final String AVAILABLE = "Available";
    final String RESERVED = "Ringing";
    final String CONNECTED = "Connected";
    final String WRAP_UP = "WrapUp";
    final String NOT_REACHABLE = "NotReachable";
    final String NOT_RESPONDING = "NotResponding";
    final String OUTDIAL_RESERVED = "OutdialReserved";
    final String CONSULT_RESERVED = "ConsultReserved";
    final String CONSULTING = "Consulting";
    final String AVAILABLE_CONSULT_RESERVED = "AvailableConsultReserved";
    final String IDLE_CONSULT_RESERVED = "IdleConsultReserved";
    final String CONNECTED_CONSULT_RESERVED = "ConnectedConsultReserved";
    final String WRAP_UP_CONSULT_RESERVED = "WrapUpConsultReserved";
    final String AVAILABLE_CONSULTING = "AvailableConsulting";
    final String IDLE_CONSULTING = "IdleConsulting";
    final String CONNECTED_CONSULTING = "ConnectedConsulting";
    final String LOST_CONNECTION = "LostConnection";
    
    // Change DN Team values error constants
    final int CHANGE_DN_TEAM_WHILE_NOT_IN_AVAILABLE_OR_IDLE_STATE_CODE = 35;
    final String CHANGE_DN_TEAM_WHILE_NOT_IN_AVAILABLE_OR_IDLE_STATE_MESSAGE = "Cannot change DN or Team while not in Available or Idle State";
    final int CHANGE_DN_TEAM_SERVER_ERROR_CODE = 36;
    final String CHANGE_DN_TEAM_SERVER_ERROR_MESSAGE = "Server error occurred while changing DN and Team values";
}
