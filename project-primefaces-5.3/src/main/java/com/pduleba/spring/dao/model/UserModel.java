package com.pduleba.spring.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users", schema="pduleba")
@SequenceGenerator(name="user_db_seq", allocationSize=1, sequenceName="USERS_SEQ")
public @Data @NoArgsConstructor class UserModel {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_db_seq")
	private Long id;
	
	@Column(name="name")
	private String name;

	public UserModel(String name) {
		this.name = name;
	}

}
