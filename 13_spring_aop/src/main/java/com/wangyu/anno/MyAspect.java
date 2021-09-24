package com.wangyu.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * class MyAspect
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/21 0:34
 **/

@Component("myAspect")
@Aspect  // 标注当前这个MyAspect是一个切面
public class MyAspect {

    @Before(value = "execution(* com.wangyu.anno.*.*(..))")
    public void before() {
        System.out.println("前置增强...");
    }

    public void afterReturning() {
        System.out.println("后置增强");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前增强...");
        Object proceed = joinPoint.proceed();// 切点方法
        System.out.println("环绕后增强...");
        return proceed;
    }

    public void afterThrowing() {
        System.out.println("抛出异常增强...");
    }

    @After("MyAspect.pointcut()")
    public void after() {
        System.out.println("最终增强...");
    }

    // 定义一个切点表达式
    @Pointcut("execution(* com.wangyu.anno.*.*(..))")
    public void pointcut() {

    }
}
