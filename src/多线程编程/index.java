package 多线程编程;

//获取主线程
public class index {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println("主线程名:" + mainThread.getName());
    }
}
