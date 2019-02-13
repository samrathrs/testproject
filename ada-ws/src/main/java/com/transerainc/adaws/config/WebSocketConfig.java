package com.transerainc.adaws.config;

import java.time.Instant;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.MapSession;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.Session;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.session.web.socket.config.annotation.AbstractSessionWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author varsha.shivaram
 */
@Configuration
@EnableScheduling
@EnableWebSocketMessageBroker
public class WebSocketConfig 
		extends AbstractSessionWebSocketMessageBrokerConfigurer<Session> {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketConfig.class.getName());

	@Autowired
	private MapSessionRepository sessionRepository;

	@Bean
	public ChannelInterceptorAdapter sessionContextChannelInterceptorAdapter() {
		return new ChannelInterceptorAdapter() {
			@Override
			public Message<?> preSend(Message<?> message, MessageChannel channel) {
				Map<String, Object> sessionHeaders = SimpMessageHeaderAccessor.getSessionAttributes(message.getHeaders());
				String sessionId = (String) sessionHeaders.get(SessionRepositoryFilter.SESSION_REPOSITORY_ATTR);
				if (sessionId != null) {
					MapSession session = sessionRepository.findById(sessionId);
					if (session != null) {
						LOGGER.debug("Session from sessionRepository is not null with session id: {}", sessionId);
						session.setLastAccessedTime(Instant.now());
						sessionRepository.save(session);
						LOGGER.debug("Session is saved into sessionRepository with session id: {}", sessionId);
					} else {
						LOGGER.debug("Session from sessionRepository is null with session id: {}", sessionId);
						session = sessionRepository.createSession();
						session.setId(sessionId);
						sessionRepository.save(session);
						LOGGER.debug("Session is created and saved into sessionRepository with sesssion id: {}", sessionId);
					}
				}
				return super.preSend(message, channel);
			}
		};
	}

	@Override
	public void configureClientInboundChannel(ChannelRegistration registration) {
		registration.setInterceptors(sessionContextChannelInterceptorAdapter());
	} 


	@Override
	protected void configureStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/application").
					addInterceptors(new HttpSessionIdHandshakeInterceptor()).
					setAllowedOrigins("*").
					withSockJS().
					setClientLibraryUrl("../ccone-ad/node_modules/sockjs-client/dist/sockjs.min.js")
					;
	}

	/**
	 * @param config
	 */
	@Override
	public void configureMessageBroker(final MessageBrokerRegistry config) {
		
		config.enableSimpleBroker("/topic/", "/update/");
		config.setApplicationDestinationPrefixes("/app");
;
	}

}
