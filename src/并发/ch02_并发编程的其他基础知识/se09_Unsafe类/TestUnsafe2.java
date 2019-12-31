package 并发.ch02_并发编程的其他基础知识.se09_Unsafe类;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

//使用反射操作unsafe类
public class TestUnsafe2 {
    //获取unsafe的实例
    static final Unsafe unsafe;

    //记录变量state在类TestUnsafe中的偏移值
    static final long stateOffset;

    //变量
    private volatile long state = 0;

    static {
        try {
            //使用反射获取Unsafe的成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置为可存取
            field.setAccessible(true);
            //获取该变量的值
            unsafe = (Unsafe) field.get(null);
            //获取state变量在类TestUnsafe中的偏移值
            stateOffset = unsafe.objectFieldOffset(TestUnsafe2.class.getDeclaredField("state"));
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new Error(ex);
        }
    }

    public static void main(String[] args) {
        //创建实例,并且设置state值为1
        TestUnsafe2 test = new TestUnsafe2();
        Boolean sucess = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(sucess);
    }
}
