package 并发.ch06_Java并发包中锁原理剖析.se02_抽象同步队列AQS概述;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class index {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        lock.lock();
        try {
            System.out.println("begin wait");
            condition.await();
            System.out.println("end wait");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        lock.lock();
        try {
            System.out.println("begin signal");
            condition.signal();
            System.out.println("end signal");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
