package com.wangyu.service;

import com.wangyu.domain.User;

import java.util.List;

/**
 * class UserService
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/15 20:02
 **/
public interface UserService {

    List<User> list();

    void save(User user, Long[] roleIds);

    void del(Long userId);
}
