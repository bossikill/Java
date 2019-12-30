package 并发.ch01_并发编程线程基础.se09_线程死锁;

//模拟线程死锁
public class DeadLockTest {
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

                    System.out.println(Thread.currentThread() + "waiting get resourceB");
                    synchronized (resourceB) {
                        System.out.println(Thread.currentThread() + "get resourceB");
                    }
                }
            }
        });

        //创建线程
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread() + " get ResourceB");

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread() + "waiting get resourceA");
                    synchronized (resourceA) {
                        System.out.println(Thread.currentThread() + "get resourceA");
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
