package juc.book2.n8;

import juc.book2.n2.util.Sleeper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static juc.book2.n2.util.Sleeper.sleep;

/**
 * class TestCountDownLatch
 *
 **/

@Slf4j(topic = "c.testCountDownLaunch")
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        test3();
    }
    
    private static void test5() {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(() -> {
            log.debug("begin...");
            sleep(1);
            latch.countDown();
            log.debug("end...{}", latch.getCount());
        });
        service.submit(() -> {
            log.debug("begin...");
            sleep(1.5);
            latch.countDown();
            log.debug("end...{}", latch.getCount());
        });
        service.submit(() -> {
            log.debug("begin...");
            sleep(2);
            latch.countDown();
            log.debug("end...{}", latch.getCount());
        });
        service.submit(()->{
            try {
                log.debug("waiting...");
                latch.await();
                log.debug("wait end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static void test4() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        new Thread(() -> {
            log.debug("begin...");
            sleep(1);
            latch.countDown();
            log.debug("end...{}", latch.getCount());
        }).start();

        new Thread(() -> {
            log.debug("begin...");
            sleep(2);
            latch.countDown();
            log.debug("end...{}", latch.getCount());
        }).start();

        new Thread(() -> {
            log.debug("begin...");
            sleep(1.5);
            latch.countDown();
            log.debug("end...{}", latch.getCount());
        }).start();

        log.debug("waiting...");
        latch.await();
        log.debug("wait end...");
    }

    private static void test3() throws InterruptedException, ExecutionException {
        RestTemplate restTemplate = new RestTemplate();
        ExecutorService service = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(4);
        log.debug("begin");

        service.submit(() -> {
            Map<String, Object> response = restTemplate.getForObject("http://localhost:8080/order/{1}", Map.class, 1);
            log.debug("end order: {}", response);
            latch.countDown();

        });
        service.submit(() -> {
            Map<String, Object> response1 = restTemplate.getForObject("http://localhost:8080/product/{1}", Map.class, 1);
            log.debug("end product: {}", response1);
            latch.countDown();
        });
        service.submit(() -> {
            Map<String, Object> response1 = restTemplate.getForObject("http://localhost:8080/product/{1}", Map.class, 2);
            log.debug("end product: {}", response1);
            latch.countDown();
        });
        service.submit(() -> {
            Map<String, Object> response3 = restTemplate.getForObject("http://localhost:8080/logistics/{1}", Map.class, 1);
            log.debug("end logistics: {}", response3);
            latch.countDown();
        });

        latch.await();
        log.debug("执行完毕");
        service.shutdown();
    }

    private static void test2() throws InterruptedException {
        AtomicInteger num = new AtomicInteger(0);
        ExecutorService service = Executors.newFixedThreadPool(10, (r) -> new Thread(r, "t" + num.getAndIncrement()));
        CountDownLatch latch = new CountDownLatch(10);
        String[] all = new String[10];
        Random r = new Random();

        for (int j = 0; j < 10; j++) {
            int x = j;
            service.submit(() -> {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(r.nextInt(200));
                    } catch (InterruptedException e) {
                    }
                    all[x] = Thread.currentThread().getName() + "(" + (i + "%") + ")";
                    System.out.print("\r" + Arrays.toString(all));
                }
                latch.countDown();
            });
        }
        latch.await();
        System.out.println("\n游戏开始...");
        service.shutdown();
    }
}
