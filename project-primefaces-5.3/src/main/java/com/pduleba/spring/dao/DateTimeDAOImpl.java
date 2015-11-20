package com.pduleba.spring.dao;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

@Repository
public class DateTimeDAOImpl implements DateTimeDAO {

	public LocalDateTime getLocalNow() {
		return LocalDateTime.now();
	}
	
}
