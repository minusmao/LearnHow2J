/**
 * 文件名：ConnectionPool.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> JDBC -> 数据库连接池
 * 时间：2021-4-29
 */

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
    /* 对象属性 */
    private List<Connection> cList = new ArrayList<>();    // 存储连接 Connection
    private int size;                                      // 连接池大小

    /* 构造方法 */
    public ConnectionPool(int size) {
        // 设置连接池大小
        this.size = size;
        // 创建连接，不能使用try-with-resource的方式，因为这些连接都需要是"活"的，不要被自动关闭了
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            for(int i = 0; i < size; i++) {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/how2java", "techrice", "123456");
                cList.add(conn);
            }
        } catch(ClassNotFoundException e) {
            System.out.println("找不到数据库驱动类");
            e.printStackTrace();
        } catch(SQLException e) {
            System.out.println("创建数据库连接失败");
            e.printStackTrace();
        }
    }

    /* 对象方法 */
    // 取出连接
    public synchronized Connection getConnection() {
        // 判断连接是否用完
        while(cList.isEmpty()) {
            try {
                this.wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        return cList.remove(0);    // 取出一个连接
    }

    // 归还连接
    public synchronized void returnConnection(Connection conn) {
        // 存入连接池中
        cList.add(conn);
        // 唤醒其他线程
        this.notifyAll();
    }
}