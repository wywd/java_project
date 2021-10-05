package com.wangyu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * class DruidConfig
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/30 16:43
 **/

@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    // 后台监控，之前的web.xml通过这种方式去实现
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        // 后台需要有人登录，账号密码配置
        HashMap<String, String> initParameters = new HashMap<>();
        // 增加配置
        initParameters.put("loginUsername", "wangyu");  // 登录的key是固定的
        initParameters.put("loginPassword", "123456");

        // 允许谁可以访问
        initParameters.put("allow", "localhost");

        // 禁止访问
//        initParameters.put("xxx", "xxx.xxx.xxx");

        bean.setInitParameters(initParameters);  // 设置初始化参数
        return bean;
    }

    // filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        // 可以过滤哪些请求

        HashMap<String, String> initParameters = new HashMap<>();

        // 这些地址不进行过滤
        initParameters.put("exclusion", "*.js, *.css, /druid/*");

        bean.setInitParameters(initParameters);
        return bean;
    }

}







