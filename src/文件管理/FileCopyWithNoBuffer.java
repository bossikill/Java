package 文件管理;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//文件复制
public class FileCopyWithNoBuffer {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("./TestDir/src.zip");
             FileOutputStream out = new FileOutputStream("./TestDir/subDir/src.zip")
        ) {
            long startTime = System.nanoTime();
            byte[] buffer = new byte[1024];
            int len = in.read(buffer);

            while (len != -1) {
                out.write(buffer, 0, len);
                len = in.read(buffer);
            }

            long elapsedTime = System.nanoTime() - startTime;
            System.out.println("耗时:" + (elapsedTime / 1000000.0) + " 毫秒");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
