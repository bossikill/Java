package 文件管理;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//文件复制
public class FileCopy {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("./TestDir/build.txt");
             FileOutputStream out = new FileOutputStream("./TestDir/subDir/build.txt")
        ) {
            byte[] buffer = new byte[10];
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
