package com.wangyu.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * class MyAspect
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/21 0:34
 **/
public class MyAspect {

    public void before() {
        System.out.println("前置增强...");
    }

    public void afterReturning() {
        System.out.println("后置增强");
    }

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前增强...");
        Object proceed = joinPoint.proceed();// 切点方法
        System.out.println("环绕后增强...");
        return proceed;
    }

    public void afterThrowing() {
        System.out.println("抛出异常增强...");
    }

    public void after() {
        System.out.println("最终增强...");
    }
}
