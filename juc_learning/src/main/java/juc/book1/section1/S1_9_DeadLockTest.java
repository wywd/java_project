package juc.book1.section1;

/**
 * class S1_9_DeadLockTest
 *
 * @Description //死锁
 * @Author wangyu
 * @Date 2021/8/21 14:40
 **/
public class S1_9_DeadLockTest {
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) {
        // 1. 什么是死锁？
        // 死锁是指两个或者两个以上的线程在执行过程中，因争夺资源而造成互相等待的现象，
        // 在无外力的作用下，这些线程会一直相互等待而无法继续运行下去
        // 2. 产生死锁的条件？
        // 互斥条件、请求并持有条件、不可剥夺条件、环路等待条件
        // 3. 如何避免死锁？
        // 破坏掉至少一个构成死锁的必要条件即可，目前只有请求并持有和环路等待条件是可以被破坏的
        // 例如：保证资源申请的有序性原则可以避免死锁
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread() + " get ResourceA");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + " waiting get ResourceB");
                    synchronized (resourceB) {
                        System.out.println(Thread.currentThread() + " get ResourceB");
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread() + " get ResourceB");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread() + " waiting get ResourceA");
                    synchronized (resourceA) {
                        System.out.println(Thread.currentThread() + "get ResourceA");
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
