package com.wangyu.dao;

import com.wangyu.domain.User;

import java.util.List;

/**
 * class UserDao
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/15 20:04
 **/
public interface UserDao {

    List<User> findAll();

    Long save(User user);

    void saveUserRoleRel(Long userId, Long[] roleIds);

    void delUserRoleRel(Long userId);

    void del(Long userId);
}
