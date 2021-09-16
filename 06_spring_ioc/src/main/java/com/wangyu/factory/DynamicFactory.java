package com.wangyu.factory;

import com.wangyu.dao.UserDao;
import com.wangyu.dao.impl.UserDaoImpl;

/**
 * class DynamicFactory
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/10 14:24
 **/
public class DynamicFactory {
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
