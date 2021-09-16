package com.wangyu.listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * class WebApplicationContextUtils
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/11 12:01
 **/
public class WebApplicationContextUtils {
    public static ApplicationContext getWebApplicationContext(ServletContext servletContext) {
        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
