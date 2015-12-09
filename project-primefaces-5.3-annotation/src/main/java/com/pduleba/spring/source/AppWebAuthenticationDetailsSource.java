package com.pduleba.spring.source;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

public class AppWebAuthenticationDetailsSource extends WebAuthenticationDetailsSource {

	public static final Logger LOG = LoggerFactory.getLogger(AppWebAuthenticationDetailsSource.class);
	
	@Override
	public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
		LOG.info("WebAuthenticationDetails :: buildDetails");
		return super.buildDetails(context);
	}
}
