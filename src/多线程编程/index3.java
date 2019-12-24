package 多线程编程;

public class index3 {
    public static void main(String[] args) {
        //创建线程t1,参数是实现Runnable接口的匿名内部类
        Thread t1 = new Thread(new Runnable() {
            //编写执行线程的代码
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    //打印次数和线程的名字
                    System.out.printf("第 %d 次执行 - %s\n", i, Thread.currentThread().getName());
                    try {
                        //随机生成休眠时间
                        long sleepTime = (long) (1000 * Math.random());
                        //线程休眠
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("执行完成!" + Thread.currentThread().getName());
            }
        });
        //开始线程t1
        t1.start();

        //创建线程t2,参数是实现Runnable接口的Lambda表达式
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                //打印次数和线程的名字
                System.out.printf("第 %d 次执行 - %s\n", i, Thread.currentThread().getName());
                try {
                    long sleepTime = (long) (1000 * Math.random());
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                }
            }
            System.out.println("执行完成!" + Thread.currentThread().getName());
        });
        t2.start();
    }
}
