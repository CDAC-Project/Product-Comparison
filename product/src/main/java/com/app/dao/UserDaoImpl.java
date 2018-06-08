package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojos.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	
	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public User validateUser(String user_id, String password) {
		String jpql="select u from User u where user_id=:id and password=:pa";
		return sf.getCurrentSession().createQuery(jpql,User.class).setParameter("id", user_id).setParameter("pa", password).getSingleResult();
	}


}
