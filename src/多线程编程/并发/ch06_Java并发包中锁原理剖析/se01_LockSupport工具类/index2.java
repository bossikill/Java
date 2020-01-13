package 多线程编程.并发.ch06_Java并发包中锁原理剖析.se01_LockSupport工具类;

import java.util.concurrent.locks.LockSupport;

//获得许可证,调用park直接返回
public class index2 {
    public static void main(String[] args) {
        System.out.println("begin park!");

        //使当前线程获取许可证
        LockSupport.unpark(Thread.currentThread());

        //再次调用park方法
        LockSupport.park();

        System.out.println("end park!");
    }
}
