package com.pduleba.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pduleba.spring.dao.model.UserModel;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	private HibernateTemplate template;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.template = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public List<UserModel> getAllUsers() {
		return template.loadAll(UserModel.class);
	}

	@Override
	public void save(UserModel user) {
		template.save(user);
	}
}
