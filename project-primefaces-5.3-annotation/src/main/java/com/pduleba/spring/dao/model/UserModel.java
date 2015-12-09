package com.pduleba.spring.dao.model;

import java.sql.Timestamp;
import java.util.Calendar;

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
@Table(name="users")
@SequenceGenerator(name="user_db_seq", allocationSize=1, sequenceName="USERS_SEQ")
public @Data @NoArgsConstructor class UserModel {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_db_seq")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password_hash")
	private String passwordHash;

	@Column(name="creation_date")
	private Timestamp creationDate;
	
	public UserModel(String name, String passwordHash) {
		this.name = name;
		this.passwordHash = passwordHash;
		this.creationDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
	}

}
