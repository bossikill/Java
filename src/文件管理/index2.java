package 文件管理;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//文件字符流重新实现文件复制
public class index2 {
    public static void main(String[] args) {
        try (
                FileReader in = new FileReader("./TestDir/build.txt");
                FileWriter out = new FileWriter("./TestDir/subDir/build.txt")
        ) {
            char[] buffer = new char[10];
            int len = in.read(buffer);

            while (len != -1) {
                String copyStr = new String(buffer);
                System.out.println(copyStr);
                out.write(buffer, 0, len);
                len = in.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
