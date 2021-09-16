package com.wangyu.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * class ContextLoaderListener
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/11 11:45
 **/
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        // 读取web.xml中的全局参数
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
        // 将Spring的应用上下文对象存储在ServletContext对象中
        servletContext.setAttribute("app", app);
        System.out.println("Spring容器创建...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ((ClassPathXmlApplicationContext) sce.getServletContext().getAttribute("app")).close();
        System.out.println("SPring容器销毁");
    }
}
