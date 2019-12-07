package com.oguzkurtcebe.dao;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oguzkurtcebe.entity.User;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public long insert(User user) {
		return (long) sessionFactory.getCurrentSession().save(user);
	}
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public User getFindByUsernameAndPass(String username,String pass) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Note WHERE username=:username AND pass=:pass AND active=:active")
				.setString("username", username)
				.setString("pass", pass)
				.setBoolean("active", true);
		return (User) query.getSingleResult();
	}
	
	public User getFindByUsername(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Note WHERE username=:username")
				.setString("username", username);								
		return (User) query.getSingleResult();
	}
	
	public User getFindByKey(String key) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Note WHERE value_key=:key")
				.setString("key", key);		
		User user=null;
		try {
			user=(User) query.getSingleResult();
		} catch (javax.persistence.PersistenceException e) {
			user=null;
		
		}
		return user;
	}
	
	
}
