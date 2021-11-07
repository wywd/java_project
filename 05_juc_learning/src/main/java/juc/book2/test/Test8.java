package juc.book2.test;

import lombok.extern.slf4j.Slf4j;

/**
 * class Test8
 *
 **/
@Slf4j(topic = "c.Test8")
public class Test8 {
    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 10; j++) {   // 运行多次看效果
            Room room = new Room();
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < 5000; i++) {
                    room.increment();
                }
            });

            Thread t2 = new Thread(() -> {
                for (int i = 0; i < 5000; i++) {
                    room.decrement();
                }
            });
            Thread t3 = new Thread(() -> {
                for (int i = 0; i < 5000; i++) {
                    room.increment();
                }
            });

            Thread t4 = new Thread(() -> {
                for (int i = 0; i < 5000; i++) {
                    room.decrement();
                }
            });
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            log.debug("{}", room.getCounter());
        }
    }
}

class Room {
    private int counter = 0;

    public void decrement() {
        synchronized (this) {
            counter--;
        }
    }

    public void increment() {
        synchronized (this) {
            counter++;
        }
    }

    int getCounter() {
//        synchronized (this) {  // 如果是join后再读出，应该不用上锁
            return counter;
//        }
    }
}
