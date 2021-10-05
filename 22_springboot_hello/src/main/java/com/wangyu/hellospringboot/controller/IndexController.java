package com.wangyu.hellospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * class IndexController
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/27 10:19
 **/

@Controller  // 在template目录下的所有页面，只能通过controller来跳转，需要模板引擎的支持：ThymeLeaf
public class IndexController {

    @RequestMapping("/test")
    public String index(Model model) {
        model.addAttribute("msg", "<h1>hello, springboot!</h1>");
        model.addAttribute("users", Arrays.asList("wangyu, jiangziting"));
        return "test";
    }
}
