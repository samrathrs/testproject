/**
 * 
 */
package com.transerainc.adaws.command.factory;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.exception.InterpretationException;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.TacgResponse;
import com.transerainc.adaws.util.DocHelper;

/**
 * @author rajeev.lochanam
 */
@Component
public class CommandFactory {

    @Autowired
    private MessageCommandFactory commandMessageFactory;

    @Autowired
    private AgentCommandFactory agentCommandFactory;

    @Autowired
    private XmlCommandFactory xmlCommandFactory;

    @Autowired
    private DocHelper docHelper;

    /**
     * @param tacgResp
     * @return
     * @throws InterpretationException
     * @throws JSONException
     */
    public AdaResponse callCommandFactory(final TacgResponse tacgResp) throws InterpretationException, JSONException {
        final Document doc = docHelper.xmlToDom(tacgResp.getXml());
        final Element docElem = doc.getDocumentElement();
        final String rootElemName = docElem.getNodeName();

        tacgResp.setElement(docElem);

        AdaResponse adaResponse = null;
        if (CommandConstants.AGENT_COMMAND.equals(rootElemName)) {

            adaResponse = commandMessageFactory.getCommand(tacgResp);
        } else if (CommandConstants.AGENT_LIST.equals(rootElemName)) {

            adaResponse = agentCommandFactory.getCommand(tacgResp);
        } else {

            adaResponse = xmlCommandFactory.getCommand(tacgResp);
        }

        return adaResponse;
    }
}
