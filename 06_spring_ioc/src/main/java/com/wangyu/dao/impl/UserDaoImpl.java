package com.wangyu.dao.impl;

import com.wangyu.dao.UserDao;
import com.wangyu.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * class UserDaoImpl
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/10 11:58
 **/
public class UserDaoImpl implements UserDao {
    private String username;
    private int age;

    private List<String> strList;
    private Map<String, User> userMap;
    private Properties properties;

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserDaoImpl() {
        System.out.println("UserDaoImpl创建...");
    }

    public void init() {
        System.out.println("UserDaoImpl初始化方法");
        System.out.println(this);
    }

    @Override
    public void save() {
        System.out.println(username + "=====" + age);
        System.out.println(strList);
        System.out.println(userMap);
        System.out.println(properties);
        System.out.println("save running...");
    }

    public void destroy() {
        System.out.println("USerDaoImpl销毁方法");
    }
}
