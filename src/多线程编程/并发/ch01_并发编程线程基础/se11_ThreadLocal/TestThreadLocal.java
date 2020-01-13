package 多线程编程.并发.ch01_并发编程线程基础.se11_ThreadLocal;

//主线程中设置的ThreadLocal线程变量,在子线程中是获取不到的
public class TestThreadLocal {

    //1 创建线程变量
    public static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {
        //2 设置线程变量
        threadLocal.set("hello world");
        //3 启动子线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //4 子线程输出线程变量的值
                System.out.println("thread:" + threadLocal.get());
            }
        });
        thread.start();

        //5 主线程输出线程变量的值
        System.out.println("main:" + threadLocal.get());
    }
}
