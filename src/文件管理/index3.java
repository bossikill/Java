package 文件管理;

import java.io.*;

public class index3 {
    public static void main(String[] args) {
        try (
                FileReader fis = new FileReader("./TestDir/JButton.html");
                BufferedReader bis = new BufferedReader(fis);
                FileWriter fos = new FileWriter("./TestDir/subDir/JButton.html");
                BufferedWriter bos = new BufferedWriter(fos)
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
