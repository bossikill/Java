package learn;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarClass {
    public static void main(String[] args) throws ParseException {
        //获得默认的日历对象
        Calendar calendar = Calendar.getInstance();
        //设置日期
        calendar.set(2019, 11, 17);

        //通过日历获得Date对象
        Date date = calendar.getTime();
        System.out.println("格式化前date=" + date);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("格式化date=" + df.format(date));
        System.out.println();

        calendar.clear();
        //设置日期2018年8月28日
        calendar.set(Calendar.YEAR, 2018);
        calendar.set(Calendar.MONTH, 8);
        calendar.set(Calendar.DATE, 28);

        //通过日历获得Date对象
        date = calendar.getTime();
        System.out.println("格式化前date=" + date);
        System.out.println("格式化后date=" + df.format(date));
    }
}
