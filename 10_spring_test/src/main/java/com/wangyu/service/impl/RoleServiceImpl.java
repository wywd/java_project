package com.wangyu.service.impl;

import com.wangyu.dao.RoleDao;
import com.wangyu.domain.Role;
import com.wangyu.service.RoleService;

import java.util.List;

/**
 * class RoleServiceImpl
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/14 11:09
 **/
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> list() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
