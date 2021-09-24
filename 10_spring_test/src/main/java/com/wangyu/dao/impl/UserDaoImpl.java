package com.wangyu.dao.impl;

import com.wangyu.dao.UserDao;
import com.wangyu.domain.Role;
import com.wangyu.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.PreparedStatement;
import java.util.List;

/**
 * class UserDaoImpl
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/15 20:05
 **/
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<>(User.class));
        return userList;
    }

    @Override
    public Long save(User user) {
//        jdbcTemplate.update("insert into sys_user values (?, ?, ?, ?, ?)",
//                null,
//                user.getUsername(),
//                user.getEmail(),
//                user.getPassword(), user.getPhoneNum());
        // 创建PreparedStatementCreator
        PreparedStatementCreator creator = con -> {
            // 使用原始jdbc完成PreparedStatement的组件
            PreparedStatement preparedStatement = con.prepareStatement("insert into sys_user values (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, null);
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getPhoneNum());
            return preparedStatement;
        };

        // 创建KeyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(creator, keyHolder);

        // 获得生成的主键
        long userId = keyHolder.getKey().longValue();
        System.out.println(userId);

        // 返回当前用户保存的ID，该ID是数据库自动生成的
        return userId;
    }

    @Override
    public void saveUserRoleRel(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values (?, ?)", userId, roleId);
        }
    }

    @Override
    public void delUserRoleRel(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId=?", userId);
    }

    @Override
    public void del(Long userId) {
        jdbcTemplate.update("delete from sys_user where id=?", userId);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) throws EmptyResultDataAccessException {
        return jdbcTemplate.queryForObject("select * from sys_user where username=? and password=?",
                new BeanPropertyRowMapper<>(User.class), username, password);
    }
}
