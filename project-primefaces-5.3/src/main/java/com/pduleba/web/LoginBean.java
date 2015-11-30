package com.pduleba.web;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.pduleba.spring.service.LogService;

import lombok.Data;

@ManagedBean(name = "loginBean", eager = true)
@RequestScoped
@Component
public @Data class LoginBean implements Serializable {

	private static final long serialVersionUID = 1549481937223946546L;

	private String userName;
	private String password;

	@Resource(name="authenticationManager")
//	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private LogService logService;

	public String login() {
		logService.logInfo("login :: starting...");
		try {
			Authentication request = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(this.userName, this.password));
			SecurityContextHolder.getContext().setAuthentication(request);
			this.password = null;

			logService.logInfo("login :: complete");

			return "/views/user/index?faces-redirect=true";
		} catch (AuthenticationException e) {
			logService.logError("Unable to authenticate", e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Unable to authenticate"));
			return null;
		}
	}

	public String logout() {
		logService.logInfo("logout :: starting...");
		SecurityContextHolder.clearContext();
		logService.logInfo("logout :: complete");

		return "/welcome?faces-redirect=true";
	}

}
