package 网络编程;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpUploadServer {
    public static void main(String[] args) {
        System.out.println("服务器端运行...");

        Thread t = new Thread(() -> {
            try (
                    //创建DatagramSocket对象,指定端口8080
                    DatagramSocket socket = new DatagramSocket(8080);
                    FileOutputStream fout = new FileOutputStream("./TestDir/subDir/coco2dxcplus.jpg");
                    BufferedOutputStream out = new BufferedOutputStream(fout);
            ) {
                //准备一个缓冲区
                byte[] buffer = new byte[1024];
                //循环接受数据报包
                while (true) {
                    //创建数据报包对象,用来接收数据
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    //接收数据报包
                    socket.receive(packet);
                    //接收数据长度
                    int len = packet.getLength();

                    if (len == 3) {
                        //获得结束标志
                        String flag = new String(buffer, 0, 3);
                        //判断结束标志,如果是bye结束接收
                        if (flag.equals("bye")) {
                            break;
                        }
                    }
                    //写入数据到文件输出流
                    out.write(buffer, 0, len);
                }
                System.out.println("接收完成!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}
