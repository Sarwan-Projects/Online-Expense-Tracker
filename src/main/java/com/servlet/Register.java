package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.HibernateUtil;
import com.entity.User;

@WebServlet("/register")
public class Register extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
   
    public Register() 
    {
        
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String fullName = req.getParameter("fullName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String about = req.getParameter("about");
		
		User u = new User(fullName, email, password, about);
		
		UserDao dao = new UserDao(HibernateUtil.getSessionFactory());
		boolean f = dao.save(u);
		HttpSession session = req.getSession();
		
		if(f)
		{
			session.setAttribute("msg", "Registered Successfully...");
			res.sendRedirect("register.jsp");
		}
		else
		{
			session.setAttribute("msg", "Something Wrong on Server!");
			res.sendRedirect("register.jsp");
		}
	}

}