package com.wangyu.service.impl;

import com.wangyu.dao.UserDao;
import com.wangyu.service.UserService;

/**
 * class UserServiceImpl
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/11 11:18
 **/
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}
