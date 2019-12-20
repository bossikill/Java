package learn;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateClass {
    public static void main(String[] args) {
        //使用now方法获得LocalDate对象
        LocalDate date1 = LocalDate.now();
        System.out.println("date1=" + date1);

        //使用of方法获得LocalDate对象2018-08-18
        LocalDate date2 = LocalDate.of(2018, 8, 18);
        System.out.println("date2=" + date2);

        //使用now方法获得LocalTime对象
        LocalTime time1 = LocalTime.now();
        System.out.println("time1=" + time1);

        //使用of方法获得LocalTime对象08:58:18
        LocalTime time2 = LocalTime.of(8, 58, 18);
        System.out.println("time2=" + time2);

        //使用now方法获得LocalDateTime对象
        LocalDateTime dateTime1 = LocalDateTime.now();
        System.out.println("dateTime1=" + dateTime1);

        //使用of方法获得LocalDateTime对象2018-08-18T08:58:18
        LocalDateTime dateTime2 = LocalDateTime.of(2018, 8, 18, 8, 58, 18);
        System.out.println("dateTime2=" + dateTime2);

        //创建LocalDateTime对象
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("dateTime格式化之前:" + dateTime);

        //设置格式化类
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String text = dateTime.format(formatter);
        System.out.println("dateTime格式化之后:" + text);

        //格式化字符串"2018-08-18 08:58:18",返回LocalDateTime对象
        LocalDateTime parsedDateTime = LocalDateTime.parse("2018-08-18 08:58:18", formatter);
        System.out.println("LocalDateTime解析之后:" + parsedDateTime);

        //创建LocalDate对象
        LocalDate date = LocalDate.now();
        System.out.println("date格式化之前:" + date);

        //重新设置格式化类
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        text = date.format(formatter);
        System.out.println("date格式化之后:" + text);

        //格式化字符串"2018-08-18",返回LocalDate对象
        LocalDate parsedDate = LocalDate.parse("2018-08-18", formatter);
        System.out.println("LocalDate解析之后:" + parsedDate);

        //创建LocalTime对象
        LocalTime time = LocalTime.now();
        System.out.println("time格式化之前:" + time);

        //重新设置格式化类
        formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        text = time.format(formatter);
        System.out.println("time格式化之后:" + text);

        //格式化字符串"08:58:18",返回LocalTime对象
        LocalTime parsedTime = LocalTime.parse("08:58:18", formatter);
        System.out.println("LocalTime解析之后:" + parsedTime);
    }
}
