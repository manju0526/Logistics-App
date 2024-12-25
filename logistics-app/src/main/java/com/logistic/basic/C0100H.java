package com.logistic.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.ControllerSupport;

public class C0100H extends ControllerSupport{

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String action = request.getParameter("action");

	        if ("process".equals(action)) {
	            // Handle the file upload logic (e.g., saving the file)
	            try {
	                // File upload logic goes here (e.g., process the file)
	                response.sendRedirect(request.getContextPath() + "/uploadFile?message=File uploaded successfully!");
	            } catch (Exception e) {
	                e.printStackTrace();
	                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "File upload failed");
	            }
	        } else {
	            // If no action, just show the form
	            viewDetails(request, response);
	        }
		
	}

	@Override
	protected String getViewPage() {
		// TODO Auto-generated method stub
		 return "/jsp/uploadFile.jsp"; 
	}

}
