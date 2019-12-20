package 内部类;

//匿名内部类
public class View2 {
    public void handler(OnClickListener listener) {
        listener.onClick();
    }

    public static void main(String[] args) {
        View2 v = new View2();
        v.handler(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("实现接口的匿名内部类...");
            }
        });
    }
}
