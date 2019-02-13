/**
 * 
 */
package com.transerainc.ara.pojo;

/**
 * @author pgujjeti
 *
 */
public class AraConfiguration {

	public static class TacgConfig {
		private String applicationName;

		private String commandInterface;

		private String aimAgentLookupInterface;

		public String getApplicationName() {
			return applicationName;
		}

		public void setApplicationName(String applicationName) {
			this.applicationName = applicationName;
		}

		public String getCommandInterface() {
			return commandInterface;
		}

		public void setCommandInterface(String commandInterface) {
			this.commandInterface = commandInterface;
		}

		public String getAimAgentLookupInterface() {
			return aimAgentLookupInterface;
		}

		public void setAimAgentLookupInterface(String aimAgentLookupInterface) {
			this.aimAgentLookupInterface = aimAgentLookupInterface;
		}
	}

	private Xpath aimXpath;

	private TacgConfig tacgConfig;

	public AraConfiguration() {
	}

	public Xpath getAimXpath() {
		return aimXpath;
	}

	public void setAimXpath(Xpath aimXpath) {
		this.aimXpath = aimXpath;
	}

	public TacgConfig getTacgConfig() {
		return tacgConfig;
	}

	public void setTacgConfig(TacgConfig tacgConfig) {
		this.tacgConfig = tacgConfig;
	}
}
