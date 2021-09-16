package com.wangyu.test;

import com.wangyu.config.SpringConfiguration;
import com.wangyu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * class SpringJunitTest
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/11 10:58
 **/
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfiguration.class})
//@ContextConfiguration()
public class SpringJunitTest {
    @Autowired
    private UserService service;
    @Test
    public void test1() {
        service.save();
    }
}
