package 泛型;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class index2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        for (String item : list) {
            System.out.println("读取集合元素:" + item);
        }
    }
}
