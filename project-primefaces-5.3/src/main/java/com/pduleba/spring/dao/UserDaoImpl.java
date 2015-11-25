package com.pduleba.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pduleba.spring.dao.model.UserModel;

@Repository
@Transactional
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	private static final Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);
	
	// DI by Constructor (you can use init method/setter)
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	public List<UserModel> getAllUsers() {
		return getHibernateTemplate().loadAll(UserModel.class);
	}

	@Override
	public void save(UserModel user) {
		getHibernateTemplate().save(user);
	}
}
