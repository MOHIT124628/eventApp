package com.pat.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pat.DAO.userDAO;
import com.pat.DAOImp.userDAOImp;
import com.pat.modren.*;
@WebServlet("/registration")
public class registrationServlet extends HttpServlet{
	public userDAO user;
	@Override
	public void init() {
		user=new userDAOImp();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email=req.getParameter("email");
		String phone_number=req.getParameter("phone_number");
		String city=req.getParameter("city");
		String role=req.getParameter("role");
		
		user us = new user();
		us.setName(name);
		us.setUsername(username);
		us.setPassword(password);
		us.setEmail(email);
		us.setPhone_number(phone_number);
		us.setCity(city);
		us.setRole(role);
		
		user.save(us);
		resp.sendRedirect("login.jsp");
		
	}
}
