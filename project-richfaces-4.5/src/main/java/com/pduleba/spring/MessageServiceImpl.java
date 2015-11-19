package com.pduleba.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public @Data class MessageServiceImpl implements MessageService {
	
	@Autowired
	private TimeService timeService;
	
	@Override
	public String getMessage(String input) {
		return new StringBuilder("Input = ").append(input).append(" on ").append(timeService.getCurrentDateString())
				.toString();
	}

}
