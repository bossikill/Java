package 多线程编程;

//线程执行对象
public class Runner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //打印次数和线程的名字
            System.out.printf("第%d次执行-%s\n", i, Thread.currentThread().getName());
            try {
                long sleepTime = (long) (1000 * Math.random());
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("执行完成!" + Thread.currentThread().getName());
    }
}
