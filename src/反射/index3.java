package 反射;

import java.lang.reflect.Constructor;

//创建对象
public class index3 {
    public static void main(String[] args) {
        try {
            Class clz = Class.forName("java.lang.String");
            //调用默认构造方法
            String str1 = (String) clz.newInstance();

            //设置构造方法参数类型
            Class[] params = new Class[1];
            //第一个参数是String
            params[0] = String.class;

            //获取与参数对应的构造方法
            Constructor constructor = clz.getConstructor(params);
            //为构造方法传递参数
            Object[] argObjs = new Object[1];
            //第一个参数传递"Hello"
            argObjs[0] = "Hello";

            //调用飞默认构造方法,构造方法第一个参数是String类型
            String str2 = (String) constructor.newInstance(argObjs);
            System.out.println(str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
