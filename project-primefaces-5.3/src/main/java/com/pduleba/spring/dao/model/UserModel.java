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
@Table(name="T_USERS")
public @Data @NoArgsConstructor class UserModel {

	@Id
	@GeneratedValue(generator="USER_DB_SEQ", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="USER_DB_SEQ", sequenceName="USERS_SEQ", allocationSize=1, initialValue = 1)
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PASSWORD_HASH")
	private String passwordHash;

	@Column(name="CREATION_DATE")
	private Timestamp creationDate;
	
	public UserModel(String name, String passwordHash) {
		this.name = name;
		this.passwordHash = passwordHash;
		this.creationDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
	}

}
