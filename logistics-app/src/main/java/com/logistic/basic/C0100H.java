package com.logistic.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.ControllerSupport;

public class C0100H extends ControllerSupport {

    @Override
    public void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Perform action processing (e.g., file upload logic)
        String action = request.getParameter("action");

        if ("process".equals(action)) {
            try {
                // Example action logic
                response.getWriter().write("File processed successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Processing failed");
            }
        } else {
            // Default to view mode
            viewDetails(request, response);
        }
    }

    @Override
    protected String getViewPage() {
        // Return the path to the JSP for this controller
        return "/WEB-INF/jsp/uploadFile.jsp";
    }
}
