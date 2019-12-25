package 网络编程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

//使用java.net.URL类
public class index3 {
    public static void main(String[] args) {
        //Web网址
        String url = "http://www.baidu.com/";

        URL reqURL;
        try {
            reqURL = new URL(url);
        } catch (MalformedURLException e) {
            return;
        }

        try {
            //打开网络通信输入流
            InputStream is = reqURL.openStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append('\n');
                line = br.readLine();
            }
            //日志输出
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
