/**
 * 文件名：Hero.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 反射机制
 * 时间：2021-5-4
 */

public class Hero {
    /* 对象属性 */
    private String name;
    private int hp;
    private int damage;
    public int other;

    /* 类初始化块 */
    static {
        System.out.println("Hero类被初始化");
    }

    /* 构造函数 */
    // 无参
    public Hero() {
        this.name = "none";
    }
    // 有参
    public Hero(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    /* 对象方法 */
    // getter 和 setter
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHp() {
        return this.hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getDamage() {
        return this.damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    // 重写 toString 方法
    public String toString() {
        return "[" + this.name + ", " + this.hp + ", " + this.damage + "]";
    }
}