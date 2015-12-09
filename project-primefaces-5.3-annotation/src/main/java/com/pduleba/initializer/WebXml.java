package com.pduleba.initializer;

import java.util.EnumSet;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.pduleba.config.SpringConfig;

public class WebXml implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// Spring
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(SpringConfig.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));

		// RequestContextListener
		servletContext.addListener(new RequestContextListener());

		// security filter
		DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy("springSecurityFilterChain");
		FilterRegistration.Dynamic securityFilterDynamic = servletContext.addFilter("securityFilter",
				delegatingFilterProxy);
		securityFilterDynamic.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

		// JSF
		FacesServlet facesServlet = new FacesServlet();
		ServletRegistration.Dynamic facesServletDynamic = servletContext.addServlet("facesServlet", facesServlet);
		facesServletDynamic.setLoadOnStartup(1);
		facesServletDynamic.addMapping("/faces/*");
		facesServletDynamic.addMapping("*.jsf");
		facesServletDynamic.addMapping("*.xhtml");
	}

}
