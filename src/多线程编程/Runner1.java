package 多线程编程;

//线程让步
public class Runner1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //打印次数和线程的名字
            System.out.printf("第 %d 次执行 - %s \n", i, Thread.currentThread().getName());
            Thread.yield();
        }
        System.out.println("执行完成!" + Thread.currentThread().getName());
    }
}
