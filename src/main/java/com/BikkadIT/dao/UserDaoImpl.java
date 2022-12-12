package com.BikkadIT.dao;

import java.util.List;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.BikkadIT.entity.User;

@Repository
public class UserDaoImpl implements UserDaoI{
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public int saveUserToDb(User user) {
		System.out.println("Dao layer method");
		System.out.println(user);
		
		Session session =sessionFactory.openSession();
		session.beginTransaction();
		
		int save =(int) session.save(user);
		session.getTransaction().commit();
		return save;
	}


	@Override
	public List<User> getAllData() {
		Session session=sessionFactory.openSession();
		Query query =session.createQuery("from  User");
		List<User> list= query.getResultList();
		
		return list;
	}


	@Override
	public List<User> getAllDataFromDB() {
		Session session=sessionFactory.openSession();
		Query query =session.createQuery("from  User");
		List<User> list= query.getResultList();
		
		return list;
	}


	@Override
	public User getSingle(int uid) {
		Session session = sessionFactory.openSession();
		User user= session.get(User.class, uid);
		return user;
	}


	@Override
	public List<User> updateUser(User user) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		
		Session session1=sessionFactory.openSession();
		Query query =session1.createQuery("from  User");
		List<User> list= query.getResultList();
		
		return list;
	}


	@Override
	public List<User> deleteUserById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user=session.get(User.class, id);
		session.delete(user);
		session.getTransaction().commit();
		
		Session session2=sessionFactory.openSession();
		Query query =session2.createQuery("from  User");
		List<User> list= query.getResultList();
		
		return list;
		
		
		
	
	}


	

}
