package com.wangyu.servlet02;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * class UseContextServlet
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/7 15:02
 **/
public class UseContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        ServletContext context = this.getServletContext();
        String url = context.getInitParameter("url");// 获取初始化参数
        resp.getWriter().print("url: " + url);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
