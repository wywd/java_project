package com.wangyu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * class JdbcController
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/30 13:35
 **/

@Controller
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 查询数据库的所有信息
    @RequestMapping("/user")
    @ResponseBody
    public List<Map<String, Object>> userList() {
        String sql = "select * from user";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
        return mapList;
    }

    @RequestMapping("/addUser")
    public String addUser() {
        String sql = "insert into user(id, username, password, birthday) values (8, '小花', '123123', null)";
        jdbcTemplate.update(sql);
        return "redirect:/user";
    }

    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id) {
        String sql = "update user set username=?, password=? where id=" + id;
        jdbcTemplate.update(sql, new Object[]{"小黄", "qaz"});
        return "redirect:/user";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql, id);
        return "redirect:/user";
    }

}












