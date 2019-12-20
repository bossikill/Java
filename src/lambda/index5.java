package lambda;

//访问变量
public class index5 {
    //实例成员变量
    private int value = 10;
    //静态成员变量
    private static int staticValue = 5;

    //静态方法,进行加密算法
    public static Calculable1 add() {
        Calculable1 result = (int a, int b) -> {
            //访问静态成员变量,不能访问实例成员变量
            staticValue++;
            int c = a + b + staticValue;//this.value;
            return c;
        };
        return result;
    }

    //实例方法,进行减法运算
    public Calculable1 sub() {
        Calculable1 result = (int a, int b) -> {
            //访问静态成员变量和实例成员变量
            staticValue++;
            this.value++;
            int c = a - b - staticValue - this.value;
            return c;
        };
        return result;
    }
}
