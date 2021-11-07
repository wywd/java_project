package juc.book2.test;

import juc.book2.n2.util.Sleeper;
import lombok.extern.slf4j.Slf4j;

/**
 * class Test12
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/10/26 12:47
 **/

@Slf4j(topic = "c.Test12")
public class Test12 {
//    volatile static boolean run = true;
    static boolean run = true;

    final static Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (!run) {
                        break;
                    }
                }
                // do something
            }
        });
        t1.start();
        Sleeper.sleep(1);
        log.debug("停止t1线程...");
        synchronized (lock) {
            run = false;
        }
    }
}
