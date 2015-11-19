package com.pduleba.jsf;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pduleba.common.Action;
import com.pduleba.spring.MessageService;

import lombok.Data;

@ManagedBean(name = "sessionBean", eager = true)
@SessionScoped
@Component
public @Data class SessionBean implements Serializable {

	private static final long serialVersionUID = 1549481937223946546L;

	private final static Logger LOG = LoggerFactory.getLogger(SessionBean.class);
	
	private String input;
	
	private String response;
	
	@Autowired
	private MessageService messageService;

	public String doAction() {
		return interceptAction(() -> componseReponseTask(), "doAction", "response");
	}

	private String interceptAction(final Action<String> action, final String actionName, final String response) {
		logMe(actionName);
		
		action.execute();
		
		return response;
	}

	private void componseReponseTask() {
		setResponse(messageService.getMessage(this.input));
	}

	private void logMe(String action) {
		if (LOG.isDebugEnabled()) {
			LOG.debug(new StringBuilder(action).append(" :: executed ").toString());
		}
	}
}
