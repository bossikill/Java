package 并发.ch01_并发编程线程基础.se03_线程通知与等待;

//当前线程只会释放当前共享对象的锁,当前线程持有的其他共享对象的监视器锁并不会被释放
public class index {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //获取resourceA共享资源的监视器锁
                    synchronized (resourceA) {
                        System.out.println("threadA get resourceA lock");

                        //获取resourceB共享资源的监视器锁
                        synchronized (resourceB) {
                            System.out.println("threadA get resourceB lock");
                            //线程A阻塞,并释放获取到的resourceA的锁
                            System.out.println("threadA release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //创建线程
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //休眠1s
                    Thread.sleep(1000);

                    //获取resourceA共享资源的监视器锁
                    synchronized (resourceA) {
                        System.out.println("threadB get resourceA lock");

                        System.out.println("threadB try get resourceB lock...");
                        //获取resourceB共享资源的监视器锁
                        synchronized (resourceB) {
                            System.out.println("threadB get resourceB lock");

                            //线程B阻塞,并释放获取到的resourceA的锁
                            System.out.println("threadB release resourceA lock");
                            resourceA.wait();
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        System.out.println("main over");
    }
}
