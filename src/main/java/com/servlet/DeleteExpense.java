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

@WebServlet("/delete")
public class DeleteExpense extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public DeleteExpense() 
    {
       
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		ExpenseDao dao = new ExpenseDao(HibernateUtil.getSessionFactory());
		boolean f = dao.deleteExpense(id);
		HttpSession session = req.getSession();
		
		if(f)
		{
			session.setAttribute("msg", "Deleted Successfully");
			res.sendRedirect("User/view_expense.jsp");
		}
		else
		{
			session.setAttribute("msg", "Something Wrong on Server");
			res.sendRedirect("User/view_expense.jsp");
		}
	}

}
