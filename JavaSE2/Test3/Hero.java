/**
 * 文件名：Hero.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 集合框架
 * 时间：2021-4-11
 */

public class Hero {
    /* 对象属性 */
    public String name;
    public float hp;
    public int damage;

    /* 构造方法 */
    public Hero() {
        super();
    }
    // 增加一个初始化 name 的构造方法
    public Hero(String name) {
        this.name = name;
    }
    // 增加一个初始化 name 和 hp 的构造方法
    public Hero(String name, float hp) {
        this(name);
        this.hp = hp;
    }
    // 增加一个初始化 name、hp 和 damage 的构造方法
    public Hero(String name, float hp, int damage) {
        this(name, hp);
        this.damage = damage;
    }

    /* 对象方法 */
    // 重写toString方法
    public String toString() {
        return name + " " + hp + " " + damage;
    }
    public String getName() {
        return this.name;
    }
}