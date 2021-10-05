package com.wangyu.config;


import org.apache.tomcat.jni.Local;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * class MyLocalResolver
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/27 16:30
 **/
public class MyLocalResolver implements LocaleResolver {

    // 解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求中的语言参数
        String language = request.getParameter("l");
        if (StringUtils.isEmpty(language)) {  // 如果为空，使用默认
            return Locale.getDefault();
        } else {
            String[] split = language.split("_");  // 分成国家；地区
            return new Locale(split[0], split[1]);
        }
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
