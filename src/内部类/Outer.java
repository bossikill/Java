package 内部类;

//实例内部类
public class Outer {
    private int x = 10;

    private void print() {
        System.out.println("调用外部方法...");
    }

    public void test() {
        Inner inner = new Inner();
        inner.display();
    }

    class Inner {
        private int x = 5;

        void display() {
            System.out.println("外部类成员变量x=" + Outer.this.x);
            System.out.println("内部类成员变量x=" + this.x);
            System.out.println("内部类成员变量x=" + x);

            Outer.this.print();
            print();
        }
    }

    public static void main(String[] args) {
        //通过外部类访问内部类
        Outer outer = new Outer();
        outer.test();
        System.out.println("------直接访问内部类------");
        //直接访问内部类
        Outer.Inner inner = outer.new Inner();
        inner.display();
    }
}

