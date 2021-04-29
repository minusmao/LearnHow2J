/**
 * 文件名：JDBCTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> JDBC
 * 时间：2021-4-17
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;

public class JDBCTest {
    /* 程序入口 */
    public static void main(String[] args) {
        /* Hello JDBC */
        try {
            /* 初始化驱动 */
            // 驱动类 com.mysql.cj.jdbc.Driver
            // 就在 mysql-connector-java-8.0.24.jar 中
            // 如果忘记了导包，就会抛出ClassNotFoundException
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        try(
            /* 建立与数据库的连接 */
            // 建立与数据库的Connection连接
            // 这里需要提供：
            // 数据库所处于的ip:127.0.0.1 (本机)
            // 数据库的端口号： 3306 （mysql专用端口号）
            // 数据库名称 crashcourse
            // 编码方式 UTF-8
            // 账号 techrice
            // 密码 123456
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/how2java?characterEncoding=UTF-8",
                                                          "techrice",
                                                          "123456");

            /* 创建Statement，用于执行SQL语句 */
            // 注意：使用的是 java.sql.Statement，不要不小心使用到： com.mysql.jdbc.Statement;
            Statement sta = conn.createStatement();
        ) {
            /* 执行SQL语句 */
            //注意：字符串要用单引号
            // 增加数据
            String sql = "INSERT INTO hero(name, hp, damage) VALUES('galen', 330.3, 100)";

            // 删除数据
            //String sql = "DELETE FROM hero WHERE name = 'galen'";

            // 更改数据
            //String sql = "UPDATE hero SET hp = 888 WHERE id = 1";

            sta.execute(sql);

            /* 查询数据 */
            // 执行查询语句并结果返回给 ResultSet 对象
            ResultSet rs = sta.executeQuery("SELECT * FROM hero");
            System.out.println("查询结果：");
            while(rs.next()) {
                int id = rs.getInt("id");         // 可以使用字段名
                String name = rs.getString(2);    // 也可以使用字段的顺序，从 1 开始
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.println("[" + id + ", " + name + ", " + hp + ", " + damage + "]");
            }
            // 不一定要在这里关闭 ResultSet，因为 Statement 关闭的时候，会自动关闭 ResultSet
            // rs.close();

            /* 查询总数 */
            rs = sta.executeQuery("SELECT count(*) FROM hero");
            if(rs.next()) {
                System.out.println("hero 总数为：" + rs.getInt(1));
            }

            /* 分页查询 */
            System.out.println("第 1~5 条数据：");
            rs = sta.executeQuery("SELECT * FROM hero LIMIT 0, 5");    // LIMIT 开始位置, 数据个数
            while(rs.next()) {
                int id = rs.getInt("id");         // 可以使用字段名
                String name = rs.getString(2);    // 也可以使用字段的顺序，从 1 开始
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.println("[" + id + ", " + name + ", " + hp + ", " + damage + "]");
            }

            /* 判断账户密码是否正确 */
            String userName = "user5";
            String password = "pass";
            // 注意：直接账户密码一起查询，看有无结果，而不是查询所有结果（数据量过多时，内存吃不消），再一个个判断
            rs = sta.executeQuery("SELECT * FROM user WHERE name = '" + userName + "' AND password = '" + password + "'");
            if(rs.next()) {
                System.out.println("密码正确");
            } else {
                System.out.println("密码错误");
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        /* 预编译 Statement */
        // 数据库会对带 ? 的 SQL 进行预编译，所以 PreparedStatement 执行 10 次，只有第 1 次传输了整个 sql 语句
        // PreparedStatement 可以方式 SQL 注入
        String sql = "SELECT * FROM user WHERE name = ? AND password = ?";    // 提前准备一个 sql 语句
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/how2java", "techrice", "123456");
            PreparedStatement preSta = conn.prepareStatement(sql);
        ) {
            // 填充参数
            preSta.setString(1, "user3");    // 填充第一个问号 "?"
            preSta.setString(2, "pass3");    // 填充第二个问号 "?"
            // 执行
            ResultSet rs = preSta.executeQuery();
            if(rs.next()) {
                System.out.println("密码正确");
            } else {
                System.out.println("密码错误");
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        /* execute与executeUpdate的区别 */
        /*
            不同1：
                execute可以执行查询语句
                然后通过getResultSet，把结果集取出来
                executeUpdate不能执行查询语句
            不同2:
                execute返回boolean类型，true表示执行的是查询语句，false表示执行的是insert,delete,update等等
                executeUpdate返回的是int，表示有多少条数据受到了影响
        */

        /* 插入时获取自增长id */
        String insertSql = "INSERT INTO hero(name, hp, damage) VALUES(?, ?, ?)";
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/how2java", "techrice", "123456");
            // 后面加了个Statement.RETURN_GENERATED_KEYS参数，以确保会返回自增长ID。 
            // 通常情况下不需要加这个，有的时候需要加，所以先加上，保险一些
            PreparedStatement preSta = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
        ) {
            // 填充参数
            preSta.setString(1, "return");
            preSta.setFloat(2, 666.6F);
            preSta.setInt(3, 120);

            // 执行插入语句
            preSta.executeUpdate();

            // 获得返回的自动增量（id），以 ResultSet 对象的形式返回
            ResultSet rs = preSta.getGeneratedKeys();
            while(rs.next()) {
                System.out.println(rs.getInt(1));    // 写 rs.getInt("id") 会出错
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        /* 获取数据库的元数据 */
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/how2java", "techrice", "123456");
        ) {
            // 获取元数据对象
            DatabaseMetaData dbMeta = conn.getMetaData();

            // 获取数据库服务器产品名称
            System.out.println("数据库服务器产品名称：" + dbMeta.getDatabaseProductName());
            // 获取数据库服务器产品版本号
            System.out.println("数据库服务器产品版本号：" + dbMeta.getDatabaseProductVersion());
            // 获取数据库服务器用作类别和表名之间的分隔符 如test.user
            System.out.println("数据库和表分隔符："+dbMeta.getCatalogSeparator());
            // 获取驱动版本
            System.out.println("驱动版本：" + dbMeta.getDriverVersion());

            // 获取所有可用数据库
            System.out.println("可用的数据库列表：");
            ResultSet rs = dbMeta.getCatalogs();
            while(rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        /* 事务 */
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/how2java", "techrice", "123456");
            Statement sta = conn.createStatement();
        ) {
            // 在事务中的多个操作，要么都成功，要么都失败
            // 在 Mysql 中，只有当表的类型是 InnoDB 的时候，才支持事务

            // 1、取消自动提交
            conn.setAutoCommit(false);

            // 2、执行一些 SQL 语句
            sta.execute("UPDATE hero SET hp = hp+1 WHERE id = 1");    // hp 加一
            sta.execute("UPDATA hero SET hp = hp-1 WHERE id = 1");    // hp 减一，故意写错

            // 3、手动提交
            conn.commit();    // 因为有一句错误，所以都不会成功，不会出现 hp 只加不减的情况

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}