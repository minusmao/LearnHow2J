/**
 * 文件名：Hero.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 类和对象
 * 时间：2021-4-4
 */

package character;

/**
 * 类名：Hero
 * 功能：所有英雄对象的父类对象
 */
public class Hero {
    /* 类属性（静态属性），也可通过对象访问，但不推荐 */
    public static String express = "所有英雄的父类";

    /* 类方法（静态方法），也可通过对象访问，但不推荐 */
    public static void battleWin() {
        System.out.println("battle win");
    }

    /* 对象属性（非静态属性） */
    public String name;      //姓名
    public float hp;         //血量
    public float armor;      //护甲
    public int moveSpeed;    //移动速度

    /* 对象方法（非静态方法） */
    // 构造方法：与类名相同，没有返回值（不写时，默认提供一个无参的空的构造方法；若显示写一个，无论有参无参，不再提供这个无参构造方法）
    public Hero() {
        System.out.println("调用 Hero 类的无参构造方法");
    }
    public Hero(String name, float hp) { 
        this.name = name;
        this.hp = hp;
        System.out.println("调用 Hero 类的两个参数的构造方法");
    }
    public Hero(String name, float hp, float armor) {
        this(name, hp);    // 通过 this 调用另一个构造方法
        this.armor = armor;
        System.out.println("调用 Hero 类的两个参数的构造方法");
    }
}