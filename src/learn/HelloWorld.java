package learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HelloWorld {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c"};
        List list = new ArrayList<>(Arrays.asList(arr));
        list.add("d");//运行时报错：UnsupportedOperationException

        for (Object str : list) {
            System.out.println((String) str);
        }
    }
}
