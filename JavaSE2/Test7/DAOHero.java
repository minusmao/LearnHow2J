/**
 * 文件名：DAOHero.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> JDBC -> ORM 和 DAO
 * 时间：2021-4-28
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

// DAO：Data Access Object
public class DAOHero {
    /* 构造方法 */
    public DAOHero() {
        super();
        // 加载 Mysql 驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /* 对象方法 */
    // 获得连接
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/how2java", "techrice", "123456");
    }

    // 增加数据：Hero 的信息添加到数据库
    public void add(Hero hero) {
        // 插入的 SQL 语句
        String insertSql = "INSERT INTO hero(name, hp, damage) VALUES(?, ?, ?)";
        // 开始插入
        try(
            Connection conn = this.getConnection();
            PreparedStatement preSta = conn.prepareStatement(insertSql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            // 填充数据
            preSta.setString(1, hero.getName());
            preSta.setFloat(2, hero.getHp());
            preSta.setInt(3, hero.getDamage());
            // 执行语句
            preSta.execute();
            // 获得插入的数据的 id
            ResultSet rs = preSta.getGeneratedKeys();
            while(rs.next()) {
                hero.setId(rs.getInt(1));    // id 存入该 Hero 对象中
                System.out.println("成功插入 Hero 数据，id 为：" + hero.getId());
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除数据：删除指定指定 id
    public void delete(int id) {
        // 删除的 SQL 语句
        String deleteSql = "DELETE FROM hero WHERE id = ?";
        // 开始删除
        try(
            Connection conn = this.getConnection();
            PreparedStatement preSta = conn.prepareStatement(deleteSql);
        ) {
            // 填充数据
            preSta.setInt(1, id);
            // 执行语句
            preSta.execute();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // 更改数据：根据传入的 hero 更新数据库
    public void update(Hero hero) {
        // 更新的 SQl 语句
        String updateSql = "UPDATE hero SET name = ?, hp = ?, damage = ? WHERE id = ?";
        // 开始更行
        try(
            Connection conn = this.getConnection();
            PreparedStatement preSta = conn.prepareStatement(updateSql);
        ) {
            // 填充数据
            preSta.setString(1, hero.getName());
            preSta.setFloat(2, hero.getHp());
            preSta.setInt(3, hero.getDamage());
            preSta.setInt(4, hero.getId());
            // 执行语句
            preSta.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // 查询数据：返回指定 id 的数据
    public Hero get(int id) {
        // 数据对象
        Hero hero = new Hero();
        // 查询的 SQL 语句
        String selectSql = "SELECT * FROM hero WHERE id = ?";
        // 开始查询
        try(
            Connection conn = this.getConnection();
            PreparedStatement preSta = conn.prepareStatement(selectSql);
        ) {
            // 填充数据
            preSta.setInt(1, id);
            // 执行语句
            ResultSet rs = preSta.executeQuery();
            // 取出结果
            if(rs.next()) {
                hero.setId(rs.getInt("id"));
                hero.setName(rs.getString("name"));
                hero.setHp(rs.getFloat("hp"));
                hero.setDamage(rs.getInt("damage")); 
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            return hero;    // 返回数据对象
        }
    }

    // 查询数据：获得数据总数
    public int getTotal() {
        // 数据总数
        int total = 0;
        // 查询的 SQL 语句
        String selectSql = "SELECT COUNT(*) FROM hero";
        // 开始查询
        try(
            Connection conn = this.getConnection();
            Statement sta = conn.createStatement();
        ) {
            // 执行语句
            ResultSet rs = sta.executeQuery(selectSql);
            if(rs.next()) {
                total = rs.getInt(1);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            return total;
        }
    }

    // 查询数据：分页查询
    public List<Hero> getList(int start, int count) {
        // 数据对象 List
        List<Hero> list = new ArrayList<>();
        // 查询的 SQL 语句
        String selectSql = "SELECT * FROM hero LIMIT ?, ?";
        // 开始查询
        try(
            Connection conn = this.getConnection();
            PreparedStatement preSta = conn.prepareStatement(selectSql);
        ) {
            // 填充数据
            preSta.setInt(1, start);
            preSta.setInt(2, count);
            // 执行语句
            ResultSet rs = preSta.executeQuery();
            // 取出结果
            while(rs.next()) {
                Hero hero = new Hero();
                hero.setId(rs.getInt("id"));
                hero.setName(rs.getString("name"));
                hero.setHp(rs.getFloat("hp"));
                hero.setDamage(rs.getInt("damage"));
                list.add(hero);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }
}