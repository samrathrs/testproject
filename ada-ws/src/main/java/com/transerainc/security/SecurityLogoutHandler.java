package com.transerainc.security;


import static org.pac4j.core.util.CommonHelper.assertNotBlank;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.pac4j.core.client.Client;
import org.pac4j.core.client.Clients;
import org.pac4j.core.config.Config;
import org.pac4j.core.context.HttpConstants;
import org.pac4j.core.context.J2EContext;
import org.pac4j.core.context.Pac4jConstants;
import org.pac4j.core.context.session.SessionStore;
import org.pac4j.core.exception.HttpAction;
import org.pac4j.core.http.J2ENopHttpActionAdapter;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.ProfileManager;
import org.pac4j.core.redirect.RedirectAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

/**
 * @author tringuyen
 *
 */
@Component("logoutHandler")
public class SecurityLogoutHandler extends SecurityContextLogoutHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(SecurityLogoutHandler.class.getName());

    @Value("${auth.cas.server.logout.successful.url}")
    private String casServerlogoutSuccessfulUrl;

    @Autowired
    private Config config;

    /* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.logout.LogoutHandler#logout(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
	 */
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		LOGGER.info("Custom Spring LogoutHandler invoked!");
		
		HttpSession session = request.getSession(false);
		if (session != null) {
			LOGGER.info("Invalidating session: " + session.getId());
			session.invalidate();
		}

		SecurityContext context = SecurityContextHolder.getContext();
		if (context != null) {
			LOGGER.info("Setting authentication to null, context: {}" + context);
			context.setAuthentication(null);
		}
	
		SecurityContextHolder.clearContext();
		
		try {
			request.logout();
		} catch (ServletException e) {
			LOGGER.info("Error logging out using request.logout(): {}", e.toString());
		}

		super.logout(request, response, authentication);

		LOGGER.info("Custom Spring LogoutHandler finished processing!");
	}

	protected void performLogout(
									final J2EContext context, 
									final Config config, 
									final String defaultUrl, 
									final String inputLogoutUrlPattern, 
									final Boolean inputLocalLogout,
									final Boolean inputDestroySession, 
									final Boolean inputCentralLogout,
									final ProfileManager<CommonProfile> manager, 
									final List<CommonProfile> profiles
	) {
		LOGGER.debug("=== LOGOUT ===");
		
		// default values
		final String logoutUrlPattern;
		if (inputLogoutUrlPattern == null) {
		   logoutUrlPattern = Pac4jConstants.DEFAULT_LOGOUT_URL_PATTERN_VALUE;
		} else {
		   logoutUrlPattern = inputLogoutUrlPattern;
		}
		final boolean localLogout;
		if (inputLocalLogout == null) {
		   localLogout = true;
		} else {
		   localLogout = inputLocalLogout;
		}
		final boolean destroySession;
		if (inputDestroySession == null) {
		   destroySession = false;
		} else {
		   destroySession = inputDestroySession;
		}
		final boolean centralLogout;
		if (inputCentralLogout == null) {
		   centralLogout = false;
		} else {
		   centralLogout = inputCentralLogout;
		}
		
		// checks for non-null
		if (
				(context != null)													&& 
				(config != null)														&& 
				(org.apache.commons.lang3.StringUtils.isNotBlank(logoutUrlPattern))	&& 
				(config.getClients() != null)
		) {
			final Clients configClients = config.getClients();
			
			// compute redirection URL
			final String url = context.getRequestParameter(Pac4jConstants.URL);
			String redirectUrl = defaultUrl;
			if (url != null && Pattern.matches(logoutUrlPattern, url)) {
			   redirectUrl = url;
			}
			LOGGER.debug("redirectUrl: {}", redirectUrl);
			HttpAction action;
			if (redirectUrl != null) {
			   action = HttpAction.redirect("redirect", context, redirectUrl);
			} else {
			   action = HttpAction.ok("ok", context);
			}

			// local logout if requested or multiple profiles
			try {
				if (localLogout || profiles.size() > 1) {
				   LOGGER.debug("Performing application logout");
				   try {
					   if (destroySession) {
						   final SessionStore sessionStore = context.getSessionStore();
						   if (sessionStore != null) {
							   final boolean removed = sessionStore.destroySession(context);
							   if (!removed) {
								   LOGGER.error("Unable to destroy the web session. The session store may not support this feature");
							   }
						   } else {
							   LOGGER.error("No session store available for this web context");
						   }
					   }
				   } catch (Exception exception) {
						LOGGER.warn("Error with sessionStore localLogout: cause: {}, toString: {}", exception.getMessage(), exception.toString());
				   }
				   try {
					   manager.logout();
				   } catch (Exception exception) {
						LOGGER.warn("Error with manager localLogout: cause: {}, toString: {}", exception.getMessage(), exception.toString());
				   }
				}
			} catch (Exception exception) {
				LOGGER.warn("Error with localLogout: cause: {}, toString: {}", exception.getMessage(), exception.toString());
			}
			
			// central logout
			try {
				if (centralLogout) {
				   LOGGER.debug("Performing central logout");
				   for (final CommonProfile profile : profiles) {
					   LOGGER.debug("Profile: {}", profile);
					   final String clientName = profile.getClientName();
					   if (clientName != null) {
						   final Client client = configClients.findClient(clientName);
						   if(client != null) {
							   final String targetUrl;
							   if (redirectUrl != null && (redirectUrl.startsWith(HttpConstants.SCHEME_HTTP) || redirectUrl.startsWith(HttpConstants.SCHEME_HTTPS))) {
								   targetUrl = redirectUrl;
							   } else {
								   targetUrl = null;
							   }
							   final RedirectAction logoutAction = client.getLogoutAction(context, profile, targetUrl);
							   LOGGER.debug("Logout action: {}", logoutAction);
							   if (logoutAction != null) {
								   action = logoutAction.perform(context);
								   break;
							   }
						   }
					   }
				   }
				}
			} catch (Exception exception) {
				LOGGER.warn("Error with centralLogout: cause: {}, toString: {}", exception.getMessage(), exception.toString());
			}
			
			J2ENopHttpActionAdapter.INSTANCE.adapt(action.getCode(), context);
		}

		LOGGER.debug("Finished logging out");
	}

	public void invalidateSession(
									final J2EContext j2eContext, 
									final ProfileManager<CommonProfile> profileManager, 
									final List<CommonProfile> commonProfilesList, 
									final HttpSession httpSession, 
									final SecurityContext securityContext
	) {
		LOGGER.info(
						"Invalidating sesssion with "			+ 
						"j2eContext: {} , "						+ 
						"profileManager: {} , "					+ 
						"commonProfilesList: {} , "				+ 
						"httpSession: {} , "						+ 
						"securityContext: {}",
						j2eContext, 
						profileManager, 
						commonProfilesList, 
						httpSession, 
						securityContext
				);

		performLogout(j2eContext, config, casServerlogoutSuccessfulUrl, null, true, true, true, profileManager, commonProfilesList);

        LOGGER.info("Http Session: {}", httpSession);
        if (httpSession != null) {
            LOGGER.info("Invalidating session: " + httpSession.getId());
            httpSession.removeAttribute("User");
            httpSession.invalidate();
        }

        LOGGER.info("SecurityContext: {}", securityContext);
        if (securityContext != null) {
            LOGGER.info("Setting authentication to null, context: {}" + securityContext);
            securityContext.setAuthentication(null);
            SecurityContextHolder.setContext(securityContext);
        }
	    SecurityContextHolder.clearContext();

	    LOGGER.info("Custom Spring LogoutHandler invalidateSession() finished processing!");
	}

}
