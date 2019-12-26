package Annotation;

//抑制编译器警告
public class SafeVarages {
    public static void main(String[] args) {
        //传递可变参数,参数是泛型集合
        display(10, 20, 30);
        //传递可变参数,参数是非泛型集合
        display("10", 20, 30);
    }

    //@SafeVarargs
    public static <T> void display(T... array) {
        for (T arg : array) {
            System.out.println(arg.getClass().getName() + ":" + arg);
        }
    }
}
