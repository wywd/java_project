package com.wangyu.test;

import com.wangyu.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * class SpringTest
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/10 13:52
 **/
public class SpringTest {
    @Test  // 测试Bean的scope属性
    public void test1() {
//        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
//        UserDao userDao2 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
//        System.out.println(userDao2);
        // Bean默认singleton  当Spring核心文件被加载时，实例化配置的Bean实例
        //com.wangyu.dao.impl.UserDaoImpl@6283d8b8
        //com.wangyu.dao.impl.UserDaoImpl@6283d8b8
        // 改成prototype  当调用getBean()方法时实例化Bean
        //com.wangyu.dao.impl.UserDaoImpl@32b260fa
        //com.wangyu.dao.impl.UserDaoImpl@581ac8a8

//        app.close();

    }
}
