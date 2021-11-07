package juc.book2.test;

import juc.book2.n2.util.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * class Test17
 *
 **/

@Slf4j(topic = "c.Test17")
public class Test17 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    log.debug("running...");
                    Sleeper.sleep(1);
                    log.debug("end...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
