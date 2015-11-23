package com.pduleba.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
class LogServiceImpl implements LogService {

	private static Logger LOG = LoggerFactory.getLogger(LogServiceImpl.class);
	
	@Override
	public void logDebug(String msg) {
		if (LOG.isDebugEnabled()) {
			LOG.info(msg);
		}
	}

}
