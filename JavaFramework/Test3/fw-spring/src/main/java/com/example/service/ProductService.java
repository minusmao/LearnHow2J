package com.example.service;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component("productService")
public class ProductService {
    /* 对象方法 */
    public void doService() {
        System.out.println("doSomeService");

        // 查询数据
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/how2java", "techrice", "123456");
            Statement sta = conn.createStatement();
            sta.execute("SELECT * FROM user");
            ResultSet resultSet = sta.getResultSet();
            while (resultSet.next()) {
                System.out.println("[" + resultSet.getInt("id") + ", " + resultSet.getString("name") + "]");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动文件异常");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL异常");
            e.printStackTrace();
        }
    }
}
