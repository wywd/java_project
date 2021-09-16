package com.wangyu.service.impl;

import com.wangyu.dao.UserDao;
import com.wangyu.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * class UserServiceImpl
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/10 14:32
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    // set方法进行依赖注入
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.save();
    }
}
