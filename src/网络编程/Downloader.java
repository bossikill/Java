package 网络编程;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloader {
    private static String urlString = "https://dgss0.bdstatic.com/5bVWsj_p_tVS5dKfpU_Y_D3/res/r/image/2017-09-27/297f5edb1e984613083a2d3cc0c5bb36.png";

    public static void main(String[] args) {
        download();
    }

    private static void download() {
        HttpURLConnection conn = null;
        try {
            //创建URL对象
            URL reqURL = new URL(urlString);
            //打开连接
            conn = (HttpURLConnection) reqURL.openConnection();

            try (
                    //从连接对象获得输入流
                    InputStream is = conn.getInputStream();
                    BufferedInputStream bin = new BufferedInputStream(is);
                    //创建文件输出流
                    OutputStream os = new FileOutputStream("./TestDir/download.png");
                    BufferedOutputStream bout = new BufferedOutputStream(os);
            ) {
                byte[] buffer = new byte[1024];
                int bytesRead = bin.read(buffer);
                while (bytesRead != -1) {
                    bout.write(buffer, 0, bytesRead);
                    bytesRead = bin.read(buffer);
                }
            } catch (IOException e) {
            }
            System.out.println("下载完成.");
        } catch (IOException e) {
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}
