package com.logistics.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class StatusMessageTag extends SimpleTagSupport {
    private String message; // Custom message to display
    private String type;    // Type of message (success, fail)
    private String icon;    // Icon for message

    // Setters for the attributes
    public void setMessage(String message) {
        this.message = message;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        String color = "lightbrown";  // Default color
        String finalMessage = (message != null && !message.trim().isEmpty()) ? message : "2024 Logistics Corp. Terms & Conditions";  // Default message when message is null or empty

        // Handle type for success, fail, etc.
        if (type == null) {
            type = "info";  // Default type
        }

        switch (type.toLowerCase()) {
            case "success":
                color = "green";
                finalMessage = (finalMessage == null) ? "File uploaded successfully!" : finalMessage;
                break;
            case "fail":
                color = "red";
                finalMessage = (finalMessage == null) ? "Upload failed. Please try again." : finalMessage;
                break;
            case "info":
                color = "blue";
                break;
            case "warning":
                color = "orange";
                break;
            default:
                color = "lightbrown";
        }

        // Output the styled footer message as a "button" at the bottom, full width, responsive
        out.write("<div style='position:fixed; bottom:10px; left:0; width:100%; background-color:" + color + "; color:white; font-weight:bold; padding:10px 20px; border-radius:5px; display:flex; align-items:center; justify-content:center; box-shadow: 0 4px 8px rgba(0,0,0,0.1); z-index:1000; overflow:hidden;'>");

        // If an icon is specified, include it
        if (icon != null && !icon.isEmpty()) {
            out.write("<span class='" + icon + "' style='margin-right: 10px;'></span>");
        }

        // Write the message to the div
        out.write("<span>" + finalMessage + "</span>");

        // Close the div
        out.write("</div>");
    }
}
