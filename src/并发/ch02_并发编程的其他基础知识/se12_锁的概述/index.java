package 并发.ch02_并发编程的其他基础知识.se12_锁的概述;

//可重入锁
public class index {
    public synchronized void helloA() {
        System.out.println("hello");
    }

    public synchronized void helloB() {
        System.out.println("hello B");
        helloA();
    }

    public static void main(String[] args) {
        index test = new index();
        test.helloB();
    }
}
