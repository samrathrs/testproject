package com.transerainc.adaws.model.cache.contact.call;

/**
 * @author tnguyen
 *
 */
public enum CallStatus {

	RINGING ("Ringing"),
	OUTDIAL_RESERVED ("OutdialReserved"),
	CONNECTED ("Connected"),
	CONSULT_REQUESTED ("ConsultRequested"),
	CONSULT_RESERVED ("ConsultReserved"),
	CONSULTING ("Consulting"),
	CONFERENCED ("Conferenced"),
	CONFERENCING ("Conferencing"),
	WRAP_UP ("WrapUp"),
	NOT_REPONDING ("NotResponding");

	private String name;

	private CallStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
