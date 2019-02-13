/**
 * 
 */
package com.transerainc.adaws.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.UUID;

import org.apache.xmlbeans.XmlOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.AgentStateConstants;
import com.transerainc.adaws.constants.CallPropertyConstants;
import com.transerainc.adaws.constants.CallStateConstants;
import com.transerainc.adaws.constants.ChannelStateConstant;
import com.transerainc.adaws.constants.ChannelType;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.model.AdaRequest;
import com.transerainc.adaws.model.AuxCode;
import com.transerainc.adaws.model.CallAssociatedData.Data;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.PeerAgent;
import com.transerainc.adaws.service.BaseService;
import com.transerainc.aha.gen.agent.AgentCommandDocument;
import com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand;
import com.transerainc.aha.gen.agent.AgentDocument.Agent;
import com.transerainc.aha.gen.agent.AgentListDocument;
import com.transerainc.aha.gen.agent.AgentListDocument.AgentList;
import com.transerainc.aha.gen.agent.AuthenticateDocument.Authenticate;
import com.transerainc.aha.gen.agent.AuxiliaryInformationDocument.AuxiliaryInformation;
import com.transerainc.aha.gen.agent.CallAssociatedDataDocument.CallAssociatedData;
import com.transerainc.aha.gen.agent.ChannelTypes;
import com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage;
import com.transerainc.aha.gen.agent.ParamDocument.Param;
import com.transerainc.aha.gen.agent.StatusType;
import com.transerainc.aha.gen.agent.SubStatusType;
import com.transerainc.aha.gen.agent.XPathQueryDocument;
import com.transerainc.aha.gen.agent.XPathQueryDocument.XPathQuery;

/**
 * @author varsha.shivaram
 */
