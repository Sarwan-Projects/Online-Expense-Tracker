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

@WebServlet("/login")
public class Login extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public Login() 
    {
        
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserDao dao = new UserDao(HibernateUtil.getSessionFactory());
		User login = dao.login(email, password);
		
		HttpSession session = req.getSession();
		
		if(login == null)
		{
			session.setAttribute("msg", "Invalid Email Or Password");
			res.sendRedirect("login.jsp");
		}
		else
		{
			session.setAttribute("loginUser", login);
			res.sendRedirect("User/home.jsp");
		}
	}

}