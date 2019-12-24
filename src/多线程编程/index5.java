package 多线程编程;

//等待线程结束
public class index5 {
    static int value = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程 开始...");

        Thread t1 = new Thread(() -> {
            System.out.println("ThreadA 执行...");
            for (int i = 0; i < 2; i++) {
                System.out.println("ThreadA 执行...");
                value++;
            }
            System.out.println("ThreadA 结束...");
        }, "ThreadA");
        t1.start();
        //主线程被阻塞,等待t1线程结束
        t1.join();
        System.out.println("value=" + value);
        System.out.println("主线程 结束...");
    }
}
