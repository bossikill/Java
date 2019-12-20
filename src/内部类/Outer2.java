package 内部类;

//局部内部类
public class Outer2 {
    //外部类成员变量
    private int value = 10;

    //外部类方法
    public void add(final int x, int y) {
        //局部变量
        int z = 100;

        //定义内部类
        class Inner {
            //内部类方法
            void display() {
                int sum = x + z + value;
                System.out.println("sum=" + sum);
            }
        }

        //声明匿名对象
        new Inner().display();
    }

    public static void main(String[] args) {
        Outer2 outer = new Outer2();
        outer.add(100, 300);
    }
}
