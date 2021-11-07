package juc.book2.test;

import lombok.extern.slf4j.Slf4j;

/**
 * class Test6
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/10/19 22:50
 **/
@Slf4j(topic = "c.Test6")
public class Test6 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug("sleep...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.debug("interrupt...");
        t1.interrupt();
        log.debug("打断标记：{}", t1.isInterrupted());
    }
}
