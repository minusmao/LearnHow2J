/**
 * 文件名：GiantDragonTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 类和对象 -> 枚举类型
 * 时间：2021-4-6
 */

// 枚举类型，定义四个季节
public enum Season {
    SPRING, SUMMER, AUTUMN, WINTER;
}

/* ========== 枚举类型 ===========
菜鸟教程更详细：https://www.runoob.com/java/java-enum.html

枚举可以理解成如下形式：
class Season
{
    public static final Season SPRING = new Season();
    public static final Season SUMMER = new Season();
    public static final Season AUTUMN = new Season();
    public static final Season WINTER = new Season();

    // enum 定义的枚举类默认继承了 java.lang.Enum 类，并实现了 java.lang.Seriablizable 和 java.lang.Comparable 两个接口。
    // 两个类方法
    public static Season[] values() {
        以数组的形式返回枚举类中所有的值.
    }
    public static Season valueOf(String str) {
        返回指定字符串值 str 的枚举常量。
    }
    // 一个对象方法
    public int ordinal() {
        返回枚举常量的索引，就像数组索引一样
    }
}
=============================== */