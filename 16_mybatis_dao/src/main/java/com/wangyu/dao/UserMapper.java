package com.wangyu.dao;

import com.wangyu.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * class UserMapper
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/22 17:26
 **/
public interface UserMapper {
    List<User> findAll();

    User findById(int id);
}
