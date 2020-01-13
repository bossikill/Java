package 多线程编程.并发.ch06_Java并发包中锁原理剖析.se01_LockSupport工具类;

import java.util.concurrent.locks.LockSupport;

//jstack可以查看堆栈信息
public class TestPark {
    public void testPark() {
        //jps jstack
        LockSupport.park();
        //LockSupport.park(this);//blocker参数提供更多信息
    }

    public static void main(String[] args) {
        TestPark testPark = new TestPark();
        testPark.testPark();
    }
}
