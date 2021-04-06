/**
 * 文件名：GiantDragonTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 类和对象 -> 单例模式
 * 时间：2021-4-4
 */

public class GiantDragonTest {
    /* 程序入口 */
    public static void main(String[] args) {
        GiantDragon1 giantDragon1 = GiantDragon1.getGiantDragon1();    // 获得对象
        System.out.println(giantDragon1.name);
        //new GiantDragon1();    // 编译报错
        GiantDragon2 giantDragon2 = GiantDragon2.getGiantDragon2();    // 获得对象
        System.out.println(giantDragon2.name);
    }
}