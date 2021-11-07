package juc.book2.n8;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.concurrent.*;

import static juc.book2.n2.util.Sleeper.sleep;

/**
 * class TestCyclicBarrier
 *
 **/

@Slf4j(topic = "c.TestCycliBarrier")
public class TestCyclicBarrier {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        CyclicBarrier barrier = new CyclicBarrier(2, ()-> {
            log.debug("task1, task2 finish...");
        });
        for (int i = 0; i < 3; i++) { // task1  task2  task1
            service.submit(() -> {
                log.debug("task1 begin...");
                sleep(1);
                try {
                    barrier.await(); // 2-1=1
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            service.submit(() -> {
                log.debug("task2 begin...");
                sleep(2);
                try {
                    barrier.await(); // 1-1=0
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        service.shutdown();
    }

    private static void test1() {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 3; i++) {
            CountDownLatch latch = new CountDownLatch(2);
            service.submit(() -> {
                log.debug("task1 start...");
                sleep(1);
                latch.countDown();
            });
            service.submit(() -> {
                log.debug("task2 start...");
                sleep(2);
                latch.countDown();
            });
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("task1 task2 finish...");
        }
        service.shutdown();
    }
}
