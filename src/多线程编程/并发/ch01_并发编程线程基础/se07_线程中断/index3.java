package 多线程编程.并发.ch01_并发编程线程基础.se07_线程中断;

//interrupted()与isInterrupted()不同之处
public class index3 {
    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });

        threadOne.start();
        threadOne.interrupt();
        //获取中断标志
        System.out.println("isInterrupted:" + threadOne.isInterrupted());
        //获取中断标志并重置
        System.out.println("isInterrupted:" + threadOne.interrupted());
        //获取中断标志并重置,上下两行作用相等,interrupted()获取的是当前的线程
        System.out.println("isInterrupted:" + Thread.interrupted());
        //获取中断标志
        System.out.println("isInterrupted:" + threadOne.isInterrupted());

        threadOne.join();
        System.out.println("main thread is over");
    }
}
