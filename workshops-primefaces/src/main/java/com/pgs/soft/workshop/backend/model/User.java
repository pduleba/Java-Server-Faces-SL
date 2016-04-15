package com.pgs.soft.workshop.backend.model;

import java.util.Date;

import org.primefaces.model.StreamedContent;

public class User extends AbstractModel {

	private static final long serialVersionUID = 4504275672229416174L;

	private String firstName;

	private String lastName;

	private Integer childrenNumber;

	private String email;

	private String phone;

	private Date birthDate;

	private StreamedContent avatar;

	private Skills skills = new Skills();
	private AboutMe aboutMe = new AboutMe();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getChildrenNumber() {
		return childrenNumber;
	}

	public void setChildrenNumber(Integer childrenNumber) {
		this.childrenNumber = childrenNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public StreamedContent getAvatar() {
		return avatar;
	}

	public void setAvatar(StreamedContent avatar) {
		this.avatar = avatar;
	}

	public Skills getSkills() {
		return skills;
	}

	public void setSkills(Skills skills) {
		this.skills = skills;
	}

	public AboutMe getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(AboutMe aboutMe) {
		this.aboutMe = aboutMe;
	}
}
