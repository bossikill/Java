package 异常处理;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//try-catch语句嵌套
public class index3_3 {
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

            try {
                String str = in.readLine();
                if (str == null) {
                    return null;
                }

                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date date = df.parse(str);
                return date;
            } catch (ParseException e) {
                System.out.println("处理ParseException...");
                e.printStackTrace();
            }
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
