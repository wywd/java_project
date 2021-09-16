package com.wangyu.servlet06;

import javax.servlet.Filter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Enumeration;

/**
 * class ShowInfoServlet
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/8 13:38
 **/
@WebServlet("/info")
public class ShowInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        // ServletConfig接口
        ServletConfig config = this.getServletConfig();

        out.print("<h1>ServletConfig的信息</h1>");
        out.print("<h2>初始化参数</h2>");
        Enumeration<String> names = config.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String parameter = config.getInitParameter(name);
            out.print(name + ": " + parameter + "");
        }
        out.print("<h2>servlet名字</h2> " + config.getServletName());
        out.print("<h2>ServletContext对象</h2>" + config.getServletContext());
        out.print("<h1>HttpServletRequest的信息</h1>");
        out.print("获取http请求方式：" + req.getMethod() + "<br/>");
        out.print("获取请求行资源路径：" + req.getRequestURI() + "<br/>");
        out.print("获取请求行中参数部分：" + URLEncoder.encode(req.getQueryString(), "UTF-8") + "<br/>");
        out.print("获取当前Servlet所对应的名字：" + req.getContextPath() + "<br/>");
        out.print("获取Servlet所映射的路径：" + req.getServletPath() + "<br/>");
        out.print("获取客户端IP地址：" + req.getRemoteAddr() + "<br/>");
        out.print("获取客户端完整主机名：" + req.getRemoteHost() + "<br/>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}


