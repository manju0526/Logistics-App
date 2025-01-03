package com.logistics.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logistics.utils.SCMLoginValidate;
import com.logistics.utils.StringFunctions;

@SuppressWarnings("serial")
public class ResetServlet extends HttpServlet {

	private StringFunctions STRINGS;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String chkUsrvalid = null;
		System.out.println("IN RESET PASSWORD CLASS!!!");

		String username = req.getParameter("username");
		System.out.println("USERNAME::: " + username);

		if (username != null) {
			try {
				chkUsrvalid = SCMLoginValidate.isUservalid(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (chkUsrvalid.equals("TRUE")) {
				resp.sendRedirect(req.getContextPath() + "/forgotPassword.jsp?Errormsg=" + chkUsrvalid);
			} else {
				resp.sendRedirect(req.getContextPath() + "/forgotPassword.jsp?Errormsg=Invalid user Id");
			}

		} else {
			resp.sendRedirect(req.getContextPath() + "/forgotPassword.jsp?Errormsg=No Userame Entered!!");
		}

	}

}
