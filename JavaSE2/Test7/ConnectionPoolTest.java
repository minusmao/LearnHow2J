/**
 * 文件名：ConnectionPoolTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> JDBC -> 数据库连接池
 * 时间：2021-4-29
 */

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class ConnectionPoolTest {
    /* 程序入口 */
    public static void main(String[] args) {
        // 创建数据库连接池
        ConnectionPool cPool = new ConnectionPool(3);    // 大小设为 3

        // 创建 10 个线程，操作数据库
        Thread[] ts = new Thread[10];
        for(int i = 0; i < ts.length; i++) {
            ts[i] = new Thread() {
                @Override
                public void run() {
                    // 从连接池中获得连接
                    Connection conn =  cPool.getConnection();
                    // 操作数据库
                    try(
                        Statement sta = conn.createStatement();
                    ) {
                        // 插入数据
                        sta.execute("INSERT INTO hero(name, hp, damage) VALUES('pool', 555.5, 200)");
                    } catch(SQLException e) {
                        e.printStackTrace();
                    }
                    // 归还连接
                    cPool.returnConnection(conn);
                }
            };
        }

        // 启动线程
        for(Thread t : ts) {
            t.start();
        }
    }
}