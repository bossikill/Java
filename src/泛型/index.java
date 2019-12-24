package 泛型;

import java.util.ArrayList;
import java.util.List;

public class index {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        for (Object item : list) {
            Integer element = (Integer) item;
            System.out.println("读取集合元素:" + element);
        }
    }
}
