package com.transerainc.adaws.util;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

/**
 * @author tringuyen
 *
 */
public class LogLevelInfoForm {

	@Valid
	private List<LogLevelInfo> logLevelInfoList = new ArrayList<LogLevelInfo>();

	public LogLevelInfoForm() {
	}

	public LogLevelInfoForm(List<LogLevelInfo> logLevelInfoList) {
		setLogLevelInfoList(logLevelInfoList);
	}

	public List<LogLevelInfo> getLogLevelInfoList() {
		return logLevelInfoList;
	}

	public void setLogLevelInfoList(List<LogLevelInfo> logLevelInfoList) {
		this.logLevelInfoList = logLevelInfoList;
	}


}
