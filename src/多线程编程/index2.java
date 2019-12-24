package 多线程编程;

public class index2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner());
        t1.start();

        Thread t2 = new Thread(new Runner(), "MyThread");
        t2.start();
    }
}
