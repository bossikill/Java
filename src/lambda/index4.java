package lambda;

//作为参数使用Lambda表达式
public class index4 {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 5;

        //打印计算结果加法计算结果
        display((a, b) -> {
            return a + b;
        }, n1, n2);

        //打印计算结果减法计算结果
        display((a, b) -> a - b, n1, n2);
    }

    /**
     * 打印计算结果
     */
    public static void display(Calculable1 calc, int n1, int n2) {
        System.out.println(calc.calculateInt(n1, n2));
    }
}
