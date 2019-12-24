package 异常处理;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//多重捕获
public class index3_4 {
    public static void main(String[] args) {
        Date date = readDate();
        System.out.println("日期=" + date);
    }

    public static Date readDate() {
        FileInputStream readfile = null;
        InputStreamReader ir = null;
        BufferedReader in = null;

        try {
            readfile = new FileInputStream("readme.txt");
            ir = new InputStreamReader(readfile);
            in = new BufferedReader(ir);
            //读取文件中的一行数据
            String str = in.readLine();
            if (str == null) {
                return null;
            }

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = df.parse(str);
            return date;
        } catch (IOException | ParseException e) {
            System.out.println("处理...");
            e.printStackTrace();
        }
        return null;
    }
}
