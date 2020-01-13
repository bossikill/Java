package 多线程编程.并发.ch05_Java并发包中并发List源码剖析;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

//多线程下迭代器的弱一致性的效果
public class copylist {
    private static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        arrayList.add("hello");
        arrayList.add("alibaba");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("hangzhou");

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                //修改list中下标为1的元素为baba
                arrayList.set(1, "baba");
                //删除元素
                arrayList.remove(2);
                arrayList.remove(3);
            }
        });

        //保证在修改线程启动前获取迭代器
        Iterator<String> itr = arrayList.iterator();

        //启动线程
        threadOne.start();

        //等待子线程执行完毕
        threadOne.join();

        //迭代元素
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
