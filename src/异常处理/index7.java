package 异常处理;

import javax.sound.midi.SysexMessage;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//throw与显式抛出异常
public class index7 {
    public static void main(String[] args) {
        try {
            Date date = readDate();
            System.out.println("读取的日期=" + date);
        } catch (MyException e) {
            System.out.println("处理MyException...");
            e.printStackTrace();
        }

    }

    public static Date readDate() throws MyException {
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
            throw new MyException(e.getMessage());
        } catch (IOException e) {
            throw new MyException(e.getMessage());
        } catch (ParseException e) {
            System.out.println("处理ParseException...");
            e.printStackTrace();
        }

        return null;
    }
}
