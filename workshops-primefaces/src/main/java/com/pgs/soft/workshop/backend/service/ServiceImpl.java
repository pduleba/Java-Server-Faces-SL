package com.pgs.soft.workshop.backend.service;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pgs.soft.workshop.backend.dao.Dao;
import com.pgs.soft.workshop.backend.dao.DaoImpl;
import com.pgs.soft.workshop.backend.model.Platform;

public class ServiceImpl implements Service, Serializable {

	private static final long serialVersionUID = -7221136865982999555L;

	public static final Logger LOG = LoggerFactory.getLogger(ServiceImpl.class);
	
	private Dao dao;

	public ServiceImpl() {
		super();
		this.dao = new DaoImpl();
	}
	
	@Override
	public List<String> findLanguages(String query) {
		return dao.findLanguages(query);
	}
	
	@Override
	public List<String> findFrameworks(String query) {
		return dao.findFrameworks(query);
	}
	
	@Override
	public List<Platform> getPlatforms() {
		return dao.getPlatforms();
	}
	
	@Override
	public List<String> getHobbies() {
		return dao.getHobbies();
	}
}
