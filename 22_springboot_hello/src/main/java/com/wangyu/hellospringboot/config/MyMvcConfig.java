package com.wangyu.hellospringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * class MyMvcConfig
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/27 12:28
 **/

// 拓展 springmvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    // 视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/wangyu").setViewName("test");
    }
}
