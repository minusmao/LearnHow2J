package com.example.dao;

/**
 * 类名：OrderItem
 * 描述：ORM（对应数据库中的 order_item 表）
 */
public class OrderItem {
    /* 对象属性 */
    private int id;           // 订单项 id
    private int productId;    // 商品 id
    private int orderId;      // 订单 id
    private int number;       // 数量

    /* 构造方法 */
    // 无参
    public OrderItem() {
    }
    // 全参
    public OrderItem(int id, int productId, int orderId, int number) {
        this.id = id;
        this.productId = productId;
        this.orderId = orderId;
        this.number = number;
    }

    /* 对象方法 */
    // getter 和 setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
