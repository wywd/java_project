package com.wangyu.service;

import com.wangyu.domain.Role;

import java.util.List;

/**
 * class RoleService
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/14 11:08
 **/
public interface RoleService {
    public List<Role> list();

    void save(Role role);
}
