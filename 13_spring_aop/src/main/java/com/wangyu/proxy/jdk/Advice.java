package com.wangyu.proxy.jdk;

/**
 * class Advice
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/19 23:46
 **/
public class Advice {
    public void before() {
        System.out.println("前置增强");
    }

    public void after() {
        System.out.println("后置增强");
    }
}
