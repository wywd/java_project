package com.wangyu.demo;

import com.wangyu.service.UserService;
import com.wangyu.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * class UserController
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/10 14:38
 **/
public class UserController {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        userService.save();

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext app = new FileSystemXmlApplicationContext("D:\\study\\codeProjects\\ssm_study\\spring_ioc\\src\\main\\resources\\applicationContext.xml");
//        UserService userService = (UserService) app.getBean("userService");  // 根据id方式（可以区分同一类不同id）适合同一类多个Bean
        UserService userService = app.getBean(UserService.class);  // 根据类名，适合同一类的一个Bean
        userService.save();


    }
}
