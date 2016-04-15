package com.pgs.soft.workshop.backend.dao;

import java.util.List;

import com.pgs.soft.workshop.backend.model.Platform;

public interface Dao {

	List<Platform> getPlatforms();

	List<String> getLanguages();
	
	List<String> getFrameworks();

	List<String> getHobbies();

	List<String> findLanguages(String query);

	List<String> getAvatars();

	List<String> findFrameworks(String query);
}
