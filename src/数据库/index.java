package 数据库;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

//最简陋的数据库连接
public class index {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动程序加载成功...");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序加载失败...");
            e.printStackTrace();
            return;
        }

        String url = "jdbc:mysql://192.168.1.5:3306/sakila?verifyServerCertificate=false&useSSL=false";
        String user = "root";
        String password = "123456";

        try (
                Connection conn = DriverManager.getConnection(url, user, password)
        ) {
            System.out.println("数据库连接成功:" + conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
