package 多线程编程;

public class MyThread extends Thread {
    public MyThread() {
        super();
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("第 %d次执行 - %s \n", i, getName());

            try {
                //随机生成休眠时间
                long sleepTime = (long) (1000 * Math.random());
                sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("执行完成!" + getName());
    }
}
