package com.wangyu.servlet07;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * class LogoutServlet
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/8 22:14
 **/
@WebServlet("/logout3")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //退出登录操作，将此次session进行销毁
        //触发HttpSessionListener监听器的sessionDestroyed方法
        request.getSession().invalidate();
        //跳转回登录页面
        response.sendRedirect("/servlet_learning/login3.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
