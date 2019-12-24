package 泛型;

//泛型方法
public class index7 {
    public static void main(String[] args) {
        System.out.println(isEquals(new Integer(1), new Integer(5)));
        System.out.println(isEquals(1, 5));
        System.out.println(isEquals(new Double(1.0), new Double(1.0)));
        System.out.println(isEquals(1.0, 1.0));
        //System.out.println(isEquals("A", "A"));//编译错误
    }

    //限定参数类型为Number
    public static <T extends Number> boolean isEquals(T a, T b) {
        return a.equals(b);
    }
}
