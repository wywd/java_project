package com.wangyu.resolver;

import com.wangyu.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * class MyExceptionResolver
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/17 11:38
 **/
public class MyExceptionResolver implements HandlerExceptionResolver {
    /*
        参数Exception ex;异常对象
    */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        if (ex instanceof MyException) {
            modelAndView.addObject("info", "自定义异常");

        } else if (ex instanceof ClassCastException) {
            modelAndView.addObject("info", "类型转换异常");
        } else {

        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
