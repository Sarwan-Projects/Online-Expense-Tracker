package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExpenseDao;
import com.db.HibernateUtil;
import com.entity.Expense;
import com.entity.User;

@WebServlet("/update")
public class UpdateExpense extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    
    public UpdateExpense() 
    {
    	
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		Integer id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String date = req.getParameter("date");
		String time = req.getParameter("time");
		String description = req.getParameter("description");
		String price = req.getParameter("price");
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("loginUser");
		
		Expense e = new Expense(title, date, time, description, price, user);
		e.setId(id);
		ExpenseDao dao = new ExpenseDao(HibernateUtil.getSessionFactory());
		boolean f = dao.updateExpense(e);
		
		if(f)
		{
			session.setAttribute("msg", "Expense Updated Successfully");
			res.sendRedirect("User/view_expense.jsp");
		}
		else
		{
			session.setAttribute("msg", "Something Wrong on Server");
			res.sendRedirect("User/view_expense.jsp");
		}
	}

}