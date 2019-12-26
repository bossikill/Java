package 数据库;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * CREATE TABLE `user` (
 * `userid` int(11) unsigned NOT NULL,
 * `name` varchar(20) DEFAULT NULL,
 * PRIMARY KEY (`userid`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 */

public class CRUDSample {
    //连接数据库url
    static String url;
    //创建Properties对象
    static Properties info = new Properties();

    //1.驱动程序加载
    static {
        //获得属性文件输入流
        InputStream input = CRUDSample.class.getClassLoader().getResourceAsStream("./数据库/config2.ini");
        try {
            //加载属性文件内容到Properties对象
            info.load(input);
            //从属性文件中取出url
            url = info.getProperty("url");
            //Class.forName("com.mysql.jdbc.Driver");
            //从属性文件中取出driver
            String driverClassName = info.getProperty("driver");
            Class.forName(driverClassName);
            System.out.println("驱动程序加载成功...");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序加载失败...");
        } catch (IOException e) {
            System.out.println("加载属性文件失败...");
        }
    }

    public static void main(String[] args) {
        //查询数据
        read();
        System.out.printf("max user id is %s\n", readMaxUserId());
        create();
        update();
        delete();
    }

    //数据查询操作
    public static void read() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            //2.创建数据库连接
            conn = DriverManager.getConnection(url, info);
            //3.创建语句对象
            pstmt = conn.prepareStatement("select name,userid from "
                    + "user where userid > ? order by userid");
            //4.绑定参数
            pstmt.setInt(1, 0);
            //5.执行查询
            rs = pstmt.executeQuery();
            //6.遍历结果集
            while (rs.next()) {
                System.out.printf("id:%d name:%s\n", rs.getInt(2), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    //查询最大的用户ID
    public static int readMaxUserId() {
        int maxId = 0;
        try (
                //2.创建数据库连接
                Connection conn = DriverManager.getConnection(url, info);
                //3.创建语句对象
                PreparedStatement pstmt = conn.prepareStatement("select max(userid) from user");
                ResultSet rs = pstmt.executeQuery();

        ) {
            if (rs.next()) {
                maxId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxId;
    }

    //数据插入操作
    public static void create() {
        try (
                Connection conn = DriverManager.getConnection(url, info);
                PreparedStatement pstmt = conn.prepareStatement("insert into user(userid,name) values(?,?)");
        ) {
            int maxId = readMaxUserId();
            pstmt.setInt(1, ++maxId);
            pstmt.setString(2, "Tony" + maxId);
            int affectedRows = pstmt.executeUpdate();
            System.out.printf("成功插入%d条数据.\n", affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update() {
        try (
                Connection conn = DriverManager.getConnection(url, info);
                PreparedStatement pstmt = conn.prepareStatement("update user set name=? where userid > ?");
        ) {
            pstmt.setString(1, "Tom");
            pstmt.setInt(2, 4);
            int affectedRows = pstmt.executeUpdate();

            System.out.printf("成功更新%d条数据.\n", affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete() {
        try (
                Connection conn = DriverManager.getConnection(url, info);
                PreparedStatement pstmt = conn.prepareStatement("delete from user where userid=?");
        ) {
            int maxId = readMaxUserId();
            pstmt.setInt(1, maxId);
            int affectedRows = pstmt.executeUpdate();
            System.out.printf("成功删除%d条数据.\n", affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
