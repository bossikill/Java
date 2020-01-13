package 多线程编程.并发.ch11_并发编程实践.se07_创建线程需要有线程名;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//创建线程池时也需要指定线程池的名称
public class index3 {
    static ThreadPoolExecutor executorOne = new ThreadPoolExecutor(
            5,
            5,
            1,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue<>());
    static ThreadPoolExecutor executorTwo = new ThreadPoolExecutor(
            5,
            5,
            1,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue<>());

    public static void main(String[] args) {
        //接受用户链接模块
        executorOne.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("接受用户链接线程");
                throw new NullPointerException();
            }
        });

        //具体处理永辉请求模块
        executorTwo.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("具体处理永辉请求模块");
            }
        });

        executorOne.shutdown();
        executorTwo.shutdown();
    }
}
