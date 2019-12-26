package 反射;

import java.lang.reflect.Method;

//调用方法
public class index5 {
    public static void main(String[] args) {
        try {
            Class clz = Class.forName("反射.Person");
            //调用默认构造方法
            Person person = (Person) clz.newInstance();
            System.out.println(person);

            //指定参数类型
            Class[] params = new Class[2];
            //第一个参数是String
            params[0] = String.class;
            //第二个参数是int
            params[1] = int.class;

            //获取setNameAndAge方法对象
            Method method = clz.getMethod("setNameAndAge", params);
            //设置传递参数
            Object[] argObjs = new Object[2];
            //第一个参数传递"Tony"
            argObjs[0] = "Tony";
            //第二个参数传递18
            argObjs[1] = 18;
            //调用setNameAndAge方法
            method.invoke(person, argObjs);
            System.out.println(person);

            //获取getName方法对象
            method = clz.getMethod("getName");
            //调用getName方法
            Object result = method.invoke(person);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
