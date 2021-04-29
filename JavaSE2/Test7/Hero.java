/**
 * 文件名：Hero.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> JDBC -> ORM 和 DAO
 * 时间：2021-4-28
 */

// ORM：Object Relationship Database Mapping
public class Hero {
    /* 对象属性 */
    private int id;
    private String name;
    private float hp;
    private int damage;

    /* 构造方法 */
    public Hero() {
        super();
    }
    public Hero(String name, float hp, int damage) {
        super();
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    /* 对象方法 */
    // getter 和 setter
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getHp() {
        return this.hp;
    }
    public void setHp(float hp) {
        this.hp = hp;
    }
    public int getDamage() {
        return this.damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
}