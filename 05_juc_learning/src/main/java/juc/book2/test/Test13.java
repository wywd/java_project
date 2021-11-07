package juc.book2.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * class Test13
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/10/27 12:36
 **/
@Slf4j(topic = "c.Test13")
public class Test13 {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);
        log.debug("{}", i.incrementAndGet());  // ++i
        log.debug("{}", i.getAndIncrement());  // i++
        log.debug("{}", i.get());
        log.debug("{}", i.getAndAdd(5));
        log.debug("{}", i.addAndGet(5));
    }
}
