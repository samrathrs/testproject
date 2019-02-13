package com.transerainc.security;

import org.jasig.cas.client.session.SingleSignOutFilter;
import org.pac4j.core.config.Config;
import org.pac4j.springframework.security.web.CallbackFilter;
import org.pac4j.springframework.security.web.Pac4jEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.header.HeaderWriter;
import org.springframework.security.web.header.writers.CacheControlHeadersWriter;
import org.springframework.security.web.header.writers.DelegatingRequestMatcherHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.session.Session;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.session.MapSessionRepository;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import java.util.HashMap;

/**
 * @author tnguyen
 *
 */
@Configuration
@EnableWebSecurity
@EnableAsync
@EnableScheduling
@ComponentScan("com.transerainc.security")
@Order(value=1)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfiguration.class.getName());

	@Value("${auth.cas.server.url}")
	private String casServerUrl;

	@Value("${auth.cas.server.logout.successful.url}")
	private String casServerlogoutSuccessfulUrl;

	@Autowired
	private Config config;
	
	@Autowired
	private SingleSignOutFilter singleLogoutFilter;

	@Autowired
	@Qualifier("logoutHandler")
	private LogoutHandler logoutHandler;
	
	//@Autowired
	private MapSessionRepository sessionRepository;
	
	private org.springframework.security.web.authentication.logout.LogoutFilter springSecurityFrameworkLogoutFilter;
	
	private CasPac4jLogoutFilter pac4jLogoutFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		LOGGER.info("Security Configuration http being configured.");

        sessionRepository = new MapSessionRepository(new HashMap<String, Session>());
		final Pac4jEntryPoint pac4jEntryPoint = new Pac4jEntryPoint(config, "CasClient");
		final CallbackFilter callbackFilter = new CallbackFilter(config);
		callbackFilter.setMultiProfile(false);
		callbackFilter.setRenewSession(false);

		singleLogoutFilter.setCasServerUrlPrefix(casServerUrl);

		springSecurityFrameworkLogoutFilter = new org.springframework.security.web.authentication.logout.LogoutFilter(
				casServerlogoutSuccessfulUrl, 
				logoutHandler
				);

		http.headers().frameOptions().disable();

		// Disable Spring Security's default Cache Control behavior to include the following headers
		/*
		 * Cache-Control: no-cache, no-store, max-age=0, must-revalidate
		 * Pragma: no-cache		 * 
		 */
		// Selectively disable Cache-Control and Pragma ==> no-cache, only for fonts
		RequestMatcher eotFontRequestMatcher = new AntPathRequestMatcher("/**/*.eot");
		RequestMatcher ttfFontRequestMatcher = new AntPathRequestMatcher("/**/*.ttf");
		RequestMatcher woffFontRequestMatcher = new AntPathRequestMatcher("/**/*.woff");
		RequestMatcher fontRequestMatcher = new OrRequestMatcher(
											eotFontRequestMatcher,
											ttfFontRequestMatcher,
											woffFontRequestMatcher
													);
		RequestMatcher notResourcesMatcher = new NegatedRequestMatcher(fontRequestMatcher);
		HeaderWriter notResourcesHeaderWriter = new DelegatingRequestMatcherHeaderWriter(notResourcesMatcher , new CacheControlHeadersWriter());
		http
			.headers()
			.cacheControl()
			.disable()
			.addHeaderWriter(notResourcesHeaderWriter)
			;
		

		pac4jLogoutFilter = new CasPac4jLogoutFilter(config);
		pac4jLogoutFilter.setDestroySession(true);
		pac4jLogoutFilter.setLocalLogout(true);
		pac4jLogoutFilter.setCentralLogout(true);

		http
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

		http
			.authorizeRequests()
				.antMatchers(
					"/", 
					"/ccone-*/views/components/", 
					"/ccone-*/views/components/*.html", 
					"/ccone-*/index.html"
					)
			.authenticated()
				.and()
			.exceptionHandling().authenticationEntryPoint(pac4jEntryPoint)
				.and()
			.addFilterBefore(new SessionRepositoryFilter(sessionRepository), ChannelProcessingFilter.class)
			.addFilterBefore(callbackFilter, BasicAuthenticationFilter.class)
			.addFilterBefore(springSecurityFrameworkLogoutFilter, org.springframework.security.web.authentication.logout.LogoutFilter.class)
			.addFilterBefore(singleLogoutFilter, CasAuthenticationFilter.class)
			.csrf().disable()
			.logout()
				.invalidateHttpSession(true)
				.deleteCookies("TGC", "TGT")
		;

		LOGGER.info("Finished configuring Security Configuration http: {}", http);
	}

	@Bean
	public SingleSignOutFilter singleLogoutFilter() {
		final SingleSignOutFilter singleSignOutFilter = new SingleSignOutFilter();
		return singleSignOutFilter;
	}

}
