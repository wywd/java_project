package juc.book2.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * class Test16
 **/
public class Test16 {
    public static void main(String[] args) {
        long ct = 0;
        for (int i = 0; i < 10; i++) {
            ct += demo(
                    () -> new AtomicLong(0),
                    (adder) -> adder.getAndIncrement()
            );
        }
        System.out.println("=====> avg time: " + ct / 10);
        ct=0;
        System.out.println("========================= ");
        for (int i = 0; i < 10; i++) {
            ct += demo(
                    () -> new LongAdder(),
                    adder -> adder.increment()
            );
        }
        System.out.println("=====> avg time: " + ct / 10);
    }

    /*
    () -> 结果    提供累加器对象
    (参数) ->     执行累加操作
     */
    private static <T> long demo(Supplier<T> adderSupplier, Consumer<T> action) {
        T adder = adderSupplier.get();
        List<Thread> ts = new ArrayList<>();
        // 4 个线程，每人累加 50 万
        for (int i = 0; i < 4; i++) {
            ts.add(new Thread(() -> {
                for (int j = 0; j < 1000000; j++) {
                    action.accept(adder);
                }
            }));
        }
        long start = System.nanoTime();
        ts.forEach(t -> t.start());
        ts.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long end = System.nanoTime();
        System.out.println(adder + " cost:" + (end - start) / 1000_000);
        return (end - start) / 1000_000;
    }
}
