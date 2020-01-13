package 多线程编程.并发.ch02_并发编程的其他基础知识.se06_JAVA中的volatile关键字;

//使用volatile进行同步
public class ThreadSafeInteger2 {
    private volatile int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}
