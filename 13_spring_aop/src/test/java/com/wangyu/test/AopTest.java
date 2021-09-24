package com.wangyu.test;

import com.wangyu.aop.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.annotation.Target;

/**
 * class AopTest
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/21 0:45
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AopTest {
    @Autowired
    private TargetInterface target;

    @Test
    public void test1() {
        target.save();
    }
}