@Component
public class GenerateXmlUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(BaseService.class.getName());

    @Autowired
    private DesktopConfigManager agentDesktopConfigMap;

    private static XmlOptions xmlOptions = new XmlOptions().setSavePrettyPrint().setUseDefaultNamespace()
            .setSaveInner();
    private int idCount = 0;

    public String getAuthenticationMessage(final AdaRequest adaRequest) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Attempting authentication.");
        }
        String userName = adaRequest.getUserName();
        String enterpriseName = adaRequest.getTenant();

        userName = escape(userName);
        enterpriseName = escape(enterpriseName);

        final AgentListDocument agentListDoc = AgentListDocument.Factory.newInstance();
        final AgentList agentList = agentListDoc.addNewAgentList();
        final Authenticate authenticate = agentList.addNewAuthenticate();
        authenticate.setUsername(userName);
        authenticate.setEnterprise(enterpriseName);
        authenticate.setCasAuthenticated(true);
        agentList.setAuthenticate(authenticate);
        final String xmlString = agentListDoc.xmlText(xmlOptions);

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(adaRequest.getagentSessionId() + " :===>> Sending adas message: " + xmlString);
        }

        return xmlString;
    }

    /**
     * @param agentSessionId
     * @param queryString
     * @return
     */
    public String getXpathQueryXml(final String agentSessionId, final String queryString) {
        final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);

        final String agentId = desktopConfig.getAgentId();
        final String channelId = desktopConfig.getChannelId(ChannelType.Telephony.getName());

        final XPathQueryDocument xpathQueryDoc = XPathQueryDocument.Factory.newInstance();
        final XPathQuery xpathQuery = xpathQueryDoc.addNewXPathQuery();
        xpathQuery.setRequestId(createId(agentId));
        xpathQuery.setAgentId(agentId);
        xpathQuery.setChannelId(channelId);
        xpathQuery.setChannelType(ChannelTypes.Enum.forString(ChannelType.Telephony.getName()));
        xpathQuery.setQueryString(StringUtils.escapeXml(queryString));
        xpathQueryDoc.setXPathQuery(xpathQuery);

        final String xmlString = xpathQueryDoc.xmlText(xmlOptions);

        return xmlString;
    }

    /**
     * @param agentSessionId
     * @param transferType
     */
    public String getTransferListQueryString(final String agentSessionId, final String transferType) {
        final DesktopConfiguration desktopConfig = agentDesktopConfigMap.getConfigForAgent(agentSessionId);

        final String enterpriseId = desktopConfig.getEnterpriseId();
        final String siteId = desktopConfig.getSiteId();
        final String teamId = desktopConfig.getTeamId();

        final StringBuffer sb = new StringBuffer();
        sb.append("/transfer-list[@").append(ContextConstants.TENANT_ID).append("='");
        sb.append(enterpriseId).append("' ");
        sb.append(ContextConstants.AND_AT).append(ContextConstants.SITE_ID).append("='").append(siteId).append("' ");
        sb.append(ContextConstants.AND_AT).append(ContextConstants.TEAM_ID).append("='").append(teamId).append("' ");
        sb.append(ContextConstants.AND_AT).append(ContextConstants.TRANSFER_TYPE).append("='").append(transferType);
        if (transferType.equals(ContextConstants.VIRTUAL_TEAM)) {
            final String vteamId = desktopConfig.getCallModel().getVteamId();
            sb.append("' ");
            sb.append(ContextConstants.AND_AT).append(CallPropertyConstants.VIRTUAL_TEAM_ID).append("='")
                    .append(vteamId).append("']");
        } else {
            sb.append("']");
        }

        return sb.toString();
    }

    /**
     * @param agentSessionId
     * @param addChannelinfo
     * @return
     */
    public String updateAgentState(final String agentSessionId, final boolean addChannelinfo, final ChannelType channelType) {
        final DesktopConfiguration config = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
        if (config == null) {
        		return null;
        }
        final String xmlString;
        final AgentListDocument agentListDoc = AgentListDocument.Factory.newInstance();
        final AgentList agentList = agentListDoc.addNewAgentList();
        final Agent agent = agentList.addNewAgent();
        final String userId = clean(config.getAgentName());

        agent.setLoginUserId(userId);
        agent.setAgentId(clean(config.getAgentId()));
        agent.setSiteId(clean(config.getSiteId()));
        agent.setStatus(StatusType.Enum.forString(config.getStatus()));
        agent.setSubStatus(SubStatusType.Enum.forString(config.getSubStatus()));
        agent.setDn(clean(config.getDn()));
        agent.setTeamId(clean(config.getTeamId()));
        agent.setEnterpriseId(clean(config.getEnterpriseId()));
        agent.setHostIpAddress("");
        agent.setAgentsessionid(config.getAgentSessionId());
        agent.setPositionId("");
        if (addChannelinfo) {
            agent.setChannelId(config.getChannelId(channelType.getName()));
            agent.setChannelType(ChannelTypes.Enum.forString(channelType.getName()));
        }
        if (config.hasCallId()) {
            agent.setCallId(config.getStateChangeData().getCallId());
        }
        if (config.hasReason()) {
            agent.setReason(config.getStateChangeData().getReason());
        }
        if (config.hasRetry()) {
            agent.setRetry(StringUtils.convertToBoolean(config.getStateChangeData().getRetry()));
        }
        agent.setTimestamp(Calendar.getInstance().getTimeInMillis());
      
        int auxSetCount = 0; //ArrayIndex
        // Bug fix 18830
        // if (!ChannelStateConstant.AVAILABLE.equals(config.getSubStatus())) {
        	if (config.getStateChangeData().getIdleAuxCode() != null && config.getSubStatus().equals(ChannelStateConstant.IDLE)) { //let in if idle
                final AuxCode idleAux = config.getStateChangeData().getIdleAuxCode();
                
                // don't do anything if the id is not available
                if (idleAux != null && idleAux.getId() != null) {
                    if (idleAux.getId().trim().length() > 0) {
                        final AuxiliaryInformation auxiliaryInfo = agent.addNewAuxiliaryInformation();
                        auxiliaryInfo.setCode(Integer.parseInt(idleAux.getId()));
                        auxiliaryInfo.setCodeType(idleAux.getType());
                        auxiliaryInfo.setName(idleAux.getDesc());
                        agent.setAuxiliaryInformationArray(auxSetCount, auxiliaryInfo);
                        auxSetCount++;
                    }
                }
        }
        	//fix for #21115
        	final com.transerainc.adaws.model.CallAssociatedData cad = config.getStateChangeData().getCallAssociatedData();
        	if (cad != null && (config.getPrevState() != null && !config.getPrevState().equalsIgnoreCase(ChannelStateConstant.AVAILABLE))) {
        		final Map<String, com.transerainc.adaws.model.CallAssociatedData.Data> map = cad.getDataMap();
            if (map != null && !map.isEmpty()) {
            		int count = 0;
            		for (final com.transerainc.adaws.model.CallAssociatedData.Data data : map.values()) {
            			final CallAssociatedData callData = agent.addNewCallAssociatedData();
            			callData.setId(data.getId());
            			callData.setName(data.getName());
            			callData.setValue(data.getValue());
            			agent.setCallAssociatedDataArray(count, callData);
            			count++;
            		}
            	}
        }
        	if (config.getStateChangeData().getWrapUpAuxCode() != null && config.getPrevState()!=null && config.getPrevState().equals(ChannelStateConstant.WRAP_UP)) { //let in if the previous state is wrapUp
        		final AuxCode wrapUpAux = config.getStateChangeData().getWrapUpAuxCode();
        		config.setPrevState(null); //Introduced to fix 18940 keeping in mind prevSatate can be used later if required.
        		// don't do anything if the id is not available
        		if (wrapUpAux != null && wrapUpAux.getId() != null) {
        			if (wrapUpAux.getId().trim().length() > 0) {
        				final AuxiliaryInformation auxiliaryInfo = agent.addNewAuxiliaryInformation();
                    	auxiliaryInfo.setCode(Integer.parseInt(wrapUpAux.getId()));
                    	auxiliaryInfo.setCodeType(wrapUpAux.getType());
                    	auxiliaryInfo.setName(wrapUpAux.getDesc());
                    	try{
	                    	//if config.getSubStatus().equals(ChannelStateConstant.IDLE)
                    		agent.setAuxiliaryInformationArray(auxSetCount, auxiliaryInfo);
                    	}
                    	catch(IndexOutOfBoundsException e){
                    		LOGGER.error("IndexOutOfBoundsException");
                    	}
        			}
             }
        	}
 
        agentList.setAgentArray(0, agent);
        xmlString = agentListDoc.xmlText(xmlOptions);
        return xmlString;
    }

    /**
     * @param agentSessionId
     * @param commandName
     * @return
     */
    public String getAgentCommandXml(final String agentSessionId, final String commandName, final String callId) {
        final DesktopConfiguration config = agentDesktopConfigMap.getConfigForAgent(agentSessionId);

        LOGGER.info(agentSessionId + "===>> Inside getAgentCommandXml commandName : " + commandName);

        final AgentCommandDocument doc = AgentCommandDocument.Factory.newInstance();
        final AgentCommand agentCommand = doc.addNewAgentCommand();

        agentCommand.setName(commandName);
        agentCommand.setCallId(callId);
        agentCommand.setAgentId(config.getAgentId());
        agentCommand.setTeamId(config.getTeamId());
        agentCommand.setEnterpriseId(config.getEnterpriseId());
        agentCommand.setChannelId(config.getChannelId(ChannelType.Telephony.getName()));
        agentCommand.setChannelType(ChannelTypes.Enum.forString(ChannelType.Telephony.getName()));
        agentCommand.setAgentsessionid(config.getAgentSessionId());
        agentCommand.setTimestamp(System.currentTimeMillis());

        doc.setAgentCommand(agentCommand);
        final String xml = doc.xmlText(xmlOptions);

        LOGGER.info(agentSessionId + "===>> Request processed succesfully, getAgentCommandXml xml : " + xml);
        return xml;
    }

    /**
     * @param agentSessionId
     * @param commandName
     * @param destId
     * @param transferringAgentTuple
     * @param cad
     * @return
     */
    public String getVteamTargetedAgentCommandXml(final String agentSessionId, final String commandName,
            final String destId, final String transferringAgentTuple,
            final com.transerainc.adaws.model.CallAssociatedData cad) {
        final DesktopConfiguration config = agentDesktopConfigMap.getConfigForAgent(agentSessionId);

        final AgentCommandDocument doc = AgentCommandDocument.Factory.newInstance();
        final AgentCommand agentCommand = doc.addNewAgentCommand();

        agentCommand.setName(commandName);
        agentCommand.setCallId(config.getStateChangeData().getCallId());
        agentCommand.setVirtualTeamId(config.getCallModel().getVteamId());
        agentCommand.setAgentId(config.getAgentId());
        agentCommand.setTeamId(config.getTeamId());
        agentCommand.setEnterpriseId(config.getEnterpriseId());
        agentCommand.setChannelId(config.getChannelId(ChannelType.Telephony.getName()));
        agentCommand.setChannelType(ChannelTypes.Enum.forString(ChannelType.Telephony.getName()));
        agentCommand.setAgentsessionid(config.getAgentSessionId());
        agentCommand.setDestinationVirtualTeamId(destId);
        agentCommand.setTimestamp(System.currentTimeMillis());

        if (!transferringAgentTuple.isEmpty() && cad != null && !cad.isEmpty()) {
            final CommandMessage commandMessage = agentCommand.addNewCommandMessage();
            final Param param = commandMessage.addNewParam();
            param.setName(CallPropertyConstants.PARAM_TRANSFERRING_AGENT);
            param.setValue(transferringAgentTuple);

            final SortedMap<String, Data> map = cad.getDataMap();
            final List<Param> paramList = new ArrayList<Param>();
            for (final Data data : map.values()) {
                final Param dataParam = commandMessage.addNewParam();
                dataParam.setId(StringUtils.escapeXml(data.getId()));
                dataParam.setName(StringUtils.escapeXml(data.getName()));
                dataParam.setValue(StringUtils.escapeXml(data.getValue()));

                paramList.add(dataParam);
            }
            paramList.add(param);
            final Param paramArray[] = paramList.toArray(new Param[paramList.size()]);
            commandMessage.setParamArray(paramArray);
            agentCommand.setCommandMessage(commandMessage);
        }

        doc.setAgentCommand(agentCommand);
        final String xml = doc.xmlText(xmlOptions);

        LOGGER.info(agentSessionId + "===>> Request processed succesfully, getVteamTargetedAgentCommandXml xml : "
                + xml);
        return xml;
    }

    /**
     * @param agentSessionId
     * @param adaRequest
     * @param transferringAgentTuple
     * @param cad
     * @return
     */
    public String getAgentTargetedAgentCommandXml(final String agentSessionId, final AdaRequest adaRequest,
            final String transferringAgentTuple, final com.transerainc.adaws.model.CallAssociatedData cad) {
        final DesktopConfiguration config = agentDesktopConfigMap.getConfigForAgent(agentSessionId);

        final AgentCommandDocument doc = AgentCommandDocument.Factory.newInstance();
        final AgentCommand agentCommand = doc.addNewAgentCommand();

        String commandName = CallPropertyConstants.AGENT_TRANSFER;
        commandName = getCommandName(adaRequest, agentCommand, config.getPeerAgentDetails());

        agentCommand.setName(commandName);
        agentCommand.setCallId(config.getStateChangeData().getCallId());
        agentCommand.setAgentId(config.getAgentId());
        agentCommand.setTeamId(config.getTeamId());
        agentCommand.setEnterpriseId(config.getEnterpriseId());
        agentCommand.setChannelId(config.getChannelId(ChannelType.Telephony.getName()));
        agentCommand.setChannelType(ChannelTypes.Enum.forString(ChannelType.Telephony.getName()));
        agentCommand.setAgentsessionid(config.getAgentSessionId());
        agentCommand.setTimestamp(System.currentTimeMillis());

        if (!transferringAgentTuple.isEmpty() && cad != null && !cad.isEmpty()) {
            final CommandMessage commandMessage = agentCommand.addNewCommandMessage();
            final Param param = commandMessage.addNewParam();
            param.setName(CallPropertyConstants.PARAM_TRANSFERRING_AGENT);
            param.setValue(transferringAgentTuple);

            final SortedMap<String, Data> map = cad.getDataMap();
            final List<Param> paramList = new ArrayList<Param>();
            // ctq-accepted doesn't send other call parameters - check applet log
            if (!commandName.equals(CallStateConstants.CTQ_ACCEPTED)) {
                for (final Data data : map.values()) {
                    final Param dataParam = commandMessage.addNewParam();
                    dataParam.setId(StringUtils.escapeXml(data.getId()));
                    dataParam.setName(StringUtils.escapeXml(data.getName()));
                    if (CallPropertyConstants.LCM_CONTACT.equals(data.getName())) {
                        dataParam.setValue(data.getValue());
                    } else {
                        dataParam.setValue(StringUtils.escapeXml(data.getValue()));
                    }

                    paramList.add(dataParam);
                }
            }
            paramList.add(param);
            final Param paramArray[] = paramList.toArray(new Param[paramList.size()]);
            commandMessage.setParamArray(paramArray);
            agentCommand.setCommandMessage(commandMessage);
        }

        doc.setAgentCommand(agentCommand);
        final String xml = doc.xmlText(xmlOptions);

        LOGGER.info(agentSessionId + "===>> Request processed succesfully, getAgentTargetedAgentCommandXml xml : "
                + xml);
        return xml;
    }

    /**
     * @param agentSessionId
     * @param targetId
     * @return
     */
    public String getOutdialAgentCommand(final String agentSessionId, final String targetId, final String outDialAni, final String lcmContact) {
        final DesktopConfiguration config = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
        final String commandName = CallPropertyConstants.OUT_DIAL;
        final String callId = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();

        if (config.getStateChangeData() != null) {
            config.getStateChangeData().setCallId(callId);
        }

        final AgentCommandDocument doc = AgentCommandDocument.Factory.newInstance();
        final AgentCommand agentCommand = doc.addNewAgentCommand();

        agentCommand.setName(commandName);
        agentCommand.setCallId(callId);
        agentCommand.setAgentId(config.getAgentId());
        agentCommand.setPeerDn(targetId);
        agentCommand.setAgentDn(config.getDn());
        agentCommand.setVirtualTeamId(config.getOutdialVteam());
        agentCommand.setTeamId(config.getTeamId());
        agentCommand.setEnterpriseId(config.getEnterpriseId());
        agentCommand.setChannelId(config.getChannelId(ChannelType.Telephony.getName()));
        agentCommand.setChannelType(ChannelTypes.Enum.forString(ChannelType.Telephony.getName()));
        agentCommand.setAgentsessionid(config.getAgentSessionId());
        agentCommand.setTimestamp(System.currentTimeMillis());

        if (StringUtils.isNotEmpty(outDialAni)) {
    			addCommandParam(agentCommand,
    					CallPropertyConstants.SYSTEM_OUT_DIAL_ANI, outDialAni);
        }
    
        if (StringUtils.isNotEmpty(lcmContact)) {
        		addCommandParamNoEscape(agentCommand, 
        				CallPropertyConstants.LCM_CONTACT, lcmContact);
        }
        
        doc.setAgentCommand(agentCommand);
        final String xml = doc.xmlText(xmlOptions);

        LOGGER.info(agentSessionId + " :===>> XMl creation completed for getOutdialAgentCommand: " + xml);
        return xml;
    }
    
    /**
     * @param agentCommand
     * @param name
     * @param value
     * @return
     */
    private void addCommandParam(final AgentCommand agentCommand,
    		final String name, final String value) {
    		final Param dataParam = agentCommand.addNewParam();
    		// dataParam.setId(StringUtils.escapeXml(data.getId()));
    		dataParam.setName(StringUtils.escapeXml(name));
    		dataParam.setValue(StringUtils.escapeXml(value));
    	}

    /**
     * @param agentCommand
     * @param name
     * @param value
     * @return
     */
    private void addCommandParamNoEscape(final AgentCommand agentCommand,
    		final String name, final String value) {
    		final Param dataParam = agentCommand.addNewParam();
    		// dataParam.setId(data.getId());
    		dataParam.setName(name);
    		dataParam.setValue(value);
    	}
    
    /**
     * @param agentSessionId
     * @param onFlag
     * @return
     */
    public String getPrivacyShieldOn(final String agentSessionId, final boolean onFlag) {
        final DesktopConfiguration config = agentDesktopConfigMap.getConfigForAgent(agentSessionId);
        final String commandName = onFlag ? CallStateConstants.PAUSE : CallStateConstants.RESUME;

        final AgentCommandDocument doc = AgentCommandDocument.Factory.newInstance();
        final AgentCommand agentCommand = doc.addNewAgentCommand();

        agentCommand.setName(commandName);
        agentCommand.setCallId(config.getStateChangeData().getCallId());
        agentCommand.setAgentId(config.getAgentId());
        agentCommand.setTeamId(config.getTeamId());
        agentCommand.setEnterpriseId(config.getEnterpriseId());
        agentCommand.setChannelId(config.getChannelId(ChannelType.Telephony.getName()));
        agentCommand.setChannelType(ChannelTypes.Enum.forString(ChannelType.Telephony.getName()));
        agentCommand.setAgentsessionid(config.getAgentSessionId());
        agentCommand.setTimestamp(System.currentTimeMillis());

        doc.setAgentCommand(agentCommand);
        final String xml = doc.xmlText(xmlOptions);

        LOGGER.info(agentSessionId + " :===>> XMl creation completed for getPrivacyShieldOn: " + xml);
        return xml;
    }

    /**
     * @param adaRequest
     * @param agentCommand
     * @param peerAgentDetails
     * @return
     */
    private String getCommandName(final AdaRequest adaRequest, final AgentCommand agentCommand,
            final PeerAgent peerAgentDetails) {
        final String targetType = adaRequest.getTargetType();
        String commandName = CallPropertyConstants.AGENT_TRANSFER;
        final String peerDet = adaRequest.getTargetId();

        switch (adaRequest.getRedirectApi()) {
        case AdaConstants.REQUEST_CONSULT:
            commandName = CallStateConstants.CONSULT;
            updatePeerOnTargetType(targetType, "", peerDet, agentCommand);
            break;
        case AdaConstants.REQUEST_CONFERENCE:
            commandName = CallStateConstants.CONFERENCE_CONFERENCE;
            updatePeerDetails(targetType, peerDet, peerAgentDetails, agentCommand);
            break;
        case AdaConstants.REQUEST_CONSULT_TRANSFER:
            commandName = CallStateConstants.CONSULT_TRANSFER;
            updatePeerDetails(targetType, peerDet, peerAgentDetails, agentCommand);
            break;
        case AdaConstants.REQUEST_HOLD:
            commandName = AgentStateConstants.HOLD;
            break;
        case AdaConstants.REQUEST_CONSULT_END:
            commandName = CallStateConstants.END_CONSULT;
            break;
        case AdaConstants.REQUEST_CONSULT_TO_QUEUE_ACCEPTED:
            agentCommand.setPeerAgentId(peerDet);
            commandName = CallStateConstants.CTQ_ACCEPTED;
            break;
        default:
            commandName = updatePeerOnTargetType(targetType, commandName, peerDet, agentCommand);
        }

        return commandName;
    }

    /**
     * @param targetType
     * @param peerDet
     * @param peerAgent
     * @param agentCommand
     */
    private void updatePeerDetails(final String targetType, final String peerDet, final PeerAgent peerAgent,
            final AgentCommand agentCommand) {
        String peerId = peerDet;
        switch (targetType) {
        case ContextConstants.DN:
            agentCommand.setPeerDn(peerDet);
            break;
        case ContextConstants.QUEUE:
            if (peerAgent != null) {
                addPeerAgentInfo(agentCommand, peerAgent);
				// COV - 11944 DLS: Dead local store
            }
            break;
        default:
            agentCommand.setPeerAgentId(peerId);
        }
    }

    /**
     * @param agentCommand
     * @param peerAgent
     */
    private void addPeerAgentInfo(final AgentCommand agentCommand, final PeerAgent peerAgent) {
        agentCommand.setPeerTeamId(peerAgent.getTeamId());
        agentCommand.setPeerDn(peerAgent.getDn());
        agentCommand.setPeerAgentSessionId(peerAgent.getSessionId());
        agentCommand.setPeerChannelId(peerAgent.getChannelId());
        agentCommand.setPeerChannelType(peerAgent.getChannelType());
        agentCommand.setPeerAgentId(peerAgent.getAgentId());
    }

    /**
     * @param targetType
     * @param commandName
     * @param peerDet
     * @param agentCommand
     * @return
     */
    private String updatePeerOnTargetType(final String targetType, String commandName, final String peerDet,
            final AgentCommand agentCommand) {
        switch (targetType) {
        case ContextConstants.AGENT:
            agentCommand.setPeerAgentId(peerDet);
            break;
        case ContextConstants.QUEUE:
            agentCommand.setDestinationVirtualTeamId(peerDet);
            commandName = CallPropertyConstants.VT_TRANSFER;
            break;
        case ContextConstants.DN:
            agentCommand.setPeerDn(peerDet);
            break;
        }

        return commandName;
    }

    /**
     * @param value
     * @return
     */
    private String escape(final String value) {
        return StringUtils.escapeXml(value);
    }

    /**
     * @param agentId
     * @return
     */
    private synchronized String createId(final String agentId) {
        idCount++;
        return ContextConstants.QUERY_HIPHEN + agentId + "_" + idCount;
    }

    /**
     * @param s
     * @return
     */
    private String clean(final String s) {
        return StringUtils.isEmpty(s) ? "" : s;
    }

}
