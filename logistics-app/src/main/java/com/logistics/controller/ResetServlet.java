package com.logistics.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logistics.utils.StringFunctions;

@SuppressWarnings("serial")
public class ResetServlet extends HttpServlet{
	
	private StringFunctions STRINGS;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("IN RESET PASSWORD CLASS!!!");
		
		
		String username = req.getParameter("username");
		System.out.println("USERNAME::: "+username);
		
		if(username!=null) {
			// Calling PL SQL function to change password before that validate the user and if true reset password else throw error
			resp.sendRedirect(req.getContextPath()+"/forgotPassword.jsp?Errormsg="+username);
			
		}else {
			resp.sendRedirect(req.getContextPath()+"/forgotPassword.jsp?Errormsg=No Userame Entered!!");
		}
		
		
		
	}
	
	
	

}
