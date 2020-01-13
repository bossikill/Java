package 多线程编程.并发.ch01_并发编程线程基础.se02_线程创建与运行;

public class RunableTask implements Runnable {
    @Override
    public void run() {
        System.out.println("I am a child thread");
    }

    public static void main(String[] args) throws InterruptedException {
        RunableTask task = new RunableTask();
        new Thread(task).start();
        new Thread(task).start();
    }
}
