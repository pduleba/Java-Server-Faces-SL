package com.pduleba.spring.service;

import static java.util.Objects.isNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pduleba.spring.dao.DateTimeDAO;

@Service
public class TimeServiceImpl implements TimeService {

	private static final String NOT_FOUND = "N/A";
	@Autowired
	private DateTimeDAO dateTimeDao;

	@Override
	public String getCurrentDateString() {
		LocalDateTime now = dateTimeDao.getLocalNow();

		return isNull(now) ? NOT_FOUND : now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

}
