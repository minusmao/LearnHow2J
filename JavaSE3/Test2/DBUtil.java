/**
 * 文件名：DBUtil.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 注解
 * 时间：2021-5-5
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

@JDBCConfig(ip="localhost", database="how2java", encoding="UTF-8", loginName="techrice", password="123456")
public class DBUtil {
    /* 类初始化块 */
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            System.out.println("MySQL驱动无法加载");
            e.printStackTrace();
        }
    }

    /* 类方法 */
    // 获得数据库连接
    public static Connection getConnection() throws SQLException {
        // 1、得到 JDBCConfig 注解对象
        JDBCConfig config = DBUtil.class.getAnnotation(JDBCConfig.class);
        // 2、读取注解对象的内容
        String ip = config.ip();
        int port = config.port();
        String database = config.database();
        String encoding = config.encoding();
        String loginName = config.loginName();
        String password = config.password();
        // 3、根据内容建立 MySQL 连接
        String connectUrl = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);    // 格式化 url 连接
        return DriverManager.getConnection(connectUrl, loginName, password);
    }

    /* 程序入口 */
    public static void main(String[] args) {
        try {
            Connection con = DBUtil.getConnection();
            System.out.println(con);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}