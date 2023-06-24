package com.example.dao;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.example.model.User;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class UserDao implements IUserDao
{
	private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
	  public void saveUser(User user) {
	    Transaction tx = null;
	    try (Session session = sessionFactory.openSession()) 
	    {
	      tx = session.beginTransaction();
	      session.save(user);
	      tx.commit();
	    } catch (Exception e) {
	      if (tx != null) {
	        tx.rollback();
	      }
	      e.printStackTrace();
	    }
	  }
}
