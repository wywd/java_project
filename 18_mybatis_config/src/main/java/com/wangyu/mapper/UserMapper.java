package com.wangyu.mapper;

import com.wangyu.domain.User;

import java.util.List;

/**
 * interface UserMapper
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/22 20:24
 **/
public interface UserMapper {
    void save(User user);
    User findById(int id);
    List<User> findAll();
}
