package com.example.pojo;

import org.springframework.stereotype.Component;

@Component("category")
public class Category {
    /* 对象属性 */
    private int id = 1;
    private String name = "category1";

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
}
