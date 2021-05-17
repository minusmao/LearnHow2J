package com.example.dao;

/**
 * 类名：Product
 * 描述：ORM（对应数据库中的 product 表）
 */
public class Product {
    /* 对象属性 */
    private int id;         // 产品 id
    private String name;    // 产品名称
    private float price;    // 产品价格

    /* 构造方法 */
    // 无参
    public Product() {
    }
    // 全参
    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /* 对象方法 */
    // getter 和 setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
