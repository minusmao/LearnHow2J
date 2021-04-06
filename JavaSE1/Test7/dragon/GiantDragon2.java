/**
 * 文件名：GiantDragon.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 类和对象 -> 懒汉式单例模式
 * 时间：2021-4-4
 */

// 懒汉式单例模式：调用时才分配对象
public class GiantDragon2 {
    /* 对象属性 */
    public String name = "懒汉";

    /* 类属性 */
    // 2、声明一个私有的类属性，且不分配对象
    private static GiantDragon2 giantDragon2;

    /* 类方法 */
    // 3、声明一个共有的类方法，返回第 2 步声明的私有属性
    public static GiantDragon2 getGiantDragon2() {
        // 先判断 giantDragon2 是否为空
        if(null == giantDragon2) {
            giantDragon2 = new GiantDragon2();    // 分配一个对象
        }
        return giantDragon2;    // 返回该对象
    }

    /* 对象方法 */
    // 1、私有化构造方法
    private GiantDragon2() {
        //
    }
}