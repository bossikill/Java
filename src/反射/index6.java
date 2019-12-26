package 反射;

import java.lang.reflect.Field;

//调用成员变量
public class index6 {
    public static void main(String[] args) {
        try {
            Class clz = Class.forName("反射.Person");
            //调用默认构造方法
            Person person = (Person) clz.newInstance();

            //返回成员变量名为name的Field对象
            Field name = clz.getDeclaredField("name");
            //设置成员变量accessible标志为true
            name.setAccessible(true);
            //为成员变量name赋值
            name.set(person, "Tony");

            //返回成员变量名为age的Field对象
            Field age = clz.getDeclaredField("age");
            //设置成员变量accessible标志为true
            age.setAccessible(true);
            //为成员变量age赋值
            age.set(person, 18);

            //获取成员变量保存的数据
            System.out.printf("[name:%s, age:%d]", name.get(person), age.get(person));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
