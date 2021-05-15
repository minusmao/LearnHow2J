package com.example.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/* DAO */
public class UserDAO {
    /* 构造方法 */
    public UserDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("SQL驱动文件错误");
            e.printStackTrace();
        }
    }

    /* 对象方法 */
    // 获得连接 Connection
    public synchronized Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/how2java", "techrice", "123456");
    }

    // 增加
    public synchronized void addUser(User user) {
        // SQL 语句
        String sql = "INSERT INTO user(name, password, sex, country, signature) VALUES(?, ?, ?, ?, ?)";
        // 操作数据库
        try {
            // 获得连接
            Connection conn = this.getConnection();
            // 获得 PreparedStatement
            PreparedStatement preSta = conn.prepareStatement(sql);
            // 填充数据
            preSta.setString(1, user.getName());
            preSta.setString(2, user.getPassword());
            preSta.setString(3, user.getSex().getName());
            preSta.setString(4, user.getCountry());
            preSta.setString(5, user.getSignature());
            // 执行 SQL 语句
            preSta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("增加数据异常");
            e.printStackTrace();
        }
    }

    // 删除
    public synchronized void deleteUser(int id) {
        // SQL 语句
        String sql = "DELETE FROM user WHERE id = ?";
        // 操作数据库
        try {
            // 获得连接
            Connection conn = this.getConnection();
            // 获得 PreparedStatement
            PreparedStatement preSta = conn.prepareStatement(sql);
            // 填充数据
            preSta.setInt(1, id);
            // 执行 SQl
            preSta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("删除数据异常");
            e.printStackTrace();
        }
    }

    // 更新
    public synchronized void updateUser(User user) {
        // SQL 语句
        String sql = "UPDATE user SET name=?, password=?, sex=?, country=?, signature=? WHERE id=?";
        // 操作数据库
        try {
            // 获得连接
            Connection conn = this.getConnection();
            // 获得 PreparedStatement
            PreparedStatement preSta = conn.prepareStatement(sql);
            // 填充数据
            preSta.setString(1, user.getName());
            preSta.setString(2, user.getPassword());
            preSta.setString(3, user.getSex().getName());
            preSta.setString(4, user.getCountry());
            preSta.setString(5, user.getSignature());
            preSta.setInt(6, user.getId());
            // 执行 SQL
            preSta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("更新数据异常");
            e.printStackTrace();
        }
    }

    // 查询数据：指定用户名和密码，用于登陆验证
    public synchronized User selectUser(String name, String password) {
        // 定义 User 数据对象
        User user = new User();
        user.setId(-1);    // 如果没有满足条件的数据，则默认id为-1
        user.setName(name);
        user.setPassword(password);
        // SQL 语句：查询数据
        String sql = "SELECT * FROM user WHERE name=? AND password=?";
        // 操作数据库
        try {
            // 获得数据库连接
            Connection conn = getConnection();
            // 获得预编译 PreparedStatement
            PreparedStatement preSta = conn.prepareStatement(sql);
            // 填充数据
            preSta.setString(1, user.getName());
            preSta.setString(2, user.getPassword());
            // 执行 SQL
            ResultSet resultSet = preSta.executeQuery();
            // 取出结果
            while (resultSet.next()) {
                // 取出数据到 user 对象中
                user.setId(resultSet.getInt("id"));
                user.setSex(Sex.getSex(resultSet.getString("sex")));
                user.setCountry(resultSet.getString("country"));
                user.setSignature(resultSet.getString("signature"));
            }
        } catch (SQLException e) {
            System.out.println("SELECT: 数据库查询数据发生异常");
            e.printStackTrace();
        }
        return user;
    }

    // 查询 hero 表格数据量总数
    public synchronized int getTotal() {
        // 数据变量
        int total = 0;
        // SQL 语句
        String sql = "SELECT count(id) AS total FROM user";
        // 操作数据库
        try {
            // 获得连接
            Connection conn = this.getConnection();
            // 获得 Statement
            Statement sta = conn.createStatement();
            // 执行 SQL
            ResultSet resultSet = sta.executeQuery(sql);
            // 遍历结果
            while (resultSet.next()) {
                total = resultSet.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("查询总数异常");
            e.printStackTrace();
        }
        return total;
    }

    // 查询数据：遍历数据
    public synchronized List<User> selectAllUsers(int begin, int length) {
        // 定义 List<User> 集合对象
        List<User> userList = new ArrayList<>();
        // SQL 语句，查询数据
        String sql = "SELECT * FROM user LIMIT ?, ?";    // LIMIT 0, 5 返回第1行开始，共5行
        // 操作数据库
        try {
            // 获得数据库连接
            Connection conn = getConnection();
            // 获得预编译 PreparedStatement
            PreparedStatement preSta = conn.prepareStatement(sql);
            // 填充数据
            preSta.setInt(1, begin);    // 首行为 0
            preSta.setInt(2, length);
            // 执行 SQL
            ResultSet resultSet = preSta.executeQuery();
            // 取出结果
            while (resultSet.next()) {
                // 取出一行的所有字段
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                Sex sex = Sex.getSex(resultSet.getString("sex"));
                String country = resultSet.getString("country");
                String signature = resultSet.getString("signature");
                // 存入数据对象
                User user  = new User(id, name, password, sex, country, signature);
                // 存入数据集合
                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println("遍历数据异常");
            e.printStackTrace();
        }
        return userList;
    }
}
