package learn;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateClass {
    public static void main(String[] args) throws ParseException {
        Date now = new Date();
        System.out.println("now=" + now);
        System.out.println("now.getTime()=" + now.getTime());

        Date date = new Date(1234567890123L);
        System.out.println("date=" + date);

        //测试now和date日期
        display(now, date);

        date = new java.util.Date(1234567890123L);
        System.out.println("格式化前date=" + date);

        java.text.DateFormat df = new SimpleDateFormat();
        System.out.println("格式化后date=" + df.format(date));

        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("格式化后date=" + df.format(date));

        String dateString = "2018-08-18 08:18:58";
        java.util.Date date1 = df.parse(dateString);
        System.out.println("从字符串获得日期对象=" + date1);
    }

    //测试after,before,compareTo方法
    public static void display(Date now, Date date) {
        System.out.println();
        System.out.println("now.after(date)=" + now.after(date));
        System.out.println("now.before(date)=" + now.before(date));
        System.out.println("now.compareTo(date)=" + now.compareTo(date));
        System.out.println();
    }
}
