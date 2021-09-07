package com.wangyu.servlet02;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * class PropertiesServlet
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/7 15:22
 **/
public class PropertiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
//        InputStream inputStream = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        InputStream inputStream = this.getServletContext().getResourceAsStream("/WEB-INF/classes/com/wangyu/servlet01/aa.properties");
        Properties prop = new Properties();
        prop.load(inputStream);
        String user = (String) prop.get("username");
        String pwd = (String) prop.get("password");
        resp.getWriter().print(user + pwd);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

