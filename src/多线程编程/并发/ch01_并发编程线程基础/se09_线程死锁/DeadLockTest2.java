package 多线程编程.并发.ch01_并发编程线程基础.se09_线程死锁;

//解决线程死锁,只有在获取了资源n-1时才能去获取资源n
public class DeadLockTest2 {
    //创建资源
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) {
        //创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread() + " get resourceA");

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread() + " waiting get resourceB");
                    synchronized (resourceB) {
                        System.out.println(Thread.currentThread() + " get resourceB");
                    }
                }
            }
        });

        //创建线程
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread() + " get ResourceB");

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread() + " waiting get resourceA");
                    synchronized (resourceB) {
                        System.out.println(Thread.currentThread() + " get resourceA");
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
