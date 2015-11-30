package com.pduleba.web;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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

	public String showUsers() {
		logService.logInfo("showUsers :: starting...");
		setTime(timeService.getCurrentDateString());
		setUsers(userService.getUsers());
		logService.logInfo("showUsers :: complete");
		
		return "/views/user/response?faces-redirect=true";
	}

	public String createUser() {
		logService.logInfo("createUser :: starting...");
		setTime(timeService.getCurrentDateString());
		boolean success = userService.createUser(new UserModel(name));
		logService.logInfo("createUser :: complete");
		
		if (success) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Success", new StringBuilder("User ").append(name).append(" created!").toString()));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					new StringBuilder("User ").append(name).append(" already exists!").toString()));
		}
		
		return null;
	}

}
