package com.pduleba.spring.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="users", schema="pduleba")
public @Data class UserModel {

	@Id
	@SequenceGenerator(name="USERS_SEQ", allocationSize=1)
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;

	public UserModel(String name) {
		this.name = name;
	}

}
