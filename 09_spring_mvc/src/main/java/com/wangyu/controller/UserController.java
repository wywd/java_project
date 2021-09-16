package com.wangyu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangyu.domain.User;
import com.wangyu.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * class UserController
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/11 17:03
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/quick22")  // 文件上传
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile) throws IOException {
        System.out.println(username);
        // 获得上传文件名称
        String filename = uploadFile.getOriginalFilename();
        System.out.println(filename);
        // 保存到某路径上
        uploadFile.transferTo(new File("D:\\" + filename));
    }

    @RequestMapping(value = "/quick21")  // Cookie
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID", required = false) String jsessionId) {
        System.out.println(jsessionId);
    }

    @RequestMapping(value = "/quick20")  // 请求头
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent", required = false) String useragent) {
        System.out.println(useragent);
    }

    @RequestMapping(value = "/quick19")  // request, response, session
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date) {  //自定义类型转换器
        System.out.println(date);
    }

    // localhost:8080/user/quick17/wangyu
    @RequestMapping(value = "/quick17/{username}")
    @ResponseBody
    public void save17(@PathVariable(value = "username") String username) {
        System.out.println(username);
    }

    @RequestMapping(value = "/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name", required = false, defaultValue = "姜紫婷") String username) {
        System.out.println(username);
    }

    @RequestMapping(value = "/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) {  // 数组类型，通过注解
        System.out.println(userList);
    }

    @RequestMapping(value = "/quick14")
    @ResponseBody
    public void save14(VO vo) {  // 集合类型，通过ajax
        System.out.println(vo);
    }

    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(String[] strs) {  // 数组类型
        System.out.println(Arrays.toString(strs));
    }

    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(User user) {  // POJO类型
        System.out.println(user);
    }

    @RequestMapping(value = "/quick11")
    @ResponseBody
    public void save11(String username, int age) {  // 基本参数类型
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping(value = "/quick10")
    @ResponseBody
    //期待SpringMVC自动将User转换成json格式
    public User save10() {
        User user = new User();
        user.setUsername("wangyu");
        user.setAge(22);
        return user;
    }

    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9() throws JsonProcessingException {
        User user = new User();
        user.setUsername("wangyu");
        user.setAge(21);
        // 使用json的转换工具将对象转换成json格式的字符串返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8() {
        return "{\"username\": \"wangyu\", \"age\": 18}";
    }

    @RequestMapping(value = "/quick7")
    @ResponseBody  // 这个注解标明不是映射地址是普通字符串
    public String save7() {
        return "<h1>Hello save7<h1>";
    }

    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().println("<h1>hello wangyu<h1>");
    }

    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request) {
        request.setAttribute("username", "姜紫婷");
        return "success";
    }

    @RequestMapping(value = "/quick4")
    public String save4(Model model) {
        model.addAttribute("username", "yuyuyu");
        return "success";
    }

    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView) {
        modelAndView.setViewName("success");
        modelAndView.addObject("username", "wangyu");
        return modelAndView;
    }

    @RequestMapping(value = "/quick2")
    public ModelAndView save2() {
        // Model:模型 作用是封装数据
        // View: 视图 作用是展示数据
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", "王瑜");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    public String save() {
        System.out.println("Controller save running...");
//        return "/jsp/success.jsp";
        return "success";
    }
}


