package com.transerainc.adaws.util;

/*
 * Created on Mar 12, 2009
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

/**
 * @author <a href="mailto:kumar.pandey@transerainc.com">Kumar Pandey</a>
 * @version $Revision: 1.2.2.1 $
 */

public class CssCustomization {
	// private static final String TENANT_DOMAIN = "tenantDomain";
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CssCustomization.class);

	private static Pattern allowedTenantPattern;

	static {
		allowedTenantPattern = Pattern.compile("[a-zA-z0-9_\\-]+");
	}

	/**
	 * This api returns the tenant domain name and sets it in the cookie as well
	 * if name is obtained. Give priority to the key/value param in url request
	 * if key tenant exists
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public static final String getTenantDomain(final HttpServletRequest request,
			final HttpServletResponse response) {
		// 1. Check the cookie for the tenant.domain
		// 2. If not available check the request parameter in the query string

		String tenantDomain = request.getParameter("tenant");

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(
					"request.getParameter(tenant) returned : " + tenantDomain);
		}
		// if request has tenantDomain create cookie and send to client
		if (!StringUtils.isBlank(tenantDomain)) {
			tenantDomain = sanitizeTenant(tenantDomain);
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info(
						"tenantDomain is not blank thus setting it in cookie");
			}
			final Cookie cookie = new Cookie("tenantDomain", tenantDomain);
			cookie.setComment("Tenant domain is indicated by this cookie");
			cookie.setPath("/");
			cookie.setHttpOnly(true);
			// cookie.setSecure(true);
			if (request.getRequestURL().toString().contains("https")) {
				cookie.setSecure(true);
			}
			cookie.setMaxAge(Integer.MAX_VALUE);
			response.addCookie(cookie);
			if (tenantDomain == null) {
				return "";
			} else {
				return tenantDomain;
			}
		}
		// if not available in requestParam then check cookie
		final Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			for (final Cookie cookie : cookies) {
				if ("tenantDomain".equals(cookie.getName())) {
					tenantDomain = cookie.getValue();
				}
			}
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info(
						"tenantDomain returned from cookie : " + tenantDomain);
			}
		}
		tenantDomain = sanitizeTenant(tenantDomain);
		if (tenantDomain == null) {
			return "";
		} else {
			return tenantDomain;
		}
	}

	/**
	 * @param tenantDomain
	 */
	private static String sanitizeTenant(String tenantDomain) {
		if (!StringUtils.isBlank(tenantDomain)) {
			Matcher matcher = allowedTenantPattern.matcher(tenantDomain);
			if (!matcher.matches()) {
				return "";
			}
		}
		return tenantDomain;
	}

}
