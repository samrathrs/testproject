package com.transerainc.adaws.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.constants.AgentProfileConstants;
import com.transerainc.adaws.constants.AgentStateConstants;
import com.transerainc.adaws.constants.CallPropertyConstants;
import com.transerainc.adaws.constants.ChannelType;
import com.transerainc.adaws.model.CallAssociatedData;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.util.StringUtils;
import com.transerainc.aha.gen.agent.CommandMessageDocument.CommandMessage;
import com.transerainc.aha.gen.agent.ParamDocument.Param;

/**
 * @author rajeev.lochanam
 */
@Component
public class CommandMessageCommand implements AgentProfileConstants {

    private static Logger LOGGER = LoggerFactory.getLogger(CommandMessageCommand.class.getName());

    /**
     * @param commandMessage
     * @param callId
     * @param conf
     */
    public void processData(final CommandMessage commandMessage, final DesktopConfiguration desktopConf,
            final String callId) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Processing commandMessage for channel " + desktopConf.getChannelId(ChannelType.Telephony.getName()) + " and for call "
                    + desktopConf.getStateChangeData().getCallId());
        }
        updateWithElement(commandMessage, callId, desktopConf);
        // desktopConf.getStateChangeData().setCallAssociatedData(cad);

        if (desktopConf.getStatus().equals(AgentStateConstants.LOGGED_IN)
                && desktopConf.getSubStatus().equals(AgentStateConstants.CONNECTED)) {
            final CallAssociatedData.Data data = desktopConf.getStateChangeData().getCallAssociatedData().getDataMap()
                    .get(CallPropertyConstants.CONNECTION_ID);
            if (data != null) {
                desktopConf.getStateChangeData().setConnectionId(data.getValue());
            }

            final CallAssociatedData.Data sendIdData = desktopConf.getStateChangeData().getCallAssociatedData()
                    .getDataMap().get(CallPropertyConstants.SEND_ID);
            if (sendIdData != null) {
                desktopConf.getStateChangeData().setSendId(sendIdData.getValue());
            }
        }
    }

    /**
     * @param commandMessage
     * @param callId
     * @param conf
     */
    private void updateWithElement(final CommandMessage commandMessage, final String callId,
            final DesktopConfiguration conf) {
        CallAssociatedData cad = null;
        if (conf.getStateChangeData().getCallAssociatedData() != null) {
            cad = conf.getStateChangeData().getCallAssociatedData();
        } else {
            cad = new CallAssociatedData();
        }
        if (commandMessage.getParamArray() != null && commandMessage.getParamArray().length > 2) {
            final CallAssociatedData.Data data = cad.getDataMap().get(CallPropertyConstants.CALL_ID);
            if (data != null) {
                cad.putData(data.getId(), data.getName(), callId, data.isEditable());
            }

            final CallAssociatedData.Data connectionIdData = cad.getDataMap().get(CallPropertyConstants.CONNECTION_ID);
            if (connectionIdData != null) {
                cad.putData(connectionIdData.getId(), connectionIdData.getName(), conf.getStateChangeData()
                        .getConnectionId(), connectionIdData.isEditable());
            }

            final CallAssociatedData.Data sendIdData = cad.getDataMap().get(CallPropertyConstants.SEND_ID);
            if (sendIdData != null) {
                cad.putData(sendIdData.getId(), sendIdData.getName(), conf.getStateChangeData().getSendId(),
                        sendIdData.isEditable());
            }

            for (final Param param : commandMessage.getParamArray()) {
                final String id = StringUtils.isEmpty(param.getId()) ? "" : param.getId();
                final String name = StringUtils.isEmpty(param.getName()) ? "" : param.getName();
                final String value = StringUtils.isEmpty(param.getValue()) ? "" : param.getValue();
                final boolean isEditable = param.getEditable() ? true : false;

                cad.putData(id, name, value, isEditable);
            }
        } else if (conf.getStateChangeData() != null && conf.getStateChangeData().getCallAssociatedData() != null) {
            if (conf.getStateChangeData().getCallAssociatedData().getDataMap() != null
                    && !conf.getStateChangeData().getCallAssociatedData().getDataMap().isEmpty()) {
                final CallAssociatedData.Data data = cad.getDataMap().get(CallPropertyConstants.CALL_ID);
                if (data != null) {
                    cad.putData(data.getId(), data.getName(), callId, data.isEditable());
                }

                final CallAssociatedData.Data connectionIdData = cad.getDataMap().get(
                        CallPropertyConstants.CONNECTION_ID);
                if (connectionIdData != null) {
                    cad.putData(connectionIdData.getId(), connectionIdData.getName(), conf.getStateChangeData()
                            .getConnectionId(), connectionIdData.isEditable());
                }

                final CallAssociatedData.Data sendIdData = cad.getDataMap().get(CallPropertyConstants.SEND_ID);
                if (sendIdData != null) {
                    cad.putData(sendIdData.getId(), sendIdData.getName(), conf.getStateChangeData().getSendId(),
                            sendIdData.isEditable());
                }
            }
        }
        conf.getStateChangeData().setCallAssociatedData(cad);
    }

    /**
     * @param callId
     * @param conf
     */
    public void processData(final String callId, final DesktopConfiguration conf) {
        if (conf.getStateChangeData() != null && conf.getStateChangeData().getCallAssociatedData() != null) {
            if (conf.getStateChangeData().getCallAssociatedData().getDataMap() != null
                    && !conf.getStateChangeData().getCallAssociatedData().getDataMap().isEmpty()) {
                final CallAssociatedData cad = conf.getStateChangeData().getCallAssociatedData();
                final CallAssociatedData.Data data = cad.getDataMap().get(CallPropertyConstants.CALL_ID);
                if (data != null) {
                    cad.putData(data.getId(), data.getName(), callId, data.isEditable());
                }

                final CallAssociatedData.Data connectionIdData = cad.getDataMap().get(
                        CallPropertyConstants.CONNECTION_ID);
                if (connectionIdData != null) {
                    cad.putData(connectionIdData.getId(), connectionIdData.getName(), conf.getStateChangeData()
                            .getConnectionId(), connectionIdData.isEditable());
                }

                final CallAssociatedData.Data sendIdData = cad.getDataMap().get(CallPropertyConstants.SEND_ID);
                if (sendIdData != null) {
                    cad.putData(sendIdData.getId(), sendIdData.getName(), conf.getStateChangeData().getSendId(),
                            sendIdData.isEditable());
                }

                conf.getStateChangeData().setCallAssociatedData(cad);
            }
        }

    }

}
