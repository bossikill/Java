package 多线程编程.并发.ch06_Java并发包中锁原理剖析.se04_读写锁ReentrantReadWriteLock的原理;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//使用ReentrantReadWriteLock实现一个简单的线程安全的list
public class ReetrantLockList {
    //线程不安全的List
    private ArrayList<String> array = new ArrayList<String>();
    //独占锁
    private volatile ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    //添加元素
    public void add(String e) {
        writeLock.lock();
        try {
            array.add(e);
        } finally {
            writeLock.unlock();
        }
    }

    //删除元素
    public void remove(String e) {
        writeLock.lock();
        try {
            array.remove(e);
        } finally {
            writeLock.unlock();
        }
    }

    //获取元素
    public String get(int index) {
        readLock.lock();
        try {
            return array.get(index);
        } finally {
            readLock.unlock();
        }
    }
}
