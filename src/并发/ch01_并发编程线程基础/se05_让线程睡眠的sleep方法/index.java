package 并发.ch01_并发编程线程基础.se05_让线程睡眠的sleep方法;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//线程在睡眠时拥有的监视器资源不会被释放
public class index {
    //创建一个独占锁
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取独占锁
                lock.lock();
                try {
                    System.out.println("child threadA is in sleep");
                    Thread.sleep(3000);
                    System.out.println("child threadA is in awaked");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //释放锁
                    lock.unlock();
                }
            }
        });

        //创建线程
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取独占锁
                lock.lock();
                try {
                    System.out.println("child threadB is in sleep");
                    Thread.sleep(3000);
                    System.out.println("child threadB is in awaked");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //释放锁
                    lock.unlock();
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
