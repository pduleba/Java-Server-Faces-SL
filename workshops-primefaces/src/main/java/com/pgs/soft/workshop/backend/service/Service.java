package com.pgs.soft.workshop.backend.service;

import java.util.List;

import com.pgs.soft.workshop.backend.model.Platform;

public interface Service {

	List<String> findLanguages(String query);

	List<String> findFrameworks(String query);

	List<Platform> getPlatforms();

	List<String> getHobbies();

}
