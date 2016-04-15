package com.pgs.soft.workshop.backend.model;

import java.io.Serializable;

public class Platform implements Serializable {

	private int id;
	
	private String img;

	private String description;

	public Platform(int id, String img, String description) {
		super();
		this.id = id;
		this.img = img;
	    this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Platform other = (Platform) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return Integer.toString(id);
	}	
	
    
}
