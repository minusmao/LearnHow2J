package com.example.dao;

/**
 * 枚举类名：Sex
 * 描述：User 中的性别属性
 */
public enum Sex {
    /* 枚举 */
    MAN(1, "man"),WOMAN(1, "woman");

    private final String name;

    /* 重写构造方法 */
    private Sex(int index, String name) {
        /* 对象属性 */
        this.name = name;
    }

    /* 对象方法 */
    // 返回字符串形式
    public String getName() {
        return this.name;
    }

    /* 类方法 */
    // 根据字符串返回枚举
    public static Sex getSex(String name) {
        return "man".equals(name)? MAN : WOMAN;
    }
}
