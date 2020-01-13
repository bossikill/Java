package 多线程编程.并发.ch01_并发编程线程基础.se04_等待线程执行终止的join方法;

public class index2 {
    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadOne begin up!");
                for (; ; ) {

                }
            }
        });

        //获取主线程
        final Thread mainThread = Thread.currentThread();

        //线程two
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                mainThread.interrupt();
                //threadOne.interrupt();
            }
        });

        //启动子线程
        threadOne.start();
        //延迟1s启动线程
        threadTwo.start();

        try {
            //等待线程one执行结束
            threadOne.join();
        } catch (Exception e) {
            System.out.println("main thread:" + e);
        }
    }
}
