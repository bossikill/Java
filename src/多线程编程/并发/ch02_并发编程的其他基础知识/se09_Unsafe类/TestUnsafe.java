package 多线程编程.并发.ch02_并发编程的其他基础知识.se09_Unsafe类;

import sun.misc.Unsafe;

//unsafe类不能直接使用,要用反射
public class TestUnsafe {
    //获取unsafe的实例
    static final Unsafe unsafe = Unsafe.getUnsafe();

    //记录变量state在类TestUnsafe中的偏移值
    static final long stateOffset;

    //变量
    private volatile long state = 0;

    static {
        try {
            //获取state变量在类TestUnsafe中的偏移值
            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new Error(ex);
        }
    }

    public static void main(String[] args) {
        //创建实例,并且设置state值为1
        TestUnsafe test = new TestUnsafe();
        Boolean sucess = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(sucess);
    }
}
