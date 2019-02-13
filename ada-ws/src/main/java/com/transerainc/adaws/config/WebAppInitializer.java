/**
 *
 */
package com.transerainc.adaws.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import com.transerainc.adaws.filter.DmzFilter;
import com.transerainc.security.SecurityConfiguration;

/**
 * @author suresh.kumar
 */
public class WebAppInitializer extends AbstractHttpSessionApplicationInitializer {

	public WebAppInitializer() {
		super(SpringHttpSessionConfig.class);
	}

	@Override
	public void onStartup(final ServletContext container) {

		// Create the 'root' Spring application context
		final AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(SecurityConfiguration.class, PropertiesConfig.class);

		// Manage the lifecycle of the root application context
		container.addListener(new ContextLoaderListener(rootContext));
		
		// Security settings
		container.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain"))
		.addMappingForUrlPatterns(null, false, 
				"/*", 
				"/ccone-*/", 
				"/ccone-*/*");
		
		// Create the dispatcher servlet's Spring application context
		final AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.setServletContext(container);
		dispatcherContext.setParent(rootContext);
		dispatcherContext.register(SecurityConfiguration.class, WebAppConfig.class);

		// Register and map the dispatcher servlet
		final ServletRegistration.Dynamic dispatcher = container.addServlet("ada-ws", new DispatcherServlet(
				dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		dispatcher.setAsyncSupported(true);

		final DelegatingFilterProxy filterProxy = new DelegatingFilterProxy("dmzFilter", dispatcherContext);
		filterProxy.setTargetFilterLifecycle(true);

		final FilterRegistration.Dynamic dmzFilter = container.addFilter("dmzFilter", DmzFilter.class);
		dmzFilter.addMappingForUrlPatterns(null, false, "/nondmz/*");
		dmzFilter.setAsyncSupported(true);

	}
}
