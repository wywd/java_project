package com.wangyu.mapper;

import com.wangyu.domain.User;

import java.util.List;

/**
 * class UserMapper
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/22 19:38
 **/
public interface UserMapper {
    List<User> findByCondition(User user);
    List<User> findByIds(List<Integer> ids);
}
