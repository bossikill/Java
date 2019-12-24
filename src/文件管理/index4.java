package 文件管理;

import java.io.*;

//缓冲流实现文件复制
public class index4 {
    public static void main(String[] args) {
        try (
                //创建字节文件输入流对象
                FileInputStream fis = new FileInputStream("./TestDir/JButton.html");
                //创建转换流对象
                InputStreamReader isr = new InputStreamReader(fis);
                //创建字符缓冲输入流对象
                BufferedReader bis = new BufferedReader(isr);

                //创建字节文件输出流对象
                FileOutputStream fos = new FileOutputStream("./TestDir/subDir/JButton.html");
                //创建转换流对象
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                //创建字符缓冲输出流对象
                BufferedWriter bos = new BufferedWriter(osw)
        ) {
            String line = bis.readLine();
            while (line != null) {
                bos.write(line);
                bos.newLine();
                line = bis.readLine();
            }
            System.out.println("复制完成");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
