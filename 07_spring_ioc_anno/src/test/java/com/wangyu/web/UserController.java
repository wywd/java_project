package com.wangyu.web;

import com.wangyu.config.SpringConfiguration;
import com.wangyu.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * class UserController
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/10 21:31
 **/
public class UserController {
    public static void main(String[] args) {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService service = app.getBean(UserService.class);
//        service.save();
//        ((ClassPathXmlApplicationContext) app).close();
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }

}
