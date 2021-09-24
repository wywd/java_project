package com.wangyu.interceptor;

import com.wangyu.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * class PrivilegeInterceptor
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/17 9:41
 **/
public class PrivilegeInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断用户是否登录 本质：判断session中有没有user
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 没有登录，重定向到登录页面
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false;
        } else {
            return true;
        }
    }
}
