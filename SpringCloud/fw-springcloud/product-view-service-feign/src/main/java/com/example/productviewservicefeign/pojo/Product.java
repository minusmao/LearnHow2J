package com.example.productviewservicefeign.pojo;

/**
 * @ClassName: Product
 * @Description: 产品实体类
 * @Author: TechRice
 * @Date: 2021/8/24 20:51
 */
public class Product {
    /* 对象属性 */
    private int id;        // 产品 ID
    private String name;   // 产品名称
    private int price;     // 产品价格

    /* 构造方法 */
    public Product() {
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /* getter 和 setter */
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
