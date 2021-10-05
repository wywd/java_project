package com.wangyu.controller;

import com.wangyu.mapper.MyUserMapper;
import com.wangyu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * class UserController
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/30 20:33
 **/
@Controller
public class UserController {

    @Autowired
    private MyUserMapper userMapper;

    @RequestMapping("/queryUser")
    @ResponseBody
    public List<User> queryUserList() {
        List<User> userList = userMapper.queryUserList();
        return userList;
    }

}
