package com.example.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 类名：OrderItemDAO
 * 描述：DAO（对应数据库中的 order_item 表）
 */
public class OrderItemDAO {
    /* 构造方法 */
    public OrderItemDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("OrderItemDAO: 数据库驱动文件异常");
            e.printStackTrace();
        }
    }

    /* 对象方法 */
    // 返回 Connection 连接
    public synchronized Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/how2java", "techrice", "123456");
    }
    // 增肌
    public void insertOrderItem(OrderItem orderItem) {
        // SQL 语句
        String sql = "INSERT INTO order_item(product_id,order_id,number) VALUES(?,?,?)";
        // 操作数据库
        try {
            // 获得 Connection 连接
            Connection conn = this.getConnection();
            // 获得 PreparedStatement
            PreparedStatement preSta = conn.prepareStatement(sql);
            // 填充 SQL
            preSta.setInt(1, orderItem.getProductId());
            preSta.setInt(2, orderItem.getOrderId());
            preSta.setInt(3, orderItem.getNumber());
            // 执行 SQL 并获得结果
            preSta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("OrderDAO: insertOrderItem  增加异常");
            e.printStackTrace();
        }
    }
    // 查询（根据 order_id 查询，即指定用户的所有订单）
    public List<OrderItem> selectOrderItemList(int orderId) {
        // 数据 List 对象
        List<OrderItem> list = new ArrayList<>();
        // SQL 语句
        String sql = "SELECT * FROM order_item WHERE order_id=?";
        // 操作数据库
        try {
            // 获得 Connection 连接
            Connection conn = this.getConnection();
            // 获得 PreparedStatement
            PreparedStatement preSta = conn.prepareStatement(sql);
            // 填充 SQL
            preSta.setInt(1, orderId);
            // 执行 SQL 并获得结果
            ResultSet resultSet = preSta.executeQuery();
            // 取出结果
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int productId = resultSet.getInt("product_id");
                int number = resultSet.getInt("number");
                // 存入数据 List
                list.add(new OrderItem(id, productId, orderId, number));
            }
        } catch (SQLException e) {
            System.out.println("OrderDAO: selectOrderList 查询异常");
            e.printStackTrace();
        }
        return list;
    }
}
