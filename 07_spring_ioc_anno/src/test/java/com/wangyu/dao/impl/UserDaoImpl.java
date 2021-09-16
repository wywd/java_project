package com.wangyu.dao.impl;

import com.wangyu.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * class UserDaoImpl
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/10 21:26
 **/

//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save running...");
    }
}
