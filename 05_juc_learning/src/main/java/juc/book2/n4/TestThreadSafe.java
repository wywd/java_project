package juc.book2.n4;


import java.util.ArrayList;

/**
 * class TestThreadSafe
 **/

public class TestThreadSafe {

    static final int THREAD_NUMBER = 10;
    static final int LOOP_NUMBER = 200;
    public static void main(String[] args) {
        ThreadSafeSubClass test = new ThreadSafeSubClass();
//        ThreadUnsafe test = new ThreadUnsafe();
//        ThreadSafe test = new ThreadSafe();
        for (int i = 0; i < THREAD_NUMBER; i++) {
            new Thread(() -> {
                test.method1(LOOP_NUMBER);
            }, "Thread" + (i+1)).start();
        }
    }
}
class ThreadUnsafe {
    ArrayList<String> list = new ArrayList<>();
    public void method1(int loopNumber) {
        for (int i = 0; i < loopNumber; i++) {
            method2();
            method3();
        }
    }

    private void method2() {  // 临界区，有修改
        list.add("1");
    }

    private void method3() {  // 临界区，有修改
        list.remove(0);
    }
}

class ThreadSafe {
    public final void method1(int loopNumber) {  // 这样每个线程调用这个方法的时候，都会创建一个list对象
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < loopNumber; i++) {
            method2(list);
            method3(list);
        }
    }

    public void method2(ArrayList<String> list) {
        list.add("1");
    }

    public void method3(ArrayList<String> list) {
//        System.out.println(1);
        list.remove(0);
    }
}

class ThreadSafeSubClass extends ThreadSafe{
    @Override
    public void method3(ArrayList<String> list) {
//        System.out.println(2);
        new Thread(() -> {
            list.remove(0);
        }).start();
    }
}
