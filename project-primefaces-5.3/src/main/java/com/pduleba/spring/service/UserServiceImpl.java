package com.pduleba.spring.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.pduleba.spring.dao.UserDao;
import com.pduleba.spring.dao.model.UserModel;
import com.pduleba.spring.security.AppUser;

@Service(value="userService")
public class UserServiceImpl implements UserService, UserDetailsService {

	public static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean createUser(UserModel user) {
		if (userDao.exists(user.getName())) {
			LOG.info(new StringBuilder("User ").append(user.getName()).append(" already exists").toString());
		} else {
			userDao.save(user);
			return true;
		}
		
		return false;
	}

	@Override
	public List<UserModel> getUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		UserModel user = userDao.findByName(username);
		return Objects.nonNull(user) ? new AppUser(user) : null;
	}

}
