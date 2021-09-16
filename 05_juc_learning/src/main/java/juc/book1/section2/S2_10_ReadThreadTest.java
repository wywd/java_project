package juc.book1.section2;

/**
 * class S2_10_ReadThreadTest
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/8/22 22:17
 **/
public class S2_10_ReadThreadTest extends Thread {

    private static int num = 0;
    private static boolean ready = false;

    public static void main(String[] args) throws InterruptedException{
        S2_10_ReadThreadTest rt = new S2_10_ReadThreadTest();
        rt.start();

        WriteThread wt = new WriteThread();
        wt.start();

        Thread.sleep(10);
        rt.interrupt();
        System.out.println("main exit");
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (ready) {
                System.out.println(num + num);
            }
            System.out.println("read thread...");
        }
    }

    public static class WriteThread extends Thread {
        @Override
        public void run() {
            num = 2;
            ready = true;
            System.out.println("writeThread set over...");
        }
    }
}




