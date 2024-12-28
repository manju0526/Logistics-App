package com.logistics.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ClientMessageTag extends SimpleTagSupport {
    private String message;
    private String icon;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.write("<div style='border: 1px solid #ccc; padding: 10px; margin: 10px 0; background-color: #f9f9f9;'>");
        if (icon != null && !icon.isEmpty()) {
            out.write("<span class='" + icon + "' style='margin-right: 10px;'></span>");
        }
        out.write("<span>" + message + "</span>");
        out.write("</div>");
    }
}
