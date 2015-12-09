package com.pduleba.spring.service;

import java.util.List;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pduleba.spring.dao.UserDao;
import com.pduleba.spring.dao.model.UserModel;
import com.pduleba.spring.security.AppUser;

@Service(value="userService")
public class UserServiceImpl implements UserService, UserDetailsService {

	public static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Value(value="${user.default.password}")
	private String defaultPassword;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public boolean createUser(String userName) {
		if (StringUtils.isEmpty(userName)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Invalid name"));
			LOG.info(new StringBuilder("User ").append(userName).append(" already exists").toString());
		} else if (userDao.exists(userName)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "User already exists"));
			LOG.info(new StringBuilder("User ").append(userName).append(" already exists").toString());
		} else {
			UserModel user = new UserModel(userName, encoder.encode(defaultPassword));
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
		if (Objects.nonNull(user)) {
			return new AppUser(user);
		} else {
			throw new UsernameNotFoundException("Unable to load user");
		}
	}

}
