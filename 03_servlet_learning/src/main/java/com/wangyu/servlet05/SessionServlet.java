package com.wangyu.servlet05;

import com.wangyu.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * class SessionServlet
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/8 10:39
 **/
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决乱码问题
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        // 得到Session
        HttpSession session = req.getSession();

        // 给Session存东西
//        session.setAttribute("name", "王瑜");
        session.setAttribute("name", new Person("王瑜", 23));

        // 获取Session ID
        String id = session.getId();

        // 判断Session是否是新创建的
        if (session.isNew()) {
            resp.getWriter().write("session创建成功,id: " + id);
        } else {
            resp.getWriter().write("session已经在服务器中创建了");
        }

        // 猜想：Session创建的时候同时创建了一个Cookie，名字叫JSESSIONID，值为id，传给了浏览器
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
