package lambda;

//Lambda表达式简化形式
public class index3 {
    public static Calculable2 calculable(int power) {
        Calculable2 result;
        if (power == 2) {
            //Lambda表达式实现Calculable接口
            result = (int a) -> {
                return a * a;
            };
        } else {
            //Lambda省略了参数类型和小括号
            result = a -> {
                return a * a * a;
            };
        }
        return result;
    }

    public static void main(String[] args) {
        int n1 = 10;

        //实现加法计算Calculable对象
        Calculable2 f1 = calculable(2);
        //实现减法计算Calculable对象
        Calculable2 f2 = calculable(3);

        //调用calculateInt方法进行加法计算
        System.out.printf("%d二次方%d\n", n1, f1.calculateInt(n1));
        //调用calculateInt方法进行减法计算
        System.out.printf("%d三次方%d\n", n1, f2.calculateInt(n1));
    }
}
