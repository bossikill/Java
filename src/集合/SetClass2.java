package 集合;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


//set集合
public class SetClass2 {
    public static void main(String[] args) {
        Set set = new HashSet();

        String b = "B";

        //向集合中添加元素
        set.add("A");
        set.add(b);
        set.add("C");
        set.add(b);
        set.add("D");
        set.add("E");

        //1.使用for-each循环遍历
        System.out.println("--1.使用for-each循环遍历--");
        for (Object item : set) {
            String s = (String) item;
            System.out.println("读取集合元素:" + s);
        }

        //2.使用迭代器遍历
        System.out.println("--2.使用迭代器遍历--");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            String s = (String) item;
            System.out.println("读取集合元素:" + s);
        }
    }
}
