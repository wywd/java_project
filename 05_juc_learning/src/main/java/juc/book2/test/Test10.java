package juc.book2.test;

import juc.book2.n2.util.Sleeper;
import juc.book2.pattern.DownLoader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.*;

/**
 * class Test10
 *
 **/

@Slf4j(topic = "c.Test10")
public class Test10 {
    // 线程1等待线程2的下载结果
    public static void main(String[] args) {
//        GuardedObject guardedObject = new GuardedObject();
//        new Thread(() -> {
//            // 等待结果
//            log.debug("等待结果...");
//            List<String> list = (List<String>) guardedObject.getObject(3000);
//            log.debug("结果是：{}", list);
//        }, "t1").start();

//        new Thread(() -> {
//            log.debug("执行下载");
//            try {
//                List<String> list = DownLoader.download();
//                guardedObject.complete(list);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }, "t2").start();

        for (int i = 0; i < 3; i++) {
            new People().start();
        }
        Sleeper.sleep(1);
        for (int id: Mailboxes.getIds()) {
            new Postman(id, "内容" + id).start();
        }
    }
}


@Slf4j(topic = "c.People")
class People extends Thread {
    @Override
    public void run() {
        // 收信
        GuardedObject guardedObject = Mailboxes.createGuardedObject();
        log.debug("开始收信 id:{}", guardedObject.getId());
        Object mail = guardedObject.getObject(5000);
        log.debug("收到信 id:{}，内容：{}", guardedObject.getId(), mail);
    }
}

@Slf4j(topic = "c.Postman")
class Postman extends Thread {
    private int id;
    private String mail;

    public Postman(int id, String mail) {
        this.id = id;
        this.mail = mail;
    }


    @Override
    public void run() {
        GuardedObject guardedObject = Mailboxes.getGuardedObject(id);
        log.debug("送信 id：{}，内容：{}", guardedObject.getId(), mail);
        guardedObject.complete(mail);
    }
}

class Mailboxes {
    private static Map<Integer, GuardedObject> boxes = new Hashtable<>();

    private static int id = 1;

    private static synchronized int generatedId() {
        return id++;
    }

    public static GuardedObject createGuardedObject() {
        GuardedObject guard = new GuardedObject(generatedId());
        boxes.put(guard.getId(), guard);
        return guard;
    }

    public static Set<Integer> getIds() {
        return boxes.keySet();
    }

    public static GuardedObject getGuardedObject(int id) {
        return boxes.remove(id);
    }
}


class GuardedObject {
    private int id;  // 用来标识Guarded Object
    private Object response;

    public GuardedObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // 结果  表示最多等待多久
    public Object getObject(long timeout) {
        synchronized (this) {
            // 开始时间
            long begin = System.currentTimeMillis();
            // 经历的时间
            long passedTime = 0;
            while (response == null) {
                // 经历的时间超过最大等待时间，退出循环
                if (passedTime >= timeout) {
                    break;
                }
                try {
                    this.wait(timeout - passedTime);  // 等待的过程中被虚假唤醒了， 避免导致等待时间边长
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 求经历的时间是多久
                passedTime = System.currentTimeMillis() - begin;
            }
            return response;
        }
    }

    public void complete(Object response) {
        synchronized (this) {
            // 给结果成员变量赋值
            this.response = response;
            this.notifyAll();
        }
    }
}



