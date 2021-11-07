package juc.book2.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.locks.StampedLock;

/**
 * class TestForkJoin
 *
 **/

@Slf4j(topic = "c.TestForkJoin")
public class TestForkJoin {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(4);
        System.out.println(pool.invoke(new MyTask(1, 16)));

        // new MyTask(5) = 5 + new MyTask(4) = 4 + new MyTask(3) ... 任务拆分
    }

}



//1~n整数求和
@Slf4j(topic = "c.MyTask")
class MyTask extends RecursiveTask<Integer> {
    int begin;
    int end;


    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (begin == end) {
            log.debug("join() {}", begin);
            return begin;
        }
        if (end - begin == 1) {
            int res = end + begin;
            log.debug("join() {} + {} = {}", begin, end, res);
            return res;
        }
        int mid = (end + begin) / 2;
        MyTask t1 = new MyTask(begin, mid);
        t1.fork();
        MyTask t2 = new MyTask(mid + 1, end);
        t2.fork();
        log.debug("fork() {} + {} = ?", t1, t2);
        int res = t1.join() + t2.join();
        log.debug("join() {} + {} = {}", t1, t2, res);
        return res;
    }
}