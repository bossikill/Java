package 并发.ch11_并发编程实践.se04_SimpleDateFormat是线程不安全的;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

//SimpleDateFormat的操作非原子性,多线程下会有问题
//解决方法  使用ThreadLocal让每一个线程持有一个本地的种子变量,避免了竞争.
public class TestSimpleDateFormat3 {
    //1 创建threadLocal实例
    static ThreadLocal<DateFormat> safeSdf = new ThreadLocal<DateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static void main(String[] args) {
        //2 创建多个线程,并启动
        for (int i = 0; i < 10; ++i) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //3 使用单例日期实例解析文本
                        System.out.println(safeSdf.get().parse("2017-12-13 15:17:27"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        //4 使用完毕记得清除,避免内存泄漏
                        safeSdf.remove();
                    }
                }
            });
            thread.start();
        }
    }
}
