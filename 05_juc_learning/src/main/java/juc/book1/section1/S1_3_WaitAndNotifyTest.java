package juc.book1.section1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * class WaitAndNotifyTest
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/8/19 16:19
 **/
public class S1_3_WaitAndNotifyTest {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException{
        S1_3_WaitAndNotifyTest test = new S1_3_WaitAndNotifyTest();
//        test.test1();
//        test.test2();
//        test.test3();
        test.test4();
    }

    // 经典的调用共享变量wait方法的代码编写方式：首先通过同步块获取obj上面的监视器，完后在while循环内调用obj的wait方法
    public void test1() throws InterruptedException {
        QueueTest queueTest = new QueueTest();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; ++i) {
                    queueTest.producer(i);
                    System.out.println("Producer: " + i + " " + Thread.currentThread());
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; ++i) {
                    queueTest.producer(i);
                    System.out.println("Producer: " + i + " " + Thread.currentThread());
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; ++i) {
                    queueTest.consumer();
                    System.out.println("Consumer: " + i + " " + Thread.currentThread());
                }
            }
        });
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; ++i) {
                    queueTest.consumer();
                    System.out.println("Consumer: " + i + " " + Thread.currentThread());
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    // 当前线程调用共享变量的wait()方法后，只会释放当前共享变量上的锁，
    // 如果当前变量还持有其它共享变量的锁，则这些锁是不会释放的
    public void test2() throws InterruptedException {
        // 创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 获取resourceA共享资源的监视器锁
                    synchronized (resourceA) {
                        System.out.println("threadA get resourcesA lock");
                        // 获取resourceB的共享监视器锁
                        synchronized (resourceB) {
                            System.out.println("threadA get resourcesB lock");

                            //线程A阻塞，并释放获取到的resourceA锁
                            System.out.println("threadA release resourcesA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 创建线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 休眠1s
                    Thread.sleep(1000);
                    synchronized (resourceA) {
                        System.out.println("threadB get resourcesA lock");
                        System.out.println("threadB try get resourceB lock...");
                        synchronized (resourceB) {
                            System.out.println("threadB get resourcesB lock");
                            System.out.println("threadB release resourcesA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 启动线程
        threadA.start();
        threadB.start();

        //等待两个线程结束
        threadA.join();
        threadB.join();

        System.out.println("main over");
    }

    // 当一个线程调用共享对象wait()方法被阻塞挂起后，
    // 如果其它线程中断了该线程，则该线程会抛出InterruptException异常并返回
    public void test3() throws InterruptedException{
        Object obj = new Object();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("-----begin-----");
                    // 阻塞当前线程
                    synchronized (obj) {
                        obj.wait();
                    }
                    System.out.println("-----end-----");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        Thread.sleep(1000);
        System.out.println("-----begin interrupt threadA-----");
        threadA.interrupt();
        System.out.println("-----end interrupt threadA-----");
    }

    // 一个线程调用notify()方法后，会唤醒一个在该共享变量上调用wait系方法后被挂起的变量
    // notify()随机唤醒一个线程，notifyAll()方法则会唤醒所有该共享变量上由于调用wait系列方法而被挂起的线程
    public void test4() throws InterruptedException{
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadA get resourceA lock");
                    try {
                        System.out.println("threadA begin wait");
                        resourceA.wait();
                        System.out.println("threadA end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadB get resourceA lock");
                    try {
                        System.out.println("threadB begin wait");
                        resourceA.wait();
                        System.out.println("threadB end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadC begin notify");
//                    resourceA.notify();
                    resourceA.notifyAll();
                }
            }
        });
        threadA.start();
        threadB.start();
        Thread.sleep(1000);
        threadC.start();
        threadA.join();
        threadB.join();
        threadC.join();
    }
}


// test1 队列
class QueueTest {
    private Queue queue = new LinkedList<Integer>();
    private static final int MAX_SIZE = 10;
    // 一个线程如何获取一个共享变量的监视器锁呢？
    // 1. 执行synchronized同步代码块，使用该共享变量作为参数
    // 2. 调用该共享变量的方法，并使用synchronized修饰该方法

    //生产者线程
//    public synchronized void producer(int element) {
    public void producer(int element) {
        synchronized (queue) {
            // 消费队满，则等待队列空闲
            // 在一个循环中调用wait方法，防范虚假唤醒！
            while (queue.size() == MAX_SIZE) {
                try {
                    // 挂起当前线程，并释放通过同步块获得的queue上的锁，让消费者线程可以获得该锁，
                    // 然后此线程阻塞挂起，直到：
                    // 1. 其它线程调用了该共享变量的notify()或者notifyAll()方法
                    // 2. 其它线程调用了该线程的interrupt()方法，该线程抛出InterruptedException异常返回
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 空闲则生成元素，并通知消费者线程
            queue.add(element);
            queue.notifyAll();
        }
    }
    //消费者线程
//    public  synchronized void consumer() {
    public void consumer() {
        synchronized (queue) {
            while (queue.size() == 0) {
                try {
                    // 挂起当前线程，并释放queue上的锁，让生产者线程可以获得该锁，将生产元素放入queue
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 消费元素，并通知生产者线程
            queue.remove();
            queue.notifyAll();
        }
    }
}

