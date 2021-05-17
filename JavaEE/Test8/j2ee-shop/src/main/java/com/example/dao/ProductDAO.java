package com.example.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名：ProductDAO
 * 描述：DAO（对应数据库中的 product 表）
 */
public class ProductDAO {
    /* 构造方法 */
    public ProductDAO() {
        try {
            // 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("ProductDAO: 数据库驱动文件异常");
            e.printStackTrace();
        }
    }

    /* 对象方法 */
    // 返回 Connection 连接
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/how2java", "techrice", "123456");
    }
    // 查询（根据产品 id）
    public synchronized Product selectProductById(int id) {
        // 创建数据对象
        Product product = new Product();
        // SQL 语句
        String sql = "SELECT * FROM product WHERE id=?";
        // 操作数据库
        try {
            // 获得 Connection 连接
            Connection conn = this.getConnection();
            // 获得 PreparedStatement
            PreparedStatement preSta = conn.prepareStatement(sql);
            // 填充 SQL
            preSta.setInt(1, id);
            // 执行 SQL 并获得结果
            ResultSet resultSet = preSta.executeQuery();
            // 取出结果
            while (resultSet.next()) {
                // 存入数据对象
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getFloat("price"));
            }
        } catch (SQLException e) {
            System.out.println("ProductDAO: selectProductById 查询异常");
            e.printStackTrace();
        }
        return product;
    }
    // 查询（LIMIT begin,length）
    public synchronized List<Product> selectProductList(int begin, int length) {
        // 数据 List 对象
        List<Product> list = new ArrayList<>();
        // SQl 语句
        String sql = "SELECT * FROM product LIMIT ?,?";
        // 操作数据库
        try {
            // 获得 Connection 连接
            Connection conn = this.getConnection();
            // 获得 PreparedStatement
            PreparedStatement preSta = conn.prepareStatement(sql);
            // 填充 SQL
            preSta.setInt(1, begin);
            preSta.setInt(2, length);
            // 执行 SQL 并获得结果
            ResultSet resultSet = preSta.executeQuery();
            // 取出结果
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                // 存入数据 List
                list.add(new Product(id, name, price));
            }
        } catch (SQLException e) {
            System.out.println("ProductDAO: selectProductList 查询异常");
            e.printStackTrace();
        }
        return list;
    }
}
