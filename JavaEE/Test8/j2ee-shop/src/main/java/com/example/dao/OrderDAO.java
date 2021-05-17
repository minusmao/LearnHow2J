package com.example.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 类名：OrderDAO
 * 描述：DAO（对应数据库中的 order_ 表）
 */
public class OrderDAO {
    /* 构造方法 */
    public OrderDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("OrderDAO: 数据库驱动文件异常");
            e.printStackTrace();
        }
    }

    /* 对象方法 */
    // 返回 Connection 连接
    public synchronized Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/how2java", "techrice", "123456");
    }
    // 增加（返回添加的对象）
    public Order insertOrder(int userId) {
        // 数据对象
        Order order = new Order(-1, userId, new Date());
        // SQL 语句
        String sql = "INSERT INTO order_(user_id, create_time) VALUES(?,?)";
        // 操作数据库
        try {
            // 获得 Connection 连接
            Connection conn = this.getConnection();
            // 获得 PreparedStatement
            PreparedStatement preSta = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);    // 确保会返回自增长 id
            // 填充 SQL
            preSta.setInt(1, userId);
            preSta.setTimestamp(2, new Timestamp(order.getCreatTime().getTime()) );
            // 执行 SQL 并获得结果
            preSta.executeUpdate();
            // 取出分配的自增长 id
            ResultSet resultSet = preSta.getGeneratedKeys();
            while (resultSet.next()) {
                order.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("OrderDAO: insertOrder 增加异常");
            e.printStackTrace();
        }
        return order;
    }
    // 查询（根据 user_id 查询，即指定用户的所有订单）
    public List<Order> selectOrderList(int userId) {
        // 数据 List 对象
        List<Order> list = new ArrayList<>();
        // SQL 语句
        String sql = "SELECT * FROM order_ WHERE user_id=?";
        // 操作数据库
        try {
            // 获得 Connection 连接
            Connection conn = this.getConnection();
            // 获得 PreparedStatement
            PreparedStatement preSta = conn.prepareStatement(sql);
            // 填充 SQL
            preSta.setInt(1, userId);
            // 执行 SQL 并获得结果
            ResultSet resultSet = preSta.executeQuery();
            // 取出结果
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date createTime = new Date(resultSet.getTimestamp("create_time").getTime());
                // 存入数据 List
                list.add(new Order(id, userId, createTime));
            }
        } catch (SQLException e) {
            System.out.println("OrderDAO: selectOrderList 查询异常");
            e.printStackTrace();
        }
        return list;
    }
}
