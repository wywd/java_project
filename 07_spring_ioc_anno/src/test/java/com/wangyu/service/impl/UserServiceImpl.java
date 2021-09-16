package com.wangyu.service.impl;

import com.wangyu.dao.UserDao;
import com.wangyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * class UserServiceImpl
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/10 21:28
 **/
//@Component("userService")
@Service("userService")
//@Scope("prototype")
@Scope("singleton")
public class UserServiceImpl implements UserService {

    @Value("${jdbc.driver}")
    private String driver;

//    @Autowired  // 单独写也能注入，按照数据类型从Spring容器中进行匹配的
//    @Qualifier("userDao")  // 按照id的名称从容器中进行匹配的，但是此处@Qualifier必须要结合@Autowired一起使用
    @Resource(name="userDao")
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println(driver);
        userDao.save();
    }

    @PostConstruct
    public void init() {
        System.out.println("Service对象的初始化方法");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Service对象的销毁方法");
    }
}
