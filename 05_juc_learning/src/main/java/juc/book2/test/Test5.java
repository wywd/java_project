package juc.book2.test;

import lombok.extern.slf4j.Slf4j;

/**
 * class Test5
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/10/19 22:06
 **/
@Slf4j(topic = "c.Test5")
public class Test5 {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.debug("enter sleep...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.debug("wake up...");
                    e.printStackTrace();
                }
            }
        };
        t1.setPriority(6);  // 仅仅是一个提示，操作系统可能会忽略
        t1.start();
        try {
            t1.join();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("interrupt...");
        t1.interrupt();
    }
}
