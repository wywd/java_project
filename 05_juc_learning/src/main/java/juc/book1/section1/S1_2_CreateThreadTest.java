package juc.book1.section1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// ----------------------------------------------------
//
// 参考书籍：《Java并发编程之美》这本书主要讲Java并发包juc各种api的使用
//
// ----------------------------------------------------
/**
 * class CreateThreadTest
 *
 * @Description
 * 创建线程的三种方式：
 * 1. 继承Thread类并重写run方法
 * 2. 实现Runnable接口的run方法
 * 3. 使用FutureTask方式
 *
 * @Author wangyu
 * @Date 2021/8/19 14:50
 **/
public class S1_2_CreateThreadTest {
    public static void main(String[] args) {
        // 当创建完thread对象后该线程并没有被启动执行，直到调用start方法后才真正启动了线程
        // 并且调用start方法后也没有马上执行run方法，而是处于就绪状态，这个状态是指线程
        // 已经获取了除CPU资源外的其它资源，等待获取CPU资源后进入运行状态
        // 方式1
        MyThread myThread = new MyThread();
        myThread.start();

        //方式2
        RunnableTask task = new RunnableTask();
        new Thread(task).start();
        new Thread(task).start();

        //方式3
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        new Thread(futureTask).start();
        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}

// 第一种方式：继承Thread类并重写run方法
// 好处，获取当前线程直接this就可以了，无须使用Thread.currentThread()
// 方便传参，可以在子类里面添加成员变量，通过set方法或者构造函数传递参数
// 坏处，Java是单继承，无法再继承其它类了，
// 任务与代码没有分离，当多个线程执行一样的任务时，需要多份任务代码
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("I am a child thread in " + this.getClass() + this.currentThread());
    }
}

// 第二种方式：实现Runnable接口的run方法
// 优点，可以做到多个线程共用一份任务代码
// 缺点，是能使用主线程里面声明为final的变量
// 和继承Thread类一样，任务没有返回值
class RunnableTask implements Runnable {
    @Override
    public void run() {
        System.out.println("I am a child thread in " + this.getClass() + Thread.currentThread());
    }
}

// 第三种方式：使用FeatureTask方式
// 优点，任务可以有返回值
// 创建任务类，类似Runnable
class CallerTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Hello " + this.getClass() + Thread.currentThread();
    }
}


