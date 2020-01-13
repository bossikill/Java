package 多线程编程.并发.ch06_Java并发包中锁原理剖析.se01_LockSupport工具类;

import java.util.concurrent.locks.LockSupport;

//默认情况下调用线程不是持有许可证的
public class index {
    public static void main(String[] args) {
        System.out.println("begin park!");

        LockSupport.park();

        System.out.println("end park!");
    }
}
