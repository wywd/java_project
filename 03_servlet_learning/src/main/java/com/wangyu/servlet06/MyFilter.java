package com.wangyu.servlet06;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * class MyFilter
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/8 16:32
 **/

@WebFilter(dispatcherTypes = {
        DispatcherType.REQUEST,
        DispatcherType.FORWARD,
        DispatcherType.INCLUDE,
        DispatcherType.ERROR
}, urlPatterns = {"/FilterServlet"})
public class MyFilter implements Filter {
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<h1>Hello MyFilter</h1>");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
