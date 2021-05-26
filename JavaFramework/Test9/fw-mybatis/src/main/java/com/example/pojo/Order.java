package com.example.pojo;

import java.util.Date;
import java.util.List;

/* ORM: 映射 order_ 订单表 */
public class Order {
    /* 对象属性 */
    private int id;
    private int userId;
    private Date createTime;
    private List<OrderItem> orderItemList;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    // 重写 toString 方法
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", createTime=" + createTime +
                '}';
    }
}
