package com.pduleba.spring.service;

import java.util.List;

import com.pduleba.spring.dao.model.UserModel;

public interface UserService {

	boolean createUser(String userName);

	List<UserModel> getUsers();

}
