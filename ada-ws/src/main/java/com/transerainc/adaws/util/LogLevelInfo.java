package com.transerainc.adaws.util;

import javax.validation.constraints.NotNull;

/**
 * @author Prashanth
 */
public class LogLevelInfo {

	@NotNull
    	private String name;

	@NotNull
    private String level;

	@NotNull
    private LogLevel[] allLogLevels = LogLevel.ALL_LOG_LEVELS;

    public LogLevelInfo() {
    }

    public LogLevelInfo(final String name, final String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(final String level) {
        this.level = level;
    }

	public LogLevel[] getAllLogLevels() {
		return allLogLevels;
	}

	public void setAllLogLevels(LogLevel[] allLogLevels) {
		this.allLogLevels = allLogLevels;
	}

}
