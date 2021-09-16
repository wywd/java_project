package com.wangyu.web;

import com.wangyu.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * class UserServlet
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/11 11:27
 **/
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
//        ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");
//        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }
}
