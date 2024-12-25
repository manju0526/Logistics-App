package com.global;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ControllerSupport {

    // Abstract method for processing requests
    public abstract void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    // Method for showing the view details (displaying the page)
    public void viewDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the JSP or View to display
        String viewPage = getViewPage();
        request.getRequestDispatcher(request.getContextPath()+viewPage).forward(request, response);
    }

    // Abstract method to get the view page (to be defined in the extending controller)
    protected abstract String getViewPage();
}
