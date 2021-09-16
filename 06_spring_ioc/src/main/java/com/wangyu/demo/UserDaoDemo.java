package com.wangyu.demo;

import com.wangyu.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * class UserDaoDemo
 *
 * @Description //控制反转例子
 * @Author wangyu
 * @Date 2021/9/10 12:02
 **/
public class UserDaoDemo {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.save();
    }
}
