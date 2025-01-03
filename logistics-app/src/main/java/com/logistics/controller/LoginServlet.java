package com.logistics.controller;

import javax.servlet.*;

import javax.servlet.http.*;
import java.io.*;

import com.logistics.utils.SCMLoginValidate;
import com.logistics.utils.StringFunctions;

public class LoginServlet extends HttpServlet {  
	
	private StringFunctions STRINGS = new StringFunctions();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Forward to login.jsp when accessing the login URL
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get form parameters
		String username = STRINGS.replaceNull(request.getParameter("username"));
		String password = STRINGS.replaceNull(request.getParameter("password"));
		String isValidUser = "FALSE";
		
		System.out.println("Username::: " + username);
		System.out.println("Password:::: " + password);

		try {
			
			if (username != null && password != null) {
				isValidUser = SCMLoginValidate.validation(username, password, request, response);
			}

			if (isValidUser.equals("TRUE")) {
				System.out.println("User validation Successfull!!!!");
				response.sendRedirect(request.getContextPath()+"/dashboard.jsp");
			} else {
				System.out.println("Not a valid user!!!!");				
				response.sendRedirect(request.getContextPath()+"/login.jsp?Errormsg=Invalid Username or password. Please retry once");

			}

		} catch (Exception e) {
			
			System.err.println("something missing");
		}

	}
}
