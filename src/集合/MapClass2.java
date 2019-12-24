package 集合;

import java.util.*;

//Map集合
public class MapClass2 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(102, "张三");
        map.put(105, "李四");
        map.put(109, "王五");
        map.put(110, "董六");
        //"李四"值重复
        map.put(111, "李四");

        //1.使用for-each循环遍历
        System.out.println("--1.使用for-each循环遍历--");
        //获得键集合
        Set keys = map.keySet();
        for (Object key : keys) {
            int ikey = (Integer) key;//自动拆箱
            String value = (String) map.get(ikey);//自动装箱
            System.out.printf("key=%d - value=%s \n", ikey, value);
        }

        //2.使用迭代器遍历
        System.out.println("--2.使用迭代器遍历--");
        //获得值集合
        Collection values = map.values();
        //遍历值集合
        Iterator it = values.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            String s = (String) item;
            System.out.println("值集合元素:" + s);
        }
    }
}
