package Annotation;

import 反射.Person;

//@SuppressWarnings 抑制编译器警告
public class SuppressWarnings {
    @java.lang.SuppressWarnings({"deprecation"})
    public static void main(String[] args) {
        Deprecated p = new Deprecated();
        p.setNameAndAge("Tony", 20);
        p.name = "Tom";
    }
}
