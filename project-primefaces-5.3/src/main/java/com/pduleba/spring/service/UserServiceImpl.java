package com.pduleba.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pduleba.spring.dao.UserDao;
import com.pduleba.spring.dao.model.UserModel;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public void createUser(String name) {
		UserModel user = new UserModel(name);
		userDao.save(user);
	}

	@Override
	public List<UserModel> getUsers() {
		return userDao.getAllUsers();
	}

}
