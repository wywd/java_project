package com.wangyu.dao.impl;

import com.wangyu.dao.RoleDao;
import com.wangyu.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * class RoleDaoImpl
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/14 11:11
 **/
public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role",
                new BeanPropertyRowMapper<>(Role.class));
        return roleList;
    }

    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values (?, ?, ?)",
                null, role.getRoleName(), role.getRoleDesc());
    }

    @Override
    public List<Role> findRoleByUserId(Long id) {
        List<Role> roles = jdbcTemplate.query(
                "select * from sys_user_role ur, sys_role r where ur.roleId = r.id and ur.userId = ?",
                new BeanPropertyRowMapper<>(Role.class), id);
        return roles;
    }
}
