/**
 * 文件名：Hero.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> Lambda
 * 时间：2021-4-17
 */

import java.lang.Comparable;

public class Hero {
    /* 对象属性 */
    private String name;
    private int hp;

    /* 构造方法 */
    public Hero(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    /* 对象方法 */
    // getter 和 setter 方法
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
}