package com.example.dao;

import java.util.Date;

/**
 * 类名：Order
 * 描述：ORM（对应数据库中的 order_ 表）
 */
public class Order {
    /* 对象属性 */
    private int id;            // 订单 id
    private int userId;        // 用户 id，对应表中 user_id 列
    private Date creatTime;    // 创建时间，对应表中 create_time 列

    /* 构造方法 */
    // 无参
    public Order() {
    }
    // 全参
    public Order(int id, int userId, Date creatTime) {
        this.id = id;
        this.userId = userId;
        this.creatTime = creatTime;
    }

    /* 对象方法 */
    // getter 和 setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
