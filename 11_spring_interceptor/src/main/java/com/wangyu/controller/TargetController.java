package com.wangyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * class TargetController
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/16 20:43
 **/
@Controller
public class TargetController {

    @RequestMapping("/target")
    public ModelAndView show() {
        System.out.println("目标资源执行");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "wangyu");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
