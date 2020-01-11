package 并发.ch11_并发编程实践.se04_SimpleDateFormat是线程不安全的;

import java.text.SimpleDateFormat;

//SimpleDateFormat的操作非原子性,多线程下会有问题
public class TestSimpleDateFormat {
    //1 创建单例实例
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        //2 创建多个线程,并启动
        for (int i = 0; i < 10; ++i) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //3 使用单例日期实例解析文本
                        System.out.println(sdf.parse("2017-12-13 15:17:27"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
}
