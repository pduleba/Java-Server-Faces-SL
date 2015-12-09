package com.pduleba.spring.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class AppLogoutSuccessHandler implements LogoutSuccessHandler {

	public static final Logger LOG = LoggerFactory.getLogger(AppLogoutSuccessHandler.class);
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		LOG.info("AppLogoutSuccessHandler :: onLogoutSuccess");
	}

}
