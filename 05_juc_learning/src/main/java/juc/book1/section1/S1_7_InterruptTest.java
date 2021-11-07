package juc.book1.section1;

/**
 * class S1_7_InterruptTest
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/8/21 12:04
 **/
public class S1_7_InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        S1_7_InterruptTest test = new S1_7_InterruptTest();
        test.test1();
    }

    public void test1() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        });

        thread.start();
        // 中断线程，设置线程thread的中断标志为True，实际线程thread并不会中断，会继续执行。
        // 当线程thread调用了wait，join，sleep等方法而被阻塞挂起的时候，若调用了interrupt方法，会抛出异常而返回
        thread.interrupt();

        // boolean isInterrupted() 方法检测当前线程是否被中断，是实例方法。
        // boolean interrupted() 方法检测当前线程是否被中断，是静态方法，会清除中断标志，
        // 该方法获取的是当前线程的中断标志而不是调用interrupted()方法的实例对象的中断标志

        System.out.println("thread.isInterrupted():" + thread.isInterrupted());
        System.out.println("Thread.interrupted():" + Thread.interrupted());
        System.out.println("Thread.interrupted():" + Thread.interrupted());
        System.out.println("thread.isInterrupted():" + thread.isInterrupted());
        thread.join();
    }
}
