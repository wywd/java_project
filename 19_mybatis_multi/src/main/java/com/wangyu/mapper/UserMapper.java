package com.wangyu.mapper;

import com.wangyu.domain.User;

import java.util.List;

/**
 * interface UserMapper
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/22 21:51
 **/
public interface UserMapper {
    List<User> findAll();
    List<User> findUserAndRole();
}
