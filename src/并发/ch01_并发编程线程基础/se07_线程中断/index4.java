package 并发.ch01_并发编程线程基础.se07_线程中断;

//调用interrupted()后中断标志被清除了
public class index4 {
    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                //中断标志为true时会退出循环,并且清除中断标志
                while (!Thread.currentThread().interrupted()) {

                }
                System.out.println("threadOne isInterrupted:" + Thread.currentThread().isInterrupted());
            }
        });

        threadOne.start();
        threadOne.interrupt();
        threadOne.join();
        System.out.println("main thread is over");
    }
}
