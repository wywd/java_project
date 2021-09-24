package com.wangyu.aop;

import com.wangyu.aop.TargetInterface;

/**
 * class Target
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/19 23:45
 **/
public class Target implements TargetInterface {
    @Override
    public void save() {
//        int i = 1/0;
        System.out.println("save running...");
    }
}
