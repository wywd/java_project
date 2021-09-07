package com.wangyu.servlet02;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * class DispatcherServlet
 *
 * @Description //请求转发，网站路径不会发生变化；区别于重定向
 * @Author wangyu
 * @Date 2021/9/7 15:09
 **/
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        System.out.println("进入了DispatcherServlet");
        // 请求转发功能介绍
        RequestDispatcher dispatcher = context.getRequestDispatcher("/getContent");  // 转发的请求路径
        dispatcher.forward(req, resp);  // 调用forward方法实现转发
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
