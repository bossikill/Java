package 并发.ch05_Java并发包中并发List源码剖析;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

//如何使用迭代器
public class index {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
        arrayList.add("hello");
        arrayList.add("alibaba");

        Iterator<String> itr = arrayList.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
