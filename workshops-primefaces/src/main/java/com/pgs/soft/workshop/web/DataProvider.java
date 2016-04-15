package com.pgs.soft.workshop.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pgs.soft.workshop.backend.model.Platform;
import com.pgs.soft.workshop.backend.service.Service;
import com.pgs.soft.workshop.backend.service.ServiceImpl;

@ManagedBean(name = "dataProvider", eager = true)
@SessionScoped
public class DataProvider implements Serializable {

	private static final long serialVersionUID = 1549481937223946546L;

	public static final String DATE_FORMAT = "MM-dd-yyyy";

	private Service service;
	
	@PostConstruct
	public void init() {
		this.service = new ServiceImpl();
	}

	public String getDateFormat() {
		return DATE_FORMAT;
	}

	public List<String> findLanguages(String query) {
		return service.findLanguages(query);
	}

	public List<String> findFrameworks(String query) {
		return service.findFrameworks(query);
	}
	
	public List<Platform> getPlatforms() {
		return service.getPlatforms();
	}
}
