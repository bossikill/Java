package 并发.ch01_并发编程线程基础.se10_守护线程与用户线程;

//创建守护线程
public class index {
    public static void main(String[] args) {
        //创建线程
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        //设置为守护线程
        daemonThread.setDaemon(true);
        daemonThread.start();
    }
}
