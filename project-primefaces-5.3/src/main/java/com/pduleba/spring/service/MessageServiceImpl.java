package com.pduleba.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
public @Data class MessageServiceImpl implements MessageService {
	
	@Autowired
	private TimeService timeService;
	
	@Override
	public String getMessage(String input) {
		return new StringBuilder("Input = ").append(input).append(" on ").append(timeService.getCurrentDateString())
				.toString();
	}

}
