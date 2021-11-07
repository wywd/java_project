package juc.book2.test;

import juc.book2.n2.util.Sleeper;
import lombok.extern.slf4j.Slf4j;

/**
 * class Test9
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/10/21 13:50
 **/

@Slf4j(topic = "c.Test9")
public class Test9 {
    public static void main(String[] args) {
        Number n1 = new Number();
        new Thread(()->{
            log.debug("begin");
            n1.a();
        }, "t1").start();

        new Thread(()->{
            log.debug("begin");
            n1.b();
        }, "t1").start();
        new Thread(()->{
            log.debug("begin");
            n1.c();
        }, "t3").start();
    }
}

@Slf4j(topic = "c.Number")
class Number {
    public synchronized void a() {
        Sleeper.sleep(1);
        log.debug("1");
    }
    public synchronized void b() {
        log.debug("2");
    }

    public void c() {
        log.debug("3");
    }
}


