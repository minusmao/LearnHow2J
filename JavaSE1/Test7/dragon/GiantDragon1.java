/**
 * 文件名：GiantDragon.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 类和对象 -> 饿汉式单例模式
 * 时间：2021-4-4
 */

// 饿汉式单例模式：启动时便分配好一个对象
public class GiantDragon1 {
    /* 对象属性 */
    public String name = "饿汉";

    /* 类属性 */
    // 2、声明一个私有的类属性，指向一个分配好的对象
    private static GiantDragon1 giantDragon1 = new GiantDragon1();

    /* 类方法 */
    // 3、声明一个共有的类方法，返回前面分配好对象的私有属性
    public static GiantDragon1 getGiantDragon1() {
        return giantDragon1;
    }

    /* 对象方法 */
    // 1、私有化构造方法
    private GiantDragon1() {
        //
    }
}