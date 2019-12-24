package lambda;

//方法引用
public class index7 {
    //静态方法,进行加法运算
    //参数列表要与函数式接口方法calculateInt(int a,int b)兼容
    public static int add(int a, int b) {
        return a + b;
    }

    //实例方法,进行减法运算
    //参数列表要与函数式接口方法calculateInt(int a,int b)兼容
    public int sub(int a, int b) {
        return a - b;
    }

    /**
     * 打印计算结果
     */
    public static void display(Calculable1 calc, int n1, int n2) {
        System.out.println(calc.calculateInt(n1, n2));
    }

    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 5;

        display(index7::add, n1, n2);
        index7 d = new index7();
        display(d::sub, n1, n2);
    }
}
