package com.logistics.controller;

import javax.servlet.*;

import javax.servlet.http.*;
import java.io.*;

import com.logistics.utils.SCMLoginValidate;

public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Forward to login.jsp when accessing the login URL
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get form parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String isValidUser = "FALSE";
		System.out.println("Username::: " + username);
		System.out.println("Password:::: " + password);
		// Simple login logic (just a basic check for demonstration)

		try {
			if (username != null && password != null) {
				isValidUser = SCMLoginValidate.validation(username, password, request, response);
			}

			if (isValidUser.equals("TRUE")) {
				System.out.println("User validation Successfull!!!!");
				response.sendRedirect(request.getContextPath()+"/dashboard.jsp");
			} else {
				response.getWriter().println("Invalid credentials!");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("something missing");
		}

	}
}
