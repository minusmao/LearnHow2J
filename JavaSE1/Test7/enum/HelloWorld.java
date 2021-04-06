/**
 * 文件名：GiantDragonTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 类和对象 -> 枚举类型
 * 时间：2021-4-6
 */

public class HelloWorld {
    /* 程序入口 */
    public static void main(String[] args) {
        Season season = Season.SPRING;
        switch(season) {
            case SPRING:
                System.out.println("春天");
                break;
        }

        // 遍历枚举，其中 Season.values() 返回的时一个数组
        for(Season s : Season.values()) {
            System.out.println(s);
        }

        Season[] seasons = Season.values();
        int index = season.ordinal();
        Season s = Season.valueOf("SPRING");
    }
}