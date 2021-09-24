package com.wangyu.test;

import com.wangyu.anno.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * class AnnoTest
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/21 11:30
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-anno.xml")
public class AnnoTest {

    @Autowired
    public TargetInterface target;

    @Test
    public void test1() {
        target.save();
    }

}
