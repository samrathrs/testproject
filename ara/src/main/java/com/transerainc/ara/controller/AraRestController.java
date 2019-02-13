/**
 * 
 */
package com.transerainc.ara.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.transerainc.ara.pojo.AgentStateRequest;
import com.transerainc.ara.pojo.AgentStateResponse;
import com.transerainc.ara.service.AgentService;

@RestController
public class AraRestController {
	private final Logger lgr = LoggerFactory.getLogger(AraRestController.class);

	@Autowired
	private AgentService agentService;

	@RequestMapping(value = "/acd/test/", method = RequestMethod.GET)
	public AgentStateResponse test() throws Exception {
		lgr.debug("Testing the controller");
		AgentStateResponse response = new AgentStateResponse();
		response.setAgentId(-1L);
		response.setStatus(true);
		return response;
	}

	@RequestMapping(value = "/acd/agent/{agentId}/setState", method = RequestMethod.POST)
	public AgentStateResponse setAgentState(@PathVariable Long agentId,
			@RequestBody AgentStateRequest asr) throws Exception {
		lgr.debug("Setting agent {} to state {} with aux code {}", agentId,
				asr.getState(), asr.getAuxCodeId());
		boolean success = agentService.setState(agentId, asr.getState(),
				asr.getAuxCodeId());
		AgentStateResponse response = new AgentStateResponse();
		response.setAgentId(agentId);
		response.setStatus(success);
		response.setTimestamp(System.currentTimeMillis());
		return response;
	}
}