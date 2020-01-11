package 并发.ch10_Java并发包中线程同步器原理剖析;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//回环屏障
public class CycleBarrierTest2 {
    //创建一个CyclicBarrier实例
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //将线程A添加到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + " step1");
                    cyclicBarrier.await();

                    System.out.println(Thread.currentThread() + " step2");
                    cyclicBarrier.await();

                    System.out.println(Thread.currentThread() + " step3");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //将线程B添加到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + " step1");
                    cyclicBarrier.await();

                    System.out.println(Thread.currentThread() + " step2");
                    cyclicBarrier.await();

                    System.out.println(Thread.currentThread() + " step3");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.shutdown();
    }
}
