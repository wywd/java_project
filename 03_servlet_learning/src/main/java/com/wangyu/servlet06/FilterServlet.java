package com.wangyu.servlet06;

import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * class FilterServlet
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/8 16:29
 **/

@WebServlet("/FilterServlet")
public class FilterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(resp.getContentType());
        resp.getWriter().write("<h3>FilterServlet访问成功</h3>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
