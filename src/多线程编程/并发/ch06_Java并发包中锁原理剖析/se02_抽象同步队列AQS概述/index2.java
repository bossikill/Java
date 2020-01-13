package 多线程编程.并发.ch06_Java并发包中锁原理剖析.se02_抽象同步队列AQS概述;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;

//生产-消费模型
public class index2 {
    final static NonReentrantLock lock = new NonReentrantLock();
    final static Condition notFull = lock.newCondition();
    final static Condition notEmpty = lock.newCondition();

    final static Queue<String> queue = new LinkedBlockingQueue<String>();
    final static int queueSize = 10;

    public static void main(String[] args) {
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取独占锁
                lock.lock();
                try {
                    //如果队列满了,则等待
                    while (queue.size() == queueSize) {
                        notEmpty.await();
                    }

                    //添加元素到队列
                    queue.add("ele");

                    //唤醒消费线程
                    notFull.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread comsumer = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    //队列空,则等待
                    while (0 == queue.size()) {
                        notFull.await();
                    }

                    //消费一个元素
                    String ele = queue.poll();
                    //唤醒生产线程
                    notEmpty.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        producer.start();
        comsumer.start();
    }
}
