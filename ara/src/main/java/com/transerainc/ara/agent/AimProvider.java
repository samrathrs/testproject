/**
 * 
 */
package com.transerainc.ara.agent;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.ara.pojo.Xpath;
import com.transerainc.provisioning.notificationServer.UpdateNotificationDocument.UpdateNotification;
import com.transerainc.provisioning.ns.NotificationMessageHandler;
import com.transerainc.provisioning.ns.NotificationServerConnector;
import com.transerainc.tam.config.ConfigAgentHelperForXMLBean;
import com.transerainc.tam.config.PopMapping;

/**
 * @author pgujjeti
 *
 */
public class AimProvider implements NotificationMessageHandler {
	private final Logger lgr = LoggerFactory
			.getLogger(AimProvider.class.getName());

	private String primaryAim;

	private String backupAim;

	private NotificationServerConnector notificationServerConnector;

	private String configAgentUrl;

	private Xpath aimXpath;

	/**
	 * @param configAgentUrl
	 * @param nsConnector
	 * @param aimPopMapping
	 * @throws Exception
	 * 
	 */
	public AimProvider(String configAgentUrl, Xpath aimXpath,
			NotificationServerConnector nsConnector) throws Exception {
		this.configAgentUrl = configAgentUrl;
		this.aimXpath = aimXpath;
		this.notificationServerConnector = nsConnector;
		notificationServerConnector.subscribe(aimXpath.getXpath(),
				aimXpath.getAttributes(), this);
		init();
	}

	public void init() throws Exception {
		List<PopMapping> nodes = ConfigAgentHelperForXMLBean
				.getPopMappings(configAgentUrl, aimXpath.getXpath());
		for (PopMapping node : nodes) {
			String url = formAimUrl(node);
			if (node.getOperatingMode() == 0) {
				primaryAim = url;
			} else {
				backupAim = url;
			}
		}
		lgr.info("Primary AIM is: {} and backup AIM is: {}", getPrimaryAim(),
				getBackupAim());
	}

	public void stop() {
	}

	/**
	 * @param node
	 * @return
	 */
	private String formAimUrl(PopMapping node) {
		String url = "http://" + node.getHost() + ":" + node.getPort();
		return url;
	}

	public String getPrimaryAim() {
		return primaryAim;
	}

	public void setPrimaryAim(String primaryAim) {
		this.primaryAim = primaryAim;
	}

	public String getBackupAim() {
		return backupAim;
	}

	public void setBackupAim(String backupAim) {
		this.backupAim = backupAim;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.transerainc.provisioning.ns.NotificationMessageHandler#
	 * handleUpdateNotification(com.transerainc.provisioning.notificationServer.
	 * UpdateNotificationDocument.UpdateNotification)
	 */
	@Override
	public void handleUpdateNotification(UpdateNotification update)
			throws Exception {
		// reinit aim mappings
		lgr.info("Received a notification message for AIM pop-mapping xpath {}",
				aimXpath.getXpath());
		init();
	}

}
