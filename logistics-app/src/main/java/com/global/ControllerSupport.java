package com.global;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ControllerSupport {

    // Abstract method for processing requests
    public abstract void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    // Method for showing the view details (displaying the page)
    public void viewDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set content type to HTML for the response
        response.setContentType("text/html");

        // Get the view page path from the implementing controller
        String viewPage = getViewPage();
        System.out.println("View mode - Rendering page: " + viewPage);

        try {
            // Include the JSP page's content in the response
            RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
            dispatcher.include(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error rendering view: " + viewPage, e);
        }
    }

    // Abstract method to get the view page path (to be defined in each specific controller)
    protected abstract String getViewPage();
}
