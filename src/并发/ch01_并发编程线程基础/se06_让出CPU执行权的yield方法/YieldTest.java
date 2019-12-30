package 并发.ch01_并发编程线程基础.se06_让出CPU执行权的yield方法;

//yield 线程让出自己剩余的时间片,没有被阻塞挂起,处于就绪状态
public class YieldTest implements Runnable {
    YieldTest() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            //当i=0时出让CPU执行权,放弃时间片,进行下一轮调度
            if ((i % 5) == 0) {
                System.out.println(Thread.currentThread() + "yield cpu...");

                //当前线程让出CPU执行权,放弃时间片,进行下一轮调度
                //Thread.yield();
            }
        }

        System.out.println(Thread.currentThread() + " is over");
    }

    public static void main(String[] args) {
        new YieldTest();
        new YieldTest();
        new YieldTest();
    }
}
