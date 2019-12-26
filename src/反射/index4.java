package 反射;

import java.io.*;
import java.lang.reflect.Constructor;

//依赖注入实现
public class index4 {
    public static void main(String[] args) {
        try {
            String className = readClassName();
            Class clz = Class.forName(className);
            //指定参数类型
            Class[] params = new Class[3];
            //第一个参数是String
            params[0] = String.class;
            //第二个参数是int
            params[1] = int.class;
            //第三个参数是String
            params[2] = String.class;

            //获取对应参数的构造方法
            Constructor constructor = clz.getConstructor(params);
            //设置传递参数
            Object[] argObjs = new Object[3];
            //第一个参数传递"Tony"
            argObjs[0] = "Tony";
            //第二个参数传递18
            argObjs[1] = 18;
            //第三个参数传递"家里蹲大学"
            argObjs[2] = "家里蹲大学";

            //调用非默认构造方法
            Object p = constructor.newInstance(argObjs);
            System.out.println(p);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readClassName() {
        FileInputStream readfile = null;
        InputStreamReader ir = null;
        BufferedReader in = null;
        try {
            readfile = new FileInputStream("./src/反射/config.ini");
            ir = new InputStreamReader(readfile);
            in = new BufferedReader(ir);
            //读取文件中的一行数据
            String str = in.readLine();
            return str;
        } catch (FileNotFoundException e) {
            System.out.println("处理FileNotFoundException...");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("处理IOException...");
            e.printStackTrace();
        }
        return null;
    }
}
