package 数据库;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//从文件中读取数据库连接配置
public class index3 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动程序加载成功...");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序加载失败...");
            e.printStackTrace();
            return;
        }

        Properties info = new Properties();
        try {
            InputStream input = index3.class.getClassLoader().getResourceAsStream("./数据库/config.ini");
            info.load(input);
        } catch (IOException e) {
            return;
        }

        String url = "jdbc:mysql://192.168.1.5:3306/sakila";
        try (
                Connection conn = DriverManager.getConnection(url, info)
        ) {
            System.out.println("数据库连接成功:" + conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
