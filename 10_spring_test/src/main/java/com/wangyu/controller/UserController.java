package com.wangyu.controller;

import com.wangyu.domain.Role;
import com.wangyu.domain.User;
import com.wangyu.service.RoleService;
import com.wangyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * class UserController
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/15 20:00
 **/

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/del/{userId}")
    public String del(@PathVariable("userId") Long userId) {
        userService.del(userId);
        return "redirect:/user/list";
    }

    @RequestMapping("/save")
    public String save(User user, Long[] roleIds) {
        userService.save(user, roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping("/saveUI")
    public ModelAndView saveUI() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/list")
    public ModelAndView list() {
        List<User> userList = userService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }
}
