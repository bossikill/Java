package 多线程编程.并发.ch06_Java并发包中锁原理剖析.se01_LockSupport工具类;

import java.util.concurrent.locks.LockSupport;

//获得许可证,调用park直接返回
public class index3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park!");

                //调用park方法,挂起自己
                LockSupport.park();

                System.out.println("child thread unpark!");
            }
        });

        thread.start();

        Thread.sleep(1000);

        System.out.println("main thread begin unpark!");

        //调用unpark方法让thread线程持有许可证,然后park方法返回
        //LockSupport.unpark(thread);
        //中断子线程
        thread.interrupt();
    }
}
