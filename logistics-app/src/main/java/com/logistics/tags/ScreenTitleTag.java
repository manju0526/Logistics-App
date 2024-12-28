package com.logistics.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ScreenTitleTag extends SimpleTagSupport {
    private String title;
    private String icon;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.write("<div style='text-align:center; margin: 20px 0;'>");
        if (icon != null && !icon.isEmpty()) {
            out.write("<span class='" + icon + "' style='margin-right: 10px;'></span>");
        }
        out.write("<h1 style='display:inline-block; font-family: Arial, sans-serif;'>" + title + "</h1>");
        out.write("</div>");
    }
}

