package com.example.dao;

/* JavaBean */
public class User {
    /* 对象属性 */
    private int id;
    private String name;
    private String password;
    private Sex sex;
    private String country;
    private String signature;

    /* 构造方法 */
    // 无参
    public User() {}

    // 有参
    public User(int id, String name, String password, Sex sex, String country, String signature) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.country = country;
        this.signature = signature;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
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
        this.country = country;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "[" + this.id + ", "+ this.name + ", "+ this.password + ", "+ this.sex.getName() + ", "+ this.country + ","+ this.signature + "]";
    }
}
