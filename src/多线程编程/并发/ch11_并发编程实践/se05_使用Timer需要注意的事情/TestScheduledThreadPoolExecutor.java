package 多线程编程.并发.ch11_并发编程实践.se05_使用Timer需要注意的事情;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestScheduledThreadPoolExecutor {

    static ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);

    public static void main(String[] args) {

        scheduledThreadPoolExecutor.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("---one Task---");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("error ");
            }
        }, 500, TimeUnit.MILLISECONDS);

        scheduledThreadPoolExecutor.schedule(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; ++i) {
                    System.out.println("---two Task---");

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 1000, TimeUnit.MILLISECONDS);

        scheduledThreadPoolExecutor.shutdown();
    }
}
