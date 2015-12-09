package com.pduleba.spring.dao;

import java.util.List;

import com.pduleba.spring.dao.model.UserModel;

public interface UserDao {

	List<UserModel> getAllUsers();

	void save(UserModel user);

	boolean exists(String name);

	UserModel findByName(String username);

}
