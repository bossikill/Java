package 内部类;

//静态内部类
public class View {
    private int x = 20;
    private static int staticX = 10;

    static class Button {
        void onClick() {
            System.out.println(staticX);
            //不能访问外部类的非静态成员
            //System.out.println(x);//编译错误
        }
    }

    public static void main(String[] args) {
        View.Button button = new View.Button();
        button.onClick();
    }
}
