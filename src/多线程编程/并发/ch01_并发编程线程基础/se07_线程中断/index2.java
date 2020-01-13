package 多线程编程.并发.ch01_并发编程线程基础.se07_线程中断;

//调用线程的interrupt(),强制sleep方法抛出异常返回
public class index2 {
    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("threadOne begin sleep for 2000 seconds");
                    Thread.sleep(2000000);
                    System.out.println("threadOne awaking");
                } catch (Exception e) {
                    System.out.println("threadOne is interrupted while sleeping");
                    return;
                }

                System.out.println("threadOne-leaving normally");
            }
        });

        threadOne.start();
        Thread.sleep(1000);
        threadOne.interrupt();
        threadOne.join();
        System.out.println("main thread is over");
    }
}
