package juc.book2.test;

import juc.book2.Constants;
import juc.book2.n2.util.FileReader;
import lombok.extern.slf4j.Slf4j;

/**
 * class Test4
 *
 * @Description // TODO
 * @Author wangyu
 * @Date 2021/10/19 21:43
 **/

@Slf4j(topic = "c.Test4")
public class Test4 {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                FileReader.read(Constants.MP4_FULL_PATH);
                log.debug("running...");
            }
        };
        log.debug("{}", t1.getState());
        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("{}", t1.getState());
        log.debug("do other things...");
    }
}
