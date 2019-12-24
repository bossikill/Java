package 异常处理;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//自动资源管理
public class index4_2 {
    public static void main(String[] args) {
        Date date = readDate();
        System.out.println("日期=" + date);
    }

    public static Date readDate() {
        try (FileInputStream readfile = new FileInputStream("readme.txt");//已实现AutoCloseable接口
             InputStreamReader ir = new InputStreamReader(readfile);//已实现AutoCloseable接口
             BufferedReader in = new BufferedReader(ir)) {//已实现AutoCloseable接口
            //读取文件中的一行数据
            String str = in.readLine();
            if (str == null) {
                return null;
            }

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = df.parse(str);
            return date;
        } catch (FileNotFoundException e) {
            System.out.println("处理FileNotFoundException...");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("处理IOException...");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("处理ParseException...");
            e.printStackTrace();
        }

        return null;
    }
}
