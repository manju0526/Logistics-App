package com.global;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logistic.basic.C0100H;

@WebServlet("/main*") // Intercepts all requests
public class DispatcherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		handleRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


	private void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String controllerName = request.getParameter("controller");
		String mode = request.getParameter("mode");

		if (controllerName != null) {
			// Handle controller logic based on controller name (e.g., C0100H for file
			// upload)
			try {
				// Create an instance of the controller dynamically using reflection
				ControllerSupport controller = createController(controllerName);

				if (controller != null) {
					// If mode is VIEW, call viewDetails, otherwise process the request
					if ("VIEW".equals(mode)) {
						controller.viewDetails(request, response); // Display the page (view)
					} else {
						controller.doProcess(request, response); // Process the action (e.g., file upload)
					}
				} else {
					response.sendError(HttpServletResponse.SC_NOT_FOUND, "Controller not found");
				}
			} catch (Exception e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error handling controller");
			}
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Controller parameter missing");
		}
	}

	// Dynamically instantiate the controller based on the controller name
	private ControllerSupport createController(String controllerName) {
		// Example: Create FileUploadController for "C0100H" controller
		if ("C0100H".equals(controllerName)) {
			return new C0100H();
		}
		// Add other controller cases here
		return null; // Return null if no valid controller found
	}
}
