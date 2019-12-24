package 文件管理;

import java.io.*;

//缓冲流实现文件复制
public class FileCopyWithBuffer {
    public static void main(String[] args) {
        try (
                FileInputStream fis = new FileInputStream("./TestDir/src.zip");
                BufferedInputStream bis = new BufferedInputStream(fis);
                FileOutputStream fos = new FileOutputStream("./TestDir/subDir/src.zip");
                BufferedOutputStream bos = new BufferedOutputStream(fos)
        ) {
            long startTime = System.nanoTime();
            byte[] buffer = new byte[1024];
            int len = bis.read(buffer);

            while (len != -1) {
                bos.write(buffer, 0, len);
                len = bis.read(buffer);
            }

            long elapsedTime = System.nanoTime() - startTime;
            System.out.println("耗时:" + (elapsedTime / 1000000.0) + " 毫秒");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
