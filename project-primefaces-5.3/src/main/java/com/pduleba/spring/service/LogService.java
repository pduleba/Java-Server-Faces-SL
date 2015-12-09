package com.pduleba.spring.service;

public interface LogService {

	void logInfo(String string);

	void logError(String string, Throwable t);
}
