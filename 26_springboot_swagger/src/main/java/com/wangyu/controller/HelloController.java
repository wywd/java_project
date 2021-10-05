package com.wangyu.controller;

import com.wangyu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * class HelloController
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/10/5 15:44
 **/
@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @PostMapping("/user")
    @ResponseBody
    public User user() {
        return new User();
    }
}
