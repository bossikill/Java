package lambda;

//捕获局部变量
public class index6 {
    //实例成员变量
    private int value = 10;
    //静态成员变量
    private static int staticValue = 5;

    //静态方法,进行加密算法
    public static Calculable1 add() {
        //局部变量
        int localValue = 20;

        Calculable1 result = (int a, int b) -> {
            //localValue++;//编译错误
            int c = a + b + localValue;
            return c;
        };
        return result;
    }

    //实例方法,进行减法运算
    public Calculable1 sub() {
        //final局部变量
        final int localValue = 20;

        Calculable1 result = (int a, int b) -> {
            int c = a - b - staticValue - this.value;
            //localValue = c;//编译错误
            return c;
        };
        return result;
    }
}
