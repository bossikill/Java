package 并发.ch11_并发编程实践.se08_线程池记得调用shutdown;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//关闭线程池,否则JVM不会关闭
public class TestShutdown {
    static void asynExecuteOne() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("--async execute one ---");
            }
        });
        //关闭线程池,否则JVM不会关闭
        executor.shutdown();
    }

    static void asynExecuteTwo() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("--async execute two ---");
            }
        });
        //关闭线程池,否则JVM不会关闭
        executor.shutdown();
    }

    public static void main(String[] args) {
        //1 同步执行
        System.out.println("--sync execute---");
        //2 异步执行操作one
        asynExecuteOne();
        //3 异步执行操作two
        asynExecuteTwo();
        //4 执行完毕
        System.out.println("---execute over---");
    }
}
