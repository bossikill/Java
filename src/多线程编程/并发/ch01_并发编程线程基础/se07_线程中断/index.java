package 多线程编程.并发.ch01_并发编程线程基础.se07_线程中断;

//使用Interrupted优雅退出的经典例子
public class index {
    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //如果当前线程被中断则退出循环
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread() + " hello");
                }
            }
        });

        thread.start();

        System.out.println("sleep....");
        Thread.sleep(1000);

        System.out.println("main thread interrupt thread");
        thread.interrupt();

        thread.join();
        System.out.println("main is over");
    }
}
