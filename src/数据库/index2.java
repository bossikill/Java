package 数据库;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//从URL分拆出,数据库连接配置
public class index2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动程序加载成功...");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序加载失败...");
            e.printStackTrace();
            return;
        }

        String url = "jdbc:mysql://192.168.1.5:3306/sakila";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");
        info.setProperty("verifyServerCertificate", "false");
        info.setProperty("useSSL", "false");

        try (
                Connection conn = DriverManager.getConnection(url, info)
        ) {
            System.out.println("数据库连接成功:" + conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
