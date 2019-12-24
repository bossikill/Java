package 异常处理;
//捕获异常

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class index3 {
    public static void main(String[] args) {
        Date date = readDate();
        System.out.println("日期=" + date);
    }

    public static Date readDate() {
        try {
            //String str = "2019-12-20";
            String str = "201A-18-18";
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = df.parse(str);
            return date;
        } catch (ParseException e) {
            System.out.println("处理ParseException...");
            e.printStackTrace();
        }
        return null;
    }
}
