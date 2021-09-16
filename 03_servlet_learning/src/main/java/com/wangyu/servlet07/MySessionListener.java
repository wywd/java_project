package com.wangyu.servlet07;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;

/**
 * class MySessionListener
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/8 22:07
 **/
@WebListener
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    public MySessionListener() {
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("HttpSessionAttributeListener****attributeAdded()方法开始工作*******************");
        //从上下文中获取已经登录账号的集合
        List<String> onLineUserList = (List<String>) se.getSession().getServletContext().getAttribute("onLineUserList");
        //在上下文中没有登陆用户
        if(onLineUserList == null || onLineUserList.size() == 0) {
            onLineUserList = new ArrayList<>();
        }

        String username =(String) se.getSession().getAttribute("username");
        //向已登录集合中添加当前账号
        onLineUserList.add(username);
        System.out.println("用户：" + username + " 成功加入在线用户列表");
        for(int i= 0;i<onLineUserList.size();i++) {
            System.out.println(onLineUserList.get(i));
        }
        se.getSession().getServletContext().setAttribute("onLineUserList", onLineUserList);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext application = session.getServletContext();
        List<String> onlineUserList = (List<String>) application.getAttribute("onLineUserList");
        // 取得登录的用户名
        String username = (String) session.getAttribute("username");
        if(!"".equals(username) && username != null && onlineUserList != null && onlineUserList.size() > 0 ) {
            // 从在线列表中删除用户名
            onlineUserList.remove(username);
            System.out.println(username+"已经退出！");
            System.out.println("当前在线人数为"+onlineUserList.size());
        }else {
            System.out.println("会话已经销毁！");
        }
    }
}
