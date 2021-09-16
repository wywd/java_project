package com.wangyu.servlet02;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * class ContextServlet
 *
 * @Description //ServletContext：1.可以共享数据 2.
 * @Author wangyu
 * @Date 2021/9/7 14:33
 **/
public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();  // 上下文对象可以用于多个servlet程序之间相互通信
        context.setAttribute("username", "wangyu");
    }
}
