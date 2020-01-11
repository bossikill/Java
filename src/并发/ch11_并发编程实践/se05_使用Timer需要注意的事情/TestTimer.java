package 并发.ch11_并发编程实践.se05_使用Timer需要注意的事情;

import java.util.Timer;
import java.util.TimerTask;

//timer的一个进程异常未捕获,其他进程会被清空
//可以使用ScheduledThreadPoolExecutor代替timer实现定时功能
public class TestTimer {
    //创建定时器对象
    static Timer timer = new Timer();

    public static void main(String[] args) {
        //添加任务1,延迟500ms执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("---one Task---");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                    //未被捕获的异常
                    throw new RuntimeException("error ");
                }
            }
        }, 500);

        //添加任务2,延迟1000ms执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (; ; ) {
                    System.out.println("---two Task---");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 1000);
    }
}
