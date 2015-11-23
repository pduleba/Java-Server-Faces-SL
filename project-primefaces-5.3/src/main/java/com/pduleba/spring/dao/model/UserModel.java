package com.pduleba.spring.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="users", schema="pduleba")
public @Data class UserModel {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_SEQ")
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;

	public UserModel(String name) {
		this.name = name;
	}

}
