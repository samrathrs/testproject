/**
 * 
 */
package com.transerainc.ara.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.aha.gen.agent.AgentDocument.Agent;
import com.transerainc.aha.gen.agent.AgentListDocument;
import com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation;
import com.transerainc.aha.gen.agent.ChannelTypes;
import com.transerainc.aha.gen.agent.StatusType;
import com.transerainc.aha.gen.agent.SubStatusType;
import com.transerainc.ara.agent.AgentLookup;
import com.transerainc.ara.agent.AimProvider;
import com.transerainc.ara.pojo.ActiveAgent;
import com.transerainc.ara.pojo.AraConfiguration.TacgConfig;
import com.transerainc.ara.prov.ConfigProvider;
import com.transerainc.tam.util.HttpStatus;
import com.transerainc.tam.util.HttpUtil;

/**
 * @author pgujjeti
 *
 */
public class AgentService {
	private final Logger lgr = LoggerFactory.getLogger(AgentService.class);

	private AimProvider aimProvider;

	private ConfigProvider configProvider;

	/**
	 * @param agentLookup
	 * @param aimProvider
	 */
	public AgentService(ConfigProvider configProvider,
			AimProvider aimProvider) {
		super();
		this.aimProvider = aimProvider;
		this.configProvider = configProvider;
	}

	/**
	 * @param agentId
	 * @param state
	 * @param auxCodeId
	 * @return
	 * @throws Exception
	 */
	public boolean setState(Long agentId, String state, int auxCodeId)
			throws Exception {
		lgr.debug("Setting agent[{}] state to {} (auxCodeId: {})", agentId,
				state, auxCodeId);
		TacgConfig tacgConfig = configProvider.getAraConfig().getTacgConfig();
		String aimUrl = aimProvider.getPrimaryAim()
				+ tacgConfig.getAimAgentLookupInterface();
		AgentLookup agentLookup = new AgentLookup();
		// lookup the telephony channel
		ActiveAgent agent = agentLookup.lookupAgent(aimUrl, agentId,
				"telephony");
		if (agent == null) {
			lgr.info("Agent {} not found in AIM", agentId);
			return false;
		}
		String acgUrl = agent.getAcgUrl() + tacgConfig.getCommandInterface();
		// Create the XML message object
		AgentListDocument listDoc = AgentListDocument.Factory.newInstance();
		Agent agentNode = listDoc.addNewAgentList().addNewAgent();
		agentNode.setAgentId(agentId.toString());
		agentNode.setStatus(StatusType.LOGGED_IN);
		agentNode.setSubStatus(SubStatusType.Enum.forString(state));
		agentNode.setAgentsessionid(agent.getAgentSessionId());
		agentNode.setChannelId(agent.getChannelId());
		agentNode.setChannelType(
				ChannelTypes.Enum.forString(agent.getChannelType()));
		agentNode.setRetry(false);
		agentNode.setLoginUserId(agent.getAgentName());
		agentNode.setEnterpriseId(agent.getTenantId().toString());
		agentNode.setTimestamp(System.currentTimeMillis());
		// Empty values - needed by TACG for proper XML validation
		agentNode.setDn("");
		agentNode.setPositionId("");
		agentNode.setSiteId("");
		agentNode.setTeamId("");
		agentNode.setHostIpAddress("");
		if (auxCodeId > 0) {
			AuxiliaryInformation auxNode = agentNode
					.addNewAuxiliaryInformation();
			auxNode.setCode(auxCodeId);
			auxNode.setCodeType("Idle");
			auxNode.setName("");
		}
		String agentListXml = listDoc.toString();
		lgr.debug("Posting command to ACG {} for agent [{}]: {}", acgUrl,
				agentId, agentListXml);
		// send the state change command to TACG
		HttpStatus status = HttpUtil.doHttpXMLPostReturningStatus(acgUrl,
				agentListXml);
		return status != null && status.getCode() >= 200
				&& status.getCode() < 300;
	}

}
