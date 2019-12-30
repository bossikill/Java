package 并发.ch01_并发编程线程基础.se10_守护线程与用户线程;

//用户进程和守护进程的区别
public class index2 {
    public static void main(String[] args) {
        //创建线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                }
            }
        });

        //thread.setDaemon(true);
        thread.start();
        System.out.println("main thread is over");
    }
}
