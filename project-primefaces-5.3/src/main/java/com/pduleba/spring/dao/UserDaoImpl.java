package com.pduleba.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pduleba.spring.dao.model.UserModel;

@Repository
@Transactional
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	
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

	@Override
	public boolean exists(String name) {
		final String SQL = "select count(*) from UserModel user where user.name = :name";
		return getHibernateTemplate().execute(new HibernateCallback<Boolean>() {
			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Long count = (Long) session.createQuery(SQL).setParameter("name", name).uniqueResult();
				return count > 0;
			}
		});
	}
	
	@Override
	public UserModel findByName(String username) {
		return getHibernateTemplate().execute(new HibernateCallback<UserModel>() {
				@Override
				public UserModel doInHibernate(Session session) throws HibernateException {
					Criteria criteria = session.createCriteria(UserModel.class);
	                criteria.add(Restrictions.eq("name", username));
					return (UserModel) criteria.uniqueResult();
				}
		});
		
		//find("from UserModel user where user.name = ?", username);
	}
}
