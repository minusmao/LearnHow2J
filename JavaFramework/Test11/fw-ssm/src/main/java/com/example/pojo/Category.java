package com.example.pojo;

import java.util.List;

/* ORM: 对应 category 表 */
public class Category {
    /* 对象属性 */
    private int id;                       // 对应表中 id 字段
    private String name;                  // 对应表中 name 字段
    private List<Product> productList;    // 存储该分类的 Product

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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    // 重写 toString 方法

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
