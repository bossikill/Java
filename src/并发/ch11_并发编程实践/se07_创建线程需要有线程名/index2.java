package 并发.ch11_并发编程实践.se07_创建线程需要有线程名;

//创建线程时给线程制定一个具体业务模块相关的名称,方便日后定位错误
public class index2 {
    static final String THREAD_SAVE_ORDER = "THREAD_SAVE_ORDER";
    static final String THREAD_SAVE_ADDR = "THREAD_SAVE_ADDR";

    public static void main(String[] args) {
        //订单模块
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("保存订单的线程");
                throw new NullPointerException();
            }
        }, THREAD_SAVE_ORDER);

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("保存收货地址的线程");
            }
        }, THREAD_SAVE_ADDR);

        threadOne.start();
        threadTwo.start();
    }
}
