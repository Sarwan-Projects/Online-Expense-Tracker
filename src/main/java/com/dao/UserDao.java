package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.User;

public class UserDao 
{
	private SessionFactory factory = null;
	private Session s = null;
	private Transaction t = null;
	
	public UserDao(SessionFactory factory) 
	{
		super();
		this.factory = factory;
	}
	
	public boolean save(User u)
	{
		boolean f = false;
		
		try 
		{
			s = factory.openSession();
			t = s.beginTransaction();
			
			s.save(u);
			t.commit();
			f= true;
		} catch (Exception e) {
			if(t!=null)
			{
				f = false;
				e.printStackTrace();
			}
		}
		
		return f;
	}
	
	public User login(String email, String password)
	{
		User u = null;
		s = factory.openSession();
		Query query = s.createQuery("from User where email=:em and password=:ps");
		query.setParameter("em", email);
		query.setParameter("ps", password);
		
		u = (User)query.uniqueResult();
		return u;
	}
}