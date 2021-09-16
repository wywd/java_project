package com.wangyu.factory;

import com.wangyu.dao.UserDao;
import com.wangyu.dao.impl.UserDaoImpl;

/**
 * class StaticFactory
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/10 14:17
 **/
public class StaticFactory {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
