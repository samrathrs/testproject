package com.transerainc.adaws.config;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.Session;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

/**
 * @author tnguyen
 *
 */

@EnableSpringHttpSession
public class SpringHttpSessionConfig {

	@Bean
	public MapSessionRepository sessionRepository() {
		return new MapSessionRepository(new HashMap<String, Session>());
	}

}
