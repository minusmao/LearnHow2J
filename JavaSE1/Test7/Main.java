/**
 * 文件名：Main.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 类和对象
 * 时间：2021-4-4
 */

public class Main {
    /* 程序入口 */
    public static void main(String[] args) {
        Weapon weapon = new Weapon();
        weapon.name = "无尽之刃";
        weapon.price = 2000;
        weapon.damage = 200;

        Armor armor1 = new Armor();
        armor1.name = "布甲";
        armor1.price = 300;
        armor1.defend = 15;

        Armor armor2 = new Armor();
        armor2.name = "锁子甲";
        armor2.price = 500;
        armor2.defend = 40;

        // 多态
        Item item;
        item = weapon;
        System.out.println(item.name + item.price);
        item = armor1;
        System.out.println(item.name + item.price);
        item = armor2;
        System.out.println(item.name + item.price);

        // 测试对象初始化
        Item item666 = new Item();
        System.out.println(item666.name);

        System.out.println(Item.express);
    }
}