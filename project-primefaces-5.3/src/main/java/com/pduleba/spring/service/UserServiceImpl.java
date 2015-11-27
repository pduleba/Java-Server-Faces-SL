package com.pduleba.spring.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pduleba.spring.dao.UserDao;
import com.pduleba.spring.dao.model.UserModel;
import com.pduleba.spring.security.AppUser;

@Service(value="userService")
public class UserServiceImpl implements UserService, UserDetailsService {

	private static final String DEFAULT_PASSWORD = "abc";
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SaltSource salt; // TODO
	
	@Override
	public void createUser(String name) {
		UserModel user = new UserModel(name);
		user.setPassword(getPasswordHash());
		
		userDao.save(user);
	}

	private String getPasswordHash() {
		return passwordEncoder.encode(DEFAULT_PASSWORD);
	}

	@Override
	public List<UserModel> getUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public AppUser loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = userDao.findByName(username);
		return Objects.nonNull(user) ? new AppUser(user) : null;
	}

}
