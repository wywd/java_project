package com.wangyu.servlet07;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * class LoginServlet3
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/8 21:47
 **/
@WebServlet("/login3")
public class LoginServlet3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置页面输出格式
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        // 获取表单数据
        String username = req.getParameter("username");
        // 查看当前会话是否有账号登陆
        String logined = (String) req.getSession().getAttribute("username");
        // 当前会话已有账号登录
        if ("".equals(username) || username == null) {
            System.out.println("非法操作，您没有输入用户名");
        } else {
            if (!"".equals(logined) && logined != null) {
                System.out.println("您已经登录，重复登录无效，请先退出当前账号重新登录！");
                out.write("<h1>王瑜的个人网站</h1>"
                        + "<h3>您好，您已经登录了账户：" + logined + "</h3>"
                        + "如要登录其他账号，请先退出当前账号重新登录！");
                // 登录页面为填写内容
            } else { // 将当前帐号加入会话中
                req.getSession().setAttribute("username", username);
                out.write("<h1>王瑜的个人网站</h1>"
                        + "<h3>" + username + "：欢迎您的到来</h3>");
            }
            // 从上下文中获取已经登录的账号集合
            List<String> onLineUserList = (List<String>) req.getServletContext().getAttribute("onLineUserList");
            if (onLineUserList != null) {
                // 向页面输出结果
                out.write("<h3>当前在线人数为：" + onLineUserList.size() +
                        "</h3>" + "<table border=\"1\" width=\"50%\">");
                for (int i = 0; i < onLineUserList.size(); ++i) {
                    out.write("<tr>\r\n" + "<td align=\"center\">" + onLineUserList.get(i) + " </td>\r\n" + "</tr>");
                }
            }
            out.write("</table><br/>" + "<a href=\"/servlet_learning/logout3\">退出登录</a>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
