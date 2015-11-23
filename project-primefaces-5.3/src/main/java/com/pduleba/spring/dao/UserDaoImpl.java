package com.pduleba.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pduleba.spring.dao.model.UserModel;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate template;
	
	@Override
	public List<UserModel> getAllUsers() {
		return template.loadAll(UserModel.class);
	}

	@Override
	public void save(UserModel user) {
		template.save(user);
	}
}
