package com.wangyu.servlet05;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * class CookieServlet
 *
 * @Description //Cookie的使用：1.保存用户上一次访问的时间
 * @Author wangyu
 * @Date 2021/9/7 23:04
 **/
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 服务器，告诉你，你来的时间，把这个时间封装成一个信件，你下次带来，我就知道你来了
        // 解决中文乱码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        // Cookie，服务端从客户端获取
        Cookie[] cookies = req.getCookies();  // 返回数组，说明Cookie存在多个
        if (cookies != null) {
            // 如果存在
            out.write("你上一次访问的时间是：");
            for (var cookie: cookies) {
                if ("lastLoginTime".equals(cookie.getName())) {
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toLocaleString());
                }
                if ("name".equals(cookie.getName())) {
                    System.out.println(cookie.getValue());
                    out.write(cookie.getValue());
                }
            }
        } else {
            out.write("这是您第一次访问本站");
        }

        // 服务器给客户端响应一个cookie
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis() + "");
        cookie.setMaxAge(24*60*60);  // 设置cookie有效期为1
        resp.addCookie(cookie);

        // 测试中文编码
        Cookie cookie2 = new Cookie("name", "王瑜的名字");
        resp.addCookie(cookie2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
