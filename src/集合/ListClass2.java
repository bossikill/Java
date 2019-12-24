package 集合;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//遍历集合
public class ListClass2 {
    public static void main(String[] args) {
        List list = new ArrayList();

        String b = "B";

        //向集合中添加元素
        list.add("A");
        list.add(b);
        list.add("C");
        list.add(b);
        list.add("D");
        list.add("E");

        //1.使用for循环遍历
        System.out.println("--1.使用for循环遍历--");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("读取集合元素(%d):%s\n", i, list.get(i));
        }

        //2.使用for-each循环遍历
        System.out.println("--2,使用for-each循环遍历--");
        for (Object item : list) {
            String s = (String) item;
            System.out.println("读取集合元素:" + s);
        }

        //3.使用迭代器遍历
        System.out.println("--3.使用迭代器遍历--");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            String s = (String) item;
            System.out.println("读取集合元素:" + s);
        }
    }

}
