package com.wangyu.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * class SecurityConfig
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/10/4 23:02
 **/

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 授权，链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 首页所有人可以访问，但是里面的功能页只能对应的有权限的用户才能访问
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        // 防止网站工具：get，post
        http.csrf().disable();

        // 没有权限，默认去登录页
        http.formLogin()
                .loginPage("/toLogin")  //用户未登录时，访问任何资源都转跳到该路径，即登录页面
                .usernameParameter("username")  // 登录表单form中用户名输入框input的name名，不修改的话默认是username
                .passwordParameter("password")  // form中密码输入框input的name名，不修改的话默认是password
                .loginProcessingUrl("/login");  //登录表单form中action的地址，也就是处理认证请求的路径

        // 注销，开启注销功能
        http.logout().logoutSuccessUrl("/").deleteCookies("remove").invalidateHttpSession(true);

        // 开启记住我功能  cookie 默认保存两周；自定义接收前端参数
        http.rememberMe().rememberMeParameter("remember");

    }


    // 认证
    // 密码编码:PasswordEncoder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 这些数据正常应该从数据库中读取
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("王瑜").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2", "vip3")
                .and()
                .withUser("姜紫婷").password(new BCryptPasswordEncoder().encode("654321")).roles("vip1");

    }
}
