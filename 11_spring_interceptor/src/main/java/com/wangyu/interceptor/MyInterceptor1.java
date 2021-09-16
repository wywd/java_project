package com.wangyu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * class MyInterceptor1
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/16 20:54
 **/
public class MyInterceptor1 implements HandlerInterceptor {

    // 这个方法在目标方法执行之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle执行了...");
        String param = request.getParameter("param");
        if ("yes".equals(param)) {
            return true;
        } else {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return false;
        }
    }

    // 这个方法在目标方法执行之后视图返回之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("name", "wangyu123");
        System.out.println("postHandle执行了...");
    }

    // 在整个流程都执行完毕之后执行，视图对象已经返回后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion执行了...");
    }
}
