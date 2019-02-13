package com.transerainc.adaws.config;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

public class HttpSessionIdHandshakeInterceptor implements HandshakeInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(HttpSessionIdHandshakeInterceptor.class.getName());

	@Override
	public void afterHandshake(ServerHttpRequest arg0, ServerHttpResponse arg1, WebSocketHandler arg2, Exception arg3) {
	}

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, 
			ServerHttpResponse response, 
			WebSocketHandler wsHandler, 
			Map<String, Object> attributes) throws Exception {
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			HttpSession session = servletRequest.getServletRequest().getSession(false);
			if (session != null) {
				LOGGER.debug("HttpSession Timeout is: {} seconds", session.getMaxInactiveInterval());
				attributes.put(SessionRepositoryFilter.SESSION_REPOSITORY_ATTR, session.getId());
			} else {
				LOGGER.debug("HttpSession is NULL");
			}
		}
		return true;	
	}

}
