package 多线程编程;

//设置线程优先级
public class index4 {
    public static void main(String[] args) {
        //创建线程t1,参数是一个线程执行对象Runner
        Thread t1 = new Thread(new Runner());
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();

        //创建线程t1,参数是一个线程执行对象Runner
        Thread t2 = new Thread(new Runner(), "MyThread");
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();
    }
}
