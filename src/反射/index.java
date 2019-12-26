package 反射;

//java.lang.Class类获得运行时对象的相关信息
public class index {
    public static void main(String[] args) {
        //获得Class实例
        //1.通过类型class静态变量
        Class clz1 = String.class;

        String str = "Hello";
        //2.通过对象的getClass()方法
        Class clz2 = str.getClass();
        //获得int类型Class实例
        Class clz3 = int.class;
        //获得Integer类型Class实例
        Class clz4 = Integer.class;

        System.out.println("clz2类名称:" + clz2.getName());
        System.out.println("clz2是否为接口:" + clz2.isInterface());
        System.out.println("clz2是否为数组对象:" + clz2.isArray());
        System.out.println("clz2父类名称:" + clz2.getSuperclass().getName());

        System.out.println("clz2是否为基本类型:" + clz2.isPrimitive());
        System.out.println("clz3是否为基本类型:" + clz3.isPrimitive());
        System.out.println("clz4是否为基本类型:" + clz4.isPrimitive());
    }
}
