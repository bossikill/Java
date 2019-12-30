package 并发.ch01_并发编程线程基础.se05_让线程睡眠的sleep方法;

//子线程在睡眠期间,主线程中断了它,会抛出异常
public class index2 {
    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("child thread is in sleep");
                    Thread.sleep(6000);
                    System.out.println("child thread is in awaked");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
