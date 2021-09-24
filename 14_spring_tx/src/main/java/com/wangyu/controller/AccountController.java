package com.wangyu.controller;

import com.wangyu.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountController {

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = app.getBean(AccountService.class);
        accountService.transfer("王瑜","姜紫婷",500);
    }

}
