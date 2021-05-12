package com.example.dao;

/**
 * 类名：User
 * 描述：映射 how2java 数据库中的 user 表的 ORM 对象
 */
public class User {
    private int id;              // ID
    private String name;         // 名称，最大长度为 30
    private String password;     // 密码，最大长度30
    private Sex sex;             // 性别，枚举类型，包括 "man"、"woman"
    private String country;      // 国籍：最大长度 30
    private String signature;    // 签名，最大长度 255

    /* 构造方法 */
    // 无参
    public User() {}
    // 全参
    public User(int id, String name, String password, Sex sex, String country, String signature) {
        setId(id);
        setName(name);
        setPassword(password);
        setSex(sex);
        setCountry(country);
        setSignature(signature);
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
        if (name != null && name.length() > 30) {
            name = name.substring(0, 30);    // 截取前 30，超过 30 不保存
        }
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && password.length() > 30) {
            password = password.substring(0, 30);    // 截取前 30，超过 30 不保存
        }
        this.password = password;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country != null && country.length() > 30) {
            country = country.substring(0, 30);    // 截取前 30，超过 30 不保存
        }
        this.country = country;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        if (signature != null && signature.length() > 30) {
            signature = signature.substring(0, 255);    // 截取前 255，超过 255 不保存
        }
        this.signature = signature;
    }
}
