package juc.book1.section2;

import sun.misc.Unsafe;

/**
 * class S2_9_UnsafeTest
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/8/22 21:53
 **/
public class S2_9_UnsafeTest {
    // 获取unsafe实例
    static final Unsafe unsafe = Unsafe.getUnsafe();
    // 记录变量state在类TestUnSafe中的偏移值
    static final long stateOffset;
    // 变量
    private volatile long state = 0;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(S2_9_UnsafeTest.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        S2_9_UnsafeTest test = new S2_9_UnsafeTest();
        Boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);
    }


}

