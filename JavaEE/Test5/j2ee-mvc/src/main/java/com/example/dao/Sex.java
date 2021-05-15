package com.example.dao;

public enum Sex {
    /* 枚举 */
    MAN(1, "man"), WOMAN(2, "woman");

    /* 对象属性 */
    private final String name;

    /* 重写构造方法 */
    private Sex(int id, String name) {
        this.name = name;
    }

    /* 对象方法 */
    // 获得字符串表达
    public String getName() {
        return this.name;
    }

    /* 类方法 */
    // 根据字符串获得枚举
    public static Sex getSex(String name) {
        return "man".equals(name)? MAN : WOMAN;
    }
}
