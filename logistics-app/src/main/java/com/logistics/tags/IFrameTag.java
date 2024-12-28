package com.logistics.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class IFrameTag extends SimpleTagSupport {
    private String src;
    private String width;
    private String height;

    public void setSrc(String src) {
        this.src = src;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.write("<iframe src='" + src + "' width='" + (width != null ? width : "100%") + "' height='" + (height != null ? height : "500px") + "' frameborder='0' style='border:0;'></iframe>");
    }
}
