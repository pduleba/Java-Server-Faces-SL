package com.pduleba.web;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pduleba.spring.dao.model.UserModel;
import com.pduleba.spring.service.LogService;
import com.pduleba.spring.service.TimeService;
import com.pduleba.spring.service.UserService;

import lombok.Data;

@ManagedBean(name = "sessionBean", eager = true)
@SessionScoped
@Component
public @Data class SessionBean implements Serializable {

	private static final long serialVersionUID = 1549481937223946546L;

	private String name;
	
	private String time;

	private List<UserModel> users = new ArrayList<>();
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TimeService timeService;
	
	@Autowired
	private LogService logService;

	public String doAction() {
		logService.logDebug("doAction :: starting...");
		
		setTime(timeService.getCurrentDateString());
		userService.createUser(this.name);
		users = userService.getUsers();
		logService.logDebug("doAction :: complete");
		
		return "response";
	}
}
