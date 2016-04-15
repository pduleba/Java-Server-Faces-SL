package com.pgs.soft.workshop.backend.dao;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.pgs.soft.workshop.backend.model.Platform;

public class DaoImpl implements Dao, Serializable {

	private static final long serialVersionUID = -7942481525456135460L;

	private List<Platform> platforms;

	private List<String> languages;

	private List<String> frameworks;

	private List<String> hobbies;

	private List<String> avatars;

	public DaoImpl() {
		super();
		this.platforms = new ArrayList<>();
		this.platforms.add(new Platform(1, "java-android", "Java with Android"));
		this.platforms.add(new Platform(2, "java-se", "Java Standard Edition"));
		this.platforms.add(new Platform(3, "java-ee", "Java Enterprise Edition"));
		this.platforms.add(new Platform(4, "spring", "Spring Framework"));

		this.languages = new ArrayList<>();
		this.languages.add("Java");
		this.languages.add("C");
		this.languages.add("C++");
		this.languages.add("C#");
		this.languages.add("Ruby");
		this.languages.add("PHP");
		this.languages.add("Python");
		this.languages.add("Pascal");
		this.languages.add("JavaScript");

		this.frameworks = new ArrayList<>();
		this.frameworks.add("Spring MVC");
		this.frameworks.add("JSF");
		this.frameworks.add("JSP");
		this.frameworks.add("Servlet");
		this.frameworks.add("Vaadin");
		this.frameworks.add("Google Web Toolkit");
		this.frameworks.add("Gralis");
		this.frameworks.add("Play 2");
		this.frameworks.add("Struts");
		this.frameworks.add("Wicklet");
		
		this.hobbies = new ArrayList<>();
		this.hobbies.add("Computer programming");
		this.hobbies.add("Cooking");
		this.hobbies.add("Coloring");
		this.hobbies.add("Cabaret");
		this.hobbies.add("Calligraphy");
		this.hobbies.add("Cabaret");

		this.avatars = new ArrayList<>();
		for (int i = 1; i < 8; i++) {
			this.avatars.add(MessageFormat.format("programmer-{0}", i));
		}
	}

	@Override
	public List<Platform> getPlatforms() {
		return platforms;
	}

	@Override
	public List<String> getLanguages() {
		return languages;
	}

	@Override
	public List<String> getFrameworks() {
		return frameworks;
	}

	@Override
	public List<String> getHobbies() {
		return hobbies;
	}

	@Override
	public List<String> getAvatars() {
		return avatars;
	}
	
	@Override
	public List<String> findLanguages(String query) {
		List<String> result = new ArrayList<String>();
		
		for (String language : languages ) {
			if (language.toUpperCase().startsWith(query.toUpperCase())) {
				result.add(language);
			}
		}
		return result;
	}
	
	@Override
	public List<String> findFrameworks(String query) {
		List<String> result = new ArrayList<String>();
		
		for (String framework : frameworks ) {
			if (framework.toUpperCase().startsWith(query.toUpperCase())) {
				result.add(framework);
			}
		}
		return result;
	}
}
