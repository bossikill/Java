package 多线程编程.并发.ch02_并发编程的其他基础知识.se06_JAVA中的volatile关键字;

//使用synchronized进行同步
public class ThreadSafeInteger {
    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized void set(int value) {
        this.value = value;
    }
}
