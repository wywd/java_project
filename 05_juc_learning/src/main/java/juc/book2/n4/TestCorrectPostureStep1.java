package juc.book2.n4;

import juc.book2.n2.util.Sleeper;
import lombok.extern.slf4j.Slf4j;

/**
 * class TestCorrectPostureStep1
 **/

@Slf4j(topic = "c.TestCorrectPostureStep1")
public class TestCorrectPostureStep1 {
    static final Object room = new Object();
    static boolean hasCigarette = false; // 有没有烟
    static boolean hasTakeout = false;

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (room) {
                log.debug("有烟没？[{}]", hasCigarette);
                while (!hasCigarette) {  // 如果是if会有虚假唤醒的问题
                    log.debug("没烟，先歇会！");
//                    Sleeper.sleep(2);
                    try {
                        room.wait();  // 会释放对象锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("有烟没？[{}]", hasCigarette);
                if (hasCigarette) {
                    log.debug("可以开始干活儿了");
                } else  {
                    log.debug("没干成活...");
                }
            }
        }, "小南").start();

        new Thread(() -> {
            synchronized (room) {
                log.debug("外卖送到没？[{}]", hasTakeout);
                while (!hasTakeout) {
                    log.debug("没外卖，先歇会！");
//                    Sleeper.sleep(2);
                    try {
                        room.wait();  // 会释放对象锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("外卖送到没？[{}]", hasTakeout);
                if (hasTakeout) {
                    log.debug("可以开始干活儿了");
                } else  {
                    log.debug("没干成活...");
                }
            }
        }, "小女").start();

//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                synchronized (room) {
//                    log.debug("可以开始干活了");
//                }
//            }, "其它人").start();
//        }

        Sleeper.sleep(1);
        new Thread(() -> {
            // 这里能不能加 synchronized (room)？
            synchronized (room) {
                hasTakeout = true;
                log.debug("外卖到了噢！");
                room.notifyAll();
            }
        }, "送烟的").start();
    }
}
