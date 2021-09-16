package com.wangyu.jsp01;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * class HelloTag
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/9 14:51
 **/
public class HelloTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("欢迎来到百度一下，我们的网址是：www.baidu.com");
    }
}
