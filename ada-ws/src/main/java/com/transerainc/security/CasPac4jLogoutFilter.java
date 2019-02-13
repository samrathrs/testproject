package com.transerainc.security;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pac4j.core.config.Config;
import org.pac4j.core.context.J2EContext;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.ProfileManager;
import org.pac4j.springframework.security.web.LogoutFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tringuyen
 *
 */
public class CasPac4jLogoutFilter extends LogoutFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CasPac4jLogoutFilter.class.getName());

	private static final String CAS_IS_FROM_NEW_LOGIN_ATTRIBUTE_KEY = "isFromNewLogin";

	/**
	 * 
	 */
	public CasPac4jLogoutFilter() {
	}

	/**
	 * @param config
	 */
	public CasPac4jLogoutFilter(Config config) {
		super(config);
	}

	/**
	 * @param config
	 * @param defaultUrl
	 */
	public CasPac4jLogoutFilter(Config config, String defaultUrl) {
		super(config, defaultUrl);
	}

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain) throws IOException, ServletException {
    		LOGGER.debug(
    				"Invoking doFilter() with request: {} , response: {} , filterChain: {}",
    				request,
    				response,
    				filterChain
    				);
    		if (shouldFilter(request, response, filterChain)) {
    			LOGGER.info("Inside doFilter(), perform super's doFilter()");
        		super.doFilter(request, response, filterChain);
    		}
		LOGGER.info("Inside doFilter(), performing rest of filter chain's doFilter()");
		filterChain.doFilter(request, response);
    		return;
    }

	private boolean shouldFilter(final ServletRequest request, final ServletResponse response, FilterChain filterChain) {
		LOGGER.debug(
				"Invoking shouldFilter() with request: {} , response: {} , filterChain: {}",
				request,
				response,
				filterChain
				);
		boolean isFromNewLogin = true;
//		boolean isWithinThresholdTime = true;

		final WebContext context = new J2EContext((HttpServletRequest) request, (HttpServletResponse) response);
		final ProfileManager<CommonProfile> manager = new ProfileManager<CommonProfile>(context);
		List<CommonProfile> profiles = manager.getAll(true);
		
		LOGGER.info("Inside shouldFilter() with context = {}, manager = {}, profiles = {}", context, manager, profiles);
		
		for(CommonProfile profile : profiles) {
			Map<String, Object> profileAttributesMap =  profile.getAttributes();
			Set<Map.Entry<String, Object>> entrySet = profileAttributesMap.entrySet();
			for (Map.Entry<String, Object> entry : entrySet) {
				LOGGER.info(
						"Profile attribute Key: {} , Value: {} , for profile: {}",
						entry.getKey(),
						entry.getValue(),
						profile
						);
				if (CasPac4jLogoutFilter.CAS_IS_FROM_NEW_LOGIN_ATTRIBUTE_KEY.equals(entry.getKey())) {
					isFromNewLogin = Boolean.valueOf(entry.getValue().toString());
					LOGGER.info("Inside shouldFilter(), detected isFromNewLogin flag to be: {}", isFromNewLogin);
				} 
			}
		}

		LOGGER.debug("isFromNewLogin: {}",
				isFromNewLogin);

		if (!isFromNewLogin) {
			LOGGER.info("Inside shouldFilter() returning true");
			return true;
		} else {
			LOGGER.info("Inside shouldFilter() returning false");
			return false;
		}
	}
}
