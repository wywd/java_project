package com.wangyu.proxy.jdk;

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
        System.out.println("save running...");
    }
}
