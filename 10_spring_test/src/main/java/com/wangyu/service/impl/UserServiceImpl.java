package com.wangyu.service.impl;

import com.wangyu.dao.RoleDao;
import com.wangyu.dao.UserDao;
import com.wangyu.domain.Role;
import com.wangyu.domain.User;
import com.wangyu.service.UserService;

import java.util.List;

/**
 * class UserServiceImpl
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/15 20:03
 **/
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        // 封装这个userList中的每一个User的roles数据
        for (User user : userList) {
            // 获得user的id
            Long id = user.getId();
            // 将id作为参数，查询当前这个userId对应的Role集合数据
            List<Role> roles = roleDao.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        // 第一步，向sys_user表中存储数据
        Long userId = userDao.save(user);
        // 第二部，向sys_user_role关系表中存储多条数据
        userDao.saveUserRoleRel(userId, roleIds);
    }

    @Override
    public void del(Long userId) {
        // 1. 删除关系表sys_user_role
        userDao.delUserRoleRel(userId);
        // 2. 删除sys_user表对应user
        userDao.del(userId);
    }
}
