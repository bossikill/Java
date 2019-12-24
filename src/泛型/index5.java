package 泛型;

import java.util.*;

public class index5 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(102, "张三");
        map.put(105, "李四");
        map.put(109, "王五");
        map.put(110, "董六");

        System.out.println("--1.使用for-each循环遍历--");
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            String value = map.get(key);
            System.out.printf("Key=%d - value=%s \n", key, value);
        }

        System.out.println("--2.使用迭代器遍历--");
        Collection<String> values = map.values();
        Iterator<String> it = values.iterator();
        while (it.hasNext()) {
            String item = it.next();
            System.out.println("值集合元素:" + item);
        }
    }
}
