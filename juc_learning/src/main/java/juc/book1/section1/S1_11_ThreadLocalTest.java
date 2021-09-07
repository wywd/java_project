package juc.book1.section1;

/**
 * class S1_11_ThreadLocalTest
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/8/21 15:27
 **/
public class S1_11_ThreadLocalTest {
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    static void print(String str) {
        // 打印当前本地内存中的localVariable变量的值
        System.out.println(str + ":" + localVariable.get());
        // 清除当前线程本地内存中的localVariable变量
        localVariable.remove();
    }

    public static void main(String[] args) {
        S1_11_ThreadLocalTest test = new S1_11_ThreadLocalTest();
//        test.test1();
        test.test2();
    }

    // ThreadLocal提供了线程本地变量，如果创建了ThreadLocal变量，每个访问这个变量的线程都会有这个变量的一个本地副本
    // 因此多个线程操作这个变量时，实际操作的是自己本地内存里面的变量，从而避免了线程安全问题
    public void test1() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("thread1 local variable");
                print("thread1");
                System.out.println("thread1 remove after:" + localVariable.get());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("thread2 local variable");
                print("thread2");
                System.out.println("thread2 remove after:" + localVariable.get());
            }
        });

        thread1.start();
        thread2.start();
    }

    // 同一个ThreadLocal变量在父线程中被设置值后，在子线程中获取不到
    public void test2() {
        localVariable.set("hello world");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread:" + localVariable.get());
            }
        });
        thread.start();
        System.out.println("main:" + localVariable.get());
    }
}
