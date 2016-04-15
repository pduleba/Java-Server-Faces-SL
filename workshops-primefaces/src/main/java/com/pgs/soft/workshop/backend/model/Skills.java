package com.pgs.soft.workshop.backend.model;

import java.util.ArrayList;
import java.util.List;

public class Skills extends AbstractModel {

	private static final long serialVersionUID = -5681801523679124309L;

	private String favouriteEditor;

	private Platform favouritePlatform;

	private List<String> frameworks = new ArrayList<>();

	private String mainLanguage;

	private String mainOS;

	private Boolean masterDegree = Boolean.FALSE;

	public String getFavouriteEditor() {
		return favouriteEditor;
	}

	public void setFavouriteEditor(String favouriteEditor) {
		this.favouriteEditor = favouriteEditor;
	}

	public Platform getFavouritePlatform() {
		return favouritePlatform;
	}

	public void setFavouritePlatform(Platform favouritePlatform) {
		this.favouritePlatform = favouritePlatform;
	}

	public List<String> getFrameworks() {
		return frameworks;
	}

	public void setFrameworks(List<String> frameworks) {
		this.frameworks = frameworks;
	}

	public String getMainLanguage() {
		return mainLanguage;
	}

	public void setMainLanguage(String mainLanguage) {
		this.mainLanguage = mainLanguage;
	}

	public String getMainOS() {
		return mainOS;
	}

	public void setMainOS(String mainOS) {
		this.mainOS = mainOS;
	}

	public Boolean getMasterDegree() {
		return masterDegree;
	}

	public void setMasterDegree(Boolean masterDegree) {
		this.masterDegree = masterDegree;
	}

}
