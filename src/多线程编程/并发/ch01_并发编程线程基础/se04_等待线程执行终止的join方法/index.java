package 多线程编程.并发.ch01_并发编程线程基础.se04_等待线程执行终止的join方法;

//join  等待一个线程结束
public class index {
    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("child threadOne over!");
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("child threadTwo over!");
            }
        });

        threadOne.start();
        threadTwo.start();

        System.out.println("wait all child thread over!");

        threadOne.join();
        threadTwo.join();

        System.out.println("all child thread over!");
    }
}
