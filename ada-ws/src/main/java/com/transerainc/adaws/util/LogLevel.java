package com.transerainc.adaws.util;

public enum LogLevel {

	OFF (Integer.MAX_VALUE, "OFF"), 
	ERROR (40000, "ERROR"), 
	WARN (30000, "WARN"), 
	INFO(20000, "INFO"), 
	DEBUG(10000, "DEBUG"), 
	TRACE(5000, "TRACE"), 
	ALL(Integer.MIN_VALUE, "ALL");

	public static final LogLevel[] ALL_LOG_LEVELS = { OFF, ERROR, WARN, INFO, DEBUG, TRACE, ALL };

	public static LogLevel forName(final String name) {
		if (org.apache.commons.lang3.StringUtils.isBlank(name)) {
			throw new IllegalArgumentException("Name cannot be blank for LogLevel");
		}
		
		switch (name) {
			case "OFF":
				return OFF;
			case "ERROR":
				return ERROR;
			case "WARN":
				return WARN;
			case "INFO":
				return INFO;
			case "DEBUG":
				return DEBUG;
			case "TRACE":
				return TRACE;
			case "ALL":
				return ALL;
			default:
				throw new IllegalArgumentException("Name \"" + name + "\" does not correspond to any LogLevel");
		}
	}

	private int levelInt;
	private String levelStr;
	
	private LogLevel(final int levelInt, final String levelStr) {
		this.levelInt = levelInt;
		this.levelStr = levelStr;
	}

	public int getIntValue() {
		return levelInt;
	}

	public String getName() {
		return levelStr;
	}

	@Override
	public String toString() {
		return getName();
	}
	
}
