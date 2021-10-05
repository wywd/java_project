package com.wangyu.hellospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * class HelloController
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/24 19:46
 **/
@RestController
//@Controller
public class HelloController {

    @RequestMapping("/hello")
//    @ResponseBody
    public String hello() {
        // 调用业务，接受前端参数
        return "hello, World；你好，世界！";
    }
}
