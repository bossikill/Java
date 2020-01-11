package 并发.ch11_并发编程实践.se10_使用ThreadLocal不当可能会导致内存泄漏;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//线程池中使用ThreadLocal的例子
//如果在线程池里面设置了ThreadLocal变量,则一定要记得及时清理,因为线程池里面的核心现成是一直存在的,
//如果不清理,线程池的核心线程的threadLocals变量一直持有ThreadLocal变量
public class ThreadPoolTest {
    static class LocalVariable {
        private Long[] a = new Long[1024 * 1024];
    }

    final static ThreadPoolExecutor poolExecutor =
            new ThreadPoolExecutor(5,
                    5,
                    1,
                    TimeUnit.MINUTES,
                    new LinkedBlockingQueue<>());

    final static ThreadLocal<LocalVariable> localVariable = new ThreadLocal<LocalVariable>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 50; ++i) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    localVariable.set(new LocalVariable());
                    System.out.println("use local varaible");
                    //localVariable.remove();//不清理会一直占用
                }
            });

            Thread.sleep(1000);
        }
        System.out.println("pool execute over");
    }
}
