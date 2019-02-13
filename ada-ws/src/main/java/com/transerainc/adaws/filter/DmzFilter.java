package com.transerainc.adaws.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.SpringContextHelper;

// @Component("dmzFilter")
public class DmzFilter implements Filter {

	private final Logger LOGGER = LoggerFactory.getLogger(DmzFilter.class);

	public DmzFilter() {
		LOGGER.info("DMZ filter CREATED");
	}

	@Override
	public void init(final FilterConfig config) throws ServletException {
		LOGGER.info("DMZ filter INITALIZED");
	}

	@Override
	public void destroy() {
		LOGGER.info("DMZ filter DESTROYED");
	}

	@Override
	public void doFilter(final ServletRequest request,
			final ServletResponse response, final FilterChain filterChain)
			throws IOException, ServletException {

		final HttpServletRequest req = (HttpServletRequest) request;
		final HttpServletResponse res = (HttpServletResponse) response;

		final String uri = req.getRequestURI();
		final String url = req.getRequestURL().toString();

		boolean validRequest = true;

		LOGGER.debug("Verifying request url {} and uri {}", url, uri);

		final PropertiesUtil propertiesUtil = SpringContextHelper
				.getBean(PropertiesUtil.class);
		final int nonDmzPort = NumberUtils
				.toInt(propertiesUtil.getAdaProperty(AdaConstants.NON_DMZ_PORT));

		if (StringUtils.startsWith(uri, "/ada-ws/nondmz")
				|| StringUtils.contains(uri, "nondmz")
				|| StringUtils.startsWith(uri, "/ada-ws/handleTacgResponse")) {
			final int requestLocalPort = request.getLocalPort();
			validRequest = requestLocalPort == nonDmzPort;
		}

		if (validRequest) {
			filterChain.doFilter(request, response);
		} else {
			LOGGER.debug("Port does not match. Disallowing the request");
			res.setStatus(404);
		}
	}

}
