package com.wangyu.dao;

import com.wangyu.domain.Role;

import java.util.List;

/**
 * class RoleDao
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/14 11:10
 **/
public interface RoleDao {

    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUserId(Long id);
}
