package com.pgs.soft.workshop.backend.model;

import java.util.ArrayList;
import java.util.List;

public class AboutMe extends AbstractModel {

	private static final long serialVersionUID = -3161130543942332226L;

	private String details;
	
	private List<String> hobbies = new ArrayList<>();

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}	
}
