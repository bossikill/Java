package 多线程编程.并发.ch06_Java并发包中锁原理剖析.se03_独占锁ReentrantLock原理;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

//使用ReentrantLock实现一个简单的线程安全的list
public class ReetrantLockList {
    //线程不安全的List
    private ArrayList<String> array = new ArrayList<String>();
    //独占锁
    private volatile ReentrantLock lock = new ReentrantLock();

    //添加元素
    public void add(String e) {
        lock.lock();
        try {
            array.add(e);
        } finally {
            lock.unlock();
        }
    }

    //删除元素
    public void remove(String e) {
        lock.lock();
        try {
            array.remove(e);
        } finally {
            lock.unlock();
        }
    }

    //获取元素
    public String get(int index) {
        lock.lock();
        try {
            return array.get(index);
        } finally {
            lock.unlock();
        }
    }
}
