package juc.book2.test;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

/**
 * class TestBiased
 **/
@Slf4j(topic = "c.TestBiased")
public class TestBiased {
    public static void main(String[] args) throws InterruptedException {
        Dog dog = new Dog();
        log.info(ClassLayout.parseInstance(dog).toPrintable());
        synchronized (dog) {
            log.debug(ClassLayout.parseInstance(dog).toPrintable());
        }
        log.info(ClassLayout.parseInstance(dog).toPrintable());
    }
}


class Dog {

}