package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Expense;
import com.entity.User;

public class ExpenseDao 
{
	private SessionFactory factory = null;
	private Session s = null;
	private Transaction t = null;
	
	public ExpenseDao(SessionFactory factory) 
	{
		super();
		this.factory = factory;
	}
	
	public boolean saveExpense(Expense ex)
	{
		boolean f = false;
		
		try 
		{
			s = factory.openSession();
			t = s.beginTransaction();
			
			s.save(ex);
			t.commit();
			f=true;
		} catch (Exception e) {
			if(t!=null)
			{
				f = false;
				e.printStackTrace();
			}
		}
		
		return f;
	}
	
	public List<Expense> getAllExpense(User user)
	{
		List<Expense> list = new ArrayList<Expense>();
		try 
		{
			s = factory.openSession();
			Query q = s.createQuery("from Expense where user=:us");
			q.setParameter("us", user);
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Expense getExpenseById(int id)
	{
		Expense ex = null;
		
		try 
		{
			s = factory.openSession();
			Query query = s.createQuery("from Expense where id=:id");
			query.setParameter("id", id);
			ex = (Expense) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ex;
	}
	
	public boolean updateExpense(Expense ex)
	{
		boolean f = false;
		
		try 
		{
			s = factory.openSession();
			t = s.beginTransaction();
			
			s.saveOrUpdate(ex);
			t.commit();
			f=true;
		} catch (Exception e) {
			if(t!=null)
			{
				f = false;
				e.printStackTrace();
			}
		}
		
		return f;
	}
	
	public boolean deleteExpense(int id)
	{
		boolean f = false;
		
		try 
		{
			s = factory.openSession();
			t = s.beginTransaction();
			
			Expense ex = s.get(Expense.class, id);
			s.delete(ex);
			t.commit();
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}