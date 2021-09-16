package com.wangyu.servlet06;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.Enumeration;

/**
 * class BlackListFilter
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/8 19:37
 **/
@WebFilter(urlPatterns = {"/login2"},
initParams = {  // 初始化有3个黑名单用户
        @WebInitParam(name = "blackList1", value = "黑名单用户1"),
        @WebInitParam(name = "blackList2", value = "黑名单用户2"),
        @WebInitParam(name = "blackList3", value = "wangyu")
})
public class BlackListFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        boolean success = true;
        // 获取前台登录的账号信息
        String name = request.getParameter("username");
        // 获取过滤器的初始化参数
        Enumeration<String> blackListNames = filterConfig.getInitParameterNames();
        //判断前台登陆账号是否为空
        if (name == null || "".equals(name)) {
            success = false;
            response.getWriter().write("用户名字不能为空");
        } else {
            // 登陆账号不为空，循环遍历黑名单
            while (blackListNames.hasMoreElements()) {
                // 若登陆账号在黑名单中，则不允许登录
                if (filterConfig.getInitParameter(blackListNames.nextElement()).equals(name)) {
                    success = false;
                }
            }
        }
        if (success) {
            chain.doFilter(request, response);
        } else {
            response.getWriter().write("<h1 align=\"center\" style=\"font-family:arial;color:red;\">" +
                    "温馨提示：您的账号存在风险，暂时不能为您提供服务 </h1>\n");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }
}
