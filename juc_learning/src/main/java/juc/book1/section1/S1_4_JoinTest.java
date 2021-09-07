package juc.book1.section1;

/**
 * class JoinTest
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/8/20 22:45
 **/
public class S1_4_JoinTest {
    public static void main(String[] args) throws InterruptedException{
        S1_4_JoinTest test = new S1_4_JoinTest();
//        test.test1();
        test.test2();
    }

    public void test1() throws InterruptedException{
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        System.out.println("wait all child thread over!");

        thread1.join();
        thread2.join();

        System.out.println("all child thread over!");
    }

    public void test2() throws InterruptedException{
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 begin run");
                while (true) {
                    System.out.println("running");
                }
            }
        });

        // 获取主线程
        final Thread mainThread = Thread.currentThread();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainThread.interrupt();
            }
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


