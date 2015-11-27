package com.pduleba.spring.request.cache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class AppRequestCache implements RequestCache {

	public static final Logger LOG = LoggerFactory.getLogger(AppRequestCache.class);
	
	@Override
	public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
		LOG.info("AppRequestCache :: saveRequest");
	}

	@Override
	public SavedRequest getRequest(HttpServletRequest request, HttpServletResponse response) {
		LOG.info("AppRequestCache :: getRequest");
		return null;
	}

	@Override
	public HttpServletRequest getMatchingRequest(HttpServletRequest request, HttpServletResponse response) {
		LOG.info("AppRequestCache :: getMatchingRequest");
		return request;
	}

	@Override
	public void removeRequest(HttpServletRequest request, HttpServletResponse response) {
		LOG.info("AppRequestCache :: removeRequest");
	}

}
