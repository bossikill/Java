package 并发.ch11_并发编程实践.se07_创建线程需要有线程名;

//线程没有名称,无法准确定位线程异常
public class index {
    public static void main(String[] args) {
        //订单模块
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("保存订单的线程");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                throw new NullPointerException();
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("保存收货地址的线程");
            }
        });

        threadOne.start();
        threadTwo.start();
    }
}
