package 异常处理;

import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//throws与声明方法抛出异常
public class index5 {
    public static void main(String[] args) {
        try {
            Date date = readDate();
            System.out.println("日期=" + date);
        } catch (IOException e) {
            System.out.println("处理IOException...");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("处理ParseException...");
            e.printStackTrace();
        }
    }

    public static Date readDate() throws IOException, ParseException {
        FileInputStream readfile = new FileInputStream("readme.txt");
        InputStreamReader ir = new InputStreamReader(readfile);
        BufferedReader in = new BufferedReader(ir);

        //读取文件中的一行数据
        String str = in.readLine();
        if (str == null) {
            return null;
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(str);
        return date;
    }
}
