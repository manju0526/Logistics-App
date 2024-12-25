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
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String controllerName = request.getParameter("controller");
        String mode = request.getParameter("mode");

        if (controllerName != null) {
            try {
                // Dynamically load the controller
                ControllerSupport controller = createController(controllerName);

                if (controller != null) {
                    // Process the request based on mode
                    if ("VIEW".equals(mode)) {
                        controller.viewDetails(request, response); // Serve view content
                    } else {
                        controller.doProcess(request, response); // Perform action processing
                    }
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().write("<p>Controller not found</p>");
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("<p>Error processing the request</p>");
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("<p>Controller parameter missing</p>");
        }
    }

    // Dynamically instantiate the controller based on the controller name
    private ControllerSupport createController(String controllerName) {
        switch (controllerName) {
            case "C0100H":
                return new C0100H();
            // Add more cases for other controllers
            default:
                return null; // Return null if no valid controller found
        }
    }
}
